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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Ngaylamviec service. Represents a row in the &quot;Timekeeping_Ngaylamviec&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see NgaylamviecModel
 * @generated
 */
@ImplementationClassName("com.liferay.docs.backend.model.impl.NgaylamviecImpl")
@ProviderType
public interface Ngaylamviec extends NgaylamviecModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.docs.backend.model.impl.NgaylamviecImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Ngaylamviec, Integer> ID_ACCESSOR =
		new Accessor<Ngaylamviec, Integer>() {

			@Override
			public Integer get(Ngaylamviec ngaylamviec) {
				return ngaylamviec.getId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Ngaylamviec> getTypeClass() {
				return Ngaylamviec.class;
			}

		};

}