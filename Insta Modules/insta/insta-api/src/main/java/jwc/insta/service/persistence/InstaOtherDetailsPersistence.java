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

import jwc.insta.exception.NoSuchInstaOtherDetailsException;
import jwc.insta.model.InstaOtherDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the insta other details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaOtherDetailsUtil
 * @generated
 */
@ProviderType
public interface InstaOtherDetailsPersistence
	extends BasePersistence<InstaOtherDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstaOtherDetailsUtil} to access the insta other details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the insta other details in the entity cache if it is enabled.
	 *
	 * @param instaOtherDetails the insta other details
	 */
	public void cacheResult(InstaOtherDetails instaOtherDetails);

	/**
	 * Caches the insta other detailses in the entity cache if it is enabled.
	 *
	 * @param instaOtherDetailses the insta other detailses
	 */
	public void cacheResult(
		java.util.List<InstaOtherDetails> instaOtherDetailses);

	/**
	 * Creates a new insta other details with the primary key. Does not add the insta other details to the database.
	 *
	 * @param otherDetid the primary key for the new insta other details
	 * @return the new insta other details
	 */
	public InstaOtherDetails create(long otherDetid);

	/**
	 * Removes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	public InstaOtherDetails remove(long otherDetid)
		throws NoSuchInstaOtherDetailsException;

	public InstaOtherDetails updateImpl(InstaOtherDetails instaOtherDetails);

	/**
	 * Returns the insta other details with the primary key or throws a <code>NoSuchInstaOtherDetailsException</code> if it could not be found.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	public InstaOtherDetails findByPrimaryKey(long otherDetid)
		throws NoSuchInstaOtherDetailsException;

	/**
	 * Returns the insta other details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details, or <code>null</code> if a insta other details with the primary key could not be found
	 */
	public InstaOtherDetails fetchByPrimaryKey(long otherDetid);

	/**
	 * Returns all the insta other detailses.
	 *
	 * @return the insta other detailses
	 */
	public java.util.List<InstaOtherDetails> findAll();

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
	public java.util.List<InstaOtherDetails> findAll(int start, int end);

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
	public java.util.List<InstaOtherDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InstaOtherDetails>
			orderByComparator);

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
	public java.util.List<InstaOtherDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InstaOtherDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the insta other detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of insta other detailses.
	 *
	 * @return the number of insta other detailses
	 */
	public int countAll();

}