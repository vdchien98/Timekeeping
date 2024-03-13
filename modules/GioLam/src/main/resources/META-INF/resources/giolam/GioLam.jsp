<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
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



<%-- nhúng đoạn này vào để thêm giây trong popup
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous"></script>
 --%>



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
</style>


<%-- 
	// height: 100vh;
	 //font-size: 10vmin; --%>

<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4
				class="m-0 font-weight-bold text-primary text-uppercase text-center">
				Bảng giờ làm tháng 3 năm 2024 <span
					class="btn btn-danger text-white" style="font-size: 60%;"> <a><span
						class="badge ngay">Ngày 4/3 </span></a> <a><span
						class="badge hours">09</span></a> : <a><span class="badge min">54</span></a>
					: <a><span class="badge sec">41</span></a>
				</span>
			</h4>
		</div>
		<div class="card-body">
			<div class="pb-2">
				<form id="check-in" class="float-right"
					action="{{ route('user.gio-lam.checkin') }}" method="POST">

				</form>


				<%-- xử lý chức năng chấm công  --%>


				<c:choose>
					<c:when test="${Chamcongsang == true}">
						<button type="button" class="btn btn-success custom-modal"
							onclick="guimazalochamcong(${userId})" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo">
							<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công
							vào buổi sáng
						</button>
					</c:when>
					<c:when test="${Chamcongrasang == true}">
						<button type="button" class="btn btn-danger custom-modal"
							onclick="guimazalochamcong(${userId})" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo">
							<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công
							ra buổi sáng
						</button>
					</c:when>
					<c:when test="${Chamcongchieu == true}">
						<button type="button" class="btn btn-success custom-modal"
							onclick="guimazalochamcong(${userId})" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo">
							<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công
							vào buổi chiều
						</button>
					</c:when>
					<c:when test="${Chamcongrachieu == true}">
						<button type="button" class="btn btn-danger custom-modal"
							onclick="guimazalochamcong(${userId})" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo">
							<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công
							ra buổi chiều
						</button>
					</c:when>
					<c:when test="${khongchamcong == true}">
						<button type="button" class="btn btn-success custom-modal hide">
							Không phải giờ chấm công</button>
					</c:when>
					<c:otherwise>
						<!-- Code nếu không có điều kiện nào đúng -->
					</c:otherwise>
				</c:choose>

				<%-- Thực Hiện chức năng gửi Zalo về máy  --%>
				<portlet:actionURL var="sendMaZaloURL" name="sendMaZalo" />
				<form id="check-in" class="float-right" action="<%=sendMaZaloURL%>"
					method="POST"></form>
				<form id="check-out" class="float-right" action="" method="POST">
				</form>



				<%-- Xác thực về mã zalo về máy --%>

				<portlet:actionURL name="ActionChamCong" var="ActionChamCong" />
				<form id="form" method="POST"
					action="<%=ActionChamCong.toString()%>"
					name="<portlet:namespace />fm">
					<div id="myModal" class="modal fade">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header thongbao">
									<h5 class="modal-title" id="exampleModalLongTitle">Thông
										Báo</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<span class="modal-title">Bạn có muốn chắc chắn chấm
										công vào/ra ?? </span>
									<div class="form-group Box">
										<p class="box1">Thời gian nhập mã xác nhận</p>
										<div class="box2" id="timer"></div>
										<p class="box3">giây</p>
									</div>

									<div class="form-group">
										<label for="recipient-name" class="col-form-label mxn">Nhập
											mã xác nhận </label> <input type="number" class="form-control"
											id="recipient-name" name="<portlet:namespace />maxacthuc">
									</div>

								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-danger">Gửi Mã</button>
								</div>
							</div>
						</div>
					</div>


				</form>

				<form id="check-out" class="float-right" action="" method="POST">
					<input type="hidden" name="_token" value=""> <input
						type="hidden" name="ca_lam" value="sang"> <input
						type="hidden" name="capcha" id="capcha">
				</form>

				<%-- kết thúc chức năng chấm công  --%>

				<%-- báo cáo tháng chưa xử lý --%>
				<form id="export-excel" class="float-right"
					action="https://chamcong.bacninh.gov.vn/export-xep-loai"
					method="GET">
					<input type="hidden" name="_token"
						value="Mf1O36nHU1Oett1jj1R0MIW0oCelkz9kI3zPSPGF"> <input
						type="hidden" name="user_id" value="22"> <input
						type="hidden" name="searchDate" value="2024-03">
					<button type="submit" class="btn btn-info">
						<i class="fas fa-file-excel"></i> Báo cáo tháng
					</button>
				</form>
			</div>



			<%-- thực hiện hiển thị giờ làm của user  --%>




			<%-- Xem gio làm của nhân viên theo tháng và năm  --%>

			<div class="input-group mb-3 row justify-content-center">
				<form class="pl-5" id="search-year" method="get">
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







			<div class="row mb-3 ">
				<span class="btn btn-success">Đúng giờ</span> <span
					class="btn btn-warning">Đi muộn/Về sớm</span> <span
					class="btn btn-secondary">Không chấm công vào/ra</span> <span
					class="btn btn-primary">Nghỉ phép/Nghỉ lễ</span> <span
					class="btn btn-info">Xin chấm công</span> <span
					class="btn btn-danger">Nghỉ không phép</span> <span
					class="btn btn-light">M: số lần đi muộn, S: số lần về sớm</span>
			</div>
			<ul class="nav nav-tabs mb-2" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link text-dark active"
					id="home-tab" data-toggle="tab" href="#home" role="tab"
					aria-controls="home" aria-selected="true">Chấm công của tôi</a></li>
				<li class="nav-item"><a class="nav-link text-dark"
					id="profile-tab" data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">Chấm công của
						phòng/đơn vị</a></li>
			</ul>

			<%--  --%>

			<div class="tab-content" id="myTabContent">
				<table class="table table-bordered">
					<thead>
						<tr class="text-center text-white">
							<th style="padding: 0;" class="bg-info">T2</th>
							<th style="padding: 0;" class="bg-info">T3</th>
							<th style="padding: 0;" class="bg-info">T4</th>
							<th style="padding: 0;" class="bg-info">T5</th>
							<th style="padding: 0;" class="bg-info">T6</th>
							<th style="padding: 0;" class="bg-warning">T7</th>
							<th style="padding: 0;" class="bg-warning">CN</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}"
							varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							<c:choose>
								<c:when test="${NgayTrongThang == null}">
									<td class="text-center" style="padding: 0;"></td>
								</c:when>
								<c:when test="${NgayTrongThang != null}">
									<c:set var="cophaingayNghi"
										value="${NgayTrongThang.get('cophaingayNghi')}" />
									<c:set var="calamsang"
										value="${NgayTrongThang.get('calamsang')}" />
									<c:set var="calamchieu"
										value="${NgayTrongThang.get('calamchieu')}" />
									<c:set var="CoPhaiThu7orChuNhat"
										value="${NgayTrongThang.get('CoPhaiThu7orChuNhat')}" />
									<td class="text-center"
										style="margin: 1px; padding-left: 4px; padding-right: 4px;">
										${NgayTrongThang.get("ngay_lam_trongthang")} <br> <c:choose>
											<c:when test="${cophaingayNghi == true}">
												<div class="bg-primary border" style="height: 10px">&nbsp;</div>
												<div class="bg-primary border" style="height: 10px">&nbsp;</div>
											</c:when>
											<c:when test="${CoPhaiThu7orChuNhat == true}">
												<div class="text-center" style="padding: 0;"></div>
												<div class="text-center" style="padding: 0;"></div>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${calamsang == 1}">
														<div class="bg-success border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Ca sáng <br> Giờ vào: 07:38:32 | Giờ ra: 11:15:00">&nbsp;</div>
													</c:when>
													<c:when test="${calamsang == 2}">
														<div class="bg-secondary border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Ca sáng <br> Giờ vào: 07:07:29 | Giờ ra: ">&nbsp;</div>
													</c:when>
													<c:when test="${calamsang == 3}">
														<div class="bg-warning border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Ca sáng <br> Giờ vào: 07:45:21 | Giờ ra: 11:15:00">&nbsp;</div>
													</c:when>
													<c:when test="${calamsang == 4}">
														<div class="bg-danger border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Nghỉ không phép">&nbsp;</div>
													</c:when>
													<c:when test="${calamsang == 0}">
														<div class="text-center" style="padding: 0;"></div>
													</c:when>
													<c:otherwise>
														<div class="text-center" style="padding: 0;"></div>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${calamchieu == 1}">

														<div class="bg-success border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Ca sáng <br> Giờ vào: 07:38:32 | Giờ ra: 11:15:00">&nbsp;</div>
													</c:when>
													<c:when test="${calamchieu == 2}">
														<div class="bg-secondary border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Ca sáng <br> Giờ vào: 07:07:29 | Giờ ra: ">&nbsp;</div>
													</c:when>
													<c:when test="${calamchieu == 3}">
														<div class="bg-warning border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Ca sáng <br> Giờ vào: 07:45:21 | Giờ ra: 11:15:00">&nbsp;</div>
													</c:when>
													<c:when test="${calamchieu == 4}">
														<div class="bg-danger border" style="height: 10px"
															data-toggle="tooltip" data-html="true" title=""
															data-original-title="Nghỉ không phép">&nbsp;</div>
													</c:when>
													<c:when test="${calamchieu == 0}">
														<div class="text-center" style="padding: 0;"></div>
													</c:when>
													<c:otherwise>
														<div class="text-center" style="padding: 0;"></div>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</td>
								</c:when>
								<c:otherwise>
									<td style="padding: 0;">${NgayTrongThang}</td>
								</c:otherwise>
							</c:choose>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>

					</tbody>
				</table>



			</div>




























			<!-- Hiển thị box điểm và phần trăm -->
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card border-left-info shadow h-100 py-2">
						<div class="card-body">
							<div class="row ml-2">
								<strong>Điểm hiện tại của tháng: <span
									class="text-danger">5</span></strong>
							</div>
							<div class="row ml-2">
								<strong>Điểm tối đa của tháng: <span
									class="text-danger">84</span></strong>
							</div>
							<div class="row ml-2">
								<strong>Xếp loại hiện tại của bạn: <span
									class="text-danger">D</span></strong>
							</div>
							<div class="row no-gutters align-items-center">
								<div class="col mr-2">
									<div class="text-info text-uppercase">
										<i class="fas fa-running fa-2x"></i> <span
											class="font-weight-bold">Cố lên nào !!!</span>
									</div>
									<div class="row no-gutters align-items-center">
										<div class="col-auto">
											<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">6%</div>
										</div>
										<div class="col">
											<div class="progress progress-sm mr-2">
												<div class="progress-bar bg-info" role="progressbar"
													style="width: 6%" aria-valuenow="6" aria-valuemin="0"
													aria-valuemax="100"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-auto">
									<i class="fas fa-trophy fa-2x text-warning"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End box điểm và phần trăm -->
			<!-- End tab content -->
		</div>
	</div>
