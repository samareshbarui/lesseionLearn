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
 * Provides the local service utility for HandleAPIKeys. This utility wraps
 * <code>jwc.insta.service.impl.HandleAPIKeysLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see HandleAPIKeysLocalService
 * @generated
 */
public class HandleAPIKeysLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jwc.insta.service.impl.HandleAPIKeysLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the handle api keys to the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeys the handle api keys
	 * @return the handle api keys that was added
	 */
	public static jwc.insta.model.HandleAPIKeys addHandleAPIKeys(
		jwc.insta.model.HandleAPIKeys handleAPIKeys) {

		return getService().addHandleAPIKeys(handleAPIKeys);
	}

	/**
	 * Creates a new handle api keys with the primary key. Does not add the handle api keys to the database.
	 *
	 * @param handleAPIKeyId the primary key for the new handle api keys
	 * @return the new handle api keys
	 */
	public static jwc.insta.model.HandleAPIKeys createHandleAPIKeys(
		long handleAPIKeyId) {

		return getService().createHandleAPIKeys(handleAPIKeyId);
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
	 * Deletes the handle api keys from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeys the handle api keys
	 * @return the handle api keys that was removed
	 */
	public static jwc.insta.model.HandleAPIKeys deleteHandleAPIKeys(
		jwc.insta.model.HandleAPIKeys handleAPIKeys) {

		return getService().deleteHandleAPIKeys(handleAPIKeys);
	}

	/**
	 * Deletes the handle api keys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys that was removed
	 * @throws PortalException if a handle api keys with the primary key could not be found
	 */
	public static jwc.insta.model.HandleAPIKeys deleteHandleAPIKeys(
			long handleAPIKeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteHandleAPIKeys(handleAPIKeyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.HandleAPIKeysModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.HandleAPIKeysModelImpl</code>.
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

	public static jwc.insta.model.HandleAPIKeys fetchHandleAPIKeys(
		long handleAPIKeyId) {

		return getService().fetchHandleAPIKeys(handleAPIKeyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static String getHandleAPIByPageKey(String pageKey) {
		return getService().getHandleAPIByPageKey(pageKey);
	}

	/**
	 * Returns the handle api keys with the primary key.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys
	 * @throws PortalException if a handle api keys with the primary key could not be found
	 */
	public static jwc.insta.model.HandleAPIKeys getHandleAPIKeys(
			long handleAPIKeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getHandleAPIKeys(handleAPIKeyId);
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
	public static java.util.List<jwc.insta.model.HandleAPIKeys>
		getHandleAPIKeyses(int start, int end) {

		return getService().getHandleAPIKeyses(start, end);
	}

	/**
	 * Returns the number of handle api keyses.
	 *
	 * @return the number of handle api keyses
	 */
	public static int getHandleAPIKeysesCount() {
		return getService().getHandleAPIKeysesCount();
	}

	public static jwc.insta.model.HandleAPIKeys getHandleAPIRowByPageKey(
		String pageKey) {

		return getService().getHandleAPIRowByPageKey(pageKey);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	/**
	 * Updates the handle api keys in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeys the handle api keys
	 * @return the handle api keys that was updated
	 */
	public static jwc.insta.model.HandleAPIKeys updateHandleAPIKeys(
		jwc.insta.model.HandleAPIKeys handleAPIKeys) {

		return getService().updateHandleAPIKeys(handleAPIKeys);
	}

	public static HandleAPIKeysLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<HandleAPIKeysLocalService, HandleAPIKeysLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			HandleAPIKeysLocalService.class);

		ServiceTracker<HandleAPIKeysLocalService, HandleAPIKeysLocalService>
			serviceTracker =
				new ServiceTracker
					<HandleAPIKeysLocalService, HandleAPIKeysLocalService>(
						bundle.getBundleContext(),
						HandleAPIKeysLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}