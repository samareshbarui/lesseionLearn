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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InstaSiteImagesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InstaSiteImagesLocalService
 * @generated
 */
public class InstaSiteImagesLocalServiceWrapper
	implements InstaSiteImagesLocalService,
			   ServiceWrapper<InstaSiteImagesLocalService> {

	public InstaSiteImagesLocalServiceWrapper(
		InstaSiteImagesLocalService instaSiteImagesLocalService) {

		_instaSiteImagesLocalService = instaSiteImagesLocalService;
	}

	/**
	 * Adds the insta site images to the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImages the insta site images
	 * @return the insta site images that was added
	 */
	@Override
	public jwc.insta.model.InstaSiteImages addInstaSiteImages(
		jwc.insta.model.InstaSiteImages instaSiteImages) {

		return _instaSiteImagesLocalService.addInstaSiteImages(instaSiteImages);
	}

	/**
	 * Creates a new insta site images with the primary key. Does not add the insta site images to the database.
	 *
	 * @param instaSiteImageId the primary key for the new insta site images
	 * @return the new insta site images
	 */
	@Override
	public jwc.insta.model.InstaSiteImages createInstaSiteImages(
		long instaSiteImageId) {

		return _instaSiteImagesLocalService.createInstaSiteImages(
			instaSiteImageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaSiteImagesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the insta site images from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImages the insta site images
	 * @return the insta site images that was removed
	 */
	@Override
	public jwc.insta.model.InstaSiteImages deleteInstaSiteImages(
		jwc.insta.model.InstaSiteImages instaSiteImages) {

		return _instaSiteImagesLocalService.deleteInstaSiteImages(
			instaSiteImages);
	}

	/**
	 * Deletes the insta site images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images that was removed
	 * @throws PortalException if a insta site images with the primary key could not be found
	 */
	@Override
	public jwc.insta.model.InstaSiteImages deleteInstaSiteImages(
			long instaSiteImageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaSiteImagesLocalService.deleteInstaSiteImages(
			instaSiteImageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaSiteImagesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _instaSiteImagesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _instaSiteImagesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _instaSiteImagesLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _instaSiteImagesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _instaSiteImagesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _instaSiteImagesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jwc.insta.model.InstaSiteImages fetchInstaSiteImages(
		long instaSiteImageId) {

		return _instaSiteImagesLocalService.fetchInstaSiteImages(
			instaSiteImageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _instaSiteImagesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _instaSiteImagesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the insta site images with the primary key.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images
	 * @throws PortalException if a insta site images with the primary key could not be found
	 */
	@Override
	public jwc.insta.model.InstaSiteImages getInstaSiteImages(
			long instaSiteImageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaSiteImagesLocalService.getInstaSiteImages(
			instaSiteImageId);
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
	@Override
	public java.util.List<jwc.insta.model.InstaSiteImages> getInstaSiteImageses(
		int start, int end) {

		return _instaSiteImagesLocalService.getInstaSiteImageses(start, end);
	}

	/**
	 * Returns the number of insta site imageses.
	 *
	 * @return the number of insta site imageses
	 */
	@Override
	public int getInstaSiteImagesesCount() {
		return _instaSiteImagesLocalService.getInstaSiteImagesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _instaSiteImagesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaSiteImagesLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<jwc.insta.model.InstaSiteImages> getPostsByPageKey(
		String pageKey) {

		return _instaSiteImagesLocalService.getPostsByPageKey(pageKey);
	}

	@Override
	public jwc.insta.model.InstaSiteImages getRowByLinksAndTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp) {

		return _instaSiteImagesLocalService.getRowByLinksAndTimestamp(
			instaimageUrl, mediaUrl, timestamp);
	}

	/**
	 * Updates the insta site images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImages the insta site images
	 * @return the insta site images that was updated
	 */
	@Override
	public jwc.insta.model.InstaSiteImages updateInstaSiteImages(
		jwc.insta.model.InstaSiteImages instaSiteImages) {

		return _instaSiteImagesLocalService.updateInstaSiteImages(
			instaSiteImages);
	}

	@Override
	public InstaSiteImagesLocalService getWrappedService() {
		return _instaSiteImagesLocalService;
	}

	@Override
	public void setWrappedService(
		InstaSiteImagesLocalService instaSiteImagesLocalService) {

		_instaSiteImagesLocalService = instaSiteImagesLocalService;
	}

	private InstaSiteImagesLocalService _instaSiteImagesLocalService;

}