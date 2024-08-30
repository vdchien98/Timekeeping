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
 * The table class for the &quot;Timekeeping_tudanhgia&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see tudanhgia
 * @generated
 */
public class tudanhgiaTable extends BaseTable<tudanhgiaTable> {

	public static final tudanhgiaTable INSTANCE = new tudanhgiaTable();

	public final Column<tudanhgiaTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<tudanhgiaTable, Long> user_id = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, String> thongtintudanhgia =
		createColumn(
			"thongtintudanhgia", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, String> ykienkhac = createColumn(
		"ykienkhac", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, String> file_url = createColumn(
		"file_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Double> tongdiem = createColumn(
		"tongdiem", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Integer> trangthaixacnhan =
		createColumn(
			"trangthaixacnhan", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Integer> trangthaikyso = createColumn(
		"trangthaikyso", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Integer> thang = createColumn(
		"thang", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Integer> nam = createColumn(
		"nam", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Long> phongban_id = createColumn(
		"phongban_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, String> xeploai = createColumn(
		"xeploai", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<tudanhgiaTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private tudanhgiaTable() {
		super("Timekeeping_tudanhgia", tudanhgiaTable::new);
	}

}