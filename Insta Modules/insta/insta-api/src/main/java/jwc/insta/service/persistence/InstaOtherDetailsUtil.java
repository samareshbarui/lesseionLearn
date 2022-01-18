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

import jwc.insta.model.InstaOtherDetails;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the insta other details service. This utility wraps <code>jwc.insta.service.persistence.impl.InstaOtherDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaOtherDetailsPersistence
 * @generated
 */
public class InstaOtherDetailsUtil {

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
	public static void clearCache(InstaOtherDetails instaOtherDetails) {
		getPersistence().clearCache(instaOtherDetails);
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
	public static Map<Serializable, InstaOtherDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InstaOtherDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InstaOtherDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InstaOtherDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InstaOtherDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InstaOtherDetails update(
		InstaOtherDetails instaOtherDetails) {

		return getPersistence().update(instaOtherDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InstaOtherDetails update(
		InstaOtherDetails instaOtherDetails, ServiceContext serviceContext) {

		return getPersistence().update(instaOtherDetails, serviceContext);
	}

	/**
	 * Caches the insta other details in the entity cache if it is enabled.
	 *
	 * @param instaOtherDetails the insta other details
	 */
	public static void cacheResult(InstaOtherDetails instaOtherDetails) {
		getPersistence().cacheResult(instaOtherDetails);
	}

	/**
	 * Caches the insta other detailses in the entity cache if it is enabled.
	 *
	 * @param instaOtherDetailses the insta other detailses
	 */
	public static void cacheResult(
		List<InstaOtherDetails> instaOtherDetailses) {

		getPersistence().cacheResult(instaOtherDetailses);
	}

	/**
	 * Creates a new insta other details with the primary key. Does not add the insta other details to the database.
	 *
	 * @param otherDetid the primary key for the new insta other details
	 * @return the new insta other details
	 */
	public static InstaOtherDetails create(long otherDetid) {
		return getPersistence().create(otherDetid);
	}

	/**
	 * Removes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	public static InstaOtherDetails remove(long otherDetid)
		throws jwc.insta.exception.NoSuchInstaOtherDetailsException {

		return getPersistence().remove(otherDetid);
	}

	public static InstaOtherDetails updateImpl(
		InstaOtherDetails instaOtherDetails) {

		return getPersistence().updateImpl(instaOtherDetails);
	}

	/**
	 * Returns the insta other details with the primary key or throws a <code>NoSuchInstaOtherDetailsException</code> if it could not be found.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	public static InstaOtherDetails findByPrimaryKey(long otherDetid)
		throws jwc.insta.exception.NoSuchInstaOtherDetailsException {

		return getPersistence().findByPrimaryKey(otherDetid);
	}

	/**
	 * Returns the insta other details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details, or <code>null</code> if a insta other details with the primary key could not be found
	 */
	public static InstaOtherDetails fetchByPrimaryKey(long otherDetid) {
		return getPersistence().fetchByPrimaryKey(otherDetid);
	}

	/**
	 * Returns all the insta other detailses.
	 *
	 * @return the insta other detailses
	 */
	public static List<InstaOtherDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the insta other detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta other detailses
	 * @param end the upper bound of the range of insta other detailses (not inclusive)
	 * @return the range of insta other detailses
	 */
	public static List<InstaOtherDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the insta other detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta other detailses
	 * @param end the upper bound of the range of insta other detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of insta other detailses
	 */
	public static List<InstaOtherDetails> findAll(
		int start, int end,
		OrderByComparator<InstaOtherDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the insta other detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta other detailses
	 * @param end the upper bound of the range of insta other detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of insta other detailses
	 */
	public static List<InstaOtherDetails> findAll(
		int start, int end,
		OrderByComparator<InstaOtherDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the insta other detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of insta other detailses.
	 *
	 * @return the number of insta other detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InstaOtherDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InstaOtherDetailsPersistence, InstaOtherDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			InstaOtherDetailsPersistence.class);

		ServiceTracker
			<InstaOtherDetailsPersistence, InstaOtherDetailsPersistence>
				serviceTracker =
					new ServiceTracker
						<InstaOtherDetailsPersistence,
						 InstaOtherDetailsPersistence>(
							 bundle.getBundleContext(),
							 InstaOtherDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}