<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>	
</head>

<body class="${css_class}">
	 <style>
				#sidlebar {
					background-color: #97f344;
				    width: 15%;
				    margin-left: 0;
				    margin-right: 0;
				    height: 100%;
				}
				
	 </style>
<div class="container-fluid" id="sidlebar">
     <@liferay_portlet["runtime"]
						defaultPreferences="<portlet-preferences></portlet-preferences>"
						portletProviderAction=portletProviderAction.VIEW
						portletName="com_liferay_docs_sidebar_portlet_SidebarPortlet"/>

</div>

</body>

</html>



	<#--
	  <section id="sidebar">
					
	</section>
	   <h1>xin chào đăng chiến đã vào được Slide Bar</h1>
	-->