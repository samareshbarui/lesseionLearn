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
 * Provides a wrapper for {@link HandleAPIKeysLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HandleAPIKeysLocalService
 * @generated
 */
public class HandleAPIKeysLocalServiceWrapper
	implements HandleAPIKeysLocalService,
			   ServiceWrapper<HandleAPIKeysLocalService> {

	public HandleAPIKeysLocalServiceWrapper(
		HandleAPIKeysLocalService handleAPIKeysLocalService) {

		_handleAPIKeysLocalService = handleAPIKeysLocalService;
	}

	/**
	 * Adds the handle api keys to the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeys the handle api keys
	 * @return the handle api keys that was added
	 */
	@Override
	public jwc.insta.model.HandleAPIKeys addHandleAPIKeys(
		jwc.insta.model.HandleAPIKeys handleAPIKeys) {

		return _handleAPIKeysLocalService.addHandleAPIKeys(handleAPIKeys);
	}

	/**
	 * Creates a new handle api keys with the primary key. Does not add the handle api keys to the database.
	 *
	 * @param handleAPIKeyId the primary key for the new handle api keys
	 * @return the new handle api keys
	 */
	@Override
	public jwc.insta.model.HandleAPIKeys createHandleAPIKeys(
		long handleAPIKeyId) {

		return _handleAPIKeysLocalService.createHandleAPIKeys(handleAPIKeyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _handleAPIKeysLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the handle api keys from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeys the handle api keys
	 * @return the handle api keys that was removed
	 */
	@Override
	public jwc.insta.model.HandleAPIKeys deleteHandleAPIKeys(
		jwc.insta.model.HandleAPIKeys handleAPIKeys) {

		return _handleAPIKeysLocalService.deleteHandleAPIKeys(handleAPIKeys);
	}

	/**
	 * Deletes the handle api keys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys that was removed
	 * @throws PortalException if a handle api keys with the primary key could not be found
	 */
	@Override
	public jwc.insta.model.HandleAPIKeys deleteHandleAPIKeys(
			long handleAPIKeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _handleAPIKeysLocalService.deleteHandleAPIKeys(handleAPIKeyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _handleAPIKeysLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _handleAPIKeysLocalService.dynamicQuery();
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

		return _handleAPIKeysLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.HandleAPIKeysModelImpl</code>.
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

		return _handleAPIKeysLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.HandleAPIKeysModelImpl</code>.
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

		return _handleAPIKeysLocalService.dynamicQuery(
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

		return _handleAPIKeysLocalService.dynamicQueryCount(dynamicQuery);
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

		return _handleAPIKeysLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jwc.insta.model.HandleAPIKeys fetchHandleAPIKeys(
		long handleAPIKeyId) {

		return _handleAPIKeysLocalService.fetchHandleAPIKeys(handleAPIKeyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _handleAPIKeysLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getHandleAPIByPageKey(String pageKey) {
		return _handleAPIKeysLocalService.getHandleAPIByPageKey(pageKey);
	}

	/**
	 * Returns the handle api keys with the primary key.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys
	 * @throws PortalException if a handle api keys with the primary key could not be found
	 */
	@Override
	public jwc.insta.model.HandleAPIKeys getHandleAPIKeys(long handleAPIKeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _handleAPIKeysLocalService.getHandleAPIKeys(handleAPIKeyId);
	}

	/**
	 * Returns a range of all the handle api keyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.HandleAPIKeysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of handle api keyses
	 * @param end the upper bound of the range of handle api keyses (not inclusive)
	 * @return the range of handle api keyses
	 */
	@Override
	public java.util.List<jwc.insta.model.HandleAPIKeys> getHandleAPIKeyses(
		int start, int end) {

		return _handleAPIKeysLocalService.getHandleAPIKeyses(start, end);
	}

	/**
	 * Returns the number of handle api keyses.
	 *
	 * @return the number of handle api keyses
	 */
	@Override
	public int getHandleAPIKeysesCount() {
		return _handleAPIKeysLocalService.getHandleAPIKeysesCount();
	}

	@Override
	public jwc.insta.model.HandleAPIKeys getHandleAPIRowByPageKey(
		String pageKey) {

		return _handleAPIKeysLocalService.getHandleAPIRowByPageKey(pageKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _handleAPIKeysLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _handleAPIKeysLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _handleAPIKeysLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the handle api keys in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeys the handle api keys
	 * @return the handle api keys that was updated
	 */
	@Override
	public jwc.insta.model.HandleAPIKeys updateHandleAPIKeys(
		jwc.insta.model.HandleAPIKeys handleAPIKeys) {

		return _handleAPIKeysLocalService.updateHandleAPIKeys(handleAPIKeys);
	}

	@Override
	public HandleAPIKeysLocalService getWrappedService() {
		return _handleAPIKeysLocalService;
	}

	@Override
	public void setWrappedService(
		HandleAPIKeysLocalService handleAPIKeysLocalService) {

		_handleAPIKeysLocalService = handleAPIKeysLocalService;
	}

	private HandleAPIKeysLocalService _handleAPIKeysLocalService;

}