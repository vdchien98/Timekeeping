package com.liferay.docs.giolam.portlet.portlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.backend.model.Calamviec;
import com.liferay.docs.backend.model.GioLam;
import com.liferay.docs.backend.model.Ngaylamviec;
import com.liferay.docs.backend.model.Ngaynghile;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Tutiengviet;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.CalamviecLocalServiceUtil;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.backend.service.NgaynghileLocalServiceUtil;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.TutiengvietLocalService;
import com.liferay.docs.backend.service.TutiengvietLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.giolam.portlet.constants.GioLamPortletKeys;
import com.liferay.petra.io.OutputStreamWriter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.osgi.service.component.annotations.Component;

import PortletUtils.portlet.CustomWebCacheItem;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GioLam", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/giolam/GioLam.jsp", "javax.portlet.name=" + GioLamPortletKeys.GIOLAM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class GioLamPortlet extends MVCPortlet {
	// Check ngày hiện tại và giờ hiện tại
	LocalDate currentDate = LocalDate.now();
	ZoneId zoneId = ZoneId.of("UTC+7");
	Date dateNgayHienTai = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	String year = "";
	String month = "";

	public void sendMaZalo(ActionRequest request, ActionResponse sponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = new ServiceContext();
		long userId = themeDisplay.getUserId();
		// System.out.println("userId la *******" + userId);
		try {
			// tao ma_xac_nhan va luu vao data
			Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
			// System.out.println("user 44444444444444444444444444 "+ user);
			int id = user.getId();
			Random random = new Random();
			int ma_xac_nhan = random.nextInt(9000) + 1000; // Tạo số ngẫu nhiên có 4 chữ số
			String ma_xac_nhan_string = "" + ma_xac_nhan;
			UsersLocalServiceUtil.updateUser(id, ma_xac_nhan_string, serviceContext);
			String message = ma_xac_nhan_string
					+ " : M\u00E3 x\u00E1c nh\u1EADn ch\u1EA5m c\u00F4ng t\u1EEB H\u1EC7 th\u1ED1ng ch\u1EA5m c\u00F4ng, giao vi\u1EC7c.";
			// gui ma xac nhan cho zalo
			sendMaXacThucToZalo(message, user.getZalo_id());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendMaXacThucToZalo(String message, String zalo_id) throws IOException, PortletException {
		// System.out.println("da vao dc sendMaXacThucToZalo"+ message);

		// getAccessTokenZaloNew();

		JsonObject user_id_info = getInfoZalo(zalo_id);
		// System.out.println("user_id_info" + user_id_info);

		if (user_id_info.has("data")) {
			JsonObject dataObject = user_id_info.getAsJsonObject("data");
			if (dataObject.has("user_id")) {
				String userId_Info = dataObject.get("user_id").getAsString();

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONObject recipient = JSONFactoryUtil.createJSONObject();
				recipient.put("user_id", userId_Info);
				JSONObject messageOne = JSONFactoryUtil.createJSONObject();
				messageOne.put("text", message);
				data.put("recipient", recipient);
				data.put("message", message);
				// Chuyển đổi thành chuỗi JSON
				String data_string = data.toString();

				JsonObject jsonObject = new Gson().fromJson(data_string, JsonObject.class);
				String datastringnew = (String) jsonObject.get("message").getAsString();

//				System.out.println("datastringnew ************** " + datastringnew);
//
//				System.out.println(" user_id " + user_id_info);

				WebCacheItem access_token_value = new CustomWebCacheItem("access_token_key");
				// Lưu trữ CustomWebCacheItem vào WebCachePool
				String access_token = (String) WebCachePoolUtil.get("access_token_key", access_token_value);
				// System.out.println("access_token sendMaXacThucToZalo " + access_token);

				URL url = new URL("https://openapi.zalo.me/v2.0/oa/message");

				// Mở kết nối HTTP
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				// Cấu hình kết nối
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("access_token", access_token);
				connection.setDoOutput(true);

				// Chuẩn bị dữ liệu gửi đi
				String datatozalo = "{\n" + "  \"recipient\": {\n" + "    \"user_id\": \"" + userId_Info + "\"\n"
						+ "  },\n" + "  \"message\": {\n" + "    \"text\":  \"" + datastringnew + "\"\n" + "  }\n"
						+ "}";
				byte[] postData = datatozalo.getBytes("UTF-8");

				// Gửi dữ liệu
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(postData);
				outputStream.flush();
				outputStream.close();

				// Nhận phản hồi
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();

				// Xử lý phản hồi
				int responseCode = connection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					// Xử lý phản hồi thành công
					System.out.println("Yêu cầu đã được gửi thành công.");
				} else {
					// Xử lý phản hồi lỗi
					System.out.println("Yêu cầu gửi không thành công. Mã phản hồi: " + responseCode);
				}

			}
		}

	}

	/* get Info của zalo đầu vào có thể là zalo_id hoặc sđt 0815269889 */
	public JsonObject getInfoZalo(String zalo_id) throws IOException, PortletException {

		// System.out.println("da vao dc getInfoZalo " + zalo_id);

		/* Kiểm tra access token có tồn tại trong cache chưa */
		WebCacheItem access_token_value = new CustomWebCacheItem("access_token_key");

		if (WebCachePoolUtil.get("access_token_key", access_token_value) == null) {
			// WebCacheItem refresh_token_value = new
			// CustomWebCacheItem("refresh_token_key");
			// Object refresh_token = WebCachePoolUtil.get("refresh_token_key",
			// refresh_token_value);
			// System.out.println("refresh_token: " + refresh_token);

			List<Map<String, String>> token = getAccessTokenZalo(
					WebCachePoolUtil.get("access_token_key", access_token_value));

			WebCacheItem wca = new CustomWebCacheItem("access_token_key_new", token);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("access_token_key", wca);
			WebCacheItem wca1 = new CustomWebCacheItem("refresh_token_key_new", token);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("refresh_token_key", wca1);
		}

		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("user_id", zalo_id);
		String dataString = data.toString();
		// System.out.println("dataString $$$$$$$ " + dataString);

		String zalo_key = (String) WebCachePoolUtil.get("access_token_key", access_token_value);
		// System.out.println("zalo_key 9999999995555555 " + zalo_key);

		try {
			String apiUrl = "https://openapi.zalo.me/v2.0/oa/getprofile";
			String queryParam = "data=" + URLEncoder.encode(dataString, "UTF-8");
			String urlString = apiUrl + "?" + queryParam;

			// Tạo URL từ địa chỉ đã xây dựng
			URL url = new URL(urlString);

			// Mở kết nối HTTP
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Cấu hình kết nối
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent", "Get info zalo");
			connection.setRequestProperty("access_token", zalo_key);

			// Nhận phản hồi
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Giải mã phản hồi từ JSON thành đối tượng
			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
			// System.out.println("jsonObject: " + jsonObject);

			// Trả về kết quả
			return jsonObject;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	/* get access_token zalo sau mỗi lần access_token hết hạn */
	public List<Map<String, String>> getAccessTokenZalo(Object refresh_token) throws IOException, PortletException {
		List<Map<String, String>> tokenPairs = new ArrayList<>();
		try {
			System.out.println("da tao dk cho get    ************* ");
			// Tạo URL và kết nối HTTP
			URL url = new URL("https://oauth.zaloapp.com/v4/oa/access_token");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// Cấu hình phương thức POST và tiêu đề
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("secret_key", "KGasVgygovT17H1J5P3Z");
			String refresh_token_str = (String) refresh_token;

			// Chuẩn bị dữ liệu gửi đi
			String data = "refresh_token=" + refresh_token_str + "&app_id=2751734353755237620"
					+ "&grant_type=refresh_token";

			// Gửi dữ liệu
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(data.getBytes());
			outputStream.flush();
			outputStream.close();

			// Đọc kết quả trả về
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			// Xử lý kết quả
			System.out.println("response.toString() " + response.toString());
			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);

			// Lấy giá trị của trường "key_access_token"
			String accessToken = jsonObject.get("access_token").getAsString();

			// Lấy giá trị của trường "key_refresh_token"
			String refreshToken = jsonObject.get("refresh_token").getAsString();

			System.out.println("accessToken  *******" + accessToken);
			System.out.println("refreshToken *******" + refreshToken);
			// Khởi tạo danh sách để lưu trữ các cặp khóa-giá trị

			// Tạo đối tượng Map cho cặp access token
			Map<String, String> accessTokenPair = new HashMap<>();
			accessTokenPair.put("access_token_key", accessToken);

			// Thêm cặp access token vào danh sách
			tokenPairs.add(accessTokenPair);

			// Tạo đối tượng Map cho cặp refresh token
			Map<String, String> refreshTokenPair = new HashMap<>();
			refreshTokenPair.put("refresh_token_key", refreshToken);
			// Thêm cặp refresh token vào danh sách
			tokenPairs.add(refreshTokenPair);
			// In danh sách các cặp khóa-giá trị
			// In danh sách các cặp khóa-giá trị
//			for (Map<String, String> tokenPair : tokenPairs) {
//				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
////					String key = entry.getKey();
////					String value = entry.getValue();
//					// System.out.println(key + ": " + value);
//				}
//			}

			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokenPairs;
	}

	/* get access_token zalo khi bắt đầu khởi tạo, ghi vào cache */

	public void getAccessTokenZaloNew() throws IOException, PortletException {
		try {
			System.out.println("da tao dk cho get    ************* ");
			// Tạo URL và kết nối HTTP
			URL url = new URL("https://oauth.zaloapp.com/v4/oa/access_token");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// Cấu hình phương thức POST và tiêu đề
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("secret_key", "KGasVgygovT17H1J5P3Z");

			// Chuẩn bị dữ liệu gửi đi
			String data = "refresh_token=ucCB9LZQGnpZOGabMzn37UTZ2YLOnKrQXdf74dsQN56vH4K9KOz8LxOsVp8B_LS0_19HSZlDPXsP3tLIMCLX58TrV4nlf70yXsTA1a6YJKcC6sqIPlGYVRWoC01n_o5acnytEaBw7sMbEL4tV-O3Ih8_6ZXBXr1Xj29s0GtOPsYpA64qRSOp1e456dzOmJ8Jit0cN4cG7Z3rR0TkJAC2BgbY9NGGt2qu-3iT1nI71rtQIGqL0R8_Mk8F8HCLj3DEmbKqBHoN4r3TPoWeVumYICDXBouRdHWSv6O9KpsY0X7wVWn24Oyx1UHK2pOuj3zkr0yk2HA-OJlaLLD9HgvY0AnUH6bQxaupjrLQOr-N4owAI0v-Tl4m9BqE6qLjsLOgrZD6RJlZImdYMmDI9-4Q4ZYFY7yAMSL660"
					+ "&app_id=2751734353755237620" + "&grant_type=refresh_token";

			// Gửi dữ liệu
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(data.getBytes());
			outputStream.flush();
			outputStream.close();

			// Đọc kết quả trả về
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			// Xử lý kết quả
			System.out.println("response.toString() " + response.toString());
			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);

			// Lấy giá trị của trường "key_access_token"
			String accessToken = jsonObject.get("access_token").getAsString();

			// Lấy giá trị của trường "key_refresh_token"
			String refreshToken = jsonObject.get("refresh_token").getAsString();

			System.out.println("accessToken  *******" + accessToken);
			System.out.println("refreshToken *******" + refreshToken);
			// Khởi tạo danh sách để lưu trữ các cặp khóa-giá trị
			List<Map<String, String>> tokenPairs = new ArrayList<>();

			// Tạo đối tượng Map cho cặp access token
			Map<String, String> accessTokenPair = new HashMap<>();
			accessTokenPair.put("access_token_key", accessToken);

			// Thêm cặp access token vào danh sách
			tokenPairs.add(accessTokenPair);

			// Tạo đối tượng Map cho cặp refresh token
			Map<String, String> refreshTokenPair = new HashMap<>();
			refreshTokenPair.put("refresh_token_key", refreshToken);
			// Thêm cặp refresh token vào danh sách
			tokenPairs.add(refreshTokenPair);
			// In danh sách các cặp khóa-giá trị
			// In danh sách các cặp khóa-giá trị
			// System.out.println("tokenPairs la 111111112222222" + tokenPairs);
//			for (Map<String, String> tokenPair : tokenPairs) {
//				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
//					String key = entry.getKey();
//					String value = entry.getValue();
//					// System.out.println(key + ": " + value);
//				}
//			}

			WebCacheItem wca = new CustomWebCacheItem("access_token_key_new", tokenPairs);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("access_token_key", wca);
//			System.out.println("WebCachePoolUtil.get(keys, wci)***" + WebCachePoolUtil.get("access_token_key", wca));

			WebCacheItem wca1 = new CustomWebCacheItem("refresh_token_key_new", tokenPairs);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("refresh_token_key", wca1);
//			System.out.println("WebCachePoolUtil.get(keys, wci)*** refresh_token_key  "
//					+ WebCachePoolUtil.get("refresh_token_key", wca1));
			// Đóng kết nối
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xử lý xác thực mã
	public void ActionChamCong(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = new ServiceContext();
		long userId = themeDisplay.getUserId();
		int maxacthuc = ParamUtil.getInteger(request, "maxacthuc");
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);

		// Lấy thời gian
		List<Calamviec> calamviecList = CalamviecLocalServiceUtil.getCalamviecs(-1, 1);
		Calamviec calamviec = calamviecList.get(0);
		String giovaosang = calamviec.getGio_vao_sang();
		int thoigianvaosomsang = calamviec.getVao_truoc_sang();
		String giorasang = calamviec.getGio_ra_sang();
		int thoigianramuonsang = calamviec.getRa_sau_sang();
		String giovaochieu = calamviec.getGio_vao_chieu();
		int thoigianvaosomchieu = calamviec.getVao_truoc_chieu();
		String giorachieu = calamviec.getGio_ra_chieu();
		int thoigianramuonchieu = calamviec.getRa_sau_chieu();
		// Lấy khung giờ làm việc buổi sáng
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		// Thực hiện h vào sáng
		LocalTime gioVaoSang = LocalTime.parse(giovaosang, formatter);
		LocalTime gioChamCongVaoSangFormatted = gioVaoSang.minusMinutes(thoigianvaosomsang);
		// gioChamCongVaoSangFormatted.format(formatter); // chuyển sang String
		// thực hiện giờ ra sáng
		LocalTime gioRaSang = LocalTime.parse(giorasang, formatter);
		LocalTime gioChamCongRaSangFormatted = gioRaSang.plusMinutes(thoigianramuonsang);
		// thực hiện giờ vào chiều
		LocalTime gioVaoChieu = LocalTime.parse(giovaochieu, formatter);
		LocalTime gioChamCongVaoChieuFormatted = gioVaoChieu.minusMinutes(thoigianvaosomchieu);
		// thực hiện giờ ra chiều
		LocalTime gioRaChieu = LocalTime.parse(giorachieu, formatter);
		LocalTime gioChamCongRaChieuFormatted = gioRaChieu.plusMinutes(thoigianramuonchieu);
		// Lấy ngày hiện tại
		LocalDate ngayHienTai = LocalDate.now();
		Date ngayHienTaikieuDate = Date.from(ngayHienTai.atStartOfDay(ZoneId.systemDefault()).toInstant());

		DateTimeFormatter ngayHienTaiformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String ngayHienTaiDinhDang = ngayHienTai.format(ngayHienTaiformatter);
		System.out.println("Ngay hien tai:------------- " + ngayHienTaiDinhDang);
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime currentTime = LocalTime.now(zoneId);
		String gioHienTai = currentTime.format(formatter);
		LocalTime gioHienTaiDate = LocalTime.parse(gioHienTai, DateTimeFormatter.ofPattern("HH:mm"));
		// check gio hiẹn tại nằm trong khoảng nào
		boolean GioHienTaiTrongBuoiSang = gioHienTaiDate.isAfter(gioChamCongVaoSangFormatted)
				&& gioHienTaiDate.isBefore(gioChamCongRaSangFormatted);
		// check gio hiẹn tại nằm trong khoảng nào
		boolean GioHienTaiTrongBuoiChieu = gioHienTaiDate.isAfter(gioChamCongVaoChieuFormatted)
				&& gioHienTaiDate.isBefore(gioChamCongRaChieuFormatted);

		String x = user.getMa_xac_nhan();
		int maxacthucData = Integer.parseInt(x);

		try {
			GioLam userGioLam = GioLamLocalServiceUtil.getGioLamByUserId(userId, dateNgayHienTai);
			if (maxacthuc == maxacthucData) {
				System.out.println("oki okiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii ");
				if (userGioLam == null) {
					if (GioHienTaiTrongBuoiSang == true) {
						int chenhLechPhutVaoSang = (int) ChronoUnit.MINUTES.between(gioVaoSang, gioHienTaiDate);

						GioLamLocalServiceUtil.addGioLamVaoSang(userId, ngayHienTaikieuDate, gioHienTai,
								chenhLechPhutVaoSang, 1, serviceContext);

					} else if (GioHienTaiTrongBuoiChieu == true) {
//						int chenhLechPhutVaoChieu = (int) gioHienTaiDate.until(gioChamCongVaoChieuFormatted,
//								ChronoUnit.MINUTES);
						int chenhLechPhutVaoChieu = (int) ChronoUnit.MINUTES.between(gioVaoChieu, gioHienTaiDate);

						GioLamLocalServiceUtil.addGioLamVaoChieu(userId, ngayHienTaikieuDate, gioHienTai,
								chenhLechPhutVaoChieu, 1, serviceContext);

					} else {

					}

				} else {
					// Thực hiện khi đã có dữ liệu

					if (GioHienTaiTrongBuoiSang == true) {
						// String checkinSang = userGioLam.getCheck_in_sang();
						System.out.println("thoi diem hiẹn tai la -------***************************** ");
						int idGioLam = userGioLam.getId();
						long user_id = userGioLam.getUser_id();
						System.out.println("idGioLam la---------- " + idGioLam);

						int chenhLechPhutRaSang = (int) ChronoUnit.MINUTES.between(gioHienTaiDate, gioRaSang);
						// System.out.println("chenhLechPhutRaSang ------ " + chenhLechPhutRaSang);
						// float diem = (float) userGioLam.getDiem();
						// System.out.println("diem hien tai la ------- " + diem);

						GioLamLocalServiceUtil.updateGioLamRaSang(idGioLam, user_id, gioHienTai, chenhLechPhutRaSang, 1,
								serviceContext);

					} else if (GioHienTaiTrongBuoiChieu == true) {
						String checkinchieu = userGioLam.getCheck_in_chieu();
						String checkinSang = userGioLam.getCheck_in_sang();
						String checkoutSang = userGioLam.getCheck_out_sang();
						String checkoutchieu = userGioLam.getCheck_out_chieu();
						long user_id = userGioLam.getUser_id();
						int idGioLam = userGioLam.getId();
						if (checkinSang.equals("") == false && checkoutSang.equals("") == false
								&& checkinchieu.equals("") == false) {

							int chenhLechPhutRaChieu = (int) ChronoUnit.MINUTES.between(gioHienTaiDate, gioRaChieu);

							GioLamLocalServiceUtil.updateGioLamRaChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutRaChieu, 1, serviceContext);
						} else if (checkinSang.equals("") == false && checkoutSang.equals("") == false) {
							// System.out.println("da cham cong sang nhưng chưa cham cong vao chieu");
							int chenhLechPhutVaoChieu = (int) ChronoUnit.MINUTES.between(gioVaoChieu, gioHienTaiDate);

							GioLamLocalServiceUtil.updateGioLamVaoChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutVaoChieu, 1, serviceContext);
						} else if (checkinSang.equals("") == false) {
							// trường hợp chấm công nhiều thường xuyên
//							int chenhLechPhutRaChieu = (int) gioHienTaiDate.until(gioChamCongRaChieuFormatted,
//									ChronoUnit.MINUTES);
							int chenhLechPhutRaChieu = (int) ChronoUnit.MINUTES.between(gioHienTaiDate, gioRaChieu);

							GioLamLocalServiceUtil.updateGioLamRaChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutRaChieu, 1, serviceContext);
						} else if (checkinchieu.equals("") == false) {
							// System.out.println("da cham cong sang nhưng chưa cham cong vao chieu");
							int chenhLechPhutRaChieu = (int) ChronoUnit.MINUTES.between(gioHienTaiDate, gioRaChieu);
							// float diem = (float) userGioLam.getDiem();

							GioLamLocalServiceUtil.updateGioLamRaChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutRaChieu, 1, serviceContext);

						}

					} else {
						// renderRequest.setAttribute("khongchamcong", true);
					}

				}
			} else {
				System.out.println("Mã xác thực không hợp lệ");
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// response.setProperty("hideModalBackdrop", "true");

		response.sendRedirect("/gio-lam");

	}

	// Xử lý xuất báo cáo và dowload báo cáo

	public void OpenExxcel(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		System.out.println("--------------------------------da va dc day ------------------------------ ");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users userBaoCao = UsersLocalServiceUtil.getUserbyUserId(userId);
		int quyenxuatBaoCao = checkQuyenTruongPhong(userBaoCao);
		List<List<Map<String, Object>>> danhSachNgayTrongThangcaPhong = new ArrayList<>();
		List<Map<String, Object>> ListXuatBao = new ArrayList<>();
		Map<String, Object> XuatbaoCao = new HashMap<>();

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
		int thang = Integer.parseInt(keymonth);
		int nam = Integer.parseInt(keyyear);

		if (quyenxuatBaoCao == 1) {
			// Xử lý hiện thị cho trưởng phòng hành chính và phụ trách phòng hành chính và
			// giám đốc
			List<Users> TatcaNhanVien = UsersLocalServiceUtil.getUserses(-1, -1);
			List<Users> userListtheothutuphong = new ArrayList<>();
			List<Phongban> danhsachphongban = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
			for (Phongban phongban : danhsachphongban) {
				for (Users users : TatcaNhanVien) {
					if (phongban.getId() == users.getPhongban_id()) {
						userListtheothutuphong.add(users);
					}
				}
			}

			double TongdiemOfThang = TinhDiemToiDaOfThang(thang, nam);
			for (Users MoiThanhVienPhong : userListtheothutuphong) {
				Map<String, Object> XuatbaoCao1111111 = new HashMap<>();
				List<Map<String, Object>> danhSachNgayTrongThangMoi = laydulieugiolamofmotnhanvien(keymonth, keyyear,
						MoiThanhVienPhong.getUserId());
				double TongdiemHanThang1ThanhVien = 0.0;
				for (Map<String, Object> map : danhSachNgayTrongThangMoi) {
					if (map == null) {
						TongdiemHanThang1ThanhVien += 0.0;

					} else {
						double diemkhacnull = (double) map.get("diem");
						TongdiemHanThang1ThanhVien += diemkhacnull;

					}

				}
				double xeploai = TongdiemHanThang1ThanhVien / TongdiemOfThang * 100;
				xeploai = Math.round(xeploai * 100.0) / 100.0;
				String xeploaiChu = "";
				if (xeploai >= 85.00) {
					xeploaiChu = "A";
				} else if (xeploai >= 70.00 && xeploai < 85.00) {
					xeploaiChu = "B";
				} else if (xeploai >= 50.00 && xeploai < 70.00) {
					xeploaiChu = "C";
				} else if (xeploai < 50.00) {
					xeploaiChu = "D";
				}
				String tenphongbaocao = LaytenPhongquaUserId((long) MoiThanhVienPhong.getUserId());

				XuatbaoCao1111111.put("hovaten", MoiThanhVienPhong.getHovaten());
				XuatbaoCao1111111.put("tenphong", tenphongbaocao);
				XuatbaoCao1111111.put("diemchamcong", String.valueOf(TongdiemHanThang1ThanhVien));
				XuatbaoCao1111111.put("xeploai", xeploaiChu);
				ListXuatBao.add(XuatbaoCao1111111);
			}
		} else if (quyenxuatBaoCao == 2) {
			// xử lý trưởng phòng khác

			List<Users> ThanhvienPhong = UsersLocalServiceUtil.getNhanVienPhongBan(userBaoCao.getPhongban_id());
			int mothInt = Integer.parseInt(month);
			int yearInt = Integer.parseInt(year);

			double TongdiemOfThang = TinhDiemToiDaOfThang(thang, nam);
			for (Users MoiThanhVienPhong : ThanhvienPhong) {
				Map<String, Object> XuatbaoCao1111111 = new HashMap<>();
				List<Map<String, Object>> danhSachNgayTrongThangMoi = laydulieugiolamofmotnhanvien(keymonth, keyyear,
						MoiThanhVienPhong.getUserId());
				double TongdiemHanThang1ThanhVien = 0.0;
				for (Map<String, Object> map : danhSachNgayTrongThangMoi) {
					if (map == null) {

						TongdiemHanThang1ThanhVien += 0.0;

					} else {
						double diemkhacnull = (double) map.get("diem");
						System.out.println("TongdiemOfThang xu mappp bao cao khac nullll ===== " + diemkhacnull);
						TongdiemHanThang1ThanhVien += diemkhacnull;
					}

				}
				double xeploai = TongdiemHanThang1ThanhVien / TongdiemOfThang * 100;
				xeploai = Math.round(xeploai * 100.0) / 100.0;
				String xeploaiChu = "";
				if (xeploai >= 85.00) {
					xeploaiChu = "A";
				} else if (xeploai >= 70.00 && xeploai < 85.00) {
					xeploaiChu = "B";
				} else if (xeploai >= 50.00 && xeploai < 70.00) {
					xeploaiChu = "C";
				} else if (xeploai < 50.00) {
					xeploaiChu = "D";
				}
				String tenphongbaocao = LaytenPhongquaUserId((long) MoiThanhVienPhong.getUserId());
				XuatbaoCao1111111.put("hovaten", MoiThanhVienPhong.getHovaten());
				XuatbaoCao1111111.put("tenphong", tenphongbaocao);
				XuatbaoCao1111111.put("diemchamcong", String.valueOf(TongdiemHanThang1ThanhVien));
				XuatbaoCao1111111.put("xeploai", xeploaiChu);
				ListXuatBao.add(XuatbaoCao1111111);
			}

		} else if (quyenxuatBaoCao == 3) {
			double TongdiemOfThang = TinhDiemToiDaOfThang(thang, nam);

			// lấy tổng điểm của 1 nhân viên
			List<Map<String, Object>> danhSachNgayTrongThangMoi = laydulieugiolamofmotnhanvien(keymonth, keyyear,
					userId);
			double TongdiemHanThang1ThanhVien = 0;
			for (Map<String, Object> map : danhSachNgayTrongThangMoi) {
				if (map == null) {
					TongdiemHanThang1ThanhVien += 0;
				} else {
					TongdiemHanThang1ThanhVien += (Double) map.get("diem");
				}

			}

			double xeploai = TongdiemHanThang1ThanhVien / TongdiemOfThang * 100;
			xeploai = Math.round(xeploai * 100.0) / 100.0;
			// System.out.println("xeploai " + xeploai);
			String xeploaiChu = "";
			if (xeploai >= 85.00) {
				xeploaiChu = "A";
			} else if (xeploai >= 70.00 && xeploai < 85.00) {
				xeploaiChu = "B";
			} else if (xeploai >= 50.00 && xeploai < 70.00) {
				xeploaiChu = "C";
			} else if (xeploai < 50.00) {
				xeploaiChu = "D";
			}
			String tenphongbaocao = LaytenPhongquaUserId(userId);
			XuatbaoCao.put("hovaten", userBaoCao.getHovaten());
			XuatbaoCao.put("tenphong", tenphongbaocao);
			XuatbaoCao.put("diemchamcong", String.valueOf(TongdiemHanThang1ThanhVien));
			XuatbaoCao.put("xeploai", xeploaiChu);
			ListXuatBao.add(XuatbaoCao);
		}

		String NameSheet = "";
		String hovatentv = "";
		String phongbantv = "";
		String diemchamcongtv = "";
		String xeploaitv = "";
		try {
			Tutiengviet p1 = TutiengvietLocalServiceUtil.getTutiengviet(1);
			NameSheet = p1.getTu_tieng_viet();
			Tutiengviet p2 = TutiengvietLocalServiceUtil.getTutiengviet(2);
			hovatentv = p2.getTu_tieng_viet();
			Tutiengviet p3 = TutiengvietLocalServiceUtil.getTutiengviet(3);
			phongbantv = p3.getTu_tieng_viet();
			Tutiengviet p4 = TutiengvietLocalServiceUtil.getTutiengviet(4);
			diemchamcongtv = p4.getTu_tieng_viet();
			Tutiengviet p5 = TutiengvietLocalServiceUtil.getTutiengviet(5);
			xeploaitv = p5.getTu_tieng_viet();

		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Khởi tạo workbook và tạo một sheet mới
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(NameSheet);

		// Tạo font chữ hỗ trợ tiếng Việt
		HSSFFont font = workbook.createFont();
		font.setFontName("Times New Roman"); // Đổi sang font hỗ trợ tiếng Việt tốt hơn
		font.setFontHeightInPoints((short) 12);

		// Tạo cell style và gán font chữ
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);

		// Tạo hàng header và áp dụng style cho từng cell
		HSSFRow headerRow = sheet.createRow(0);

		Cell cell0 = headerRow.createCell(0);
		cell0.setCellValue("STT");
		cell0.setCellStyle(style);

		Cell cell1 = headerRow.createCell(1);
		cell1.setCellValue(hovatentv);
		cell1.setCellStyle(style);

		Cell cell2 = headerRow.createCell(2);
		cell2.setCellValue(phongbantv);
		cell2.setCellStyle(style);

		Cell cell3 = headerRow.createCell(3);
		cell3.setCellValue(diemchamcongtv);
		cell3.setCellStyle(style);

		Cell cell4 = headerRow.createCell(4);
		cell4.setCellValue(xeploaitv);
		cell4.setCellStyle(style);

//		Cell cell5 = headerRow.createCell(5);
//		cell5.setCellValue("Xep Loai Phong");
//		cell5.setCellStyle(style);
		// Thêm các cột khác nếu cần

		HSSFCellStyle headerCellStyle = workbook.createCellStyle();

		// Tạo một font mới và thiết lập font chữ và màu
		HSSFFont headerFont = workbook.createFont();
		headerFont.setFontName("Times New Roman");
		headerFont.setFontHeightInPoints((short) 12);
		// headerFont.setColor(IndexedColors.ORANGE.getIndex());
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD); // hoặc headerFont.setBold(true);
		// thêm chữ màu xanh nhạt đậm
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor customColor = palette.findSimilarColor(54, 185, 204);
		short customColorIndex = customColor.getIndex();
		headerFont.setColor(customColorIndex);
		// Áp dụng font vào CellStyle
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // Căn giữa theo chiều ngang
		headerCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // Căn giữa theo chiều dọc

		// Thiết lập Wrap Text cho CellStyle
		headerCellStyle.setWrapText(true);

		String[] headers = { "STT", hovatentv, phongbantv, diemchamcongtv, xeploaitv };

		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Tự động điều chỉnh độ rộng cột theo nội dung
		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Áp dụng CellStyle vào các ô trong hàng header
		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
			headerRow.getCell(i).setCellStyle(headerCellStyle);
		}

		// Đặt lại CellStyle để không có màu nền cho dữ liệu
		HSSFCellStyle dataCellStyle = workbook.createCellStyle();
		dataCellStyle.setFont(font);
		dataCellStyle.setWrapText(true);
		dataCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dataCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// Lặp qua danh sách pets và tạo hàng cho mỗi pet
		int rowNum = 1; // Bắt đầu từ hàng thứ nhất, vì hàng đầu tiên đã là header
		int counter = 1;
		for (Map<String, Object> xuatBao : ListXuatBao) {
			String hoVaTen = (String) xuatBao.get("hovaten");
			String tenphong = (String) xuatBao.get("tenphong");
			String xeploai = (String) xuatBao.get("xeploai");
			String diemchamcong = (String) xuatBao.get("diemchamcong");
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(counter++); // Ghi số thứ tự
			row.createCell(1).setCellValue(hoVaTen);
			row.createCell(2).setCellValue(tenphong);
			row.createCell(3).setCellValue(diemchamcong);
			row.createCell(4).setCellValue(xeploai);
			// Áp dụng style cho các ô trong hàng
			for (int i = 0; i < 5; i++) {
				row.getCell(i).setCellStyle(dataCellStyle);
			}
		}
		// Tự động điều chỉnh độ rộng cột theo nội dung
		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}
		long timestamp = System.currentTimeMillis();
		String tenfile = "BaoCao - " + Long.toString(timestamp);
		String baseFilePath = "D:\\AppTimekeeping\\liferay-ce-portal-7.4.3.42-ga42\\excel\\";
		String extension = ".xls";
		String filename = baseFilePath + tenfile + extension;
		try (FileOutputStream fileOut = new FileOutputStream(filename)) {
			workbook.write(fileOut);
			System.out.println("Excel file has been generated successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// lấy file từ server về và download về có tên là pet5555555s
		String baseFilePathServer = "D:\\AppTimekeeping\\liferay-ce-portal-7.4.3.42-ga42\\excel\\";
		String filePath = baseFilePathServer + tenfile + extension;
		File file = new File(filePath);

		// Kiểm tra nếu file tồn tại
		if (!file.exists()) {
			throw new IOException("File not found: " + filePath);
		}

		// Thiết lập phản hồi HTTP để tải xuống file
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		httpResponse.setContentType("application/vnd.ms-excel");
		httpResponse.setHeader("Content-Disposition", "attachment; filename=" + tenfile + extension);
		httpResponse.setContentLength((int) file.length());

		// Ghi nội dung file vào phản hồi HTTP
		try (FileInputStream inputStream = new FileInputStream(file);
				OutputStream outputStream = httpResponse.getOutputStream()) {
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/home");
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// Lấy UserId
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);

		System.out.println("userId****** " + userId);
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		// System.out.println("user ------ " + user);
		// check quyền user

		// hàm check có phải trưởng phòng ko ???
		int quyenxemgiolam = checkQuyenTruongPhong(user);
		// System.out.println("quyenxemgiolam ----- )))) " + quyenxemgiolam);
		renderRequest.setAttribute("quyenxemgiolam", quyenxemgiolam);
		// System.out.println("user****** " + user);
		// XỬ LÝ NÚT CHẤM CÔNG ///
		// Lấy ca làm việc lưu trong db
		List<Calamviec> calamviecList = CalamviecLocalServiceUtil.getCalamviecs(-1, 1);
		Calamviec calamviec = calamviecList.get(0);
		String giovaosang = calamviec.getGio_vao_sang();
		int thoigianvaosomsang = calamviec.getVao_truoc_sang();
		String giorasang = calamviec.getGio_ra_sang();
		int thoigianramuonsang = calamviec.getRa_sau_sang();
		String giovaochieu = calamviec.getGio_vao_chieu();
		int thoigianvaosomchieu = calamviec.getVao_truoc_chieu();
		String giorachieu = calamviec.getGio_ra_chieu();
		int thoigianramuonchieu = calamviec.getRa_sau_chieu();
		// Lấy khung giờ làm việc buổi sáng
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		// Thực hiện h vào sáng
		LocalTime gioVaoSang = LocalTime.parse(giovaosang, formatter);
		LocalTime gioChamCongVaoSangFormatted = gioVaoSang.minusMinutes(thoigianvaosomsang);
		// String gioChamCongVaoSangFormatted11 =
		// gioChamCongVaoSangFormatted.format(formatter); // chuyển sang String
		// thực hiện giờ ra sáng
		LocalTime gioRaSang = LocalTime.parse(giorasang, formatter);
		LocalTime gioChamCongRaSangFormatted = gioRaSang.plusMinutes(thoigianramuonsang);
		// thực hiện giờ vào chiều
		LocalTime gioVaoChieu = LocalTime.parse(giovaochieu, formatter);
		LocalTime gioChamCongVaoChieuFormatted = gioVaoChieu.minusMinutes(thoigianvaosomchieu);
		// thực hiện giờ ra chiều
		LocalTime gioRaChieu = LocalTime.parse(giorachieu, formatter);
		LocalTime gioChamCongRaChieuFormatted = gioRaChieu.plusMinutes(thoigianramuonchieu);
		LocalTime currentTime = LocalTime.now(zoneId);
		String gioHienTai = currentTime.format(formatter);
		LocalTime gioHienTaiDate = LocalTime.parse(gioHienTai, DateTimeFormatter.ofPattern("HH:mm"));
		// check gio hiẹn tại nằm trong khoảng nào
		boolean GioHienTaiTrongBuoiSang = gioHienTaiDate.isAfter(gioChamCongVaoSangFormatted)
				&& gioHienTaiDate.isBefore(gioChamCongRaSangFormatted);
		// check gio hiẹn tại nằm trong khoảng nào
		boolean GioHienTaiTrongBuoiChieu = gioHienTaiDate.isAfter(gioChamCongVaoChieuFormatted)
				&& gioHienTaiDate.isBefore(gioChamCongRaChieuFormatted);

		try {
			GioLam userGioLam = GioLamLocalServiceUtil.getGioLamByUserId(userId, dateNgayHienTai);
			if (userGioLam == null) {
				// Nếu vào buổi sáng thì
				if (GioHienTaiTrongBuoiSang == true) {
					renderRequest.setAttribute("Chamcongsang", GioHienTaiTrongBuoiSang);
				} else if (GioHienTaiTrongBuoiChieu == true) {
					renderRequest.setAttribute("Chamcongchieu", GioHienTaiTrongBuoiChieu);
				} else {
					renderRequest.setAttribute("khongchamcong", true);

				}
			} else {
				if (GioHienTaiTrongBuoiSang == true) {
					String checkinSang = userGioLam.getCheck_in_sang();
					String checkoutSang = userGioLam.getCheck_out_sang();
					if (checkinSang.equals("") == false && checkoutSang.equals("") == false) {
						renderRequest.setAttribute("khongchamcong", true);
					} else if (checkinSang.equals("") == false) {
						// System.out.println("da cham cong vao sang nhung chua cham cong ra ra
						// --------------------- ");
						renderRequest.setAttribute("Chamcongrasang", true);
					} else if (checkoutSang.equals("") == false) {
						renderRequest.setAttribute("khongchamcong", true);
					}

				} else if (GioHienTaiTrongBuoiChieu == true) {
					String checkinchieu = userGioLam.getCheck_in_chieu();
					String checkinSang = userGioLam.getCheck_in_sang();
					String checkoutSang = userGioLam.getCheck_out_sang();
					String checkoutchieu = userGioLam.getCheck_out_chieu();
					if (!checkoutchieu.equals("")) {
						renderRequest.setAttribute("khongchamcong", true);
					} else if (checkinSang.equals("") == false && checkoutSang.equals("") == false
							&& checkinchieu.equals("") == false) {
						// System.out.println("da cham cong sang nhưng chưa cham cong chieu");
						renderRequest.setAttribute("Chamcongrachieu", true);
					} else if (checkinSang.equals("") == false && checkoutSang.equals("") == false) {
						// System.out.println("da cham cong sang nhưng chưa cham cong chieu");
						renderRequest.setAttribute("Chamcongchieu", GioHienTaiTrongBuoiChieu);
					} else if (checkinSang.equals("") == false) {
						// trường hợp chấm công nhiều thường xuyên
						Boolean Chamcongrachieu = true;
						renderRequest.setAttribute("Chamcongrachieu", Chamcongrachieu);
					} else {
						// System.out.println("da cham cong chieu nhung chua cham cong ra chieu");
						Boolean Chamcongrachieu = true;
						renderRequest.setAttribute("Chamcongrachieu", Chamcongrachieu);
					}

				} else {
					renderRequest.setAttribute("khongchamcong", true);

				}

			}

		} catch (PortalException e1) {
			e1.printStackTrace();
		}

		// KẾT THÚC NÚT CHẤM CÔNG

		// BẮT ĐẦU HIỂN THỊ GIỜ LÀM

		// Lấy tháng và năm

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
		List<Map<String, Object>> danhSachNgayTrongThangMoi = laydulieugiolamofmotnhanvien(keymonth, keyyear, userId);

		// Tính Tổng điểm hàng tháng

		double TongdiemOfThang = 0;
		double TongdiemHanThang1ThanhVien = 0;

		for (Map<String, Object> map : danhSachNgayTrongThangMoi) {
			if (map == null) {
				TongdiemHanThang1ThanhVien += 0;
			} else {
				TongdiemHanThang1ThanhVien += (Double) map.get("diem");
			}

		}
		// Tổng điểm tối đa hàng tháng

		int thang = Integer.parseInt(keymonth);
		int nam = Integer.parseInt(keyyear);
		TongdiemOfThang = TinhDiemToiDaOfThang(thang, nam);
		// Xếp Loại
		double xeploai = TongdiemHanThang1ThanhVien / TongdiemOfThang * 100;
		xeploai = Math.round(xeploai * 100.0) / 100.0;
		// System.out.println("xeploai " + xeploai);
		int xeploaiChu = 0;
		if (xeploai >= 85.00) {
			xeploaiChu = 1;
		} else if (xeploai >= 70.00 && xeploai < 85.00) {
			xeploaiChu = 2;
		} else if (xeploai >= 50.00 && xeploai < 70.00) {
			xeploaiChu = 3;
		} else if (xeploai < 50.00) {
			xeploaiChu = 4;
		}

		// System.out.println("xeploaiChu "+ xeploaiChu);

		renderRequest.setAttribute("TongdiemHanThangMotThanhVien", TongdiemHanThang1ThanhVien);
		renderRequest.setAttribute("TongdiemOfThang", TongdiemOfThang);
		renderRequest.setAttribute("xeploaiChu", xeploaiChu);
		renderRequest.setAttribute("xeploaiphantram", xeploai);
		renderRequest.setAttribute("danhSachNgayTrongThang", danhSachNgayTrongThangMoi);
		List<List<Map<String, Object>>> danhSachNgayTrongThangcaPhong = new ArrayList<>();
		if (quyenxemgiolam == 1) {
			// Xử lý hiện thị cho trưởng phòng hành chính và phụ trách phòng hành chính và
			List<Users> TatCaNhanVien = UsersLocalServiceUtil.getUserses(-1, -1);
			int mothInt = Integer.parseInt(month);
			int yearInt = Integer.parseInt(year);
			int daysInMonth = getDaysInMonth(mothInt, yearInt);
			List<String> ListThang = new ArrayList<>(daysInMonth);
			for (int i = 1; i <= daysInMonth; i++) {
				String s = String.valueOf(i);
				ListThang.add(s);

			}

			renderRequest.setAttribute("ListThang", ListThang);
			for (Users tungthanhvien : TatCaNhanVien) {
				List<Map<String, Object>> danhSachNgayTrongThangTungThanvien = laydulieugiolamofmotnhanvien(keymonth,
						keyyear, tungthanhvien.getUserId());
				danhSachNgayTrongThangcaPhong.add(danhSachNgayTrongThangTungThanvien);

			}
            System.out.println("danhSachNgayTrongThangcaPhong ------ "+ danhSachNgayTrongThangcaPhong);
			renderRequest.setAttribute("danhSachNgayTrongThangcaPhong", danhSachNgayTrongThangcaPhong);

		} else if (quyenxemgiolam == 2) {
			// xử lý trưởng phòng khác
			List<Users> ThanhvienPhong = UsersLocalServiceUtil.getNhanVienPhongBan(user.getPhongban_id());
			int mothInt = Integer.parseInt(month);
			int yearInt = Integer.parseInt(year);
			int daysInMonth = getDaysInMonth(mothInt, yearInt);
			List<String> ListThang = new ArrayList<>(daysInMonth);
			for (int i = 1; i <= daysInMonth; i++) {
				String s = String.valueOf(i);
				ListThang.add(s);

			}

			renderRequest.setAttribute("ListThang", ListThang);
			for (Users tungthanhvien : ThanhvienPhong) {
				List<Map<String, Object>> danhSachNgayTrongThangTungThanvien = laydulieugiolamofmotnhanvien(keymonth,
						keyyear, tungthanhvien.getUserId());
				danhSachNgayTrongThangcaPhong.add(danhSachNgayTrongThangTungThanvien);

			}

			renderRequest.setAttribute("danhSachNgayTrongThangcaPhong", danhSachNgayTrongThangcaPhong);

		} else if (quyenxemgiolam == 3) {

		}

		super.render(renderRequest, renderResponse);
	}

	public List<Map<String, Object>> laydulieugiolamofmotnhanvien(String keymonth, String keyyear, long userId) {
		// xử lý giờ làm của 1 người

		List<GioLam> GioLamByUserIdYearAndMonthList = GioLamLocalServiceUtil.getGioLamByYearAndMonth(keymonth, keyyear,
				userId);
		int mothInt = Integer.parseInt(month);
		int yearInt = Integer.parseInt(year);
		int daysInMonth = getDaysInMonth(mothInt, yearInt);

		// LocalDate ngayDauTienCuaThang = ngayHienTai.withDayOfMonth(1);
		LocalDate ngayDauTienCuaThang = LocalDate.of(yearInt, mothInt, 1);
		DayOfWeek thuMay = ngayDauTienCuaThang.getDayOfWeek();
		// System.out.println("thuMay --+++---++++ "+ thuMay);
		List<GioLam> monthList = new ArrayList<>(daysInMonth);
		for (int i = 1; i <= daysInMonth; i++) {
			int ngay = 0;
			LocalDate ngay_lamchuacos = LocalDate.of(yearInt, mothInt, i);
			Date ngay_lamchuacoDate = Date.from(ngay_lamchuacos.atStartOfDay(ZoneId.systemDefault()).toInstant());
			int idGioLamnew = (int) CounterLocalServiceUtil.increment();
			GioLam gioLamChuan = GioLamLocalServiceUtil.createGioLam(idGioLamnew);
			gioLamChuan.setUser_id(userId);
			gioLamChuan.setNgay_lam(ngay_lamchuacoDate);

			for (GioLam gioLam : GioLamByUserIdYearAndMonthList) {
				Date ngay_lam = gioLam.getNgay_lam();
				Instant instant = ngay_lam.toInstant();
				LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

				if (localDate.getDayOfMonth() == i) {
					gioLamChuan = gioLam;
					ngay = localDate.getDayOfMonth();
				}
			}
			;

			if (ngay == i) {
				monthList.add(gioLamChuan);
			} else {
				monthList.add(gioLamChuan);
			}

		}
		 
		System.out.println("monthList -------************ " + monthList);
		List<Map<String, Object>> newgioLamMapListNhanVien = new ArrayList<>();
		for (GioLam x : monthList) {
			Map<String, Object> gioLamMap = new HashMap<>();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(x.getNgay_lam());
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			boolean CoPhaiNgayNghileKo = CoPhaiNgayNghiKo(x.getNgay_lam());
			boolean CoPhaiThu7orChuNhatKo = CoPhaiThu7orChuNhat(x.getNgay_lam());
			int DateTruocSauNgayHienTai = DateTruocSau(x.getNgay_lam());
			int trangthaicasang = checkDataCaSang(x.getCheck_in_sang(), x.getCheck_out_sang(), x.getDi_muon_sang(),
					x.getVe_som_sang(), x.getCheck_in_chieu(), x.getCheck_out_chieu(), x.getDi_muon_chieu(),
					x.getVe_som_chieu(), DateTruocSauNgayHienTai);
			int trangthaicachieu = checkDataCaChieu(x.getCheck_in_sang(), x.getCheck_out_sang(), x.getDi_muon_sang(),
					x.getVe_som_sang(), x.getCheck_in_chieu(), x.getCheck_out_chieu(), x.getDi_muon_chieu(),
					x.getVe_som_chieu(), DateTruocSauNgayHienTai);
			Users users = UsersLocalServiceUtil.getUserbyUserId(x.getUser_id());
			String ho_va_ten = users.getHovaten();

			// Lấy điểm của thành viên

			double diem = TinhDiemcuaMotNhanVienOfMotNgay(x.getUser_id(), x.getNgay_lam());
			
			// lấy tổng điểm của cả tháng tính đến ngày hiện tại
 
			double tongdiemofthangdenhientai = TinhTongDiemCaThangdenHomnay(x.getUser_id(),mothInt , yearInt);
			

			
			
			
			if (x == null) {
				System.out.println("khong vao dc" + x);
//							gioLamMap.put("ngay_lam", x.getNgay_lam());
//			            	gioLamMap.put("ho_va_ten", ho_va_ten);
//							gioLamMap.put("ngay_lam_trongthang", dayOfMonth);
//							gioLamMap.put("cophaingayNghi", CoPhaiNgayNghileKo);
//							gioLamMap.put("CoPhaiThu7orChuNhat", CoPhaiThu7orChuNhatKo);
//						    gioLamMap.put("ngaytrcNgayHienTaiKo", DateTruocSauNgayHienTai); // trường hợp để giới hạn những ngày

//							gioLamMap.put("calamsang", trangthaicasang);
//							gioLamMap.put("calamchieu", trangthaicachieu);
//							gioLamMap.put("checkinsang", x.getCheck_in_sang());
//							gioLamMap.put("checkoutsang", x.getCheck_out_sang());
//							gioLamMap.put("checkinchieu", x.getCheck_in_chieu());
//							gioLamMap.put("checkoutchieu", x.getCheck_out_chieu());
//				newgioLamMapListNhanVien.add(null);
			} else {
				gioLamMap.put("user_id", x.getUser_id());
				gioLamMap.put("ho_va_ten", ho_va_ten);
				gioLamMap.put("ngay_lam_trongthang", dayOfMonth);
				gioLamMap.put("cophaingayNghi", CoPhaiNgayNghileKo);
				gioLamMap.put("CoPhaiThu7orChuNhat", CoPhaiThu7orChuNhatKo);
				gioLamMap.put("ngaytrcNgayHienTaiKo", DateTruocSauNgayHienTai); // trường hợp để giới hạn những ngày
																				// ngày đã chấm công
				gioLamMap.put("calamsang", trangthaicasang);
				gioLamMap.put("calamchieu", trangthaicachieu);
				gioLamMap.put("checkinsang", x.getCheck_in_sang());
				gioLamMap.put("checkoutsang", x.getCheck_out_sang());
				gioLamMap.put("checkinchieu", x.getCheck_in_chieu());
				gioLamMap.put("checkoutchieu", x.getCheck_out_chieu());
				gioLamMap.put("diem", diem);
				gioLamMap.put("diemcuathang", tongdiemofthangdenhientai);
				newgioLamMapListNhanVien.add(gioLamMap);
			}
		}

	//	System.out.println("newgioLamMapListNhanVien " + newgioLamMapListNhanVien);

		int ngaydautien = 0;
		if (thuMay == DayOfWeek.MONDAY) {
			ngaydautien = 2;
		} else if (thuMay == DayOfWeek.TUESDAY) {
			ngaydautien = 3;
		} else if (thuMay == DayOfWeek.WEDNESDAY) {
			ngaydautien = 4;
		} else if (thuMay == DayOfWeek.THURSDAY) {
			ngaydautien = 5;
		} else if (thuMay == DayOfWeek.FRIDAY) {
			ngaydautien = 6;
		} else if (thuMay == DayOfWeek.SATURDAY) {
			ngaydautien = 7;
		} else if (thuMay == DayOfWeek.SUNDAY) {
			ngaydautien = 8;
		}
		// System.out.println("ngaydautien ----------------- "+ ngaydautien);
		int soLuongNull = ngaydautien - 2;

		List<Map<String, Object>> danhSachNgayTrongThangMoi = new ArrayList<>();
		for (int i = 0; i < soLuongNull; i++) {
			danhSachNgayTrongThangMoi.add(null);
			// System.out.println("da vao dc day ------ ");
		}
		danhSachNgayTrongThangMoi.addAll(newgioLamMapListNhanVien);
		//System.out.println("danhSachNgayTrongThang ----++++++++++++++ " + danhSachNgayTrongThangMoi);
		return danhSachNgayTrongThangMoi;
		
	}

	// Hàm lấy số ngày của 1 tháng
	public static int getDaysInMonth(int month, int year) {
		YearMonth yearMonth = YearMonth.of(year, month);
		return yearMonth.lengthOfMonth();
	}

	// Hàm check ngày có phải ngày nghỉ ko

	public static boolean CoPhaiNgayNghiKo(Date ngay_lam) {
		LocalDate localDatengay_lam = ngay_lam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		boolean isSameDay = false;
		List<Ngaynghile> ListNgayNghiLe = NgaynghileLocalServiceUtil.getNgaynghiles(-1, -1);
		for (Ngaynghile ngaynghile : ListNgayNghiLe) {
			LocalDate localDatengaynghile = ngaynghile.getNgay_nghi().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			if ((localDatengaynghile.getDayOfMonth() == localDatengay_lam.getDayOfMonth())
					&& (localDatengaynghile.getMonth() == localDatengay_lam.getMonth())
					&& (localDatengaynghile.getYear() == localDatengay_lam.getYear())) {
				isSameDay = true;
			} else {
				isSameDay = isSameDay;
			}

		}

		return isSameDay;
	}

	// Hàm check ngày đã này thuộc ngày trc hay sau ngày hiện tại ; Trước ngày hiện
	// tại trả về 1 ; Sau ngày hiện tại trả về 2, ngay hien tại tra ve 3

	public int DateTruocSau(Date ngay_lam) {
		int isDateTruocSau = 0;

		LocalDate localDatengay_lam = ngay_lam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		if (localDatengay_lam.isBefore(currentDate)) {
			isDateTruocSau = 1;
		} else if (localDatengay_lam.isAfter(currentDate)) {
			isDateTruocSau = 2;
		} else {
			isDateTruocSau = 3;
		}

		return isDateTruocSau;
	}

	// Ham check ngày có phải ngày hiện đ

	// Hàm check trang thái casang
	public int checkDataCaSang(String checkinsang, String checkoutsang, int dimuonsang, int vesomsang,
			String checkinchieu, String checkoutchieu, int dimuonchieu, int vesomchieu, int trangthaingay) {
		int DataCaSang = 0;
		boolean inSang = checkinsang.equals("");
		boolean outSang = checkoutsang.equals("");
		boolean inChieu = checkinchieu.equals("");
		boolean outChieu = checkoutchieu.equals("");

		if (trangthaingay == 3) {
			if (dimuonsang <= 0 && vesomsang <= 0 && (inSang == false) && (outSang == false)) {
				// trường hợp đi làm đúng giờ
				DataCaSang = 1;
			} else if (dimuonsang > 0 && inSang == false && outSang == true
					&& ((inChieu == true && outChieu == true))) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaSang = 3;
			} else if ((inSang == false) && dimuonsang <= 0 && (inChieu == false || outChieu == false)) {
				// ttrường hợp ca sáng ko chấm công vào ra
				DataCaSang = 2;
			} else if ((inSang == false) && dimuonsang <= 0) {
				// trường hợp đi làm đúng giờ
				DataCaSang = 1;
			} else if (inSang == true && outSang == true && ((inChieu == true && outChieu == true))) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaSang = 2;
			} else if ((inSang == false && outSang == true) || (inSang == true && outSang == false)) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaSang = 2;
			} else if (dimuonsang > 0 || vesomsang > 0) {
				// trường hợp ca sáng đi muộn về sớm
				DataCaSang = 3;
			} else if ((inSang == true && outSang == true)) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaSang = 4;
			}
		} else if (trangthaingay == 1) {
			if (dimuonsang <= 0 && vesomsang <= 0 && (inSang == false) && (outSang == false)) {
				// trường hợp đi làm đúng giờ
				DataCaSang = 1;
			} else if (inSang == false && outSang == true && inChieu == true & outChieu == false && dimuonsang <= 0
					&& vesomchieu <= 0) {
				// trường hợp đi làm đúng giờ
				DataCaSang = 1;
			} else if (inSang == true && outSang == true) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaSang = 4;
			} else if ((inSang == false && outSang == true && (dimuonsang > 0 || vesomsang > 0))) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaSang = 3;
			} else if ((inSang == true && outSang == false) || (inSang == false && outSang == true)) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaSang = 2;
			} else if (dimuonsang > 0 || vesomsang > 0) {
				// trường hợp ca sáng đi muộn về sớm
				DataCaSang = 3;
			}

		} else if (trangthaingay == 2) {
			DataCaSang = 0; // trường hợp chưa có dữ liệu
		}

		return DataCaSang;
	}

	// Hàm check trang thái ca chieu
	public int checkDataCaChieu(String checkinsang, String checkoutsang, int dimuonsang, int vesomsang,
			String checkinchieu, String checkoutchieu, int dimuonchieu, int vesomchieu, int trangthaingay) {
		int DataCaChieu = 0;
		boolean inSang = checkinsang.equals("");
		boolean outSang = checkoutsang.equals("");
		boolean inChieu = checkinchieu.equals("");
		boolean outChieu = checkoutchieu.equals("");

		if (trangthaingay == 3) {
			if (dimuonchieu <= 0 && vesomchieu <= 0 && (inChieu == false) && (outChieu == false)) {
				// trường hợp đi làm đúng giờ
				DataCaChieu = 1;
			} else if ((inSang == false && outSang == false) && inChieu == true && outChieu == true) {
				DataCaChieu = 2;
			} else if ((dimuonchieu > 0 || vesomchieu > 0) && (inChieu == false) && (outChieu == true)) {
				DataCaChieu = 3;
			} else if ((inChieu == false) && dimuonchieu <= 0 && (inSang == false || outSang == false)) {
				// ttrường hợp ca chiều ko chấm công vào ra
				DataCaChieu = 2;
			} else if (dimuonchieu >= 0 && (inSang == false && outSang == true) && inChieu == true
					&& outChieu == true) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaChieu = 2;
			} else if ((inSang == true && outSang == true) && inChieu == true && outChieu == true) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaChieu = 2;
			} else if ((inSang == false) && dimuonsang <= 0 && (inChieu == true)) {
				// ttrường hợp ca chiều ko chấm công vào ra
				DataCaChieu = 2;
			} else if (inChieu == false && outChieu == true) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaChieu = 2;
			} else if (inChieu == false && outChieu == false) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaChieu = 2;
			} else if ((dimuonsang > 0 && vesomsang > 0)) {
				// trường hợp ca sáng đi muộn về sớm
				DataCaChieu = 2;
			} else if ((inSang == true && outSang == true)) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaChieu = 4;
			}
		} else if (trangthaingay == 1) {

			if (dimuonchieu <= 0 && vesomchieu <= 0 && (inChieu == false) && (outChieu == false)) {
				// trường hợp đi làm đúng giờ
				DataCaChieu = 1;
			} else if (inSang == false && outSang == true && inChieu == true & outChieu == false
					&& (dimuonsang <= 0 || dimuonsang > 0) && vesomchieu <= 0) {
				// trường hợp đi làm đúng giờ
				DataCaChieu = 1;
			} else if (inChieu == true && outChieu == true) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaChieu = 4;
			} else if ((inChieu == true && outChieu == false) || (inChieu == true && outChieu == false)) {
				// trường hợp ca sáng ko chấm công vào ra
				DataCaChieu = 2;
			} else if (dimuonchieu > 0 || vesomchieu > 0) {
				// trường hợp ca sáng đi muộn về sớm
				DataCaChieu = 3;
			}

		} else if (trangthaingay == 2) {
			DataCaChieu = 0; // trường hợp chưa có dữ liệu
		}

		return DataCaChieu;
	}

	// Hàm check có phải trưởng phòng ko ???
	// Hàm lấy số ngày của 1 tháng
	public int checkQuyenTruongPhong(Users user) {
		long chucvu_id = user.getChucvu_id();
		long phongban_id = user.getPhongban_id();
		long phu_trach_phong = user.getPhu_trach_phong();
//		System.out.println(" chucvu_id " + chucvu_id);
//		System.out.println(" phongban_id " + phongban_id);
//		System.out.println(" phu_trach_phong " + phu_trach_phong);
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

	// Hàm tính điểm của 1 nhân viên của 1 ngày
	public double TinhDiemcuaMotNhanVienOfMotNgay(long user_id, Date ngay_lam) {

		double tongdiem1ngay = 0;
		try {
			GioLam NgaycanTinhDiem = GioLamLocalServiceUtil.getGioLamByUserId(user_id, ngay_lam);

			if (NgaycanTinhDiem != null) {
				String checkinsang = NgaycanTinhDiem.getCheck_in_sang();
				String checkoutsang = NgaycanTinhDiem.getCheck_out_sang();
				String checkinchieu = NgaycanTinhDiem.getCheck_in_chieu();
				String checkoutchieu = NgaycanTinhDiem.getCheck_out_chieu();
				int dimuonsang = NgaycanTinhDiem.getDi_muon_sang();
				int vesomsang = NgaycanTinhDiem.getVe_som_sang();
				int dimuonchieu = NgaycanTinhDiem.getDi_muon_chieu();
				int vesomchieu = NgaycanTinhDiem.getVe_som_chieu();
				double diemvaosang = 0;
				double diemrasang = 0;
				double diemvaochieu = 0;
				double diemrachieu = 0;

				if (!checkinsang.equals("") && !checkoutchieu.equals("")) {
					if (dimuonsang <= 1) {
						diemvaosang = 1;
					} else if (dimuonsang > 1 && dimuonsang < 10) {
						diemvaosang = 0.8;
					} else if (dimuonsang >= 10 && dimuonsang < 15) {
						diemvaosang = 0.6;
					} else if (dimuonsang >= 15 && dimuonsang < 20) {
						diemvaosang = 0.4;
					} else if (dimuonsang >= 20 && dimuonsang < 30) {
						diemvaosang = 0.2;
					} else {
						diemvaosang = 0.0;
					}
					diemrasang = 1;
					diemvaochieu = 1;
					if (vesomchieu <= 1) {
						diemrachieu = 1;
					} else if (vesomchieu > 1 && vesomchieu < 10) {
						diemrachieu = 0.8;
					} else if (vesomchieu >= 10 && vesomchieu < 15) {
						diemrachieu = 0.6;
					} else if (vesomchieu >= 15 && vesomchieu < 20) {
						diemrachieu = 0.4;
					} else if (vesomchieu >= 20 && vesomchieu < 30) {
						diemrachieu = 0.2;
					} else {
						diemrachieu = 0.0;
					}

				} else {

					if (!checkinsang.equals("") && checkoutsang.equals("")) {
						if (dimuonsang <= 1) {
							diemvaosang = 1;
						} else if (dimuonsang > 1 && dimuonsang < 10) {
							diemvaosang = 0.8;
						} else if (dimuonsang >= 10 && dimuonsang < 15) {
							diemvaosang = 0.6;
						} else if (dimuonsang >= 15 && dimuonsang < 20) {
							diemvaosang = 0.4;
						} else if (dimuonsang >= 20 && dimuonsang < 30) {
							diemvaosang = 0.2;
						} else {
							diemvaosang = 0.0;
						}

						diemrasang = 0.0;

					}
					if (!checkinsang.equals("") && !checkoutsang.equals("")) {
						if (dimuonsang <= 1) {
							diemvaosang = 1;
						} else if (dimuonsang > 1 && dimuonsang < 10) {
							diemvaosang = 0.8;
						} else if (dimuonsang >= 10 && dimuonsang < 15) {
							diemvaosang = 0.6;
						} else if (dimuonsang >= 15 && dimuonsang < 20) {
							diemvaosang = 0.4;
						} else if (dimuonsang >= 20 && dimuonsang < 30) {
							diemvaosang = 0.2;
						} else {
							diemvaosang = 0.0;
						}

						if (vesomsang <= 1) {
							diemrasang = 1;
						} else if (vesomsang > 1 && vesomsang < 10) {
							diemrasang = 0.8;
						} else if (vesomsang >= 10 && vesomsang < 15) {
							diemrasang = 0.6;
						} else if (vesomsang >= 15 && vesomsang < 20) {
							diemrasang = 0.4;
						} else if (vesomsang >= 20 && vesomsang < 30) {
							diemrasang = 0.2;
						} else {
							diemrasang = 0.0;
						}

					}

					if (!checkinchieu.equals("") && checkoutchieu.equals("")) {
						if (dimuonchieu <= 1) {
							diemvaochieu = 1;
						} else if (dimuonchieu > 1 && dimuonchieu < 10) {
							diemvaochieu = 0.8;
						} else if (dimuonchieu >= 10 && dimuonchieu < 15) {
							diemvaochieu = 0.6;
						} else if (dimuonchieu >= 15 && dimuonchieu < 20) {
							diemvaochieu = 0.4;
						} else if (dimuonchieu >= 20 && dimuonchieu < 30) {
							diemvaochieu = 0.2;
						} else {
							diemvaochieu = 0.0;
						}

						diemrachieu = 0.0;

					}
					if (!checkinchieu.equals("") && !checkoutchieu.equals("")) {
						if (dimuonchieu <= 1) {
							diemvaochieu = 1;
						} else if (dimuonchieu > 1 && dimuonchieu < 10) {
							diemvaochieu = 0.8;
						} else if (dimuonchieu >= 10 && dimuonchieu < 15) {
							diemvaochieu = 0.6;
						} else if (dimuonchieu >= 15 && dimuonchieu < 20) {
							diemvaochieu = 0.4;
						} else if (dimuonchieu >= 20 && dimuonchieu < 30) {
							diemvaochieu = 0.2;
						} else {
							diemvaochieu = 0.0;
						}

						if (vesomchieu <= 1) {
							diemrachieu = 1;
						} else if (vesomchieu > 1 && vesomchieu < 10) {
							diemrachieu = 0.8;
						} else if (vesomchieu >= 10 && vesomchieu < 15) {
							diemrachieu = 0.6;
						} else if (vesomchieu >= 15 && vesomchieu < 20) {
							diemrachieu = 0.4;
						} else if (vesomchieu >= 20 && vesomchieu < 30) {
							diemrachieu = 0.2;
						} else {
							diemrachieu = 0.0;
						}

					}

				}

				ServiceContext serviceContext = new ServiceContext();

				tongdiem1ngay = (diemvaosang + diemrasang + diemvaochieu + diemrachieu);

				GioLamLocalServiceUtil.upateDiemChamCong(NgaycanTinhDiem.getId(), NgaycanTinhDiem.getNgay_lam(),
						tongdiem1ngay, 1, serviceContext);

			} else {
				tongdiem1ngay = 0;
			}

		} catch (PortalException e) {
			e.printStackTrace();
		}

		return tongdiem1ngay;
	}

	// tính tổng điểm của 1 thành viên của cả tháng
	public double TinhTongDiemCaThangdenHomnay(long userid, int thang, int nam) {
		double TinhDiemOfThangMotNhanVien = 0;
		List<GioLam> ListGioLamAll = GioLamLocalServiceUtil.getGioLams(-1, -1);
		List<GioLam> ListGioLamMotNhanVienTheoThang = ListGioLamAll.stream().filter(x -> {
			LocalDate localDate = x.getNgay_lam().toInstant() // Chuyển sang Instant
					.atZone(ZoneId.systemDefault()) // Chuyển Instant sang ZonedDateTime dựa trên múi giờ hệ thống
					.toLocalDate(); // Chuyển về LocalDate
			return x.getUser_id() == userid && localDate.getMonthValue() == thang && localDate.getYear() == nam;
		}).collect(Collectors.toList());

		for (GioLam gioLam : ListGioLamMotNhanVienTheoThang) {
			TinhDiemOfThangMotNhanVien += gioLam.getDiem();
		}
		return TinhDiemOfThangMotNhanVien;
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

	public static boolean CoPhaiThu7orChuNhat(Date ngay_lam) {
		LocalDate localDatengay_lam = ngay_lam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DayOfWeek dayOfWeek = localDatengay_lam.getDayOfWeek();
		return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
	}

	public String LaytenPhongquaUserId(long userId) {
		String tenphong = "khong co phong ban";
		// List<Users> TatCaNhanVien = UsersLocalServiceUtil.getUserses(-1, -1);
		List<Phongban> ListPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		Users username = UsersLocalServiceUtil.getUserbyUserId(userId);
		long maphong = username.getPhongban_id();
		for (Phongban phongban : ListPhongBan) {
			if (phongban.getId() == maphong) {
				tenphong = phongban.getTenphong();
			} else {
				tenphong = tenphong;
			}
		}
		return tenphong;
	}

}