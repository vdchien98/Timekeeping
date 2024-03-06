<%@ include file="/init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">





<c:choose>
	<c:when test="${quyenquantri}">

		<nav
			class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
			<!-- Sidebar Toggle (Topbar) -->
			<button id="sidebarToggleTop"
				class="btn btn-link d-md-none rounded-circle mr-3">
				<i class="fa fa-bars"></i>
			</button>

			<div class="d-none d-lg-inline mx-3 font-weight-bold text-center">
				HỆ THỐNG CHẤM CÔNG VÀ GIAO VIỆC <br>TRUNG TÂM CÔNG NGHỆ THÔNG
				TIN VÀ TRUYỀN THÔNG
			</div>

			<!-- Topbar Navbar -->
			<ul class="navbar-nav ml-auto">

				<div class="topbar-divider d-none d-sm-block"></div>

				<!-- Nav Item - User Information -->
				<li class="nav-item dropdown no-arrow"><a
					class="nav-link dropdown-toggle" href="/c/portal/logout"
					id="userDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <span
						class="mr-2 d-none d-lg-inline text-gray-600 small">Quản
							trị hệ thống | vdchien.stttt</span> <i class="fa fa-user"
						aria-hidden="true"></i>
				</a> <!-- Dropdown - User Information -->
					<div
						class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown">
						<a class="dropdown-item logout" href="/c/portal/logout"
							data-toggle="modal" data-target="#logoutModal"> <i
							class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Thoát
						</a>
					</div></li>
			</ul>

		</nav>

	</c:when>
	<c:otherwise>
		<nav
			class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
			<!-- Sidebar Toggle (Topbar) -->
			<button id="sidebarToggleTop"
				class="btn btn-link d-md-none rounded-circle mr-3">
				<i class="fa fa-bars"></i>
			</button>

			<div class="d-none d-lg-inline mx-3 font-weight-bold text-center">
				HỆ THỐNG CHẤM CÔNG VÀ GIAO VIỆC <br>TRUNG TÂM CÔNG NGHỆ THÔNG
				TIN VÀ TRUYỀN THÔNG
			</div>

			<!-- Topbar Navbar -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown no-arrow"><c:forEach
						var="itemChucVu" items="${selectChucVu}">
						<c:if test="${itemChucVu.id == thongtintaikhoan.chucvu_id}">
							<span class="nav-link text-warning"> ${itemChucVu.name}</span>
						</c:if>
					</c:forEach></li>

				<li class="nav-item dropdown no-arrow"><c:forEach
						var="itemPhongBan" items="${selectPhongBan}">
						<c:if test="${itemPhongBan.id == thongtintaikhoan.phongban_id}">
							<span class="nav-link text-info"> Phòng/ban:
								${itemPhongBan.tenphong}</span>
						</c:if>
					</c:forEach> </li>
				<div class="topbar-divider d-none d-sm-block"></div>

				<!-- Nav Item - User Information -->
				<li class="nav-item dropdown no-arrow"><a
					class="nav-link dropdown-toggle" href="#" id="userDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <span
						class="mr-2 d-none d-lg-inline text-gray-600 small">${thongtintaikhoan.hovaten}</span>
						<i class="fa fa-user" aria-hidden="true"></i>
				</a> <!-- Dropdown - User Information -->
					<div
						class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="/c/portal/logout"> <i
							class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Thoát
						</a>
					</div></li>
				<div class="topbar-divider d-none d-sm-block"></div>
				<li class="nav-item dropdown no-arrow"><a
					class="nav-link text-danger" href="huong-dan.pdf" target="_blank">
						<span>Hướng dẫn</span>
				</a></li>

			</ul>
			<!-- End of Topbar -->
		</nav>







	</c:otherwise>
</c:choose>




























<script>
	$(document).ready(function() {
		// Bắt sự kiện click vào thẻ a
		$('#userDropdown').click(function() {
			// Hiển thị hoặc ẩn dropdown-menu
			$('.dropdown-menu').toggle();
		});
	});
</script>
