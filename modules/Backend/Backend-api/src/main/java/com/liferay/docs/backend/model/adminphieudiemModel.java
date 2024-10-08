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
 * The base model interface for the adminphieudiem service. Represents a row in the &quot;Timekeeping_adminphieudiem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.backend.model.impl.adminphieudiemModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.backend.model.impl.adminphieudiemImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiem
 * @generated
 */
@ProviderType
public interface adminphieudiemModel extends BaseModel<adminphieudiem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a adminphieudiem model instance should use the {@link adminphieudiem} interface instead.
	 */

	/**
	 * Returns the primary key of this adminphieudiem.
	 *
	 * @return the primary key of this adminphieudiem
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this adminphieudiem.
	 *
	 * @param primaryKey the primary key of this adminphieudiem
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this adminphieudiem.
	 *
	 * @return the ID of this adminphieudiem
	 */
	public int getId();

	/**
	 * Sets the ID of this adminphieudiem.
	 *
	 * @param id the ID of this adminphieudiem
	 */
	public void setId(int id);

	/**
	 * Returns the uuid of this adminphieudiem.
	 *
	 * @return the uuid of this adminphieudiem
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this adminphieudiem.
	 *
	 * @param uuid the uuid of this adminphieudiem
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the user_id of this adminphieudiem.
	 *
	 * @return the user_id of this adminphieudiem
	 */
	public long getUser_id();

	/**
	 * Sets the user_id of this adminphieudiem.
	 *
	 * @param user_id the user_id of this adminphieudiem
	 */
	public void setUser_id(long user_id);

	/**
	 * Returns the nhomcauhoi of this adminphieudiem.
	 *
	 * @return the nhomcauhoi of this adminphieudiem
	 */
	@AutoEscape
	public String getNhomcauhoi();

	/**
	 * Sets the nhomcauhoi of this adminphieudiem.
	 *
	 * @param nhomcauhoi the nhomcauhoi of this adminphieudiem
	 */
	public void setNhomcauhoi(String nhomcauhoi);

	/**
	 * Returns the noidungcauhoi of this adminphieudiem.
	 *
	 * @return the noidungcauhoi of this adminphieudiem
	 */
	@AutoEscape
	public String getNoidungcauhoi();

	/**
	 * Sets the noidungcauhoi of this adminphieudiem.
	 *
	 * @param noidungcauhoi the noidungcauhoi of this adminphieudiem
	 */
	public void setNoidungcauhoi(String noidungcauhoi);

	/**
	 * Returns the thuocnhomcauhoinao of this adminphieudiem.
	 *
	 * @return the thuocnhomcauhoinao of this adminphieudiem
	 */
	public int getThuocnhomcauhoinao();

	/**
	 * Sets the thuocnhomcauhoinao of this adminphieudiem.
	 *
	 * @param thuocnhomcauhoinao the thuocnhomcauhoinao of this adminphieudiem
	 */
	public void setThuocnhomcauhoinao(int thuocnhomcauhoinao);

	/**
	 * Returns the diemtoida of this adminphieudiem.
	 *
	 * @return the diemtoida of this adminphieudiem
	 */
	public double getDiemtoida();

	/**
	 * Sets the diemtoida of this adminphieudiem.
	 *
	 * @param diemtoida the diemtoida of this adminphieudiem
	 */
	public void setDiemtoida(double diemtoida);

	/**
	 * Returns the trangthaicauhoi of this adminphieudiem.
	 *
	 * @return the trangthaicauhoi of this adminphieudiem
	 */
	public long getTrangthaicauhoi();

	/**
	 * Sets the trangthaicauhoi of this adminphieudiem.
	 *
	 * @param trangthaicauhoi the trangthaicauhoi of this adminphieudiem
	 */
	public void setTrangthaicauhoi(long trangthaicauhoi);

	/**
	 * Returns the created_at of this adminphieudiem.
	 *
	 * @return the created_at of this adminphieudiem
	 */
	public Date getCreated_at();

	/**
	 * Sets the created_at of this adminphieudiem.
	 *
	 * @param created_at the created_at of this adminphieudiem
	 */
	public void setCreated_at(Date created_at);

	/**
	 * Returns the updated_at of this adminphieudiem.
	 *
	 * @return the updated_at of this adminphieudiem
	 */
	public Date getUpdated_at();

	/**
	 * Sets the updated_at of this adminphieudiem.
	 *
	 * @param updated_at the updated_at of this adminphieudiem
	 */
	public void setUpdated_at(Date updated_at);

	@Override
	public adminphieudiem cloneWithOriginalValues();

}