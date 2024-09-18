<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<script src="${contextPath}/phieudiem/vgcaplugin.js"></script>
<style>
/* đây là css Popup mở ra  */
.modal-header.thongbao {
	background: #1d61a9;
	text-align: center;
	color: white;
}

.form-group.Box {
	display: flex;
	margin-bottom: -10px;
	/* flex-direction: row; */
}

i.fa.fa-file-excel-o.iconexcel {
	margin-right: 9px;
}

p.box1 {
	margin-right: 5px;
	font-size: 20px;
	font-weight: 400;
}

div#timer {
	margin-left: 5px;
	font-size: 20px;
	font-weight: bold;
	color: red;
}

p.box3 {
	margin-left: 5px;
	font-size: 20px;
	font-weight: 400;
	font-size: 20px;
}

label.col-form-label.mxn {
	font-size: 20px;
}

.pb-2.chamcongvabaocao {
	display: flex;
	justify-content: space-around;
}

.input-group.mb-3.row.justify-content-center.thangnam {
	/* display: contents; */
	display: flex;
	/* justify-content: space-between; */
	flex-direction: column;
	align-content: center;
	justify-content: center;
}

form#search-year {
	margin-left: -75px;
	padding: 0;
}

.col-auto.chientrophy {
	font-size: 85px;
	color: #fff700;
}

span#hours {
	font-size: 15px;
}

span#min {
	font-size: 15px;
}

span#sec {
	font-size: 15px;
}

.form-group.xeploaidanhgia {
	margin-top: 10px;
}
</style>


