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

package com.liferay.docs.backend.service.persistence;

import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the adminphieudiem service. This utility wraps <code>com.liferay.docs.backend.service.persistence.impl.adminphieudiemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiemPersistence
 * @generated
 */
public class adminphieudiemUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(adminphieudiem adminphieudiem) {
		getPersistence().clearCache(adminphieudiem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, adminphieudiem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<adminphieudiem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<adminphieudiem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<adminphieudiem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static adminphieudiem update(adminphieudiem adminphieudiem) {
		return getPersistence().update(adminphieudiem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static adminphieudiem update(
		adminphieudiem adminphieudiem, ServiceContext serviceContext) {

		return getPersistence().update(adminphieudiem, serviceContext);
	}

	/**
	 * Returns all the adminphieudiems where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching adminphieudiems
	 */
	public static List<adminphieudiem> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the adminphieudiems where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @return the range of matching adminphieudiems
	 */
	public static List<adminphieudiem> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the adminphieudiems where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching adminphieudiems
	 */
	public static List<adminphieudiem> findByid(
		int id, int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the adminphieudiems where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching adminphieudiems
	 */
	public static List<adminphieudiem> findByid(
		int id, int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adminphieudiem
	 * @throws NoSuchadminphieudiemException if a matching adminphieudiem could not be found
	 */
	public static adminphieudiem findByid_First(
			int id, OrderByComparator<adminphieudiem> orderByComparator)
		throws com.liferay.docs.backend.exception.
			NoSuchadminphieudiemException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adminphieudiem, or <code>null</code> if a matching adminphieudiem could not be found
	 */
	public static adminphieudiem fetchByid_First(
		int id, OrderByComparator<adminphieudiem> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adminphieudiem
	 * @throws NoSuchadminphieudiemException if a matching adminphieudiem could not be found
	 */
	public static adminphieudiem findByid_Last(
			int id, OrderByComparator<adminphieudiem> orderByComparator)
		throws com.liferay.docs.backend.exception.
			NoSuchadminphieudiemException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adminphieudiem, or <code>null</code> if a matching adminphieudiem could not be found
	 */
	public static adminphieudiem fetchByid_Last(
		int id, OrderByComparator<adminphieudiem> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the adminphieudiems where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of adminphieudiems where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching adminphieudiems
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the adminphieudiem in the entity cache if it is enabled.
	 *
	 * @param adminphieudiem the adminphieudiem
	 */
	public static void cacheResult(adminphieudiem adminphieudiem) {
		getPersistence().cacheResult(adminphieudiem);
	}

	/**
	 * Caches the adminphieudiems in the entity cache if it is enabled.
	 *
	 * @param adminphieudiems the adminphieudiems
	 */
	public static void cacheResult(List<adminphieudiem> adminphieudiems) {
		getPersistence().cacheResult(adminphieudiems);
	}

	/**
	 * Creates a new adminphieudiem with the primary key. Does not add the adminphieudiem to the database.
	 *
	 * @param id the primary key for the new adminphieudiem
	 * @return the new adminphieudiem
	 */
	public static adminphieudiem create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the adminphieudiem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem that was removed
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	public static adminphieudiem remove(int id)
		throws com.liferay.docs.backend.exception.
			NoSuchadminphieudiemException {

		return getPersistence().remove(id);
	}

	public static adminphieudiem updateImpl(adminphieudiem adminphieudiem) {
		return getPersistence().updateImpl(adminphieudiem);
	}

	/**
	 * Returns the adminphieudiem with the primary key or throws a <code>NoSuchadminphieudiemException</code> if it could not be found.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	public static adminphieudiem findByPrimaryKey(int id)
		throws com.liferay.docs.backend.exception.
			NoSuchadminphieudiemException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the adminphieudiem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem, or <code>null</code> if a adminphieudiem with the primary key could not be found
	 */
	public static adminphieudiem fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the adminphieudiems.
	 *
	 * @return the adminphieudiems
	 */
	public static List<adminphieudiem> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the adminphieudiems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @return the range of adminphieudiems
	 */
	public static List<adminphieudiem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the adminphieudiems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of adminphieudiems
	 */
	public static List<adminphieudiem> findAll(
		int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the adminphieudiems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adminphieudiemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of adminphieudiems
	 * @param end the upper bound of the range of adminphieudiems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of adminphieudiems
	 */
	public static List<adminphieudiem> findAll(
		int start, int end, OrderByComparator<adminphieudiem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the adminphieudiems from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of adminphieudiems.
	 *
	 * @return the number of adminphieudiems
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static adminphieudiemPersistence getPersistence() {
		return _persistence;
	}

	private static volatile adminphieudiemPersistence _persistence;

}