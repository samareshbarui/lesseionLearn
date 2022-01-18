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

package jwc.insta.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import jwc.insta.model.InstaOtherDetails;
import jwc.insta.service.InstaOtherDetailsLocalService;
import jwc.insta.service.persistence.HandleAPIKeysPersistence;
import jwc.insta.service.persistence.InstaOtherDetailsPersistence;
import jwc.insta.service.persistence.InstaSiteImagesPersistence;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the insta other details local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link jwc.insta.service.impl.InstaOtherDetailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see jwc.insta.service.impl.InstaOtherDetailsLocalServiceImpl
 * @generated
 */
public abstract class InstaOtherDetailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   InstaOtherDetailsLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>InstaOtherDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jwc.insta.service.InstaOtherDetailsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the insta other details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InstaOtherDetails addInstaOtherDetails(
		InstaOtherDetails instaOtherDetails) {

		instaOtherDetails.setNew(true);

		return instaOtherDetailsPersistence.update(instaOtherDetails);
	}

	/**
	 * Creates a new insta other details with the primary key. Does not add the insta other details to the database.
	 *
	 * @param otherDetid the primary key for the new insta other details
	 * @return the new insta other details
	 */
	@Override
	@Transactional(enabled = false)
	public InstaOtherDetails createInstaOtherDetails(long otherDetid) {
		return instaOtherDetailsPersistence.create(otherDetid);
	}

	/**
	 * Deletes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws PortalException if a insta other details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InstaOtherDetails deleteInstaOtherDetails(long otherDetid)
		throws PortalException {

		return instaOtherDetailsPersistence.remove(otherDetid);
	}

	/**
	 * Deletes the insta other details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InstaOtherDetails deleteInstaOtherDetails(
		InstaOtherDetails instaOtherDetails) {

		return instaOtherDetailsPersistence.remove(instaOtherDetails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			InstaOtherDetails.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return instaOtherDetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return instaOtherDetailsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return instaOtherDetailsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return instaOtherDetailsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return instaOtherDetailsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public InstaOtherDetails fetchInstaOtherDetails(long otherDetid) {
		return instaOtherDetailsPersistence.fetchByPrimaryKey(otherDetid);
	}

	/**
	 * Returns the insta other details with the primary key.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details
	 * @throws PortalException if a insta other details with the primary key could not be found
	 */
	@Override
	public InstaOtherDetails getInstaOtherDetails(long otherDetid)
		throws PortalException {

		return instaOtherDetailsPersistence.findByPrimaryKey(otherDetid);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			instaOtherDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InstaOtherDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("otherDetid");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			instaOtherDetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(InstaOtherDetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("otherDetid");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			instaOtherDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InstaOtherDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("otherDetid");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return instaOtherDetailsPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return instaOtherDetailsLocalService.deleteInstaOtherDetails(
			(InstaOtherDetails)persistedModel);
	}

	public BasePersistence<InstaOtherDetails> getBasePersistence() {
		return instaOtherDetailsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return instaOtherDetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the insta other detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jwc.insta.model.impl.InstaOtherDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insta other detailses
	 * @param end the upper bound of the range of insta other detailses (not inclusive)
	 * @return the range of insta other detailses
	 */
	@Override
	public List<InstaOtherDetails> getInstaOtherDetailses(int start, int end) {
		return instaOtherDetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of insta other detailses.
	 *
	 * @return the number of insta other detailses
	 */
	@Override
	public int getInstaOtherDetailsesCount() {
		return instaOtherDetailsPersistence.countAll();
	}

	/**
	 * Updates the insta other details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InstaOtherDetails updateInstaOtherDetails(
		InstaOtherDetails instaOtherDetails) {

		return instaOtherDetailsPersistence.update(instaOtherDetails);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			InstaOtherDetailsLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		instaOtherDetailsLocalService = (InstaOtherDetailsLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return InstaOtherDetailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return InstaOtherDetails.class;
	}

	protected String getModelClassName() {
		return InstaOtherDetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				instaOtherDetailsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected HandleAPIKeysPersistence handleAPIKeysPersistence;

	protected InstaOtherDetailsLocalService instaOtherDetailsLocalService;

	@Reference
	protected InstaOtherDetailsPersistence instaOtherDetailsPersistence;

	@Reference
	protected InstaSiteImagesPersistence instaSiteImagesPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}