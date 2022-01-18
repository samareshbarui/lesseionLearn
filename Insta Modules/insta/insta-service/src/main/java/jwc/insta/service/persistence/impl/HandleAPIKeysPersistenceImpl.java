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

import jwc.insta.exception.NoSuchHandleAPIKeysException;
import jwc.insta.model.HandleAPIKeys;
import jwc.insta.model.impl.HandleAPIKeysImpl;
import jwc.insta.model.impl.HandleAPIKeysModelImpl;
import jwc.insta.service.persistence.HandleAPIKeysPersistence;
import jwc.insta.service.persistence.impl.constants.JWCPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the handle api keys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = HandleAPIKeysPersistence.class)
public class HandleAPIKeysPersistenceImpl
	extends BasePersistenceImpl<HandleAPIKeys>
	implements HandleAPIKeysPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HandleAPIKeysUtil</code> to access the handle api keys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HandleAPIKeysImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByPageKey;
	private FinderPath _finderPathCountByPageKey;

	/**
	 * Returns the handle api keys where pageKey = &#63; or throws a <code>NoSuchHandleAPIKeysException</code> if it could not be found.
	 *
	 * @param pageKey the page key
	 * @return the matching handle api keys
	 * @throws NoSuchHandleAPIKeysException if a matching handle api keys could not be found
	 */
	@Override
	public HandleAPIKeys findByPageKey(String pageKey)
		throws NoSuchHandleAPIKeysException {

		HandleAPIKeys handleAPIKeys = fetchByPageKey(pageKey);

		if (handleAPIKeys == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("pageKey=");
			sb.append(pageKey);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHandleAPIKeysException(sb.toString());
		}

		return handleAPIKeys;
	}

	/**
	 * Returns the handle api keys where pageKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pageKey the page key
	 * @return the matching handle api keys, or <code>null</code> if a matching handle api keys could not be found
	 */
	@Override
	public HandleAPIKeys fetchByPageKey(String pageKey) {
		return fetchByPageKey(pageKey, true);
	}

	/**
	 * Returns the handle api keys where pageKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pageKey the page key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching handle api keys, or <code>null</code> if a matching handle api keys could not be found
	 */
	@Override
	public HandleAPIKeys fetchByPageKey(
		String pageKey, boolean useFinderCache) {

		pageKey = Objects.toString(pageKey, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {pageKey};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPageKey, finderArgs, this);
		}

		if (result instanceof HandleAPIKeys) {
			HandleAPIKeys handleAPIKeys = (HandleAPIKeys)result;

			if (!Objects.equals(pageKey, handleAPIKeys.getPageKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_HANDLEAPIKEYS_WHERE);

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

				List<HandleAPIKeys> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPageKey, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {pageKey};
							}

							_log.warn(
								"HandleAPIKeysPersistenceImpl.fetchByPageKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					HandleAPIKeys handleAPIKeys = list.get(0);

					result = handleAPIKeys;

					cacheResult(handleAPIKeys);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByPageKey, finderArgs);
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
			return (HandleAPIKeys)result;
		}
	}

	/**
	 * Removes the handle api keys where pageKey = &#63; from the database.
	 *
	 * @param pageKey the page key
	 * @return the handle api keys that was removed
	 */
	@Override
	public HandleAPIKeys removeByPageKey(String pageKey)
		throws NoSuchHandleAPIKeysException {

		HandleAPIKeys handleAPIKeys = findByPageKey(pageKey);

		return remove(handleAPIKeys);
	}

	/**
	 * Returns the number of handle api keyses where pageKey = &#63;.
	 *
	 * @param pageKey the page key
	 * @return the number of matching handle api keyses
	 */
	@Override
	public int countByPageKey(String pageKey) {
		pageKey = Objects.toString(pageKey, "");

		FinderPath finderPath = _finderPathCountByPageKey;

		Object[] finderArgs = new Object[] {pageKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HANDLEAPIKEYS_WHERE);

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
		"handleAPIKeys.pageKey = ?";

	private static final String _FINDER_COLUMN_PAGEKEY_PAGEKEY_3 =
		"(handleAPIKeys.pageKey IS NULL OR handleAPIKeys.pageKey = '')";

	public HandleAPIKeysPersistenceImpl() {
		setModelClass(HandleAPIKeys.class);

		setModelImplClass(HandleAPIKeysImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the handle api keys in the entity cache if it is enabled.
	 *
	 * @param handleAPIKeys the handle api keys
	 */
	@Override
	public void cacheResult(HandleAPIKeys handleAPIKeys) {
		entityCache.putResult(
			entityCacheEnabled, HandleAPIKeysImpl.class,
			handleAPIKeys.getPrimaryKey(), handleAPIKeys);

		finderCache.putResult(
			_finderPathFetchByPageKey,
			new Object[] {handleAPIKeys.getPageKey()}, handleAPIKeys);

		handleAPIKeys.resetOriginalValues();
	}

	/**
	 * Caches the handle api keyses in the entity cache if it is enabled.
	 *
	 * @param handleAPIKeyses the handle api keyses
	 */
	@Override
	public void cacheResult(List<HandleAPIKeys> handleAPIKeyses) {
		for (HandleAPIKeys handleAPIKeys : handleAPIKeyses) {
			if (entityCache.getResult(
					entityCacheEnabled, HandleAPIKeysImpl.class,
					handleAPIKeys.getPrimaryKey()) == null) {

				cacheResult(handleAPIKeys);
			}
			else {
				handleAPIKeys.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all handle api keyses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HandleAPIKeysImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the handle api keys.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HandleAPIKeys handleAPIKeys) {
		entityCache.removeResult(
			entityCacheEnabled, HandleAPIKeysImpl.class,
			handleAPIKeys.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((HandleAPIKeysModelImpl)handleAPIKeys, true);
	}

	@Override
	public void clearCache(List<HandleAPIKeys> handleAPIKeyses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HandleAPIKeys handleAPIKeys : handleAPIKeyses) {
			entityCache.removeResult(
				entityCacheEnabled, HandleAPIKeysImpl.class,
				handleAPIKeys.getPrimaryKey());

			clearUniqueFindersCache(
				(HandleAPIKeysModelImpl)handleAPIKeys, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, HandleAPIKeysImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		HandleAPIKeysModelImpl handleAPIKeysModelImpl) {

		Object[] args = new Object[] {handleAPIKeysModelImpl.getPageKey()};

		finderCache.putResult(
			_finderPathCountByPageKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByPageKey, args, handleAPIKeysModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		HandleAPIKeysModelImpl handleAPIKeysModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {handleAPIKeysModelImpl.getPageKey()};

			finderCache.removeResult(_finderPathCountByPageKey, args);
			finderCache.removeResult(_finderPathFetchByPageKey, args);
		}

		if ((handleAPIKeysModelImpl.getColumnBitmask() &
			 _finderPathFetchByPageKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				handleAPIKeysModelImpl.getOriginalPageKey()
			};

			finderCache.removeResult(_finderPathCountByPageKey, args);
			finderCache.removeResult(_finderPathFetchByPageKey, args);
		}
	}

	/**
	 * Creates a new handle api keys with the primary key. Does not add the handle api keys to the database.
	 *
	 * @param handleAPIKeyId the primary key for the new handle api keys
	 * @return the new handle api keys
	 */
	@Override
	public HandleAPIKeys create(long handleAPIKeyId) {
		HandleAPIKeys handleAPIKeys = new HandleAPIKeysImpl();

		handleAPIKeys.setNew(true);
		handleAPIKeys.setPrimaryKey(handleAPIKeyId);

		return handleAPIKeys;
	}

	/**
	 * Removes the handle api keys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys that was removed
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	@Override
	public HandleAPIKeys remove(long handleAPIKeyId)
		throws NoSuchHandleAPIKeysException {

		return remove((Serializable)handleAPIKeyId);
	}

	/**
	 * Removes the handle api keys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the handle api keys
	 * @return the handle api keys that was removed
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	@Override
	public HandleAPIKeys remove(Serializable primaryKey)
		throws NoSuchHandleAPIKeysException {

		Session session = null;

		try {
			session = openSession();

			HandleAPIKeys handleAPIKeys = (HandleAPIKeys)session.get(
				HandleAPIKeysImpl.class, primaryKey);

			if (handleAPIKeys == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHandleAPIKeysException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(handleAPIKeys);
		}
		catch (NoSuchHandleAPIKeysException noSuchEntityException) {
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
	protected HandleAPIKeys removeImpl(HandleAPIKeys handleAPIKeys) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(handleAPIKeys)) {
				handleAPIKeys = (HandleAPIKeys)session.get(
					HandleAPIKeysImpl.class, handleAPIKeys.getPrimaryKeyObj());
			}

			if (handleAPIKeys != null) {
				session.delete(handleAPIKeys);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (handleAPIKeys != null) {
			clearCache(handleAPIKeys);
		}

		return handleAPIKeys;
	}

	@Override
	public HandleAPIKeys updateImpl(HandleAPIKeys handleAPIKeys) {
		boolean isNew = handleAPIKeys.isNew();

		if (!(handleAPIKeys instanceof HandleAPIKeysModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(handleAPIKeys.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					handleAPIKeys);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in handleAPIKeys proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HandleAPIKeys implementation " +
					handleAPIKeys.getClass());
		}

		HandleAPIKeysModelImpl handleAPIKeysModelImpl =
			(HandleAPIKeysModelImpl)handleAPIKeys;

		Session session = null;

		try {
			session = openSession();

			if (handleAPIKeys.isNew()) {
				session.save(handleAPIKeys);

				handleAPIKeys.setNew(false);
			}
			else {
				handleAPIKeys = (HandleAPIKeys)session.merge(handleAPIKeys);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, HandleAPIKeysImpl.class,
			handleAPIKeys.getPrimaryKey(), handleAPIKeys, false);

		clearUniqueFindersCache(handleAPIKeysModelImpl, false);
		cacheUniqueFindersCache(handleAPIKeysModelImpl);

		handleAPIKeys.resetOriginalValues();

		return handleAPIKeys;
	}

	/**
	 * Returns the handle api keys with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the handle api keys
	 * @return the handle api keys
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	@Override
	public HandleAPIKeys findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHandleAPIKeysException {

		HandleAPIKeys handleAPIKeys = fetchByPrimaryKey(primaryKey);

		if (handleAPIKeys == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHandleAPIKeysException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return handleAPIKeys;
	}

	/**
	 * Returns the handle api keys with the primary key or throws a <code>NoSuchHandleAPIKeysException</code> if it could not be found.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys
	 * @throws NoSuchHandleAPIKeysException if a handle api keys with the primary key could not be found
	 */
	@Override
	public HandleAPIKeys findByPrimaryKey(long handleAPIKeyId)
		throws NoSuchHandleAPIKeysException {

		return findByPrimaryKey((Serializable)handleAPIKeyId);
	}

	/**
	 * Returns the handle api keys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param handleAPIKeyId the primary key of the handle api keys
	 * @return the handle api keys, or <code>null</code> if a handle api keys with the primary key could not be found
	 */
	@Override
	public HandleAPIKeys fetchByPrimaryKey(long handleAPIKeyId) {
		return fetchByPrimaryKey((Serializable)handleAPIKeyId);
	}

	/**
	 * Returns all the handle api keyses.
	 *
	 * @return the handle api keyses
	 */
	@Override
	public List<HandleAPIKeys> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<HandleAPIKeys> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<HandleAPIKeys> findAll(
		int start, int end,
		OrderByComparator<HandleAPIKeys> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<HandleAPIKeys> findAll(
		int start, int end, OrderByComparator<HandleAPIKeys> orderByComparator,
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

		List<HandleAPIKeys> list = null;

		if (useFinderCache) {
			list = (List<HandleAPIKeys>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HANDLEAPIKEYS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HANDLEAPIKEYS;

				sql = sql.concat(HandleAPIKeysModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HandleAPIKeys>)QueryUtil.list(
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
	 * Removes all the handle api keyses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HandleAPIKeys handleAPIKeys : findAll()) {
			remove(handleAPIKeys);
		}
	}

	/**
	 * Returns the number of handle api keyses.
	 *
	 * @return the number of handle api keyses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HANDLEAPIKEYS);

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
		return "handleAPIKeyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HANDLEAPIKEYS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HandleAPIKeysModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the handle api keys persistence.
	 */
	@Activate
	public void activate() {
		HandleAPIKeysModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		HandleAPIKeysModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, HandleAPIKeysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, HandleAPIKeysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByPageKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, HandleAPIKeysImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPageKey",
			new String[] {String.class.getName()},
			HandleAPIKeysModelImpl.PAGEKEY_COLUMN_BITMASK);

		_finderPathCountByPageKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPageKey",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(HandleAPIKeysImpl.class.getName());
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
				"value.object.column.bitmask.enabled.jwc.insta.model.HandleAPIKeys"),
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

	private static final String _SQL_SELECT_HANDLEAPIKEYS =
		"SELECT handleAPIKeys FROM HandleAPIKeys handleAPIKeys";

	private static final String _SQL_SELECT_HANDLEAPIKEYS_WHERE =
		"SELECT handleAPIKeys FROM HandleAPIKeys handleAPIKeys WHERE ";

	private static final String _SQL_COUNT_HANDLEAPIKEYS =
		"SELECT COUNT(handleAPIKeys) FROM HandleAPIKeys handleAPIKeys";

	private static final String _SQL_COUNT_HANDLEAPIKEYS_WHERE =
		"SELECT COUNT(handleAPIKeys) FROM HandleAPIKeys handleAPIKeys WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "handleAPIKeys.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HandleAPIKeys exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No HandleAPIKeys exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HandleAPIKeysPersistenceImpl.class);

	static {
		try {
			Class.forName(JWCPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}