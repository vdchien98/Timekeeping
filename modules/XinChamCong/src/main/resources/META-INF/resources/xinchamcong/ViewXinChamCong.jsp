
<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Link jQuery và Bootstrap JS -->

<style>
.mt-2\,.mb-2.xinchamcongngay {
	display: flex;
}

.mt-2\,.mb-2.xinchamcongnuangay {
	margin-right: 20px;
}
</style>

<portlet:renderURL var="xinchamcongURL">
	<portlet:param name="mvcPath"
		value="/xinchamcong/viewXinChamCongVaoRa.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="xinchamcongNuaNgayURL">
	<portlet:param name="mvcPath"
		value="/xinchamcong/xinchamcongNuaNgay.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="xinchamcongCaNgayURL">
	<portlet:param name="mvcPath"
		value="/xinchamcong/xinchamcongCaNgay.jsp"></portlet:param>
</portlet:renderURL>
<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách xin chấm
				công</h4>
		</div>
		<div class="card-body">
			<ul class="nav nav-tabs mb-2" id="myTab" role="tablist">

				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home-tab-pane" type="button" role="tab"
						aria-controls="home-tab-pane" aria-selected="true">Xin
						chấm công vào/ra</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile-tab-pane" type="button" role="tab"
						aria-controls="profile-tab-pane" aria-selected="false">Xin
						chấm công nửa ngày/cả ngày</button>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home-tab-pane"
					role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					<div class="mt-2, mb-2">
						<a class="btn btn-info text-white" href="${xinchamcongURL}"><i
							class="fa fa-check-square"></i> Xin chấm công vào/ra</a>
					</div>
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
									id="dataTable" role="grid" aria-describedby="dataTable_info">
									<thead>
										<tr role="row">
											<th class="sorting_asc" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="STT: activate to sort column descending"
												style="width: 42px;">STT</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Họ và tên: activate to sort column ascending"
												style="width: 137px;">Họ và tên</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Thời gian: activate to sort column ascending"
												style="width: 198px;">Thời gian</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Lý do: activate to sort column ascending"
												style="width: 480px;">Lý do</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Họ và tên người xác nhận: activate to sort column ascending"
												style="width: 327px;">Họ và tên người xác nhận</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Trạng thái: activate to sort column ascending"
												style="width: 129px;">Trạng thái</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Hành động: activate to sort column ascending"
												style="width: 102px;">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="xinchamcong" items="${ListXinChamCong}"
											varStatus="loop">
											<tr role="row" class="odd">
												<td class="sorting_1">${loop.index + 1}</td>
												<td class="font-weight-bold"><c:forEach var="user"
														items="${ListUsers}">
														<c:if test="${user.userId == xinchamcong.user_id}">
															<span class="text-warning mr-3"> ${user.hovaten}</span>
														</c:if>
													</c:forEach></td>
												<td><span class="font-weight-bold text-info">Ngày:
														<fmt:formatDate value="${xinchamcong.ngay_lam}"
															pattern="dd/MM/yyyy" />
												</span> <br> <span class="text-warning mr-3"> Ca làm:
														${xinchamcong.ca_lam}</span> <br> <c:choose>
														<c:when test="${ not empty xinchamcong.check_in}">
															<span class="font-weight-bold text-danger">Giờ
																chấm công: ${xinchamcong.check_in}</span>
														</c:when>
														<c:when test="${not empty xinchamcong.check_out }">
															<span class="font-weight-bold text-danger">Giờ
																chấm công: ${xinchamcong.check_out}</span>
														</c:when>
													</c:choose></td>
												<td>${xinchamcong.ly_do}</td>
												<td class="font-weight-bold"><c:forEach var="user"
														items="${ListUsers}">
														<c:choose>
															<c:when test="${user.userId == xinchamcong.user_id}">
																<c:choose>
																	<c:when test="${user.chucvu_id == 42601}">
																		<span>Người xác nhận: ${Phutrach.hovaten}</span>
																		<br>
																	</c:when>
																	<c:otherwise>
																		<span>Người xác nhận: ${GiamDoc.hovaten}</span>
																		<br>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose>
													</c:forEach> <span></span></td>
												<td><c:forEach var="user" items="${ListUsers}">
														<c:choose>
															<c:when test="${user.userId == xinchamcong.user_id}">
																<c:choose>
																	<c:when test="${user.chucvu_id == 42601}">

																		<c:if test="${xinchamcong.trangthai ==0 }">
																			<button type="button" class="btn btn-info">Chờ
																				Trưởng Phòng Đã Xác Nhận</button>
																		</c:if>
																		<c:if test="${xinchamcong.trangthai ==1 }">
																			<button type="button" class="btn btn-success">Trưởng
																				Phòng Đã Xác Nhận</button>
																		</c:if>
																		<c:if test="${xinchamcong.trangthai == 5 }">
																			<button type="button" class="btn btn-danger">Trưởng
																				Phòng Từ Chối</button>
																		</c:if>
																		<br>
																	</c:when>
																	<c:otherwise>
																		<c:if test="${xinchamcong.trangthai ==0 }">
																			<button type="button" class="btn btn-info">Chờ
																				Lãnh Đạo Đã Xác Nhận</button>
																		</c:if>
																		<c:if test="${xinchamcong.trangthai ==1 }">
																			<button type="button" class="btn btn-success">Lãnh
																				Đạo Đã Xác Nhận</button>
																		</c:if>
																		<c:if test="${xinchamcong.trangthai == 5 }">
																			<button type="button" class="btn btn-danger">Lãnh
																				Đạo Từ Chối</button>
																		</c:if>

																		<br>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose>
													</c:forEach></td>
												<td><c:forEach var="user" items="${ListUsers}">
														<c:choose>
															<c:when test="${user.userId == xinchamcong.user_id}">
																<c:choose>
																	<c:when test="${userdangnhap.chucvu_id == 42602}">
																		<c:choose>
																			<c:when
																				test="${user.chucvu_id == 42601 && xinchamcong.trangthai == 0 }">
																				<portlet:actionURL
																					name="actionDongYXinChamCongVaoRaTruongPhong"
																					var="actionDongYXinChamCongVaoRaTruongPhongURL" />
																				<form id="form" method="POST"
																					action="<%=actionDongYXinChamCongVaoRaTruongPhongURL.toString()%>"
																					name="<portlet:namespace />fm">
																					<button type="submit" class="btn btn-success"
																						onclick="">
																						<i class="fa fa-check"></i> Xác nhận
																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>
																				<portlet:actionURL
																					name="actionTuChoiXinChamCongVaoRaTruongPhong"
																					var="actionTuChoiXinChamCongVaoRaTruongPhongURL" />
																				<form id="form" method="POST"
																					action="<%=actionTuChoiXinChamCongVaoRaTruongPhongURL.toString()%>"
																					name="<portlet:namespace />fm">

																					<button class="btn btn-light mt-1" type="submit"
																						data-toggle="tooltip" title="Từ chối" onclick="">
																						<i class="fa fa-times-circle"></i> Từ chối

																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>

																			</c:when>

																		</c:choose>
																	</c:when>
																	<c:when test="${userdangnhap.chucvu_id == 42604}">
																		<c:choose>
																			<c:when test="${user.chucvu_id == 42601}">
																			</c:when>
																			<c:when test="${xinchamcong.trangthai == 0  }">
																				<portlet:actionURL
																					name="actionDongYXinChamCongVaoRaTruongPhong"
																					var="actionDongYXinChamCongVaoRaTruongPhongURL" />
																				<form id="form" method="POST"
																					action="<%=actionDongYXinChamCongVaoRaTruongPhongURL.toString()%>"
																					name="<portlet:namespace />fm">
																					<button type="submit" class="btn btn-success"
																						onclick="">
																						<i class="fa fa-check"></i> Xác nhận
																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>
																				<portlet:actionURL
																					name="actionTuChoiXinChamCongVaoRaTruongPhong"
																					var="actionTuChoiXinChamCongVaoRaTruongPhongURL" />
																				<form id="form" method="POST"
																					action="<%=actionTuChoiXinChamCongVaoRaTruongPhongURL.toString()%>"
																					name="<portlet:namespace />fm">

																					<button class="btn btn-light mt-1" type="submit"
																						data-toggle="tooltip" title="Từ chối" onclick="">
																						<i class="fa fa-times-circle"></i> Từ chối

																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>
																			</c:when>
																		</c:choose>
																	</c:when>
																</c:choose>
															</c:when>
														</c:choose>
													</c:forEach></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status"
									aria-live="polite">Hiển thị 1 đến 10 của 11 kết quả</div>
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
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="#" aria-controls="dataTable" data-dt-idx="3"
											tabindex="0" class="page-link">Tiếp</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

				</div>







				<%-- xin chấm công nửa ngày  --%>
				<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
					aria-labelledby="profile-tab" tabindex="0">
					<div class="mt-2, mb-2 xinchamcongngay">
						<div class="mt-2, mb-2 xinchamcongnuangay">
							<a class="btn btn-info text-white"
								href="${xinchamcongNuaNgayURL}"><i
								class="fa fa-check-square"></i> Nửa Ngày</a>
						</div>
						<div class="mt-2, mb-2">
							<a class="btn btn-success text-white"
								href="${xinchamcongCaNgayURL}"><i class="fa fa-check-square"></i>
								Cả Ngày</a>
						</div>


					</div>
					<div id="dataTable1_wrapper"
						class="dataTables_wrapper dt-bootstrap4 no-footer">
						<div class="row">
							<div class="col-sm-12 col-md-6">
								<div class="dataTables_length" id="dataTable1_length">
									<label>Hiển thị <select name="dataTable1_length"
										aria-controls="dataTable1"
										class="custom-select custom-select-sm form-control form-control-sm"><option
												value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option></select> kết quả
									</label>
								</div>
							</div>
							<div class="col-sm-12 col-md-6">
								<div id="dataTable1_filter" class="dataTables_filter">
									<label>Tìm kiếm:<input type="search"
										class="form-control form-control-sm" placeholder=""
										aria-controls="dataTable1"></label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-hover dataTable no-footer"
									id="dataTable1" role="grid" aria-describedby="dataTable1_info">
									<thead>
										<tr role="row">
											<th style="width: 5px;" class="sorting_asc" tabindex="0"
												aria-controls="dataTable1" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="STT: activate to sort column descending">STT</th>
											<th style="width: 15px;" class="sorting" tabindex="0"
												aria-controls="dataTable1" rowspan="1" colspan="1"
												aria-label="Họ và tên: activate to sort column ascending">Họ
												và tên</th>
											<th style="width: 20px;" class="sorting" tabindex="0"
												aria-controls="dataTable1" rowspan="1" colspan="1"
												aria-label="Thời gian: activate to sort column ascending">Thời
												gian</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable1"
												rowspan="1" colspan="1"
												aria-label="Lý do: activate to sort column ascending"
												style="width: 0px;">Lý do</th>
											<th style="width: 10px;" class="sorting" tabindex="0"
												aria-controls="dataTable1" rowspan="1" colspan="1"
												aria-label="Trạng thái: activate to sort column ascending">Trạng
												thái</th>
											<th style="width: 12px;" class="sorting" tabindex="0"
												aria-controls="dataTable1" rowspan="1" colspan="1"
												aria-label="Hành động: activate to sort column ascending">Hành
												động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="xinchamcong"
											items="${ListXinChamCongNuaNgayCaNgay}" varStatus="loop">
											<tr role="row" class="odd">
												<td class="sorting_1">${loop.index+ 1}</td>
												<td class="font-weight-bold"><c:forEach var="user"
														items="${ListUsers}">
														<c:if test="${user.userId == xinchamcong.user_id}">
															<span class="text-warning mr-3"> ${user.hovaten}</span>
														</c:if>
													</c:forEach></td>

												<td><span class="font-weight-bold text-info">Từ
														Ngày: <fmt:formatDate value="${xinchamcong.tu_ngay}"
															pattern="dd/MM/yyyy" />
												</span> <br> <span class="font-weight-bold text-info">Đến
														Ngày: <fmt:formatDate value="${xinchamcong.den_ngay}"
															pattern="dd/MM/yyyy" />
												</span></td>
												<td><span class="font-weight-bold">${xinchamcong.chon_ly_do}:
												</span> ${xinchamcong.ly_do}<br></td>
												<td><c:forEach var="user" items="${ListUsers}">
														<c:choose>
															<c:when test="${user.userId == xinchamcong.user_id}">
																<c:choose>
																	<c:when test="${user.chucvu_id == 42601}">
																		<c:choose>
																		    <c:when
																				test="${xinchamcong.ca_lam !=null && xinchamcong.trangthai == 1 }">
																				<button type="button" class="btn btn-success">
																					Lãnh Đạo Xác Nhận</button>
																			</c:when>
																			  <c:when
																				test="${xinchamcong.ca_lam !=null && xinchamcong.trangthai == 5 }">
																				<button type="button" class="btn btn-danger">
																					Lãnh Đạo Từ Chối</button>
																			</c:when>
																			<c:when
																				test="${xinchamcong.tu_ngay !=null && xinchamcong.den_ngay !=null }">
																				<button type="button" class="btn btn-info">Chờ
																					Lãnh Đạo Xác Nhận</button>
																			</c:when>
																			<c:when test="${xinchamcong.trangthai ==0 }">
																				<button type="button" class="btn btn-info">Chờ
																					Trưởng Phòng Xác Nhận</button>
																			</c:when>
																			<c:when test="${xinchamcong.trangthai ==1 }">
																				<button type="button" class="btn btn-success">Trưởng
																					Phòng Đã Xác Nhận</button>
																			</c:when>
																			<c:when test="${xinchamcong.trangthai == 5 }">
																				<button type="button" class="btn btn-danger">Trưởng
																					Phòng Từ Chối</button>
																			</c:when>

																		</c:choose>


																		<br>
																	</c:when>
																	<c:otherwise>
																		<c:if test="${xinchamcong.trangthai ==0 }">
																			<button type="button" class="btn btn-info">Chờ
																				Lãnh Đạo Xác Nhận</button>
																		</c:if>
																		<c:if test="${xinchamcong.trangthai ==1 }">
																			<button type="button" class="btn btn-success">Lãnh
																				Đạo Đã Xác Nhận</button>
																		</c:if>
																		<c:if test="${xinchamcong.trangthai == 5 }">
																			<button type="button" class="btn btn-danger">Lãnh
																				Đạo Từ Chối</button>
																		</c:if>

																		<br>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose>
													</c:forEach></td>
												<td><c:forEach var="user" items="${ListUsers}">
														<c:choose>
															<c:when test="${user.userId == xinchamcong.user_id}">
																<c:choose>
																	<c:when test="${userdangnhap.chucvu_id == 42602}">
																		<c:choose>
																			<c:when
																				test="${user.chucvu_id == 42601 && xinchamcong.trangthai == 0 && xinchamcong.tu_ngay == null && xinchamcong.den_ngay == null}">
																				<portlet:actionURL name="actionDongYXinChamCongCaNgayNuaNgay"
																					var="actionDongYXinChamCongCaNgayNuaNgayURL" />
																				<form id="form" method="POST"
																					action="<%=actionDongYXinChamCongCaNgayNuaNgayURL.toString()%>"
																					name="<portlet:namespace />fm">
																					<button type="submit" class="btn btn-success"
																						onclick="">
																						<i class="fa fa-check"></i> Xác nhận
																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>
																				<portlet:actionURL name="actionTuChoiXinChamCongCaNgayNuaNgay"
																					var="actionTuChoiXinChamCongCaNgayNuaNgayURL" />
																				<form id="form" method="POST"
																					action="<%=actionTuChoiXinChamCongCaNgayNuaNgayURL.toString()%>"
																					name="<portlet:namespace />fm">

																					<button class="btn btn-light mt-1" type="submit"
																						data-toggle="tooltip" title="Từ chối" onclick="">
																						<i class="fa fa-times-circle"></i> Từ chối

																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>

																			</c:when>

																		</c:choose>
																	</c:when>
																	<c:when test="${userdangnhap.chucvu_id == 42604}">
																		<c:choose>
																			<c:when test="${xinchamcong.trangthai == 0 }">
																				<portlet:actionURL name="actionDongYXinChamCongCaNgayNuaNgayGiamDoc"
																					var="actionDongYXinChamNuaNgayCaNgayGiamDocURL" />
																				<form id="form" method="POST"
																					action="<%=actionDongYXinChamNuaNgayCaNgayGiamDocURL.toString()%>"
																					name="<portlet:namespace />fm">
																					<button type="submit" class="btn btn-success"
																						onclick="">
																						<i class="fa fa-check"></i> Xác nhận
																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>
																				<portlet:actionURL name="actionTuChoiXinChamCongCaNgayNuaNgay"
																					var="actionTuChoiXinChamNuaNgayCaNgayTruongPhongURL" />
																				<form id="form" method="POST"
																					action="<%=actionTuChoiXinChamNuaNgayCaNgayTruongPhongURL.toString()%>"
																					name="<portlet:namespace />fm">

																					<button class="btn btn-light mt-1" type="submit"
																						data-toggle="tooltip" title="Từ chối" onclick="">
																						<i class="fa fa-times-circle"></i> Từ chối

																					</button>
																					<input type="hidden"
																						name="<portlet:namespace />id_xinchamcong"
																						value="${xinchamcong.id}"> <input
																						type="hidden" name="_token" value="">
																				</form>
																			</c:when>
																		</c:choose>
																	</c:when>
																</c:choose>
															</c:when>
														</c:choose>
													</c:forEach></td>

											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable1_info" role="status"
									aria-live="polite">Hiển thị 1 đến 1 của 1 kết quả</div>
							</div>
							<div class="col-sm-12 col-md-7">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTable1_paginate">
									<ul class="pagination">
										<li class="paginate_button page-item previous disabled"
											id="dataTable1_previous"><a href="#"
											aria-controls="dataTable1" data-dt-idx="0" tabindex="0"
											class="page-link">Quay lại</a></li>
										<li class="paginate_button page-item active"><a href="#"
											aria-controls="dataTable1" data-dt-idx="1" tabindex="0"
											class="page-link">1</a></li>
										<li class="paginate_button page-item next disabled"
											id="dataTable1_next"><a href="#"
											aria-controls="dataTable1" data-dt-idx="2" tabindex="0"
											class="page-link">Tiếp</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- End tab content -->

		</div>
	</div>
</div>


<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
