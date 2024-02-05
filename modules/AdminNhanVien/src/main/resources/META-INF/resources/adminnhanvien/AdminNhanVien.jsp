<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
span.text-info.mr-3.chucvu {
	margin-left: 10px;
}

i.fa.fa-user-circle-o {
	font-size: x-large;
	color: teal;
	margin-bottom: 5px;
}

.iconnhanvien {
	font-size: initial;
}
</style>

<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị nhân viên</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">
				Danh sách nhân viên


				<portlet:renderURL var="createUrl">
					<portlet:param name="mvcPath"
						value="/adminnhanvien/AdminNhanVienCreate.jsp" />
				</portlet:renderURL>
				<a href="<%=createUrl%>" class="btn btn-success float-right"> <i
					class="fa fa-plus" aria-hidden="true"></i> Thêm mới
				</a>




			</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
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
								<table class="table table-hover dataTable no-footer"
									id="dataTable" width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">
									<thead>
										<tr role="row">
											<th style="width: 38px;" class="sorting_asc" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="STT: activate to sort column descending">STT</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Thông tin nhân viên: activate to sort column ascending"
												style="width: 1071px;">Thông tin nhân viên</th>
											<th style="width: 117px;" class="sorting" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-label="Trạng thái: activate to sort column ascending">Trạng
												thái</th>
											<th style="width: 197px;" class="sorting" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-label="Hành động: activate to sort column ascending">Hành
												động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${usersList}" varStatus="loop">


											<portlet:renderURL var="editURL">
												<portlet:param name="id" value="${user.id }" />
												<portlet:param name="mvcPath"
													value="/adminnhanvien/AdminNhanVienCreate.jsp" />
											</portlet:renderURL>

											<tr role="row" class="odd">
												<th class="sorting_1">${loop.index +1}</th>
												<th>
													<div class="row">
														<i class="fa fa-user-circle-o " aria-hidden="true"></i>
														<c:forEach var="itemChucVu" items="${selectChucVu}">
															<c:if test="${itemChucVu.id == user.chucvu_id}">
																<span
																	class="font-weight-bold text-warning styleChucVuHome">
																	${itemChucVu.name}</span>
															</c:if>
														</c:forEach>
														<span>${user.hovaten}</span>
													</div>
													<div class="row">
														<c:forEach var="itemPhongBan" items="${selectPhongBan}">
															<c:if test="${itemPhongBan.id == user.phongban_id}">
																<span class="text-warning mr-3"> Phòng/ban:
																	${itemPhongBan.tenphong}</span>
															</c:if>
														</c:forEach>
													</div>
													<div class="row">
														<span class="mr-3">Tên đăng nhập: </span>${user.email} <span
															class="ml-5 text-info">Có làm ca tối</span> <span
															class="ml-5 text-primary"></span>
													</div>
													<div class="row">
														<span class="mr-3">Số ngày nghỉ phép trong năm: </span><span
															class="text-danger">12</span>
													</div>

												</th>
												<th><span class="btn btn-success btn-sm">Hoạt
														động</span></th>
												<th><a class="btn btn-success btn-circle mr-1 btn-sm"
													href="${editURL }"> <i
														class="fa fa-pencil-square-o iconnhanvien"
														aria-hidden="true"></i>
												</a>

													<button class="btn btn-danger btn-circle btn-sm"
														type="button" onclick="confirmDelete(65);">
														<i class="fa fa-trash iconnhanvien" aria-hidden="true"></i>
													</button>

													<form id="delete-65" class="float-right"
														action="https://chamcong.bacninh.gov.vn/admin/nhan-vien/65"
														method="POST">
														<input type="hidden" name="_token"
															value="NPKgd9Na3cdKPMnwp5Rh7lUTgFi87gmEAXAUvsxA">
														<input type="hidden" name="_method" value="DELETE">
													</form></th>
											</tr>
										</c:forEach>


									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status"
									aria-live="polite">Hiển thị 1 đến 10 của 54 kết quả</div>
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
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="2" tabindex="0"
											class="page-link">2</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="3" tabindex="0"
											class="page-link">3</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="4" tabindex="0"
											class="page-link">4</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="5" tabindex="0"
											class="page-link">5</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="6" tabindex="0"
											class="page-link">6</a></li>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="#" aria-controls="dataTable" data-dt-idx="7"
											tabindex="0" class="page-link">Tiếp</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>







			<portlet:actionURL name="addAllNhanVien" var="formActionURLALLNhanVien" />
			<form id="form" method="POST" action="<%=formActionURLALLNhanVien.toString()%>"
				name="<portlet:namespace />fm">

				<div class="modal-footer justify-content-center">
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
					</button>
				</div>
			</form>

