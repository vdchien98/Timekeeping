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
		trị chức vụ</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách chức vụ
			</h4>
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
												style="width: 151px;">STT</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Tên chức vụ: activate to sort column ascending"
												style="width: 368px;">Tên chức vụ</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Hành động: activate to sort column ascending"
												style="width: 288px;">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="chucvu" items="${chucVuList}" varStatus="loop">
											<tr role="row" class="odd">
												<td class="sorting_1">${loop.index +1}</td>
												<td>${chucvu.name} <br> <span class="text-info">Số nhân viên: 5</span>
												</td>
												<td>
													<button class="btn btn-success btn-circle mr-1 btn-sm"
														type="button" data-toggle="tooltip" title="Sửa"
														onclick="editChucVu('${chucvu.id}', '${chucvu.name}', '${chucvu.role}');"
														>
														<i class="fa fa-pencil-square-o iconnhanvien"
															aria-hidden="true"></i>
													</button>
												</td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status"
									aria-live="polite">Hiển thị 1 đến 5 của 5 kết quả</div>
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
							mới chức vụ</h5>
					</div>
					<portlet:actionURL name="saveChucVu" var="formChucVuActionURL" />
					<form id="form1" method="POST"
						action="<%=formChucVuActionURL.toString()%>"
						name="<portlet:namespace />fm">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="name" class="col-form-label text-md-right">Tên
									chức vụ <span class="text-danger">(*)</span>
								</label> 
								<input id="chucvuId" type="hidden" class="form-control"
									    name="<portlet:namespace />idChucVu" required autofocus
									placeholder="ID" value="${chucvuedit.id}"> 
								<input id="name" type="text" class="form-control"
									   name="<portlet:namespace />name" required autofocus
									   placeholder="Nhập tên chức vụ"  ${chucvuedit.name} >
							</div>
							<div class="form-group row mt-4">
								<label for="name" class="col-form-label text-md-right">Nhóm
									quyền <span class="text-danger">(*)</span>
								</label> 
                                <select class="custom-select" id="roleChucVu" name="<portlet:namespace />roleChucVu" required="">

											<option value="0 " >Nhân viên</option>
											<option value="1"  >Lãnh đạo phòng</option>
											<option value="2" >Lãnh đạo đơn vị</option>
								</select>
								
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>
					<div>
						<strong class="text-danger">Chú ý:</strong> <br> <span>
							- Chỉ những chức vụ không có nhân viên có chức năng xóa. Chức vụ
							có nhân viên không có chức năng xóa.</span> <br> <span> - Do
							vậy để xóa được chức vụ phải chuyển các nhân viên trong chức vụ
							đó sang chức vụ khác hoặc xóa những nhân viên đó.</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
    function editChucVu(id, name, role) {
        var modalTitle = document.querySelector(".modal-title");
        var roleChucVuSelect = document.getElementById("roleChucVu");

        if (id > 0) {
            modalTitle.textContent = 'Chỉnh sửa chức vụ';
        } else {
            modalTitle.textContent = 'Thêm mới chức vụ';
        }

        console.log("*****" + id);

        // Đặt giá trị cho các trường input và select
        document.getElementById("chucvuId").value = id;
        document.getElementById("name").value = name;

        // Duyệt qua các tùy chọn và thêm thuộc tính selected cho tùy chọn có giá trị bằng role
        for (var i = 0; i < roleChucVuSelect.options.length; i++) {
            if (roleChucVuSelect.options[i].value == role) {
                roleChucVuSelect.options[i].selected = true;
            } else {
                roleChucVuSelect.options[i].selected = false;
            }
        }
    }
</script>
