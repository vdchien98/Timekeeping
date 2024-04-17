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
import com.liferay.docs.backend.model.Xinchamcong;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.XinchamcongLocalServiceUtil;
import com.liferay.docs.backend.service.base.XinchamcongLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.backend.model.Xinchamcong", service = AopService.class)
public class XinchamcongLocalServiceImpl extends XinchamcongLocalServiceBaseImpl {

	public void addXinChamCongVaoRa(long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam, String check_in, String check_out,
			Date ngay_lam, long user_id_nguoi_duyet,long user_id_nguoi_huy, String loai_cham_cong, float diem, int trangthai,
			long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		int startValue = 1;  // Giá trị bắt đầu cho counter
		String counterName = "XinChamCongCounter";  // Tên của counter
		int idXinChamCong = (int) CounterLocalServiceUtil.increment(counterName, startValue);
		
		Xinchamcong xinchamcong = xinchamcongPersistence.create(idXinChamCong);
		Date now = new Date();
		xinchamcong.setUser_id(user_id_nguoi_xin_cham_cong);
		xinchamcong.setLy_do(ly_do);
		
		
	    if (ca_lam.equals("sang")) {
	    	xinchamcong.setCa_lam(ca_lam);
	    	if (loai_cham_cong.equals("check_in") ) {
				// xin chấm công vào 
				xinchamcong.setCheck_in("07:30:00");
			} else if(loai_cham_cong.equals("check_out") ) {
				// xin chấm công ra
				xinchamcong.setCheck_out("11:30:00");
			}
		} else if(ca_lam.equals("chieu")) {
			xinchamcong.setCa_lam(ca_lam);
			if (loai_cham_cong.equals("check_in") ) {
				// xin chấm công vào 
				xinchamcong.setCheck_in("13:30:00");
			} else if(loai_cham_cong.equals("check_out") ) {
				// xin chấm công ra
				xinchamcong.setCheck_out("16:30:00");
			}
		}	
		xinchamcong.setNgay_lam(ngay_lam);
		xinchamcong.setDiem(diem);
		// TRẠNG THÁI LÀ 0 LÀ KO ĐC ĐỒNG , 1 LÀ ĐỒNG Ý
		xinchamcong.setTrangthai(trangthai);
		xinchamcong.setCreated_at(now);
		xinchamcong.setUpdated_at(now);
		xinchamcong.setPhongban_id(phongban_id);
		

		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}

	public void actionDuyetChamCongVaoRa(long chucvu_id, int idxinchamcong,long user_id_nguoi_xin_cham_cong, String ly_do,  long user_id_nguoi_duyet, long user_id_nguoi_huy,  int trangthai,
			long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		
		Xinchamcong xinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(idxinchamcong);
		Date now = new Date();
		xinchamcong.setTrangthai(1);
		xinchamcong.setNguoi_duyet(user_id_nguoi_duyet);
        xinchamcong.setCreated_at(now);
        xinchamcong.setUpdated_at(now);
		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}
	
	public void actionTuChoiChamCongVaoRa(long chucvu_id, int idxinchamcong,long user_id_nguoi_xin_cham_cong, String ly_do,  long user_id_nguoi_duyet, long user_id_nguoi_huy,  int trangthai,
			long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		Xinchamcong xinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(idxinchamcong);
		Date now = new Date();
		xinchamcong.setNguoi_huy(user_id_nguoi_huy);
		xinchamcong.setTrangthai(5);

		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}
	
