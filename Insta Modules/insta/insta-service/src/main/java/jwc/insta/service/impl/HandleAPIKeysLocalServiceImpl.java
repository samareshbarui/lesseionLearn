/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package jwc.insta.service.impl;

import com.liferay.portal.aop.AopService;

import jwc.insta.exception.NoSuchHandleAPIKeysException;
import jwc.insta.model.HandleAPIKeys;
import jwc.insta.service.base.HandleAPIKeysLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the handle api keys local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jwc.insta.service.HandleAPIKeysLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HandleAPIKeysLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jwc.insta.model.HandleAPIKeys",
	service = AopService.class
)
public class HandleAPIKeysLocalServiceImpl
	extends HandleAPIKeysLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jwc.insta.service.HandleAPIKeysLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jwc.insta.service.HandleAPIKeysLocalServiceUtil</code>.
	 */
	 public String getHandleAPIByPageKey(String pageKey)  {
		HandleAPIKeys handleAPIKeys;
		String apiKey = "";
		try {
			handleAPIKeys = handleAPIKeysPersistence.findByPageKey(pageKey);
			apiKey = handleAPIKeys.getApiKey();
		} catch (NoSuchHandleAPIKeysException e) {
			apiKey ="";
		}
			
		return apiKey;
	 }
	 
	 
	 public HandleAPIKeys getHandleAPIRowByPageKey(String pageKey)  {
			HandleAPIKeys handleAPIKey = null;
			
			try {
				handleAPIKey = handleAPIKeysPersistence.findByPageKey(pageKey);
				
			} catch (NoSuchHandleAPIKeysException e) {
				
			}
				
			return handleAPIKey;
		 }
	
	
}