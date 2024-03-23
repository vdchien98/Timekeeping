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
import com.liferay.docs.backend.model.FilekysoModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Filekyso service. Represents a row in the &quot;Timekeeping_Filekyso&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FilekysoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FilekysoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FilekysoImpl
 * @generated
 */
@JSON(strict = true)
public class FilekysoModelImpl
	extends BaseModelImpl<Filekyso> implements FilekysoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a filekyso model instance should use the <code>Filekyso</code> interface instead.
	 */
	public static final String TABLE_NAME = "Timekeeping_Filekyso";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.INTEGER}, {"file_id_nosigned", Types.BIGINT},
		{"trangthai", Types.INTEGER}, {"fileurl_signed", Types.VARCHAR},
		{"nguoilamdon_id", Types.BIGINT}, {"nguoikydon_id", Types.BIGINT},
		{"created_at", Types.TIMESTAMP}, {"updated_at", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("file_id_nosigned", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("trangthai", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("fileurl_signed", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nguoilamdon_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nguoikydon_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("created_at", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updated_at", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Timekeeping_Filekyso (id_ INTEGER not null primary key,file_id_nosigned LONG,trangthai INTEGER,fileurl_signed VARCHAR(75) null,nguoilamdon_id LONG,nguoikydon_id LONG,created_at DATE null,updated_at DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table Timekeeping_Filekyso";

	public static final String ORDER_BY_JPQL = " ORDER BY filekyso.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Timekeeping_Filekyso.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public FilekysoModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Filekyso.class;
	}

	@Override
	public String getModelClassName() {
		return Filekyso.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Filekyso, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Filekyso, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Filekyso, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Filekyso)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Filekyso, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Filekyso, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Filekyso)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Filekyso, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Filekyso, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Filekyso, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Filekyso, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Filekyso, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Filekyso, Object>>();
		Map<String, BiConsumer<Filekyso, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Filekyso, ?>>();

		attributeGetterFunctions.put("id", Filekyso::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Filekyso, Integer>)Filekyso::setId);
		attributeGetterFunctions.put(
			"file_id_nosigned", Filekyso::getFile_id_nosigned);
		attributeSetterBiConsumers.put(
			"file_id_nosigned",
			(BiConsumer<Filekyso, Long>)Filekyso::setFile_id_nosigned);
		attributeGetterFunctions.put("trangthai", Filekyso::getTrangthai);
		attributeSetterBiConsumers.put(
			"trangthai", (BiConsumer<Filekyso, Integer>)Filekyso::setTrangthai);
		attributeGetterFunctions.put(
			"fileurl_signed", Filekyso::getFileurl_signed);
		attributeSetterBiConsumers.put(
			"fileurl_signed",
			(BiConsumer<Filekyso, String>)Filekyso::setFileurl_signed);
		attributeGetterFunctions.put(
			"nguoilamdon_id", Filekyso::getNguoilamdon_id);
		attributeSetterBiConsumers.put(
			"nguoilamdon_id",
			(BiConsumer<Filekyso, Long>)Filekyso::setNguoilamdon_id);
		attributeGetterFunctions.put(
			"nguoikydon_id", Filekyso::getNguoikydon_id);
		attributeSetterBiConsumers.put(
			"nguoikydon_id",
			(BiConsumer<Filekyso, Long>)Filekyso::setNguoikydon_id);
		attributeGetterFunctions.put("created_at", Filekyso::getCreated_at);
		attributeSetterBiConsumers.put(
			"created_at", (BiConsumer<Filekyso, Date>)Filekyso::setCreated_at);
		attributeGetterFunctions.put("updated_at", Filekyso::getUpdated_at);
		attributeSetterBiConsumers.put(
			"updated_at", (BiConsumer<Filekyso, Date>)Filekyso::setUpdated_at);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalId() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("id_"));
	}

	@JSON
	@Override
	public long getFile_id_nosigned() {
		return _file_id_nosigned;
	}

	@Override
	public void setFile_id_nosigned(long file_id_nosigned) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_file_id_nosigned = file_id_nosigned;
	}

	@JSON
	@Override
	public int getTrangthai() {
		return _trangthai;
	}

	@Override
	public void setTrangthai(int trangthai) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_trangthai = trangthai;
	}

	@JSON
	@Override
	public String getFileurl_signed() {
		if (_fileurl_signed == null) {
			return "";
		}
		else {
			return _fileurl_signed;
		}
	}

	@Override
	public void setFileurl_signed(String fileurl_signed) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileurl_signed = fileurl_signed;
	}

	@JSON
	@Override
	public long getNguoilamdon_id() {
		return _nguoilamdon_id;
	}

	@Override
	public void setNguoilamdon_id(long nguoilamdon_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nguoilamdon_id = nguoilamdon_id;
	}

	@JSON
	@Override
	public long getNguoikydon_id() {
		return _nguoikydon_id;
	}

	@Override
	public void setNguoikydon_id(long nguoikydon_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nguoikydon_id = nguoikydon_id;
	}

	@JSON
	@Override
	public Date getCreated_at() {
		return _created_at;
	}

	@Override
	public void setCreated_at(Date created_at) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_created_at = created_at;
	}

	@JSON
	@Override
	public Date getUpdated_at() {
		return _updated_at;
	}

	@Override
	public void setUpdated_at(Date updated_at) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_updated_at = updated_at;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public Filekyso toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Filekyso>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FilekysoImpl filekysoImpl = new FilekysoImpl();

		filekysoImpl.setId(getId());
		filekysoImpl.setFile_id_nosigned(getFile_id_nosigned());
		filekysoImpl.setTrangthai(getTrangthai());
		filekysoImpl.setFileurl_signed(getFileurl_signed());
		filekysoImpl.setNguoilamdon_id(getNguoilamdon_id());
		filekysoImpl.setNguoikydon_id(getNguoikydon_id());
		filekysoImpl.setCreated_at(getCreated_at());
		filekysoImpl.setUpdated_at(getUpdated_at());

		filekysoImpl.resetOriginalValues();

		return filekysoImpl;
	}

	@Override
	public Filekyso cloneWithOriginalValues() {
		FilekysoImpl filekysoImpl = new FilekysoImpl();

		filekysoImpl.setId(this.<Integer>getColumnOriginalValue("id_"));
		filekysoImpl.setFile_id_nosigned(
			this.<Long>getColumnOriginalValue("file_id_nosigned"));
		filekysoImpl.setTrangthai(
			this.<Integer>getColumnOriginalValue("trangthai"));
		filekysoImpl.setFileurl_signed(
			this.<String>getColumnOriginalValue("fileurl_signed"));
		filekysoImpl.setNguoilamdon_id(
			this.<Long>getColumnOriginalValue("nguoilamdon_id"));
		filekysoImpl.setNguoikydon_id(
			this.<Long>getColumnOriginalValue("nguoikydon_id"));
		filekysoImpl.setCreated_at(
			this.<Date>getColumnOriginalValue("created_at"));
		filekysoImpl.setUpdated_at(
			this.<Date>getColumnOriginalValue("updated_at"));

		return filekysoImpl;
	}

	@Override
	public int compareTo(Filekyso filekyso) {
		int primaryKey = filekyso.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Filekyso)) {
			return false;
		}

		Filekyso filekyso = (Filekyso)object;

		int primaryKey = filekyso.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Filekyso> toCacheModel() {
		FilekysoCacheModel filekysoCacheModel = new FilekysoCacheModel();

		filekysoCacheModel.id = getId();

		filekysoCacheModel.file_id_nosigned = getFile_id_nosigned();

		filekysoCacheModel.trangthai = getTrangthai();

		filekysoCacheModel.fileurl_signed = getFileurl_signed();

		String fileurl_signed = filekysoCacheModel.fileurl_signed;

		if ((fileurl_signed != null) && (fileurl_signed.length() == 0)) {
			filekysoCacheModel.fileurl_signed = null;
		}

		filekysoCacheModel.nguoilamdon_id = getNguoilamdon_id();

		filekysoCacheModel.nguoikydon_id = getNguoikydon_id();

		Date created_at = getCreated_at();

		if (created_at != null) {
			filekysoCacheModel.created_at = created_at.getTime();
		}
		else {
			filekysoCacheModel.created_at = Long.MIN_VALUE;
		}

		Date updated_at = getUpdated_at();

		if (updated_at != null) {
			filekysoCacheModel.updated_at = updated_at.getTime();
		}
		else {
			filekysoCacheModel.updated_at = Long.MIN_VALUE;
		}

		return filekysoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Filekyso, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Filekyso, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Filekyso, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Filekyso)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Filekyso, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Filekyso, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Filekyso, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Filekyso)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Filekyso>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Filekyso.class, ModelWrapper.class);

	}

	private int _id;
	private long _file_id_nosigned;
	private int _trangthai;
	private String _fileurl_signed;
	private long _nguoilamdon_id;
	private long _nguoikydon_id;
	private Date _created_at;
	private Date _updated_at;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Filekyso, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Filekyso)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("file_id_nosigned", _file_id_nosigned);
		_columnOriginalValues.put("trangthai", _trangthai);
		_columnOriginalValues.put("fileurl_signed", _fileurl_signed);
		_columnOriginalValues.put("nguoilamdon_id", _nguoilamdon_id);
		_columnOriginalValues.put("nguoikydon_id", _nguoikydon_id);
		_columnOriginalValues.put("created_at", _created_at);
		_columnOriginalValues.put("updated_at", _updated_at);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("id_", "id");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("id_", 1L);

		columnBitmasks.put("file_id_nosigned", 2L);

		columnBitmasks.put("trangthai", 4L);

		columnBitmasks.put("fileurl_signed", 8L);

		columnBitmasks.put("nguoilamdon_id", 16L);

		columnBitmasks.put("nguoikydon_id", 32L);

		columnBitmasks.put("created_at", 64L);

		columnBitmasks.put("updated_at", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Filekyso _escapedModel;

}