	// Chấm công nửa ngày
	public void addXinChamCongNuaNgay(long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam, String check_in, String check_out,
			Date ngay_lam, long user_id_nguoi_duyet,long user_id_nguoi_huy, String loai_cham_cong, float diem, int trangthai,
			long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		int startValue = 1;  // Giá trị bắt đầu cho counter
		String counterName = "XinChamCongCounter";  // Tên của counter
		int idXinChamCong = (int) CounterLocalServiceUtil.increment(counterName, startValue);
		
		Xinchamcong xinchamcong = xinchamcongPersistence.create(idXinChamCong);
		Date now = new Date();
		xinchamcong.setUser_id(user_id_nguoi_xin_cham_cong);
		
		
		
	    if (ca_lam.equals("sang")) {
	    	xinchamcong.setCa_lam(ca_lam);
	    	xinchamcong.setCheck_in("07:30:00");
	    	xinchamcong.setCheck_out("11:30:00");
	    	xinchamcong.setLy_do(ly_do);
	    	xinchamcong.setChon_ly_do(loai_cham_cong);
		} else if(ca_lam.equals("chieu")) {
			xinchamcong.setCa_lam(ca_lam);
			xinchamcong.setCheck_in("13:30:00");
			xinchamcong.setCheck_out("16:30:00");
			xinchamcong.setLy_do(ly_do);
	    	xinchamcong.setChon_ly_do(loai_cham_cong);
		
		}	
		xinchamcong.setNgay_lam(ngay_lam);
		xinchamcong.setDiem(diem);
		// TRẠNG THÁI LÀ 0 LÀ KO ĐC ĐỒNG , 1 LÀ ĐỒNG Ý
		xinchamcong.setTrangthai(trangthai);
		xinchamcong.setCreated_at(now);
		xinchamcong.setUpdated_at(now);
		xinchamcong.setPhongban_id(phongban_id);
		

		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}
	
	public void actionDuyetChamCongNuaNgayCaNgay(long chucvu_id, long idxinchamcong,
			long user_id_nguoi_xin_cham_cong,
			long user_id_nguoi_duyet, long user_id_nguoi_huy,  
			int trangthai, long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		
		Xinchamcong xinchamcong = XinchamcongLocalServiceUtil.getXinchamcong((int)idxinchamcong);
		Date now = new Date();
		xinchamcong.setTrangthai(1);
		xinchamcong.setNguoi_duyet(user_id_nguoi_duyet);
        xinchamcong.setCreated_at(now);
        xinchamcong.setUpdated_at(now);
		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}
	
	public void actionTuChoiChamCongNuaNgayCaNgay(long chucvu_id, int idxinchamcong,long user_id_nguoi_xin_cham_cong, String ly_do,  long user_id_nguoi_duyet, long user_id_nguoi_huy,  int trangthai,
			long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		Xinchamcong xinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(idxinchamcong);
		Date now = new Date();
		xinchamcong.setNguoi_huy(user_id_nguoi_huy);
		xinchamcong.setTrangthai(5);
		xinchamcong.setCreated_at(now);
		xinchamcong.setUpdated_at(now);
		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}
	
	
	
	// Chấm công cả ngày 
	public void addXinChamCongCaNgay(long user_id_nguoi_xin_cham_cong, String ly_do, String ca_lam, String check_in, String check_out,
			Date tu_ngay,Date den_ngay, long user_id_nguoi_duyet,long user_id_nguoi_huy, String loai_cham_cong, float diem, int trangthai,
			long phongban_id, ServiceContext serviceContext) throws PortalException, SystemException {

		int startValue = 1;  // Giá trị bắt đầu cho counter
		String counterName = "XinChamCongCounter";  // Tên của counter
		int idXinChamCong = (int) CounterLocalServiceUtil.increment(counterName, startValue);
		
		Xinchamcong xinchamcong = xinchamcongPersistence.create(idXinChamCong);
		Date now = new Date();
		xinchamcong.setUser_id(user_id_nguoi_xin_cham_cong);
        xinchamcong.setChon_ly_do(loai_cham_cong);
        xinchamcong.setLy_do(ly_do);
		xinchamcong.setTu_ngay(tu_ngay);
		xinchamcong.setDen_ngay(den_ngay);
		xinchamcong.setDiem(diem);
		// TRẠNG THÁI LÀ 0 LÀ KO ĐC ĐỒNG , 1 LÀ ĐỒNG Ý
		xinchamcong.setTrangthai(0);
		xinchamcong.setCreated_at(now);
		xinchamcong.setUpdated_at(now);
		xinchamcong.setPhongban_id(phongban_id);
		

		XinchamcongLocalServiceUtil.updateXinchamcong(xinchamcong);

	}
	
	
	
	
}