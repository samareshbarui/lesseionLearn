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

import jwc.insta.model.InstaSiteImages;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the insta site images service. This utility wraps <code>jwc.insta.service.persistence.impl.InstaSiteImagesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaSiteImagesPersistence
 * @generated
 */
public class InstaSiteImagesUtil {

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
	public static void clearCache(InstaSiteImages instaSiteImages) {
		getPersistence().clearCache(instaSiteImages);
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
	public static Map<Serializable, InstaSiteImages> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InstaSiteImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InstaSiteImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InstaSiteImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InstaSiteImages update(InstaSiteImages instaSiteImages) {
		return getPersistence().update(instaSiteImages);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InstaSiteImages update(
		InstaSiteImages instaSiteImages, ServiceContext serviceContext) {

		return getPersistence().update(instaSiteImages, serviceContext);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public static InstaSiteImages findByInstaimageUrl(String instaimageUrl)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().findByInstaimageUrl(instaimageUrl);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public static InstaSiteImages fetchByInstaimageUrl(String instaimageUrl) {
		return getPersistence().fetchByInstaimageUrl(instaimageUrl);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public static InstaSiteImages fetchByInstaimageUrl(
		String instaimageUrl, boolean useFinderCache) {

		return getPersistence().fetchByInstaimageUrl(
			instaimageUrl, useFinderCache);
	}

	/**
	 * Removes the insta site images where instaimageUrl = &#63; from the database.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the insta site images that was removed
	 */
	public static InstaSiteImages removeByInstaimageUrl(String instaimageUrl)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().removeByInstaimageUrl(instaimageUrl);
	}

	/**
	 * Returns the number of insta site imageses where instaimageUrl = &#63;.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the number of matching insta site imageses
	 */
	public static int countByInstaimageUrl(String instaimageUrl) {
		return getPersistence().countByInstaimageUrl(instaimageUrl);
	}

	/**
	 * Returns all the insta site imageses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the matching insta site imageses
	 */
	public static List<InstaSiteImages> findBypageKey(String pageKey) {
		return getPersistence().findBypageKey(pageKey);
	}

	/**
	 * Returns a range of all the insta site imageses where pageKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param pageKey the page key
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @return the range of matching insta site imageses
	 */
	public static List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end) {

		return getPersistence().findBypageKey(pageKey, start, end);
	}

	/**
	 * Returns an ordered range of all the insta site imageses where pageKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param pageKey the page key
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching insta site imageses
	 */
	public static List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator) {

		return getPersistence().findBypageKey(
			pageKey, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the insta site imageses where pageKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param pageKey the page key
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching insta site imageses
	 */
	public static List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypageKey(
			pageKey, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public static InstaSiteImages findBypageKey_First(
			String pageKey,
			OrderByComparator<InstaSiteImages> orderByComparator)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().findBypageKey_First(pageKey, orderByComparator);
	}

	/**
	 * Returns the first insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public static InstaSiteImages fetchBypageKey_First(
		String pageKey, OrderByComparator<InstaSiteImages> orderByComparator) {

		return getPersistence().fetchBypageKey_First(
			pageKey, orderByComparator);
	}

	/**
	 * Returns the last insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public static InstaSiteImages findBypageKey_Last(
			String pageKey,
			OrderByComparator<InstaSiteImages> orderByComparator)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().findBypageKey_Last(pageKey, orderByComparator);
	}

	/**
	 * Returns the last insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public static InstaSiteImages fetchBypageKey_Last(
		String pageKey, OrderByComparator<InstaSiteImages> orderByComparator) {

		return getPersistence().fetchBypageKey_Last(pageKey, orderByComparator);
	}

	/**
	 * Returns the insta site imageses before and after the current insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param instaSiteImageId the primary key of the current insta site images
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next insta site images
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	public static InstaSiteImages[] findBypageKey_PrevAndNext(
			long instaSiteImageId, String pageKey,
			OrderByComparator<InstaSiteImages> orderByComparator)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().findBypageKey_PrevAndNext(
			instaSiteImageId, pageKey, orderByComparator);
	}

	/**
	 * Removes all the insta site imageses where pageKey = &#63; from the database.
	 *
	 * @param pageKey the page key
	 */
	public static void removeBypageKey(String pageKey) {
		getPersistence().removeBypageKey(pageKey);
	}

	/**
	 * Returns the number of insta site imageses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the number of matching insta site imageses
	 */
	public static int countBypageKey(String pageKey) {
		return getPersistence().countBypageKey(pageKey);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public static InstaSiteImages findBylinksTimestamp(
			String instaimageUrl, String mediaUrl, String timestamp)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().findBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public static InstaSiteImages fetchBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp) {

		return getPersistence().fetchBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public static InstaSiteImages fetchBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp,
		boolean useFinderCache) {

		return getPersistence().fetchBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp, useFinderCache);
	}

	/**
	 * Removes the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; from the database.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the insta site images that was removed
	 */
	public static InstaSiteImages removeBylinksTimestamp(
			String instaimageUrl, String mediaUrl, String timestamp)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().removeBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp);
	}

