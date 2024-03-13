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
import com.liferay.docs.backend.model.GioLam;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.base.GioLamLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.backend.model.GioLam",
	service = AopService.class
)
public class GioLamLocalServiceImpl extends GioLamLocalServiceBaseImpl {
	
	
	
	public void addGioLamVaoSang( long user_id,
			Date ngaylam,  String check_in_sang,  int di_muon_sang, float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {
		
		int idGioLamnew = (int) CounterLocalServiceUtil.increment();
		GioLam giolam = gioLamPersistence.create(idGioLamnew);
		Date now = new Date();
		
		giolam.setId(idGioLamnew);
		giolam.setUser_id(user_id);
		giolam.setNgay_lam(ngaylam);
		giolam.setCheck_in_sang(check_in_sang);
		giolam.setDi_muon_sang(di_muon_sang);;
		
		giolam.setDiem(diem);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		giolam.setTrangthai(trangthai);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		
	}
	
	public void addGioLamVaoChieu( long user_id,
			Date ngaylam,  String check_in_chieu,  int di_muon_chieu,float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {
		
		int idGioLamnew = (int) CounterLocalServiceUtil.increment();
		GioLam giolam = gioLamPersistence.create(idGioLamnew);
		Date now = new Date();
		
		giolam.setId(idGioLamnew);
		giolam.setUser_id(user_id);
		giolam.setNgay_lam(ngaylam);
		giolam.setCheck_in_chieu(check_in_chieu);
		giolam.setDi_muon_chieu(di_muon_chieu);
		
		giolam.setDiem(diem);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		giolam.setTrangthai(trangthai);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		
	}
	
	public void updateGioLamRaSang( int idGioLam, long user_id, String check_out_sang,  int ve_som_sang ,float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {
		
		GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
		Date now = new Date();
		//giolam.setId(idGioLam);
		giolam.setUser_id(user_id);
        giolam.setCheck_out_sang(check_out_sang);
		giolam.setVe_som_sang(ve_som_sang);    
		giolam.setDiem(diem);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		giolam.setTrangthai(trangthai);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		
	}
	public void updateGioLamVaoChieu( int idGioLam, long user_id, String check_in_chieu,  int di_muon_chieu ,float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {
		
		GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
		Date now = new Date();
		giolam.setUser_id(user_id);
        giolam.setCheck_in_chieu(check_in_chieu);
        giolam.setDi_muon_chieu(di_muon_chieu);
	
		giolam.setDiem(diem);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		giolam.setTrangthai(trangthai);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		
	}
	public void updateGioLamRaChieu( int idGioLam, long user_id, String check_out_chieu,  int ve_som_chieu ,float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {
		
		GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
		Date now = new Date();
		giolam.setUser_id(user_id);
        giolam.setCheck_out_chieu(check_out_chieu);
        giolam.setVe_som_chieu(ve_som_chieu);
		giolam.setDiem(diem);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		giolam.setTrangthai(trangthai);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		
	}
	public void updateGioLamCaNgay( int idGioLam, long user_id, String check_out_chieu,  int ve_som_chieu ,float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {
		
		GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
		Date now = new Date();
		giolam.setUser_id(user_id);
        giolam.setCheck_out_chieu(check_out_chieu);
        giolam.setVe_som_chieu(ve_som_chieu);
		giolam.setDiem(diem);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		giolam.setTrangthai(trangthai);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		
	}
	
	public List<GioLam> getGioLamByYearAndMonth(String Month,String Year, long userId) {
	     System.out.println("Year ---- "+ Year);
	     System.out.println("Month ---- "+ Month);
	     System.out.println("userId ---- "+ userId);
		return gioLamFinder.getGioLamByYearAndMonth(Month,Year, userId);
		
	}
	
	
	
	
	// Lấy thời gian của nhân viên trong db tại ngày hiện tại 
	public GioLam getGioLamByUserId(long userId, Date NgayLam) throws PortalException {
		List<GioLam> gioLamList = GioLamLocalServiceUtil.getGioLams(-1, -1);
		LocalDate localDate = NgayLam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Chuyển đổi Date thành
																								// LocalDate
		Optional<GioLam> employeeGioLam = gioLamList.stream()
				.filter(n -> n.getNgay_lam().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().equals(localDate)
						&& n.getUser_id() == userId)
				.findFirst();
		//System.out.println("employeeGioLam: " + employeeGioLam);
		GioLam gioLam = null; // Khởi tạo giá trị mặc định là null
		if (employeeGioLam.isPresent()) {
			gioLam = employeeGioLam.get();
			// System.out.println("employeeGioLam: " + gioLam);
		}
		return gioLam;

	}
	

	
}