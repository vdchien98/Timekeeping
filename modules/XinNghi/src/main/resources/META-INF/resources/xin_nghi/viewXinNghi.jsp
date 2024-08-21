<%@page
	import="com.liferay.docs.backend.service.FilekysoLocalServiceUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<script src="${contextPath}/xin_nghi/vgcaplugin.js"></script>


</head>



<style type="text/css">
a.btn.btn-link.mr-2.fileUrl {
	margin-top: -30px;
	margin-left: -15px;
}

button.nutkyso {
	margin-top: 0px;
}

a.btn.btn-link.mr-2.filedSigned {
	margin-left: -15px;
}

.row.thoigian {
	display: contents;
}

th.hanhdong {
	display: flex;
	/* flex-wrap: nowrap; */
	justify-content: space-evenly;
}

span.lanhdaotuchoi {
	color: coral;
}

.button-holder.xinnghistyle {
	margin-left: 20px;
	margin-right: 10px;
	/* background: url(); */
}

.btn-secondary {
	color: #fff;
	background-color: #1cc88a;
	border-color: #85879600;
	margin-left: 16px;
}
</style>
<portlet:renderURL var="xinnghiURL">
	<portlet:param name="mvcPath" value="/xin_nghi/viewXinNghiCaNgay.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="xinnghinuangayURL">
	<portlet:param name="mvcPath" value="/xin_nghi/viewXinNghiNuaNgay.jsp"></portlet:param>
