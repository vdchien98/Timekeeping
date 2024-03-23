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
<%-- 
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.0/css/dataTables.bootstrap4.css">
 --%>

<style>
span.text-info.mr-3.chucvu {
	margin-left: 10px;
}

.dt-length label {
	display: none;
}

.iconnhanvien {
	font-size: initial;
}

.styleChucVuHome {
	margin-left: 11px;
	margin-right: 10px;
}

i.fa.fa-user-circle-o {
	font-size: 20px;
	color: #2a838d;
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
							<div class="col-sm-12">
								<table id="example" class="table table-striped table-bordered"
									style="width: 100%">
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
												<th class="sorting_1">${loop.index +1 }</th>
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
														<c:set var="lamcatoi" value="${user.ca_lam_toi}" />
														<c:set var="chamcongngoai" value="${user.cham_cong_ngoai}" />
														<span class="mr-3">Tên đăng nhập: </span>${user.email}
														<c:choose>
															<c:when test="${lamcatoi == 1}">
																<span class="ml-5 text-info">Có làm ca tối </span>
															</c:when>
															<c:when test="${lamcatoi == 0}">
																<span class="ml-5 text-info"></span>
															</c:when>
														</c:choose>
														<c:choose>
															<c:when test="${chamcongngoai == 1}">
																<span class="ml-5 text-info">Có chấm công ngoài </span>
															</c:when>
															<c:when test="${chamcongngoai == 0}">
																<span class="ml-5 text-info"></span>
															</c:when>
														</c:choose>
													</div>
													<div class="row">
														<span class="mr-3">Số ngày nghỉ phép trong năm: </span><span
															class="text-danger">12</span>
													</div>

												</th>
												<th><c:set var="trangthai" value="${user.trangthai}" />
													<c:choose>

														<c:when test="${trangthai == 1}">
															<span class="btn btn-success btn-sm">Hoạt động</span></th>
												</c:when>
												<c:when test="${trangthai == 0}">
													<span class="btn btn-light btn-sm">Không Hoạt động</span>
													</th>
												</c:when>

												</c:choose>

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

					</div>
				</div>
			</div>
		</div>
	</div>
</div>






<%-- 
<portlet:actionURL name="addAllNhanVien" var="formActionURLALLNhanVien" />
<form id="form" method="POST"
	action="<%=formActionURLALLNhanVien.toString()%>"
	name="<portlet:namespace />fm">

	<div class="modal-footer justify-content-center">
		<button type="submit" class="btn btn-primary">
			<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
		</button>
	</div>
</form>

 --%>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/2.0.0/js/dataTables.js"></script>
<script
	src="https://cdn.datatables.net/2.0.0/js/dataTables.bootstrap4.js"></script>
<script>
	new DataTable('#example');
</script>




