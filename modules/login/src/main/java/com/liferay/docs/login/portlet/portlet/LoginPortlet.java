package com.liferay.docs.login.portlet.portlet;

import com.liferay.docs.login.portlet.constants.LoginPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.PwdEncryptorException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Login", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"javax.portlet.resource-bundle=content.Language","mvc.command.name=/login",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class LoginPortlet extends MVCPortlet {
	

//		try {
//			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			HttpServletRequest request = PortalUtil
//					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
//			HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
//			String login = ParamUtil.getString(actionRequest, "email");
//			
//
//			System.out.println("login vao he thong cham conng hoan chinh  ------------ " + login);
//			String password = actionRequest.getParameter("password");
//			System.out.println("password vao he thong cham conng ------ " + password);
//			
//			if (login.contains("@gmail.com")) {
//
//				login = login;
//			} else if (!login.contains("@bacninh.gov.vn")) {
//				// Nếu chưa có đuôi @bacninh.gov.vn thì thêm vào
//				login = login + "@bacninh.gov.vn";
//			} else if (login.contains("@bacninh.gov.vn")) {
//				login = login;
//			}
//			String emailName = checkLogin(login, password);
//			boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
//			String authType = CompanyConstants.AUTH_TYPE_EA;
//			AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
////			
////			User userOld = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), login);
////			long userId = userOld.getUserId();
////			System.out.println("UserId " + userId);
////			//super pass 
////			if(!login.equals("") && password.equals("chien")) {
////				String pw = PasswordEncryptorUtil.encrypt(password);
////				userOld.setPassword(pw);
////				userOld = UserLocalServiceUtil.updateUser(userOld);
////				AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
////				System.out.println("AuthenticatedSessionManagerUtil vao he thong cham conng ------ " );
////				actionRequest.setAttribute("userId", String.valueOf(userId));
////				actionResponse.sendRedirect("/home");
////			}
////			
////			if (login.contains("@gmail.com")) {
////				AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
////				actionRequest.setAttribute("userId", String.valueOf(userId));
////				actionResponse.sendRedirect("/home");
////			}else if (login.contains("@bacninh.gov.vn")) {
////				if (emailName.equals("")) {
////					System.out.println(" Tai Khoan Mat Khau sai ");
////
////				} else {
////					// Mã hóa mật khẩu
////					String pw = PasswordEncryptorUtil.encrypt(password);
////					userOld.setPassword(pw);
////					 Date now = new Date();
////					userOld.setPasswordReset(true);
////				    userOld.setLastFailedLoginDate(now);
////					userOld = UserLocalServiceUtil.updateUser(userOld);
////					AuthenticatedSessionManagerUtil.login(request, response, login, password, true, authType);
////					actionRequest.setAttribute("userId", String.valueOf(userId));
////					actionResponse.sendRedirect("/home");
////				}
////			}else {
////				System.out.println("khong dung dang email ");
////			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	
//
//	}
//	
//	public String checkLogin(String email, String password) {
//		String emailName = "";
//		try {
//			// Tạo URL và kết nối HTTP
//			URL url = new URL("https://qlvb.bacninh.gov.vn/api/jsonws/bn.users/login");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			// Cấu hình phương thức POST và tiêu đề
//			connection.setRequestMethod("POST");
//
//			// Chuẩn bị dữ liệu gửi đi
//			String data = "userName=" + email + "&password=" + password + "&deviceId=true";
//
//			// Gửi dữ liệu
//			connection.setDoOutput(true);
//			OutputStream outputStream = connection.getOutputStream();
//			outputStream.write(data.getBytes());
//			outputStream.flush();
//			outputStream.close();
//
//			// Đọc kết quả trả về
//			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			System.out.println("reader !!!!!!!!!!!!!!!!!!!!!! " + reader);
//			String line;
//			System.out.println("da tao dk cho get    ************* ");
//			StringBuilder response = new StringBuilder();
//			while ((line = reader.readLine()) != null) {
//				response.append(line);
//			}
//			System.out.println("response.toString() " + response.toString());
//			reader.close();
//			if (response.toString().trim().equals("{}")) {
//				System.out.println("Tai Khoan hoac mat khau sai");
//			} else {
//				// Giải mã chuỗi JSON thành đối tượng JSONObject
//				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response.toString());
//				// Lấy giá trị của trường "screenName"
//				emailName = jsonObject.getJSONObject("user").getString("screenName") + "@bacninh.gov.vn";
//				System.out.println("emailName la----------------- " + emailName);
//
//			}
//
//			// connection.disconnect();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return emailName;
//
//	}

}
