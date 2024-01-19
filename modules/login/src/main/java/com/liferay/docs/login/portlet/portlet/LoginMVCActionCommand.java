package com.liferay.docs.login.portlet.portlet;

import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.docs.login.portlet.constants.LoginPortletKeys;

@Component(property = { "javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"mvc.command.name=/login" }, service = MVCActionCommand.class)
public class LoginMVCActionCommand extends BaseMVCActionCommand {

	@Override
	// viet lai ham doProcessAction trong MVCActionCommand de thuc hien cac action ( o day la action login) 
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		String login = ParamUtil.getString(actionRequest, "login");
		String password = actionRequest.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		String authType = CompanyConstants.AUTH_TYPE_EA;
		System.out.println("login la  ---------------- " + login);
		System.out.println("password la  ---------------- " + password);
		AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
		actionResponse.sendRedirect("/home");
	}

}
