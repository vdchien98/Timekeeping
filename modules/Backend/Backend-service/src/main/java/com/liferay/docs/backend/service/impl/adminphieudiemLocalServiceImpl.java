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
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.docs.backend.service.adminphieudiemLocalServiceUtil;
import com.liferay.docs.backend.service.base.adminphieudiemLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.awt.TextArea;
import java.util.Date;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.backend.model.adminphieudiem",
	service = AopService.class
)
public class adminphieudiemLocalServiceImpl extends adminphieudiemLocalServiceBaseImpl {
	public adminphieudiem addcauhoi(String uuid, long userid, String nhomcauhoi, String noidungcauhoi,long thuocnhomcauhoinao ,Double diemtoida,int trangthaicauhoi, ServiceContext serviceContext)
			throws PortalException, SystemException {
		

		// tạo tài khoản và người dùng vào hệ thống Liferay
		long IdUserLiferay = CounterLocalServiceUtil.increment("adminphieudiem");
		Date now = new Date();
		int idcauhoi = (int) IdUserLiferay;
		adminphieudiem cauhoi = adminphieudiemPersistence.create(idcauhoi);

    	// Tạo bảng user cho cham cong
        cauhoi.setId(idcauhoi);
        cauhoi.setUuid(uuid);
        cauhoi.setUser_id(userid);
        cauhoi.setNhomcauhoi(nhomcauhoi);
        cauhoi.setNoidungcauhoi(noidungcauhoi);
      // cauhoi.setThuocnhomcauhoinao(thuocnhomcauhoinao);
        cauhoi.setDiemtoida(diemtoida);
        cauhoi.setTrangthaicauhoi(trangthaicauhoi);
		cauhoi.setCreated_at(now);
		cauhoi.setUpdated_at(now);

		adminphieudiemPersistence.update(cauhoi);
		return cauhoi;
	}
//	public adminphieudiem updatecauhoi(int idcauhoi, String uuid, int cocauhoiconko, ServiceContext serviceContext)
//			throws PortalException, SystemException {
//		
//
//		// tạo tài khoản và người dùng vào hệ thống Liferay
//		Date now = new Date();
//		adminphieudiem cauhoi = adminphieudiemLocalServiceUtil.getadminphieudiem(idcauhoi);
//
//    	// Tạo bảng user cho cham cong
//		
//		cauhoi.setCreated_at(now);
//		cauhoi.setUpdated_at(now);
//
//		adminphieudiemPersistence.update(cauhoi);
//		return cauhoi;
//	}
	
}