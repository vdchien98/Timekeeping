<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
<%@ include file="../init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</link>

<style>
.form-group.row.khoitaongaulamviec {
	margin-left: 30px;
}

i.fa.fa-pencil-square-o {
	font-size: large;
}
</style>

<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị ngày làm việc</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách số ngày
				làm việc trong tháng</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<div class="form-group row">
						<form class="pl-5" id="search-year" method="get"
							name="<portlet:namespace />fm">
							<input type="hidden" name="p_p_id"
								value="<%=themeDisplay.getPortletDisplay().getId()%>" /> <input
								type="hidden" name="p_p_auth"
								value="<%=AuthTokenUtil.getToken(request, themeDisplay.getPlid(), themeDisplay.getPpid())%>" />
							<div class="form-group row">
								<div class="form-group row">
									<label class="col-form-label font-weight-bold text-info mr-3">Năm</label>
									<input type="text"
										class="form-control datepicker col-md-6 ml-6"
										name="<portlet:namespace />yearone" id="year"
										placeholder="${namsaucung}" value="" >
								</div>
							</div>
						</form>




						<portlet:actionURL name="saveNgayNghiLamviec"
							var="formNgayNghiLeActionURL" />
						<form id="form2" method="POST"
							action="<%=formNgayNghiLeActionURL.toString()%>"
							name="<portlet:namespace />fm">
							<input type="hidden" name="_token" value="">
							<div class="form-group row khoitaongaulamviec">
								<input type="text" hidden="" id="yearSubmit"
									name="<portlet:namespace />yearSubmit" value="">
								<button class="btn btn-info" style="">Khởi tạo ngày làm
									việc</button>
							</div>
						</form>
					</div>
					<table class="table table-bordered table-hover" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Tháng</th>
								<th>Số ngày làm việc</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="itemngaylamviec" items="${hienthirender}"
								varStatus="loop">
								<tr>
									<td class="text-center">${itemngaylamviec.thang}</td>
									<td class="text-center">${itemngaylamviec.so_ngay_lam_viec}</td>
									<td class="text-center">
										<button class="btn btn-success btn-circle mr-1 btn-sm"
											type="button" data-toggle="tooltip" title=""
											onclick="editNgayLamViec('${itemngaylamviec.id}', '${itemngaylamviec.thang}','${itemngaylamviec.so_ngay_lam_viec}');"
											data-original-title="Sửa">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>


							</c:forEach>


						</tbody>
					</table>
				</div>

				<div class="col-md-5">
					<div class="modal-header">
						<h5 class="modal-title text-uppercase font-weight-bold">Cập
							nhật ngày làm việc</h5>
					</div>
					<portlet:actionURL name="saveChinhSuaNgayLamViec"
						var="formNgayNghiLamviecchinhsuaActionURL" />
					<form id="form" method="POST"
						action="<%=formNgayNghiLamviecchinhsuaActionURL.toString()%>">
						<input type="hidden" id ="idngaylamviec" name="<portlet:namespace />idngaylamviec"
							value="">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="thang" class="col-form-label text-md-right">Tháng
									<span class="text-danger">(*)</span>
								</label> <input id="thang" type="number" class="form-control"
									name="<portlet:namespace />thangngaylamviec" placeholder="Nhập tháng" required readonly value="${ngaylamviecedit.thang}">
							</div>
							<div class="form-group row mt-4">
								<label for="so_ngay_lam_viec"
									class="col-form-label text-md-right">Số ngày làm việc <span
									class="text-danger">(*)</span></label>
								<div class="input-group">
									<input type="number" class="form-control"
										name="<portlet:namespace />so_ngay_lam_viec" id="so_ngay_lam_viec"
										placeholder="Nhập số ngày làm việc" value="${ngaylamviecedit.so_ngay_lam_viec}" required="">
								</div>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	!(function($) {
		$.fn.datepicker.dates['vi'] = {
			days : [ "Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm",
					"Thứ sáu", "Thứ bảy", "Chủ nhật" ],
			daysShort : [ "CN", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6",
					"Thứ 7", "CN" ],
			daysMin : [ "CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN" ],
			months : [ "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
					"Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10",
					"Tháng 11", "Tháng 12" ],
			monthsShort : [ "Th1", "Th2", "Th3", "Th4", "Th5", "Th6", "Th7",
					"Th8", "Th9", "Th10", "Th11", "Th12" ],
			today : "Hôm nay",
			clear : "Xóa",
			format : "dd/mm/yyyy"
		};
	}(jQuery));

	$(document).ready(function() {
		$('.datepicker').datepicker({
			language : 'vi',
			format : "yyyy",
			startView : "years",
			minViewMode : "years"
		}).on('changeDate', function(e) {
			var selectedMonth = e.date.getMonth() + 1; // Tháng được chọn (0-11)
			var selectedYear = e.date.getFullYear(); // Năm được chọn
			console.log("selectedYear " + selectedYear)
			$('#yearSubmit').val(selectedYear);
			$('#year').val(selectedYear);
			$('#search-year').submit();
		});
	});

	function editNgayLamViec(id, thang, songaylamviec) {
		console.log("id la ----- " + id)
		console.log("thang la ----- " + thang)
		console.log("songaylamviec la ----- " + songaylamviec)
		document.getElementById("idngaylamviec").value = id;
		document.getElementById("thang").value = thang;
		document.getElementById("so_ngay_lam_viec").value = songaylamviec;
	}
</script>