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
 * Provides a wrapper for {@link XinchamcongLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see XinchamcongLocalService
 * @generated
 */
public class XinchamcongLocalServiceWrapper
	implements ServiceWrapper<XinchamcongLocalService>,
			   XinchamcongLocalService {

	public XinchamcongLocalServiceWrapper() {
		this(null);
	}

	public XinchamcongLocalServiceWrapper(
		XinchamcongLocalService xinchamcongLocalService) {

		_xinchamcongLocalService = xinchamcongLocalService;
	}

	@Override
	public void actionDuyetChamCongNuaNgayCaNgay(
			long chucvu_id, long idxinchamcong,
			long user_id_nguoi_xin_cham_cong, long user_id_nguoi_duyet,
			long user_id_nguoi_huy, int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.actionDuyetChamCongNuaNgayCaNgay(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	@Override
	public void actionDuyetChamCongVaoRa(
			long chucvu_id, int idxinchamcong, long user_id_nguoi_xin_cham_cong,
			String ly_do, long user_id_nguoi_duyet, long user_id_nguoi_huy,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.actionDuyetChamCongVaoRa(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong, ly_do,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	@Override
	public void actionTuChoiChamCongNuaNgayCaNgay(
			long chucvu_id, int idxinchamcong, long user_id_nguoi_xin_cham_cong,
			String ly_do, long user_id_nguoi_duyet, long user_id_nguoi_huy,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.actionTuChoiChamCongNuaNgayCaNgay(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong, ly_do,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	@Override
	public void actionTuChoiChamCongVaoRa(
			long chucvu_id, int idxinchamcong, long user_id_nguoi_xin_cham_cong,
			String ly_do, long user_id_nguoi_duyet, long user_id_nguoi_huy,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.actionTuChoiChamCongVaoRa(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong, ly_do,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	/**
	 * Adds the xinchamcong to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinchamcongLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinchamcong the xinchamcong
	 * @return the xinchamcong that was added
	 */
	@Override
	public com.liferay.docs.backend.model.Xinchamcong addXinchamcong(
		com.liferay.docs.backend.model.Xinchamcong xinchamcong) {

		return _xinchamcongLocalService.addXinchamcong(xinchamcong);
	}

	@Override
	public void addXinChamCongCaNgay(
			long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam,
			String check_in, String check_out, java.util.Date tu_ngay,
			java.util.Date den_ngay, long user_id_nguoi_duyet,
			long user_id_nguoi_huy, String loai_cham_cong, float diem,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.addXinChamCongCaNgay(
			user_id_nguoi_xin_cham_cong, ly_do, ca_lam, check_in, check_out,
			tu_ngay, den_ngay, user_id_nguoi_duyet, user_id_nguoi_huy,
			loai_cham_cong, diem, trangthai, phongban_id, serviceContext);
	}

	@Override
	public void addXinChamCongNuaNgay(
			long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam,
			String check_in, String check_out, java.util.Date ngay_lam,
			long user_id_nguoi_duyet, long user_id_nguoi_huy,
			String loai_cham_cong, float diem, int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.addXinChamCongNuaNgay(
			user_id_nguoi_xin_cham_cong, ly_do, ca_lam, check_in, check_out,
			ngay_lam, user_id_nguoi_duyet, user_id_nguoi_huy, loai_cham_cong,
			diem, trangthai, phongban_id, serviceContext);
	}

	@Override
	public void addXinChamCongVaoRa(
			long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam,
			String check_in, String check_out, java.util.Date ngay_lam,
			long user_id_nguoi_duyet, long user_id_nguoi_huy,
			String loai_cham_cong, float diem, int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_xinchamcongLocalService.addXinChamCongVaoRa(
			user_id_nguoi_xin_cham_cong, ly_do, ca_lam, check_in, check_out,
			ngay_lam, user_id_nguoi_duyet, user_id_nguoi_huy, loai_cham_cong,
			diem, trangthai, phongban_id, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinchamcongLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new xinchamcong with the primary key. Does not add the xinchamcong to the database.
	 *
	 * @param id the primary key for the new xinchamcong
	 * @return the new xinchamcong
	 */
	@Override
	public com.liferay.docs.backend.model.Xinchamcong createXinchamcong(
		int id) {

		return _xinchamcongLocalService.createXinchamcong(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinchamcongLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the xinchamcong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinchamcongLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong that was removed
	 * @throws PortalException if a xinchamcong with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.Xinchamcong deleteXinchamcong(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinchamcongLocalService.deleteXinchamcong(id);
	}

	/**
	 * Deletes the xinchamcong from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinchamcongLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinchamcong the xinchamcong
	 * @return the xinchamcong that was removed
	 */
	@Override
	public com.liferay.docs.backend.model.Xinchamcong deleteXinchamcong(
		com.liferay.docs.backend.model.Xinchamcong xinchamcong) {

		return _xinchamcongLocalService.deleteXinchamcong(xinchamcong);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _xinchamcongLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _xinchamcongLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _xinchamcongLocalService.dynamicQuery();
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

		return _xinchamcongLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinchamcongModelImpl</code>.
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

		return _xinchamcongLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinchamcongModelImpl</code>.
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

		return _xinchamcongLocalService.dynamicQuery(
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

		return _xinchamcongLocalService.dynamicQueryCount(dynamicQuery);
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

		return _xinchamcongLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.backend.model.Xinchamcong fetchXinchamcong(int id) {
		return _xinchamcongLocalService.fetchXinchamcong(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _xinchamcongLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _xinchamcongLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _xinchamcongLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinchamcongLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the xinchamcong with the primary key.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong
	 * @throws PortalException if a xinchamcong with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.Xinchamcong getXinchamcong(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinchamcongLocalService.getXinchamcong(id);
	}

	/**
	 * Returns a range of all the xinchamcongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @return the range of xinchamcongs
	 */
	@Override
	public java.util.List<com.liferay.docs.backend.model.Xinchamcong>
		getXinchamcongs(int start, int end) {

		return _xinchamcongLocalService.getXinchamcongs(start, end);
	}

	/**
	 * Returns the number of xinchamcongs.
	 *
	 * @return the number of xinchamcongs
	 */
	@Override
	public int getXinchamcongsCount() {
		return _xinchamcongLocalService.getXinchamcongsCount();
	}

	/**
	 * Updates the xinchamcong in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinchamcongLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinchamcong the xinchamcong
	 * @return the xinchamcong that was updated
	 */
	@Override
	public com.liferay.docs.backend.model.Xinchamcong updateXinchamcong(
		com.liferay.docs.backend.model.Xinchamcong xinchamcong) {

		return _xinchamcongLocalService.updateXinchamcong(xinchamcong);
	}

	@Override
	public XinchamcongLocalService getWrappedService() {
		return _xinchamcongLocalService;
	}

	@Override
	public void setWrappedService(
		XinchamcongLocalService xinchamcongLocalService) {

		_xinchamcongLocalService = xinchamcongLocalService;
	}

	private XinchamcongLocalService _xinchamcongLocalService;

}