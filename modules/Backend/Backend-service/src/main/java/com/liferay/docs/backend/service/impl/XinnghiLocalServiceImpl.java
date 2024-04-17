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

package com.liferay.docs.backend.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.backend.model.Xinnghi;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.base.XinnghiLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.backend.model.Xinnghi", service = AopService.class)
public class XinnghiLocalServiceImpl extends XinnghiLocalServiceBaseImpl {
	public Xinnghi saveXinNghiCaNgay(long userId, Date tu_ngay, Date den_ngay, String chon_ly_do, String ly_do,
			int trangthai, int nuangay, int soNgay, String file_url, long nguoihuy, long phongban_id,
			ServiceContext serviceContext) throws PortalException, SystemException {

		System.out.println("da vao dc serrvice -------- ");

		long groupId = serviceContext.getScopeGroupId();
		int idXinNghi = (int) CounterLocalServiceUtil.increment();
		System.out.println("id la " + idXinNghi);
		Xinnghi xinnghi = xinnghiPersistence.create(idXinNghi);
		Date now = new Date();
		xinnghi.setId(idXinNghi);
		xinnghi.setTu_ngay(tu_ngay);
		xinnghi.setDen_ngay(den_ngay);
		xinnghi.setUser_id(userId);
		xinnghi.setChon_ly_do(chon_ly_do);
		xinnghi.setLy_do(ly_do);
		xinnghi.setTrangthai(trangthai);
		xinnghi.setNua_ngay(nuangay);
		xinnghi.setSo_ngay(soNgay);

		xinnghi.setNguoi_huy(nguoihuy);
		xinnghi.setCreated_at(now);
		xinnghi.setUpdated_at(now);
		xinnghi.setPhongban_id(phongban_id);

		// xử lý tạo file PDF

		xinnghi.setFile_url(file_url);

		xinnghiLocalService.updateXinnghi(xinnghi);
		return xinnghi;
	}

	public Xinnghi saveXinNghiNuaNgay(long userId, Date tu_ngay, String chon_ly_do, String ly_do, int trangthai,
			int Nghi_ca_lam, int soNgay, long nguoihuy, long phongban_id, int trangthaikyso,
			ServiceContext serviceContext) throws PortalException, SystemException {

		System.out.println("da vao dc serrvice -------- ");

		long groupId = serviceContext.getScopeGroupId();
		int idXinNghi = (int) CounterLocalServiceUtil.increment();
		System.out.println("id la " + idXinNghi);
		Xinnghi xinnghi = xinnghiPersistence.create(idXinNghi);
		Date now = new Date();
		xinnghi.setId(idXinNghi);
		xinnghi.setUser_id(userId);
		xinnghi.setTu_ngay(tu_ngay);
		xinnghi.setLy_do(ly_do);
		xinnghi.setChon_ly_do(chon_ly_do);
		xinnghi.setTrangthai(trangthai);
		xinnghi.setNua_ngay(Nghi_ca_lam);
		xinnghi.setSo_ngay(soNgay);

		xinnghi.setNguoi_huy(nguoihuy);
		xinnghi.setCreated_at(now);
		xinnghi.setUpdated_at(now);
		xinnghi.setPhongban_id(phongban_id);
		xinnghi.setTrangthai_kyso(trangthaikyso);

		// xử lý tạo file PDF
		xinnghiLocalService.updateXinnghi(xinnghi);
		return xinnghi;
	}

	public Xinnghi upadatefileXinNghi(int id_file, int trangthai_ky_so, ServiceContext serviceContext)
			throws PortalException, SystemException {

		System.out.println("da vao dc serrvice -------- ");
		Xinnghi xinnghi = getXinnghi(id_file);
		if (trangthai_ky_so == 1) {
			xinnghi.setTrangthai_kyso(1);
		} else if (trangthai_ky_so == 2) {
			xinnghi.setTrangthai_kyso(2);
		}
		xinnghiLocalService.updateXinnghi(xinnghi);

		return xinnghi;
	}
	
	
	
	
	
	public Xinnghi upadateXinNghiByLanhDaoDuyet(int id_file, int trangthai_ky_so, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("da vao dc serrvice -------- ");
		Xinnghi xinnghi = getXinnghi(id_file);
		
		xinnghi.setTrangthai_kyso(2);
		xinnghi.setTrangthai(2);
		
		
		xinnghiLocalService.updateXinnghi(xinnghi);

		return xinnghi;
	}
	
	
	
	
	
	
	public Xinnghi TuChoXinNghiByLanhDao(int id_file, int trangthai_ky_so, long id_nguoihuy, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("da vao dc serrvice -------- ");
		Xinnghi xinnghi = getXinnghi(id_file);
		
		xinnghi.setTrangthai(7);
		xinnghi.setNguoi_huy(id_nguoihuy);
		
		xinnghiLocalService.updateXinnghi(xinnghi);

		return xinnghi;
	}
	
	
	public Xinnghi upadateXinNghiByTruongPhongDuyet(int id_file, int trangthai_ky_so, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("da vao dc serrvice -------- ");
		Xinnghi xinnghi = getXinnghi(id_file);
		
		xinnghi.setTrangthai_kyso(5);
		xinnghi.setTrangthai(6);
		
		
		xinnghiLocalService.updateXinnghi(xinnghi);

		return xinnghi;
	}
	
	public Xinnghi TuChoXinNghiByTruongPhong(int id_file, int trangthai_ky_so, long id_nguoihuy, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("da vao dc serrvice -------- ");
		Xinnghi xinnghi = getXinnghi(id_file);
		
		xinnghi.setTrangthai(7);
		xinnghi.setNguoi_huy(id_nguoihuy);
		
		xinnghiLocalService.updateXinnghi(xinnghi);

		return xinnghi;
	}
	
	
	
	


	public static List<Date> taoDanhSachNgay(Date tungay, Date denngay) {
		List<Date> danhSachNgay = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tungay);

		while (!calendar.getTime().after(denngay)) {
			Date ngayHienTai = calendar.getTime();
			// Đặt giờ, phút và giây thành 00:00:00
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			danhSachNgay.add(calendar.getTime());

			calendar.add(Calendar.DATE, 1); // Tăng ngày thêm 1
		}

		return danhSachNgay;
	}
	
	
	
	
	// Xin chấm công nửa ngay
	
	
	
	
	
	
	
	
	
	
	

}