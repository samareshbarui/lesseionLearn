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

package jwc.insta.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import jwc.insta.exception.NoSuchInstaSiteImagesException;
import jwc.insta.model.InstaSiteImages;
import jwc.insta.model.impl.InstaSiteImagesImpl;
import jwc.insta.model.impl.InstaSiteImagesModelImpl;
import jwc.insta.service.persistence.InstaSiteImagesPersistence;
import jwc.insta.service.persistence.impl.constants.JWCPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the insta site images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = InstaSiteImagesPersistence.class)
public class InstaSiteImagesPersistenceImpl
	extends BasePersistenceImpl<InstaSiteImages>
	implements InstaSiteImagesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InstaSiteImagesUtil</code> to access the insta site images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InstaSiteImagesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByInstaimageUrl;
	private FinderPath _finderPathCountByInstaimageUrl;

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages findByInstaimageUrl(String instaimageUrl)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = fetchByInstaimageUrl(instaimageUrl);

		if (instaSiteImages == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("instaimageUrl=");
			sb.append(instaimageUrl);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInstaSiteImagesException(sb.toString());
		}

		return instaSiteImages;
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages fetchByInstaimageUrl(String instaimageUrl) {
		return fetchByInstaimageUrl(instaimageUrl, true);
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages fetchByInstaimageUrl(
		String instaimageUrl, boolean useFinderCache) {

		instaimageUrl = Objects.toString(instaimageUrl, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {instaimageUrl};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByInstaimageUrl, finderArgs, this);
		}

		if (result instanceof InstaSiteImages) {
			InstaSiteImages instaSiteImages = (InstaSiteImages)result;

			if (!Objects.equals(
					instaimageUrl, instaSiteImages.getInstaimageUrl())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_INSTASITEIMAGES_WHERE);

			boolean bindInstaimageUrl = false;

			if (instaimageUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSTAIMAGEURL_INSTAIMAGEURL_3);
			}
			else {
				bindInstaimageUrl = true;

				sb.append(_FINDER_COLUMN_INSTAIMAGEURL_INSTAIMAGEURL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInstaimageUrl) {
					queryPos.add(instaimageUrl);
				}

				List<InstaSiteImages> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByInstaimageUrl, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {instaimageUrl};
							}

							_log.warn(
								"InstaSiteImagesPersistenceImpl.fetchByInstaimageUrl(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					InstaSiteImages instaSiteImages = list.get(0);

					result = instaSiteImages;

					cacheResult(instaSiteImages);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByInstaimageUrl, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (InstaSiteImages)result;
		}
	}

	/**
	 * Removes the insta site images where instaimageUrl = &#63; from the database.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the insta site images that was removed
	 */
	@Override
	public InstaSiteImages removeByInstaimageUrl(String instaimageUrl)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = findByInstaimageUrl(instaimageUrl);

		return remove(instaSiteImages);
	}

	/**
	 * Returns the number of insta site imageses where instaimageUrl = &#63;.
	 *
	 * @param instaimageUrl the instaimage url
	 * @return the number of matching insta site imageses
	 */
	@Override
	public int countByInstaimageUrl(String instaimageUrl) {
		instaimageUrl = Objects.toString(instaimageUrl, "");

		FinderPath finderPath = _finderPathCountByInstaimageUrl;

		Object[] finderArgs = new Object[] {instaimageUrl};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTASITEIMAGES_WHERE);

			boolean bindInstaimageUrl = false;

			if (instaimageUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSTAIMAGEURL_INSTAIMAGEURL_3);
			}
			else {
				bindInstaimageUrl = true;

				sb.append(_FINDER_COLUMN_INSTAIMAGEURL_INSTAIMAGEURL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInstaimageUrl) {
					queryPos.add(instaimageUrl);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INSTAIMAGEURL_INSTAIMAGEURL_2 =
		"instaSiteImages.instaimageUrl = ?";

	private static final String _FINDER_COLUMN_INSTAIMAGEURL_INSTAIMAGEURL_3 =
		"(instaSiteImages.instaimageUrl IS NULL OR instaSiteImages.instaimageUrl = '')";

	private FinderPath _finderPathWithPaginationFindBypageKey;
	private FinderPath _finderPathWithoutPaginationFindBypageKey;
	private FinderPath _finderPathCountBypageKey;

	/**
	 * Returns all the insta site imageses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the matching insta site imageses
	 */
	@Override
	public List<InstaSiteImages> findBypageKey(String pageKey) {
		return findBypageKey(
			pageKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end) {

		return findBypageKey(pageKey, start, end, null);
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
	@Override
	public List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator) {

		return findBypageKey(pageKey, start, end, orderByComparator, true);
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
	@Override
	public List<InstaSiteImages> findBypageKey(
		String pageKey, int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator,
		boolean useFinderCache) {

		pageKey = Objects.toString(pageKey, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypageKey;
				finderArgs = new Object[] {pageKey};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypageKey;
			finderArgs = new Object[] {pageKey, start, end, orderByComparator};
		}

		List<InstaSiteImages> list = null;

		if (useFinderCache) {
			list = (List<InstaSiteImages>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InstaSiteImages instaSiteImages : list) {
					if (!pageKey.equals(instaSiteImages.getPageKey())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_INSTASITEIMAGES_WHERE);

			boolean bindPageKey = false;

			if (pageKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_PAGEKEY_PAGEKEY_3);
			}
			else {
				bindPageKey = true;

				sb.append(_FINDER_COLUMN_PAGEKEY_PAGEKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstaSiteImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPageKey) {
					queryPos.add(pageKey);
				}

				list = (List<InstaSiteImages>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages findBypageKey_First(
			String pageKey,
			OrderByComparator<InstaSiteImages> orderByComparator)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = fetchBypageKey_First(
			pageKey, orderByComparator);

		if (instaSiteImages != null) {
			return instaSiteImages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pageKey=");
		sb.append(pageKey);

		sb.append("}");

		throw new NoSuchInstaSiteImagesException(sb.toString());
	}

	/**
	 * Returns the first insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages fetchBypageKey_First(
		String pageKey, OrderByComparator<InstaSiteImages> orderByComparator) {

		List<InstaSiteImages> list = findBypageKey(
			pageKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages findBypageKey_Last(
			String pageKey,
			OrderByComparator<InstaSiteImages> orderByComparator)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = fetchBypageKey_Last(
			pageKey, orderByComparator);

		if (instaSiteImages != null) {
			return instaSiteImages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pageKey=");
		sb.append(pageKey);

		sb.append("}");

		throw new NoSuchInstaSiteImagesException(sb.toString());
	}

	/**
	 * Returns the last insta site images in the ordered set where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages fetchBypageKey_Last(
		String pageKey, OrderByComparator<InstaSiteImages> orderByComparator) {

		int count = countBypageKey(pageKey);

		if (count == 0) {
			return null;
		}

		List<InstaSiteImages> list = findBypageKey(
			pageKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InstaSiteImages[] findBypageKey_PrevAndNext(
			long instaSiteImageId, String pageKey,
			OrderByComparator<InstaSiteImages> orderByComparator)
		throws NoSuchInstaSiteImagesException {

		pageKey = Objects.toString(pageKey, "");

		InstaSiteImages instaSiteImages = findByPrimaryKey(instaSiteImageId);

		Session session = null;

		try {
			session = openSession();

			InstaSiteImages[] array = new InstaSiteImagesImpl[3];

			array[0] = getBypageKey_PrevAndNext(
				session, instaSiteImages, pageKey, orderByComparator, true);

			array[1] = instaSiteImages;

			array[2] = getBypageKey_PrevAndNext(
				session, instaSiteImages, pageKey, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected InstaSiteImages getBypageKey_PrevAndNext(
		Session session, InstaSiteImages instaSiteImages, String pageKey,
		OrderByComparator<InstaSiteImages> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTASITEIMAGES_WHERE);

		boolean bindPageKey = false;

		if (pageKey.isEmpty()) {
			sb.append(_FINDER_COLUMN_PAGEKEY_PAGEKEY_3);
		}
		else {
			bindPageKey = true;

			sb.append(_FINDER_COLUMN_PAGEKEY_PAGEKEY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(InstaSiteImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPageKey) {
			queryPos.add(pageKey);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						instaSiteImages)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InstaSiteImages> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the insta site imageses where pageKey = &#63; from the database.
	 *
	 * @param pageKey the page key
	 */
	@Override
	public void removeBypageKey(String pageKey) {
		for (InstaSiteImages instaSiteImages :
				findBypageKey(
					pageKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(instaSiteImages);
		}
	}

	/**
	 * Returns the number of insta site imageses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the number of matching insta site imageses
	 */
	@Override
	public int countBypageKey(String pageKey) {
		pageKey = Objects.toString(pageKey, "");

		FinderPath finderPath = _finderPathCountBypageKey;

		Object[] finderArgs = new Object[] {pageKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTASITEIMAGES_WHERE);

			boolean bindPageKey = false;

			if (pageKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_PAGEKEY_PAGEKEY_3);
			}
			else {
				bindPageKey = true;

				sb.append(_FINDER_COLUMN_PAGEKEY_PAGEKEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPageKey) {
					queryPos.add(pageKey);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PAGEKEY_PAGEKEY_2 =
		"instaSiteImages.pageKey = ?";

	private static final String _FINDER_COLUMN_PAGEKEY_PAGEKEY_3 =
		"(instaSiteImages.pageKey IS NULL OR instaSiteImages.pageKey = '')";

	private FinderPath _finderPathFetchBylinksTimestamp;
	private FinderPath _finderPathCountBylinksTimestamp;

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the matching insta site images
	 * @throws NoSuchInstaSiteImagesException if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages findBylinksTimestamp(
			String instaimageUrl, String mediaUrl, String timestamp)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = fetchBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp);

		if (instaSiteImages == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("instaimageUrl=");
			sb.append(instaimageUrl);

			sb.append(", mediaUrl=");
			sb.append(mediaUrl);

			sb.append(", timestamp=");
			sb.append(timestamp);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInstaSiteImagesException(sb.toString());
		}

		return instaSiteImages;
	}

	/**
	 * Returns the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the matching insta site images, or <code>null</code> if a matching insta site images could not be found
	 */
	@Override
	public InstaSiteImages fetchBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp) {

		return fetchBylinksTimestamp(instaimageUrl, mediaUrl, timestamp, true);
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
	@Override
	public InstaSiteImages fetchBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp,
		boolean useFinderCache) {

		instaimageUrl = Objects.toString(instaimageUrl, "");
		mediaUrl = Objects.toString(mediaUrl, "");
		timestamp = Objects.toString(timestamp, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {instaimageUrl, mediaUrl, timestamp};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBylinksTimestamp, finderArgs, this);
		}

		if (result instanceof InstaSiteImages) {
			InstaSiteImages instaSiteImages = (InstaSiteImages)result;

			if (!Objects.equals(
					instaimageUrl, instaSiteImages.getInstaimageUrl()) ||
				!Objects.equals(mediaUrl, instaSiteImages.getMediaUrl()) ||
				!Objects.equals(timestamp, instaSiteImages.getTimestamp())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_INSTASITEIMAGES_WHERE);

			boolean bindInstaimageUrl = false;

			if (instaimageUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_INSTAIMAGEURL_3);
			}
			else {
				bindInstaimageUrl = true;

				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_INSTAIMAGEURL_2);
			}

			boolean bindMediaUrl = false;

			if (mediaUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_MEDIAURL_3);
			}
			else {
				bindMediaUrl = true;

				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_MEDIAURL_2);
			}

			boolean bindTimestamp = false;

			if (timestamp.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_TIMESTAMP_3);
			}
			else {
				bindTimestamp = true;

				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_TIMESTAMP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInstaimageUrl) {
					queryPos.add(instaimageUrl);
				}

				if (bindMediaUrl) {
					queryPos.add(mediaUrl);
				}

				if (bindTimestamp) {
					queryPos.add(timestamp);
				}

				List<InstaSiteImages> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBylinksTimestamp, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									instaimageUrl, mediaUrl, timestamp
								};
							}

							_log.warn(
								"InstaSiteImagesPersistenceImpl.fetchBylinksTimestamp(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					InstaSiteImages instaSiteImages = list.get(0);

					result = instaSiteImages;

					cacheResult(instaSiteImages);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBylinksTimestamp, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (InstaSiteImages)result;
		}
	}

	/**
	 * Removes the insta site images where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63; from the database.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the insta site images that was removed
	 */
	@Override
	public InstaSiteImages removeBylinksTimestamp(
			String instaimageUrl, String mediaUrl, String timestamp)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = findBylinksTimestamp(
			instaimageUrl, mediaUrl, timestamp);

		return remove(instaSiteImages);
	}

	/**
	 * Returns the number of insta site imageses where instaimageUrl = &#63; and mediaUrl = &#63; and timestamp = &#63;.
	 *
	 * @param instaimageUrl the instaimage url
	 * @param mediaUrl the media url
	 * @param timestamp the timestamp
	 * @return the number of matching insta site imageses
	 */
	@Override
	public int countBylinksTimestamp(
		String instaimageUrl, String mediaUrl, String timestamp) {

		instaimageUrl = Objects.toString(instaimageUrl, "");
		mediaUrl = Objects.toString(mediaUrl, "");
		timestamp = Objects.toString(timestamp, "");

		FinderPath finderPath = _finderPathCountBylinksTimestamp;

		Object[] finderArgs = new Object[] {instaimageUrl, mediaUrl, timestamp};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_INSTASITEIMAGES_WHERE);

			boolean bindInstaimageUrl = false;

			if (instaimageUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_INSTAIMAGEURL_3);
			}
			else {
				bindInstaimageUrl = true;

				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_INSTAIMAGEURL_2);
			}

			boolean bindMediaUrl = false;

			if (mediaUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_MEDIAURL_3);
			}
			else {
				bindMediaUrl = true;

				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_MEDIAURL_2);
			}

			boolean bindTimestamp = false;

			if (timestamp.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_TIMESTAMP_3);
			}
			else {
				bindTimestamp = true;

				sb.append(_FINDER_COLUMN_LINKSTIMESTAMP_TIMESTAMP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInstaimageUrl) {
					queryPos.add(instaimageUrl);
				}

				if (bindMediaUrl) {
					queryPos.add(mediaUrl);
				}

				if (bindTimestamp) {
					queryPos.add(timestamp);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LINKSTIMESTAMP_INSTAIMAGEURL_2 =
		"instaSiteImages.instaimageUrl = ? AND ";

	private static final String _FINDER_COLUMN_LINKSTIMESTAMP_INSTAIMAGEURL_3 =
		"(instaSiteImages.instaimageUrl IS NULL OR instaSiteImages.instaimageUrl = '') AND ";

	private static final String _FINDER_COLUMN_LINKSTIMESTAMP_MEDIAURL_2 =
		"instaSiteImages.mediaUrl = ? AND ";

	private static final String _FINDER_COLUMN_LINKSTIMESTAMP_MEDIAURL_3 =
		"(instaSiteImages.mediaUrl IS NULL OR instaSiteImages.mediaUrl = '') AND ";

	private static final String _FINDER_COLUMN_LINKSTIMESTAMP_TIMESTAMP_2 =
		"instaSiteImages.timestamp = ?";

	private static final String _FINDER_COLUMN_LINKSTIMESTAMP_TIMESTAMP_3 =
		"(instaSiteImages.timestamp IS NULL OR instaSiteImages.timestamp = '')";

	public InstaSiteImagesPersistenceImpl() {
		setModelClass(InstaSiteImages.class);

		setModelImplClass(InstaSiteImagesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the insta site images in the entity cache if it is enabled.
	 *
	 * @param instaSiteImages the insta site images
	 */
	@Override
	public void cacheResult(InstaSiteImages instaSiteImages) {
		entityCache.putResult(
			entityCacheEnabled, InstaSiteImagesImpl.class,
			instaSiteImages.getPrimaryKey(), instaSiteImages);

		finderCache.putResult(
			_finderPathFetchByInstaimageUrl,
			new Object[] {instaSiteImages.getInstaimageUrl()}, instaSiteImages);

		finderCache.putResult(
			_finderPathFetchBylinksTimestamp,
			new Object[] {
				instaSiteImages.getInstaimageUrl(),
				instaSiteImages.getMediaUrl(), instaSiteImages.getTimestamp()
			},
			instaSiteImages);

		instaSiteImages.resetOriginalValues();
	}

	/**
	 * Caches the insta site imageses in the entity cache if it is enabled.
	 *
	 * @param instaSiteImageses the insta site imageses
	 */
	@Override
	public void cacheResult(List<InstaSiteImages> instaSiteImageses) {
		for (InstaSiteImages instaSiteImages : instaSiteImageses) {
			if (entityCache.getResult(
					entityCacheEnabled, InstaSiteImagesImpl.class,
					instaSiteImages.getPrimaryKey()) == null) {

				cacheResult(instaSiteImages);
			}
			else {
				instaSiteImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all insta site imageses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InstaSiteImagesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the insta site images.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InstaSiteImages instaSiteImages) {
		entityCache.removeResult(
			entityCacheEnabled, InstaSiteImagesImpl.class,
			instaSiteImages.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(InstaSiteImagesModelImpl)instaSiteImages, true);
	}

	@Override
	public void clearCache(List<InstaSiteImages> instaSiteImageses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InstaSiteImages instaSiteImages : instaSiteImageses) {
			entityCache.removeResult(
				entityCacheEnabled, InstaSiteImagesImpl.class,
				instaSiteImages.getPrimaryKey());

			clearUniqueFindersCache(
				(InstaSiteImagesModelImpl)instaSiteImages, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, InstaSiteImagesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		InstaSiteImagesModelImpl instaSiteImagesModelImpl) {

		Object[] args = new Object[] {
			instaSiteImagesModelImpl.getInstaimageUrl()
		};

		finderCache.putResult(
			_finderPathCountByInstaimageUrl, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByInstaimageUrl, args, instaSiteImagesModelImpl,
			false);

		args = new Object[] {
			instaSiteImagesModelImpl.getInstaimageUrl(),
			instaSiteImagesModelImpl.getMediaUrl(),
			instaSiteImagesModelImpl.getTimestamp()
		};

		finderCache.putResult(
			_finderPathCountBylinksTimestamp, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBylinksTimestamp, args, instaSiteImagesModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		InstaSiteImagesModelImpl instaSiteImagesModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				instaSiteImagesModelImpl.getInstaimageUrl()
			};

			finderCache.removeResult(_finderPathCountByInstaimageUrl, args);
			finderCache.removeResult(_finderPathFetchByInstaimageUrl, args);
		}

		if ((instaSiteImagesModelImpl.getColumnBitmask() &
			 _finderPathFetchByInstaimageUrl.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				instaSiteImagesModelImpl.getOriginalInstaimageUrl()
			};

			finderCache.removeResult(_finderPathCountByInstaimageUrl, args);
			finderCache.removeResult(_finderPathFetchByInstaimageUrl, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				instaSiteImagesModelImpl.getInstaimageUrl(),
				instaSiteImagesModelImpl.getMediaUrl(),
				instaSiteImagesModelImpl.getTimestamp()
			};

			finderCache.removeResult(_finderPathCountBylinksTimestamp, args);
			finderCache.removeResult(_finderPathFetchBylinksTimestamp, args);
		}

		if ((instaSiteImagesModelImpl.getColumnBitmask() &
			 _finderPathFetchBylinksTimestamp.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				instaSiteImagesModelImpl.getOriginalInstaimageUrl(),
				instaSiteImagesModelImpl.getOriginalMediaUrl(),
				instaSiteImagesModelImpl.getOriginalTimestamp()
			};

			finderCache.removeResult(_finderPathCountBylinksTimestamp, args);
			finderCache.removeResult(_finderPathFetchBylinksTimestamp, args);
		}
	}

	/**
	 * Creates a new insta site images with the primary key. Does not add the insta site images to the database.
	 *
	 * @param instaSiteImageId the primary key for the new insta site images
	 * @return the new insta site images
	 */
	@Override
	public InstaSiteImages create(long instaSiteImageId) {
		InstaSiteImages instaSiteImages = new InstaSiteImagesImpl();

		instaSiteImages.setNew(true);
		instaSiteImages.setPrimaryKey(instaSiteImageId);

		return instaSiteImages;
	}

	/**
	 * Removes the insta site images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images that was removed
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	@Override
	public InstaSiteImages remove(long instaSiteImageId)
		throws NoSuchInstaSiteImagesException {

		return remove((Serializable)instaSiteImageId);
	}

	/**
	 * Removes the insta site images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the insta site images
	 * @return the insta site images that was removed
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	@Override
	public InstaSiteImages remove(Serializable primaryKey)
		throws NoSuchInstaSiteImagesException {

		Session session = null;

		try {
			session = openSession();

			InstaSiteImages instaSiteImages = (InstaSiteImages)session.get(
				InstaSiteImagesImpl.class, primaryKey);

			if (instaSiteImages == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstaSiteImagesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(instaSiteImages);
		}
		catch (NoSuchInstaSiteImagesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected InstaSiteImages removeImpl(InstaSiteImages instaSiteImages) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(instaSiteImages)) {
				instaSiteImages = (InstaSiteImages)session.get(
					InstaSiteImagesImpl.class,
					instaSiteImages.getPrimaryKeyObj());
			}

			if (instaSiteImages != null) {
				session.delete(instaSiteImages);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (instaSiteImages != null) {
			clearCache(instaSiteImages);
		}

		return instaSiteImages;
	}

	@Override
	public InstaSiteImages updateImpl(InstaSiteImages instaSiteImages) {
		boolean isNew = instaSiteImages.isNew();

		if (!(instaSiteImages instanceof InstaSiteImagesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(instaSiteImages.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					instaSiteImages);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in instaSiteImages proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom InstaSiteImages implementation " +
					instaSiteImages.getClass());
		}

		InstaSiteImagesModelImpl instaSiteImagesModelImpl =
			(InstaSiteImagesModelImpl)instaSiteImages;

		Session session = null;

		try {
			session = openSession();

			if (instaSiteImages.isNew()) {
				session.save(instaSiteImages);

				instaSiteImages.setNew(false);
			}
			else {
				instaSiteImages = (InstaSiteImages)session.merge(
					instaSiteImages);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				instaSiteImagesModelImpl.getPageKey()
			};

			finderCache.removeResult(_finderPathCountBypageKey, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBypageKey, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((instaSiteImagesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBypageKey.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					instaSiteImagesModelImpl.getOriginalPageKey()
				};

				finderCache.removeResult(_finderPathCountBypageKey, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypageKey, args);

				args = new Object[] {instaSiteImagesModelImpl.getPageKey()};

				finderCache.removeResult(_finderPathCountBypageKey, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypageKey, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, InstaSiteImagesImpl.class,
			instaSiteImages.getPrimaryKey(), instaSiteImages, false);

		clearUniqueFindersCache(instaSiteImagesModelImpl, false);
		cacheUniqueFindersCache(instaSiteImagesModelImpl);

		instaSiteImages.resetOriginalValues();

		return instaSiteImages;
	}

	/**
	 * Returns the insta site images with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the insta site images
	 * @return the insta site images
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	@Override
	public InstaSiteImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstaSiteImagesException {

		InstaSiteImages instaSiteImages = fetchByPrimaryKey(primaryKey);

		if (instaSiteImages == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstaSiteImagesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return instaSiteImages;
	}

	/**
	 * Returns the insta site images with the primary key or throws a <code>NoSuchInstaSiteImagesException</code> if it could not be found.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images
	 * @throws NoSuchInstaSiteImagesException if a insta site images with the primary key could not be found
	 */
	@Override
	public InstaSiteImages findByPrimaryKey(long instaSiteImageId)
		throws NoSuchInstaSiteImagesException {

		return findByPrimaryKey((Serializable)instaSiteImageId);
	}

	/**
	 * Returns the insta site images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param instaSiteImageId the primary key of the insta site images
	 * @return the insta site images, or <code>null</code> if a insta site images with the primary key could not be found
	 */
	@Override
	public InstaSiteImages fetchByPrimaryKey(long instaSiteImageId) {
		return fetchByPrimaryKey((Serializable)instaSiteImageId);
	}

	/**
	 * Returns all the insta site imageses.
	 *
	 * @return the insta site imageses
	 */
	@Override
	public List<InstaSiteImages> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InstaSiteImages> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<InstaSiteImages> findAll(
		int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<InstaSiteImages> findAll(
		int start, int end,
		OrderByComparator<InstaSiteImages> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<InstaSiteImages> list = null;

		if (useFinderCache) {
			list = (List<InstaSiteImages>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INSTASITEIMAGES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INSTASITEIMAGES;

				sql = sql.concat(InstaSiteImagesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InstaSiteImages>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the insta site imageses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InstaSiteImages instaSiteImages : findAll()) {
			remove(instaSiteImages);
		}
	}

	/**
	 * Returns the number of insta site imageses.
	 *
	 * @return the number of insta site imageses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INSTASITEIMAGES);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "instaSiteImageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INSTASITEIMAGES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InstaSiteImagesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the insta site images persistence.
	 */
	@Activate
	public void activate() {
		InstaSiteImagesModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		InstaSiteImagesModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaSiteImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaSiteImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByInstaimageUrl = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaSiteImagesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByInstaimageUrl",
			new String[] {String.class.getName()},
			InstaSiteImagesModelImpl.INSTAIMAGEURL_COLUMN_BITMASK);

		_finderPathCountByInstaimageUrl = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstaimageUrl",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBypageKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaSiteImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypageKey",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBypageKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaSiteImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypageKey",
			new String[] {String.class.getName()},
			InstaSiteImagesModelImpl.PAGEKEY_COLUMN_BITMASK);

		_finderPathCountBypageKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypageKey",
			new String[] {String.class.getName()});

		_finderPathFetchBylinksTimestamp = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaSiteImagesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBylinksTimestamp",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			InstaSiteImagesModelImpl.INSTAIMAGEURL_COLUMN_BITMASK |
			InstaSiteImagesModelImpl.MEDIAURL_COLUMN_BITMASK |
			InstaSiteImagesModelImpl.TIMESTAMP_COLUMN_BITMASK);

		_finderPathCountBylinksTimestamp = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylinksTimestamp",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(InstaSiteImagesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = JWCPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.jwc.insta.model.InstaSiteImages"),
			true);
	}

	@Override
	@Reference(
		target = JWCPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = JWCPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INSTASITEIMAGES =
		"SELECT instaSiteImages FROM InstaSiteImages instaSiteImages";

	private static final String _SQL_SELECT_INSTASITEIMAGES_WHERE =
		"SELECT instaSiteImages FROM InstaSiteImages instaSiteImages WHERE ";

	private static final String _SQL_COUNT_INSTASITEIMAGES =
		"SELECT COUNT(instaSiteImages) FROM InstaSiteImages instaSiteImages";

	private static final String _SQL_COUNT_INSTASITEIMAGES_WHERE =
		"SELECT COUNT(instaSiteImages) FROM InstaSiteImages instaSiteImages WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "instaSiteImages.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InstaSiteImages exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No InstaSiteImages exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InstaSiteImagesPersistenceImpl.class);

	static {
		try {
			Class.forName(JWCPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}