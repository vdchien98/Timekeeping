/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.backend.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link tudanhgia}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tudanhgia
 * @generated
 */
public class tudanhgiaWrapper
	extends BaseModelWrapper<tudanhgia>
	implements ModelWrapper<tudanhgia>, tudanhgia {

	public tudanhgiaWrapper(tudanhgia tudanhgia) {
		super(tudanhgia);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("user_id", getUser_id());
		attributes.put("thongtintudanhgia", getThongtintudanhgia());
		attributes.put("ykienkhac", getYkienkhac());
		attributes.put("file_url", getFile_url());
		attributes.put("tongdiem", getTongdiem());
		attributes.put("trangthaixacnhan", getTrangthaixacnhan());
		attributes.put("trangthaikyso", getTrangthaikyso());
		attributes.put("thang", getThang());
		attributes.put("nam", getNam());
		attributes.put("phongban_id", getPhongban_id());
		attributes.put("xeploai", getXeploai());
		attributes.put("created_at", getCreated_at());
		attributes.put("updated_at", getUpdated_at());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String thongtintudanhgia = (String)attributes.get("thongtintudanhgia");

		if (thongtintudanhgia != null) {
			setThongtintudanhgia(thongtintudanhgia);
		}

		String ykienkhac = (String)attributes.get("ykienkhac");

		if (ykienkhac != null) {
			setYkienkhac(ykienkhac);
		}

		String file_url = (String)attributes.get("file_url");

		if (file_url != null) {
			setFile_url(file_url);
		}

		Double tongdiem = (Double)attributes.get("tongdiem");

		if (tongdiem != null) {
			setTongdiem(tongdiem);
		}

		Integer trangthaixacnhan = (Integer)attributes.get("trangthaixacnhan");

		if (trangthaixacnhan != null) {
			setTrangthaixacnhan(trangthaixacnhan);
		}

		Integer trangthaikyso = (Integer)attributes.get("trangthaikyso");

		if (trangthaikyso != null) {
			setTrangthaikyso(trangthaikyso);
		}

		Integer thang = (Integer)attributes.get("thang");

		if (thang != null) {
			setThang(thang);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Long phongban_id = (Long)attributes.get("phongban_id");

		if (phongban_id != null) {
			setPhongban_id(phongban_id);
		}

		String xeploai = (String)attributes.get("xeploai");

		if (xeploai != null) {
			setXeploai(xeploai);
		}

		Date created_at = (Date)attributes.get("created_at");

		if (created_at != null) {
			setCreated_at(created_at);
		}

		Date updated_at = (Date)attributes.get("updated_at");

		if (updated_at != null) {
			setUpdated_at(updated_at);
		}
	}

	@Override
	public tudanhgia cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this tudanhgia.
	 *
	 * @return the created_at of this tudanhgia
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the file_url of this tudanhgia.
	 *
	 * @return the file_url of this tudanhgia
	 */
	@Override
	public String getFile_url() {
		return model.getFile_url();
	}

	/**
	 * Returns the ID of this tudanhgia.
	 *
	 * @return the ID of this tudanhgia
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the nam of this tudanhgia.
	 *
	 * @return the nam of this tudanhgia
	 */
	@Override
	public int getNam() {
		return model.getNam();
	}

	/**
	 * Returns the phongban_id of this tudanhgia.
	 *
	 * @return the phongban_id of this tudanhgia
	 */
	@Override
	public long getPhongban_id() {
		return model.getPhongban_id();
	}

	/**
	 * Returns the primary key of this tudanhgia.
	 *
	 * @return the primary key of this tudanhgia
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the thang of this tudanhgia.
	 *
	 * @return the thang of this tudanhgia
	 */
	@Override
	public int getThang() {
		return model.getThang();
	}

	/**
	 * Returns the thongtintudanhgia of this tudanhgia.
	 *
	 * @return the thongtintudanhgia of this tudanhgia
	 */
	@Override
	public String getThongtintudanhgia() {
		return model.getThongtintudanhgia();
	}

	/**
	 * Returns the tongdiem of this tudanhgia.
	 *
	 * @return the tongdiem of this tudanhgia
	 */
	@Override
	public double getTongdiem() {
		return model.getTongdiem();
	}

	/**
	 * Returns the trangthaikyso of this tudanhgia.
	 *
	 * @return the trangthaikyso of this tudanhgia
	 */
	@Override
	public int getTrangthaikyso() {
		return model.getTrangthaikyso();
	}

	/**
	 * Returns the trangthaixacnhan of this tudanhgia.
	 *
	 * @return the trangthaixacnhan of this tudanhgia
	 */
	@Override
	public int getTrangthaixacnhan() {
		return model.getTrangthaixacnhan();
	}

	/**
	 * Returns the updated_at of this tudanhgia.
	 *
	 * @return the updated_at of this tudanhgia
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the user_id of this tudanhgia.
	 *
	 * @return the user_id of this tudanhgia
	 */
	@Override
	public long getUser_id() {
		return model.getUser_id();
	}

	/**
	 * Returns the xeploai of this tudanhgia.
	 *
	 * @return the xeploai of this tudanhgia
	 */
	@Override
	public String getXeploai() {
		return model.getXeploai();
	}

	/**
	 * Returns the ykienkhac of this tudanhgia.
	 *
	 * @return the ykienkhac of this tudanhgia
	 */
	@Override
	public String getYkienkhac() {
		return model.getYkienkhac();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created_at of this tudanhgia.
	 *
	 * @param created_at the created_at of this tudanhgia
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the file_url of this tudanhgia.
	 *
	 * @param file_url the file_url of this tudanhgia
	 */
	@Override
	public void setFile_url(String file_url) {
		model.setFile_url(file_url);
	}

	/**
	 * Sets the ID of this tudanhgia.
	 *
	 * @param id the ID of this tudanhgia
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the nam of this tudanhgia.
	 *
	 * @param nam the nam of this tudanhgia
	 */
	@Override
	public void setNam(int nam) {
		model.setNam(nam);
	}

	/**
	 * Sets the phongban_id of this tudanhgia.
	 *
	 * @param phongban_id the phongban_id of this tudanhgia
	 */
	@Override
	public void setPhongban_id(long phongban_id) {
		model.setPhongban_id(phongban_id);
	}

	/**
	 * Sets the primary key of this tudanhgia.
	 *
	 * @param primaryKey the primary key of this tudanhgia
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the thang of this tudanhgia.
	 *
	 * @param thang the thang of this tudanhgia
	 */
	@Override
	public void setThang(int thang) {
		model.setThang(thang);
	}

	/**
	 * Sets the thongtintudanhgia of this tudanhgia.
	 *
	 * @param thongtintudanhgia the thongtintudanhgia of this tudanhgia
	 */
	@Override
	public void setThongtintudanhgia(String thongtintudanhgia) {
		model.setThongtintudanhgia(thongtintudanhgia);
	}

	/**
	 * Sets the tongdiem of this tudanhgia.
	 *
	 * @param tongdiem the tongdiem of this tudanhgia
	 */
	@Override
	public void setTongdiem(double tongdiem) {
		model.setTongdiem(tongdiem);
	}

	/**
	 * Sets the trangthaikyso of this tudanhgia.
	 *
	 * @param trangthaikyso the trangthaikyso of this tudanhgia
	 */
	@Override
	public void setTrangthaikyso(int trangthaikyso) {
		model.setTrangthaikyso(trangthaikyso);
	}

	/**
	 * Sets the trangthaixacnhan of this tudanhgia.
	 *
	 * @param trangthaixacnhan the trangthaixacnhan of this tudanhgia
	 */
	@Override
	public void setTrangthaixacnhan(int trangthaixacnhan) {
		model.setTrangthaixacnhan(trangthaixacnhan);
	}

	/**
	 * Sets the updated_at of this tudanhgia.
	 *
	 * @param updated_at the updated_at of this tudanhgia
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the user_id of this tudanhgia.
	 *
	 * @param user_id the user_id of this tudanhgia
	 */
	@Override
	public void setUser_id(long user_id) {
		model.setUser_id(user_id);
	}

	/**
	 * Sets the xeploai of this tudanhgia.
	 *
	 * @param xeploai the xeploai of this tudanhgia
	 */
	@Override
	public void setXeploai(String xeploai) {
		model.setXeploai(xeploai);
	}

	/**
	 * Sets the ykienkhac of this tudanhgia.
	 *
	 * @param ykienkhac the ykienkhac of this tudanhgia
	 */
	@Override
	public void setYkienkhac(String ykienkhac) {
		model.setYkienkhac(ykienkhac);
	}

	@Override
	protected tudanhgiaWrapper wrap(tudanhgia tudanhgia) {
		return new tudanhgiaWrapper(tudanhgia);
	}

}