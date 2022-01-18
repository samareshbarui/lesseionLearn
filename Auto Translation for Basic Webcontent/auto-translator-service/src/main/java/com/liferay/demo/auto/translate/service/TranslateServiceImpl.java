package com.liferay.demo.auto.translate.service;


import com.liferay.demo.auto.translate.api.TranslateService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

/**
 * @author samareshb915
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = TranslateService.class
)
public class TranslateServiceImpl implements TranslateService {

    private static String subscriptionKey = "4c96ac76157c4b208288f76609f158e8";
    private static String endpoint = "https://api.cognitive.microsofttranslator.com";
	
    OkHttpClient client = new OkHttpClient();
    
	@Override
	public String doTranslateWithLocale(Locale from, Locale to, String value) {
		// TODO Auto-generated method stub
		return this.doTranslate(from.getLanguage(),to.getLanguage(),value);
	}

	@Override
	public String doTranslate(String fromLanguage, String toLanguage, String value) {
		
		String url = endpoint + "/translate?api-version=3.0&from="+fromLanguage+"&to="+toLanguage;
		try {
			_log.debug("Translate from [" + fromLanguage + "] to [" + toLanguage + "]: " + value);

			// Create credentials using a provider chain. For more information, see
			// https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
			//_log.debug("key: " + PortalUtil.getPortalProperties().getProperty("aws.accessKeyId"));
			
			/*
			BasicAWSCredentials awsCreds = new BasicAWSCredentials(PortalUtil.getPortalProperties().getProperty("aws.accessKeyId"), PortalUtil.getPortalProperties().getProperty("aws.secretKey"));

			AmazonTranslate translate = AmazonTranslateClient.builder()
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
					.withRegion(PortalUtil.getPortalProperties().getProperty("aws.region"))
					.build();

			TranslateTextRequest request = new TranslateTextRequest()
					.withText(value)
					.withSourceLanguageCode(fromLanguage)
					.withTargetLanguageCode(toLanguage);
			TranslateTextResult result  = translate.translateText(request);
			_log.debug(result.getTranslatedText());
			return result.getTranslatedText(); 
			*/
			System.out.println("value : "+value);
			String ValueStr="[{\"Text\":\""+value+"\"}]";
			System.out.println("ValueStr : "+ValueStr);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, ValueStr);
			System.out.println("URL : "+url);
			System.out.println("body : "+body);
			Request request = new Request.Builder()
	                .url(url).post(body)
	                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
	                .addHeader("Content-type", "application/json")
	        		.addHeader("Ocp-Apim-Subscription-Region", "centralindia").build();
	        Response response = client.newCall(request).execute();
	        // _log.debug(response.body().string());
		    String result = "";
	        //JSONObject jsonObject = new JSONObject(result);
	        //_log.info("jsonObject : "+jsonObject);
	        JSONArray jsonArray = new JSONArray(response.body().string());
	        System.out.println("jsonArray length : "+jsonArray.length());
	        for(int i=0;i<jsonArray.length();i++) {
	        	JSONObject jsonObject = jsonArray.getJSONObject(i);
	        	System.out.println("jsonObject 1: "+jsonObject.toString());
	        	System.out.println("jsonObject 2: "+jsonObject.get("translations"));
	        	JSONArray jsonArray2 = new JSONArray(jsonObject.get("translations").toString());
	        	for(int j=0; j<jsonArray2.length(); j++) {
	        		JSONObject jsonObject2 = jsonArray2.getJSONObject(j);
	        		System.out.println("jsonObject2 1: "+jsonObject2.toString());
	        		System.out.println("jsonObject2 2: "+jsonObject2.get("text"));
	        		result = jsonObject2.get("text").toString();
	        	}
	        }
	        System.out.println("result : "+result);
	        return result;
		} catch (Exception ex) {
			_log.error("Error: " + ex.getMessage());
			ex.printStackTrace();
			return "";
		}
	}

	// TODO enter required service methods
	private static final Log _log = LogFactoryUtil.getLog(TranslateServiceImpl.class);
}