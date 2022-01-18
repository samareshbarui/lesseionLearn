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
 * Provides a wrapper for {@link InstaOtherDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InstaOtherDetailsLocalService
 * @generated
 */
public class InstaOtherDetailsLocalServiceWrapper
	implements InstaOtherDetailsLocalService,
			   ServiceWrapper<InstaOtherDetailsLocalService> {

	public InstaOtherDetailsLocalServiceWrapper(
		InstaOtherDetailsLocalService instaOtherDetailsLocalService) {

		_instaOtherDetailsLocalService = instaOtherDetailsLocalService;
	}

	/**
	 * Adds the insta other details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was added
	 */
	@Override
	public jwc.insta.model.InstaOtherDetails addInstaOtherDetails(
		jwc.insta.model.InstaOtherDetails instaOtherDetails) {

		return _instaOtherDetailsLocalService.addInstaOtherDetails(
			instaOtherDetails);
	}

	/**
	 * Creates a new insta other details with the primary key. Does not add the insta other details to the database.
	 *
	 * @param otherDetid the primary key for the new insta other details
	 * @return the new insta other details
	 */
	@Override
	public jwc.insta.model.InstaOtherDetails createInstaOtherDetails(
		long otherDetid) {

		return _instaOtherDetailsLocalService.createInstaOtherDetails(
			otherDetid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaOtherDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the insta other details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was removed
	 */
	@Override
	public jwc.insta.model.InstaOtherDetails deleteInstaOtherDetails(
		jwc.insta.model.InstaOtherDetails instaOtherDetails) {

		return _instaOtherDetailsLocalService.deleteInstaOtherDetails(
			instaOtherDetails);
	}

	/**
	 * Deletes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws PortalException if a insta other details with the primary key could not be found
	 */
	@Override
	public jwc.insta.model.InstaOtherDetails deleteInstaOtherDetails(
			long otherDetid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaOtherDetailsLocalService.deleteInstaOtherDetails(
			otherDetid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaOtherDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _instaOtherDetailsLocalService.dynamicQuery();
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

		return _instaOtherDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaOtherDetailsModelImpl</code>.
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

		return _instaOtherDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaOtherDetailsModelImpl</code>.
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

		return _instaOtherDetailsLocalService.dynamicQuery(
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

		return _instaOtherDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _instaOtherDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jwc.insta.model.InstaOtherDetails fetchInstaOtherDetails(
		long otherDetid) {

		return _instaOtherDetailsLocalService.fetchInstaOtherDetails(
			otherDetid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _instaOtherDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _instaOtherDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the insta other details with the primary key.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details
	 * @throws PortalException if a insta other details with the primary key could not be found
	 */
	@Override
	public jwc.insta.model.InstaOtherDetails getInstaOtherDetails(
			long otherDetid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaOtherDetailsLocalService.getInstaOtherDetails(otherDetid);
	}

	/**
	 * Returns a range of all the insta other detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta other detailses
	 * @param end the upper bound of the range of insta other detailses (not inclusive)
	 * @return the range of insta other detailses
	 */
	@Override
	public java.util.List<jwc.insta.model.InstaOtherDetails>
		getInstaOtherDetailses(int start, int end) {

		return _instaOtherDetailsLocalService.getInstaOtherDetailses(
			start, end);
	}

	/**
	 * Returns the number of insta other detailses.
	 *
	 * @return the number of insta other detailses
	 */
	@Override
	public int getInstaOtherDetailsesCount() {
		return _instaOtherDetailsLocalService.getInstaOtherDetailsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _instaOtherDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _instaOtherDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the insta other details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was updated
	 */
	@Override
	public jwc.insta.model.InstaOtherDetails updateInstaOtherDetails(
		jwc.insta.model.InstaOtherDetails instaOtherDetails) {

		return _instaOtherDetailsLocalService.updateInstaOtherDetails(
			instaOtherDetails);
	}

	@Override
	public InstaOtherDetailsLocalService getWrappedService() {
		return _instaOtherDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		InstaOtherDetailsLocalService instaOtherDetailsLocalService) {

		_instaOtherDetailsLocalService = instaOtherDetailsLocalService;
	}

	private InstaOtherDetailsLocalService _instaOtherDetailsLocalService;

}