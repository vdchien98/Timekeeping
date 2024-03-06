package com.liferay.docs.sidebar.portlet.portlet;

import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.sidebar.portlet.constants.SidebarPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.Users_OrgsTable;
import com.liferay.portal.kernel.model.Users_RolesTable;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		// Chú y khi nhung portlet vao thi thay doi
		"com.liferay.portlet.instanceable=false",
		//
		"javax.portlet.display-name=Sidebar",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SidebarPortletKeys.SIDEBAR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SidebarPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getLayout().getGroupId();
	//	System.out.println("userId Dang Nhap groupId " + groupId);
		boolean quyenquantri = false ;
		try {
			List<Role> userRoles = RoleServiceUtil.getUserRoles(userId);
			for (Role role : userRoles) {
				if (role.getRoleId() == 20103) {
					quyenquantri = true ;
				} else if (role.getRoleId() == 20107) {
					quyenquantri = true ;
				}
			}
			//System.out.println("userGroupRoles ---- "+ userRoles);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		renderRequest.setAttribute("quyenquantri", quyenquantri);

		
		
		
		
		
		
		super.render(renderRequest, renderResponse);
	}
}