package Sign.in.Custom.Slider.constants;

import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author sbarui002
 */
public class SignInCustomSliderPortletKeys {

	public static final String SIGNINCUSTOMSLIDER =
		"Sign_in_Custom_Slider_SignInCustomSliderPortlet";
	public static final String REDIS_API_BASE_PATH = PropsUtil.get("web.jwc.site.redis.api.base.url");
	public static final String REDIS_API_BRAND_SLIDER_PATH = REDIS_API_BASE_PATH+"saveBrandSliders";

}