package com.liferay.docs.giolam.portlet.portlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.backend.model.Calamviec;
import com.liferay.docs.backend.model.Chucvu;
import com.liferay.docs.backend.model.GioLam;
import com.liferay.docs.backend.model.Ngaynghile;
import com.liferay.docs.backend.model.Phongban;
import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.service.CalamviecLocalServiceUtil;
import com.liferay.docs.backend.service.ChucvuLocalServiceUtil;
import com.liferay.docs.backend.service.GioLamLocalServiceUtil;
import com.liferay.docs.backend.service.NgaynghileLocalServiceUtil;
import com.liferay.docs.backend.service.PhongbanLocalServiceUtil;
import com.liferay.docs.backend.service.UsersLocalServiceUtil;
import com.liferay.docs.giolam.portlet.constants.GioLamPortletKeys;
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

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

		//getAccessTokenZaloNew();

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
			WebCacheItem refresh_token_value = new CustomWebCacheItem("refresh_token_key");
			Object refresh_token = WebCachePoolUtil.get("refresh_token_key", refresh_token_value);
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
			for (Map<String, String> tokenPair : tokenPairs) {
				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					// System.out.println(key + ": " + value);
				}
			}

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
			String data = "refresh_token=xOYK55AId6_iYfOKKPISRkY8bHHIZUiUjzwiOdQXutt4mRX07zh5GVgujJiRuEPBgOBeLdUUdKomsSirIuY36RkLr3HItDCJdiRPQpctb4ZuwPji5u6NNDpCntOTb9famDJzUIAFaG2Ua-mGMV2yFvo-pXmd-SGIsPIX0nU7_N_dswzqE9gYMFZmrYOWke5Ns-dqU2ZsZ4VAZTP61CM3FyQaq0zXlTaGc_YlRNAhoK38jRHU1jYpG-IOssefzfvIyAlCV1tAlW7ZbCqdBFIb6SINeWStwCiCvA-PAWJ7tXFtkvTsFDRfNF_GuMSWifLwtyFC062Se2UStiK6MvAbBxhnhH9Yj_uPfiwH9nYlsohVzeasEvYRJyAAYKPxxCv2nvIoOM3frtYizzXaQg-mURFb_4P0lOqzWEM7CeehFqXJZPbh"
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
			for (Map<String, String> tokenPair : tokenPairs) {
				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					// System.out.println(key + ": " + value);
				}
			}

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
						float diem = 0;
						if (chenhLechPhutVaoSang < 0) {
							diem += 1.0;
						} else if (chenhLechPhutVaoSang > 1 && chenhLechPhutVaoSang < 10) {
							diem += 0.8;
						} else if (chenhLechPhutVaoSang >= 10 && chenhLechPhutVaoSang < 15) {
							diem += 0.6;
						} else if (chenhLechPhutVaoSang >= 15 && chenhLechPhutVaoSang < 20) {
							diem += 0.4;
						} else if (chenhLechPhutVaoSang >= 20 && chenhLechPhutVaoSang < 30) {
							diem += 0.2;
						} else {
							diem += 0.0;
						}

						GioLamLocalServiceUtil.addGioLamVaoSang(userId, ngayHienTaikieuDate, gioHienTai,
								chenhLechPhutVaoSang, diem, 1, serviceContext);

					} else if (GioHienTaiTrongBuoiChieu == true) {
//						int chenhLechPhutVaoChieu = (int) gioHienTaiDate.until(gioChamCongVaoChieuFormatted,
//								ChronoUnit.MINUTES);
						int chenhLechPhutVaoChieu = (int) ChronoUnit.MINUTES.between(gioVaoChieu, gioHienTaiDate);
						float diem = 0;
						if (chenhLechPhutVaoChieu < 0) {
							diem += 1.0;
						} else if (chenhLechPhutVaoChieu > 1 && chenhLechPhutVaoChieu < 10) {
							diem += 0.8;
						} else if (chenhLechPhutVaoChieu >= 10 && chenhLechPhutVaoChieu < 15) {
							diem += 0.6;
						} else if (chenhLechPhutVaoChieu >= 15 && chenhLechPhutVaoChieu < 20) {
							diem += 0.4;
						} else if (chenhLechPhutVaoChieu >= 20 && chenhLechPhutVaoChieu < 30) {
							diem += 0.2;
						} else {
							diem += 0.0;
						}

						GioLamLocalServiceUtil.addGioLamVaoChieu(userId, ngayHienTaikieuDate, gioHienTai,
								chenhLechPhutVaoChieu, diem, 1, serviceContext);

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
						float diem = (float) userGioLam.getDiem();
						// System.out.println("diem hien tai la ------- " + diem);
						if (chenhLechPhutRaSang < 0) {
							diem += 1.0;
						} else if (chenhLechPhutRaSang > 1 && chenhLechPhutRaSang < 10) {
							diem += 0.8;
						} else if (chenhLechPhutRaSang >= 10 && chenhLechPhutRaSang < 15) {
							diem += 0.6;
						} else if (chenhLechPhutRaSang >= 15 && chenhLechPhutRaSang < 20) {
							diem += 0.4;
						} else if (chenhLechPhutRaSang >= 20 && chenhLechPhutRaSang < 30) {
							diem += 0.2;
						} else {
							diem += 0.0;
						}

						GioLamLocalServiceUtil.updateGioLamRaSang(idGioLam, user_id, gioHienTai, chenhLechPhutRaSang,
								diem, 1, serviceContext);

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

							float diem = (float) userGioLam.getDiem();
							if (chenhLechPhutRaChieu < 0) {
								diem += 1.0;
							} else if (chenhLechPhutRaChieu > 1 && chenhLechPhutRaChieu < 10) {
								diem += 0.8;
							} else if (chenhLechPhutRaChieu >= 10 && chenhLechPhutRaChieu < 15) {
								diem += 0.6;
							} else if (chenhLechPhutRaChieu >= 15 && chenhLechPhutRaChieu < 20) {
								diem += 0.4;
							} else if (chenhLechPhutRaChieu >= 20 && chenhLechPhutRaChieu < 30) {
								diem += 0.2;
							} else {
								diem += 0;
							}

							GioLamLocalServiceUtil.updateGioLamRaChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutRaChieu, diem, 1, serviceContext);
						} else if (checkinSang.equals("") == false && checkoutSang.equals("") == false) {
							// System.out.println("da cham cong sang nhưng chưa cham cong vao chieu");
							int chenhLechPhutVaoChieu = (int) ChronoUnit.MINUTES.between(gioVaoChieu, gioHienTaiDate);

							float diem = (float) userGioLam.getDiem();
							if (chenhLechPhutVaoChieu < 0) {
								diem += 1;
							} else if (chenhLechPhutVaoChieu > 1 && chenhLechPhutVaoChieu < 10) {
								diem += 0.8;
							} else if (chenhLechPhutVaoChieu >= 10 && chenhLechPhutVaoChieu < 15) {
								diem += 0.6;
							} else if (chenhLechPhutVaoChieu >= 15 && chenhLechPhutVaoChieu < 20) {
								diem += 0.4;
							} else if (chenhLechPhutVaoChieu >= 20 && chenhLechPhutVaoChieu < 30) {
								diem += 0.2;
							} else {
								diem += 0.0;
							}

							GioLamLocalServiceUtil.updateGioLamVaoChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutVaoChieu, diem, 1, serviceContext);
						} else if (checkinSang.equals("") == false) {
							// trường hợp chấm công nhiều thường xuyên
//							int chenhLechPhutRaChieu = (int) gioHienTaiDate.until(gioChamCongRaChieuFormatted,
//									ChronoUnit.MINUTES);
							int chenhLechPhutRaChieu = (int) ChronoUnit.MINUTES.between(gioHienTaiDate, gioRaChieu);
							float diem = (float) userGioLam.getDiem();
							if (chenhLechPhutRaChieu < 0) {
								diem += 3.0;
							} else if (chenhLechPhutRaChieu > 1 && chenhLechPhutRaChieu < 10) {
								diem += 2.8;
							} else if (chenhLechPhutRaChieu >= 10 && chenhLechPhutRaChieu < 15) {
								diem += 2.6;
							} else if (chenhLechPhutRaChieu >= 15 && chenhLechPhutRaChieu < 20) {
								diem += 2.4;
							} else if (chenhLechPhutRaChieu >= 20 && chenhLechPhutRaChieu < 30) {
								diem += 2.2;
							} else {
								diem += 2.0;
							}
							GioLamLocalServiceUtil.updateGioLamRaChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutRaChieu, diem, 1, serviceContext);
						} else if (checkinchieu.equals("") == false) {
							// System.out.println("da cham cong sang nhưng chưa cham cong vao chieu");
							int chenhLechPhutRaChieu = (int) ChronoUnit.MINUTES.between(gioHienTaiDate, gioRaChieu);
							float diem = (float) userGioLam.getDiem();
							if (chenhLechPhutRaChieu < 0) {
								diem += 1.0;
							} else if (chenhLechPhutRaChieu > 1 && chenhLechPhutRaChieu < 10) {
								diem += 0.8;
							} else if (chenhLechPhutRaChieu >= 10 && chenhLechPhutRaChieu < 15) {
								diem += 0.6;
							} else if (chenhLechPhutRaChieu >= 15 && chenhLechPhutRaChieu < 20) {
								diem += 0.4;
							} else if (chenhLechPhutRaChieu >= 20 && chenhLechPhutRaChieu < 30) {
								diem += 0.2;
							} else {
								diem += 0.0;
							}

							GioLamLocalServiceUtil.updateGioLamRaChieu(idGioLam, user_id, gioHienTai,
									chenhLechPhutRaChieu, diem, 1, serviceContext);

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

		response.sendRedirect("/gio-lam");
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// Lấy UserId
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);

		System.out.println("userId****** " + userId);
		Users user = UsersLocalServiceUtil.getUserbyUserId(userId);
		System.out.println("user ------ " + user);

		// check quyền user

		// hàm check có phải trưởng phòng ko ???
		int quyenxemgiolam = checkQuyenTruongPhong(user);
		System.out.println("quyenxemgiolam ----- )))) " + quyenxemgiolam);
		renderRequest.setAttribute("quyenxemgiolam", quyenxemgiolam);
		// System.out.println("user****** " + user);
		// XỬ LÝ NÚT CHẤM CÔNG ///
		// Lấy ca làm việc lưu trong db
		List<Calamviec> calamviecList = CalamviecLocalServiceUtil.getCalamviecs(-1, 1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		DateFormat StringtoDate = new SimpleDateFormat("HH:mm"); // chuyển từ String sang Date
		SimpleDateFormat dateFormatString = new SimpleDateFormat("HH:mm"); // chuyển từ Date sang String
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

		// Lấy ngày hiện tại
		LocalDate ngayHienTai = LocalDate.now();
		DateTimeFormatter ngayHienTaiformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String ngayHienTaiDinhDang = ngayHienTai.format(ngayHienTaiformatter);
		// System.out.println("Ngay hien tai:------------- " + ngayHienTaiDinhDang);

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
//		System.out.println("Lay dc year la  --------------------++++++ "+ year);
//		System.out.println("Lay dc month la  -------------------++++++ "+ month);

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
		System.out.println("keyyear +++++****** " + keyyear);
		System.out.println("keymonth +++++****** " + keymonth);

		renderRequest.setAttribute("monthhienthi", month);
		renderRequest.setAttribute("yearhienthi", year);
		List<Map<String, Object>> danhSachNgayTrongThangMoi = laydulieugiolamofmotnhanvien(keymonth, keyyear, userId);
		System.out.println("danhSachNgayTrongThangMoi ");
		renderRequest.setAttribute("danhSachNgayTrongThang", danhSachNgayTrongThangMoi);
		List<List<Map<String, Object>>> danhSachNgayTrongThangcaPhong = new ArrayList<>();
		if (quyenxemgiolam == 1) {
			// Xử lý hiện thị cho trưởng phòng và phụ trách phòng và giám đốc
			System.out.println("quyenTruongPhong  --- " + quyenxemgiolam);
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
			System.out.println("danhSachNgayTrongThangcaPhong ===== " + danhSachNgayTrongThangcaPhong);
			renderRequest.setAttribute("danhSachNgayTrongThangcaPhong", danhSachNgayTrongThangcaPhong);

		} else if (quyenxemgiolam == 2) {
			// xử lý trưởng phòng
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
			System.out.println("danhSachNgayTrongThangcaPhong ===== " + danhSachNgayTrongThangcaPhong);
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
		System.out.println("monthList ************  " + monthList);

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

			if (x == null) {
//							gioLamMap.put("ngay_lam", x.getNgay_lam());
//			            	gioLamMap.put("ho_va_ten", ho_va_ten);
//							gioLamMap.put("ngay_lam_trongthang", dayOfMonth);
//							gioLamMap.put("cophaingayNghi", CoPhaiNgayNghileKo);
//							gioLamMap.put("CoPhaiThu7orChuNhat", CoPhaiThu7orChuNhatKo);
//						    gioLamMap.put("ngaytrcNgayHienTaiKo", DateTruocSauNgayHienTai); // trường hợp để giới hạn những ngày
//																							// ngày đã chấm công
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
				gioLamMap.put("diem", x.getDiem());
				newgioLamMapListNhanVien.add(gioLamMap);
			}
		}

		System.out.println("newgioLamMapListNhanVien " + newgioLamMapListNhanVien);

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

		return danhSachNgayTrongThangMoi;
		// System.out.println("danhSachNgayTrongThang ---- " +
		// danhSachNgayTrongThangMoi);
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

	public static boolean CoPhaiThu7orChuNhat(Date ngay_lam) {
		LocalDate localDatengay_lam = ngay_lam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DayOfWeek dayOfWeek = localDatengay_lam.getDayOfWeek();
		return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
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
			} else if ((inSang == true && outSang == false) || (inSang == true && outSang == false)) {
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
			} else if ((inChieu == false) && dimuonchieu <= 0 && (inSang == false || outSang == false)) {
				// ttrường hợp ca chiều ko chấm công vào ra
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
			} else if (dimuonsang > 0 || vesomsang > 0) {
				// trường hợp ca sáng đi muộn về sớm
				DataCaChieu = 3;
			} else if ((inSang == true && outSang == true)) {
				// trường hợp ca sáng nghỉ ko phép
				DataCaChieu = 4;
			}
		} else if (trangthaingay == 1) {

			if (dimuonchieu <= 0 && vesomchieu <= 0 && (inChieu == false) && (outChieu == false)) {
				// trường hợp đi làm đúng giờ
				DataCaChieu = 1;
			} else if (inSang == false && outSang == true && inChieu == true & outChieu == false && dimuonsang <= 0
					&& vesomchieu <= 0) {
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
		System.out.println(" chucvu_id " + chucvu_id);
		System.out.println(" phongban_id " + phongban_id);
		System.out.println(" phu_trach_phong " + phu_trach_phong);
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