package com.liferay.docs.phieudiem.portle.portlet;

import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.docs.backend.service.CalamviecLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.backend.service.adminphieudiemLocalServiceUtil;
import com.liferay.docs.phieudiem.portle.constants.PhieuDiemPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		"javax.portlet.display-name=PhieuDiem", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/phieudiem/PhieuDiem.jsp",
		"javax.portlet.name=" + PhieuDiemPortletKeys.PHIEUDIEM, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PhieuDiemPortlet extends MVCPortlet {

	public void ChamPhieuDiem(ActionRequest request, ActionResponse response) {

		ServiceContext serviceContext = new ServiceContext();

		System.out.println("da vao dc champhieudiem");
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		System.out.println("user phieu diem la =========== " + user);
		int quyenxemgiolam = checkQuyenTruongPhong(user);
		renderRequest.setAttribute("quyenxemgiolam", quyenxemgiolam);
		// hiển thị phiếu điểm cá nhân
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<adminphieudiem> danhsachcauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
		System.out.println("danhsachcauhoi === " + danhsachcauhoi);

		List<adminphieudiem> mutableDanhSachCauHoi = new ArrayList<>(danhsachcauhoi);

		Collections.sort(mutableDanhSachCauHoi, new Comparator<adminphieudiem>() {
			@Override
			public int compare(adminphieudiem o1, adminphieudiem o2) {
				String nhomcauhoi1 = (String) o1.getNhomcauhoi();
				String nhomcauhoi2 = (String) o2.getNhomcauhoi();

				String[] parts1 = nhomcauhoi1.split("\\.");
				String[] parts2 = nhomcauhoi2.split("\\.");

				int len = Math.min(parts1.length, parts2.length);
				for (int i = 0; i < len; i++) {
					int diff = Integer.parseInt(parts1[i]) - Integer.parseInt(parts2[i]);
					if (diff != 0) {
						return diff;
					}
				}
				return parts1.length - parts2.length;
			}
		});

		httpServletRequest.setAttribute("danhsachcauhoi", mutableDanhSachCauHoi);

		super.render(renderRequest, renderResponse);
	}

	public int checkQuyenTruongPhong(Users user) {
		long chucvu_id = user.getChucvu_id();
		long phongban_id = user.getPhongban_id();
		long phu_trach_phong = user.getPhu_trach_phong();
		int checkQuyenTruongPhong = 0;
		if ((chucvu_id == 42602 && phongban_id == 42527) || (phu_trach_phong == 1 && phongban_id == 42527)
				|| (phongban_id == 42528)) {
			// xem toàn bộ nhân viên
			checkQuyenTruongPhong = 1;
		} else if (chucvu_id == 42602 || phu_trach_phong == 1) {
			// xem nhân viên trong phòng quản lý
			checkQuyenTruongPhong = 2;
		} else {
			// nhân viên bình thường
			checkQuyenTruongPhong = 3;

		}

		return checkQuyenTruongPhong;
	}

}