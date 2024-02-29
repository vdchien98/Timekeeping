package com.liferay.docs.adminngaylamviec.portlet.portlet;

import com.liferay.docs.adminngaylamviec.portlet.constants.AdminNgayLamViecPortletKeys;
import com.liferay.docs.backend.model.Ngaylamviec;
import com.liferay.docs.backend.model.Ngaynghile;
import com.liferay.docs.backend.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.backend.service.NgaynghileLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		"javax.portlet.display-name=AdminNgayLamViec", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminngaylamviec/AdminNgayLamViec.jsp",
		"javax.portlet.name=" + AdminNgayLamViecPortletKeys.ADMINNGAYLAMVIEC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AdminNgayLamViecPortlet extends MVCPortlet {

	String year = null;

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		year = renderRequest.getParameter("yearone");
		if (year == null) {
			Date currentDate = new Date();
			int namHienTai = currentDate.getYear() + 1900;
			year = String.valueOf(namHienTai);
		} else {
			year = year;
		}
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("namsaucung", year);
		int NamsaucungRender = Integer.parseInt(year);
		List<Ngaylamviec> x = NgaylamviecLocalServiceUtil.getNgaylamviecs(-1, -1);
		List<Ngaylamviec> checknamindata = x.stream().filter(y -> y.getNam() == NamsaucungRender)
				.collect(Collectors.toList());
		httpServletRequest.setAttribute("hienthirender", checknamindata);

		int idngaylamviec = ParamUtil.getInteger(renderRequest, "idngaylamviec");
		if (idngaylamviec > 0) {
			try {
				Ngaylamviec ngaylamviecedit = NgaylamviecLocalServiceUtil.getNgaylamviec(idngaylamviec);
				httpServletRequest.setAttribute("ngaylamviecedit", ngaylamviecedit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		super.render(renderRequest, renderResponse);
	}

	public void saveNgayNghiLamviec(ActionRequest request, ActionResponse response) {
		System.out.println("year sau cung ------" + year);
		int Namsaucung = Integer.parseInt(year);
		System.out.println("Namsaucung " + Namsaucung);
		// xử lý ngày nghỉ
		List<Ngaynghile> ngayNghiLeList = NgaynghileLocalServiceUtil.getNgaynghiles(-1, -1);
		List<Ngaynghile> filteredGioLamList = ngayNghiLeList.stream()
				.filter(ngaynghile -> (ngaynghile.getNgay_nghi().getYear() + 1900) == Namsaucung)
				.collect(Collectors.toList());
		int thang1 = 0;
		int thang2 = 0;
		int thang3 = 0;
		int thang4 = 0;
		int thang5 = 0;
		int thang6 = 0;
		int thang7 = 0;
		int thang8 = 0;
		int thang9 = 0;
		int thang10 = 0;
		int thang11 = 0;
		int thang12 = 0;
		String tenThang = null;
		for (Ngaynghile ngaynghile : filteredGioLamList) {
			// Lấy ngày nghỉ từ phần tử
			Date ngay_nghi = ngaynghile.getNgay_nghi();
			SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE"); // Lấy thứ
			SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM"); // Lấy tên tháng
			String thu = dayFormat.format(ngay_nghi);
			tenThang = convertMonthToVietnamese(monthFormat.format(ngay_nghi));
			// Kiểm tra xem ngày nghỉ có phải là thứ 7 hoặc Chủ nhật hay không
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ngay_nghi);
			int ngayTrongTuan = calendar.get(Calendar.DAY_OF_WEEK);
			if (ngayTrongTuan != Calendar.SATURDAY && ngayTrongTuan != Calendar.SUNDAY) {
				if (tenThang.equals("1")) {
					thang1++;
				} else if (tenThang.equals("2")) {
					thang2++;
				} else if (tenThang.equals("3")) {
					thang3++;
				} else if (tenThang.equals("4")) {
					thang4++;
				} else if (tenThang.equals("5")) {
					thang5++;
				} else if (tenThang.equals("6")) {
					thang6++;
				} else if (tenThang.equals("7")) {
					thang7++;
				} else if (tenThang.equals("8")) {
					thang8++;
				} else if (tenThang.equals("9")) {
					thang9++;
				} else if (tenThang.equals("10")) {
					thang10++;
				} else if (tenThang.equals("11")) {
					thang11++;
				} else if (tenThang.equals("12")) {
					thang12++;
				}

			}
			System.out.println("-------------------");

		}

		List<Integer> myListNgayNghiLe = new ArrayList<>();
		myListNgayNghiLe.add(thang1);
		myListNgayNghiLe.add(thang2);
		myListNgayNghiLe.add(thang3);
		myListNgayNghiLe.add(thang4);
		myListNgayNghiLe.add(thang5);
		myListNgayNghiLe.add(thang6);
		myListNgayNghiLe.add(thang7);
		myListNgayNghiLe.add(thang8);
		myListNgayNghiLe.add(thang9);
		myListNgayNghiLe.add(thang10);
		myListNgayNghiLe.add(thang11);
		myListNgayNghiLe.add(thang12);
		System.out.println("myListNgayNghiLe: ------------------------------- " + myListNgayNghiLe);
		Calendar calendar = Calendar.getInstance();
		ServiceContext serviceContext = new ServiceContext();
		// Cách lấy 1 tháng có bao nhiêu ngày thứ 7 , bao nhiêu ngày chủ nhật
		List<Ngaylamviec> x = NgaylamviecLocalServiceUtil.getNgaylamviecs(-1, -1);
		List<Ngaylamviec> checknamindata = x.stream().filter(y -> y.getNam() == Namsaucung)
				.collect(Collectors.toList());
		if (checknamindata.size() == 0) {
			for (int thang = 1; thang <= 12; thang++) {
				calendar.set(Namsaucung, thang - 1, 1);
				int soNgayTrongThang = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				int soNgayThuBay = 0;
				int soNgayChuNhat = 0;

				for (int ngay = 1; ngay <= soNgayTrongThang; ngay++) {
					calendar.set(Namsaucung, thang - 1, ngay); // Đặt ngày cụ thể trong tháng
					int thu = calendar.get(Calendar.DAY_OF_WEEK);
					// Nếu là thứ 7 hoặc Chủ nhật
					if (thu == Calendar.SATURDAY) {
						soNgayThuBay++;
					} else if (thu == Calendar.SUNDAY) {
						soNgayChuNhat++;
					}
				}
				int tongsongayt7vsCninThang = soNgayThuBay + soNgayChuNhat;
				int songaydilamtheothang = soNgayTrongThang - tongsongayt7vsCninThang;
				int songaynghithu2denthu6 = myListNgayNghiLe.get(thang - 1);
				int songaylamvieccuoicung = songaydilamtheothang - songaynghithu2denthu6;

				try {
					NgaylamviecLocalServiceUtil.saveNgayLamViec(Namsaucung, thang, songaylamvieccuoicung,
							serviceContext);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else if (checknamindata.size() > 0) {
			// danh cho updata lại cả năm 
			System.out.println("So ngay lam viec cua nam da dc tao ");
			for (Ngaylamviec ngaylamviec : checknamindata) {
				int idngaylamviec = ngaylamviec.getId();
				int thang = ngaylamviec.getThang();
				try {
				
						calendar.set(Namsaucung, thang - 1, 1);
						int soNgayTrongThang = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
						int soNgayThuBay = 0;
						int soNgayChuNhat = 0;

						for (int ngay = 1; ngay <= soNgayTrongThang; ngay++) {
							calendar.set(Namsaucung, thang - 1, ngay); // Đặt ngày cụ thể trong tháng
							int thu = calendar.get(Calendar.DAY_OF_WEEK);
							// Nếu là thứ 7 hoặc Chủ nhật
							if (thu == Calendar.SATURDAY) {
								soNgayThuBay++;
							} else if (thu == Calendar.SUNDAY) {
								soNgayChuNhat++;
							}
						}
						int tongsongayt7vsCninThang = soNgayThuBay + soNgayChuNhat;
						int songaydilamtheothang = soNgayTrongThang - tongsongayt7vsCninThang;
						int songaynghithu2denthu6 = myListNgayNghiLe.get(thang - 1);
						int songaylamvieccuoicung = songaydilamtheothang - songaynghithu2denthu6;
						NgaylamviecLocalServiceUtil.updateNgayLamViec(idngaylamviec, thang, songaylamvieccuoicung,
								serviceContext);
						
						
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void saveChinhSuaNgayLamViec(ActionRequest request, ActionResponse response) {
		ServiceContext serviceContext = new ServiceContext();

		try {
			int idNgaylamviec = ParamUtil.getInteger(request, "idngaylamviec");
			int ThangNgaylamviec = ParamUtil.getInteger(request, "thangngaylamviec");
			int so_ngay_lam_viec = ParamUtil.getInteger(request, "so_ngay_lam_viec");
			System.out.println("idNgaylamviec ------- " + idNgaylamviec);
			System.out.println("ThangNgaylamviec ------- " + ThangNgaylamviec);
			System.out.println("so_ngay_lam_viec ------- " + so_ngay_lam_viec);
			try {
				NgaylamviecLocalServiceUtil.updateNgayLamViec(idNgaylamviec, ThangNgaylamviec, so_ngay_lam_viec,
						serviceContext);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.sendRedirect("/admin/ngay-lam-viec");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String convertMonthToVietnamese(String englishMonth) {
		Map<String, String> monthMap = new HashMap<>();
		monthMap.put("January", "1");
		monthMap.put("February", "2");
		monthMap.put("March", "3");
		monthMap.put("April", "4");
		monthMap.put("May", "5");
		monthMap.put("June", "6");
		monthMap.put("July", "7");
		monthMap.put("August", "8");
		monthMap.put("September", "9");
		monthMap.put("October", "10");
		monthMap.put("November", "11");
		monthMap.put("December", "12");

		return monthMap.get(englishMonth);
	}

}