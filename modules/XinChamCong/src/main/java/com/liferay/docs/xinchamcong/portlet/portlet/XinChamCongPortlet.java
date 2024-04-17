package com.liferay.docs.xinchamcong.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.backend.model.GioLam;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.Xinchamcong;
import com.liferay.docs.backend.model.Xinnghi;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.backend.service.XinchamcongLocalServiceUtil;
import com.liferay.docs.backend.service.XinnghiLocalServiceUtil;
import com.liferay.docs.xinchamcong.portlet.constants.XinChamCongPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=XinChamCong", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/xinchamcong/ViewXinChamCong.jsp",
		"javax.portlet.name=" + XinChamCongPortletKeys.XINCHAMCONG, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class XinChamCongPortlet extends MVCPortlet {
	public void addXinChamCongVaoRa(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();
		// xử lý chức năng
		String ngay_lam = ParamUtil.getString(request, "ngay_lam");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datengay_lam = null;
		try {
			datengay_lam = sdf.parse(ngay_lam);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ca_lam = ParamUtil.getString(request, "ca_lam");
		String loai_cham_cong = ParamUtil.getString(request, "loai_cham_cong");
		String ly_do = ParamUtil.getString(request, "ly_do");
		System.out.println("ngay_lam " + ngay_lam);
		System.out.println("ca_lam " + ca_lam);
		System.out.println("loai_cham_cong " + loai_cham_cong);
		System.out.println("ly_do " + ly_do);

		try {
			XinchamcongLocalServiceUtil.addXinChamCongVaoRa(userId, ly_do, ca_lam, "", "", datengay_lam, 9498, 9498,
					loai_cham_cong, 1, 0, phongban_id, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/xin-cham-cong");

	}

	public void actionDongYXinChamCongVaoRaTruongPhong(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();
		// xử lý chức năng
		String id_xinchamcongStr = ParamUtil.getString(request, "id_xinchamcong");
		int id_xinchamcong = Integer.parseInt(id_xinchamcongStr);

		try {
			Xinchamcong xinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(id_xinchamcong);
			String loai_cham_cong = null;
			String check_in = xinchamcong.getCheck_in();
			System.out.println("check_in la " + check_in);
			String check_out = xinchamcong.getCheck_out();
			System.out.println("check_out la " + check_out);
			if (!check_in.equals("") && check_out.equals("")) {
				loai_cham_cong = "check_in";
			} else if (check_in.equals("") && !check_out.equals("")) {
				loai_cham_cong = "check_out";
			}

			System.out.println("loai_cham_cong la " + loai_cham_cong);

			XinchamcongLocalServiceUtil.actionDuyetChamCongVaoRa(1, id_xinchamcong, xinchamcong.getUser_id(), "",
					userId, userId, 1, phongban_id, serviceContext);
			// Thực hiện hành động chỉnh sửa trong GioLam
			Date ngay_xin_cham_cong = xinchamcong.getNgay_lam();
			long User_id_xinchamcong = xinchamcong.getUser_id();

			GioLam giolamc_can_lay = GioLamLocalServiceUtil.getGioLamByUserId(User_id_xinchamcong, ngay_xin_cham_cong);
			if (giolamc_can_lay == null) {
				GioLamLocalServiceUtil.addXinChamCongvaoRa(1, User_id_xinchamcong, xinchamcong.getNgay_lam(),
						xinchamcong.getCa_lam(), loai_cham_cong, 1, 1, serviceContext);
			} else {
				GioLamLocalServiceUtil.updateXinChamCongvaoRa(giolamc_can_lay.getId(), xinchamcong.getNgay_lam(),
						User_id_xinchamcong, xinchamcong.getCa_lam(), loai_cham_cong, 1, 1, serviceContext);
			}
//			

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/xin-cham-cong");

	}

	public void actionTuChoiXinChamCongVaoRaTruongPhong(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();
		// xử lý chức năng
		String id_xinchamcongStr = ParamUtil.getString(request, "id_xinchamcong");
		int id_xinchamcong = Integer.parseInt(id_xinchamcongStr);

		try {
			Xinchamcong xinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(id_xinchamcong);
			XinchamcongLocalServiceUtil.actionTuChoiChamCongVaoRa(1, id_xinchamcong, xinchamcong.getUser_id(), "",
					userId, userId, 1, phongban_id, serviceContext);

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/xin-cham-cong");

	}

	public void addXinChamCongNuaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();
		// xử lý chức năng
		String ngay_lam = ParamUtil.getString(request, "ngay_lam");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datengay_lam = null;
		try {
			datengay_lam = sdf.parse(ngay_lam);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ca_lam = ParamUtil.getString(request, "ca_lam");
		String loai_cham_cong = ParamUtil.getString(request, "loai_cham_cong");
		String ly_do = ParamUtil.getString(request, "ly_do");
		System.out.println("ngay_lam " + ngay_lam);
		System.out.println("ca_lam " + ca_lam);
		System.out.println("loai_cham_cong " + loai_cham_cong);
		System.out.println("ly_do " + ly_do);

		try {
			XinchamcongLocalServiceUtil.addXinChamCongNuaNgay(userId, ly_do, ca_lam, "", "", datengay_lam, 9498, 9498,
					loai_cham_cong, 1, 0, phongban_id, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.sendRedirect("/xin-cham-cong");

	}

	public void addXinChamCongCaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();

		// xử lý chức năng
		String tu_ngay = ParamUtil.getString(request, "tu_ngay");
		String den_ngay = ParamUtil.getString(request, "den_ngay");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datetu_ngay = null;
		Date dateden_ngay = null;
		try {
			datetu_ngay = sdf.parse(tu_ngay);
			dateden_ngay = sdf.parse(den_ngay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String loai_cham_cong = ParamUtil.getString(request, "loai_cham_cong");
		String ly_do = ParamUtil.getString(request, "ly_do");
		System.out.println("dateden_ngay " + dateden_ngay);
		System.out.println("loai_cham_cong " + loai_cham_cong);
		System.out.println("ly_do " + ly_do);

		System.out.println("da vao dc day roi hihiiihiiiiiiiiiiiiiiihiiiiiiiiiih ");

		try {
			XinchamcongLocalServiceUtil.addXinChamCongCaNgay(userId, ly_do, "", "", null, datetu_ngay, dateden_ngay,
					9498, 9498, loai_cham_cong, 1, 1, phongban_id, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.sendRedirect("/xin-cham-cong");

	}

	// Hành động Cả Ngày và Nửa Ngày Xin chấm công

	// Nút Trưởng phòng
	public void actionDongYXinChamCongCaNgayNuaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();

		// xử lý chức năng
		String id_xinchamcongStr = ParamUtil.getString(request, "id_xinchamcong");
		System.out.println("id_xinchamcong ============= " + id_xinchamcongStr);
		int id_xinchamcong = Integer.parseInt(id_xinchamcongStr);

		Xinchamcong dulieuxinchamcong;
		try {
			dulieuxinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(id_xinchamcong);
			// xác định loai chấm công
			String loai_cham_cong = "";
			String ca_lam = dulieuxinchamcong.getCa_lam();
			String Check_in = dulieuxinchamcong.getCheck_in();
			String Check_out = dulieuxinchamcong.getCheck_out();
			Date tu_ngay = dulieuxinchamcong.getTu_ngay();
			Date den_ngay = dulieuxinchamcong.getDen_ngay();

			if (ca_lam.equals("")) {
				loai_cham_cong = "Chamcongcangay";
			} else if (ca_lam.equals("sang")) {
				loai_cham_cong = "ChamCongNuaNgaySang";
			} else if (ca_lam.equals("chieu")) {
				loai_cham_cong = "ChamCongNuaNgayChieu";
			}

			GioLam giolamc_can_lay = GioLamLocalServiceUtil.getGioLamByUserId(dulieuxinchamcong.getUser_id(),
					dulieuxinchamcong.getNgay_lam());
			XinchamcongLocalServiceUtil.actionDuyetChamCongNuaNgayCaNgay(user.getChucvu_id(), id_xinchamcong,
					dulieuxinchamcong.getUser_id(), userId, userId, 1, phongban_id, serviceContext);

			if (giolamc_can_lay == null) {
				GioLamLocalServiceUtil.addXinChamCongCaNgayNuaNgay(dulieuxinchamcong.getNgay_lam(),
						dulieuxinchamcong.getUser_id(), loai_cham_cong, 1, 1, serviceContext);

			} else {
				GioLamLocalServiceUtil.updateXinChamCongCaNgayNuaNgay(giolamc_can_lay.getId(),
						dulieuxinchamcong.getNgay_lam(), dulieuxinchamcong.getUser_id(), loai_cham_cong, 1, 1,
						serviceContext);
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// response.sendRedirect("/xin-cham-cong");

	}

	public void actionTuChoiXinChamCongCaNgayNuaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();

		// xử lý chức năng
		String id_xinchamcongStr = ParamUtil.getString(request, "id_xinchamcong");
		System.out.println("id_xinchamcong ============================================++++++++++++++++++++++++ " + id_xinchamcongStr);
		int id_xinchamcong = Integer.parseInt(id_xinchamcongStr);

		Xinchamcong dulieuxinchamcong;
		try {
			dulieuxinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(id_xinchamcong);
			// xác định loai chấm công
			String loai_cham_cong = "";
			String ca_lam = dulieuxinchamcong.getCa_lam();
			String Check_in = dulieuxinchamcong.getCheck_in();
			String Check_out = dulieuxinchamcong.getCheck_out();
			Date tu_ngay = dulieuxinchamcong.getTu_ngay();
			Date den_ngay = dulieuxinchamcong.getDen_ngay();

			if (ca_lam.equals("")) {
				loai_cham_cong = "Chamcongcangay";
			} else if (ca_lam.equals("sang")) {
				loai_cham_cong = "ChamCongNuaNgaySang";
			} else if (ca_lam.equals("chieu")) {
				loai_cham_cong = "ChamCongNuaNgayChieu";
			}

			XinchamcongLocalServiceUtil.actionTuChoiChamCongNuaNgayCaNgay(user.getChucvu_id(), id_xinchamcong,
					dulieuxinchamcong.getUser_id(), "", userId, userId, 5, phongban_id, serviceContext);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// response.sendRedirect("/xin-cham-cong");

	}

	// nút giám đốc
	public void actionDongYXinChamCongCaNgayNuaNgayGiamDoc(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		long phongban_id = user.getPhongban_id();
		ServiceContext serviceContext = new ServiceContext();

		// xử lý chức năng
		String id_xinchamcongStr = ParamUtil.getString(request, "id_xinchamcong");
		System.out.println("id_xinchamcong ============= " + id_xinchamcongStr);
		int id_xinchamcong = Integer.parseInt(id_xinchamcongStr);

		Xinchamcong dulieuxinchamcong;
		try {
			dulieuxinchamcong = XinchamcongLocalServiceUtil.getXinchamcong(id_xinchamcong);
			System.out.println("dulieuxinchamcong ------ " + dulieuxinchamcong);
			// xác định loai chấm công
			String loai_cham_cong = "";
			String ca_lam = dulieuxinchamcong.getCa_lam();
			String Check_in = dulieuxinchamcong.getCheck_in();
			String Check_out = dulieuxinchamcong.getCheck_out();
			Date tu_ngay = dulieuxinchamcong.getTu_ngay();
			Date den_ngay = dulieuxinchamcong.getDen_ngay();
			LocalDate tu_ngayLocalDate = tu_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate den_ngayLocalDate = den_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int soNgay = (int)ChronoUnit.DAYS.between(tu_ngayLocalDate, den_ngayLocalDate);

			if (ca_lam.equals("")) {
				loai_cham_cong = "Chamcongcangay";
				
				List<GioLam> gioLamListXinNghi = new ArrayList<>(soNgay + 1);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(tu_ngay);
				for (int i = 0; !calendar.getTime().after(den_ngay); i++, calendar.add(Calendar.DAY_OF_MONTH, 1)) {
					int idGioLamnew = (int) CounterLocalServiceUtil.increment();
					GioLam gioLamChuan = GioLamLocalServiceUtil.createGioLam(idGioLamnew);
					gioLamChuan.setUser_id(dulieuxinchamcong.getUser_id());

					gioLamChuan.setNgay_lam(calendar.getTime()); // set ngay_lam cho gioLam

					gioLamListXinNghi.add(gioLamChuan);
				}
				System.out.println("gioLamListXinNghi ----------------------- " + gioLamListXinNghi);
				for (GioLam gioLam : gioLamListXinNghi) {
					Date Ngaylam = gioLam.getNgay_lam();
					GioLam checkgiolamcanlay = GioLamLocalServiceUtil.getGioLamByUserId(dulieuxinchamcong.getUser_id(), Ngaylam);
					if (checkgiolamcanlay == null) {
						GioLamLocalServiceUtil.addGioLamXinNghiDcPheDuyetCaNgay(1, dulieuxinchamcong.getUser_id(), Ngaylam, 1,
								serviceContext);
					} else {
						int idgioLam = checkgiolamcanlay.getId();
						GioLamLocalServiceUtil.updateGioLamXinNghiDcPheDuyetCaNgay(idgioLam, dulieuxinchamcong.getUser_id(),
								Ngaylam, 1, serviceContext);
					}

				}
				XinchamcongLocalServiceUtil.actionDuyetChamCongNuaNgayCaNgay(user.getChucvu_id(), id_xinchamcong,
						dulieuxinchamcong.getUser_id(), userId, userId, 1, phongban_id, serviceContext);
			
				
	

			} else if (!ca_lam.equals("")) {

				if (ca_lam.equals("sang")) {
					loai_cham_cong = "ChamCongNuaNgaySang";
				} else if (ca_lam.equals("chieu")) {
					loai_cham_cong = "ChamCongNuaNgayChieu";
				}
				// Xử lý chấm công nửa ngày của trưởng phòng để giám đốc phê duyệt
				XinchamcongLocalServiceUtil.actionDuyetChamCongNuaNgayCaNgay(user.getChucvu_id(), id_xinchamcong,
				dulieuxinchamcong.getUser_id(), userId, userId, 1, phongban_id, serviceContext);	
				GioLam giolamc_can_lay = GioLamLocalServiceUtil.getGioLamByUserId(dulieuxinchamcong.getUser_id(),
						dulieuxinchamcong.getNgay_lam());
				XinchamcongLocalServiceUtil.actionDuyetChamCongNuaNgayCaNgay(user.getChucvu_id(), id_xinchamcong,
						dulieuxinchamcong.getUser_id(), userId, userId, 1, phongban_id, serviceContext);
				if (giolamc_can_lay == null) {
					GioLamLocalServiceUtil.addXinChamCongCaNgayNuaNgay(dulieuxinchamcong.getNgay_lam(),
							dulieuxinchamcong.getUser_id(), loai_cham_cong, 1, 1, serviceContext);
	
				} else {
					GioLamLocalServiceUtil.updateXinChamCongCaNgayNuaNgay(giolamc_can_lay.getId(),dulieuxinchamcong.getNgay_lam(),
							dulieuxinchamcong.getUser_id(), loai_cham_cong, 1, 1, serviceContext);
				}
			}

			

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// response.sendRedirect("/xin-cham-cong");

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// Thông tin đăng nhập
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		renderRequest.setAttribute("userdangnhap", user);
		long chucvu_id_userdangnhap = user.getChucvu_id();
		// Lấy List Xin Chấm Công Vào Ra
		try {
			if (chucvu_id_userdangnhap == 42601) {
				// nhân viên
				List<Xinchamcong> ListXinChamCong = listXinChamCongVaoRaNhanVien(user.getUserId());
				renderRequest.setAttribute("ListXinChamCong", ListXinChamCong);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			} else if (chucvu_id_userdangnhap == 42604) {
				// giám đốc
				List<Xinchamcong> ListXinChamCong = listXinChamCongVaoRaGiamDoc(user.getUserId());
				renderRequest.setAttribute("ListXinChamCong", ListXinChamCong);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			} else if (chucvu_id_userdangnhap == 42605) {
				// phó giám đốc
				List<Xinchamcong> ListXinChamCong = listXinChamCongVaoRaNhanVien(user.getUserId());
				renderRequest.setAttribute("ListXinChamCong", ListXinChamCong);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			} else if (chucvu_id_userdangnhap == 42602 || user.getPhu_trach_phong() == 1) {
				// trưởng phòng và phụ trách phòng
				List<Xinchamcong> ListXinChamCong = listXinChamCongVaoRaTruongPhong(user.getUserId(),
						user.getPhongban_id());
				renderRequest.setAttribute("ListXinChamCong", ListXinChamCong);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			}

			List<Users> ListUsers = UsersLocalServiceUtil.getUserses(-1, -1);
			renderRequest.setAttribute("ListUsers", ListUsers);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lấy List Xin Chấm Công Nửa Ngày/ Cả ngày
		try {
			if (chucvu_id_userdangnhap == 42601) {
				// nhân viên
				List<Xinchamcong> ListXinChamCongNuaNgayCaNgay = listXinChamCongNuaNgayvsCaNgayNhanVien(
						user.getUserId());
				renderRequest.setAttribute("ListXinChamCongNuaNgayCaNgay", ListXinChamCongNuaNgayCaNgay);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			} else if (chucvu_id_userdangnhap == 42604) {
				// giám đốc
				List<Xinchamcong> ListXinChamCongNuaNgayCaNgay = listXinChamCongNuaNgayvsCaNgayGiamDoc(
						user.getUserId());
				renderRequest.setAttribute("ListXinChamCongNuaNgayCaNgay", ListXinChamCongNuaNgayCaNgay);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			} else if (chucvu_id_userdangnhap == 42605) {
				// phó giám đốc
				List<Xinchamcong> ListXinChamCongNuaNgayCaNgay = listXinChamCongNuaNgayvsCaNgayNhanVien(
						user.getUserId());
				renderRequest.setAttribute("ListXinChamCongNuaNgayCaNgay", ListXinChamCongNuaNgayCaNgay);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			} else if (chucvu_id_userdangnhap == 42602 || user.getPhu_trach_phong() == 1) {
				// trưởng phòng và phụ trách phòng
				List<Xinchamcong> ListXinChamCongNuaNgayCaNgay = listXinChamCongNuaNgayvsCaNgayTruongPhong(
						user.getUserId(), user.getPhongban_id());
				renderRequest.setAttribute("ListXinChamCongNuaNgayCaNgay", ListXinChamCongNuaNgayCaNgay);
				Users Phutrach = TruongPhongLayByUserId(userId);
				renderRequest.setAttribute("Phutrach", Phutrach);
				Users GiamDoc = GiamDoc();
				renderRequest.setAttribute("GiamDoc", GiamDoc);
			}

			List<Users> ListUsers = UsersLocalServiceUtil.getUserses(-1, -1);
			renderRequest.setAttribute("ListUsers", ListUsers);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}

	public List<Xinchamcong> listXinChamCongVaoRaNhanVien(long userId) throws PortalException, SystemException {
		List<Xinchamcong> ListXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		List<Xinchamcong> listXinChamCongVaoRaNhanVien = ListXinChamCong.stream()
				.filter(xinchamcong -> (xinchamcong.getUser_id() == userId) && xinchamcong.getChon_ly_do().equals(""))
				.collect(Collectors.toList());
		return listXinChamCongVaoRaNhanVien;

	}

	// listXinChamCongNuaNgayvsCaNgayNhanVien
	public List<Xinchamcong> listXinChamCongNuaNgayvsCaNgayNhanVien(long userId)
			throws PortalException, SystemException {
		List<Xinchamcong> ListXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		List<Xinchamcong> listXinChamCongVaoRaNhanVien = ListXinChamCong.stream()
				.filter(xinchamcong -> (xinchamcong.getUser_id() == userId) && !xinchamcong.getChon_ly_do().equals(""))
				.collect(Collectors.toList());
		return listXinChamCongVaoRaNhanVien;

	}

	public List<Xinchamcong> listXinChamCongVaoRaTruongPhong(long userId, long phongban_id)
			throws PortalException, SystemException {
		// đây sẽ lấy hết tất cả những nhân viên thuộc phòng và bản thân luôn
		List<Xinchamcong> ListXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		List<Xinchamcong> listXinChamCongVaoRaTruongPhong = ListXinChamCong.stream()
				.filter(xinnghi -> (xinnghi.getPhongban_id() == phongban_id && xinnghi.getChon_ly_do().equals("")))
				.collect(Collectors.toList());
		return listXinChamCongVaoRaTruongPhong;

	}

	// listXinChamCongNuaNgayvsCaNgayTruongPhong
	public List<Xinchamcong> listXinChamCongNuaNgayvsCaNgayTruongPhong(long userId, long phongban_id)
			throws PortalException, SystemException {
		// đây sẽ lấy hết tất cả những nhân viên thuộc phòng và bản thân luôn
		List<Xinchamcong> ListXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		List<Xinchamcong> listXinChamCongVaoRaTruongPhong = ListXinChamCong.stream()
				.filter(xinnghi -> (xinnghi.getPhongban_id() == phongban_id && !xinnghi.getChon_ly_do().equals("")))
				.collect(Collectors.toList());
		return listXinChamCongVaoRaTruongPhong;

	}

	public List<Xinchamcong> listXinChamCongVaoRaGiamDoc(long userId) throws PortalException, SystemException {
		// đây sẽ lấy hết tất cả những nhân viên thuộc phòng và bản thân luôn
		List<Xinchamcong> ListXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		List<Xinchamcong> listXinChamCongVaoRaGiamDoc = new ArrayList<>();
		for (Xinchamcong itemxinchamcong : ListXinChamCong) {
			long user_iditemxinchamcong = itemxinchamcong.getUser_id();
			Users useritemxinchamcong = UsersLocalServiceUtil.getUserbyUserId(user_iditemxinchamcong);
			if (itemxinchamcong.getChon_ly_do().equals("")) {
				if (useritemxinchamcong.getChucvu_id() == 42602 || useritemxinchamcong.getChucvu_id() == 42605
						|| useritemxinchamcong.getPhu_trach_phong() == 1) {
					listXinChamCongVaoRaGiamDoc.add(itemxinchamcong);
				}
			}

		}

		return listXinChamCongVaoRaGiamDoc;

	}

	// listXinChamCongNuaNgayvsCaNgayGiamDoc
	public List<Xinchamcong> listXinChamCongNuaNgayvsCaNgayGiamDoc(long userId)
			throws PortalException, SystemException {
		// đây sẽ lấy hết tất cả những nhân viên thuộc phòng và bản thân luôn
		List<Xinchamcong> ListXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		List<Xinchamcong> listXinChamCongVaoRaGiamDoc = new ArrayList<>();
		for (Xinchamcong itemxinchamcong : ListXinChamCong) {
			long user_iditemxinchamcong = itemxinchamcong.getUser_id();
			Users useritemxinchamcong = UsersLocalServiceUtil.getUserbyUserId(user_iditemxinchamcong);
			if (!itemxinchamcong.getChon_ly_do().equals("")) {

				if (useritemxinchamcong.getChucvu_id() == 42602 || useritemxinchamcong.getChucvu_id() == 42605
						|| useritemxinchamcong.getPhu_trach_phong() == 1) {
					listXinChamCongVaoRaGiamDoc.add(itemxinchamcong);
				} else if (itemxinchamcong.getTu_ngay() != null && itemxinchamcong.getDen_ngay() != null) {
					listXinChamCongVaoRaGiamDoc.add(itemxinchamcong);
				}

			}
		}

		return listXinChamCongVaoRaGiamDoc;

	}

	public Users TruongPhongLayByUserId(long userId_NhanVien) throws PortalException, SystemException {
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId_NhanVien);
		long phongban_id = user.getPhongban_id();
		List<Users> ListAllUser = UsersLocalServiceUtil.getUserses(-1, -1);
		List<Users> ListTruongPhongUser = ListAllUser.stream()
				.filter(x -> ((x.getPhongban_id() == phongban_id && x.getChucvu_id() == 42602)
						|| (x.getPhongban_id() == phongban_id && x.getPhu_trach_phong() == 1)))
				.collect(Collectors.toList());
		return ListTruongPhongUser.get(0);
	}

	public Users GiamDoc() throws PortalException, SystemException {
		List<Users> ListUsers = UsersLocalServiceUtil.getUserses(-1, -1);
		Users GiamDoc = null;
		for (Users users : ListUsers) {
			if (users.getChucvu_id() == 42604) {
				GiamDoc = users;
			}
		}

		return GiamDoc;
	}

}