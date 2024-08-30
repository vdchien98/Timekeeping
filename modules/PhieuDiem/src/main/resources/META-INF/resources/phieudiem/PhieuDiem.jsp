<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3 text-center">
			<h4 class="m-0 font-weight-bold text-primary">PHIẾU TỰ XẾP LOẠI
				MỨC ĐỘ HOÀN THÀNH NHIỆM VỤ</h4>
			<div class="input-group row justify-content-center">
				<form class="form-inline" action="#" id="searchMonth"></form>
			</div>
		</div>
		<div class="card-body">
			<ul class="nav nav-tabs mb-2" id="myTab" role="tablist">
				<c:choose>
					<c:when test="${quyenxemgiolam == 1 }">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="home-tab"
								data-bs-toggle="tab" data-bs-target="#home-tab-pane"
								type="button" role="tab" aria-controls="home-tab-pane"
								aria-selected="true">Phiếu tự xếp loại của tôi</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
								data-bs-target="#profile-tab-pane" type="button" role="tab"
								aria-controls="profile-tab-pane" aria-selected="false"
								tabindex="-1">Phiếu tự xếp loại của phòng/đơn vị</button>
						</li>
					</c:when>
					<c:when test="${quyenxemgiolam == 2 }">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="home-tab"
								data-bs-toggle="tab" data-bs-target="#home-tab-pane"
								type="button" role="tab" aria-controls="home-tab-pane"
								aria-selected="true">Phiếu tự xếp loại của tôi</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
								data-bs-target="#profile-tab-pane" type="button" role="tab"
								aria-controls="profile-tab-pane" aria-selected="false"
								tabindex="-1">Phiếu tự xếp loại của phòng/đơn vị</button>
						</li>

					</c:when>
					<c:when test="${quyenxemgiolam == 3 }">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="home-tab"
								data-bs-toggle="tab" data-bs-target="#home-tab-pane"
								type="button" role="tab" aria-controls="home-tab-pane"
								aria-selected="true">Phiếu tự xếp loại của tôi</button>
						</li>
					</c:when>
				</c:choose>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home-tab-pane"
					role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					<%-- xử lý cá nhân  --%>
					<div class="tab-pane fade show active" id="phieuxeploainhanvien"
						role="tabpanel" aria-labelledby="phieuxeploainhanvien-tab">
						<portlet:actionURL name="ChamPhieuDiem" var="ActionChamPhieuDiem" />
						<form id="chamCongForm" method="POST"
							action="<%=ActionChamPhieuDiem.toString()%>"
							name="<portlet:namespace />fm">

							<h5 class="font-weight-bold">I. Kết quả tự đánh giá mức độ
								hoàn thành nhiệm vụ:</h5>
							<table class="table table-bordered">
								<thead>
									<tr class="text-center bg-info text-white">
										<th style="width: 5%;">TT</th>
										<th>Nội dung công việc/ Cách tính điểm</th>
										<th style="width: 10%;">Điểm tối đa</th>
										<th style="width: 15%;">Tự đánh giá</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="cauhoi" items="${danhsachcauhoi}"
										varStatus="loop">
										<c:choose>
											<c:when test="${cauhoi.thuocnhomcauhoinao == 0}">
												<tr class="font-weight-bold bg-warning text-white">
													<td class="text-center">${cauhoi.nhomcauhoi}</td>
													<td>${cauhoi.noidungcauhoi}</td>
													<td class="text-center">${cauhoi.diemtoida}</td>
													<td><input type="number" min="0" max="" readonly=""
														class="form-control tong" name="chinhtri" id="chinhtri"
														value=""></td>
												</tr>

											</c:when>
											<c:when test="${cauhoi.thuocnhomcauhoinao == 1}">
												<tr>
													<td class="text-center">${cauhoi.nhomcauhoi}</td>
													<td>${cauhoi.noidungcauhoi}</td>
													<td class="text-center">${cauhoi.diemtoida}</td>
													<%-- 
													<td><input type="number" min="0" max="" readonly=""
														class="form-control tong" name="chinhtri" id="chinhtri"
														value=""></td>
													 --%>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td class="text-center">${cauhoi.nhomcauhoi}</td>
													<td>${cauhoi.noidungcauhoi}</td>
													<td class="text-center">${cauhoi.diemtoida}</td>
													<td><input type="number" min="0" max="3"
														class="form-control chinhtri" name="chinhtri_1"
														id="chinhtri_1" value=""></td>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tbody>
							</table>
							<div class="form-group">
								<label for="y_kien" class="col-form-label text-md-right">Các
									ý kiến khác (nếu có)</label>
								<div class="input-group">
									<textarea class="form-control" name="y_kien" id="y_kien"
										rows="5"></textarea>
								</div>
							</div>
							<div class="form-group"></div>
							<input type="hidden" value="2024-08" name="searchDate">
							<div class="form-group text-center">
								<button type="submit" class="btn btn-primary" id="save-form">
									<i class="fas fa-save"></i> Xác nhận
								</button>
							</div>
						</form>
					</div>

				</div>


				<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
					aria-labelledby="profile-tab" tabindex="0">
					<%-- xử lý bảng trưởng phòng  --%>
					<p>Xuất excel</p>

				</div>

			</div>


		</div>
	</div>
