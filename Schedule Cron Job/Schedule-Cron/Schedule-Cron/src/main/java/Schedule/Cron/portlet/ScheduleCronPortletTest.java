package Schedule.Cron.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import jwc.insta.model.HandleAPIKeys;
import jwc.insta.service.HandleAPIKeysLocalServiceUtil;

/**
 * @author sbarui002
 */
@Component(
	immediate = true,
	property = {
			"cron.expression=0 0/3 * 1/1 * ? *" //scheduler executed every 3 mins
			},
	service = ScheduleCronPortletTest.class
)
public class ScheduleCronPortletTest extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/*
	 * 
	 * private static final Logger _logger =
	 * LogManager.getLogger(ScheduleCronPortletTest.class);
	 * 
	 * @Override protected void doReceive(Message message) throws Exception {
	 * _logger.info("....Scheduled task executed..."); // String token = //
	 * "IGQVJXZAW5iRENWTkk5N2R4ZA1Q1U1BXUk01djhZARmw4UXBtSnRIaFI4ZA2tnZAUxLLTdsa0NvZA2kzVkNHbmh6cFU3OGExMnpNV1NXZAWNFNmxuNVpocTZAwczRDTWV5WUItcU55N1NYZAkVFRG1oZAEJLLUNNMwZDZD";
	 * String token = ""; String fields =
	 * "id,media_type,media_url,thumbnail_url,timestamp,permalink,caption"; //
	 * String uri = "https://graph.instagram.com/me/media?fields="+ fields //
	 * +"&access_token="+ token +"&count=-1";
	 * 
	 * List<HandleAPIKeys> handleAPIKeys = new ArrayList<HandleAPIKeys>();
	 * handleAPIKeys = HandleAPIKeysLocalServiceUtil.getHandleAPIKeyses(-1, -1); if
	 * (handleAPIKeys.size() != 0) { for (HandleAPIKeys apiKeys : handleAPIKeys) {
	 * token = apiKeys.getApiKey(); String uri =
	 * "https://graph.instagram.com/me/media?fields=" + fields + "&access_token=" +
	 * token + "&count=-1"; _logger.info("uri.. : " + uri); URL url = new URL(uri);
	 * HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 * connection.setRequestMethod("GET"); _logger.info("connection : " +
	 * connection); int responseCode = connection.getResponseCode();
	 * _logger.info("responseCode : " + responseCode); if (responseCode == 200) {
	 * _logger.info("For " + apiKeys.getPageKey() + " Token Valid"); } else {
	 * _logger.info("For " + apiKeys.getPageKey() + " Token InValid");
	 * 
	 * String subject = "For " + apiKeys.getPageKey() +
	 * " : Token Has been Expired."; String body =
	 * "<b>Hi Team</b><br><br><span><b>For " + apiKeys.getPageKey() +
	 * " : Instagram Token Has been Expired.</b></span>"; InternetAddress
	 * fromAddress = new InternetAddress("samaresh.b.mail@gmail.com");
	 * InternetAddress toAddress = new InternetAddress("baruisamaresh@gmail.com");
	 * InternetAddress ccAddress = new InternetAddress("mitesh.zaveri@ril.com");
	 * MailMessage mailMessage = new MailMessage();
	 * mailMessage.setFrom(fromAddress); mailMessage.setTo(toAddress);
	 * mailMessage.setCC(ccAddress); mailMessage.setSubject(subject);
	 * mailMessage.setBody(body); mailMessage.setHTMLFormat(true);
	 * 
	 * MailServiceUtil.sendEmail(mailMessage);
	 * _logger.info("....Send Mail Succeessfully.........."); } } }
	 * 
	 * }
	 * 
	 * @Activate
	 * 
	 * @Modified protected void activate(Map<String, Object> properties) throws
	 * SchedulerException {
	 * 
	 * try { _logger.info("__Scheduler activated__"); String cronExpression =
	 * GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
	 * _logger.info(" cronExpression: " + cronExpression);
	 * 
	 * String listenerClass = getClass().getName(); Trigger jobTrigger =
	 * TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(),
	 * null, cronExpression);
	 * 
	 * SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass,
	 * jobTrigger);
	 * 
	 * SchedulerEngineHelperUtil.register(this, schedulerEntryImpl,
	 * DestinationNames.SCHEDULER_DISPATCH);
	 * 
	 * } catch (Exception e) { _logger.error("--- Issue in Scheduler ----");
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * @Deactivate protected void deactive() {
	 * _logger.info("__ Scheduler deactivated__");
	 * SchedulerEngineHelperUtil.unregister(this); }
	 * 
	 */}