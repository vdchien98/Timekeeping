package com.liferay.docs.navbar.portlet.portlet;

import com.liferay.docs.backend.model.Chucvu;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.ChucvuLocalServiceUtil;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.navbar.portlet.constants.NavbarPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleServiceUtil;
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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Navbar",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NavbarPortletKeys.NAVBAR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NavbarPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// xá»­ lÃ½ xong hiá»ƒn thá»‹ theo quyá»�n 
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getLayout().getGroupId();
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
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("quyenquantri", quyenquantri);
		// xá»­ lÃ½ hiá»‡n thÃ´ng tin 


		List<Phongban> entitiesPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		renderRequest.setAttribute("selectPhongBan", entitiesPhongBan);
		List<Chucvu> entitiesChucvus = ChucvuLocalServiceUtil.getChucvus(-1, -1);
		renderRequest.setAttribute("selectChucVu", entitiesChucvus);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		httpServletRequest.setAttribute("usersList", usersList);
		
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		if (user == null) {
			// renderRequest.setAttribute("thongtintaikhoan", null);
		}else {
			//System.out.println("user -------- "+ user);
			renderRequest.setAttribute("thongtintaikhoan", user);
		}
		

		super.render(renderRequest, renderResponse);
	}
}