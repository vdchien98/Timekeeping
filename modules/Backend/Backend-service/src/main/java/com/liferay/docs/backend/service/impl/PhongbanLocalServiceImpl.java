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
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.service.base.PhongbanLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.backend.model.Phongban", service = AopService.class)
public class PhongbanLocalServiceImpl extends PhongbanLocalServiceBaseImpl {
	public Phongban addPhongBan(String tenphong, int trangthai, int nguoi_phu_trach, ServiceContext serviceContext)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		int idPhongBan = (int) CounterLocalServiceUtil.increment();
		System.out.println("id la " + idPhongBan);
		Phongban phongban = phongbanPersistence.create(idPhongBan);
		System.out.println("da vao savephongban ---- backen");
		Date now = new Date();
		phongban.setId(idPhongBan);
		phongban.setTenphong(tenphong);
		phongban.setTrangthai(trangthai);
		phongban.setNguoi_phu_trach(nguoi_phu_trach);
		phongban.setCreated_at(now);
		phongban.setUpdated_at(now);
		phongban.setGroupId(groupId);
		phongbanLocalService.updatePhongban(phongban);
		return phongban;
	}

	public Phongban updatePhongBan(int id, String tenphong, int trangthai, int nguoi_phu_trach,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Phongban phongban = getPhongban(id);
		phongban.setTenphong(tenphong);
		phongban.setTrangthai(trangthai);
		phongban.setNguoi_phu_trach(nguoi_phu_trach);
		phongban.setCreated_at(now);
		phongban.setUpdated_at(now);
		phongban.setGroupId(groupId);
		phongbanLocalService.updatePhongban(phongban);

		return phongban;
	}

	public Phongban updateSoThanhVienTuCreateNhanVien(int id, int trangthai, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("trangthai updateSoThanhVienTuCreateNhanVien-------------- "+ trangthai);
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Phongban phongban = getPhongban(id);
		if (trangthai > 0) {
			phongban.setSo_thanh_vien(phongban.getSo_thanh_vien() + 1);

		} else {
			phongban.setSo_thanh_vien(phongban.getSo_thanh_vien() - 1);

		}
		phongban.setCreated_at(now);
		phongban.setUpdated_at(now);
		phongban.setGroupId(groupId);
		phongbanLocalService.updatePhongban(phongban);

		return phongban;
	}

	public Phongban updateSoThanhVienTuAllPhong(int id, long so_thanh_vien, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Phongban phongban = getPhongban(id);
		phongban.setSo_thanh_vien(so_thanh_vien);
		phongban.setCreated_at(now);
		phongban.setUpdated_at(now);
		phongban.setGroupId(groupId);
		phongbanLocalService.updatePhongban(phongban);

		return phongban;
	}

}