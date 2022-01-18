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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import jwc.insta.exception.NoSuchInstaSiteImagesException;
import jwc.insta.model.InstaSiteImages;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the insta site images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaSiteImagesUtil
 * @generated
 */
@ProviderType
public interface InstaSiteImagesPersistence
	extends BasePersistence<InstaSiteImages> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstaSiteImagesUtil} to access the insta site images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public InstaSiteImages findByInstaimageUrl(String instaimageUrl)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public InstaSiteImages fetchByInstaimageUrl(String instaimageUrl);

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public InstaSiteImages fetchByInstaimageUrl(
		String instaimageUrl, boolean useFinderCache);

	/**
	 * Removes the insta site images where instaimageUrl = &#63; from the database.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the insta site images that was removed
	 */
	public InstaSiteImages removeByInstaimageUrl(String instaimageUrl)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the number of insta site imageses where instaimageUrl = &#63;.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the number of matching insta site imageses
	 */
	public int countByInstaimageUrl(String instaimageUrl);

	/**
	 * Returns all the insta site imageses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the matching insta site imageses
	 */
	public java.util.List<InstaSiteImages> findBypageKey(String pageKey);

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
	public java.util.List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end);

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
	public java.util.List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
			orderByComparator);

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
	public java.util.List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public InstaSiteImages findBypageKey_First(
			String pageKey,
			com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
				orderByComparator)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the first insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public InstaSiteImages fetchBypageKey_First(
		String pageKey,
		com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
			orderByComparator);

	/**
	 * Returns the last insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public InstaSiteImages findBypageKey_Last(
			String pageKey,
			com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
				orderByComparator)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the last insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public InstaSiteImages fetchBypageKey_Last(
		String pageKey,
		com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
			orderByComparator);

	/**
	 * Returns the insta site imageses before and after the current insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param instaSiteImageId the primary key of the current insta site images
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next insta site images
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	public InstaSiteImages[] findBypageKey_PrevAndNext(
			long instaSiteImageId, String pageKey,
			com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
				orderByComparator)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Removes all the insta site imageses where pageKey = &#63; from the database.
	 *
	 * @param pageKey the page key
	 */
	public void removeBypageKey(String pageKey);

	/**
	 * Returns the number of insta site imageses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the number of matching insta site imageses
	 */
	public int countBypageKey(String pageKey);

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	public InstaSiteImages findBylinksTimestamp(
			String instaimageUrl, String mediaUrl, String timestamp)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public InstaSiteImages fetchBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp);

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	public InstaSiteImages fetchBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp,
		boolean useFinderCache);

	/**
	 * Removes the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; from the database.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the insta site images that was removed
	 */
	public InstaSiteImages removeBylinksTimestamp(
			String instaimageUrl, String mediaUrl, String timestamp)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the number of insta site imageses where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63;.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the number of matching insta site imageses
	 */
	public int countBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp);

	/**
	 * Caches the insta site images in the entity cache if it is enabled.
	 *
	 * @param instaSiteImages the insta site images
	 */
	public void cacheResult(InstaSiteImages instaSiteImages);

	/**
	 * Caches the insta site imageses in the entity cache if it is enabled.
	 *
	 * @param instaSiteImageses the insta site imageses
	 */
	public void cacheResult(java.util.List<InstaSiteImages> instaSiteImageses);

	/**
	 * Creates a new insta site images with the primary key. Does not add the insta site images to the database.
	 *
	 * @param instaSiteImageId the primary key for the new insta site images
	 * @return the new insta site images
	 */
	public InstaSiteImages create(long instaSiteImageId);

	/**
	 * Removes the insta site images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images that was removed
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	public InstaSiteImages remove(long instaSiteImageId)
		throws NoSuchInstaSiteImagesException;

	public InstaSiteImages updateImpl(InstaSiteImages instaSiteImages);

	/**
	 * Returns the insta site images with the primary key or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	public InstaSiteImages findByPrimaryKey(long instaSiteImageId)
		throws NoSuchInstaSiteImagesException;

	/**
	 * Returns the insta site images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images, or <code>null</code> if a insta site images with the primary key could not be found
	 */
	public InstaSiteImages fetchByPrimaryKey(long instaSiteImageId);

	/**
	 * Returns all the insta site imageses.
	 *
	 * @return the insta site imageses
	 */
	public java.util.List<InstaSiteImages> findAll();

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
	public java.util.List<InstaSiteImages> findAll(int start, int end);

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
	public java.util.List<InstaSiteImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
			orderByComparator);

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
	public java.util.List<InstaSiteImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InstaSiteImages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the insta site imageses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of insta site imageses.
	 *
	 * @return the number of insta site imageses
	 */
	public int countAll();

}