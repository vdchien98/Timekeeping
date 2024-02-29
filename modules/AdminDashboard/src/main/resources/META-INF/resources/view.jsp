<%@ include file="/init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
i.fa.fa-user-o {
	font-size: 40px;
}
</style>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Dashboard</h1>

	<div class="row">
		<!-- Nhân viên -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-s font-weight-bold text-primary text-uppercase mb-1">Nhân
								viên</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">50</div>
						</div>
						<div class="col-auto">
							<i class="fa fa-user-o" aria-hidden="true"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Công việc -->
		<!-- <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-s font-weight-bold text-info text-uppercase mb-1">Công việc
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">29</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-clipboard-list fa-2x"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div> -->
	</div>
	<!-- End row -->

	<!-- <div class="row">
        <div class="col-md-6 mb-4">
            <div class="card shadow mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">
                        Công việc
                        <form class="mt-2 pl-2" action="https://chamcong.bacninh.gov.vn/admin/dashboard">
                            <input type="hidden" name="_token" value="f25cJVLTJ7o77YiGgZwzHsaDad5nP3hOirEMtJWr">                            <div class="form-group row">
                                <label class="col-form-label">Năm</label>
                                <input type="text" class="form-control datepicker col-md-3 ml-3" name="year" id="year" placeholder="Năm" value="2024">
                                <label class="col-form-label ml-3">Tháng</label>
                                <input type="text" class="form-control datepicker col-md-3 ml-3" name="month" id="month" placeholder="Tháng" value="">
                                <button type="submit" class="btn btn-success ml-3"><i class="fas fa-search"></i> Tìm kiếm</button>
                            </div>
                        </form>
                    </h6>
                </div>
                <div class="card-body">
                    <div class="row justify-content-center">
                        <span class="text-danger font-weight-bold">Tổng số công việc: <span class="text-info" id="allCongViec">0</span></span>
                    </div>
                    <div class="chart-pie pt-4 pb-2">
                        <canvas id="myPieChart" width="431" height="306" class="chartjs-render-monitor" style="display: block; height: 245px; width: 345px;"></canvas>
                    </div>
                <div class="mt-4 text-center small">
                    <span class="mr-2">
                        <i class="fas fa-circle text-success"></i> Hoàn thành
                    </span>
                    <span class="mr-2">
                        <i class="fas fa-circle text-danger"></i> Hoàn thành chậm
                    </span>
                    <span class="mr-2">
                        <i class="fas fa-circle text-warning"></i> Đang xử lý
                    </span> <br>
                    <span class="mr-2">
                        <i class="fas fa-circle text-info"></i> Đang chờ xác nhận của lãnh đạo
                    </span>
                    <span class="mr-2">
                        <i class="fas fa-circle text-dark"></i> Đang chờ nhận việc của nhân viên
                    </span> <br>
                    <span class="mr-2">
                        <i class="fas fa-circle text-dark text-gray-300"></i> Từ chối xác nhận/ Từ chối tiếp nhận
                    </span>
                </div>
            </div>
        </div>
        </div>
    </div> -->
	<!-- End row -->
</div>