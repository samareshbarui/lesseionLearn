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

package jwc.insta.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jwc.insta.model.HandleAPIKeys;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the handle api keys service. This utility wraps <code>jwc.insta.service.persistence.impl.HandleAPIKeysPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HandleAPIKeysPersistence
 * @generated
 */
public class HandleAPIKeysUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(HandleAPIKeys handleAPIKeys) {
		getPersistence().clearCache(handleAPIKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, HandleAPIKeys> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HandleAPIKeys> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HandleAPIKeys> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HandleAPIKeys> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HandleAPIKeys> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HandleAPIKeys update(HandleAPIKeys handleAPIKeys) {
		return getPersistence().update(handleAPIKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HandleAPIKeys update(
		HandleAPIKeys handleAPIKeys, ServiceContext serviceContext) {

		return getPersistence().update(handleAPIKeys, serviceContext);
	}

	/**
	 * Returns the handle api keys where pageKey = &#63; or throws a <code>NoSuchHandleAPIKeysException</code> if it could not be found.
	 *
	 * @param pageKey the page key
	 * @return the matching handle api keys
	 * @throws NoSuchHandleAPIKeysException if a matching handle api keys could not be found
	 */
	public static HandleAPIKeys findByPageKey(String pageKey)
		throws jwc.insta.exception.NoSuchHandleAPIKeysException {

		return getPersistence().findByPageKey(pageKey);
	}

	/**
	 * Returns the handle api keys where pageKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pageKey the page key
	 * @return the matching handle api keys, or <code>null</code> if a matching handle api keys could not be found
	 */
	public static HandleAPIKeys fetchByPageKey(String pageKey) {
		return getPersistence().fetchByPageKey(pageKey);
	}

	/**
	 * Returns the handle api keys where pageKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pageKey the page key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching handle api keys, or <code>null</code> if a matching handle api keys could not be found
	 */
	public static HandleAPIKeys fetchByPageKey(
		String pageKey, boolean useFinderCache) {

		return getPersistence().fetchByPageKey(pageKey, useFinderCache);
	}

	/**
	 * Removes the handle api keys where pageKey = &#63; from the database.
	 *
	 * @param pageKey the page key
	 * @return the handle api keys that was removed
	 */
	public static HandleAPIKeys removeByPageKey(String pageKey)
		throws jwc.insta.exception.NoSuchHandleAPIKeysException {

		return getPersistence().removeByPageKey(pageKey);
	}

	/**
	 * Returns the number of handle api keyses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the number of matching handle api keyses
	 */
	public static int countByPageKey(String pageKey) {
		return getPersistence().countByPageKey(pageKey);
	}

	/**
	 * Caches the handle api keys in the entity cache if it is enabled.
	 *
	 * @param handleAPIKeys the handle api keys
	 */
	public static void cacheResult(HandleAPIKeys handleAPIKeys) {
		getPersistence().cacheResult(handleAPIKeys);
	}

	/**
	 * Caches the handle api keyses in the entity cache if it is enabled.
	 *
	 * @param handleAPIKeyses the handle api keyses
	 */
	public static void cacheResult(List<HandleAPIKeys> handleAPIKeyses) {
		getPersistence().cacheResult(handleAPIKeyses);
	}

	/**
	 * Creates a new handle api keys with the primary key. Does not add the handle api keys to the database.
	 *
	 * @param handleAPIKeyId the primary key for the new handle api keys
	 * @return the new handle api keys
	 */
	public static HandleAPIKeys create(long handleAPIKeyId) {
		return getPersistence().create(handleAPIKeyId);
	}

	/**
	 * Removes the handle api keys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys that was removed
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	public static HandleAPIKeys remove(long handleAPIKeyId)
		throws jwc.insta.exception.NoSuchHandleAPIKeysException {

		return getPersistence().remove(handleAPIKeyId);
	}

	public static HandleAPIKeys updateImpl(HandleAPIKeys handleAPIKeys) {
		return getPersistence().updateImpl(handleAPIKeys);
	}

	/**
	 * Returns the handle api keys with the primary key or throws a <code>NoSuchHandleAPIKeysException</code> if it could not be found.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	public static HandleAPIKeys findByPrimaryKey(long handleAPIKeyId)
		throws jwc.insta.exception.NoSuchHandleAPIKeysException {

		return getPersistence().findByPrimaryKey(handleAPIKeyId);
	}

	/**
	 * Returns the handle api keys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys, or <code>null</code> if a handle api keys with the primary key could not be found
	 */
	public static HandleAPIKeys fetchByPrimaryKey(long handleAPIKeyId) {
		return getPersistence().fetchByPrimaryKey(handleAPIKeyId);
	}

	/**
	 * Returns all the handle api keyses.
	 *
	 * @return the handle api keyses
	 */
	public static List<HandleAPIKeys> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the handle api keyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HandleAPIKeysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of handle api keyses
	 * @param end the upper bound of the range of handle api keyses (not inclusive)
	 * @return the range of handle api keyses
	 */
	public static List<HandleAPIKeys> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the handle api keyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HandleAPIKeysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of handle api keyses
	 * @param end the upper bound of the range of handle api keyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of handle api keyses
	 */
	public static List<HandleAPIKeys> findAll(
		int start, int end,
		OrderByComparator<HandleAPIKeys> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the handle api keyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HandleAPIKeysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of handle api keyses
	 * @param end the upper bound of the range of handle api keyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of handle api keyses
	 */
	public static List<HandleAPIKeys> findAll(
		int start, int end, OrderByComparator<HandleAPIKeys> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the handle api keyses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of handle api keyses.
	 *
	 * @return the number of handle api keyses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HandleAPIKeysPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<HandleAPIKeysPersistence, HandleAPIKeysPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HandleAPIKeysPersistence.class);

		ServiceTracker<HandleAPIKeysPersistence, HandleAPIKeysPersistence>
			serviceTracker =
				new ServiceTracker
					<HandleAPIKeysPersistence, HandleAPIKeysPersistence>(
						bundle.getBundleContext(),
						HandleAPIKeysPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}