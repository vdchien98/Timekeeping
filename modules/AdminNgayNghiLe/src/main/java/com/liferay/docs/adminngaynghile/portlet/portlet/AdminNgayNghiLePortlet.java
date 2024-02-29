package com.liferay.docs.adminngaynghile.portlet.portlet;

import com.liferay.docs.adminngaynghile.portlet.constants.AdminNgayNghiLePortletKeys;
import com.liferay.docs.backend.model.Ngaynghile;
import com.liferay.docs.backend.service.NgaynghileLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
		"javax.portlet.display-name=AdminNgayNghiLe",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminngaynghile/AdminNgayNghiLe.jsp",
		"javax.portlet.name=" + AdminNgayNghiLePortletKeys.ADMINNGAYNGHILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminNgayNghiLePortlet extends MVCPortlet {
	
	public void saveNgayNghiLe(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		int idNgayNghiLe = ParamUtil.getInteger(request, "idNgayNghiLe");
		String ten = ParamUtil.getString(request, "ten");
		String ngay_nghi = ParamUtil.getString(request, "ngay_nghi");
		int trangthai = ParamUtil.getInteger(request, "trangthai");
		SimpleDateFormat formatNgayNghi = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			if (idNgayNghiLe == 0) {
				try {
					date = formatNgayNghi.parse(ngay_nghi);
				} catch (Exception e) {
					e.printStackTrace();
				}
				NgaynghileLocalServiceUtil.addNgayNghiLe(ten, date, trangthai, serviceContext);
			} else {
				Ngaynghile ngaynghileedit = NgaynghileLocalServiceUtil.getNgaynghile(idNgayNghiLe);
				if (ngaynghileedit != null) {
					try {
						date = formatNgayNghi.parse(ngay_nghi);
					} catch (Exception e) {
						e.printStackTrace();
					}
					NgaynghileLocalServiceUtil.updateNgayNghiLe(idNgayNghiLe, ten, date, trangthai, serviceContext);
				} else {
					System.out.println("Not  Find Ngay Nghi Le");
				}
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		response.sendRedirect("/admin/ngay-nghi-le");
	}
	public void deleteNgayNghiLe(ActionRequest request, ActionResponse response) throws PortalException {
        int deleteNgayNghiLeId = ParamUtil.getInteger(request, "deleteNgayNghiLeId");
          System.out.println("da vao dc day");
        try {
        	 NgaynghileLocalServiceUtil.deleteNgaynghile(deleteNgayNghiLeId);
        	 response.sendRedirect("/admin/ngay-nghi-le");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String year = renderRequest.getParameter("year"); 
		if (year == null) {
			Date currentDate = new Date();
			int namHienTai = currentDate.getYear() + 1900;
			year = String.valueOf(namHienTai);
		} else {
			 year = renderRequest.getParameter("year");
		}
		int soNguyen = Integer.parseInt(year);
		System.out.println("year sau cung ------" + year);
		

		List<Ngaynghile> ngayNghiLeList = NgaynghileLocalServiceUtil.getNgaynghiles(-1, -1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);	
        List<Ngaynghile> filteredGioLamList = ngayNghiLeList.stream()
                .filter(ngaynghile -> (ngaynghile.getNgay_nghi().getYear()+ 1900) == soNguyen)
                .collect(Collectors.toList());
        System.out.println("===== filteredGioLamList ------ " + filteredGioLamList);
		httpServletRequest.setAttribute("ngayNghiLeList", filteredGioLamList);
		int idNgayNghiLe = ParamUtil.getInteger(renderRequest, "idNgayNghiLe");
		System.out.println("idNgayNghiLe da vao day *******" + idNgayNghiLe);
		if (idNgayNghiLe > 0) {
			try {
				Ngaynghile ngaynghileedit = NgaynghileLocalServiceUtil.getNgaynghile(idNgayNghiLe);
				httpServletRequest.setAttribute("ngaynghileedit", ngaynghileedit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.render(renderRequest, renderResponse);
	}
	
}