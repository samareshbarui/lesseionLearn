package com.liferay.demo.auto.translate;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.demo.auto.translate.api.TranslateService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.xml.Attribute;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReader;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * @author samareshb915
 */
@Component(
	immediate = true,
	property = {
			"destination.name=" + AutoTranslatorConfigurator.DESTINATION
	},
	service = MessageListener.class
)
public class AutoTranslatorJournalMessageListener implements MessageListener {
	
	private long WAITTIME = Long.parseLong(PortalUtil.getPortalProperties().getProperty("translate.waittime", "10000"));
	private double MAXVERSION = Double.parseDouble(PortalUtil.getPortalProperties().getProperty("translate.maxversion", "5.9"));
	private LoadingCache<Long, Long> cache;

	@Override
	public void receive(Message message) throws MessageListenerException {

		ArrayList<String> fields = new ArrayList(Arrays.asList(PortalUtil.getPortalProperties().getProperty("translate.fields").split("\\s*,\\s*")));

		try {
			_log.debug("Let's wait " + WAITTIME + " milliseconds..");
			Thread.sleep(WAITTIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JournalArticle article = null;
		AssetEntry entry = null;
		try {
			long groupid = (long) message.get("groupId");
			Locale defaultLocale = PortalUtil.getSiteDefaultLocale(groupid);
			article = _JournalArticleLocalService.getArticle(groupid, (String) message.get("articleId"));
			entry = _AssetEntryLocalService.getEntry(JournalArticle.class.getName(), article.getResourcePrimKey());
			final Set<Locale> availableLocales = LanguageUtil.getAvailableLocales(groupid);

			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setCompanyId(entry.getCompanyId());
			serviceContext.setScopeGroupId(article.getGroupId());

			if (article != null) {
				_log.debug("Before inside IF");
				_log.debug("article.getVersion() : "+article.getVersion());
				_log.debug("MAXVERSION : "+MAXVERSION);
				if (mustbeTranslated(entry) && article.getVersion() <= MAXVERSION) {
					_log.debug("inside IF");
					Map<Locale, String> titleMap = article.getTitleMap();
					SAXReader reader = SAXReaderUtil.getSAXReader();
					Document document = reader.read(article.getContentByLocale(defaultLocale.getLanguage()));

					_log.debug("Original XML: " + document.asXML());

					for (Locale locale : LanguageUtil.getAvailableLocales(article.getGroupId())) {
						if (!locale.equals(defaultLocale)) {
							// translate title
							String result = _TranslateService.doTranslate(defaultLocale.getLanguage(),
									locale.getLanguage(), article.getTitle());
							if (!result.isEmpty()) {
								_log.debug("translation for " + locale.getLanguage() + ":  " + result);
								if (titleMap.containsKey(locale)) {
									titleMap.replace(locale, result);
								} else {
									titleMap.put(locale, result);
								}
							}

							// translate content
							for (String fieldname : fields) {
								try {
									// TODO verify whether field IS translatable
									_log.debug("Translating field " + fieldname);

									// <dynamic-element name='Responsibilities'
									XPath xPath = SAXReaderUtil.createXPath("//dynamic-element[lower-case(@name)='"
											+ fieldname + "']/dynamic-content[@language-id='" + defaultLocale.toString()
											+ "']");
									_log.info("xPath : "+xPath.getText());
									Element n = (Element) xPath.selectSingleNode(document);
									_log.info("n.... : "+n);
									String text = n.getText();
									_log.info("text : .........."+text);
									org.jsoup.nodes.Document soup = Jsoup.parse(text);

									Elements eles = soup.getAllElements();
									_log.info("text : .........."+text);
									// For each element
									for (org.jsoup.nodes.Element ele : eles) {

										if (!ele.ownText().isEmpty()) {
											String elementText = ele.ownText();
											_log.debug("Let's translate: " + elementText);
											String res = _TranslateService.doTranslate(defaultLocale.getLanguage(),
													locale.getLanguage(), elementText);
											_log.debug("Translate to: " + res);
											ele.text(res);

											// If you encounter service throttling when translating large web
											// pages, you can request a service limit increase. For details,
											// see
											// https://aws.amazon.com/premiumsupport/knowledge-center/manage-service-limits/,
											// or you can throttle your requests by inserting a sleep statement.
											// Thread.sleep(1000);
										}
									}

									Element parent = n.getParent();
									Element tn = n.createCopy();
									Attribute l = tn.attribute("language-id");
									l.setValue(locale.toString());
									tn.clearContent();
									tn.addCDATA(soup.body().html());
									_log.debug("new node text" + tn.getText());
									parent.add(tn);
									_log.debug("new parent" + parent.formattedString());
									_log.debug("Selected text: " + text);
								} catch (IOException | NullPointerException e) {
									_log.error(e.getMessage());
								}
							}
						}
					}

					_JournalArticleLocalService.updateArticle(entry.getUserId(), entry.getGroupId(),
							article.getFolderId(), article.getArticleId(), article.getVersion(), titleMap,
							article.getDescriptionMap(), document.asXML(), article.getLayoutUuid(), serviceContext);
				}
			}
		} catch (PortalException | DocumentException e) {
			_log.error(e.getMessage());
		}

	}
	
	public boolean mustbeTranslated(AssetEntry entry) throws PortalException {
        //only autotag if there's an autotag tag or if it's empty
        String triggerTagName = "autotranslate";
        Boolean mustTranslate = false;
            
        _log.debug("Entry ID: " + entry.getEntryId());

        if (triggerTagName.isEmpty()) {
            _log.debug("No trigger tagname found");
            return mustTranslate;
        } else {
            _log.debug("Checking entry for tag " + triggerTagName);
             AssetTag triggerTag = AssetTagLocalServiceUtil.getTag(entry.getGroupId(), triggerTagName);
             _log.debug("Entry has triggertag: " + entry.getTags().contains(triggerTag));
            mustTranslate = entry.getTags().contains(triggerTag);
            AssetTagLocalServiceUtil.deleteAssetEntryAssetTag(entry.getEntryId(),triggerTag);
            if (mustTranslate && cache.getIfPresent(entry.getEntryId()) == null) {
                cache.getUnchecked(entry.getEntryId());
            }
            else if (mustTranslate && cache.getIfPresent(entry.getEntryId()) != null)
            {
                _log.debug("Hitting entry in cache... not translating");
                mustTranslate = false;
            }
            _log.info("mustTranslate : "+mustTranslate);
            return mustTranslate;

        }
    }
	
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		System.out.println("Activating message listener");
		System.out.println("Init cache");
		CacheLoader<Long, Long> loader;
		loader = new CacheLoader<Long, Long>() {
			@Override
			public Long load(Long key) {
				return key;
			}
		};
		cache = CacheBuilder.newBuilder().expireAfterWrite(WAITTIME * 3, TimeUnit.MILLISECONDS).build(loader);
	}

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    protected JournalArticleLocalService _JournalArticleLocalService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    protected AssetEntryLocalService _AssetEntryLocalService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    protected TranslateService _TranslateService;

    private static final Log _log = LogFactoryUtil.getLog(AutoTranslatorJournalMessageListener.class);
    //private static Logger _log = LoggerFactory.getLogger(AutoTranslatorJournalMessageListener.class.getName());

}