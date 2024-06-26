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

import com.liferay.docs.backend.model.Xinchamcong;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Xinchamcong. This utility wraps
 * <code>com.liferay.docs.backend.service.impl.XinchamcongLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see XinchamcongLocalService
 * @generated
 */
public class XinchamcongLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.backend.service.impl.XinchamcongLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void actionDuyetChamCongNuaNgayCaNgay(
			long chucvu_id, long idxinchamcong,
			long user_id_nguoi_xin_cham_cong, long user_id_nguoi_duyet,
			long user_id_nguoi_huy, int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().actionDuyetChamCongNuaNgayCaNgay(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	public static void actionDuyetChamCongVaoRa(
			long chucvu_id, int idxinchamcong, long user_id_nguoi_xin_cham_cong,
			String ly_do, long user_id_nguoi_duyet, long user_id_nguoi_huy,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().actionDuyetChamCongVaoRa(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong, ly_do,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	public static void actionTuChoiChamCongNuaNgayCaNgay(
			long chucvu_id, int idxinchamcong, long user_id_nguoi_xin_cham_cong,
			String ly_do, long user_id_nguoi_duyet, long user_id_nguoi_huy,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().actionTuChoiChamCongNuaNgayCaNgay(
			chucvu_id, idxinchamcong, user_id_nguoi_xin_cham_cong, ly_do,
			user_id_nguoi_duyet, user_id_nguoi_huy, trangthai, phongban_id,
			serviceContext);
	}

	public static void actionTuChoiChamCongVaoRa(
			long chucvu_id, int idxinchamcong, long user_id_nguoi_xin_cham_cong,
			String ly_do, long user_id_nguoi_duyet, long user_id_nguoi_huy,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().actionTuChoiChamCongVaoRa(
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
	public static Xinchamcong addXinchamcong(Xinchamcong xinchamcong) {
		return getService().addXinchamcong(xinchamcong);
	}

	public static void addXinChamCongCaNgay(
			long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam,
			String check_in, String check_out, java.util.Date tu_ngay,
			java.util.Date den_ngay, long user_id_nguoi_duyet,
			long user_id_nguoi_huy, String loai_cham_cong, float diem,
			int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addXinChamCongCaNgay(
			user_id_nguoi_xin_cham_cong, ly_do, ca_lam, check_in, check_out,
			tu_ngay, den_ngay, user_id_nguoi_duyet, user_id_nguoi_huy,
			loai_cham_cong, diem, trangthai, phongban_id, serviceContext);
	}

	public static void addXinChamCongNuaNgay(
			long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam,
			String check_in, String check_out, java.util.Date ngay_lam,
			long user_id_nguoi_duyet, long user_id_nguoi_huy,
			String loai_cham_cong, float diem, int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addXinChamCongNuaNgay(
			user_id_nguoi_xin_cham_cong, ly_do, ca_lam, check_in, check_out,
			ngay_lam, user_id_nguoi_duyet, user_id_nguoi_huy, loai_cham_cong,
			diem, trangthai, phongban_id, serviceContext);
	}

	public static void addXinChamCongVaoRa(
			long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam,
			String check_in, String check_out, java.util.Date ngay_lam,
			long user_id_nguoi_duyet, long user_id_nguoi_huy,
			String loai_cham_cong, float diem, int trangthai, long phongban_id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		getService().addXinChamCongVaoRa(
			user_id_nguoi_xin_cham_cong, ly_do, ca_lam, check_in, check_out,
			ngay_lam, user_id_nguoi_duyet, user_id_nguoi_huy, loai_cham_cong,
			diem, trangthai, phongban_id, serviceContext);
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
	 * Creates a new xinchamcong with the primary key. Does not add the xinchamcong to the database.
	 *
	 * @param id the primary key for the new xinchamcong
	 * @return the new xinchamcong
	 */
	public static Xinchamcong createXinchamcong(int id) {
		return getService().createXinchamcong(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Xinchamcong deleteXinchamcong(int id) throws PortalException {
		return getService().deleteXinchamcong(id);
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
	public static Xinchamcong deleteXinchamcong(Xinchamcong xinchamcong) {
		return getService().deleteXinchamcong(xinchamcong);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinchamcongModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinchamcongModelImpl</code>.
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

	public static Xinchamcong fetchXinchamcong(int id) {
		return getService().fetchXinchamcong(id);
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

	/**
	 * Returns the xinchamcong with the primary key.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong
	 * @throws PortalException if a xinchamcong with the primary key could not be found
	 */
	public static Xinchamcong getXinchamcong(int id) throws PortalException {
		return getService().getXinchamcong(id);
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
	public static List<Xinchamcong> getXinchamcongs(int start, int end) {
		return getService().getXinchamcongs(start, end);
	}

	/**
	 * Returns the number of xinchamcongs.
	 *
	 * @return the number of xinchamcongs
	 */
	public static int getXinchamcongsCount() {
		return getService().getXinchamcongsCount();
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
	public static Xinchamcong updateXinchamcong(Xinchamcong xinchamcong) {
		return getService().updateXinchamcong(xinchamcong);
	}

	public static XinchamcongLocalService getService() {
		return _service;
	}

	private static volatile XinchamcongLocalService _service;

}