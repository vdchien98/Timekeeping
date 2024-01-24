package com.liferay.docs.adminnhanvien.portlet.portlet;

import com.liferay.docs.adminnhanvien.portlet.constants.AdminNhanVienPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AdminNhanVien",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminnhanvien/AdminNhanVien.jsp",
		"javax.portlet.name=" + AdminNhanVienPortletKeys.ADMINNHANVIEN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminNhanVienPortlet extends MVCPortlet {
	
	
}