<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3 text-center">
			<h4 class="m-0 font-weight-bold text-primary">PHIẾU TỰ XẾP LOẠI
				MỨC ĐỘ HOÀN THÀNH NHIỆM VỤ</h4>
			<%-- Xem gio làm của nhân viên theo tháng và năm --%>

			<div class="input-group mb-3 row justify-content-center thangnam">
				<label class="col-form-label font-weight-bold text-info">Tháng
					: ${monthhienthi} Năm : ${yearhienthi}</label>
				<form class="pl-5 formxemgio" id="search-year" method="get">
					<input type="hidden" name="p_p_id"
						value="<%=themeDisplay.getPortletDisplay().getId()%>" /> <input
						type="hidden" name="p_p_auth"
						value="<%=AuthTokenUtil.getToken(request, themeDisplay.getPlid(), themeDisplay.getPpid())%>" />
					<div class="form-group row">
						<div class="form-group row">
							<input type="hidden" class="" name="<portlet:namespace />thang"
								id="thang" value=""> <input type="text"
								class="form-control datepicker col-md-6 ml-6"
								name="<portlet:namespace />year" id="year" placeholder="Năm"
								value="">
						</div>
					</div>
				</form>
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
												</tr>

											</c:when>
											<c:when test="${cauhoi.thuocnhomcauhoinao == 1}">
												<tr>
													<td class="text-center">${cauhoi.nhomcauhoi}</td>
													<td>${cauhoi.noidungcauhoi}</td>
													<td class="text-center">${cauhoi.diemtoida}</td>
												</tr>
											</c:when>
											<c:when test="${cauhoi.thuocnhomcauhoinao == 8}">
												<tr>
													<td class="text-center">${cauhoi.nhomcauhoi}</td>
													<td>${cauhoi.noidungcauhoi}</td>
													<td class="text-center">${cauhoi.diemtoida}</td>
													<td><input type="number" min="0" readonly=""
														class="form-control chinhtri" onchange="tinhTongDiem()"
														name="<portlet:namespace />${cauhoi.uuid}"
														id="${cauhoi.uuid}" value="${diemchamcongphieuChamdiem}"></td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td class="text-center">${cauhoi.nhomcauhoi}</td>
													<td>${cauhoi.noidungcauhoi}</td>
													<td class="text-center">${cauhoi.diemtoida}</td>
													<c:set var="giatriuuid" value="${cauhoi.uuid}" />
													<c:if test="${trangthaixacnhan == 1}">
														<c:forEach var="cautraloi" items="${danhSachPhieutucham}"
															varStatus="loop">
															<c:choose>
																<c:when test="${cautraloi.UUID  eq giatriuuid}">
																	<td><input type="number" min="0" readonly=""
																		class="form-control chinhtri"
																		name="<portlet:namespace />${cauhoi.uuid}"
																		id="${cauhoi.uuid}" value="${cautraloi.diemcauhoi}"></td>
																</c:when>
															</c:choose>
														</c:forEach>
													</c:if>

													<c:if test="${trangthaixacnhan == 0}">
														<td><input type="number" min="0"
															class="form-control chinhtri" onchange="tinhTongDiem()"
															name="<portlet:namespace />${cauhoi.uuid}"
															id="${cauhoi.uuid}" value=""></td>
													</c:if>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test="${trangthaixacnhan == 1}">

										<tr class="font-weight-bold bg-danger text-white">
											<td></td>
											<td class="text-center">TỔNG</td>
											<td class="text-center">100</td>
											<td><input type="number" min="0" max="100" readonly=""
												class="form-control" name="<portlet:namespace />tong_diem"
												id="tong_diem" value="${cauhoi.tongdiem}"></td>
										</tr>
									</c:if>
									<c:if test="${trangthaixacnhan == 0}">

										<tr class="font-weight-bold bg-danger text-white">
											<td></td>
											<td class="text-center">TỔNG</td>
											<td class="text-center">100</td>
											<td><input type="number" min="0" max="100" readonly=""
												class="form-control" name="<portlet:namespace />tong_diem"
												id="tong_diem" value="0"></td>
										</tr>
									</c:if>
								</tbody>
							</table>
							<%-- readonly="" --%>
							<c:if test="${trangthaixacnhan == 1}">
								<div class="form-group">
									<label for="y_kien" class="col-form-label text-md-right">Các
										ý kiến khác (nếu có)</label>
									<div class="input-group">
										<textarea class="form-control" readonly=""
											name="<portlet:namespace />y_kien" id="y_kien" rows="5">${ykienkhac}</textarea>
									</div>
									<div class="form-group xeploaidanhgia">
										<h5 class="font-weight-bold">
											Mức độ xếp loại hoàn thành nhiệm vụ theo quy chế chi tiêu nội
											bộ: <span class="text-danger">${xeploai}</span>
										</h5>
									</div>
									<div class="form-group">
										<h5>
											Phiếu tự xếp loại mức độ hoàn thành nhiệm vụ: <a
												target="_blank"
												href="http://localhost:8080/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=${URL_file}">
												<i class="fa fa-file-pdf-o" aria-hidden="true"></i> Phiếu tự
												xếp loại
											</a> <a href=""
												onclick="kysoPdf('${URL_file}', '${userId}', '1998')"
												class="btn btn-info"> <i class="fa fa-pencil"
												aria-hidden="true"></i> Ký số
											</a>
										</h5>

										<h5>
											Phiếu tự xếp loại hoàn thành nhiệm vụ đã ký số:
											<c:set var="originalFileUrl" value="${URL_file}" />
											<c:set var="fileUrl"
												value="${fn:replace(originalFileUrl, '.pdf', '.signed.pdf')}" />
											<a target="_blank"
												href="http://localhost:8080/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=${fileUrl}"><i
												class="far fa-file-pdf"></i> Phiếu tự xếp loại đã ký số</a>
										</h5>
									</div>


								</div>

							</c:if>
							<c:if test="${trangthaixacnhan == 0}">
								<div class="form-group">
									<label for="y_kien" class="col-form-label text-md-right">Các
										ý kiến khác (nếu có)</label>
									<div class="input-group">
										<textarea class="form-control"
											name="<portlet:namespace />y_kien" id="y_kien" rows="5"></textarea>
									</div>
								</div>


								<div class="form-group text-center">
									<button type="submit" class="btn btn-primary" id="save-form">
										<i class="fa fa-floppy-o" aria-hidden="true"></i> Xác nhận
									</button>
								</div>
							</c:if>
						</form>
					</div>

				</div>


				<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
					aria-labelledby="profile-tab" tabindex="0">
					<%-- xử lý bảng trưởng phòng  --%>

                    <%-- Xuất báo cáo --%>
					<form id="export-excel" class="float-center"
						action="https://chamcong.bacninh.gov.vn/phieu-diem/export"
						method="GET">
						<input type="hidden" name="_token"
							value="FVwfIO7w2OHYD44wCzVXDrpXp7DG8YgyqePNAKS6"> <input
							type="hidden" name="searchDate" value="2024-09">
						<button type="submit" class="btn btn-success">
							<i class="fas fa-file-excel"></i> Xuất báo cáo
						</button>
					</form>
					<%-- Bảng theo dõi phòng/đơn vị --%>
					<table class="table table-bordered">
						<thead>
							<tr class="text-center bg-info text-white">
								<th rowspan="2" style="width: 3%;">TT</th>
								<th rowspan="2" style="width: 15%;">Họ và tên</th>
								<th colspan="2">Tháng 1</th>
								<th colspan="2">Tháng 2</th>
								<th colspan="2">Tháng 3</th>
								<th colspan="2">Tháng 4</th>
								<th colspan="2">Tháng 5</th>
								<th colspan="2">Tháng 6</th>
								<th colspan="2">Tháng 7</th>
								<th colspan="2">Tháng 8</th>
								<th colspan="2">Tháng 9</th>
								<th colspan="2">Tháng 10</th>
								<th colspan="2">Tháng 11</th>
								<th colspan="2">Tháng 12</th>
							</tr>
							<tr class="text-center bg-info text-white">
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
								<th>Điểm</th>
								<th>XL</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td class="font-weight-bold">Phòng Phần Mềm</td>
							</tr>
							<tr>
								<td class="text-center">1</td>
								<td>Phạm Anh Minh</td>
								<td><a
									href="phieudiem/db0dfaeb58f237a402d2409e30c721ad.pdf"
									target="_blank">96.9</a></td>
								<td><a
									href="phieudiem/db0dfaeb58f237a402d2409e30c721ad.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/a583395244a9301b48f353fbf6b57a22.pdf"
									target="_blank">96.9</a></td>
								<td><a
									href="phieudiem/a583395244a9301b48f353fbf6b57a22.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/ed9253e60cc823b7d3887d57b84f1b6b.signed.pdf"
									target="_blank">96.5</a></td>
								<td><a
									href="phieudiem/ed9253e60cc823b7d3887d57b84f1b6b.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/8a9ff8c319d3c7044ac4667224ae7abd.signed.pdf"
									target="_blank">96.7</a></td>
								<td><a
									href="phieudiem/8a9ff8c319d3c7044ac4667224ae7abd.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/b32e5aae08509461699d342808542c06.signed.pdf"
									target="_blank">96.7</a></td>
								<td><a
									href="phieudiem/b32e5aae08509461699d342808542c06.signed.pdf"
									target="_blank">A</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
							</tr>
							<tr>
								<td class="text-center">2</td>
								<td>Vũ Đăng Chiến</td>
								<td><a
									href="phieudiem/f72ff57057de4d5ecdf2275dcc2e178f.signed.pdf"
									target="_blank">86.9</a></td>
								<td><a
									href="phieudiem/f72ff57057de4d5ecdf2275dcc2e178f.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/8699e22c2993476d717e457410791ab4.signed.pdf"
									target="_blank">86.7</a></td>
								<td><a
									href="phieudiem/8699e22c2993476d717e457410791ab4.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/b4c3f6525306a722eb789240b09bcc34.signed.pdf"
									target="_blank">86.7</a></td>
								<td><a
									href="phieudiem/b4c3f6525306a722eb789240b09bcc34.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/cf7fd49bf012e3b729b4eb42dd0ac617.signed.pdf"
									target="_blank">86.7</a></td>
								<td><a
									href="phieudiem/cf7fd49bf012e3b729b4eb42dd0ac617.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/97fd192afe95c324ad43d3f1d2985456.signed.pdf"
									target="_blank">86.8</a></td>
								<td><a
									href="phieudiem/97fd192afe95c324ad43d3f1d2985456.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/9033fcefc31ca3475839db773a7c2fb9.signed.pdf"
									target="_blank">86.6</a></td>
								<td><a
									href="phieudiem/9033fcefc31ca3475839db773a7c2fb9.signed.pdf"
									target="_blank">A</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
							</tr>
							<tr>
								<td class="text-center">3</td>
								<td>Đinh Minh Đức</td>
								<td><a
									href="phieudiem/901692bb0f752dcf5c3d52e4e07990b7.signed.pdf"
									target="_blank">95.4</a></td>
								<td><a
									href="phieudiem/901692bb0f752dcf5c3d52e4e07990b7.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/075d07912dc00d0e418f9fdc24e174ef.signed.pdf"
									target="_blank">95.6</a></td>
								<td><a
									href="phieudiem/075d07912dc00d0e418f9fdc24e174ef.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/1cea6e113f43984b6defa8944a0ff9c5.signed.pdf"
									target="_blank">95.4</a></td>
								<td><a
									href="phieudiem/1cea6e113f43984b6defa8944a0ff9c5.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/6847432d3732b75f71bd6beb25985476.signed.pdf"
									target="_blank">96.3</a></td>
								<td><a
									href="phieudiem/6847432d3732b75f71bd6beb25985476.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/7fad6198579f6af1131e3f1b7c5cdae8.signed.pdf"
									target="_blank">96.1</a></td>
								<td><a
									href="phieudiem/7fad6198579f6af1131e3f1b7c5cdae8.signed.pdf"
									target="_blank">A</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
							</tr>
							<tr>
								<td class="text-center">4</td>
								<td>Nguyễn Văn Định</td>
								<td><a
									href="phieudiem/8fbdbbe7ada28e17acefd9d0d12c8d2c.pdf"
									target="_blank">96.8</a></td>
								<td><a
									href="phieudiem/8fbdbbe7ada28e17acefd9d0d12c8d2c.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/f69d6b3ac8a108b3ac2bd2de91afbc72.pdf"
									target="_blank">96.8</a></td>
								<td><a
									href="phieudiem/f69d6b3ac8a108b3ac2bd2de91afbc72.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/3e9417960dda82232df6b4902692355f.pdf"
									target="_blank">95.1</a></td>
								<td><a
									href="phieudiem/3e9417960dda82232df6b4902692355f.pdf"
									target="_blank">A</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<td>Ngô Duy Trung</td>
								<td><a
									href="phieudiem/db9129ba8bd255fb89fcd38d46bdc9e6.signed.pdf"
									target="_blank">96.3</a></td>
								<td><a
									href="phieudiem/db9129ba8bd255fb89fcd38d46bdc9e6.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/f1314534141b6aad3698942a6eb29bb5.signed.pdf"
									target="_blank">95.4</a></td>
								<td><a
									href="phieudiem/f1314534141b6aad3698942a6eb29bb5.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/45edf5d5284b8ba5a42ae84385489133.signed.pdf"
									target="_blank">96.4</a></td>
								<td><a
									href="phieudiem/45edf5d5284b8ba5a42ae84385489133.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/69cbe943ca074cc0368af4216a1fdf5f.signed.pdf"
									target="_blank">96.3</a></td>
								<td><a
									href="phieudiem/69cbe943ca074cc0368af4216a1fdf5f.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/b285534bf4067297c3611c0ebfe79cb7.signed.pdf"
									target="_blank">96.4</a></td>
								<td><a
									href="phieudiem/b285534bf4067297c3611c0ebfe79cb7.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/ef805dac143c591ea27b60a90fa528aa.signed.pdf"
									target="_blank">96.2</a></td>
								<td><a
									href="phieudiem/ef805dac143c591ea27b60a90fa528aa.signed.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/ae6e3b889e4bc16a938e3d2fe06f68d8.signed.pdf"
									target="_blank">96.2</a></td>
								<td><a
									href="phieudiem/ae6e3b889e4bc16a938e3d2fe06f68d8.signed.pdf"
									target="_blank">A</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
							</tr>
							<tr>
								<td class="text-center">6</td>
								<td>Vũ Văn Hạnh</td>
								<td><a
									href="phieudiem/875ac905aa409ab5d91a5881e7d6ce22.pdf"
									target="_blank">96.5</a></td>
								<td><a
									href="phieudiem/875ac905aa409ab5d91a5881e7d6ce22.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/3e663ec88996de5a9b49786cd40027df.pdf"
									target="_blank">96.6</a></td>
								<td><a
									href="phieudiem/3e663ec88996de5a9b49786cd40027df.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/ddfa20cfbd589ce1fd9281e88f2aa29d.pdf"
									target="_blank">95.8</a></td>
								<td><a
									href="phieudiem/ddfa20cfbd589ce1fd9281e88f2aa29d.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/5e4f75caa0deda1a73189c0d04ba8268.pdf"
									target="_blank">96</a></td>
								<td><a
									href="phieudiem/5e4f75caa0deda1a73189c0d04ba8268.pdf"
									target="_blank">A</a></td>
								<td><a
									href="phieudiem/cd279aa4a70b89a634e46e7aae386a4a.pdf"
									target="_blank">96.2</a></td>
								<td><a
									href="phieudiem/cd279aa4a70b89a634e46e7aae386a4a.pdf"
									target="_blank">A</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
								<td><a href="" target="_blank">0</a></td>
								<td><a href="" target="_blank">D</a></td>
							</tr>
						</tbody>
					</table>










				</div>

			</div>


		</div>
	</div>
