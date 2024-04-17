<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<style>
.modal-footer.footerXinChamCongRaVao {
	display: flex;
	align-content: center;
	justify-content: center;
}
</style>
<div class="modal-content">
	<div class="modal-header">
		<h5 class="modal-title" id="exampleModalCenterTitle">Xin chấm
			Công Cả Ngày</h5>
	</div>
	<div class="modal-body">
		<portlet:actionURL name="addXinChamCongCaNgay"
			var="addXinChamCongCaNgayURL" />
		<form id="form" method="POST"
			action="<%=addXinChamCongCaNgayURL.toString()%>"
			name="<portlet:namespace />fm">
			<!-- <div class="row"> -->
			<input type="hidden" name="_token"
				value="TQhtuZbsbtdXm89TTl6kKOIT7mdyodAbrDRABl6b">
			<div class="form-group">
				<label for="ngay_lam" class="col-form-label text-md-right">Xin
					chấm công Từ Ngày <span class="text-danger">(*)</span>
				</label>
				<div class="input-group">
					<input type="date" class="form-control"
						name="<portlet:namespace />tu_ngay" id="ngay_lam" value=""
						required="">
				</div>
			</div>
			<div class="form-group">
				<label for="ngay_lam" class="col-form-label text-md-right">Xin
					chấm công Đến Ngày <span class="text-danger">(*)</span>
				</label>
				<div class="input-group">
					<input type="date" class="form-control"
						name="<portlet:namespace />den_ngay" id="ngay_lam" value=""
						required="">
				</div>
			</div>

			<div class="form-group">
				<label for="loai_cham_cong" class="col-form-label text-md-right">Chọn
					lý do <span class="text-danger">(*)</span>
				</label> <select class="form-control"
					name="<portlet:namespace />loai_cham_cong" id="loai_cham_cong"
					required="">
					<option value="">[-- Chọn lý do --]</option>
					<option value="Đi công tác">Đi công tác</option>
					<option value="Đi học tập">Đi học tập</option>
					<option value="Lý do khác">Lý do khác</option>
				</select>
			</div>
			<div class="form-group">
				<label for="ly_do" class="col-form-label text-md-right">Nội
					dung <span class="text-danger">(*)</span>
				</label>
				<div class="input-group">
					<textarea class="form-control" name="<portlet:namespace />ly_do"
						id="ly_do" rows="4" required=""></textarea>
				</div>
			</div>
			<!-- </div> -->
			<div class="modal-footer footerXinChamCongRaVao">
				<button type="button" class="btn btn-secondary">
					<i class="fa fa-window-close"></i> Đóng
				</button>
				<button type="submit" class="btn btn-primary" id="save-form">
					<i class="fa fa-save"></i> Xác nhận
				</button>
			</div>
		</form>
	</div>
</div>