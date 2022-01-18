package insta.portlet.portlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import insta.portlet.constants.InstaPortletKeys;
import jwc.insta.model.HandleAPIKeys;
import jwc.insta.model.InstaOtherDetails;
import jwc.insta.model.InstaSiteImages;
import jwc.insta.service.HandleAPIKeysLocalServiceUtil;
import jwc.insta.service.InstaOtherDetailsLocalServiceUtil;
import jwc.insta.service.InstaSiteImagesLocalServiceUtil;

/**
 * @author Lenovo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Insta",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + InstaPortletKeys.INSTA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InstaPortlet extends MVCPortlet {
	
	private static String ROOT_FOLDER_NAME = "Insta Images";
	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";
	private static long PARENT_FOLDER_ID = 0;
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		_log.info("Enter Render Method");
		String selectPageKey = ParamUtil.getString(renderRequest, "selectPageKey");
		_log.info("selectPageKey..in render : "+renderRequest.getAttribute("selectPageKey"));
		super.render(renderRequest, renderResponse);
		
	}

	public void getPageKey(ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info(".......inside get Page Key method.......");
		String selectPageKey = ParamUtil.getString(actionRequest, "selectPageKey");
		String selectedVal = ParamUtil.getString(actionRequest, "abc");
		_log.info("Select page Key Value::... "+selectedVal);
		_log.info("inside select Page Key");
		_log.info("selectPageKey in selectPageKey : "+selectPageKey);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		actionRequest.setAttribute("selectVal", selectedVal);
		
		//actionResponse.setRenderParameter(key, value);
		/*
		 * actionResponse.setRenderParameter("jspPage", "/view.jsp");
		 * actionResponse.setProperty("newPageKey", selectPageKey);
		 * actionResponse.setRenderParameter("newPageKey", selectPageKey);
		 * actionRequest.setAttribute("selectPageKey", selectPageKey);
		 */
	}

	public void addInstaImageOnSite(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, IOException {

		String mediaUrl = ParamUtil.getString(request, "allCheckedMediaIds");

		// _log.info("Media URl :" + mediaUrl);
		String instaUrl = ParamUtil.getString(request, "allCheckedInstaIds");

		// _log.info("Check Insta URl :" + instaUrl);

		String timestamp = ParamUtil.getString(request, "allCheckedTimeStamp");

		String hideInstagramWidget = ParamUtil.getString(request, "hideInstagramWidget");

		// TODO When other pages comes in , create a dropdownlist in the jsp page and
		
		String hiddenKeyValOfPage = ParamUtil.getString(request, "hiddenKeyOfPage");
		_log.info("hiddenKeyValOfPage:: "+hiddenKeyValOfPage);
		request.setAttribute("selectVal", hiddenKeyValOfPage);
		
		String instaOtherDetId = ParamUtil.getString(request, "instaOtherDetId");
		String handleName = ParamUtil.getString(request, "handleName");
		String followUsLink = ParamUtil.getString(request, "followUsLink");
		InstaOtherDetails instaOtherDetails = null;
		_log.info("handleName:: "+handleName);
		_log.info("followUsLink:: "+followUsLink);
		
		
		
		// linked that dropdown list to featureOn Master table and get the value from
		// that dropdownlist
		String pageKey = hiddenKeyValOfPage;

		String redisAPIBaseUrl = PropsUtil.get("web.jwc.site.redis.api.base.url");

		String apiFullUrl = redisAPIBaseUrl + InstaPortletKeys.REDIS_API_INSTA_PATH + pageKey;
		System.out.println("apiUrl : "+apiFullUrl);
		String url = apiFullUrl;

		// Save the Hide Instagram Widget on Site Flag here
		HandleAPIKeys handleAPIKeys = HandleAPIKeysLocalServiceUtil.getHandleAPIRowByPageKey(pageKey);
		if (handleAPIKeys != null) {
			handleAPIKeys.setInstagramWidgetFlag(Boolean.valueOf(hideInstagramWidget));
			HandleAPIKeysLocalServiceUtil.updateHandleAPIKeys(handleAPIKeys);
		}
		
		if(instaOtherDetId.equalsIgnoreCase("")) {
			instaOtherDetails = InsertIntaOtherDetails(handleName,followUsLink);
		}else {
			instaOtherDetails = UpdateIntaOtherDetails(instaOtherDetId,handleName,followUsLink);
		}
		
		if (hideInstagramWidget != null && !hideInstagramWidget.isEmpty() && hideInstagramWidget == "false") {

			deleteAllCheckedPermLinkIds(pageKey);

			if (!mediaUrl.isEmpty() && !instaUrl.isEmpty() && !timestamp.isEmpty()) {

				String[] mediaUrlArray = mediaUrl.split(",");
				String[] instaUrlArray = instaUrl.split(",");
				String[] timestampArray = timestamp.split(",");

				InstaSiteImages instaSiteImages = null;

				for (int index = 0; index < mediaUrlArray.length; index++) {
					
					String dmsUrl = uploadDMSAndGetUrl(request,index,mediaUrlArray[index]);
					//String dmsUrl = uploadDMSAndGetUrl(request,index,instaUrlArray[index]+"media/?size=l");
					System.out.println("dms url : "+index+"..."+dmsUrl);
					long instaSiteImageId = CounterLocalServiceUtil.increment();
					instaSiteImages = InstaSiteImagesLocalServiceUtil.createInstaSiteImages(instaSiteImageId);
					instaSiteImages.setPageKey(pageKey);
					instaSiteImages.setMediaUrl(dmsUrl);
					instaSiteImages.setInstaimageUrl(instaUrlArray[index]);
					instaSiteImages.setTimestamp(timestampArray[index]);
					instaSiteImages.setOtherDetid(instaOtherDetails.getOtherDetid());
					instaSiteImages = InstaSiteImagesLocalServiceUtil.addInstaSiteImages(instaSiteImages);

				}

			}

			_log.info("Redis API Url :" + url);
			redisAPICaller(url);
		} 
	}


	private InstaOtherDetails InsertIntaOtherDetails(String handleName,String followUsLink) {
		// TODO Auto-generated method stub
		long instaOtherDetId = CounterLocalServiceUtil.increment();
		InstaOtherDetails instaOtherDetails = InstaOtherDetailsLocalServiceUtil.createInstaOtherDetails(instaOtherDetId);
		instaOtherDetails.setFollowUsLink(followUsLink);
		instaOtherDetails.setInstaHandleName(handleName);
		InstaOtherDetails otherDetails = InstaOtherDetailsLocalServiceUtil.addInstaOtherDetails(instaOtherDetails);
		return otherDetails;
	}
	
	private InstaOtherDetails UpdateIntaOtherDetails(String instaOtherDetId,String handleName,String followUsLink) throws NumberFormatException, PortalException {
		// TODO Auto-generated method stub
		InstaOtherDetails instaOtherDetails = InstaOtherDetailsLocalServiceUtil.getInstaOtherDetails(Long.valueOf(instaOtherDetId));
		instaOtherDetails.setFollowUsLink(followUsLink);
		instaOtherDetails.setInstaHandleName(handleName);
		InstaOtherDetails otherDetails = InstaOtherDetailsLocalServiceUtil.updateInstaOtherDetails(instaOtherDetails);
		return otherDetails;
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

		}
	}
   
	public String uploadDMSAndGetUrl(ActionRequest request,int index, String instaImgUrl) throws IOException, PortalException {

		System.out.println("instaImgUrl : "+instaImgUrl);
		URL url = new URL(instaImgUrl);
		System.out.println("url : "+url);
		//String fileName = url.getFile();
		//System.out.println("fileName :" + fileName);
		//String destName = fileName.substring(fileName.lastIndexOf("/")).replace("/", "");
		//System.out.println("destName :" + destName);
		Date date = new Date();
		Long time = (long) (((((date.getHours() * 60) + date.getMinutes()) * 60) + date.getSeconds()) * 1000);
		String fileName = "insta_"+time+index+".jpg";
		InputStream in = new BufferedInputStream(url.openStream());
		System.out.println("in : "+in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.out.println("out : "+out);
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();
		System.out.println("response: " + response);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long repositoryId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		
		FileEntry fileEntry = null;
		Folder folder = createFolder(request, themeDisplay);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folder.getFolderId(), "", "image/jpeg", fileName, "", "",
					response, serviceContext);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		//String downloadUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "", false, true);
		String downloadUrl = "/documents/" + themeDisplay.getScopeGroupId() + "/" + fileEntry.getFolderId() + "/"
				+ fileEntry.getFileName() + "/" + fileEntry.getUuid();
		System.out.println("downloadUrl : "+downloadUrl);
		return downloadUrl;
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
	
	public Folder getFolder(ThemeDisplay themeDisplay) {
		System.out.println("inside method getFolder");
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}
	


	public void deleteAllCheckedPermLinkIds(String pageKey) {
		/*List<InstaSiteImages> instaImagesList = InstaSiteImagesLocalServiceUtil.getInstaSiteImageses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS); */
		_log.info("inside deleteAllCheckedPermLinkIds :::");
		List<InstaSiteImages> instaImagesList = InstaSiteImagesLocalServiceUtil.getPostsByPageKey(pageKey);
		if (instaImagesList != null) {
			for (InstaSiteImages instaSiteImage : instaImagesList) {
				InstaSiteImagesLocalServiceUtil.deleteInstaSiteImages(instaSiteImage);
			}
		}
	}

     private static final Log _log = LogFactoryUtil.getLog(InstaPortlet.class);
  
}