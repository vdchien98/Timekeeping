<%@ include file="/init.jsp"%>

<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị nhân viên</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Thêm mới nhân viên
			</h4>
		</div>
		<div class="card-body">
			<form id="form" method="POST"
				action="https://chamcong.bacninh.gov.vn/admin/nhan-vien">
				<input type="hidden" name="_token"
					value="NPKgd9Na3cdKPMnwp5Rh7lUTgFi87gmEAXAUvsxA">
				<div class="modal-body">
					<div class="form-group row mt-4">
						<label for="hovaten" class="col-form-label text-md-left col-md-2">Họ
							và tên <span class="text-danger">(*)</span>
						</label> <input id="hovaten" type="text" class="form-control col-md-9"
							name="hovaten" required="" autofocus=""
							placeholder="Nhập họ và tên" value="">
					</div>
					<div class="form-group row mt-4">
						<label for="email" class="col-form-label text-md-left col-md-2">Email
							đăng nhập <span class="text-danger">(*)</span>
						</label> <input id="email" type="text" class="form-control col-md-9"
							name="email" required="" autofocus=""
							placeholder="Nhập email đăng nhập" value="">
					</div>
					<div class="form-group row mt-4">
						<label for="zalo_id" class="col-form-label text-md-left col-md-2">Zalo
							id ( Số Điện thoại ) <span class="text-danger">(*)</span>
						</label> <input id="zalo_id" type="text" class="form-control col-md-9"
							name="zalo_id" autofocus="" placeholder="Nhập zalo id" value="">
					</div>
					<div class="form-group row mt-4">
						<label for="chucvu_id"
							class="col-form-label text-md-left col-md-2">Chức vụ <span
							class="text-danger">(*)</span></label> <select
							class="custom-select col-md-6" id="chucvu_id" name="chucvu_id"
							required="">
							<option value="">[-- Chọn chức vụ --]</option>
							<option value="1">Giám đốc</option>
							<option value="2">Phó giám đốc</option>
							<option value="3">Trưởng phòng</option>
							<option value="4">Phó trưởng phòng</option>
							<option value="6">Viên chức</option>
						</select>
					</div>
					<div class="form-group row mt-4">
						<label for="phongban_id"
							class="col-form-label text-md-left col-md-2">Phòng/ban <span
							class="text-danger">(*)</span></label> <select
							class="custom-select col-md-6" id="phongban_id"
							name="phongban_id" required="">
							<option value="">[-- Chọn phòng/ban --]</option>
							<option value="1">Phòng Phần Mềm</option>
							<option value="2">Phòng Truyền Thông</option>
							<option value="3">Phòng Hạ Tầng</option>
							<option value="6">Phòng Hành Chính - Tổng Hợp</option>
							<option value="12">Phòng Nghiệp vụ</option>
							<option value="13">Phòng Dịch Vụ</option>
							<option value="14">Lãnh Đạo Cơ Quan</option>
						</select>
					</div>
					<div class="form-group row mt-4">
						<label for="ca_lam_id"
							class="col-form-label text-md-left col-md-2">Ca làm việc
							<span class="text-danger">(*)</span>
						</label> <select class="custom-select col-md-6" id="ca_lam_id"
							name="ca_lam_id" required="">
							<option value="1">Giờ hành chính</option>
						</select>
					</div>
					<div class="form-group row mt-4">
						<label for="so_ngay_nghi_phep"
							class="col-form-label text-md-left col-md-2">Số ngày nghỉ
							phép trong năm <span class="text-danger">(*)</span>
						</label> <input id="so_ngay_nghi_phep" type="number"
							class="form-control col-md-2" name="so_ngay_nghi_phep"
							placeholder="Nhập số ngày nghỉ phép trong năm" value="">
					</div>
					<div class="form-group row mt-4 ml-5">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" name="trangthai" value="1"
								class="custom-control-input" id="trangthai"> <label
								class="custom-control-label" for="trangthai">Hoạt động</label>
						</div>
						<div class="custom-control custom-checkbox ml-5">
							<input type="checkbox" name="ca_lam_toi" value="1"
								class="custom-control-input" id="ca_lam_toi"> <label
								class="custom-control-label" for="ca_lam_toi">Làm ca tối</label>
						</div>
						<div class="custom-control custom-checkbox ml-5">
							<input type="checkbox" name="cham_cong_ngoai" value="1"
								class="custom-control-input" id="cham_cong_ngoai"> <label
								class="custom-control-label" for="cham_cong_ngoai">Chấm
								công ngoài</label>
						</div>
						<div class="custom-control custom-checkbox ml-5">
							<input type="checkbox" name="phu_trach_phong" value="1"
								class="custom-control-input" id="phu_trach_phong"> <label
								class="custom-control-label" for="phu_trach_phong">Phụ
								trách phòng</label>
						</div>
					</div>
				</div>
				<div class="modal-footer justify-content-center">
					<a href="https://chamcong.bacninh.gov.vn/admin/nhan-vien"
						class="btn btn-light"><i class="fa fa-arrow-left"
						aria-hidden="true"></i> Quay lại </a>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
