package com.liferay.docs.adminchucvu.portlet.portlet;

import com.liferay.docs.adminchucvu.portlet.constants.AdminChucVuPortletKeys;
import com.liferay.docs.backend.model.Chucvu;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.ChucvuLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AdminChucVu", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminchucvu/AdminChucVu.jsp",
		"javax.portlet.name=" + AdminChucVuPortletKeys.ADMINCHUCVU, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AdminChucVuPortlet extends MVCPortlet {
	public void saveChucVu(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		int idChucVu = ParamUtil.getInteger(request, "idChucVu");
		String name = ParamUtil.getString(request, "name");
		int roleChucVu = ParamUtil.getInteger(request, "roleChucVu");
		System.out.println("roleChucVu ---------- "+ roleChucVu);

		try {
			if (idChucVu == 0) {
				ChucvuLocalServiceUtil.addChucVu(name, roleChucVu, serviceContext);

			}else {
				Chucvu chucvuedit = ChucvuLocalServiceUtil.getChucvu(idChucVu);
				if (chucvuedit != null) {
					ChucvuLocalServiceUtil.updateChucVu(idChucVu, name, roleChucVu, serviceContext);
				} else {
					System.out.println("Not  Find Phong Ban");
				}
				
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		response.sendRedirect("/admin/chuc-vu");

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Chucvu> chucVuList = ChucvuLocalServiceUtil.getChucvus(-1, -1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("chucVuList", chucVuList);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		//UpdatechucVu
		
		// update số nhân viên của mỗi chức vụ
		for (Chucvu chucvu : chucVuList) {
			
			
			List<Users> ListUsersofMotChuVu = new ArrayList<>();
		
			for (Users user : usersList) {
				if (chucvu.getId()== user.getChucvu_id() && user.getTrangthai()==1) {
					ListUsersofMotChuVu.add(user);
				}			
			}
			ServiceContext serviceContext = new ServiceContext();
			try {
				ChucvuLocalServiceUtil.updateSoThanhVienTuALLChucVu(chucvu.getId(), ListUsersofMotChuVu.size(), serviceContext);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("--------- "+ ListUsersofMotChuVu);
			
		}
		
		
		
		

		super.render(renderRequest, renderResponse);
	}
}