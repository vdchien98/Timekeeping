<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />

	<@liferay.css file_name="${css_folder}/app.css" />
	<@liferay.css file_name="${css_folder}/base.css" />
	<@liferay.css file_name="${css_folder}/sb-admin-2.min.css" />
	<@liferay.css file_name="${css_folder}/styles.css" />
	<@liferay.css file_name="${css_folder}/style.css" />

	<@liferay.css file_name="${css_folder}/bootstrap-datepicker.css" />
	<@liferay.css file_name="${css_folder}/bootstrap-datetimepicker.css" />
	<@liferay.css file_name="${css_folder}/bootstrap-datetimepicker.min.css" />
	
	<@liferay.js file_name="${javascript_folder}/jquery.js" />
	<@liferay.js file_name="${javascript_folder}/style.js" />
	<@liferay.js file_name="${javascript_folder}/bootstrap-datepicker.js" />
	<@liferay.js file_name="${javascript_folder}/bootstrap-datetimepicker.js" />
	<@liferay.js file_name="${javascript_folder}/bootstrap-datetimepicker.min.js" />
	
</head>

<body class="${css_class}">





<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid position-relative" id="wrapper">
   <#--
   
       <style>
				body, html {
				     width: 100%;
				     height: 100%;
				  }
				  div#senna_surface1-default {
					    height: 100%;
				   }
				  #wrapper {
				    width: 100%;
				    height: 100%;
				    display: flex;
				    padding-left: 0;
                    padding-right: 0;
				  }
				  #content {
				    width: 40%;
				    height: 100%;
				    /* Thêm các thuộc tính CSS khác tùy ý */
				  }
	 
		</style>
   
	<header id="banner" role="banner">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
	</header>
	-->

<#assign
    time_zone = user.getTimeZoneId()
    is_login_redirect_required = portalUtil.isLoginRedirectRequired(request)
    is_signed_in = theme_display.isSignedIn()
    group_id = theme_display.getScopeGroupId()
    
/>


	<#if is_signed_in>
	    <!-- Kiểm tra và chuyển hướng nếu đang truy cập /login sau khi đã đăng nhập -->
	    <#assign currentUrl = theme_display.getURLCurrent() />
	    <#assign redirectToLogin = false>
		<#if currentUrl?contains("/login") && !redirectToLogin>
		    <#assign redirectToLogin = true>
		    <script>
		        Liferay.Util.navigate('/home');
		    </script>
		</#if>
		
	    <!-- Bao gồm mẫu cho người dùng đã đăng nhập -->
			${portletDisplay.recycle()}
			${portletDisplay.setTitle(the_title)}
			
 
				<#include "${full_templates_path}/sidlebar.ftl" />
			    <div id="noidung">
			        <#include "${full_templates_path}/navbar.ftl" />
					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>			    
			    </div>

			
			
	<#else>
	    <!-- Kiểm tra và chuyển hướng nếu không phải trang /login -->
	    <#assign currentUrl = theme_display.getURLCurrent() />
	    <#if !currentUrl?contains("/login") >
	        <script>
	           window.location.href = "/login";
	        </script>
	    </#if>
	
	    <!-- Bao gồm mẫu cho người dùng chưa đăng nhập -->
	    <@liferay_util["include"] page=content_include />
	</#if>
	
	
	
	
	
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>