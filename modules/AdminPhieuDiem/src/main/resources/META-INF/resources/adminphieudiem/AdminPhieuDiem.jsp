<%@page import="java.util.Date"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.thongsocauhoi {
	width: 50%;
	display: flex;
}

.form-group.noidungcauhoi {
	width: 50%;
}

.thongtintongquat {
	margin-bottom: 30px;
}
</style>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><script
	src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<div class="card-header py-3 text-center">
	<h4 class="m-0 font-weight-bold text-primary">CẤU HÌNH PHIẾU TỰ
		XẾP LOẠI MỨC ĐỘ HOÀN THÀNH NHIỆM VỤ</h4>
</div>
<div class="card-body">
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="phieuxeploainhanvien"
			role="tabpanel" aria-labelledby="phieuxeploainhanvien-tab">
			<h5 class="font-weight-bold">Nhập thông tin câu hỏi</h5>
			<div class="thongtintongquat">
				<portlet:actionURL name="LuuThongTinCauHoi"
					var="ActionThongTinPhieuDiemURL" />
				<form id="form" method="POST"
					action="<%=ActionThongTinPhieuDiemURL.toString()%>"
					name="<portlet:namespace />fm">
					<div class="form-group noidungcauhoi">
						<label for="exampleInputEmail1">Câu hỏi</label>
						<textarea type="text" class="form-control"
							name="<portlet:namespace />noidungcauhoi" id="noidungInput"
							placeholder="Nội dung câu hỏi "></textarea>
					</div>
					<div class="thongsocauhoi">
						<div class="form-group nhomcauhoi">
							<label class="form-label" for="typeNumber">Mục câu hỏi </label> <input
								type="text" name="<portlet:namespace />nhomcauhoi"
								pattern="^\d+(\.\d+)*$" min="0" step="any" id="typeNumber"
								class="form-control" />
						</div>
						<div class="form-group diemtoida">
							<label class="form-label" for="typeNumber">Điểm tối đa
								câu hỏi </label> <input type="number"
								name="<portlet:namespace />diemcauhoi" min="1" step="any"
								id="typeNumber" class="form-control" />
						</div>
						<%-- 
						<div class="form-group thuocnhomcauhoinao">
							<label class="form-label" for="typeNumber">Thuộc nhóm câu
								hỏi </label> <input type="text"
								name="<portlet:namespace />thuocnhomcauhoinao"
								pattern="^\d+(\.\d+)*$" min="0" step="any" id="typeNumber"
								class="form-control" />
						</div>
						 --%>
					</div>


					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div></div>



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
					<c:forEach var="cauhoi" items="${danhsachcauhoi}" varStatus="loop">
						<c:choose>
							<c:when test="${cauhoi.thuocnhomcauhoinao == 0}">
								<tr class="font-weight-bold bg-warning text-white">
									<td class="text-center">${cauhoi.nhomcauhoi}</td>
									<td>${cauhoi.noidungcauhoi}</td>
									<td class="text-center">${cauhoi.diemtoida}</td>
									<td><input type="number" min="0" max="9" readonly=""
										class="form-control tong" name="chinhtri" id="chinhtri"
										value="0"></td>
								</tr>

							</c:when>
							<c:when test="${cauhoi.thuocnhomcauhoinao == 1}">
								<tr>
									<td class="text-center">${cauhoi.nhomcauhoi}</td>
									<td>${cauhoi.noidungcauhoi}</td>
									<td class="text-center">${cauhoi.diemtoida}</td>
									<td><input type="number" min="0" max="" readonly=""
										class="form-control tong" name="chinhtri" id="chinhtri"
										value="0"></td>
								</tr>

							</c:when>
							<c:otherwise>
								<tr>
									<td class="text-center">${cauhoi.nhomcauhoi}</td>
									<td>${cauhoi.noidungcauhoi}</td>
									<td class="text-center">${cauhoi.diemtoida}</td>
									<td><input type="number" min="0" max="3"
										class="form-control chinhtri" name="chinhtri_1"
										id="chinhtri_1" value="0"></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
				</tbody>
			</table>


		</div>
	</div>
	<!-- end form -->
</div>
