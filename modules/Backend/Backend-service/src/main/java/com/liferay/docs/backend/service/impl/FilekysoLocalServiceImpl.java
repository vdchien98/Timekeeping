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

import com.liferay.docs.backend.model.Filekyso;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.Xinnghi;
import com.liferay.docs.backend.service.FilekysoLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.backend.service.XinnghiLocalServiceUtil;
import com.liferay.docs.backend.service.base.FilekysoLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.backend.model.Filekyso", service = AopService.class)
public class FilekysoLocalServiceImpl extends FilekysoLocalServiceBaseImpl {
	public Filekyso addfileSigned(String name, String fileUrl, long file_id , long user_id) throws PortalException {

		// Group group = GroupLocalServiceUtil.getGroup(groupId);
		// long userId = serviceContext.getUserId();
		 //Users user_lamdon = userLocalService.getUser(userId);
		Xinnghi  XinNghitaoRaFileXinNghi = XinnghiLocalServiceUtil.getXinnghi((int)file_id);
		Users user_NguoiKy = UsersLocalServiceUtil.getUserbyUserId(user_id);
		System.out.println("user_NguoiKy ===="+ user_NguoiKy);
		long chucvu = user_NguoiKy.getChucvu_id();
		System.out.println("chucvu ===== "+ chucvu);
		int filekysoId = (int) counterLocalService.increment(Filekyso.class.getName());

		Filekyso filekyso = createFilekyso(filekysoId);

		filekyso.setId(filekysoId);
		filekyso.setFile_id_nosigned(file_id);
		filekyso.setFileurl_signed(fileUrl);
		filekyso.setNguoilamdon_id(XinNghitaoRaFileXinNghi.getUser_id());
		filekyso.setNguoikydon_id(user_id);

		if (chucvu == 42604 || chucvu == 42605) {
			filekyso.setTrangthai(2);
		} else if (chucvu == 42602 || user_NguoiKy.getPhu_trach_phong()== 1) {
			filekyso.setTrangthai(1);
		} else {
			filekyso.setTrangthai(0);
		}
		
		
		

		// Dong ma return super.addContacto(contacto);
		// co y nghia rang lop con đang ghi đe (override) phương thuc addContacto cua
		// lop cha
		return super.addFilekyso(filekyso);
	}
	
	
	public Filekyso upadtefileSigned(String name, String fileUrl, long file_id , long user_id) throws PortalException {

		// Group group = GroupLocalServiceUtil.getGroup(groupId);
		// long userId = serviceContext.getUserId();
		 //Users user_lamdon = userLocalService.getUser(userId);
		Xinnghi  XinNghitaoRaFileXinNghi = XinnghiLocalServiceUtil.getXinnghi((int)file_id);
		Users user_NguoiKy = UsersLocalServiceUtil.getUserbyUserId(user_id);
		long chucvu = user_NguoiKy.getChucvu_id();
		int filekysoId = (int) counterLocalService.increment(Filekyso.class.getName());

		Filekyso filekyso = createFilekyso(filekysoId);

		filekyso.setId(filekysoId);
		filekyso.setFile_id_nosigned(file_id);
		filekyso.setFileurl_signed(fileUrl);
		filekyso.setNguoilamdon_id(XinNghitaoRaFileXinNghi.getUser_id());
		filekyso.setNguoikydon_id(user_id);

		if (chucvu == 42604 || chucvu == 42605) {
			filekyso.setTrangthai(2);
		} else if (chucvu == 42602 || user_NguoiKy.getPhu_trach_phong()==1) {
			filekyso.setTrangthai(1);
		} else {
			filekyso.setTrangthai(0);
		}
		
		
		

		// Dong ma return super.addContacto(contacto);
		// co y nghia rang lop con đang ghi đe (override) phương thuc addContacto cua
		// lop cha
		return super.addFilekyso(filekyso);
	}
	

	@Override
	public Filekyso addFilekyso(Filekyso contacto) {
		// nem 1 ngoai le ten UnsupportedOperationException vs message la Not supported
		// từ khóa throw trong Java được sử dụng để ném một ngoại lệ (exception) trong
		// chương trình
		throw new UnsupportedOperationException("Not supported.");
	}
}