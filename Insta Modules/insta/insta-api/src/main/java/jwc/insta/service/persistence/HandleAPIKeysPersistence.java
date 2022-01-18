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

import jwc.insta.exception.NoSuchHandleAPIKeysException;
import jwc.insta.model.HandleAPIKeys;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the handle api keys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HandleAPIKeysUtil
 * @generated
 */
@ProviderType
public interface HandleAPIKeysPersistence
	extends BasePersistence<HandleAPIKeys> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HandleAPIKeysUtil} to access the handle api keys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the handle api keys where pageKey = &#63; or throws a <code>NoSuchHandleAPIKeysException</code> if it could not be found.
	 *
	 * @param pageKey the page key
	 * @return the matching handle api keys
	 * @throws NoSuchHandleAPIKeysException if a matching handle api keys could not be found
	 */
	public HandleAPIKeys findByPageKey(String pageKey)
		throws NoSuchHandleAPIKeysException;

	/**
	 * Returns the handle api keys where pageKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pageKey the page key
	 * @return the matching handle api keys, or <code>null</code> if a matching handle api keys could not be found
	 */
	public HandleAPIKeys fetchByPageKey(String pageKey);

	/**
	 * Returns the handle api keys where pageKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pageKey the page key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching handle api keys, or <code>null</code> if a matching handle api keys could not be found
	 */
	public HandleAPIKeys fetchByPageKey(String pageKey, boolean useFinderCache);

	/**
	 * Removes the handle api keys where pageKey = &#63; from the database.
	 *
	 * @param pageKey the page key
	 * @return the handle api keys that was removed
	 */
	public HandleAPIKeys removeByPageKey(String pageKey)
		throws NoSuchHandleAPIKeysException;

	/**
	 * Returns the number of handle api keyses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the number of matching handle api keyses
	 */
	public int countByPageKey(String pageKey);

	/**
	 * Caches the handle api keys in the entity cache if it is enabled.
	 *
	 * @param handleAPIKeys the handle api keys
	 */
	public void cacheResult(HandleAPIKeys handleAPIKeys);

	/**
	 * Caches the handle api keyses in the entity cache if it is enabled.
	 *
	 * @param handleAPIKeyses the handle api keyses
	 */
	public void cacheResult(java.util.List<HandleAPIKeys> handleAPIKeyses);

	/**
	 * Creates a new handle api keys with the primary key. Does not add the handle api keys to the database.
	 *
	 * @param handleAPIKeyId the primary key for the new handle api keys
	 * @return the new handle api keys
	 */
	public HandleAPIKeys create(long handleAPIKeyId);

	/**
	 * Removes the handle api keys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys that was removed
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	public HandleAPIKeys remove(long handleAPIKeyId)
		throws NoSuchHandleAPIKeysException;

	public HandleAPIKeys updateImpl(HandleAPIKeys handleAPIKeys);

	/**
	 * Returns the handle api keys with the primary key or throws a <code>NoSuchHandleAPIKeysException</code> if it could not be found.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	public HandleAPIKeys findByPrimaryKey(long handleAPIKeyId)
		throws NoSuchHandleAPIKeysException;

	/**
	 * Returns the handle api keys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys, or <code>null</code> if a handle api keys with the primary key could not be found
	 */
	public HandleAPIKeys fetchByPrimaryKey(long handleAPIKeyId);

	/**
	 * Returns all the handle api keyses.
	 *
	 * @return the handle api keyses
	 */
	public java.util.List<HandleAPIKeys> findAll();

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
	public java.util.List<HandleAPIKeys> findAll(int start, int end);

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
	public java.util.List<HandleAPIKeys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HandleAPIKeys>
			orderByComparator);

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
	public java.util.List<HandleAPIKeys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HandleAPIKeys>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the handle api keyses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of handle api keyses.
	 *
	 * @return the number of handle api keyses
	 */
	public int countAll();

}