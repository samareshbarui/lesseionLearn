package instagrampost.application;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

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
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/instaposts",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Instaposts.Rest"
	},
	service = Application.class
)
public class InstagrampostApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

		
	@GET
	@Path("/getLatestPosts/by-pagekey/{pageKey}")
	@Produces("application/json")
	public Response getInstaImages(@PathParam("pageKey") String pageKey,
			@QueryParam("param") String param) {

		ResponseBuilder builder;

		try {

			_log.info("pageKey : " + pageKey);
			List<InstaSiteImages> instaImagesList = InstaSiteImagesLocalServiceUtil.getPostsByPageKey(pageKey);
			_log.info("instaImagesList : " + instaImagesList.size());
			
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode instaArrayNode = mapper.createArrayNode();
			ObjectNode objectNode = mapper.createObjectNode();
			ObjectNode objectNode2 = mapper.createObjectNode();
			
			HandleAPIKeys handleAPIKeys = HandleAPIKeysLocalServiceUtil.getHandleAPIRowByPageKey(pageKey);
			if (handleAPIKeys != null && handleAPIKeys.getInstagramWidgetFlag()) {
				/*
				 * ObjectNode objectNode = mapper.createObjectNode();
				 * objectNode.put("hideInstagramWidget",
				 * handleAPIKeys.getInstagramWidgetFlag()); instaArrayNode.add(objectNode);
				 */

			} else if (instaImagesList != null && !instaImagesList.isEmpty() && instaImagesList.size() > 0) {
				for (InstaSiteImages instaSiteImage : instaImagesList) {
					

					long otherDetailId = instaSiteImage.getOtherDetid();
					InstaOtherDetails details = InstaOtherDetailsLocalServiceUtil.getInstaOtherDetails(otherDetailId);

					//objectNode.put("handleName", details.getInstaHandleName());
					objectNode.put("mediaLink", instaSiteImage.getMediaUrl());
					objectNode.put("instagramLink", instaSiteImage.getInstaimageUrl());
					objectNode.put("timestamp", instaSiteImage.getTimestamp());
					//objectNode.put("followUsLink", details.getFollowUsLink());
					instaArrayNode.add(objectNode);
				}
				
				objectNode2.put("handleName", "DASDSDS");
				objectNode2.put("followUsLink", "abc.com");
				instaArrayNode.add(objectNode2);
				
				// builder = Response.ok(instaArrayNode);
			} else {
				// builder = Response.ok(instaArrayNode);
				_log.error("Error Occured in API : /getLatestPosts/by-pagekey/" + pageKey + "-------"
						+ "No Records Found");
			}

			builder = Response.ok(instaArrayNode);

		} catch (Exception ex) {
			_log.error("Error Occured in API : /getLatestPosts/by-pagekey/" + pageKey + "-------" + ex.getMessage());
			builder = Response.serverError();
		}

		return builder.build();
	}
	
	private static final Log _log = LogFactoryUtil.getLog(InstagrampostApplication.class);
	
}