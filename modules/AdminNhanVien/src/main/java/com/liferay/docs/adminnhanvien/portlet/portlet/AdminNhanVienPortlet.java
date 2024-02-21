package com.liferay.docs.adminnhanvien.portlet.portlet;

import com.liferay.docs.adminnhanvien.portlet.constants.AdminNhanVienPortletKeys;
import com.liferay.docs.backend.model.Chucvu;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.ChucvuLocalServiceUtil;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AdminNhanVien", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminnhanvien/AdminNhanVien.jsp",
		"javax.portlet.name=" + AdminNhanVienPortletKeys.ADMINNHANVIEN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AdminNhanVienPortlet extends MVCPortlet {
	 private boolean isTimKiem = false;
	 private String keyTimKiem;
	
	public void saveNhanVien(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId****** " + userId);
		ServiceContext serviceContext = new ServiceContext();
		int id = ParamUtil.getInteger(request, "idUserEdit");
		System.out.println("id la *********------- " + id);
		String hoTen = ParamUtil.getString(request, "hovaten");
		String email = ParamUtil.getString(request, "email");
		long chucvu = ParamUtil.getLong(request, "chucvu_id");
		System.out.println("chucvu ----- "+ chucvu);
		
		
		long trangThai = ParamUtil.getLong(request, "trangthai");
		long phongban_id = ParamUtil.getLong(request, "phongban_id");
		
		System.out.println("phongban_id ----- "+ phongban_id);
		
		
		long ca_lam_id = ParamUtil.getLong(request, "ca_lam_id");
		
		long caLamToi = ParamUtil.getLong(request, "ca_lam_toi");
		String ma_xac_nhan = "chien";
		String zaloId = ParamUtil.getString(request, "zalo_id");
		long chamCongNgoai = ParamUtil.getLong(request, "cham_cong_ngoai");
		long soNgayNghiPhep = ParamUtil.getLong(request, "so_ngay_nghi_phep");
		int phuTrachPhong = ParamUtil.getInteger(request, "phu_trach_phong");
		try {
			if (id == 0) {
				UsersLocalServiceUtil.addNhanVien(hoTen, email, chucvu, trangThai, phongban_id, ca_lam_id, caLamToi,
						ma_xac_nhan, zaloId, chamCongNgoai, soNgayNghiPhep, phuTrachPhong, serviceContext);
			} else {
				Users user = UsersLocalServiceUtil.getUsers(id);
				if (user != null) {
					UsersLocalServiceUtil.updateNhanVien(id, hoTen, email, chucvu, trangThai, phongban_id, ca_lam_id,
							caLamToi, ma_xac_nhan, zaloId, chamCongNgoai, soNgayNghiPhep, phuTrachPhong,
							serviceContext);
				} else {
					System.out.println("Not Find");
				}
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		response.sendRedirect("/admin/nhan-vien");
	}

	public void deleteNhanVien(ActionRequest request, ActionResponse response) throws PortalException {
		int deleteUserId = ParamUtil.getInteger(request, "deleteUserId");
		try {
			UsersLocalServiceUtil.deleteUsers(deleteUserId);
			response.sendRedirect("/admin/nhan-vien");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void TimKiem(ActionRequest request, ActionResponse response) throws PortalException {
		try {
			isTimKiem = true;
			System.out.println("da vao dc day ");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			keyTimKiem = ParamUtil.getString(request, "timkkiemNhanVien");
			System.out.println("keyTimKiem ---- "+ keyTimKiem);
			
			ServiceContext serviceContext = new ServiceContext();
			response.sendRedirect("/admin/nhan-vien");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		if (isTimKiem == false) {
			List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			httpServletRequest.setAttribute("usersList", usersList);
			int id = ParamUtil.getInteger(renderRequest, "id");
			System.out.println("id la ----- " + id);
			if (id > 0) {
				try {
					Users useredit = UsersLocalServiceUtil.getUsers(id);
					httpServletRequest.setAttribute("useredit", useredit);
				} catch (Exception e) {
					System.out.println("chạy vào đây******");
					e.printStackTrace();
				}
			}

			try {
				List<Phongban> entitiesPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
				renderRequest.setAttribute("selectPhongBan", entitiesPhongBan);
			} catch (SystemException e) {
				e.printStackTrace();
			}

			try {
				List<Chucvu> entitiesChucvus = ChucvuLocalServiceUtil.getChucvus(-1, -1);
				renderRequest.setAttribute("selectChucVu", entitiesChucvus);
			} catch (SystemException e) {
				e.printStackTrace();
			}

		}else  {
			System.out.println("keyTimKiem da vao dc day  ---- " + keyTimKiem);
			isTimKiem=!isTimKiem;
			String keyChuan = "%" + keyTimKiem + "%";
			System.out.println("keyChuan  -++++++++++---------" + keyChuan);
			List<Users> usersList = UsersLocalServiceUtil.getDuLieuTimKiem(keyChuan);
			System.out.println("usersList  -++++++++++---------" + usersList);
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			httpServletRequest.setAttribute("usersList", usersList);
			try {
				List<Phongban> entitiesPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
				renderRequest.setAttribute("selectPhongBan", entitiesPhongBan);
			} catch (SystemException e) {
				e.printStackTrace();
			}

			try {
				List<Chucvu> entitiesChucvus = ChucvuLocalServiceUtil.getChucvus(-1, -1);
				renderRequest.setAttribute("selectChucVu", entitiesChucvus);
			} catch (SystemException e) {
				e.printStackTrace();
			}

		}

		super.render(renderRequest, renderResponse);
	}

	
//	public void addAllNhanVien(ActionRequest request, ActionResponse response) throws PortalException {
//	ServiceContext serviceContext = new ServiceContext();
//	try {
//	//	 UsersLocalServiceUtil.addOneAllNhanVien(serviceContext);
//		System.out.println("--------- da vao dc day kkkkkkkkkkkkkkkkkkkk---- ");
//		 UsersLocalServiceUtil.UpdateAllNhanVien(serviceContext);
//		
//		 response.sendRedirect("/admin/nhan-vien");
//	}
//
//	catch (Exception e) {
//		e.printStackTrace();
//	}
//
//}
//	 @ProcessAction(name = "redirectToCreate")
//	    public void redirectToCreate(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
//
//	        // Retrieve userId from the action request
//	        long userId = ParamUtil.getLong(actionRequest, "_com_liferay_docs_adminnhanvien_portlet_AdminNhanVienPortlet_INSTANCE_difv_userId");
//
//	        // Construct the URL for redirection
//	        String redirectURL = "/admin/nhan-vien/create?p_p_id=com_liferay_docs_adminnhanvien_portlet_AdminNhanVienCreatePortlet_INSTANCE_xyz&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_com_liferay_docs_adminnhanvien_portlet_AdminNhanVienCreatePortlet_INSTANCE_xyz_userId=" + userId;
//
//	        // Use Liferay's sendRedirect method
//	        actionResponse.sendRedirect(redirectURL);
//	    }

}