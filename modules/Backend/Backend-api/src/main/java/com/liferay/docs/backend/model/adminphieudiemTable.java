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
 * The table class for the &quot;Timekeeping_adminphieudiem&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiem
 * @generated
 */
public class adminphieudiemTable extends BaseTable<adminphieudiemTable> {

	public static final adminphieudiemTable INSTANCE =
		new adminphieudiemTable();

	public final Column<adminphieudiemTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<adminphieudiemTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, Long> user_id = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, String> nhomcauhoi = createColumn(
		"nhomcauhoi", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, String> noidungcauhoi =
		createColumn(
			"noidungcauhoi", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, Integer> thuocnhomcauhoinao =
		createColumn(
			"thuocnhomcauhoinao", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, Double> diemtoida = createColumn(
		"diemtoida", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, Long> trangthaicauhoi =
		createColumn(
			"trangthaicauhoi", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<adminphieudiemTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private adminphieudiemTable() {
		super("Timekeeping_adminphieudiem", adminphieudiemTable::new);
	}

}