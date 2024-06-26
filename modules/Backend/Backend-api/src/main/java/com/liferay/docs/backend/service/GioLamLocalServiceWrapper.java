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
 * Provides a wrapper for {@link GioLamLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GioLamLocalService
 * @generated
 */
public class GioLamLocalServiceWrapper
	implements GioLamLocalService, ServiceWrapper<GioLamLocalService> {

	public GioLamLocalServiceWrapper() {
		this(null);
	}

	public GioLamLocalServiceWrapper(GioLamLocalService gioLamLocalService) {
		_gioLamLocalService = gioLamLocalService;
	}

	/**
	 * Adds the gio lam to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GioLamLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gioLam the gio lam
	 * @return the gio lam that was added
	 */
	@Override
	public com.liferay.docs.backend.model.GioLam addGioLam(
		com.liferay.docs.backend.model.GioLam gioLam) {

		return _gioLamLocalService.addGioLam(gioLam);
	}

	@Override
	public void addGioLamVaoChieu(
			long user_id, java.util.Date ngaylam, String check_in_chieu,
			int di_muon_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.addGioLamVaoChieu(
			user_id, ngaylam, check_in_chieu, di_muon_chieu, trangthai,
			serviceContext);
	}

	@Override
	public void addGioLamVaoSang(
			long user_id, java.util.Date ngaylam, String check_in_sang,
			int di_muon_sang, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.addGioLamVaoSang(
			user_id, ngaylam, check_in_sang, di_muon_sang, trangthai,
			serviceContext);
	}

	@Override
	public void addGioLamXinNghiDcPheDuyetCaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.addGioLamXinNghiDcPheDuyetCaNgay(
			idGioLam, userXinNghi, ngaylam, TrangThai, serviceContext);
	}

	@Override
	public void addGioLamXinNghiDcPheDuyetNuaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int Ca_Nghi_Phep, int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.addGioLamXinNghiDcPheDuyetNuaNgay(
			idGioLam, userXinNghi, ngaylam, Ca_Nghi_Phep, TrangThai,
			serviceContext);
	}

	@Override
	public void addXinChamCongCaNgayNuaNgay(
			java.util.Date ngay_lam, long user_id_XinChamCong,
			String loai_cham_cong, float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.addXinChamCongCaNgayNuaNgay(
			ngay_lam, user_id_XinChamCong, loai_cham_cong, diem, trangthai,
			serviceContext);
	}

	@Override
	public void addXinChamCongvaoRa(
			int idGioLam, long user_id_XinChamCongVaoRa,
			java.util.Date ngay_lam, String ca_lam, String loai_cham_cong,
			float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.addXinChamCongvaoRa(
			idGioLam, user_id_XinChamCongVaoRa, ngay_lam, ca_lam,
			loai_cham_cong, diem, trangthai, serviceContext);
	}

	/**
	 * Creates a new gio lam with the primary key. Does not add the gio lam to the database.
	 *
	 * @param id the primary key for the new gio lam
	 * @return the new gio lam
	 */
	@Override
	public com.liferay.docs.backend.model.GioLam createGioLam(int id) {
		return _gioLamLocalService.createGioLam(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gioLamLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the gio lam from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GioLamLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gioLam the gio lam
	 * @return the gio lam that was removed
	 */
	@Override
	public com.liferay.docs.backend.model.GioLam deleteGioLam(
		com.liferay.docs.backend.model.GioLam gioLam) {

		return _gioLamLocalService.deleteGioLam(gioLam);
	}

	/**
	 * Deletes the gio lam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GioLamLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam that was removed
	 * @throws PortalException if a gio lam with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.GioLam deleteGioLam(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gioLamLocalService.deleteGioLam(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gioLamLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _gioLamLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _gioLamLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gioLamLocalService.dynamicQuery();
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

		return _gioLamLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.GioLamModelImpl</code>.
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

		return _gioLamLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.GioLamModelImpl</code>.
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

		return _gioLamLocalService.dynamicQuery(
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

		return _gioLamLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gioLamLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.backend.model.GioLam fetchGioLam(int id) {
		return _gioLamLocalService.fetchGioLam(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gioLamLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the gio lam with the primary key.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam
	 * @throws PortalException if a gio lam with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.GioLam getGioLam(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gioLamLocalService.getGioLam(id);
	}

	@Override
	public com.liferay.docs.backend.model.GioLam getGioLamByUserId(
			long userId, java.util.Date NgayLam)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gioLamLocalService.getGioLamByUserId(userId, NgayLam);
	}

	@Override
	public java.util.List<com.liferay.docs.backend.model.GioLam>
		getGioLamByYearAndMonth(String Month, String Year, long userId) {

		return _gioLamLocalService.getGioLamByYearAndMonth(Month, Year, userId);
	}

	/**
	 * Returns a range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @return the range of gio lams
	 */
	@Override
	public java.util.List<com.liferay.docs.backend.model.GioLam> getGioLams(
		int start, int end) {

		return _gioLamLocalService.getGioLams(start, end);
	}

	/**
	 * Returns the number of gio lams.
	 *
	 * @return the number of gio lams
	 */
	@Override
	public int getGioLamsCount() {
		return _gioLamLocalService.getGioLamsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gioLamLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gioLamLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gioLamLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void upateDiemChamCong(
			int idGioLam, java.util.Date ngay_lam, double diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.upateDiemChamCong(
			idGioLam, ngay_lam, diem, trangthai, serviceContext);
	}

	/**
	 * Updates the gio lam in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GioLamLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gioLam the gio lam
	 * @return the gio lam that was updated
	 */
	@Override
	public com.liferay.docs.backend.model.GioLam updateGioLam(
		com.liferay.docs.backend.model.GioLam gioLam) {

		return _gioLamLocalService.updateGioLam(gioLam);
	}

	@Override
	public void updateGioLamCaNgay(
			int idGioLam, long user_id, String check_out_chieu,
			int ve_som_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateGioLamCaNgay(
			idGioLam, user_id, check_out_chieu, ve_som_chieu, trangthai,
			serviceContext);
	}

	@Override
	public void updateGioLamRaChieu(
			int idGioLam, long user_id, String check_out_chieu,
			int ve_som_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateGioLamRaChieu(
			idGioLam, user_id, check_out_chieu, ve_som_chieu, trangthai,
			serviceContext);
	}

	@Override
	public void updateGioLamRaSang(
			int idGioLam, long user_id, String check_out_sang, int ve_som_sang,
			int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateGioLamRaSang(
			idGioLam, user_id, check_out_sang, ve_som_sang, trangthai,
			serviceContext);
	}

	@Override
	public void updateGioLamVaoChieu(
			int idGioLam, long user_id, String check_in_chieu,
			int di_muon_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateGioLamVaoChieu(
			idGioLam, user_id, check_in_chieu, di_muon_chieu, trangthai,
			serviceContext);
	}

	@Override
	public void updateGioLamXinNghiDcPheDuyetCaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateGioLamXinNghiDcPheDuyetCaNgay(
			idGioLam, userXinNghi, ngaylam, TrangThai, serviceContext);
	}

	@Override
	public void updateGioLamXinNghiDcPheDuyetNuaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int Ca_Nghi_Phep, int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateGioLamXinNghiDcPheDuyetNuaNgay(
			idGioLam, userXinNghi, ngaylam, Ca_Nghi_Phep, TrangThai,
			serviceContext);
	}

	@Override
	public void updateXinChamCongCaNgayNuaNgay(
			int idGioLam, java.util.Date ngay_lam, long user_id_XinChamCong,
			String loai_cham_cong, float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateXinChamCongCaNgayNuaNgay(
			idGioLam, ngay_lam, user_id_XinChamCong, loai_cham_cong, diem,
			trangthai, serviceContext);
	}

	@Override
	public void updateXinChamCongvaoRa(
			int idGioLam, java.util.Date ngay_lam,
			long user_id_XinChamCongVaoRa, String ca_lam, String loai_cham_cong,
			float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_gioLamLocalService.updateXinChamCongvaoRa(
			idGioLam, ngay_lam, user_id_XinChamCongVaoRa, ca_lam,
			loai_cham_cong, diem, trangthai, serviceContext);
	}

	@Override
	public GioLamLocalService getWrappedService() {
		return _gioLamLocalService;
	}

	@Override
	public void setWrappedService(GioLamLocalService gioLamLocalService) {
		_gioLamLocalService = gioLamLocalService;
	}

	private GioLamLocalService _gioLamLocalService;

}