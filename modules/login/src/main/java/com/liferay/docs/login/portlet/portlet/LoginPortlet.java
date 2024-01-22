package com.liferay.docs.login.portlet.portlet;

import com.liferay.docs.login.portlet.constants.LoginPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

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
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Login",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LoginPortlet extends MVCPortlet {
	public void loginChamCong (ActionRequest request1, ActionResponse response1) throws IOException, PortletException {
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request1));
		HttpServletResponse response = PortalUtil.getHttpServletResponse(response1);
		String login = ParamUtil.getString(request1, "email");
		System.out.println(" **************** da vao dc loginChamCong  la  ****************  " );
		String password = request1.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(request1, "rememberMe");
		String authType = CompanyConstants.AUTH_TYPE_EA;
		System.out.println("login la  ---------------- " + login);
		System.out.println("password la  ---------------- " + password);
		try {
			AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response1.sendRedirect("/home");
	
	}

	
	@Override   
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.render(renderRequest, renderResponse);
	}
	
	
}