</div>


<script>
function ChinhTriTotal() {
    let inputs = document.querySelectorAll('.form-control.chinhtri');
    let total = 0;
    inputs.forEach(input => {
        total += parseInt(input.value) || 0;
    });
    document.getElementById('chinhtri').value = total;
    xacdinhtongdiemPhieuDiem();
}
function DaoDucLoiSongTotal() {
    let inputs = document.querySelectorAll('.form-control.daoduc_loisong');
    let total = 0;
    inputs.forEach(input => {
        total += parseInt(input.value) || 0;
    });
    document.getElementById('daoduc_loisong').value = total;
    xacdinhtongdiemPhieuDiem();
}

function Ythuc_ky_luat_2Total() {
    let inputs = document.querySelectorAll('.form-control.ythuc_kyluat_2');
    let total = 0;
    inputs.forEach(input => {
        total += parseInt(input.value) || 0;
    });
    document.getElementById('ythuc_kyluat_2').value = total;
    //xacdinhtongdiemMuc3()
}

function YthucKyluatTotal() {
    let inputs = document.querySelectorAll('.form-control.ythuc_kyluat');
    let total = 0;
    inputs.forEach(input => {
        total += parseInt(input.value) || 0;
    });
    document.getElementById('ythuc_kyluat').value = total;
    xacdinhtongdiemMuc3()
}




function xacdinhtongdiemMuc3() {
    let ythuc_kyluat_1 = parseInt(document.getElementById('ythuc_kyluat_1').value) || 0;

    let ythuc_kyluat_3 = parseInt(document.getElementById('ythuc_kyluat_3').value) || 0;
    let ythuc_kyluat_2 = parseInt(document.getElementById('ythuc_kyluat_2').value) || 0;
    let ythuc_kyluat_4 = parseInt(document.getElementById('ythuc_kyluat_4').value) || 0;
    let ythuc_kyluat_5 = parseInt(document.getElementById('ythuc_kyluat_5').value) || 0;
    let ythuc_kyluat_6 = parseInt(document.getElementById('ythuc_kyluat_6').value) || 0;
    let ythuc_kyluat_7 = parseInt(document.getElementById('ythuc_kyluat_7').value) || 0;
    let ythuc_kyluat_8 = parseInt(document.getElementById('ythuc_kyluat_8').value) || 0;
    let total = ythuc_kyluat_3 + ythuc_kyluat_2+ ythuc_kyluat_4+ ythuc_kyluat_5+ ythuc_kyluat_6+ ythuc_kyluat_7+ ythuc_kyluat_8;
    document.getElementById('').value = total;
    xacdinhtongdiemPhieuDiem();
}

function KetquaThucChienTotal() {
    let inputs = document.querySelectorAll('.form-control.ketqua_thuchien');
    let total = 0;
    inputs.forEach(input => {
        total += parseInt(input.value) || 0;
    });
    document.getElementById('ketqua_thuchien').value = total;
    xacdinhtongdiemPhieuDiem();
}
function GiaiPhapSangKienTotal() {
    let inputs = document.querySelectorAll('.form-control.giaiphap_sangkien');
    let total = 0;
    inputs.forEach(input => {
        total += parseInt(input.value) || 0;
    });
    document.getElementById('giaiphap_sangkien').value = total;
    xacdinhtongdiemPhieuDiem();
}

function xacdinhtongdiemPhieuDiem() {
    let chinhtri = parseInt(document.getElementById('chinhtri').value) || 0;
    let daoduc_loisong = parseInt(document.getElementById('daoduc_loisong').value) || 0;
    let ythuc_kyluat = parseInt(document.getElementById('ythuc_kyluat').value) || 0;
    let ketqua_thuchien = parseInt(document.getElementById('ketqua_thuchien').value) || 0;
    let giaiphap_sangkien = parseInt(document.getElementById('giaiphap_sangkien').value) || 0;
    let total = chinhtri + daoduc_loisong + ythuc_kyluat + ketqua_thuchien + giaiphap_sangkien;
    document.getElementById('tong_diem').value = total;
}
</script>


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>




<%--  nhúng đoạn này vào để thêm giây trong popup   --%>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous"></script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>








<script type="text/javascript">
	function closeMyModal() {
		$('#myModal').modal('hide');
	}
</script>

<script>
	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})
</script>
