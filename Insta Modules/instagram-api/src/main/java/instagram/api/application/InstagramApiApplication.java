package instagram.api.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import instagram.api.dto.InstaUrls;
import instagram.api.dto.InstagramApiMainDto;
import jwc.insta.model.InstaOtherDetails;
import jwc.insta.model.InstaSiteImages;
import jwc.insta.service.InstaOtherDetailsLocalServiceUtil;
import jwc.insta.service.InstaSiteImagesLocalServiceUtil;


/**
 * @author sbarui002
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/instaposts",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Instaposts.Rest"
	},
	service = Application.class
)
public class InstagramApiApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}
	
	@GET
	@Path("/getLatestPosts/by-pagekey/{pageKey}")
	@Produces("application/json")
	public InstagramApiMainDto getInstaImages(@PathParam("pageKey") String pageKey,
			@QueryParam("param") String param) throws SQLException, PortalException {
		
		_log.info("pageKey : " + pageKey);
		InstagramApiMainDto instagramApiMainDto = null;
		List<InstaUrls> urllist = new ArrayList<InstaUrls>();
		InstaOtherDetails details = null;
		
		List<InstaSiteImages> instaImagesList = InstaSiteImagesLocalServiceUtil.getPostsByPageKey(pageKey);
		_log.info("instaImagesList : " + instaImagesList.size());
		if (instaImagesList != null && !instaImagesList.isEmpty() && instaImagesList.size() > 0) {
			for (InstaSiteImages instaSiteImage : instaImagesList) {
				instagramApiMainDto = new InstagramApiMainDto();
				_log.info("Inside for loop");
				InstaUrls instaUrls = new InstaUrls();
				long otherDetailId = instaSiteImage.getOtherDetid();
				details = InstaOtherDetailsLocalServiceUtil.getInstaOtherDetails(otherDetailId);
				
				instaUrls.setInstagramLink(instaSiteImage.getInstaimageUrl());
				instaUrls.setMediaLink(instaSiteImage.getMediaUrl());
				instaUrls.setTimestamp(instaSiteImage.getTimestamp());
				urllist.add(instaUrls);
			}
			instagramApiMainDto.setInstaUrls(urllist);
			instagramApiMainDto.setHandleName(details.getInstaHandleName());
			instagramApiMainDto.setFollowUsLink(details.getFollowUsLink());
		}else {
			_log.info("inside else....");
			instagramApiMainDto = new InstagramApiMainDto();
		}
		return instagramApiMainDto;
		
	}

	private static final Log _log = LogFactoryUtil.getLog(InstagramApiApplication.class);
}