<%@ include file="../init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.iconnhanvien {
	font-size: initial;
}
</style>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị phòng ban</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách phòng
				ban</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<div id="dataTable_wrapper"
						class="dataTables_wrapper dt-bootstrap4 no-footer">
						<div class="row">
							<div class="col-sm-12 col-md-6">
								<div class="dataTables_length" id="dataTable_length">
									<label>Hiển thị <select name="dataTable_length"
										aria-controls="dataTable"
										class="custom-select custom-select-sm form-control form-control-sm"><option
												value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option></select> kết quả
									</label>
								</div>
							</div>
							<div class="col-sm-12 col-md-6">
								<div id="dataTable_filter" class="dataTables_filter">
									<label>Tìm kiếm:<input type="search"
										class="form-control form-control-sm" placeholder=""
										aria-controls="dataTable"></label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table
									class="table table-bordered table-hover dataTable no-footer"
									id="dataTable" width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">
									<thead>
										<tr role="row">
											<th class="sorting_asc" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="STT: activate to sort column descending"
												style="width: 65px;">STT</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Tên phòng ban: activate to sort column ascending"
												style="width: 406px;">Tên phòng ban</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Trạng thái: activate to sort column ascending"
												style="width: 132px;">Trạng thái</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Hành động: activate to sort column ascending"
												style="width: 141px;">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="phongban" items="${phongBanList}"
											varStatus="loop">

											<c:if test="${phongban.so_thanh_vien > 0}">
												<tr role="row" class="odd">
													<td class="sorting_1">${loop.index +1}</td>
													<td><span>${phongban.tenphong}</span> <br> <span
														class="font-weight-bold text-primary">Số nhân viên:
															${phongban.so_thanh_vien}</span> <br> <c:forEach
															var="itemUser" items="${usersList}">
															<c:if test="${phongban.nguoi_phu_trach == itemUser.id}">
																<span class="font-weight-bold text-warning">Người
																	phụ trách: ${itemUser.hovaten}</span>
															</c:if>
														</c:forEach></td>
													<c:choose>
														<c:when test="${phongban.trangthai == 1}">
															<td><span class="btn btn-success btn-sm">Hoạt
																	động</span></td>

														</c:when>
														<c:when test="${phongban.trangthai == 0}">
															<td><span class="btn btn-light btn-sm">Không
																	hoạt động</span></td>

														</c:when>
													</c:choose>


													<td>
														<button class="btn btn-success btn-circle mr-1 btn-sm"
															type="button" data-toggle="tooltip" title="Sửa"
															onclick="editPhongBan('${phongban.id}', '${phongban.tenphong}', '${phongban.nguoi_phu_trach}', '${phongban.trangthai}');">
															<i class="fa fa-pencil-square-o iconnhanvien"
																aria-hidden="true"></i>
														</button>
													</td>
												</tr>




											</c:if>



										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status"
									aria-live="polite">Hiển thị 1 đến 7 của 7 kết quả</div>
							</div>
							<div class="col-sm-12 col-md-7">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTable_paginate">
									<ul class="pagination">
										<li class="paginate_button page-item previous disabled"
											id="dataTable_previous"><a href="#"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">Quay lại</a></li>
										<li class="paginate_button page-item active"><a href="#"
											aria-controls="dataTable" data-dt-idx="1" tabindex="0"
											class="page-link">1</a></li>
										<li class="paginate_button page-item next disabled"
											id="dataTable_next"><a href="#"
											aria-controls="dataTable" data-dt-idx="2" tabindex="0"
											class="page-link">Tiếp</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-5">
					<div class="modal-header">
						<h5 class="modal-title text-uppercase font-weight-bold">Thêm
							mới phòng ban</h5>
					</div>
					<portlet:actionURL name="savePhongBan" var="formPhongBanActionURL" />
					<form id="form" method="POST"
						action="<%=formPhongBanActionURL.toString()%>">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="name" class="col-form-label text-md-right">Tên
									phòng ban <span class="text-danger">(*)</span>
								</label> <input id="phongbanId" type="hidden" class="form-control"
									name="<portlet:namespace />idPhongBan" required autofocus
									placeholder="ID" value="${phongbanedit.id}"> <input
									id="tenphong" type="text" class="form-control"
									name="<portlet:namespace />tenphong" required="" autofocus=""
									placeholder="Nhập tên phòng" value="${phongbanedit.tenphong}">
							</div>
							<div class="form-group row mt-4">
								<label for="name" class="col-form-label text-md-right">Người
									phụ trách</label> <select class="form-control" id="nguoi_phu_trach"
									name="<portlet:namespace />nguoi_phu_trach"
									data-live-search="true" required="">
									<option value="">[-- Chọn người phụ trách --]</option>
									<option value="13">Nguyễn Ngọc Nam</option>
									<option value="49">Lại Hữu Dương</option>
									<option value="55">Khổng Minh Phương</option>
								</select>
							</div>
							<div class="form-group row mt-4">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" name="<portlet:namespace />trangthai"
										value="${phongbanedit.trangthai}"
										${phongbanedit.trangthai == 1 ? 'checked' : ''}
										class="custom-control-input" id="trangthai"
										onclick="updateValuehoatdong()"> <label
										class="custom-control-label" for="trangthai">Hoạt động</label>
								</div>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>
					<div>
						<strong class="text-danger">Chú ý:</strong> <br> <span>
							- Chỉ những phòng ban không có nhân viên có chức năng xóa. Phòng
							ban có nhân viên không có chức năng xóa.</span> <br> <span>
							- Do vậy để xóa được phòng ban phải chuyển các nhân viên trong
							phòng ban đó sang phòng ban khác hoặc xóa những nhân viên đó.</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	function updateValuehoatdong() {
		var checkbox = document.getElementById("trangthai");
		var valueInput = document
				.getElementsByName("<portlet:namespace />trangthai")[0];

		if (checkbox.checked) {
			valueInput.value = 1; // Giá trị mới khi checkbox được chọn
		} else {
			valueInput.value = 0; // Giá trị mới khi checkbox không được chọn
		}
	}
</script>

<script>
	function editPhongBan(id, tenphong, nguoi_phu_trach, trangthai) {
		var modalTitle = document.querySelector(".modal-title");
		if (id > 0) {
			modalTitle.textContent = 'Chỉnh sửa phòng ban';
		} else {
			modalTitle.textContent = 'Thêm phòng ban';
		}
		document.getElementById("phongbanId").value = id;
		document.getElementById("tenphong").value = tenphong;
		document.getElementById("nguoi_phu_trach").value = nguoi_phu_trach;

		if (trangthai > 0) {
			document.getElementById("trangthai").checked = 1;
		} else {
			document.getElementById("trangthai").checked = 0;
		}

	}
</script>

