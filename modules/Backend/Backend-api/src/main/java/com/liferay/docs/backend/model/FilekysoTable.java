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
 * The table class for the &quot;Timekeeping_Filekyso&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Filekyso
 * @generated
 */
public class FilekysoTable extends BaseTable<FilekysoTable> {

	public static final FilekysoTable INSTANCE = new FilekysoTable();

	public final Column<FilekysoTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<FilekysoTable, Long> file_id_nosigned = createColumn(
		"file_id_nosigned", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FilekysoTable, Integer> trangthai = createColumn(
		"trangthai", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FilekysoTable, String> fileurl_signed = createColumn(
		"fileurl_signed", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FilekysoTable, Long> nguoilamdon_id = createColumn(
		"nguoilamdon_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FilekysoTable, Long> nguoikydon_id = createColumn(
		"nguoikydon_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FilekysoTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FilekysoTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FilekysoTable() {
		super("Timekeeping_Filekyso", FilekysoTable::new);
	}

}