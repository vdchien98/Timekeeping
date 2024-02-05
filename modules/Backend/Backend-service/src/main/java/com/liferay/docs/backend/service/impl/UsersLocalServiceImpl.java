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
import com.liferay.docs.backend.service.base.UsersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.backend.model.Users", service = AopService.class)
public class UsersLocalServiceImpl extends UsersLocalServiceBaseImpl {
	public Users addNhanVien(String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi, String ma_xac_nhan, String zalo_id, long cham_cong_ngoai,
			long so_ngay_nghi_phep, int phu_trach_phong, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("hovaten ---- " + hovaten);
		System.out.println("emai ----- " + email);
		System.out.println("chucvu_id ---- " + chucvu_id);
		System.out.println("trangthai ---- " + trangthai);
		System.out.println("phongban_id ---- " + phongban_id);
		System.out.println("so_ngay_nghi_phep ---- " + so_ngay_nghi_phep);
		System.out.println("phu_trach_phong ---- " + phu_trach_phong);

		// tạo tài khoản và người dùng vào hệ thống Liferay
		long IdUserLiferay = CounterLocalServiceUtil.increment();
		Date now = new Date();
		int idUser = (int) IdUserLiferay;
		System.out.println("idUser ---- " + idUser);
		long companyId = PortalUtil.getDefaultCompanyId();
		System.out.println("companyId ---- " + companyId);
		Locale locale = new Locale("", "");
		long prefixId = 0;
		long suffixId = 0;
		boolean male = true;

		int birthdayMonth = 4;
		int birthdayDay = 1;
		int birthdayYear = 2000;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;
		// user.setPasswordReset(false);
		// user.setLastFailedLoginDate(now);

		System.out.println("locale ---- " + locale);
		System.out.println("prefixId ---- " + prefixId);
		System.out.println("suffixId ---- " + suffixId);
		System.out.println("male ---- " + male);
		System.out.println("groupIds ---- " + groupIds);
		System.out.println("organizationIds ---- " + organizationIds);
		System.out.println("roleIds ---- " + roleIds);
		System.out.println("sendEmail ---- " + sendEmail);

		User userLiferay = UserLocalServiceUtil.addUser(20125, companyId, true, ma_xac_nhan, ma_xac_nhan, true, hovaten,
				email, locale, hovaten, "", "", prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
				jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		userLiferay.setAgreedToTermsOfUse(true);
		userLiferay.setFailedLoginAttempts(0);

		UserLocalServiceUtil.updateUser(userLiferay);

		System.out.println("userLiferay la ====== " + userLiferay);

//		User userLiferay =  UserLocalServiceUtil.addUser(20125, companyId, true, ma_xac_nhan, ma_xac_nhan, 
//				true, hovaten, email, locale, hovaten, "", "", 
//				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, 
//				organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		// Tạo bảng user cho cham cong
		Users users = usersPersistence.create(idUser);
		users.setId(idUser);
		users.setHovaten(hovaten);
		users.setUserId(userLiferay.getUserId());
		users.setEmail(email);
		users.setChucvu_id(chucvu_id);
		users.setTrangthai(trangthai);
		users.setPhongban_id(phongban_id);
		users.setCa_lam_id(ca_lam_id);
		users.setCa_lam_toi(ca_lam_toi);
		users.setMa_xac_nhan(ma_xac_nhan);
		users.setZalo_id(zalo_id);
		users.setCham_cong_ngoai(cham_cong_ngoai);
		users.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		users.setPhu_trach_phong(phu_trach_phong);
		users.setCreated_at(now);
		users.setUpdated_at(now);
		// users.setGroupId(groupId);

		usersLocalService.updateUsers(users);
		return users;
	}

	public Users updateNhanVien(int id, String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi, String ma_xac_nhan, String zalo_id, long cham_cong_ngoai,
			long so_ngay_nghi_phep, int phu_trach_phong, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Users user = getUsers(id);
		user.setHovaten(hovaten);
		user.setEmail(email);
		user.setChucvu_id(chucvu_id);
		user.setTrangthai(trangthai);
		user.setPhongban_id(phongban_id);
		user.setCa_lam_id(ca_lam_id);
		user.setCa_lam_toi(ca_lam_toi);
		user.setMa_xac_nhan(ma_xac_nhan);
		user.setZalo_id(zalo_id);
		user.setCham_cong_ngoai(cham_cong_ngoai);
		user.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		user.setPhu_trach_phong(phu_trach_phong);
		user.setCreated_at(now);
		user.setUpdated_at(now);
		user.setGroupId(groupId);
		usersLocalService.updateUsers(user);
		return user;
	}

	public Users deleteUser(int id, ServiceContext serviceContext) throws PortalException {
		Users user = getUsers(id);
		user = deleteUsers(id);
		return user;
	}

	public Users updateUser(int id, String ma_xac_nhan, ServiceContext serviceContext) throws PortalException {
		Users user = getUsers(id);
		System.out.println("uer *****" + user);
		user.setMa_xac_nhan(ma_xac_nhan);
		usersLocalService.updateUsers(user);
		return user;
	}

//	public void addOneAllNhanVien(ServiceContext serviceContext) throws PortalException {
//	System.out.println("da vao addOneAllNhanVien ");
//	 
//	  
//	  
//	   List<Users> listUser = usersLocalService.getUserses(-1,-1);
//	   listUser = listUser.stream().filter(n -> n.getId()<62)
//               .collect(Collectors.toList());
//		for (Users Usertest : listUser) {
//			  System.out.println("Usertest ---------" + Usertest);
//			  
//		   long companyId = PortalUtil.getDefaultCompanyId();
//			Locale locale = new Locale("", "");
//			long prefixId = 0	;
//			long suffixId = 0;
//			boolean male = true;
//			int birthdayMonth = 4;
//			int birthdayDay = 1;
//			int birthdayYear = 2000;
//			String jobTitle = "";
//			long[] groupIds = null;
//			long[] organizationIds = null;
//			long[] roleIds = null;
//			long[] userGroupIds = null;
//			boolean sendEmail = true;
//		
//			
//		
//			
//		
//			User userLiferay = UserLocalServiceUtil.addUser(20125, companyId, 
//					true, Usertest.getMa_xac_nhan(), Usertest.getMa_xac_nhan(), true, Usertest.getHovaten(), 
//					Usertest.getEmail()+"@bacninh.gov.vn", locale, Usertest.getHovaten(), "", "", prefixId, 
//					suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, 
//					groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
//		
//			 updateUserIdinTimekingUser( Usertest.getId(),  userLiferay.getUserId() , serviceContext);
//
//			UserLocalServiceUtil.updateUser(userLiferay);
//	}
//	  
//	  
//	
//
//
//
//
//}
//	
//	public Users updateUserIdinTimekingUser(int id, long UserId , ServiceContext serviceContext) throws PortalException {
//		Users user = getUsers(id);
//		System.out.println("uer *****"+user);
//		user.setUserId(UserId);
//		usersLocalService.updateUsers(user);
//		return user;
//	}

	public void UpdateAllNhanVien(ServiceContext serviceContext) throws PortalException {
		System.out.println("da vao addOneAllNhanVien ");

		List<Users> listUser = usersLocalService.getUserses(-1, -1);
		listUser = listUser.stream().filter(n -> n.getId() < 62).collect(Collectors.toList());
		for (Users Usertest : listUser) {
			System.out.println("Usertest ---------" + Usertest);

			updateData(Usertest.getId(), serviceContext);

		}

	}

	public Users updateData(int id, ServiceContext serviceContext) throws PortalException {
		Users user = getUsers(id);
		System.out.println("uer *****" + user);
		long chucvuId = user.getChucvu_id();
		long phongbanId = user.getPhongban_id();

		if (chucvuId == 1) {
			user.setChucvu_id(42604);
			usersLocalService.updateUsers(user);
		} else if (chucvuId == 2) {
			user.setChucvu_id(42605);
			usersLocalService.updateUsers(user);
		} else if (chucvuId == 3) {
			user.setChucvu_id(42602);
			usersLocalService.updateUsers(user);
		} else if (chucvuId == 4) {
			user.setChucvu_id(42603);
			usersLocalService.updateUsers(user);
		} else if (chucvuId == 6) {
			user.setChucvu_id(42601);
			usersLocalService.updateUsers(user);
		} else {
			System.out.println("Khong co chuc vu ");
		}

		if (phongbanId == 1) {
			user.setPhongban_id(42523);
			usersLocalService.updateUsers(user);
		} else if (phongbanId == 2) {
			user.setPhongban_id(42525);
			usersLocalService.updateUsers(user);
		} else if (phongbanId == 3) {
			user.setPhongban_id(42524);
			usersLocalService.updateUsers(user);
		} else if (phongbanId == 6) {
			user.setPhongban_id(42527);
			usersLocalService.updateUsers(user);
		} else if (phongbanId == 12) {
			user.setPhongban_id(42529);
			usersLocalService.updateUsers(user);
		} else if (phongbanId == 13) {
			user.setPhongban_id(42526);
			usersLocalService.updateUsers(user);
		} else if (phongbanId == 14) {
			user.setPhongban_id(42528);
			usersLocalService.updateUsers(user);
		} else {
			System.out.println("Khong co phon ban  ");
		}
		System.out.println("ket thuc----- ");
		return user;
	}

}