</portlet:renderURL>
<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách xin nghỉ</h4>
		</div>
		<div class="card-body">
			<table>
				<thead>
					<tr>
						<th>Tổng số ngày nghỉ phép trong năm</th>
						<th class="text-danger">12</th>
					</tr>
					<tr>
						<th>Số ngày đã nghỉ phép trong năm</th>
						<th class="text-danger">2</th>
					</tr>
				</thead>
			</table>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<div class="mb-3 row">
						<aui:button-row>
							<aui:button class="custom-button icon-plus"
								onClick="<%=xinnghiURL.toString()%>" value="Xin Nghỉ "></aui:button>
						</aui:button-row>
						<aui:button-row>
							<aui:button iconCssClass="icon-plus"
								onClick="<%=xinnghinuangayURL.toString()%>"
								value="Xin Nghỉ Nửa Ngày "></aui:button>
						</aui:button-row>
					</div>
					<table class="table table-hover" id="dataTable">
						<thead>
							<tr>
								<th style="width: 5%">STT</th>
								<th style="width: 15%">Họ và tên</th>
								<th style="width: 20%">Thời gian</th>
								<th>Lý do</th>
								<th style="width: 10%">Trạng thái</th>
								<th style="width: 12%">Hành động</th>
							</tr>
						</thead>

						<tbody>
							<%-- 
								<portlet:renderURL var="editURL">
									<portlet:param name="id" value="${user.id }" />
									<portlet:param name="mvcPath" value="/home/viewForm.jsp" />
								</portlet:renderURL>
                                --%>


							<c:forEach var="userdanhsach" items="${danhsachXinNghi}"
								varStatus="loop">

								<tr>
									<th>${loop.index + 1}</th>
									<th>
										<div class="row">
											<c:forEach var="hovatennhanvien" items="${hovatennhanviens}">
												<c:if
													test="${userdanhsach.user_id == hovatennhanvien.userId }">
													<span class="text-warning mr-3 fileUrl">
														${hovatennhanvien.hovaten}</span>
												</c:if>
											</c:forEach>
										</div>
									</th>
									<th>
										<div class="row thoigian">

											<c:choose>
												<c:when test="${userdanhsach.trangthai == 1 }">
													<span class="text-info font-weight-bold">Trong Ngày:
														<fmt:formatDate value="${userdanhsach.tu_ngay}"
															pattern="dd/MM/yyyy" />
													</span>
													</br>
												</c:when>
												<c:otherwise>
													<span class="text-info font-weight-bold">Từ Ngày: <fmt:formatDate
															value="${userdanhsach.tu_ngay}" pattern="dd/MM/yyyy" />
													</span>
													</br>

												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${userdanhsach.trangthai == 1 }">
													<c:if test="${userdanhsach.nua_ngay == 1}">
														<span class="text-warning font-weight-bold"> Nghỉ
															buổi sáng </span>
													</c:if>
													<c:if test="${userdanhsach.nua_ngay == 2}">
														<span class="text-warning font-weight-bold"> Nghỉ
															buổi Chiều </span>
													</c:if>
												</c:when>
												<c:otherwise>
													<span class="text-warning font-weight-bold">Đến
														Ngày: <fmt:formatDate value="${userdanhsach.den_ngay}"
															pattern="dd/MM/yyyy" />
													</span>
												</c:otherwise>
											</c:choose>

										</div>
									</th>
									<th>
										<div class="row">
											<span>Lý do : ${userdanhsach.ly_do}</span> <br> <br />
											<%-- <portlet:actionURL var="OpenFilePDFURL" name="OpenFilePDF" /> action="<%=OpenFilePDFURL%>"--%>

											<form id="check_pdf" class="float-right" method="get">
												<input type="hidden" name="p_p_id"
													value="<%=themeDisplay.getPortletDisplay().getId()%>" /> <input
													type="hidden" name="p_p_auth"
													value="<%=AuthTokenUtil.getToken(request, themeDisplay.getPlid(), themeDisplay.getPpid())%>" />
												<input type="hidden"
													name="<portlet:namespace />popupCapchaValue"
													id="popupCapchaValueURL" value="">
											</form>


											<c:choose>
												<c:when test="${userdanhsach.trangthai == 1 }">

												</c:when>
												<c:when test="${userdanhsach.trangthai == 6 }">

												</c:when>
												<c:otherwise>
													<a
														href="http://localhost:8080/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=${userdanhsach.file_url}"
														class="btn btn-link mr-2 fileUrl" onclick=""
														target="_blank"> <span>Xem file xin nghỉ:
															${userdanhsach.file_url}</span>
													</a>
												</c:otherwise>
											</c:choose>



											<c:choose>
												<c:when test="${userdanhsach.trangthai == 7}">
													<span class="lanhdaotuchoi">Lãnh đạo Từ Chối</span>
												</c:when>

												<c:when test="${userdanhsach.trangthai_kyso == 0}">
													<a
														href="http://localhost:8080/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=${userdanhsach.file_url}"
														class="btn btn-link mr-2 filedSigned" onclick=""
														target="_blank"> <span>File Chờ Trưởng Phòng Ký
													</span>
													</a>

													<c:choose>
														<c:when test="${userDangNhap.chucvu_id == 42602}">
															<button class="nutkyso"
																onclick="kysoPdf('${userdanhsach.file_url}', '${userDangNhap.userId}', '${userdanhsach.id}')">Ký
																Số</button>
														</c:when>
													</c:choose>
												</c:when>



												<%-- truong hop trường phòng đã ký đã ký --%>
												<c:when test="${userdanhsach.trangthai_kyso == 1}">
													<c:set var="originalFileUrl"
														value="${userdanhsach.file_url}" />
													<c:set var="fileUrl"
														value="${fn:replace(originalFileUrl, '.pdf', '.signed.pdf')}" />

													<a
														href="http://localhost:8080/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=${fileUrl}"
														class="btn btn-link mr-2 filedSigned" onclick=""
														target="_blank"> <span> File Trưởng Phòng Đã Ký
															Chờ Lãnh Đạo Cơ Quan Ký </span>
													</a>
													<c:choose>
														<c:when
															test="${userDangNhap.chucvu_id == 42604 || userDangNhap.chucvu_id == 42605}">

															<button class="nutkyso"
																onclick="kysoPdf('${fileUrl}', '${userDangNhap.userId}', '${userdanhsach.id}')">Ký
																Số</button>
														</c:when>
													</c:choose>
												</c:when>
												<%-- truong hop lãnh đạo cơ quan đã ký --%>
												<c:when test="${userdanhsach.trangthai_kyso == 2}">
													<c:set var="originalFileUrl"
														value="${userdanhsach.file_url}" />
													<c:set var="fileUrl"
														value="${fn:replace(originalFileUrl, '.pdf', '.signed.signed.pdf')}" />

													<a
														href="http://localhost:8080/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=${fileUrl}"
														class="btn btn-link mr-2 filedSigned" onclick=""
														target="_blank"> <span> File Lãnh Đạo Cơ Quan
															Đã Ký </span>
													</a>

												</c:when>


											</c:choose>
										</div>
									</th>
									<th><c:choose>
											<c:when test="${userdanhsach.trangthai == 7 }">
												<span class="btn btn-danger">Xin nghỉ phép bị Từ Chối
												</span>
											</c:when>
											<c:when test="${userdanhsach.trangthai == 6 }">
												<span class="btn btn-success">Đã xác nhận Trưởng
													Phòng </span>
											</c:when>
											<%-- truong hop truowngr phongf đã ký --%>

											<c:when
												test="${userdanhsach.trangthai_kyso == 0 || userdanhsach.trangthai_kyso ==5}">
												<span class="btn btn-info">Chờ xác nhận của Trưởng
													Phòng</span>
											</c:when>

											<c:when test="${userdanhsach.trangthai == 2}">
												<span class="btn btn-info">Đã xác nhận Trưởng Phòng
													Chờ Lãnh Đạo Cơ Quan Xác Nhận</span>
											</c:when>
											<%-- truong hop lãnh đạo cơ quan đã ký --%>
											<c:when test="${userdanhsach.trangthai == 3}">
												<span class="btn btn-success">Đã xác nhận Lãnh Đạo Cơ
													Quan</span>
											</c:when>


										</c:choose></th>
									<th class="hanhdong"><c:choose>
											<%-- truong hop lãnh đạo cơ quan đã ký --%>





											<c:when
												test="${userdanhsach.trangthai == 2 && userdanhsach.trangthai_kyso !=0 && (userDangNhap.chucvu_id == 42604 || userDangNhap.chucvu_id == 42605 )}">
												<%-- hành động xác nhận  --%>
												<portlet:actionURL name="ChamCongXinnghiCaNgay"
													var="ChamCongXinNghiCaNgayURL" />
												<form id="form" method="POST"
													action="<%=ChamCongXinNghiCaNgayURL.toString()%>"
													name="<portlet:namespace />fm">
													<input type="hidden"
														name="<portlet:namespace />file_id_xinnghi"
														value="${userdanhsach.id}">
													<button type="submit" class="btn btn-success btn-circle"
														onclick="" title="Xác nhận">
														<i class="fa fa-check"></i>
													</button>
												</form>

												<%-- hành động từ chối  --%>
												<portlet:actionURL name="TuChoiChamCongXinNghiCaNgay"
													var="TuChoiChamCongXinNghiCaNgayURL" />
												<form id="form" method="POST"
													action="<%=TuChoiChamCongXinNghiCaNgayURL.toString()%>"
													name="<portlet:namespace />fm">
													<input type="hidden"
														name="<portlet:namespace />file_id_xinnghi"
														value="${userdanhsach.id}">
													<button class="btn btn-secondary btn-circle" type="submit"
														onclick="" title="Không xác nhận">
														<i class="fa fa-times"></i>
													</button>
												</form>

											</c:when>


											<%-- hành động của trưởng phòng--%>


											<c:when
												test="${userdanhsach.trangthai == 1 && userDangNhap.chucvu_id == 42602}">
												<%-- hành động xác nhận  --%>
												<portlet:actionURL name="ChamCongXinnghiNuaNgay"
													var="ChamCongXinnghiNuaNgayURL" />
												<form id="form" method="POST"
													action="<%=ChamCongXinnghiNuaNgayURL.toString()%>"
													name="<portlet:namespace />fm">
													<input type="hidden"
														name="<portlet:namespace />file_id_xinnghi"
														value="${userdanhsach.id}">
													<button type="submit" class="btn btn-success btn-circle"
														onclick="" title="Xác nhận">
														<i class="fa fa-check"></i>
													</button>
												</form>

												<%-- hành động từ chối  --%>
												<portlet:actionURL name="TuChoiChamCongXinNghiCaNgay"
													var="TuChoiChamCongXinNghiCaNgayURL" />
												<form id="form" method="POST"
													action="<%=TuChoiChamCongXinNghiCaNgayURL.toString()%>"
													name="<portlet:namespace />fm">
													<input type="hidden"
														name="<portlet:namespace />file_id_xinnghi"
														value="${userdanhsach.id}">
													<button class="btn btn-secondary btn-circle" type="submit"
														onclick="" title="Không xác nhận">
														<i class="fa fa-times"></i>
													</button>
												</form>
											</c:when>
										</c:choose></th>
								</tr>

							</c:forEach>

						</tbody>
					</table>
					<!-- End tab content -->
				</div>
			</div>
		</div>
	</div>
