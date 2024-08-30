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

import com.liferay.docs.backend.model.Xinnghi;
import com.liferay.docs.backend.service.XinnghiLocalService;
import com.liferay.docs.backend.service.XinnghiLocalServiceUtil;
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
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the xinnghi local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.docs.backend.service.impl.XinnghiLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.backend.service.impl.XinnghiLocalServiceImpl
 * @generated
 */
public abstract class XinnghiLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, XinnghiLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>XinnghiLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>XinnghiLocalServiceUtil</code>.
	 */

	/**
	 * Adds the xinnghi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinnghi the xinnghi
	 * @return the xinnghi that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Xinnghi addXinnghi(Xinnghi xinnghi) {
		xinnghi.setNew(true);

		return xinnghiPersistence.update(xinnghi);
	}

	/**
	 * Creates a new xinnghi with the primary key. Does not add the xinnghi to the database.
	 *
	 * @param id the primary key for the new xinnghi
	 * @return the new xinnghi
	 */
	@Override
	@Transactional(enabled = false)
	public Xinnghi createXinnghi(int id) {
		return xinnghiPersistence.create(id);
	}

	/**
	 * Deletes the xinnghi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi that was removed
	 * @throws PortalException if a xinnghi with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Xinnghi deleteXinnghi(int id) throws PortalException {
		return xinnghiPersistence.remove(id);
	}

	/**
	 * Deletes the xinnghi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinnghi the xinnghi
	 * @return the xinnghi that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Xinnghi deleteXinnghi(Xinnghi xinnghi) {
		return xinnghiPersistence.remove(xinnghi);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return xinnghiPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Xinnghi.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return xinnghiPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return xinnghiPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return xinnghiPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return xinnghiPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return xinnghiPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Xinnghi fetchXinnghi(int id) {
		return xinnghiPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the xinnghi with the primary key.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi
	 * @throws PortalException if a xinnghi with the primary key could not be found
	 */
	@Override
	public Xinnghi getXinnghi(int id) throws PortalException {
		return xinnghiPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(xinnghiLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Xinnghi.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			xinnghiLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Xinnghi.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(xinnghiLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Xinnghi.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return xinnghiPersistence.create(((Integer)primaryKeyObj).intValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return xinnghiLocalService.deleteXinnghi((Xinnghi)persistedModel);
	}

	@Override
	public BasePersistence<Xinnghi> getBasePersistence() {
		return xinnghiPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return xinnghiPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the xinnghis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @return the range of xinnghis
	 */
	@Override
	public List<Xinnghi> getXinnghis(int start, int end) {
		return xinnghiPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of xinnghis.
	 *
	 * @return the number of xinnghis
	 */
	@Override
	public int getXinnghisCount() {
		return xinnghiPersistence.countAll();
	}

	/**
	 * Updates the xinnghi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinnghi the xinnghi
	 * @return the xinnghi that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Xinnghi updateXinnghi(Xinnghi xinnghi) {
		return xinnghiPersistence.update(xinnghi);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			XinnghiLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		xinnghiLocalService = (XinnghiLocalService)aopProxy;

		_setLocalServiceUtilService(xinnghiLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return XinnghiLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Xinnghi.class;
	}

	protected String getModelClassName() {
		return Xinnghi.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = xinnghiPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		XinnghiLocalService xinnghiLocalService) {

		try {
			Field field = XinnghiLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, xinnghiLocalService);
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

	protected XinnghiLocalService xinnghiLocalService;

	@Reference
	protected XinnghiPersistence xinnghiPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}