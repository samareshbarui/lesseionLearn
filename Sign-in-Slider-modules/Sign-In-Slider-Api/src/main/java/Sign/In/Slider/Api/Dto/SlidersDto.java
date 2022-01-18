package Sign.In.Slider.Api.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"brandKeyName",
"imageUrls",
})

public class SlidersDto {
	
	@JsonProperty("brandKeyName")
	private String brandKeyName;
	@JsonProperty("imageUrls")
	private List<ImageUrls> imageUrls ;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public String getBrandKeyName() {
		return brandKeyName;
	}
	public void setBrandKeyName(String brandKeyName) {
		this.brandKeyName = brandKeyName;
	}
	public List<ImageUrls> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(List<ImageUrls> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
	
}
