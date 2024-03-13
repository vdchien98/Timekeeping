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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private int dodaibang_dataTable = 10;
	private int trangsocanlay = 1;

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
		System.out.println("chucvu ----- " + chucvu);

		long trangThai = ParamUtil.getLong(request, "trangthai");
		long phongban_id = ParamUtil.getLong(request, "phongban_id");

		System.out.println("phongban_id ----- " + phongban_id);

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
			System.out.println("keyTimKiem ---- " + keyTimKiem);

			ServiceContext serviceContext = new ServiceContext();
			response.sendRedirect("/admin/nhan-vien");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dodaibang_dataTable(ActionRequest request, ActionResponse response) throws PortalException {

		try {
			dodaibang_dataTable = ParamUtil.getInteger(request, "dataTable_length");
			System.out.println("dodaibang_dataTable " + dodaibang_dataTable);
			response.sendRedirect("/admin/nhan-vien");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void PhantrangUsers(ActionRequest request, ActionResponse response) throws PortalException {
		System.out.println("da vao day roi hihihihihihihihihihihihi");
		try {
			trangsocanlay = ParamUtil.getInteger(request, "trangsocanlay");
			System.out.println("trangsocanlay )))))))))))))) " + trangsocanlay);
			response.sendRedirect("/admin/nhan-vien");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public class UserNew {
//		private String name;
//
//		// Các getter và setter cho trường name
//
//		public UserNew(String name) {
//			this.name = name;
//		}
//	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			List<Phongban> entitiesPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
			renderRequest.setAttribute("selectPhongBan", entitiesPhongBan);
			List<Chucvu> entitiesChucvus = ChucvuLocalServiceUtil.getChucvus(-1, -1);
			renderRequest.setAttribute("selectChucVu", entitiesChucvus);
			List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
			httpServletRequest.setAttribute("usersList", usersList);
			int id = ParamUtil.getInteger(renderRequest, "id");
			if (id > 0) {
				try {
					Users useredit = UsersLocalServiceUtil.getUsers(id);
					httpServletRequest.setAttribute("useredit", useredit);
				} catch (Exception e) {
					System.out.println("chạy vào đây******");
					e.printStackTrace();
				}
			} 

		} catch (SystemException e) {
			e.printStackTrace();
		}
//		if (isTimKiem == false) {
//			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//			int id = ParamUtil.getInteger(renderRequest, "id");
//			System.out.println("id la ----- " + id);
//			if (id > 0) {
//				try {
//					Users useredit = UsersLocalServiceUtil.getUsers(id);
//					httpServletRequest.setAttribute("useredit", useredit);
//				} catch (Exception e) {
//					System.out.println("chạy vào đây******");
//					e.printStackTrace();
//				}
//			}
//
//			if (dodaibang_dataTable > 0) {
//				System.out.println("do dai dodaibang_dataTable in data " + dodaibang_dataTable);
//				List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
//
//				httpServletRequest.setAttribute("dodaibang", dodaibang_dataTable);
//				int sotrang = (int) (usersList.size() / dodaibang_dataTable) + 1;
//				System.out.println("so trang la ############# " + sotrang);
//				int[] mangSoNguyen = new int[sotrang];
//				for (int i = 0; i < sotrang; i++) {
//					mangSoNguyen[i] = i + 1;
//				}
//				httpServletRequest.setAttribute("sotrang", mangSoNguyen);
//
//				int vitridau = trangsocanlay * dodaibang_dataTable - dodaibang_dataTable ;
//				int vitricuoi = trangsocanlay * dodaibang_dataTable;
//				int vitricuoiChuan = (vitricuoi > usersList.size()) ? usersList.size() : vitricuoi;
//
//				List<Users> usersToDisplay = usersList.subList(vitridau, vitricuoiChuan);
//
//				for (int i = 0; i < usersToDisplay.size(); i++) {
//					Users user = usersToDisplay.get(i);
//					// Thiết lập giá trị mới cho trường id
//					user.setId(trangsocanlay * dodaibang_dataTable - dodaibang_dataTable + 1 +i);
//				}
//
//				System.out.println("usersToDisplay +++++++ " + usersToDisplay);
//				
//				// xử lý đoạn này -------------------------------------------
//				
//				Map<String, Object> userMap = new HashMap<>();
//				userMap.put("usersList", usersToDisplay);
//				userMap.put("otherValue", vitricuoi/10 - 1); // Thêm giá trị khác nếu cần
//				
//				// chưa xử lý xong ----------------------------------------------
//				
//				httpServletRequest.setAttribute("usersList", usersToDisplay);
//
//			} else {
//				// đoạn này đang thừa
//				List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
//				httpServletRequest.setAttribute("usersList", usersList);
//			}
//
//		} else {
//			System.out.println("keyTimKiem da vao dc day  ---- " + keyTimKiem);
//			isTimKiem = !isTimKiem;
//			String keyChuan = "%" + keyTimKiem + "%";
//			System.out.println("keyChuan  -++++++++++---------" + keyChuan);
//			List<Users> usersList = UsersLocalServiceUtil.getDuLieuTimKiem(keyChuan);
//			System.out.println("usersList  -++++++++++---------" + usersList);
//			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//			httpServletRequest.setAttribute("usersList", usersList);
//
//		}

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