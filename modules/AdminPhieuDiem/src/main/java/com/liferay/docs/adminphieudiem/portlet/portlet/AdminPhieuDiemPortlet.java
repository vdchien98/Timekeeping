package com.liferay.docs.adminphieudiem.portlet.portlet;

import com.liferay.docs.adminphieudiem.portlet.constants.AdminPhieuDiemPortletKeys;
import com.liferay.docs.backend.model.Ngaynghile;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.backend.service.adminphieudiemLocalServiceUtil;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
		"javax.portlet.display-name=AdminPhieuDiem", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminphieudiem/AdminPhieuDiem.jsp",
		"javax.portlet.name=" + AdminPhieuDiemPortletKeys.ADMINPHIEUDIEM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AdminPhieuDiemPortlet extends MVCPortlet {
	public void LuuThongTinCauHoi(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId****** " + userId);
		ServiceContext serviceContext = new ServiceContext();
		String noidungcauhoi = ParamUtil.getString(request, "noidungcauhoi");
		Double diemcauhoi = ParamUtil.getDouble(request, "diemcauhoi");
		String nhomcauhoi = ParamUtil.getString(request, "nhomcauhoi");
		long thuocnhomcauhoinao = ParamUtil.getLong(request, "thuocnhomcauhoinao");
		String uuidcauhoi = UUID.randomUUID().toString();
		int trangthaicauhoi = 1;
		try {
			adminphieudiemLocalServiceUtil.addcauhoi(uuidcauhoi, userId, nhomcauhoi, noidungcauhoi, thuocnhomcauhoinao,
					diemcauhoi, trangthaicauhoi, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
		}

		List<adminphieudiem> danhsachcauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
//	    for (adminphieudiem adminphieudiem : danhsachcauhoi) {
//	    	String x = adminphieudiem.getNhomcauhoi();
//			if (thuocnhomcauhoinao.equals(x)) {
//				
//			} 
//		}

		response.sendRedirect("/admin/phieu-diem");
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<adminphieudiem> danhsachcauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
        System.out.println("danhsachcauhoi === " +danhsachcauhoi);
		
        
        List<adminphieudiem> mutableDanhSachCauHoi = new ArrayList<>(danhsachcauhoi);
        
        Collections.sort(mutableDanhSachCauHoi, new Comparator<adminphieudiem>() {
            @Override
            public int compare(adminphieudiem o1,adminphieudiem o2) {
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

	// Hàm check xem có cauhoi có phần từ không , nếu có trả về true, nếu không trả
	// về fale
	public boolean checkcocauhoiconko(adminphieudiem cauhoi) {
		boolean trangthai = false;
		List<adminphieudiem> cauhoichecks = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
		for (adminphieudiem cauhoicheck : cauhoichecks) {
			long nhomcauhoi = cauhoicheck.getThuocnhomcauhoinao();
			if (cauhoi.getNhomcauhoi().equals(nhomcauhoi)) {
				trangthai = true;
			}
		}

		return trangthai;
	}

	// 1 hàm lấy ra các phần tử con cấp1 của câu hỏi đó
	public List<adminphieudiem> danhsachcocauhoiconko(adminphieudiem cauhoi, boolean trangthai) {
		List<adminphieudiem> listcauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
		List<adminphieudiem> listcauhoicanlay = new ArrayList<>();
		if (trangthai == true) {
			// tức là có phần tử con
			for (adminphieudiem adminphieudiem : listcauhoi) {
				if (cauhoi.getNhomcauhoi().equals(adminphieudiem.getThuocnhomcauhoinao())) {
					listcauhoicanlay.add(adminphieudiem);
				}
			}

		}
		return listcauhoicanlay;
	}

}