package Sign.In.Slider.Api.Dto;

import java.util.List;

public class SignInBrandDTO {
	
	private long brandId;
	private String brandKeyName;
	private String imageUrlList;
	
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public String getBrandKeyName() {
		return brandKeyName;
	}
	public void setBrandKeyName(String brandKeyName) {
		this.brandKeyName = brandKeyName;
	}
	public String getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(String imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	
	
}
