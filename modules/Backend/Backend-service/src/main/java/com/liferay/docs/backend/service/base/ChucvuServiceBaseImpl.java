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

package com.liferay.docs.backend.service.base;

import com.liferay.docs.backend.model.Chucvu;
import com.liferay.docs.backend.service.ChucvuService;
import com.liferay.docs.backend.service.ChucvuServiceUtil;
import com.liferay.docs.backend.service.persistence.CalamviecPersistence;
import com.liferay.docs.backend.service.persistence.ChucvuPersistence;
import com.liferay.docs.backend.service.persistence.FilekysoPersistence;
import com.liferay.docs.backend.service.persistence.GioLamFinder;
import com.liferay.docs.backend.service.persistence.GioLamPersistence;
import com.liferay.docs.backend.service.persistence.NgaylamviecPersistence;
import com.liferay.docs.backend.service.persistence.NgaynghilePersistence;
import com.liferay.docs.backend.service.persistence.PhongbanPersistence;
import com.liferay.docs.backend.service.persistence.TutiengvietPersistence;
import com.liferay.docs.backend.service.persistence.UsersFinder;
import com.liferay.docs.backend.service.persistence.UsersPersistence;
import com.liferay.docs.backend.service.persistence.XinchamcongPersistence;
import com.liferay.docs.backend.service.persistence.XinnghiPersistence;
import com.liferay.docs.backend.service.persistence.adminphieudiemPersistence;
import com.liferay.docs.backend.service.persistence.tudanhgiaPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the chucvu remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.docs.backend.service.impl.ChucvuServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.backend.service.impl.ChucvuServiceImpl
 * @generated
 */
public abstract class ChucvuServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, ChucvuService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ChucvuService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ChucvuServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ChucvuService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		chucvuService = (ChucvuService)aopProxy;

		_setServiceUtilService(chucvuService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ChucvuService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Chucvu.class;
	}

	protected String getModelClassName() {
		return Chucvu.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = chucvuPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(ChucvuService chucvuService) {
		try {
			Field field = ChucvuServiceUtil.class.getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, chucvuService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected adminphieudiemPersistence adminphieudiemPersistence;

	@Reference
	protected CalamviecPersistence calamviecPersistence;

	@Reference
	protected com.liferay.docs.backend.service.ChucvuLocalService
		chucvuLocalService;

	protected ChucvuService chucvuService;

	@Reference
	protected ChucvuPersistence chucvuPersistence;

	@Reference
	protected FilekysoPersistence filekysoPersistence;

	@Reference
	protected GioLamPersistence gioLamPersistence;

	@Reference
	protected GioLamFinder gioLamFinder;

	@Reference
	protected NgaylamviecPersistence ngaylamviecPersistence;

	@Reference
	protected NgaynghilePersistence ngaynghilePersistence;

	@Reference
	protected PhongbanPersistence phongbanPersistence;

	@Reference
	protected tudanhgiaPersistence tudanhgiaPersistence;

	@Reference
	protected TutiengvietPersistence tutiengvietPersistence;

	@Reference
	protected UsersPersistence usersPersistence;

	@Reference
	protected UsersFinder usersFinder;

	@Reference
	protected XinchamcongPersistence xinchamcongPersistence;

	@Reference
	protected XinnghiPersistence xinnghiPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

}