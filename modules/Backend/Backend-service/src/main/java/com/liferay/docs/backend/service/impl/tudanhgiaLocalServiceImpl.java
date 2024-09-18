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
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.docs.backend.model.tudanhgia;
import com.liferay.docs.backend.service.base.tudanhgiaLocalServiceBaseImpl;
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
	property = "model.class.name=com.liferay.docs.backend.model.tudanhgia",
	service = AopService.class
)
public class tudanhgiaLocalServiceImpl extends tudanhgiaLocalServiceBaseImpl {

	public tudanhgia addcautraloi(long userid, String thongtintudanhgia, String ykienkhac,String file_url ,
			Double tongdiem,int trangthaixacnhan,int trangthaikyso, int thang, int nam, long phongban_id, String xeploai, ServiceContext serviceContext)
			throws PortalException, SystemException {
		
    System.out.println(" da vao dc day -------------------------- ");
		// tạo tài khoản và người dùng vào hệ thống Liferay
		long IdUserLiferay = CounterLocalServiceUtil.increment("tudanhgia");
		Date now = new Date();
		int idcauhoi = (int) IdUserLiferay;
		tudanhgia cautraloi = tudanhgiaPersistence.create(idcauhoi);
		System.out.println(" da vao dc day --------------------------cautraloi ");
		cautraloi.setId(idcauhoi);
		cautraloi.setUser_id(userid);
		cautraloi.setThongtintudanhgia(thongtintudanhgia);
		cautraloi.setYkienkhac(ykienkhac);
		cautraloi.setFile_url(file_url);
		cautraloi.setTongdiem(tongdiem);
		cautraloi.setTrangthaixacnhan(trangthaixacnhan);
		cautraloi.setTrangthaikyso(trangthaikyso);
		cautraloi.setThang(thang);
		cautraloi.setNam(nam);
		cautraloi.setPhongban_id(phongban_id);
		cautraloi.setXeploai(xeploai);
		cautraloi.setCreated_at(now);
		cautraloi.setUpdated_at(now);
		tudanhgiaLocalService.updatetudanhgia(cautraloi);
		return cautraloi;
	}
}