</div>

<script>
	function kysoPdf(fileUrl, user_id, file_id) {
		console.log("fileUrl ------------- " + fileUrl);
		console.log("user_id ------------- " + user_id);
		console.log("file_id ------------- " + file_id);
		var pdfUrl = 'xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url='
				+ fileUrl;

		console.log("xin chao moi nguoi  --- " + pdfUrl)
		var prms = {};
		var scv = [ {
			"Key" : "file_id",
			"Value" : file_id
		}, {
			"Key" : "user_id",
			"Value" : user_id
		}, {
			"Key" : "fileUrl",
			"Value" : fileUrl
		}

		];
		prms["FileUploadHandler"] = " http://localhost:8080/api/jsonws/ks.filekyso/getchukyso";
		prms["SessionId"] = "";
		prms["FileName"] = "http://localhost:8080/" + pdfUrl;
		prms["MetaData"] = scv;

		var json_prms = JSON.stringify(prms);
		console.log("json_prms ------------- " + json_prms);
		vgca_sign_approved(json_prms);

	}
</script>

<script type="text/javascript">
	function tinhTongDiem() {
		let tongDiem = 0;
		// Lấy tất cả các input có class là 'chinhtri'
		document.querySelectorAll('.chinhtri').forEach(function(input) {
			let value = parseFloat(input.value) || 0; // Nếu giá trị là NaN thì mặc định là 0
			tongDiem += value; // Cộng dồn các giá trị
		});

		// Cập nhật giá trị vào ô tổng điểm, giới hạn không vượt quá 100
		tongDiem = Math.min(tongDiem, 100);
		document.getElementById('tong_diem').value = tongDiem;
	}

	// Khởi tạo lần đầu để tính tổng giá trị các input khi trang được load
	document.addEventListener("DOMContentLoaded", function() {
		tinhTongDiem();
	});
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
<script type="text/javascript">
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
			format : "mm/yyyy",
			startView : "months",
			minViewMode : "months"
		}).on('changeDate', function(e) {
			var selectedMonth = e.date.getMonth() + 1; // Tháng được chọn (0-11)
			var selectedYear = e.date.getFullYear(); // Năm được chọn
			console.log("selectedYear " + selectedYear)
			$('#year').val(selectedYear);
			$('#thang').val(selectedMonth);
			$('#search-year').submit();
		});
	});
</script>