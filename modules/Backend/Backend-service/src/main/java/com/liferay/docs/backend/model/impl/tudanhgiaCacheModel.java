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

import com.liferay.docs.backend.model.tudanhgia;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing tudanhgia in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class tudanhgiaCacheModel
	implements CacheModel<tudanhgia>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof tudanhgiaCacheModel)) {
			return false;
		}

		tudanhgiaCacheModel tudanhgiaCacheModel = (tudanhgiaCacheModel)object;

		if (id == tudanhgiaCacheModel.id) {
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
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", thongtintudanhgia=");
		sb.append(thongtintudanhgia);
		sb.append(", ykienkhac=");
		sb.append(ykienkhac);
		sb.append(", file_url=");
		sb.append(file_url);
		sb.append(", tongdiem=");
		sb.append(tongdiem);
		sb.append(", trangthaixacnhan=");
		sb.append(trangthaixacnhan);
		sb.append(", trangthaikyso=");
		sb.append(trangthaikyso);
		sb.append(", thang=");
		sb.append(thang);
		sb.append(", nam=");
		sb.append(nam);
		sb.append(", phongban_id=");
		sb.append(phongban_id);
		sb.append(", xeploai=");
		sb.append(xeploai);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public tudanhgia toEntityModel() {
		tudanhgiaImpl tudanhgiaImpl = new tudanhgiaImpl();

		tudanhgiaImpl.setId(id);
		tudanhgiaImpl.setUser_id(user_id);

		if (thongtintudanhgia == null) {
			tudanhgiaImpl.setThongtintudanhgia("");
		}
		else {
			tudanhgiaImpl.setThongtintudanhgia(thongtintudanhgia);
		}

		if (ykienkhac == null) {
			tudanhgiaImpl.setYkienkhac("");
		}
		else {
			tudanhgiaImpl.setYkienkhac(ykienkhac);
		}

		if (file_url == null) {
			tudanhgiaImpl.setFile_url("");
		}
		else {
			tudanhgiaImpl.setFile_url(file_url);
		}

		tudanhgiaImpl.setTongdiem(tongdiem);
		tudanhgiaImpl.setTrangthaixacnhan(trangthaixacnhan);
		tudanhgiaImpl.setTrangthaikyso(trangthaikyso);
		tudanhgiaImpl.setThang(thang);
		tudanhgiaImpl.setNam(nam);
		tudanhgiaImpl.setPhongban_id(phongban_id);

		if (xeploai == null) {
			tudanhgiaImpl.setXeploai("");
		}
		else {
			tudanhgiaImpl.setXeploai(xeploai);
		}

		if (created_at == Long.MIN_VALUE) {
			tudanhgiaImpl.setCreated_at(null);
		}
		else {
			tudanhgiaImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			tudanhgiaImpl.setUpdated_at(null);
		}
		else {
			tudanhgiaImpl.setUpdated_at(new Date(updated_at));
		}

		tudanhgiaImpl.resetOriginalValues();

		return tudanhgiaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		user_id = objectInput.readLong();
		thongtintudanhgia = objectInput.readUTF();
		ykienkhac = objectInput.readUTF();
		file_url = objectInput.readUTF();

		tongdiem = objectInput.readDouble();

		trangthaixacnhan = objectInput.readInt();

		trangthaikyso = objectInput.readInt();

		thang = objectInput.readInt();

		nam = objectInput.readInt();

		phongban_id = objectInput.readLong();
		xeploai = objectInput.readUTF();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeLong(user_id);

		if (thongtintudanhgia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thongtintudanhgia);
		}

		if (ykienkhac == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ykienkhac);
		}

		if (file_url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(file_url);
		}

		objectOutput.writeDouble(tongdiem);

		objectOutput.writeInt(trangthaixacnhan);

		objectOutput.writeInt(trangthaikyso);

		objectOutput.writeInt(thang);

		objectOutput.writeInt(nam);

		objectOutput.writeLong(phongban_id);

		if (xeploai == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(xeploai);
		}

		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public long user_id;
	public String thongtintudanhgia;
	public String ykienkhac;
	public String file_url;
	public double tongdiem;
	public int trangthaixacnhan;
	public int trangthaikyso;
	public int thang;
	public int nam;
	public long phongban_id;
	public String xeploai;
	public long created_at;
	public long updated_at;

}