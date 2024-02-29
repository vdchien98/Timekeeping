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
import com.liferay.docs.backend.model.Ngaylamviec;
import com.liferay.docs.backend.model.Ngaynghile;
import com.liferay.docs.backend.service.base.NgaylamviecLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.backend.model.Ngaylamviec",
	service = AopService.class
)
public class NgaylamviecLocalServiceImpl extends NgaylamviecLocalServiceBaseImpl {
	public Ngaylamviec saveNgayLamViec( int nam,int thang ,int songaylamviec, ServiceContext serviceContext)
			throws PortalException, SystemException {
       // System.out.println("da vao den day **********+++++++++++");
		int idNgayNgayLamViec = (int) CounterLocalServiceUtil.increment();
		//idNgayNgayLamViec++;
		Ngaylamviec ngaylamviec = ngaylamviecPersistence.create(idNgayNgayLamViec);
		Date now = new Date();
		ngaylamviec.setId(idNgayNgayLamViec);
		ngaylamviec.setNam(nam);
		ngaylamviec.setThang(thang);
		ngaylamviec.setSo_ngay_lam_viec(songaylamviec);
		ngaylamviec.setCreated_at(now);
		ngaylamviec.setUpdated_at(now);
		ngaylamviecLocalService.updateNgaylamviec(ngaylamviec);
		return ngaylamviec;
	}
	
	public Ngaylamviec updateNgayLamViec(int id, int thang, int songaylamviec, ServiceContext serviceContext)
			throws PortalException, SystemException {
  
	
		Date now = new Date();
		Ngaylamviec ngaylamviec = getNgaylamviec(id);
	
		ngaylamviec.setThang(thang);
		ngaylamviec.setSo_ngay_lam_viec(songaylamviec);
        ngaylamviecLocalService.updateNgaylamviec(ngaylamviec);
		
		return ngaylamviec;
	}
	
//	public Ngaylamviec updateNgayLamViecToanBo(int nam,int thang ,int songaylamviec, ServiceContext serviceContext) throws PortalException, SystemException {
//  
////	
////		Date now = new Date();
////		Ngaylamviec ngaynghile = getNgaynghile(id);
////	
////		ngaynghile.setTen(ten);
////		ngaynghile.setNgay_nghi(ngay_nghi);
////		ngaynghile.setTrangthai(trangthai);
////		ngaynghile.setCreated_at(now);
////		ngaynghile.setUpdated_at(now);
////
////		ngaynghileLocalService.updateNgaynghile(ngaynghile);
////		return ngaynghile;
//	}
	
	
	
	
	
}