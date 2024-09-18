package com.liferay.docs.phieudiem.portle.portlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.liferay.docs.backend.model.Chucvu;
import com.liferay.docs.backend.model.GioLam;
import com.liferay.docs.backend.model.Ngaylamviec;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.docs.backend.model.tudanhgia;
import com.liferay.docs.backend.service.ChucvuLocalServiceUtil;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.TutiengvietLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.backend.service.adminphieudiemLocalServiceUtil;
import com.liferay.docs.backend.service.tudanhgiaLocalServiceUtil;
import com.liferay.docs.phieudiem.portle.constants.PhieuDiemPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	String year = "";
	String month = "";

	public void ChamPhieuDiem(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		try {
			ServiceContext serviceContext = new ServiceContext();
			List<adminphieudiem> danhsachcauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
			Map<String, Object> Phieudiem1nhanvien = new HashMap<>();
			for (adminphieudiem adminphieudiem : danhsachcauhoi) {
				Number giatri = ParamUtil.getNumber(request, adminphieudiem.getUuid());
				Phieudiem1nhanvien.put(adminphieudiem.getUuid(), giatri);
			}
			Double tongdiem = ParamUtil.getDouble(request, "tong_diem");
			String tongdiemString =String.valueOf(tongdiem);
			String ykienkhac = ParamUtil.getString(request, "y_kien");

			Gson gson = new Gson();
			String Phieudiem1nhanvienJson = gson.toJson(Phieudiem1nhanvien);
			int nam = Integer.parseInt(year);
			int thang = Integer.parseInt(month);
			String tenfile = "";
			long timestamp = System.currentTimeMillis();
			String pdfFileName = "phieudiem" + "_" + timestamp + ".pdf";
			tenfile = pdfFileName;
		
			try {
				tudanhgiaLocalServiceUtil.addcautraloi(userId, Phieudiem1nhanvienJson, ykienkhac, tenfile, tongdiem, 1,
						0, thang, nam, user.getPhongban_id(), "A", serviceContext);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//         Thực hiện chức năng xuất file PDF
			List<Map<String, Object>> datacanlay = new ArrayList<>();
			try {

				List<adminphieudiem> bocauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
				for (adminphieudiem moicauhoi : bocauhoi) {
					Map<String, Object> x = new HashMap<>();
					String uuidcauhoi = moicauhoi.getUuid();
					x.put("muccauhoi", moicauhoi.getNhomcauhoi());
					x.put("cauhoi", moicauhoi.getNoidungcauhoi());
					x.put("diemtoida", moicauhoi.getDiemtoida());
					String diemcauhoi = laydiemtudanhgia(uuidcauhoi, userId, thang, nam);
					x.put("diemtucham", diemcauhoi);
					datacanlay.add(x);

				}
				List<Map<String, Object>> PhieudanhgiaChuan = new ArrayList<>(datacanlay);
				System.out.println("vao dc xuat file PDF ========================================");
				Collections.sort(PhieudanhgiaChuan, new Comparator<Map<String, Object>>() {
					@Override
					public int compare(Map<String, Object> o1, Map<String, Object> o2) {
						String nhomcauhoi1 = (String) o1.get("muccauhoi");
						String nhomcauhoi2 = (String) o2.get("muccauhoi");

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

				System.out.println("mutableDanhSachCauHoi ====== " + PhieudanhgiaChuan);

				// =================== Tạo file
				// PDF===============================================================
				
				System.out.println("tenfileUrl ===================== " + tenfile);
				String dest = "D:\\AppTimekeeping\\liferay-ce-portal-7.4.3.42-ga42\\filePdf\\" + pdfFileName;
				PdfWriter writer = new PdfWriter(dest);

				// Creating a PdfDocument
				PdfDocument pdfDoc = new PdfDocument(writer);

				// Adding a new page
				pdfDoc.addNewPage();

				// Creating a Document
				Document document = new Document(pdfDoc);
				float marginTop = 40; // 1 inch (2.54 cm)
				float marginBottom = 36; // 0.5 inch (1.27 cm)
				float marginLeft = 30; // 50pt (~1.77 cm)
				float marginRight = 30; // 50pt (~1.77 cm)
				// float defaultFontSize = 12;
				document.setMargins(marginTop, marginRight, marginBottom, marginLeft);

				String fontPath = "D:\\\\AppTimekeeping\\\\Timekeeping\\\\modules\\\\XinNghi\\\\src\\\\main\\\\resources\\\\META-INF\\\\resources\\\\font\\\\Tinos-Regular.ttf"; // .otf
				PdfFont defaultFont = PdfFontFactory.createFont(fontPath, "Identity-H", true);
				// Lấy Ngày Hiện Tại
				LocalDate currentDate = LocalDate.now();
				// Lấy năm, tháng và ngày hiện tại
				int year = currentDate.getYear();
				int month = currentDate.getMonthValue();
				int day = currentDate.getDayOfMonth();
				String yearString = String.valueOf(year);
				String monthString = String.valueOf(month);
				String dayString = String.valueOf(day);

				// lấy thông tin

				// Lấy những từ tiếng việt
				String text1 = "";
				String text2 = "";
				String text3 = "";
				String text4 = "";
				String text5 = "";
				String text6 = "";
				String text7 = "";
				String text8 = "";
				String text9 = "";
				String text10 = "";
				String text11 = "";
				String text12 = "";
				String text13 = "";
				String text14 = "";
				String text15 = "";
				String text16 = "";

				try {
					
					tudanhgia thongtinchamdiem = LayThongTinTuDanhGia(userId, thang, nam);
		
					long UserIdchamdiem = thongtinchamdiem.getUser_id();
					String tenphong = LayTenPhongByPhongBanId(thongtinchamdiem.getPhongban_id());
					String chucvu = LayChucVuByPhongBanId(user.getChucvu_id());

					text1 = TutiengvietLocalServiceUtil.getTutiengviet(7).getTu_tieng_viet();
					text2 = TutiengvietLocalServiceUtil.getTutiengviet(9).getTu_tieng_viet() + "\n"
							+ TutiengvietLocalServiceUtil.getTutiengviet(10).getTu_tieng_viet();
					text3 = TutiengvietLocalServiceUtil.getTutiengviet(8).getTu_tieng_viet();
					text4 = TutiengvietLocalServiceUtil.getTutiengviet(11).getTu_tieng_viet() + ", "
							+ TutiengvietLocalServiceUtil.getTutiengviet(12).getTu_tieng_viet() + " " + dayString + " "
							+ TutiengvietLocalServiceUtil.getTutiengviet(13).getTu_tieng_viet() + " " + monthString
							+ " " + TutiengvietLocalServiceUtil.getTutiengviet(14).getTu_tieng_viet() + " "
							+ yearString;
					text5 = TutiengvietLocalServiceUtil.getTutiengviet(15).getTu_tieng_viet() + "\r\n "
							+ TutiengvietLocalServiceUtil.getTutiengviet(13).getTu_tieng_viet().toUpperCase() + " "
							+ monthString + " "
							+ TutiengvietLocalServiceUtil.getTutiengviet(14).getTu_tieng_viet().toUpperCase() + " "
							+ yearString;
					;
					text6 = TutiengvietLocalServiceUtil.getTutiengviet(16).getTu_tieng_viet() + ": "
							+ user.getHovaten();
					text7 = TutiengvietLocalServiceUtil.getTutiengviet(17).getTu_tieng_viet() + ": " + chucvu;
					text8 = TutiengvietLocalServiceUtil.getTutiengviet(18).getTu_tieng_viet() + ": " + tenphong;
					text9 = TutiengvietLocalServiceUtil.getTutiengviet(19).getTu_tieng_viet();
					text10 = TutiengvietLocalServiceUtil.getTutiengviet(24).getTu_tieng_viet();
					text11 = TutiengvietLocalServiceUtil.getTutiengviet(25).getTu_tieng_viet();
					text12 = TutiengvietLocalServiceUtil.getTutiengviet(26).getTu_tieng_viet();
					text13 = TutiengvietLocalServiceUtil.getTutiengviet(20).getTu_tieng_viet() + ": "
							+ thongtinchamdiem.getXeploai();
					text14 = TutiengvietLocalServiceUtil.getTutiengviet(21).getTu_tieng_viet();
					text15 = TutiengvietLocalServiceUtil.getTutiengviet(22).getTu_tieng_viet();
					text16 = TutiengvietLocalServiceUtil.getTutiengviet(23).getTu_tieng_viet();

				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				float[] columnWidths = { 40f, 60f };
				Table table = new Table(columnWidths);
				table.setWidthPercent(100);

				// Thêm nội dung vào bảng
				table.addCell(new Cell().add(text1).setBorder(Border.NO_BORDER).setFontSize(12))
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)
						.setFont(defaultFont);
				table.addCell(
						new Cell().add(text2).setBorder(Border.NO_BORDER).setMarginTop(5).setBold().setFontSize(14))
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)
						.setFont(defaultFont);
				table.addCell(new Cell().add(text3).setBorder(Border.NO_BORDER).setMarginTop(-12).setBold())
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)
						.setFont(defaultFont);
				table.addCell(new Cell().add("------------------------").setBorder(Border.NO_BORDER).setMarginTop(-5))
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)
						.setFont(defaultFont);
				table.addCell(new Cell().add("------------------------").setBorder(Border.NO_BORDER).setMarginTop(-14))
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)
						.setFont(defaultFont);
				table.addCell(new Cell().add(text4).setBorder(Border.NO_BORDER).setMarginTop(25)
						.setTextAlignment(TextAlignment.CENTER).setPaddingRight(-50))
						.setVerticalAlignment(VerticalAlignment.MIDDLE).setFont(defaultFont);
				document.add(table);
				Paragraph paragraph1 = new Paragraph(text5);
				paragraph1.setTextAlignment(TextAlignment.CENTER).setFontSize(14).setFont(defaultFont).setMarginTop(15)
						.setBold();
				document.add(paragraph1);
				Paragraph paragraph2 = new Paragraph(text6).setTextAlignment(TextAlignment.LEFT).setFont(defaultFont)
						.setMarginLeft(20);
				Paragraph paragraph3 = new Paragraph(text7).setTextAlignment(TextAlignment.LEFT).setFont(defaultFont)
						.setMarginLeft(20);
				Paragraph paragraph4 = new Paragraph(text8).setTextAlignment(TextAlignment.LEFT).setFont(defaultFont)
						.setMarginLeft(20);
				document.add(paragraph2);
				document.add(paragraph3);
				document.add(paragraph4);
				Paragraph paragraph5 = new Paragraph(text9).setTextAlignment(TextAlignment.LEFT).setFont(defaultFont)
						.setMarginLeft(20).setBold().setFontSize(16);
				document.add(paragraph5);

				float[] columnWidths1 = { 1f, 3f, 1f, 1f };
				Table table1 = new Table(columnWidths1);

				table1.setWidthPercent(100).setMarginLeft(20);
				table1.addHeaderCell(new Cell().add("TT").setFont(defaultFont));
				table1.addHeaderCell(new Cell().add(text10).setFont(defaultFont));
				table1.addHeaderCell(new Cell().add(text11).setFont(defaultFont));
				table1.addHeaderCell(new Cell().add(text12).setFont(defaultFont));
				for (Map<String, Object> question : PhieudanhgiaChuan) {
					table1.addCell(new Cell().add(new Paragraph(String.valueOf(question.get("muccauhoi"))))
							.setFont(defaultFont));
					table1.addCell(
							new Cell().add(new Paragraph(String.valueOf(question.get("cauhoi")))).setFont(defaultFont));
					table1.addCell(new Cell().add(new Paragraph(String.valueOf(question.get("diemtoida"))))
							.setFont(defaultFont));
					table1.addCell(new Cell().add(new Paragraph(String.valueOf(question.get("diemtucham"))))
							.setFont(defaultFont));
				}
				table1.addCell(new Cell().add(new Paragraph("")).setFont(defaultFont));
				table1.addCell(new Cell().add(new Paragraph("Tong")).setFont(defaultFont));
				table1.addCell(new Cell().add(new Paragraph("100")).setFont(defaultFont));
				table1.addCell(new Cell().add(new Paragraph(tongdiemString)).setFont(defaultFont));

				document.add(table1);

				Paragraph mucdanhgia = new Paragraph(text13).setTextAlignment(TextAlignment.LEFT).setFont(defaultFont)
						.setMarginLeft(20).setMarginTop(20);
				Paragraph ykienkhac1 = new Paragraph(text14).setTextAlignment(TextAlignment.LEFT).setFont(defaultFont)
						.setMarginLeft(20);
				document.add(mucdanhgia);
				document.add(ykienkhac1);
				float[] columnWidths2 = { 1f, 1f };
				Table table2 = new Table(columnWidths2);
				table2.setWidthPercent(100);
				table2.addHeaderCell(new Cell().add("").setFont(defaultFont).setBorder(Border.NO_BORDER));
				table2.addHeaderCell(new Cell().add(text4).setFont(defaultFont).setBorder(Border.NO_BORDER)
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
				table2.addHeaderCell(new Cell().add("").setFont(defaultFont).setBorder(Border.NO_BORDER));
				table2.addHeaderCell(new Cell().add(text15).setFont(defaultFont).setBorder(Border.NO_BORDER)
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
				table2.addHeaderCell(new Cell().add("").setFont(defaultFont).setBorder(Border.NO_BORDER));
				table2.addHeaderCell(new Cell().add(text16).setFont(defaultFont).setBorder(Border.NO_BORDER)
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
				table2.addHeaderCell(new Cell().add("").setFont(defaultFont).setBorder(Border.NO_BORDER));
				table2.addHeaderCell(new Cell().add(user.getHovaten()).setFont(defaultFont).setBorder(Border.NO_BORDER)
						.setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)
						.setMarginTop(50));
				document.add(table2);

				// Closing the document
				document.close();
				System.out.println("PDF Created");

			} catch (Exception e) {
				// TODO: handle exception
			}
			response.sendRedirect("/phieu-diem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		int quyenxemgiolam = checkQuyenTruongPhong(user);
		renderRequest.setAttribute("quyenxemgiolam", quyenxemgiolam);
		// hiển thị phiếu điểm cá nhân
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<adminphieudiem> danhsachcauhoi = adminphieudiemLocalServiceUtil.getadminphieudiems(-1, -1);
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

		// Lấy ngày tháng năm
		year = renderRequest.getParameter("year");
		month = renderRequest.getParameter("thang");
		if (year == null) {
			LocalDate ngayHienTai22 = LocalDate.now();
			int namHienTai = ngayHienTai22.getYear();
			year = String.valueOf(namHienTai);
		} else {
			year = year;
		}
		if (month == null) {
			LocalDate ngayHienTai22 = LocalDate.now();
			int thanghientai = ngayHienTai22.getMonthValue();
			month = String.format("%02d", thanghientai);
		} else {
			int numericMonth = Integer.parseInt(month);
			month = String.format("%02d", numericMonth);
		}
		String keyyear = year;
		String keymonth = month;
		renderRequest.setAttribute("monthhienthi", month);
		renderRequest.setAttribute("yearhienthi", year);
		int namInt = Integer.parseInt(keyyear);
		int thangInt = Integer.parseInt(keymonth);
		tudanhgia phieudanhgiaBanThan = LayThongTinTuDanhGia(userId, thangInt, namInt);
		int trangthaixacnhan = 0;

		// Lấy điểm chấm công của tháng ứng vs userId tháng và năm đến ngày hôm nay
		double tongdiemThangtinhdenHienTai = LaydiemchamcongOfThangDenThoiDiemHienTai(userId, thangInt, namInt);
		double tongDiemToiDaThang = TinhDiemToiDaOfThang(thangInt, namInt);
		double diemchamcongphieuChamdiem = Math.round((2 * tongdiemThangtinhdenHienTai / tongDiemToiDaThang) * 1000)
				/ 1000;
		renderRequest.setAttribute("diemchamcongphieuChamdiem", diemchamcongphieuChamdiem);
		if (phieudanhgiaBanThan != null) {
			String thongtintudanhgia = phieudanhgiaBanThan.getThongtintudanhgia();
			List<Map<String, Object>> danhSachPhieutucham = new ArrayList<>();
			Gson gson = new Gson();
			Type mapType = new TypeToken<Map<String, Object>>() {
			}.getType();

			// tudanhgia thongtinchamdiem =
			// tudanhgiaLocalServiceUtil.gettudanhgia(thongtintudanhgiaUserId.getId());
			Map<String, Object> map = gson.fromJson(thongtintudanhgia, mapType);

			// Lặp qua các phần tử trong Map và thêm vào danh sách
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Map<String, Object> item = new HashMap<>();
				item.put("UUID", entry.getKey());
				item.put("diemcauhoi", entry.getValue());
				danhSachPhieutucham.add(item);
			}

			trangthaixacnhan = 1;
			String ykienkhac = phieudanhgiaBanThan.getYkienkhac();
			String xeploai = phieudanhgiaBanThan.getXeploai();
			String URL_file = phieudanhgiaBanThan.getFile_url();
			renderRequest.setAttribute("URL_file", URL_file);
			renderRequest.setAttribute("userId", userId);
			renderRequest.setAttribute("ykienkhac", ykienkhac);
			renderRequest.setAttribute("xeploai", xeploai);
			renderRequest.setAttribute("danhSachPhieutucham", danhSachPhieutucham);

		}

		renderRequest.setAttribute("trangthaixacnhan", trangthaixacnhan);
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

	public String LayTenPhongByPhongBanId(long phongbanId) {
		String tenphong = "";
		List<Phongban> ListPhongBans = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		for (Phongban phongban : ListPhongBans) {
			if ((long) phongban.getId() == phongbanId) {
				tenphong = phongban.getTenphong();
			}
		}

		return tenphong;
	}

	public String LayChucVuByPhongBanId(long ChucVuId) {
		String chucvu = "";
		List<Chucvu> ListChucVus = ChucvuLocalServiceUtil.getChucvus(-1, -1);
		for (Chucvu chucvu2 : ListChucVus) {
			if ((long) chucvu2.getId() == ChucVuId) {
				chucvu = chucvu2.getName();
			}
		}

		return chucvu;
	}

	public void xuatfilePDF(Users user, long userid, int thang, int nam, String tenfile) {

	}

	public String laydiemtudanhgia(String uuid, long userId, int thang, int nam) {
		String diemtucham = "0";
		List<Map<String, Object>> danhSach = new ArrayList<>();
		Gson gson = new Gson();
		Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		tudanhgia thongtinchamdiem = LayThongTinTuDanhGia(userId, thang, nam);

		// tudanhgia thongtinchamdiem =
		// tudanhgiaLocalServiceUtil.gettudanhgia(thongtintudanhgiaUserId.getId());
		String thongtintudanhgia = thongtinchamdiem.getThongtintudanhgia();
		Map<String, Object> map = gson.fromJson(thongtintudanhgia, mapType);

		// Lặp qua các phần tử trong Map và thêm vào danh sách
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			Map<String, Object> item = new HashMap<>();
			item.put("UUID", entry.getKey());
			item.put("diemcauhoi", entry.getValue());
			danhSach.add(item);
		}
		// In danh sách ra màn hình
		for (Map<String, Object> map1 : danhSach) {
			if (map1.get("UUID").equals(uuid)) {
				Double diem = (Double) map1.get("diemcauhoi");
				diemtucham = String.valueOf(diem);
			}
		}

		return diemtucham;
	}

	// Lấy phiếu đánh giá qua tháng, năm , userid
	public tudanhgia LayThongTinTuDanhGia(long userId, int thang, int nam) {
		List<tudanhgia> ListTuDanhGia = tudanhgiaLocalServiceUtil.gettudanhgias(-1, -1);
		tudanhgia thongtincanlay = null;

		for (tudanhgia x : ListTuDanhGia) {
			if (x.getUser_id() == userId && x.getNam() == nam && x.getThang() == thang) {
				thongtincanlay = x;
			}
		}
		return thongtincanlay;

	}

	// Lấy phiếu đánh giá qua tháng, năm , userid
	public double LaydiemchamcongOfThangDenThoiDiemHienTai(long userId, int thang, int nam) {

		List<GioLam> listGioLam = GioLamLocalServiceUtil.getGioLams(-1, -1);
		double tongdiemthang = 0;
		for (GioLam gioLam : listGioLam) {
			long userIdNgayLam = gioLam.getUser_id();
			Date ngaylam = gioLam.getNgay_lam();
			LocalDateTime localDateTime = ngaylam.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			int thangofNgayLam = localDateTime.getMonthValue();
			int namofNgayLam = localDateTime.getYear();

			if (userIdNgayLam == userId && thangofNgayLam == thang && namofNgayLam == nam) {
				tongdiemthang += gioLam.getDiem();
			}

		}
		return tongdiemthang;

	}

	public double TinhDiemToiDaOfThang(int thang, int nam) {

		List<Ngaylamviec> listNgaylamviecs = NgaylamviecLocalServiceUtil.getNgaylamviecs(-1, -1);
		Ngaylamviec NgayLamViec = listNgaylamviecs.stream()
				.filter(ngaylamviec -> ngaylamviec.getNam() == nam && ngaylamviec.getThang() == thang).findFirst()
				.orElse(null); // Nếu không tìm thấy thì trả về null
		double TinhDiemToiDaOfThang = 0;
		if (NgayLamViec == null) {
			TinhDiemToiDaOfThang = 0;
		} else {
			TinhDiemToiDaOfThang = NgayLamViec.getSo_ngay_lam_viec() * 4;
		}

		return TinhDiemToiDaOfThang;
	}

}