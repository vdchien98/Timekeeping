<%@ include file="/init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 


 
<portlet:actionURL name="/login" var="loginURL">
	<portlet:param name="mvcRenderCommandName" value="/login" />
</portlet:actionURL>
<aui:form action="<%=loginURL%>" autocomplete='on' cssClass="sign-in-form"
	method="post" name="loginForm">
	<aui:input autoFocus="true" cssClass="clearable" label="email-address"
		name="login" showRequiredLabel="<%=false%>" type="text" value="">
		<aui:validator name="required" />
	</aui:input>

	<aui:input name="password" showRequiredLabel="<%=false%>"
		type="password">
		<aui:validator name="required" />
	</aui:input>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="sign-in" />
	</aui:button-row>

</aui:form>


--%>

<style>
#wrapper {
    justify-content: center;
    margin-top: 5%;
    }
 div#home {
    padding-left: 85px;
    padding-right: 85px;
}
.container.register {
    margin-top: 4%;
}
.register-title {
    text-align: center;
    color: white;
    font-size: revert-layer;
}
</style>







<div class="container register">
	<div class="row justify-content-center">
		<h1 class="text-uppercase register-title font-weight-bold">Hệ thống chấm công và giao việc</h1>
		<div class="col-md-8">
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active text-align" id="home"
					role="tabpanel" aria-labelledby="home-tab">
					<h3 class="register-heading text-uppercase text-center">Đăng nhập</h3>
					<div class="row register-form">
						<div class="col-md-12">
						    <portlet:actionURL name="loginChamCong" var="login" />
							<form method="POST" action="<%=login.toString()%>">
								<input type="hidden" name="_token">
								<div class="form-group">
									<input type="text" class="form-control " name="<portlet:namespace />email" value=""
										required="" autocomplete="email" autofocus=""
										placeholder="Nhập tên đăng nhập *">

								</div>

								<div class="form-group">
									<input type="password" class="form-control " name="<portlet:namespace />password"
										required="" autocomplete="current-password"
										placeholder="Nhập mật khẩu *">

								</div>

								<div class="form-group text-center">
									<input type="submit" name="LGform1"
										class="btnContactSubmit font-weight-bold" value="Đăng nhập">
								</div>
								<div class="text-center">
									<a
										href="https://tinnhiemmang.vn/danh-ba-tin-nhiem/chamcongbacninhgovvn-1636097761"
										title="Chung nhan Tin Nhiem Mang" target="_blank"><img
										src="https://tinnhiemmang.vn/handle_cert?id=chamcong.bacninh.gov.vn"
										style="width: 100px;" height="auto"
										alt="Chung nhan Tin Nhiem Mang"></a>
								</div>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

