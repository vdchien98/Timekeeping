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

package com.liferay.docs.backend.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link adminphieudiemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiemLocalService
 * @generated
 */
public class adminphieudiemLocalServiceWrapper
	implements adminphieudiemLocalService,
			   ServiceWrapper<adminphieudiemLocalService> {

	public adminphieudiemLocalServiceWrapper() {
		this(null);
	}

	public adminphieudiemLocalServiceWrapper(
		adminphieudiemLocalService adminphieudiemLocalService) {

		_adminphieudiemLocalService = adminphieudiemLocalService;
	}

	/**
	 * Adds the adminphieudiem to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect adminphieudiemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param adminphieudiem the adminphieudiem
	 * @return the adminphieudiem that was added
	 */
	@Override
	public com.liferay.docs.backend.model.adminphieudiem addadminphieudiem(
		com.liferay.docs.backend.model.adminphieudiem adminphieudiem) {

		return _adminphieudiemLocalService.addadminphieudiem(adminphieudiem);
	}

	@Override
	public com.liferay.docs.backend.model.adminphieudiem addcauhoi(
			String uuid, long userid, String nhomcauhoi, String noidungcauhoi,
			long thuocnhomcauhoinao, Double diemtoida, int trangthaicauhoi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _adminphieudiemLocalService.addcauhoi(
			uuid, userid, nhomcauhoi, noidungcauhoi, thuocnhomcauhoinao,
			diemtoida, trangthaicauhoi, serviceContext);
	}

	/**
	 * Creates a new adminphieudiem with the primary key. Does not add the adminphieudiem to the database.
	 *
	 * @param id the primary key for the new adminphieudiem
	 * @return the new adminphieudiem
	 */
	@Override
	public com.liferay.docs.backend.model.adminphieudiem createadminphieudiem(
		int id) {

		return _adminphieudiemLocalService.createadminphieudiem(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminphieudiemLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the adminphieudiem from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect adminphieudiemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param adminphieudiem the adminphieudiem
	 * @return the adminphieudiem that was removed
	 */
	@Override
	public com.liferay.docs.backend.model.adminphieudiem deleteadminphieudiem(
		com.liferay.docs.backend.model.adminphieudiem adminphieudiem) {

		return _adminphieudiemLocalService.deleteadminphieudiem(adminphieudiem);
	}

	/**
	 * Deletes the adminphieudiem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect adminphieudiemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem that was removed
	 * @throws PortalException if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.adminphieudiem deleteadminphieudiem(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminphieudiemLocalService.deleteadminphieudiem(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminphieudiemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _adminphieudiemLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _adminphieudiemLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adminphieudiemLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _adminphieudiemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _adminphieudiemLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _adminphieudiemLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _adminphieudiemLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _adminphieudiemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.backend.model.adminphieudiem fetchadminphieudiem(
		int id) {

		return _adminphieudiemLocalService.fetchadminphieudiem(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _adminphieudiemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the adminphieudiem with the primary key.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem
	 * @throws PortalException if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.adminphieudiem getadminphieudiem(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminphieudiemLocalService.getadminphieudiem(id);
	}

	/**
	 * Returns a range of all the adminphieudiems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @return the range of adminphieudiems
	 */
	@Override
	public java.util.List<com.liferay.docs.backend.model.adminphieudiem>
		getadminphieudiems(int start, int end) {

		return _adminphieudiemLocalService.getadminphieudiems(start, end);
	}

	/**
	 * Returns the number of adminphieudiems.
	 *
	 * @return the number of adminphieudiems
	 */
	@Override
	public int getadminphieudiemsCount() {
		return _adminphieudiemLocalService.getadminphieudiemsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _adminphieudiemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _adminphieudiemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminphieudiemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the adminphieudiem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect adminphieudiemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param adminphieudiem the adminphieudiem
	 * @return the adminphieudiem that was updated
	 */
	@Override
	public com.liferay.docs.backend.model.adminphieudiem updateadminphieudiem(
		com.liferay.docs.backend.model.adminphieudiem adminphieudiem) {

		return _adminphieudiemLocalService.updateadminphieudiem(adminphieudiem);
	}

	@Override
	public adminphieudiemLocalService getWrappedService() {
		return _adminphieudiemLocalService;
	}

	@Override
	public void setWrappedService(
		adminphieudiemLocalService adminphieudiemLocalService) {

		_adminphieudiemLocalService = adminphieudiemLocalService;
	}

	private adminphieudiemLocalService _adminphieudiemLocalService;

}