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
 * This class is a wrapper for {@link adminphieudiem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiem
 * @generated
 */
public class adminphieudiemWrapper
	extends BaseModelWrapper<adminphieudiem>
	implements adminphieudiem, ModelWrapper<adminphieudiem> {

	public adminphieudiemWrapper(adminphieudiem adminphieudiem) {
		super(adminphieudiem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("uuid", getUuid());
		attributes.put("user_id", getUser_id());
		attributes.put("nhomcauhoi", getNhomcauhoi());
		attributes.put("noidungcauhoi", getNoidungcauhoi());
		attributes.put("thuocnhomcauhoinao", getThuocnhomcauhoinao());
		attributes.put("diemtoida", getDiemtoida());
		attributes.put("trangthaicauhoi", getTrangthaicauhoi());
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

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String nhomcauhoi = (String)attributes.get("nhomcauhoi");

		if (nhomcauhoi != null) {
			setNhomcauhoi(nhomcauhoi);
		}

		String noidungcauhoi = (String)attributes.get("noidungcauhoi");

		if (noidungcauhoi != null) {
			setNoidungcauhoi(noidungcauhoi);
		}

		Integer thuocnhomcauhoinao = (Integer)attributes.get(
			"thuocnhomcauhoinao");

		if (thuocnhomcauhoinao != null) {
			setThuocnhomcauhoinao(thuocnhomcauhoinao);
		}

		Double diemtoida = (Double)attributes.get("diemtoida");

		if (diemtoida != null) {
			setDiemtoida(diemtoida);
		}

		Long trangthaicauhoi = (Long)attributes.get("trangthaicauhoi");

		if (trangthaicauhoi != null) {
			setTrangthaicauhoi(trangthaicauhoi);
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
	public adminphieudiem cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this adminphieudiem.
	 *
	 * @return the created_at of this adminphieudiem
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the diemtoida of this adminphieudiem.
	 *
	 * @return the diemtoida of this adminphieudiem
	 */
	@Override
	public double getDiemtoida() {
		return model.getDiemtoida();
	}

	/**
	 * Returns the ID of this adminphieudiem.
	 *
	 * @return the ID of this adminphieudiem
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the nhomcauhoi of this adminphieudiem.
	 *
	 * @return the nhomcauhoi of this adminphieudiem
	 */
	@Override
	public String getNhomcauhoi() {
		return model.getNhomcauhoi();
	}

	/**
	 * Returns the noidungcauhoi of this adminphieudiem.
	 *
	 * @return the noidungcauhoi of this adminphieudiem
	 */
	@Override
	public String getNoidungcauhoi() {
		return model.getNoidungcauhoi();
	}

	/**
	 * Returns the primary key of this adminphieudiem.
	 *
	 * @return the primary key of this adminphieudiem
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the thuocnhomcauhoinao of this adminphieudiem.
	 *
	 * @return the thuocnhomcauhoinao of this adminphieudiem
	 */
	@Override
	public int getThuocnhomcauhoinao() {
		return model.getThuocnhomcauhoinao();
	}

	/**
	 * Returns the trangthaicauhoi of this adminphieudiem.
	 *
	 * @return the trangthaicauhoi of this adminphieudiem
	 */
	@Override
	public long getTrangthaicauhoi() {
		return model.getTrangthaicauhoi();
	}

	/**
	 * Returns the updated_at of this adminphieudiem.
	 *
	 * @return the updated_at of this adminphieudiem
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the user_id of this adminphieudiem.
	 *
	 * @return the user_id of this adminphieudiem
	 */
	@Override
	public long getUser_id() {
		return model.getUser_id();
	}

	/**
	 * Returns the uuid of this adminphieudiem.
	 *
	 * @return the uuid of this adminphieudiem
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created_at of this adminphieudiem.
	 *
	 * @param created_at the created_at of this adminphieudiem
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the diemtoida of this adminphieudiem.
	 *
	 * @param diemtoida the diemtoida of this adminphieudiem
	 */
	@Override
	public void setDiemtoida(double diemtoida) {
		model.setDiemtoida(diemtoida);
	}

	/**
	 * Sets the ID of this adminphieudiem.
	 *
	 * @param id the ID of this adminphieudiem
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the nhomcauhoi of this adminphieudiem.
	 *
	 * @param nhomcauhoi the nhomcauhoi of this adminphieudiem
	 */
	@Override
	public void setNhomcauhoi(String nhomcauhoi) {
		model.setNhomcauhoi(nhomcauhoi);
	}

	/**
	 * Sets the noidungcauhoi of this adminphieudiem.
	 *
	 * @param noidungcauhoi the noidungcauhoi of this adminphieudiem
	 */
	@Override
	public void setNoidungcauhoi(String noidungcauhoi) {
		model.setNoidungcauhoi(noidungcauhoi);
	}

	/**
	 * Sets the primary key of this adminphieudiem.
	 *
	 * @param primaryKey the primary key of this adminphieudiem
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the thuocnhomcauhoinao of this adminphieudiem.
	 *
	 * @param thuocnhomcauhoinao the thuocnhomcauhoinao of this adminphieudiem
	 */
	@Override
	public void setThuocnhomcauhoinao(int thuocnhomcauhoinao) {
		model.setThuocnhomcauhoinao(thuocnhomcauhoinao);
	}

	/**
	 * Sets the trangthaicauhoi of this adminphieudiem.
	 *
	 * @param trangthaicauhoi the trangthaicauhoi of this adminphieudiem
	 */
	@Override
	public void setTrangthaicauhoi(long trangthaicauhoi) {
		model.setTrangthaicauhoi(trangthaicauhoi);
	}

	/**
	 * Sets the updated_at of this adminphieudiem.
	 *
	 * @param updated_at the updated_at of this adminphieudiem
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the user_id of this adminphieudiem.
	 *
	 * @param user_id the user_id of this adminphieudiem
	 */
	@Override
	public void setUser_id(long user_id) {
		model.setUser_id(user_id);
	}

	/**
	 * Sets the uuid of this adminphieudiem.
	 *
	 * @param uuid the uuid of this adminphieudiem
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected adminphieudiemWrapper wrap(adminphieudiem adminphieudiem) {
		return new adminphieudiemWrapper(adminphieudiem);
	}

}