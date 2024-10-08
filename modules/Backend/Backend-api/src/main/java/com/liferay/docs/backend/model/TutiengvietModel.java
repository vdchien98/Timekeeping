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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Tutiengviet service. Represents a row in the &quot;Timekeeping_Tutiengviet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.backend.model.impl.TutiengvietModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.backend.model.impl.TutiengvietImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tutiengviet
 * @generated
 */
@ProviderType
public interface TutiengvietModel extends BaseModel<Tutiengviet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tutiengviet model instance should use the {@link Tutiengviet} interface instead.
	 */

	/**
	 * Returns the primary key of this tutiengviet.
	 *
	 * @return the primary key of this tutiengviet
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this tutiengviet.
	 *
	 * @param primaryKey the primary key of this tutiengviet
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this tutiengviet.
	 *
	 * @return the ID of this tutiengviet
	 */
	public int getId();

	/**
	 * Sets the ID of this tutiengviet.
	 *
	 * @param id the ID of this tutiengviet
	 */
	public void setId(int id);

	/**
	 * Returns the tieu_de_tv of this tutiengviet.
	 *
	 * @return the tieu_de_tv of this tutiengviet
	 */
	@AutoEscape
	public String getTieu_de_tv();

	/**
	 * Sets the tieu_de_tv of this tutiengviet.
	 *
	 * @param tieu_de_tv the tieu_de_tv of this tutiengviet
	 */
	public void setTieu_de_tv(String tieu_de_tv);

	/**
	 * Returns the tu_tieng_viet of this tutiengviet.
	 *
	 * @return the tu_tieng_viet of this tutiengviet
	 */
	@AutoEscape
	public String getTu_tieng_viet();

	/**
	 * Sets the tu_tieng_viet of this tutiengviet.
	 *
	 * @param tu_tieng_viet the tu_tieng_viet of this tutiengviet
	 */
	public void setTu_tieng_viet(String tu_tieng_viet);

	/**
	 * Returns the created_at of this tutiengviet.
	 *
	 * @return the created_at of this tutiengviet
	 */
	public Date getCreated_at();

	/**
	 * Sets the created_at of this tutiengviet.
	 *
	 * @param created_at the created_at of this tutiengviet
	 */
	public void setCreated_at(Date created_at);

	/**
	 * Returns the updated_at of this tutiengviet.
	 *
	 * @return the updated_at of this tutiengviet
	 */
	public Date getUpdated_at();

	/**
	 * Sets the updated_at of this tutiengviet.
	 *
	 * @param updated_at the updated_at of this tutiengviet
	 */
	public void setUpdated_at(Date updated_at);

	@Override
	public Tutiengviet cloneWithOriginalValues();

}