	/**
	 * Returns the number of insta site imageses where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63;.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the number of matching insta site imageses
	 */
	public static int countBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp) {

		return getPersistence().countBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp);
	}

	/**
	 * Caches the insta site images in the entity cache if it is enabled.
	 *
	 * @param instaSiteImages the insta site images
	 */
	public static void cacheResult(InstaSiteImages instaSiteImages) {
		getPersistence().cacheResult(instaSiteImages);
	}

	/**
	 * Caches the insta site imageses in the entity cache if it is enabled.
	 *
	 * @param instaSiteImageses the insta site imageses
	 */
	public static void cacheResult(List<InstaSiteImages> instaSiteImageses) {
		getPersistence().cacheResult(instaSiteImageses);
	}

	/**
	 * Creates a new insta site images with the primary key. Does not add the insta site images to the database.
	 *
	 * @param instaSiteImageId the primary key for the new insta site images
	 * @return the new insta site images
	 */
	public static InstaSiteImages create(long instaSiteImageId) {
		return getPersistence().create(instaSiteImageId);
	}

	/**
	 * Removes the insta site images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images that was removed
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	public static InstaSiteImages remove(long instaSiteImageId)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().remove(instaSiteImageId);
	}

	public static InstaSiteImages updateImpl(InstaSiteImages instaSiteImages) {
		return getPersistence().updateImpl(instaSiteImages);
	}

	/**
	 * Returns the insta site images with the primary key or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	public static InstaSiteImages findByPrimaryKey(long instaSiteImageId)
		throws jwc.insta.exception.NoSuchInstaSiteImagesException {

		return getPersistence().findByPrimaryKey(instaSiteImageId);
	}

	/**
	 * Returns the insta site images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images, or <code>null</code> if a insta site images with the primary key could not be found
	 */
	public static InstaSiteImages fetchByPrimaryKey(long instaSiteImageId) {
		return getPersistence().fetchByPrimaryKey(instaSiteImageId);
	}

	/**
	 * Returns all the insta site imageses.
	 *
	 * @return the insta site imageses
	 */
	public static List<InstaSiteImages> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the insta site imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @return the range of insta site imageses
	 */
	public static List<InstaSiteImages> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the insta site imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of insta site imageses
	 */
	public static List<InstaSiteImages> findAll(
		int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the insta site imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstaSiteImagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta site imageses
	 * @param end the upper bound of the range of insta site imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of insta site imageses
	 */
	public static List<InstaSiteImages> findAll(
		int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the insta site imageses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of insta site imageses.
	 *
	 * @return the number of insta site imageses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InstaSiteImagesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InstaSiteImagesPersistence, InstaSiteImagesPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			InstaSiteImagesPersistence.class);

		ServiceTracker<InstaSiteImagesPersistence, InstaSiteImagesPersistence>
			serviceTracker =
				new ServiceTracker
					<InstaSiteImagesPersistence, InstaSiteImagesPersistence>(
						bundle.getBundleContext(),
						InstaSiteImagesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}