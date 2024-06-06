package com.liferay.docs.adminphongban.portlet.portlet;

import com.liferay.docs.adminphongban.portlet.constants.AdminPhongBanPortletKeys;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.portal.kernel.dao.db.Index;
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
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AdminPhongBan",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminphongban/AdminPhongBan.jsp",
		"javax.portlet.name=" + AdminPhongBanPortletKeys.ADMINPHONGBAN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminPhongBanPortlet extends MVCPortlet {
	public void savePhongBan(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		int idPhongBan = ParamUtil.getInteger(request, "idPhongBan");
		String tenphong = ParamUtil.getString(request, "tenphong");
		int trangthai = ParamUtil.getInteger(request, "trangthai");
		int nguoiPhuTrach = ParamUtil.getInteger(request, "nguoi_phu_trach");	
		try {
			if (idPhongBan == 0) {
				PhongbanLocalServiceUtil.addPhongBan(tenphong, trangthai, nguoiPhuTrach, serviceContext);
			} else {
				Phongban phongbanedit = PhongbanLocalServiceUtil.getPhongban(idPhongBan);
				if (phongbanedit != null) {
					PhongbanLocalServiceUtil.updatePhongBan(idPhongBan, tenphong, trangthai, nguoiPhuTrach, serviceContext);
				} else {
					System.out.println("Not  Find Phong Ban");
				}
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		  response.sendRedirect("/admin/phong-ban");
	}
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<Phongban> phongBanList = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		System.out.println("phongBanList **** "+ phongBanList);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		httpServletRequest.setAttribute("usersList", usersList);
		
		// update số nhân viên của mỗi phòng 
		for (Phongban phongban : phongBanList) {
			List<Users> ListUsersofMotPhong = new ArrayList<>();
		
			for (Users user : usersList) {
				if (phongban.getId()== user.getPhongban_id() && user.getTrangthai()==1) {
					ListUsersofMotPhong.add(user);
				}			
			}
			ServiceContext serviceContext = new ServiceContext();
			try {
				PhongbanLocalServiceUtil.updateSoThanhVienTuAllPhong(phongban.getId(), ListUsersofMotPhong.size(), serviceContext);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("--------- "+ ListUsersofMotPhong);
			
		}
		
		
		
		
		
		
		httpServletRequest.setAttribute("phongBanList", phongBanList);
		int idPhongBan = ParamUtil.getInteger(renderRequest, "idPhongBan");
		if (idPhongBan > 0) {
			try {
				Phongban phongbanedit = PhongbanLocalServiceUtil.getPhongban(idPhongBan);
				System.out.println("phongbanedit ****++++++++++++++  "+ phongbanedit);
				httpServletRequest.setAttribute("phongbanedit", phongbanedit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		ServiceContext serviceContext = new ServiceContext();
//		try {
//			List<Users> entities = UsersLocalServiceUtil.getUserGiamDocActive(serviceContext);
//			renderRequest.setAttribute("usersLanhDao", entities);
//		} catch (SystemException e) {
//			e.printStackTrace();
//		} catch (PortalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		super.render(renderRequest, renderResponse);
	}
	
	
}