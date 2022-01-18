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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import jwc.insta.exception.NoSuchInstaOtherDetailsException;
import jwc.insta.model.InstaOtherDetails;
import jwc.insta.model.impl.InstaOtherDetailsImpl;
import jwc.insta.model.impl.InstaOtherDetailsModelImpl;
import jwc.insta.service.persistence.InstaOtherDetailsPersistence;
import jwc.insta.service.persistence.impl.constants.JWCPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the insta other details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = InstaOtherDetailsPersistence.class)
public class InstaOtherDetailsPersistenceImpl
	extends BasePersistenceImpl<InstaOtherDetails>
	implements InstaOtherDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InstaOtherDetailsUtil</code> to access the insta other details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InstaOtherDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public InstaOtherDetailsPersistenceImpl() {
		setModelClass(InstaOtherDetails.class);

		setModelImplClass(InstaOtherDetailsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the insta other details in the entity cache if it is enabled.
	 *
	 * @param instaOtherDetails the insta other details
	 */
	@Override
	public void cacheResult(InstaOtherDetails instaOtherDetails) {
		entityCache.putResult(
			entityCacheEnabled, InstaOtherDetailsImpl.class,
			instaOtherDetails.getPrimaryKey(), instaOtherDetails);

		instaOtherDetails.resetOriginalValues();
	}

	/**
	 * Caches the insta other detailses in the entity cache if it is enabled.
	 *
	 * @param instaOtherDetailses the insta other detailses
	 */
	@Override
	public void cacheResult(List<InstaOtherDetails> instaOtherDetailses) {
		for (InstaOtherDetails instaOtherDetails : instaOtherDetailses) {
			if (entityCache.getResult(
					entityCacheEnabled, InstaOtherDetailsImpl.class,
					instaOtherDetails.getPrimaryKey()) == null) {

				cacheResult(instaOtherDetails);
			}
			else {
				instaOtherDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all insta other detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InstaOtherDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the insta other details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InstaOtherDetails instaOtherDetails) {
		entityCache.removeResult(
			entityCacheEnabled, InstaOtherDetailsImpl.class,
			instaOtherDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InstaOtherDetails> instaOtherDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InstaOtherDetails instaOtherDetails : instaOtherDetailses) {
			entityCache.removeResult(
				entityCacheEnabled, InstaOtherDetailsImpl.class,
				instaOtherDetails.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, InstaOtherDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new insta other details with the primary key. Does not add the insta other details to the database.
	 *
	 * @param otherDetid the primary key for the new insta other details
	 * @return the new insta other details
	 */
	@Override
	public InstaOtherDetails create(long otherDetid) {
		InstaOtherDetails instaOtherDetails = new InstaOtherDetailsImpl();

		instaOtherDetails.setNew(true);
		instaOtherDetails.setPrimaryKey(otherDetid);

		return instaOtherDetails;
	}

	/**
	 * Removes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	@Override
	public InstaOtherDetails remove(long otherDetid)
		throws NoSuchInstaOtherDetailsException {

		return remove((Serializable)otherDetid);
	}

	/**
	 * Removes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	@Override
	public InstaOtherDetails remove(Serializable primaryKey)
		throws NoSuchInstaOtherDetailsException {

		Session session = null;

		try {
			session = openSession();

			InstaOtherDetails instaOtherDetails =
				(InstaOtherDetails)session.get(
					InstaOtherDetailsImpl.class, primaryKey);

			if (instaOtherDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstaOtherDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(instaOtherDetails);
		}
		catch (NoSuchInstaOtherDetailsException noSuchEntityException) {
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
	protected InstaOtherDetails removeImpl(
		InstaOtherDetails instaOtherDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(instaOtherDetails)) {
				instaOtherDetails = (InstaOtherDetails)session.get(
					InstaOtherDetailsImpl.class,
					instaOtherDetails.getPrimaryKeyObj());
			}

			if (instaOtherDetails != null) {
				session.delete(instaOtherDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (instaOtherDetails != null) {
			clearCache(instaOtherDetails);
		}

		return instaOtherDetails;
	}

	@Override
	public InstaOtherDetails updateImpl(InstaOtherDetails instaOtherDetails) {
		boolean isNew = instaOtherDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (instaOtherDetails.isNew()) {
				session.save(instaOtherDetails);

				instaOtherDetails.setNew(false);
			}
			else {
				instaOtherDetails = (InstaOtherDetails)session.merge(
					instaOtherDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, InstaOtherDetailsImpl.class,
			instaOtherDetails.getPrimaryKey(), instaOtherDetails, false);

		instaOtherDetails.resetOriginalValues();

		return instaOtherDetails;
	}

	/**
	 * Returns the insta other details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the insta other details
	 * @return the insta other details
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	@Override
	public InstaOtherDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstaOtherDetailsException {

		InstaOtherDetails instaOtherDetails = fetchByPrimaryKey(primaryKey);

		if (instaOtherDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstaOtherDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return instaOtherDetails;
	}

	/**
	 * Returns the insta other details with the primary key or throws a <code>NoSuchInstaOtherDetailsException</code> if it could not be found.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details
	 * @throws NoSuchInstaOtherDetailsException if a insta other details with the primary key could not be found
	 */
	@Override
	public InstaOtherDetails findByPrimaryKey(long otherDetid)
		throws NoSuchInstaOtherDetailsException {

		return findByPrimaryKey((Serializable)otherDetid);
	}

	/**
	 * Returns the insta other details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details, or <code>null</code> if a insta other details with the primary key could not be found
	 */
	@Override
	public InstaOtherDetails fetchByPrimaryKey(long otherDetid) {
		return fetchByPrimaryKey((Serializable)otherDetid);
	}

	/**
	 * Returns all the insta other detailses.
	 *
	 * @return the insta other detailses
	 */
	@Override
	public List<InstaOtherDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InstaOtherDetails> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<InstaOtherDetails> findAll(
		int start, int end,
		OrderByComparator<InstaOtherDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<InstaOtherDetails> findAll(
		int start, int end,
		OrderByComparator<InstaOtherDetails> orderByComparator,
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

		List<InstaOtherDetails> list = null;

		if (useFinderCache) {
			list = (List<InstaOtherDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INSTAOTHERDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INSTAOTHERDETAILS;

				sql = sql.concat(InstaOtherDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InstaOtherDetails>)QueryUtil.list(
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
	 * Removes all the insta other detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InstaOtherDetails instaOtherDetails : findAll()) {
			remove(instaOtherDetails);
		}
	}

	/**
	 * Returns the number of insta other detailses.
	 *
	 * @return the number of insta other detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INSTAOTHERDETAILS);

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
		return "otherDetid";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INSTAOTHERDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InstaOtherDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the insta other details persistence.
	 */
	@Activate
	public void activate() {
		InstaOtherDetailsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		InstaOtherDetailsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaOtherDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, InstaOtherDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(InstaOtherDetailsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.jwc.insta.model.InstaOtherDetails"),
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

	private static final String _SQL_SELECT_INSTAOTHERDETAILS =
		"SELECT instaOtherDetails FROM InstaOtherDetails instaOtherDetails";

	private static final String _SQL_COUNT_INSTAOTHERDETAILS =
		"SELECT COUNT(instaOtherDetails) FROM InstaOtherDetails instaOtherDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS = "instaOtherDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InstaOtherDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		InstaOtherDetailsPersistenceImpl.class);

	static {
		try {
			Class.forName(JWCPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}