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

import com.liferay.docs.backend.model.Tutiengviet;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the tutiengviet service. This utility wraps <code>com.liferay.docs.backend.service.persistence.impl.TutiengvietPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TutiengvietPersistence
 * @generated
 */
public class TutiengvietUtil {

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
	public static void clearCache(Tutiengviet tutiengviet) {
		getPersistence().clearCache(tutiengviet);
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
	public static Map<Serializable, Tutiengviet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Tutiengviet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tutiengviet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tutiengviet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Tutiengviet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Tutiengviet update(Tutiengviet tutiengviet) {
		return getPersistence().update(tutiengviet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Tutiengviet update(
		Tutiengviet tutiengviet, ServiceContext serviceContext) {

		return getPersistence().update(tutiengviet, serviceContext);
	}

	/**
	 * Returns all the tutiengviets where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching tutiengviets
	 */
	public static List<Tutiengviet> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the tutiengviets where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @return the range of matching tutiengviets
	 */
	public static List<Tutiengviet> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the tutiengviets where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tutiengviets
	 */
	public static List<Tutiengviet> findByid(
		int id, int start, int end,
		OrderByComparator<Tutiengviet> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tutiengviets where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tutiengviets
	 */
	public static List<Tutiengviet> findByid(
		int id, int start, int end,
		OrderByComparator<Tutiengviet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tutiengviet
	 * @throws NoSuchTutiengvietException if a matching tutiengviet could not be found
	 */
	public static Tutiengviet findByid_First(
			int id, OrderByComparator<Tutiengviet> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchTutiengvietException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tutiengviet, or <code>null</code> if a matching tutiengviet could not be found
	 */
	public static Tutiengviet fetchByid_First(
		int id, OrderByComparator<Tutiengviet> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tutiengviet
	 * @throws NoSuchTutiengvietException if a matching tutiengviet could not be found
	 */
	public static Tutiengviet findByid_Last(
			int id, OrderByComparator<Tutiengviet> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchTutiengvietException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tutiengviet, or <code>null</code> if a matching tutiengviet could not be found
	 */
	public static Tutiengviet fetchByid_Last(
		int id, OrderByComparator<Tutiengviet> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the tutiengviets where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of tutiengviets where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching tutiengviets
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the tutiengviet in the entity cache if it is enabled.
	 *
	 * @param tutiengviet the tutiengviet
	 */
	public static void cacheResult(Tutiengviet tutiengviet) {
		getPersistence().cacheResult(tutiengviet);
	}

	/**
	 * Caches the tutiengviets in the entity cache if it is enabled.
	 *
	 * @param tutiengviets the tutiengviets
	 */
	public static void cacheResult(List<Tutiengviet> tutiengviets) {
		getPersistence().cacheResult(tutiengviets);
	}

	/**
	 * Creates a new tutiengviet with the primary key. Does not add the tutiengviet to the database.
	 *
	 * @param id the primary key for the new tutiengviet
	 * @return the new tutiengviet
	 */
	public static Tutiengviet create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the tutiengviet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet that was removed
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	public static Tutiengviet remove(int id)
		throws com.liferay.docs.backend.exception.NoSuchTutiengvietException {

		return getPersistence().remove(id);
	}

	public static Tutiengviet updateImpl(Tutiengviet tutiengviet) {
		return getPersistence().updateImpl(tutiengviet);
	}

	/**
	 * Returns the tutiengviet with the primary key or throws a <code>NoSuchTutiengvietException</code> if it could not be found.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	public static Tutiengviet findByPrimaryKey(int id)
		throws com.liferay.docs.backend.exception.NoSuchTutiengvietException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the tutiengviet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet, or <code>null</code> if a tutiengviet with the primary key could not be found
	 */
	public static Tutiengviet fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the tutiengviets.
	 *
	 * @return the tutiengviets
	 */
	public static List<Tutiengviet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tutiengviets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @return the range of tutiengviets
	 */
	public static List<Tutiengviet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tutiengviets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tutiengviets
	 */
	public static List<Tutiengviet> findAll(
		int start, int end, OrderByComparator<Tutiengviet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tutiengviets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tutiengviets
	 */
	public static List<Tutiengviet> findAll(
		int start, int end, OrderByComparator<Tutiengviet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tutiengviets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tutiengviets.
	 *
	 * @return the number of tutiengviets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TutiengvietPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TutiengvietPersistence _persistence;

}