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
 * Provides a wrapper for {@link tudanhgiaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see tudanhgiaLocalService
 * @generated
 */
public class tudanhgiaLocalServiceWrapper
	implements ServiceWrapper<tudanhgiaLocalService>, tudanhgiaLocalService {

	public tudanhgiaLocalServiceWrapper() {
		this(null);
	}

	public tudanhgiaLocalServiceWrapper(
		tudanhgiaLocalService tudanhgiaLocalService) {

		_tudanhgiaLocalService = tudanhgiaLocalService;
	}

	@Override
	public com.liferay.docs.backend.model.tudanhgia addcautraloi(
			long userid, String thongtintudanhgia, String ykienkhac,
			String file_url, Double tongdiem, int trangthaixacnhan,
			int trangthaikyso, int thang, int nam, long phongban_id,
			String xeploai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _tudanhgiaLocalService.addcautraloi(
			userid, thongtintudanhgia, ykienkhac, file_url, tongdiem,
			trangthaixacnhan, trangthaikyso, thang, nam, phongban_id, xeploai,
			serviceContext);
	}

	/**
	 * Adds the tudanhgia to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect tudanhgiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tudanhgia the tudanhgia
	 * @return the tudanhgia that was added
	 */
	@Override
	public com.liferay.docs.backend.model.tudanhgia addtudanhgia(
		com.liferay.docs.backend.model.tudanhgia tudanhgia) {

		return _tudanhgiaLocalService.addtudanhgia(tudanhgia);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tudanhgiaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tudanhgia with the primary key. Does not add the tudanhgia to the database.
	 *
	 * @param id the primary key for the new tudanhgia
	 * @return the new tudanhgia
	 */
	@Override
	public com.liferay.docs.backend.model.tudanhgia createtudanhgia(int id) {
		return _tudanhgiaLocalService.createtudanhgia(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tudanhgiaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tudanhgia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect tudanhgiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia that was removed
	 * @throws PortalException if a tudanhgia with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.tudanhgia deletetudanhgia(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tudanhgiaLocalService.deletetudanhgia(id);
	}

	/**
	 * Deletes the tudanhgia from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect tudanhgiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tudanhgia the tudanhgia
	 * @return the tudanhgia that was removed
	 */
	@Override
	public com.liferay.docs.backend.model.tudanhgia deletetudanhgia(
		com.liferay.docs.backend.model.tudanhgia tudanhgia) {

		return _tudanhgiaLocalService.deletetudanhgia(tudanhgia);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tudanhgiaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tudanhgiaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tudanhgiaLocalService.dynamicQuery();
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

		return _tudanhgiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.tudanhgiaModelImpl</code>.
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

		return _tudanhgiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.tudanhgiaModelImpl</code>.
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

		return _tudanhgiaLocalService.dynamicQuery(
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

		return _tudanhgiaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tudanhgiaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.backend.model.tudanhgia fetchtudanhgia(int id) {
		return _tudanhgiaLocalService.fetchtudanhgia(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tudanhgiaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tudanhgiaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tudanhgiaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tudanhgiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tudanhgia with the primary key.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia
	 * @throws PortalException if a tudanhgia with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.tudanhgia gettudanhgia(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tudanhgiaLocalService.gettudanhgia(id);
	}

	/**
	 * Returns a range of all the tudanhgias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @return the range of tudanhgias
	 */
	@Override
	public java.util.List<com.liferay.docs.backend.model.tudanhgia>
		gettudanhgias(int start, int end) {

		return _tudanhgiaLocalService.gettudanhgias(start, end);
	}

	/**
	 * Returns the number of tudanhgias.
	 *
	 * @return the number of tudanhgias
	 */
	@Override
	public int gettudanhgiasCount() {
		return _tudanhgiaLocalService.gettudanhgiasCount();
	}

	/**
	 * Updates the tudanhgia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect tudanhgiaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tudanhgia the tudanhgia
	 * @return the tudanhgia that was updated
	 */
	@Override
	public com.liferay.docs.backend.model.tudanhgia updatetudanhgia(
		com.liferay.docs.backend.model.tudanhgia tudanhgia) {

		return _tudanhgiaLocalService.updatetudanhgia(tudanhgia);
	}

	@Override
	public tudanhgiaLocalService getWrappedService() {
		return _tudanhgiaLocalService;
	}

	@Override
	public void setWrappedService(tudanhgiaLocalService tudanhgiaLocalService) {
		_tudanhgiaLocalService = tudanhgiaLocalService;
	}

	private tudanhgiaLocalService _tudanhgiaLocalService;

}