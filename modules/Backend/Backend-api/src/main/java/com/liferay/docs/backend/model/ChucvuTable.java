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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Timekeeping_Chucvu&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Chucvu
 * @generated
 */
public class ChucvuTable extends BaseTable<ChucvuTable> {

	public static final ChucvuTable INSTANCE = new ChucvuTable();

	public final Column<ChucvuTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<ChucvuTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ChucvuTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ChucvuTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ChucvuTable, Integer> role = createColumn(
		"role_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ChucvuTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChucvuTable, Long> so_thanh_vien = createColumn(
		"so_thanh_vien", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ChucvuTable() {
		super("Timekeeping_Chucvu", ChucvuTable::new);
	}

}