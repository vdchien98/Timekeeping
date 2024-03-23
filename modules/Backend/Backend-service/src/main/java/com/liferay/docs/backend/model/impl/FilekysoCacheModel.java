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

import com.liferay.docs.backend.model.Filekyso;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Filekyso in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FilekysoCacheModel
	implements CacheModel<Filekyso>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FilekysoCacheModel)) {
			return false;
		}

		FilekysoCacheModel filekysoCacheModel = (FilekysoCacheModel)object;

		if (id == filekysoCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", file_id_nosigned=");
		sb.append(file_id_nosigned);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", fileurl_signed=");
		sb.append(fileurl_signed);
		sb.append(", nguoilamdon_id=");
		sb.append(nguoilamdon_id);
		sb.append(", nguoikydon_id=");
		sb.append(nguoikydon_id);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Filekyso toEntityModel() {
		FilekysoImpl filekysoImpl = new FilekysoImpl();

		filekysoImpl.setId(id);
		filekysoImpl.setFile_id_nosigned(file_id_nosigned);
		filekysoImpl.setTrangthai(trangthai);

		if (fileurl_signed == null) {
			filekysoImpl.setFileurl_signed("");
		}
		else {
			filekysoImpl.setFileurl_signed(fileurl_signed);
		}

		filekysoImpl.setNguoilamdon_id(nguoilamdon_id);
		filekysoImpl.setNguoikydon_id(nguoikydon_id);

		if (created_at == Long.MIN_VALUE) {
			filekysoImpl.setCreated_at(null);
		}
		else {
			filekysoImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			filekysoImpl.setUpdated_at(null);
		}
		else {
			filekysoImpl.setUpdated_at(new Date(updated_at));
		}

		filekysoImpl.resetOriginalValues();

		return filekysoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		file_id_nosigned = objectInput.readLong();

		trangthai = objectInput.readInt();
		fileurl_signed = objectInput.readUTF();

		nguoilamdon_id = objectInput.readLong();

		nguoikydon_id = objectInput.readLong();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeLong(file_id_nosigned);

		objectOutput.writeInt(trangthai);

		if (fileurl_signed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileurl_signed);
		}

		objectOutput.writeLong(nguoilamdon_id);

		objectOutput.writeLong(nguoikydon_id);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public long file_id_nosigned;
	public int trangthai;
	public String fileurl_signed;
	public long nguoilamdon_id;
	public long nguoikydon_id;
	public long created_at;
	public long updated_at;

}