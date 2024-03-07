<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%-- nhúng đoạn này vào để thêm giây trong popup --%>
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


				<%-- kết thúc chức năng chấm công  --%>


















				<form id="check-out" class="float-right" action="" method="POST">
					<input type="hidden" name="_token" value=""> <input
						type="hidden" name="ca_lam" value="sang"> <input
						type="hidden" name="capcha" id="capcha">
				</form>




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
			<div class="input-group mb-3 row justify-content-center">
				<form class="form-inline"
					action="https://chamcong.bacninh.gov.vn/gio-lam" id="searchMonth">
					<input type="hidden" name="_token"
						value="Mf1O36nHU1Oett1jj1R0MIW0oCelkz9kI3zPSPGF">
					<div class="input-group">
						<input type="text" class="form-control datepicker"
							name="searchDate" id="searchDate" placeholder="yyyy-mm"
							value="2024-03">
						<div class="input-group-append">
							<span class="input-group-text" id="basic-addon2"><i
								class="fas fa-calendar-alt"></i></span>
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


			<div class="tab-content" id="myTabContent"></div>



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

