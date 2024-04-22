<%@ include file="/init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
ul.navbar-nav.bg-gradient-primary.sidebar.sidebar-dark.chiendang {
	width: 100% !important;
}

img.img-fluid.px-3.px-sm-4.mt-3.mb-4 {
	width: 72px;
	height: 72px;
}

p.chien1 {
	display: inline;
	margin-left: 5px;
	margin-right: 50px;
}

li.nav-item.vdchien {
	display: flex;
	flex-direction: column;
}

a.sidebar-brand.d-flex.align-items-center.justify-content-center {
	margin-top: 6px;
}

p.chien33 {
	margin-right: 5px;
}

li.nav-item.vdchien {
	margin-left: -10px;
}
</style>




<c:choose>
	<c:when test="${quyenquantri}">
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark chiendang"
			id="">
			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center">
				<div class="sidebar-brand-icon">
					<img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
						src=" https://chamcong.bacninh.gov.vn/images/stttt.png"
						alt="Logo Sở thông tin và truyền thông">
				</div>
				<div class="sidebar-brand-text mx-3 text-white">Quản trị</div>
			</a>
			<!-- Divider -->
			<hr class="sidebar-divider my-0">
			<li class="nav-item active"><a class="nav-link" href="#"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			<hr class="sidebar-divider">
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="#"  id="toggleCollapse"> <i
					class="fa fa-clock-o" aria-hidden="true"></i>
					<p class="chien1">Bảng giờ làm</p> <i
					class="fa fa-chevron-right chien22" aria-hidden="true"></i>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar"
					style="">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item " href="#">Giờ làm theo tháng</a> <a
							class="collapse-item " href="#">Giờ làm theo năm</a>
					</div>
				</div></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="#"  id="toggleCollapse"> <i
					class="fa fa-calendar-times-o" aria-hidden="true"></i>
					<p class="chien1">Xin Nghỉ</p>
			</a></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				 id="toggleCollapseCauHinh"> <i
					class="fa fa-cogs" aria-hidden="true"></i>
					<p class="chien1 chien33">Cấu hình hệ Thống</p> <i
					class="fa fa-chevron-right chien23" aria-hidden="true"></i>
			</a>
				<div id="collapseUtilitiesCauHinh" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar"
					style="">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item "
							href="http://localhost:8080/admin/nhan-vien">Nhân viên</a> <a
							class="collapse-item "
							href="http://localhost:8080/admin/phong-ban">Phòng ban</a> <a
							class="collapse-item " href="http://localhost:8080/admin/chuc-vu">Chức
							vụ</a> <a class="collapse-item "
							href="http://localhost:8080/admin/ca-lam-viec">Ca làm việc</a> <a
							class="collapse-item "
							href="http://localhost:8080/admin/ngay-nghi-le">Ngày nghỉ lễ</a>
						<a class="collapse-item "
							href="http://localhost:8080/admin/ngay-lam-viec">Ngày làm
							việc</a>

					</div>
				</div></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="#"  id="toggleCollapse"> <i
					class="fa fa-calendar-times-o" aria-hidden="true"></i>
					<p class="chien1">Hướng Dẫn</p>
			</a></li>
		</ul>

	</c:when>
	<c:otherwise>
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark chiendang"
			id="">
			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center">
				<div class="sidebar-brand-icon">
					<img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
						src=" https://chamcong.bacninh.gov.vn/images/stttt.png"
						alt="Logo Sở thông tin và truyền thông">
				</div>
				<div class="sidebar-brand-text mx-3 text-white">User</div>
			</a>
			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<hr class="sidebar-divider">
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="http://localhost:8080/gio-lam"  id="toggleCollapse"> <i
					class="fa fa-clock-o" aria-hidden="true"></i>
					<p class="chien1">Bảng giờ làm</p> 
			</a></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="http://localhost:8080/xin-nghi"  id="toggleCollapse"> <i
					class="fa fa-calendar-times-o" aria-hidden="true"></i>
					<p class="chien1">Xin Nghỉ</p>
			</a></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="http://localhost:8080/xin-cham-cong" id="toggleCollapse"><i
					class="fa fa-calendar-check-o" aria-hidden="true"></i>
					<p class="chien1">Xin Chấm Công</p> </a></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="#"  id="toggleCollapse"> <i
					class="fa fa-file-pdf-o" aria-hidden="true"></i>
					<p class="chien1">Phiếu điểm</p>
			</a></li>
			<li class="nav-item vdchien"><a class="nav-link banggiolam"
				href="#"  id="toggleCollapse"> <i
					class="fa fa-book" aria-hidden="true"></i>
					<p class="chien1">Hướng Dẫn</p>
			</a></li>
		</ul>

	</c:otherwise>
</c:choose>



<script>
	$(document)
			.ready(
					function() {
						// Bắt sự kiện click trên thẻ có id là "toggleCollapse"
						$("#toggleCollapse")
								.click(
										function() {
											// Thêm hoặc xoá class "show" của div có id là "collapseUtilities"
											$("#collapseUtilities")
													.toggleClass("show");

											// Lấy phần tử <i> để thay đổi class giữa "fa-chevron-right" và "fa-chevron-down"
											var chevronIcon = $(this).find(
													"i.chien22");

											// Kiểm tra xem có class "show" hay không
											if ($("#collapseUtilities")
													.hasClass("show")) {
												chevronIcon
														.removeClass(
																"fa-chevron-right")
														.addClass(
																"fa-chevron-down");
											} else {
												chevronIcon
														.removeClass(
																"fa-chevron-down")
														.addClass(
																"fa-chevron-right");
											}
										});
						$("#toggleCollapseCauHinh")
								.click(
										function() {
											// Thêm hoặc xoá class "show" của div có id là "collapseUtilities"
											$("#collapseUtilitiesCauHinh")
													.toggleClass("show");

											// Lấy phần tử <i> để thay đổi class giữa "fa-chevron-right" và "fa-chevron-down"
											var chevronIcon = $(this).find(
													"i.chien23");

											// Kiểm tra xem có class "show" hay không
											if ($("#collapseUtilitiesCauHinh")
													.hasClass("show")) {
												chevronIcon
														.removeClass(
																"fa-chevron-right")
														.addClass(
																"fa-chevron-down");
											} else {
												chevronIcon
														.removeClass(
																"fa-chevron-down")
														.addClass(
																"fa-chevron-right");
											}
										});
					});
</script>



