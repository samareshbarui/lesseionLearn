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

package jwc.insta.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for InstaOtherDetails. This utility wraps
 * <code>jwc.insta.service.impl.InstaOtherDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see InstaOtherDetailsLocalService
 * @generated
 */
public class InstaOtherDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jwc.insta.service.impl.InstaOtherDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the insta other details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was added
	 */
	public static jwc.insta.model.InstaOtherDetails addInstaOtherDetails(
		jwc.insta.model.InstaOtherDetails instaOtherDetails) {

		return getService().addInstaOtherDetails(instaOtherDetails);
	}

	/**
	 * Creates a new insta other details with the primary key. Does not add the insta other details to the database.
	 *
	 * @param otherDetid the primary key for the new insta other details
	 * @return the new insta other details
	 */
	public static jwc.insta.model.InstaOtherDetails createInstaOtherDetails(
		long otherDetid) {

		return getService().createInstaOtherDetails(otherDetid);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the insta other details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was removed
	 */
	public static jwc.insta.model.InstaOtherDetails deleteInstaOtherDetails(
		jwc.insta.model.InstaOtherDetails instaOtherDetails) {

		return getService().deleteInstaOtherDetails(instaOtherDetails);
	}

	/**
	 * Deletes the insta other details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details that was removed
	 * @throws PortalException if a insta other details with the primary key could not be found
	 */
	public static jwc.insta.model.InstaOtherDetails deleteInstaOtherDetails(
			long otherDetid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteInstaOtherDetails(otherDetid);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static jwc.insta.model.InstaOtherDetails fetchInstaOtherDetails(
		long otherDetid) {

		return getService().fetchInstaOtherDetails(otherDetid);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the insta other details with the primary key.
	 *
	 * @param otherDetid the primary key of the insta other details
	 * @return the insta other details
	 * @throws PortalException if a insta other details with the primary key could not be found
	 */
	public static jwc.insta.model.InstaOtherDetails getInstaOtherDetails(
			long otherDetid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInstaOtherDetails(otherDetid);
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
	public static java.util.List<jwc.insta.model.InstaOtherDetails>
		getInstaOtherDetailses(int start, int end) {

		return getService().getInstaOtherDetailses(start, end);
	}

	/**
	 * Returns the number of insta other detailses.
	 *
	 * @return the number of insta other detailses
	 */
	public static int getInstaOtherDetailsesCount() {
		return getService().getInstaOtherDetailsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the insta other details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instaOtherDetails the insta other details
	 * @return the insta other details that was updated
	 */
	public static jwc.insta.model.InstaOtherDetails updateInstaOtherDetails(
		jwc.insta.model.InstaOtherDetails instaOtherDetails) {

		return getService().updateInstaOtherDetails(instaOtherDetails);
	}

	public static InstaOtherDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InstaOtherDetailsLocalService, InstaOtherDetailsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			InstaOtherDetailsLocalService.class);

		ServiceTracker
			<InstaOtherDetailsLocalService, InstaOtherDetailsLocalService>
				serviceTracker =
					new ServiceTracker
						<InstaOtherDetailsLocalService,
						 InstaOtherDetailsLocalService>(
							 bundle.getBundleContext(),
							 InstaOtherDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}