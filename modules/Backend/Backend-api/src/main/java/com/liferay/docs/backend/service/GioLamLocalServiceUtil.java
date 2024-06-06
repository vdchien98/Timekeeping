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

import com.liferay.docs.backend.model.GioLam;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for GioLam. This utility wraps
 * <code>com.liferay.docs.backend.service.impl.GioLamLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GioLamLocalService
 * @generated
 */
public class GioLamLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.backend.service.impl.GioLamLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static GioLam addGioLam(GioLam gioLam) {
		return getService().addGioLam(gioLam);
	}

	public static void addGioLamVaoChieu(
			long user_id, java.util.Date ngaylam, String check_in_chieu,
			int di_muon_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addGioLamVaoChieu(
			user_id, ngaylam, check_in_chieu, di_muon_chieu, trangthai,
			serviceContext);
	}

	public static void addGioLamVaoSang(
			long user_id, java.util.Date ngaylam, String check_in_sang,
			int di_muon_sang, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addGioLamVaoSang(
			user_id, ngaylam, check_in_sang, di_muon_sang, trangthai,
			serviceContext);
	}

	public static void addGioLamXinNghiDcPheDuyetCaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addGioLamXinNghiDcPheDuyetCaNgay(
			idGioLam, userXinNghi, ngaylam, TrangThai, serviceContext);
	}

	public static void addGioLamXinNghiDcPheDuyetNuaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int Ca_Nghi_Phep, int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addGioLamXinNghiDcPheDuyetNuaNgay(
			idGioLam, userXinNghi, ngaylam, Ca_Nghi_Phep, TrangThai,
			serviceContext);
	}

	public static void addXinChamCongCaNgayNuaNgay(
			java.util.Date ngay_lam, long user_id_XinChamCong,
			String loai_cham_cong, float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addXinChamCongCaNgayNuaNgay(
			ngay_lam, user_id_XinChamCong, loai_cham_cong, diem, trangthai,
			serviceContext);
	}

	public static void addXinChamCongvaoRa(
			int idGioLam, long user_id_XinChamCongVaoRa,
			java.util.Date ngay_lam, String ca_lam, String loai_cham_cong,
			float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addXinChamCongvaoRa(
			idGioLam, user_id_XinChamCongVaoRa, ngay_lam, ca_lam,
			loai_cham_cong, diem, trangthai, serviceContext);
	}

	/**
	 * Creates a new gio lam with the primary key. Does not add the gio lam to the database.
	 *
	 * @param id the primary key for the new gio lam
	 * @return the new gio lam
	 */
	public static GioLam createGioLam(int id) {
		return getService().createGioLam(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static GioLam deleteGioLam(GioLam gioLam) {
		return getService().deleteGioLam(gioLam);
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
	public static GioLam deleteGioLam(int id) throws PortalException {
		return getService().deleteGioLam(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
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
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static GioLam fetchGioLam(int id) {
		return getService().fetchGioLam(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the gio lam with the primary key.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam
	 * @throws PortalException if a gio lam with the primary key could not be found
	 */
	public static GioLam getGioLam(int id) throws PortalException {
		return getService().getGioLam(id);
	}

	public static GioLam getGioLamByUserId(long userId, java.util.Date NgayLam)
		throws PortalException {

		return getService().getGioLamByUserId(userId, NgayLam);
	}

	public static List<GioLam> getGioLamByYearAndMonth(
		String Month, String Year, long userId) {

		return getService().getGioLamByYearAndMonth(Month, Year, userId);
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
	public static List<GioLam> getGioLams(int start, int end) {
		return getService().getGioLams(start, end);
	}

	/**
	 * Returns the number of gio lams.
	 *
	 * @return the number of gio lams
	 */
	public static int getGioLamsCount() {
		return getService().getGioLamsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void upateDiemChamCong(
			int idGioLam, java.util.Date ngay_lam, double diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().upateDiemChamCong(
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
	public static GioLam updateGioLam(GioLam gioLam) {
		return getService().updateGioLam(gioLam);
	}

	public static void updateGioLamCaNgay(
			int idGioLam, long user_id, String check_out_chieu,
			int ve_som_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateGioLamCaNgay(
			idGioLam, user_id, check_out_chieu, ve_som_chieu, trangthai,
			serviceContext);
	}

	public static void updateGioLamRaChieu(
			int idGioLam, long user_id, String check_out_chieu,
			int ve_som_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateGioLamRaChieu(
			idGioLam, user_id, check_out_chieu, ve_som_chieu, trangthai,
			serviceContext);
	}

	public static void updateGioLamRaSang(
			int idGioLam, long user_id, String check_out_sang, int ve_som_sang,
			int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateGioLamRaSang(
			idGioLam, user_id, check_out_sang, ve_som_sang, trangthai,
			serviceContext);
	}

	public static void updateGioLamVaoChieu(
			int idGioLam, long user_id, String check_in_chieu,
			int di_muon_chieu, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateGioLamVaoChieu(
			idGioLam, user_id, check_in_chieu, di_muon_chieu, trangthai,
			serviceContext);
	}

	public static void updateGioLamXinNghiDcPheDuyetCaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateGioLamXinNghiDcPheDuyetCaNgay(
			idGioLam, userXinNghi, ngaylam, TrangThai, serviceContext);
	}

	public static void updateGioLamXinNghiDcPheDuyetNuaNgay(
			int idGioLam, long userXinNghi, java.util.Date ngaylam,
			int Ca_Nghi_Phep, int TrangThai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateGioLamXinNghiDcPheDuyetNuaNgay(
			idGioLam, userXinNghi, ngaylam, Ca_Nghi_Phep, TrangThai,
			serviceContext);
	}

	public static void updateXinChamCongCaNgayNuaNgay(
			int idGioLam, java.util.Date ngay_lam, long user_id_XinChamCong,
			String loai_cham_cong, float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateXinChamCongCaNgayNuaNgay(
			idGioLam, ngay_lam, user_id_XinChamCong, loai_cham_cong, diem,
			trangthai, serviceContext);
	}

	public static void updateXinChamCongvaoRa(
			int idGioLam, java.util.Date ngay_lam,
			long user_id_XinChamCongVaoRa, String ca_lam, String loai_cham_cong,
			float diem, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().updateXinChamCongvaoRa(
			idGioLam, ngay_lam, user_id_XinChamCongVaoRa, ca_lam,
			loai_cham_cong, diem, trangthai, serviceContext);
	}

	public static GioLamLocalService getService() {
		return _service;
	}

	private static volatile GioLamLocalService _service;

}