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

import com.liferay.docs.backend.model.Ngaylamviec;
import com.liferay.docs.backend.service.NgaylamviecLocalService;
import com.liferay.docs.backend.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.backend.service.persistence.CalamviecPersistence;
import com.liferay.docs.backend.service.persistence.ChucvuPersistence;
import com.liferay.docs.backend.service.persistence.FilekysoPersistence;
import com.liferay.docs.backend.service.persistence.GioLamFinder;
import com.liferay.docs.backend.service.persistence.GioLamPersistence;
import com.liferay.docs.backend.service.persistence.NgaylamviecPersistence;
import com.liferay.docs.backend.service.persistence.NgaynghilePersistence;
import com.liferay.docs.backend.service.persistence.PhongbanPersistence;
import com.liferay.docs.backend.service.persistence.UsersFinder;
import com.liferay.docs.backend.service.persistence.UsersPersistence;
import com.liferay.docs.backend.service.persistence.XinchamcongPersistence;
import com.liferay.docs.backend.service.persistence.XinnghiPersistence;
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
 * Provides the base implementation for the ngaylamviec local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.docs.backend.service.impl.NgaylamviecLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.backend.service.impl.NgaylamviecLocalServiceImpl
 * @generated
 */
public abstract class NgaylamviecLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, NgaylamviecLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>NgaylamviecLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>NgaylamviecLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ngaylamviec to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaylamviec the ngaylamviec
	 * @return the ngaylamviec that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Ngaylamviec addNgaylamviec(Ngaylamviec ngaylamviec) {
		ngaylamviec.setNew(true);

		return ngaylamviecPersistence.update(ngaylamviec);
	}

	/**
	 * Creates a new ngaylamviec with the primary key. Does not add the ngaylamviec to the database.
	 *
	 * @param id the primary key for the new ngaylamviec
	 * @return the new ngaylamviec
	 */
	@Override
	@Transactional(enabled = false)
	public Ngaylamviec createNgaylamviec(int id) {
		return ngaylamviecPersistence.create(id);
	}

	/**
	 * Deletes the ngaylamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec that was removed
	 * @throws PortalException if a ngaylamviec with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Ngaylamviec deleteNgaylamviec(int id) throws PortalException {
		return ngaylamviecPersistence.remove(id);
	}

	/**
	 * Deletes the ngaylamviec from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaylamviec the ngaylamviec
	 * @return the ngaylamviec that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Ngaylamviec deleteNgaylamviec(Ngaylamviec ngaylamviec) {
		return ngaylamviecPersistence.remove(ngaylamviec);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return ngaylamviecPersistence.dslQuery(dslQuery);
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
			Ngaylamviec.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ngaylamviecPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.NgaylamviecModelImpl</code>.
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

		return ngaylamviecPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.NgaylamviecModelImpl</code>.
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

		return ngaylamviecPersistence.findWithDynamicQuery(
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
		return ngaylamviecPersistence.countWithDynamicQuery(dynamicQuery);
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

		return ngaylamviecPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Ngaylamviec fetchNgaylamviec(int id) {
		return ngaylamviecPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the ngaylamviec with the primary key.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec
	 * @throws PortalException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public Ngaylamviec getNgaylamviec(int id) throws PortalException {
		return ngaylamviecPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ngaylamviecLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Ngaylamviec.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ngaylamviecLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Ngaylamviec.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ngaylamviecLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Ngaylamviec.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ngaylamviecPersistence.create(
			((Integer)primaryKeyObj).intValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ngaylamviecLocalService.deleteNgaylamviec(
			(Ngaylamviec)persistedModel);
	}

	@Override
	public BasePersistence<Ngaylamviec> getBasePersistence() {
		return ngaylamviecPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ngaylamviecPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @return the range of ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> getNgaylamviecs(int start, int end) {
		return ngaylamviecPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ngaylamviecs.
	 *
	 * @return the number of ngaylamviecs
	 */
	@Override
	public int getNgaylamviecsCount() {
		return ngaylamviecPersistence.countAll();
	}

	/**
	 * Updates the ngaylamviec in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaylamviec the ngaylamviec
	 * @return the ngaylamviec that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Ngaylamviec updateNgaylamviec(Ngaylamviec ngaylamviec) {
		return ngaylamviecPersistence.update(ngaylamviec);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			NgaylamviecLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ngaylamviecLocalService = (NgaylamviecLocalService)aopProxy;

		_setLocalServiceUtilService(ngaylamviecLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return NgaylamviecLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Ngaylamviec.class;
	}

	protected String getModelClassName() {
		return Ngaylamviec.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ngaylamviecPersistence.getDataSource();

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
		NgaylamviecLocalService ngaylamviecLocalService) {

		try {
			Field field = NgaylamviecLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, ngaylamviecLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

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

	protected NgaylamviecLocalService ngaylamviecLocalService;

	@Reference
	protected NgaylamviecPersistence ngaylamviecPersistence;

	@Reference
	protected NgaynghilePersistence ngaynghilePersistence;

	@Reference
	protected PhongbanPersistence phongbanPersistence;

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