</div>


<script>
    function loadPdf(fileUrl) {
        var pdfUrl = '/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=' + fileUrl;
        console.log("pdfUrl ------------- "+ pdfUrl);
        window.open(pdfUrl);
    }
    function kysoPdf(fileUrl,user_id, file_id) {
    	 console.log("fileUrl ------------- "+ fileUrl);
    	 console.log("user_id ------------- "+ user_id);
    	 console.log("file_id ------------- "+ file_id);
        var pdfUrl = 'xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_xplm_file_url=' + fileUrl;
        
        console.log("xin chao moi nguoi  --- " + pdfUrl)
        var prms = {};
        var scv = [
	    	  {"Key":"file_id","Value":file_id},
	    	  {"Key":"user_id","Value":user_id},
	    	  {"Key":"fileUrl","Value":fileUrl}
	    	  
	        ];
        prms["FileUploadHandler"] = " http://localhost:8080/api/jsonws/ks.filekyso/getchukyso";
        prms["SessionId"] = "";
        prms["FileName"] = "http://localhost:8080/" + pdfUrl;
        prms["MetaData"] = scv;
        
        
        var json_prms = JSON.stringify(prms);
        console.log("json_prms ------------- "+ json_prms);
        vgca_sign_approved(json_prms); 
       
      
    }
    
    
</script>


