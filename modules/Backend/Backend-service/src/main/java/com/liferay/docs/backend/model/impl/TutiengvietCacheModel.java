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

import com.liferay.docs.backend.model.Tutiengviet;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tutiengviet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TutiengvietCacheModel
	implements CacheModel<Tutiengviet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TutiengvietCacheModel)) {
			return false;
		}

		TutiengvietCacheModel tutiengvietCacheModel =
			(TutiengvietCacheModel)object;

		if (id == tutiengvietCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tieu_de_tv=");
		sb.append(tieu_de_tv);
		sb.append(", tu_tieng_viet=");
		sb.append(tu_tieng_viet);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tutiengviet toEntityModel() {
		TutiengvietImpl tutiengvietImpl = new TutiengvietImpl();

		tutiengvietImpl.setId(id);

		if (tieu_de_tv == null) {
			tutiengvietImpl.setTieu_de_tv("");
		}
		else {
			tutiengvietImpl.setTieu_de_tv(tieu_de_tv);
		}

		if (tu_tieng_viet == null) {
			tutiengvietImpl.setTu_tieng_viet("");
		}
		else {
			tutiengvietImpl.setTu_tieng_viet(tu_tieng_viet);
		}

		if (created_at == Long.MIN_VALUE) {
			tutiengvietImpl.setCreated_at(null);
		}
		else {
			tutiengvietImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			tutiengvietImpl.setUpdated_at(null);
		}
		else {
			tutiengvietImpl.setUpdated_at(new Date(updated_at));
		}

		tutiengvietImpl.resetOriginalValues();

		return tutiengvietImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		tieu_de_tv = objectInput.readUTF();
		tu_tieng_viet = objectInput.readUTF();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (tieu_de_tv == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tieu_de_tv);
		}

		if (tu_tieng_viet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tu_tieng_viet);
		}

		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public String tieu_de_tv;
	public String tu_tieng_viet;
	public long created_at;
	public long updated_at;

}