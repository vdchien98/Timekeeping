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

package com.liferay.docs.backend.model.impl;

import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing adminphieudiem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class adminphieudiemCacheModel
	implements CacheModel<adminphieudiem>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof adminphieudiemCacheModel)) {
			return false;
		}

		adminphieudiemCacheModel adminphieudiemCacheModel =
			(adminphieudiemCacheModel)object;

		if (id == adminphieudiemCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", nhomcauhoi=");
		sb.append(nhomcauhoi);
		sb.append(", noidungcauhoi=");
		sb.append(noidungcauhoi);
		sb.append(", thuocnhomcauhoinao=");
		sb.append(thuocnhomcauhoinao);
		sb.append(", diemtoida=");
		sb.append(diemtoida);
		sb.append(", trangthaicauhoi=");
		sb.append(trangthaicauhoi);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public adminphieudiem toEntityModel() {
		adminphieudiemImpl adminphieudiemImpl = new adminphieudiemImpl();

		adminphieudiemImpl.setId(id);

		if (uuid == null) {
			adminphieudiemImpl.setUuid("");
		}
		else {
			adminphieudiemImpl.setUuid(uuid);
		}

		adminphieudiemImpl.setUser_id(user_id);

		if (nhomcauhoi == null) {
			adminphieudiemImpl.setNhomcauhoi("");
		}
		else {
			adminphieudiemImpl.setNhomcauhoi(nhomcauhoi);
		}

		if (noidungcauhoi == null) {
			adminphieudiemImpl.setNoidungcauhoi("");
		}
		else {
			adminphieudiemImpl.setNoidungcauhoi(noidungcauhoi);
		}

		adminphieudiemImpl.setThuocnhomcauhoinao(thuocnhomcauhoinao);
		adminphieudiemImpl.setDiemtoida(diemtoida);
		adminphieudiemImpl.setTrangthaicauhoi(trangthaicauhoi);

		if (created_at == Long.MIN_VALUE) {
			adminphieudiemImpl.setCreated_at(null);
		}
		else {
			adminphieudiemImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			adminphieudiemImpl.setUpdated_at(null);
		}
		else {
			adminphieudiemImpl.setUpdated_at(new Date(updated_at));
		}

		adminphieudiemImpl.resetOriginalValues();

		return adminphieudiemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		uuid = objectInput.readUTF();

		user_id = objectInput.readLong();
		nhomcauhoi = objectInput.readUTF();
		noidungcauhoi = objectInput.readUTF();

		thuocnhomcauhoinao = objectInput.readInt();

		diemtoida = objectInput.readDouble();

		trangthaicauhoi = objectInput.readLong();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(user_id);

		if (nhomcauhoi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nhomcauhoi);
		}

		if (noidungcauhoi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noidungcauhoi);
		}

		objectOutput.writeInt(thuocnhomcauhoinao);

		objectOutput.writeDouble(diemtoida);

		objectOutput.writeLong(trangthaicauhoi);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public String uuid;
	public long user_id;
	public String nhomcauhoi;
	public String noidungcauhoi;
	public int thuocnhomcauhoinao;
	public double diemtoida;
	public long trangthaicauhoi;
	public long created_at;
	public long updated_at;

}