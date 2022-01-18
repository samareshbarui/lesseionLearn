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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import jwc.insta.exception.NoSuchInstaSiteImagesException;
import jwc.insta.model.InstaSiteImages;
import jwc.insta.service.base.InstaSiteImagesLocalServiceBaseImpl;

/**
 * The implementation of the insta site images local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jwc.insta.service.InstaSiteImagesLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaSiteImagesLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jwc.insta.model.InstaSiteImages",
	service = AopService.class
)
public class InstaSiteImagesLocalServiceImpl
	extends InstaSiteImagesLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jwc.insta.service.InstaSiteImagesLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jwc.insta.service.InstaSiteImagesLocalServiceUtil</code>.
	 */

     public List<InstaSiteImages> getPostsByPageKey(String pageKey){
    	 return instaSiteImagesPersistence.findBypageKey(pageKey);
     }

     
     public InstaSiteImages getRowByLinksAndTimestamp(String instaimageUrl, String mediaUrl ,String timestamp) {
    	 InstaSiteImages instaSiteImages = null ;
    	 
    	   try {
			return instaSiteImagesPersistence.findBylinksTimestamp(instaimageUrl, mediaUrl, timestamp);
		} catch (NoSuchInstaSiteImagesException e) {
			_log.error("Exception Occured in getRowByLinksAndTimestamp() :" + e.getMessage());
			return instaSiteImages;
		}
     }
     
     
     private static final Log _log = LogFactoryUtil.getLog(InstaSiteImagesLocalServiceImpl.class);

}