</div>
<script>
!(function($){
	$.fn.datepicker.dates['vi'] = {
		days: ["Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy", "Chủ nhật"],
		daysShort: ["CN", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "CN"],
		daysMin: ["CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN"],
		months: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
		monthsShort: ["Th1", "Th2", "Th3", "Th4", "Th5", "Th6", "Th7", "Th8", "Th9", "Th10", "Th11", "Th12"],
		today: "Hôm nay",
		clear: "Xóa",
		format: "dd/mm/yyyy"
	};
}(jQuery));
$(document).ready(function() {
	  $('.datepicker').datepicker({
	    language: 'vi',
	    format: "mm/yyyy",
		startView : "months",
		minViewMode : "months"
	  }).on('changeDate', function(e) {
		  var selectedMonth = e.date.getMonth()+1; // Tháng được chọn (0-11)
		    var selectedYear = e.date.getFullYear(); // Năm được chọn
		    console.log("selectedYear "+selectedYear)
		    $('#year').val(selectedYear);
		    $('#thang').val(selectedMonth);
		    $('#search-year').submit();
	  });
	});
</script>



<script>
$(function() {
	var time_out;
	 $('.custom-modal').click(function(e) {
	      e.preventDefault();
	      var mymodal = $('#myModal');
	      mymodal.modal('show');
	      var time_limit = 30;
	      var timerElement = $('#timer');

	      time_out = setInterval(() => {
	        if (time_limit == 0) {
	          clearInterval(time_out);
	          mymodal.modal('hide');
	        } else {
	          if (time_limit < 10) {
	            time_limit = '0' + time_limit;
	          }
	          timerElement.html(time_limit);
	          time_limit -= 1;
	        }
	      }, 1000);
	    });

	    $('#myModal').on('hidden.bs.modal', function() {
	      clearInterval(time_out); // Dừng đếm ngược khi modal ẩn
	      time_limit = 30; // Đặt lại giá trị của time_limit về giá trị ban đầu
	     //location.reload(); // Load lại trang sau khi modal được ẩn
	    });
	  });
</script>
<script>
function guimazalochamcong(userId) {
	console.log("userId la "+ userId);
	sendMaZaloAndConfirmCheckin(userId);
}
function sendMaZaloAndConfirmCheckin(userId) {
	//	console.log("userId ########33333333333 "+ userId);
	//	console.log("trangthai ########33333333333 "+ trangthai);
	    sendMaZalo()
	      .then(function(response) {
	        // Xử lý phản hồi    từ hàm sendMaZalo nếu cần
	        
	        // Gọi hàm confirmCheckin
	      //  confirmCheckin(userId);
	        setTimeout(function() {
	            confirmCheckin(userId);
	          }, 100); // 30000 milliseconds = 30 seconds
	      })
	      .catch(function(error) {
	        console.log(error);
	      });
	  }
function sendMaZalo() {
    return fetch('<%=sendMaZaloURL%>', {
      method: 'POST',
      body: JSON.stringify({}),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(function(response) {
        if (response.ok) {
          return response.text();
        }
        throw new Error('Lỗi khi gửi yêu cầu đến hàm sendMaZalo');
      });
  }

</script>

