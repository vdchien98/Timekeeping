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
 * This class is a wrapper for {@link Filekyso}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Filekyso
 * @generated
 */
public class FilekysoWrapper
	extends BaseModelWrapper<Filekyso>
	implements Filekyso, ModelWrapper<Filekyso> {

	public FilekysoWrapper(Filekyso filekyso) {
		super(filekyso);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("file_id_nosigned", getFile_id_nosigned());
		attributes.put("trangthai", getTrangthai());
		attributes.put("fileurl_signed", getFileurl_signed());
		attributes.put("nguoilamdon_id", getNguoilamdon_id());
		attributes.put("nguoikydon_id", getNguoikydon_id());
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

		Long file_id_nosigned = (Long)attributes.get("file_id_nosigned");

		if (file_id_nosigned != null) {
			setFile_id_nosigned(file_id_nosigned);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		String fileurl_signed = (String)attributes.get("fileurl_signed");

		if (fileurl_signed != null) {
			setFileurl_signed(fileurl_signed);
		}

		Long nguoilamdon_id = (Long)attributes.get("nguoilamdon_id");

		if (nguoilamdon_id != null) {
			setNguoilamdon_id(nguoilamdon_id);
		}

		Long nguoikydon_id = (Long)attributes.get("nguoikydon_id");

		if (nguoikydon_id != null) {
			setNguoikydon_id(nguoikydon_id);
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
	public Filekyso cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this filekyso.
	 *
	 * @return the created_at of this filekyso
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the file_id_nosigned of this filekyso.
	 *
	 * @return the file_id_nosigned of this filekyso
	 */
	@Override
	public long getFile_id_nosigned() {
		return model.getFile_id_nosigned();
	}

	/**
	 * Returns the fileurl_signed of this filekyso.
	 *
	 * @return the fileurl_signed of this filekyso
	 */
	@Override
	public String getFileurl_signed() {
		return model.getFileurl_signed();
	}

	/**
	 * Returns the ID of this filekyso.
	 *
	 * @return the ID of this filekyso
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the nguoikydon_id of this filekyso.
	 *
	 * @return the nguoikydon_id of this filekyso
	 */
	@Override
	public long getNguoikydon_id() {
		return model.getNguoikydon_id();
	}

	/**
	 * Returns the nguoilamdon_id of this filekyso.
	 *
	 * @return the nguoilamdon_id of this filekyso
	 */
	@Override
	public long getNguoilamdon_id() {
		return model.getNguoilamdon_id();
	}

	/**
	 * Returns the primary key of this filekyso.
	 *
	 * @return the primary key of this filekyso
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trangthai of this filekyso.
	 *
	 * @return the trangthai of this filekyso
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this filekyso.
	 *
	 * @return the updated_at of this filekyso
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created_at of this filekyso.
	 *
	 * @param created_at the created_at of this filekyso
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the file_id_nosigned of this filekyso.
	 *
	 * @param file_id_nosigned the file_id_nosigned of this filekyso
	 */
	@Override
	public void setFile_id_nosigned(long file_id_nosigned) {
		model.setFile_id_nosigned(file_id_nosigned);
	}

	/**
	 * Sets the fileurl_signed of this filekyso.
	 *
	 * @param fileurl_signed the fileurl_signed of this filekyso
	 */
	@Override
	public void setFileurl_signed(String fileurl_signed) {
		model.setFileurl_signed(fileurl_signed);
	}

	/**
	 * Sets the ID of this filekyso.
	 *
	 * @param id the ID of this filekyso
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the nguoikydon_id of this filekyso.
	 *
	 * @param nguoikydon_id the nguoikydon_id of this filekyso
	 */
	@Override
	public void setNguoikydon_id(long nguoikydon_id) {
		model.setNguoikydon_id(nguoikydon_id);
	}

	/**
	 * Sets the nguoilamdon_id of this filekyso.
	 *
	 * @param nguoilamdon_id the nguoilamdon_id of this filekyso
	 */
	@Override
	public void setNguoilamdon_id(long nguoilamdon_id) {
		model.setNguoilamdon_id(nguoilamdon_id);
	}

	/**
	 * Sets the primary key of this filekyso.
	 *
	 * @param primaryKey the primary key of this filekyso
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trangthai of this filekyso.
	 *
	 * @param trangthai the trangthai of this filekyso
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this filekyso.
	 *
	 * @param updated_at the updated_at of this filekyso
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	@Override
	protected FilekysoWrapper wrap(Filekyso filekyso) {
		return new FilekysoWrapper(filekyso);
	}

}