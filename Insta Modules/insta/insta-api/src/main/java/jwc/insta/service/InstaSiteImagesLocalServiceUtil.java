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

package jwc.insta.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for InstaSiteImages. This utility wraps
 * <code>jwc.insta.service.impl.InstaSiteImagesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see InstaSiteImagesLocalService
 * @generated
 */
public class InstaSiteImagesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jwc.insta.service.impl.InstaSiteImagesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the insta site images to the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImages the insta site images
	 * @return the insta site images that was added
	 */
	public static jwc.insta.model.InstaSiteImages addInstaSiteImages(
		jwc.insta.model.InstaSiteImages instaSiteImages) {

		return getService().addInstaSiteImages(instaSiteImages);
	}

	/**
	 * Creates a new insta site images with the primary key. Does not add the insta site images to the database.
	 *
	 * @param instaSiteImageId the primary key for the new insta site images
	 * @return the new insta site images
	 */
	public static jwc.insta.model.InstaSiteImages createInstaSiteImages(
		long instaSiteImageId) {

		return getService().createInstaSiteImages(instaSiteImageId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the insta site images from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImages the insta site images
	 * @return the insta site images that was removed
	 */
	public static jwc.insta.model.InstaSiteImages deleteInstaSiteImages(
		jwc.insta.model.InstaSiteImages instaSiteImages) {

		return getService().deleteInstaSiteImages(instaSiteImages);
	}

	/**
	 * Deletes the insta site images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images that was removed
	 * @throws PortalException if a insta site images with the primary key could not be found
	 */
	public static jwc.insta.model.InstaSiteImages deleteInstaSiteImages(
			long instaSiteImageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteInstaSiteImages(instaSiteImageId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static jwc.insta.model.InstaSiteImages fetchInstaSiteImages(
		long instaSiteImageId) {

		return getService().fetchInstaSiteImages(instaSiteImageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the insta site images with the primary key.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images
	 * @throws PortalException if a insta site images with the primary key could not be found
	 */
	public static jwc.insta.model.InstaSiteImages getInstaSiteImages(
			long instaSiteImageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInstaSiteImages(instaSiteImageId);
	}

	/**
	 * Returns a range of all the insta site imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @return the range of insta site imageses
	 */
	public static java.util.List<jwc.insta.model.InstaSiteImages>
		getInstaSiteImageses(int start, int end) {

		return getService().getInstaSiteImageses(start, end);
	}

	/**
	 * Returns the number of insta site imageses.
	 *
	 * @return the number of insta site imageses
	 */
	public static int getInstaSiteImagesesCount() {
		return getService().getInstaSiteImagesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<jwc.insta.model.InstaSiteImages>
		getPostsByPageKey(String pageKey) {

		return getService().getPostsByPageKey(pageKey);
	}

	public static jwc.insta.model.InstaSiteImages getRowByLinksAndTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp) {

		return getService().getRowByLinksAndTimestamp(
			instaimageUrl, mediaUrl, timestamp);
	}

	/**
	 * Updates the insta site images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImages the insta site images
	 * @return the insta site images that was updated
	 */
	public static jwc.insta.model.InstaSiteImages updateInstaSiteImages(
		jwc.insta.model.InstaSiteImages instaSiteImages) {

		return getService().updateInstaSiteImages(instaSiteImages);
	}

	public static InstaSiteImagesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InstaSiteImagesLocalService, InstaSiteImagesLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			InstaSiteImagesLocalService.class);

		ServiceTracker<InstaSiteImagesLocalService, InstaSiteImagesLocalService>
			serviceTracker =
				new ServiceTracker
					<InstaSiteImagesLocalService, InstaSiteImagesLocalService>(
						bundle.getBundleContext(),
						InstaSiteImagesLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}