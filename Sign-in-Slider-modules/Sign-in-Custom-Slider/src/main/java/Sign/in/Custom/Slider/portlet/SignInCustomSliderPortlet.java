package Sign.in.Custom.Slider.portlet;

import com.jwc.signin.model.SignIn;
import com.jwc.signin.service.SignInLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Sign.in.Custom.Slider.constants.SignInCustomSliderPortletKeys;

/**
 * @author sbarui002
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SignInCustomSlider",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SignInCustomSliderPortletKeys.SIGNINCUSTOMSLIDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SignInCustomSliderPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(SignInCustomSliderPortlet.class);
	private static String ROOT_FOLDER_NAME = "Slider_Image_Upload";
	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";
	private static long PARENT_FOLDER_ID = 0;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		super.render(renderRequest, renderResponse);
	}
	
	public void addSlider(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		_log.info("::::Start of the method--{addSlider}::::");
		Random rand = new Random();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		Date date2 = new Date();
		Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds()) * 1000);
		int rand_int = rand.nextInt(1000);
		long repositoryId = themeDisplay.getScopeGroupId();
		
		String apiFullUrl = SignInCustomSliderPortletKeys.REDIS_API_BRAND_SLIDER_PATH;
		System.out.println("apiUrl : "+apiFullUrl);
		String url = apiFullUrl;
		
		String brandId = ParamUtil.getString(request, "brand");
		_log.info("brandId : "+brandId);
		String mediaCount = ParamUtil.getString(request, "mediaCount");
		String mediaUrl = "";
		_log.info("mediaCount : "+mediaCount);
		if(!mediaCount.equalsIgnoreCase("")) {
			for(int j = 1;j<=Integer.parseInt(mediaCount);j++) {
				String mediaFileName = uploadPortletRequest.getFileName("media-"+j);
				_log.info("mediaFileName : "+mediaFileName);
				String mediaType = ParamUtil.getString(request, "mediaType-"+j);
				String signInImageId = ParamUtil.getString(request, "mediaTemplateId-"+j);
				_log.info("signInImageId : "+signInImageId);
				if(!mediaFileName.equalsIgnoreCase("")) {
					_log.info("mediaFileName ::>>> "+mediaFileName);
					String[] arr = mediaFileName.split("\\.");
					String extension = arr[1];
					String title = arr[0];
					_log.info("time2 : "+time2);
					String newFileName = "media"+time2+("-"+j)+"."+extension;
					_log.info("newVFileName : "+newFileName);
					File mediaFile = uploadPortletRequest.getFile("media-"+j);
					String mediaMimeType = uploadPortletRequest.getContentType("media-"+j);
					FileEntry mediaFileEntry = null;
					long mediaFileSize = uploadPortletRequest.getSize("media-"+j);
					_log.info("fileSize  >>>> "+mediaFileSize);
					
					try {
						//Folder folder = getFolder(themeDisplay);
						Folder folder = createFolder(request, themeDisplay);
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
						InputStream is = new FileInputStream(mediaFile);
						mediaFileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), mediaFileName, mediaMimeType, newFileName, ROOT_FOLDER_DESCRIPTION,
								"", is, mediaFileSize, serviceContext);

					} catch (Exception e) {
						_log.error(e.getMessage());
						response.setRenderParameter("jspPage", "/createSlider.jsp");
					}
					_log.info("fileEntry >>>>>>>>>>>> "+mediaFileEntry.getFileEntryId());
					mediaUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
							+ themeDisplay.getScopeGroupId() + "/" + mediaFileEntry.getFolderId() + "/"
							+ mediaFileEntry.getFileName() + "/" + mediaFileEntry.getUuid() + "?t=" + time2;
					_log.info("url : "+mediaUrl);
				}else {
					mediaUrl = ParamUtil.getString(request, "sameMediaUrl-"+j);
					_log.info("mediaUrlUrlPath : "+mediaUrl);
				}
				
				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				if(signInImageId.equalsIgnoreCase("")) {
					_log.info("inside image addition...");
					SignInLocalServiceUtil.addBrandSliderImages(Long.valueOf(brandId), mediaUrl, themeDisplay.getScopeGroupId(), themeDisplay.getSiteGroupId(), user.getUserId(), user.getFullName());
				}else {
					_log.info("inside image updation...");
					SignInLocalServiceUtil.updateBrandSliderImages(Long.valueOf(signInImageId), Long.valueOf(brandId), mediaUrl, user.getUserId(), user.getFullName());
				}
				
			}
		}
		
		redisAPICaller(url);
	}
	
	public void deleteMedia(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		_log.info("::::Start of the method--{deleteMedia}::::");
		String mediaTemplateId = ParamUtil.getString(request, "mediaId");
		_log.info("mediaId : "+mediaTemplateId);
		SignIn signInSliderMedia = null;
		if(!mediaTemplateId.equalsIgnoreCase("")) {
			signInSliderMedia = SignInLocalServiceUtil.getSignIn(Long.valueOf(mediaTemplateId));
			SignInLocalServiceUtil.deleteSignIn(signInSliderMedia);
		}
		
		String apiFullUrl = SignInCustomSliderPortletKeys.REDIS_API_BRAND_SLIDER_PATH;
		System.out.println("apiUrl : "+apiFullUrl);
		String url = apiFullUrl;
		redisAPICaller(url);
	}
	
	
	public void deleteSlider(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		_log.info("::::Start of the method--{deleteSlider}::::");
		String brandId = ParamUtil.getString(request, "brandId");
		_log.info("brandId : " + brandId);
		List<SignIn> signInSliderList = new ArrayList<SignIn>();
		if (!brandId.equalsIgnoreCase("")) {
			signInSliderList = SignInLocalServiceUtil.fetchAllImagesByBrandId(Long.valueOf(brandId));
			if(signInSliderList.size()>0) {
				for(SignIn ob : signInSliderList) {
					SignInLocalServiceUtil.deleteSignIn(ob);
				}
			}
		}
	}
	
	
	public void redisAPICaller(String rurl) {
		HttpURLConnection con;
		try {
			URL url = new URL(rurl);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			_log.info("Redis API responseCode : " + responseCode);
			BufferedReader br = null;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String strCurrentLine;
				StringBuilder sb = new StringBuilder();
				while ((strCurrentLine = br.readLine()) != null) {
					sb.append(strCurrentLine + "\n");
				}

				_log.info("Success Response from API : " + sb.toString());
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String strCurrentLine;
				StringBuilder sb = new StringBuilder();
				while ((strCurrentLine = br.readLine()) != null) {
					sb.append(strCurrentLine + "\n");
				}

				_log.info("Error Response from API : " + sb.toString());

			}
			br.close();

		} catch (IOException e) {
			_log.error("Error Occured with executing redis api");
			_log.info("url : "+rurl);
		}
	}
	 
	
	public Folder getFolder(ThemeDisplay themeDisplay){
		_log.info("::::Start of the method--{getFolder}::::");
		Folder folder = null;
		try {
			folder = (Folder) DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			_log.error(e.getMessage());
		}
		return folder;
	}
	
	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		System.out.println("inside method create");
		boolean folderExist = isFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, ROOT_FOLDER_NAME,
						ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		}else {
			folder = getFolder(themeDisplay);
		}
		return folder;
	}
	
	public boolean isFolderExist(ThemeDisplay themeDisplay) {
		System.out.println("inside method isFolderExist");
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
}