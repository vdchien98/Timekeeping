package com.liferay.docs.home.portlet.portlet;

import com.liferay.docs.home.portlet.constants.HomePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

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
		"javax.portlet.display-name=Home",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HomePortletKeys.HOME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HomePortlet extends MVCPortlet {
	
	
	

//    @Override
//    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
//        // Kiểm tra xem người dùng đã đăng nhập hay chưa
//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        long userId = themeDisplay.getUserId();
//
//        if (userId > 0) {
//            // Người dùng đã đăng nhập, ở lại và xử lý logic của bạn ở đây
//            super.doView(renderRequest, renderResponse);
//        } else {
//            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
//            String loginURL = "/login"; // Đặt URL của trang đăng nhập của bạn
//            sendRedirect(renderResponse, loginURL);
//        }
//    }
//
//    private void sendRedirect(RenderResponse renderResponse, String redirectURL) throws IOException {
//        HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(renderResponse);
//        httpServletResponse.sendRedirect(redirectURL);
//    }
}