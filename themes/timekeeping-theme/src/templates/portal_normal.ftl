<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid position-relative" id="wrapper">
  

	<header id="banner" role="banner">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
			<#-- 
			    ẩn Logo
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>
            -->
            <#-- 
               ẩn title
				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			-->
			</div>
		</div>
       <#--
			<#if !is_signed_in>
				<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
			</#if>
	     
			<#if has_navigation && is_setup_complete>
				<#include "${full_templates_path}/navigation.ftl" />
			</#if>
	    -->
	</header>
	
	
	
	
	
	
	
 
 

<#assign
    time_zone = user.getTimeZoneId()
    is_login_redirect_required = portalUtil.isLoginRedirectRequired(request)
    is_signed_in = theme_display.isSignedIn()
    group_id = theme_display.getScopeGroupId()
    
/>

<section id="content">
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
	    <@liferay_util["include"] page=content_include />
	    <h1>Xin chào </h1>
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
	
	
</section>



    
	
	



 <#-- 	
<section id="content">
    <#if !is_signed_in>
        <script>
            Liferay.on('allPortletsReady', function() {
                // Kiểm tra nếu người dùng chưa đăng nhập
                if (!Liferay.ThemeDisplay.isSignedIn()) {
                    // Chuyển hướng đến trang đăng nhập
                    if (window.location.pathname !== '/login') {
                        Liferay.Util.navigate('/login');
                    }
                }
            });
        </script>
         <section id="content">
            <@liferay_util["include"] page=content_include />
        </section>
        
    <#else>
        <script>
            Liferay.on('allPortletsReady', function() {
                // Kiểm tra nếu người dùng đã đăng nhập và đang truy cập trang /login
                var currentURL = new URL(window.location.href);
                if (currentURL.pathname === '/login' && Liferay.ThemeDisplay.isSignedIn()) {
                    // Chuyển hướng đến trang home
                    Liferay.Util.navigate('/home');
                }
            });
        </script>
        
        <h1>Xin chao</h1>

        <section id="content">
            <@liferay_util["include"] page=content_include />
        </section>
    </#if>
</section>

 -->
<#--
<footer id="footer" role="contentinfo">
	<p class="powered-by">
	<@liferay.language_format 
	            arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'
				key="powered-by-x"/>
	</p>
</footer>
-->		
	
	
	
	
	
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>