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
 * This class is a wrapper for {@link Tutiengviet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tutiengviet
 * @generated
 */
public class TutiengvietWrapper
	extends BaseModelWrapper<Tutiengviet>
	implements ModelWrapper<Tutiengviet>, Tutiengviet {

	public TutiengvietWrapper(Tutiengviet tutiengviet) {
		super(tutiengviet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tieu_de_tv", getTieu_de_tv());
		attributes.put("tu_tieng_viet", getTu_tieng_viet());
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

		String tieu_de_tv = (String)attributes.get("tieu_de_tv");

		if (tieu_de_tv != null) {
			setTieu_de_tv(tieu_de_tv);
		}

		String tu_tieng_viet = (String)attributes.get("tu_tieng_viet");

		if (tu_tieng_viet != null) {
			setTu_tieng_viet(tu_tieng_viet);
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
	public Tutiengviet cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this tutiengviet.
	 *
	 * @return the created_at of this tutiengviet
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the ID of this tutiengviet.
	 *
	 * @return the ID of this tutiengviet
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this tutiengviet.
	 *
	 * @return the primary key of this tutiengviet
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tieu_de_tv of this tutiengviet.
	 *
	 * @return the tieu_de_tv of this tutiengviet
	 */
	@Override
	public String getTieu_de_tv() {
		return model.getTieu_de_tv();
	}

	/**
	 * Returns the tu_tieng_viet of this tutiengviet.
	 *
	 * @return the tu_tieng_viet of this tutiengviet
	 */
	@Override
	public String getTu_tieng_viet() {
		return model.getTu_tieng_viet();
	}

	/**
	 * Returns the updated_at of this tutiengviet.
	 *
	 * @return the updated_at of this tutiengviet
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
	 * Sets the created_at of this tutiengviet.
	 *
	 * @param created_at the created_at of this tutiengviet
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the ID of this tutiengviet.
	 *
	 * @param id the ID of this tutiengviet
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this tutiengviet.
	 *
	 * @param primaryKey the primary key of this tutiengviet
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tieu_de_tv of this tutiengviet.
	 *
	 * @param tieu_de_tv the tieu_de_tv of this tutiengviet
	 */
	@Override
	public void setTieu_de_tv(String tieu_de_tv) {
		model.setTieu_de_tv(tieu_de_tv);
	}

	/**
	 * Sets the tu_tieng_viet of this tutiengviet.
	 *
	 * @param tu_tieng_viet the tu_tieng_viet of this tutiengviet
	 */
	@Override
	public void setTu_tieng_viet(String tu_tieng_viet) {
		model.setTu_tieng_viet(tu_tieng_viet);
	}

	/**
	 * Sets the updated_at of this tutiengviet.
	 *
	 * @param updated_at the updated_at of this tutiengviet
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	@Override
	protected TutiengvietWrapper wrap(Tutiengviet tutiengviet) {
		return new TutiengvietWrapper(tutiengviet);
	}

}