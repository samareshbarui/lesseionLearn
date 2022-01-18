package instagram.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"handleName",
"followUsLink",
"instaUrls"
})

public class InstagramApiMainDto {

	@JsonProperty("handleName")
	private String handleName;
	@JsonProperty("followUsLink")
	private String followUsLink;
	@JsonProperty("instaUrls")
	private List<InstaUrls> instaUrls = null;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public String getHandleName() {
		return handleName;
	}
	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}
	public String getFollowUsLink() {
		return followUsLink;
	}
	public void setFollowUsLink(String followUsLink) {
		this.followUsLink = followUsLink;
	}

	public List<InstaUrls> getInstaUrls() {
		return instaUrls;
	}
	public void setInstaUrls(List<InstaUrls> instaUrls) {
		this.instaUrls = instaUrls;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
	
	
}
