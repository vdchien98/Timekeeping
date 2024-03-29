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

import com.liferay.docs.backend.model.Users;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the users service. This utility wraps <code>com.liferay.docs.backend.service.persistence.impl.UsersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UsersPersistence
 * @generated
 */
public class UsersUtil {

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
	public static void clearCache(Users users) {
		getPersistence().clearCache(users);
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
	public static Map<Serializable, Users> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Users> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Users> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Users> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Users update(Users users) {
		return getPersistence().update(users);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Users update(Users users, ServiceContext serviceContext) {
		return getPersistence().update(users, serviceContext);
	}

	/**
	 * Returns all the userses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching userses
	 */
	public static List<Users> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @return the range of matching userses
	 */
	public static List<Users> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userses
	 */
	public static List<Users> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Users> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching userses
	 */
	public static List<Users> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Users> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching users
	 * @throws NoSuchUsersException if a matching users could not be found
	 */
	public static Users findByGroupId_First(
			long groupId, OrderByComparator<Users> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching users, or <code>null</code> if a matching users could not be found
	 */
	public static Users fetchByGroupId_First(
		long groupId, OrderByComparator<Users> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching users
	 * @throws NoSuchUsersException if a matching users could not be found
	 */
	public static Users findByGroupId_Last(
			long groupId, OrderByComparator<Users> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching users, or <code>null</code> if a matching users could not be found
	 */
	public static Users fetchByGroupId_Last(
		long groupId, OrderByComparator<Users> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the userses before and after the current users in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current users
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next users
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public static Users[] findByGroupId_PrevAndNext(
			int id, long groupId, OrderByComparator<Users> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the userses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of userses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching userses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching userses
	 */
	public static List<Users> findByGetUserId(long userId) {
		return getPersistence().findByGetUserId(userId);
	}

	/**
	 * Returns a range of all the userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @return the range of matching userses
	 */
	public static List<Users> findByGetUserId(long userId, int start, int end) {
		return getPersistence().findByGetUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userses
	 */
	public static List<Users> findByGetUserId(
		long userId, int start, int end,
		OrderByComparator<Users> orderByComparator) {

		return getPersistence().findByGetUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching userses
	 */
	public static List<Users> findByGetUserId(
		long userId, int start, int end,
		OrderByComparator<Users> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGetUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching users
	 * @throws NoSuchUsersException if a matching users could not be found
	 */
	public static Users findByGetUserId_First(
			long userId, OrderByComparator<Users> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByGetUserId_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the first users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching users, or <code>null</code> if a matching users could not be found
	 */
	public static Users fetchByGetUserId_First(
		long userId, OrderByComparator<Users> orderByComparator) {

		return getPersistence().fetchByGetUserId_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the last users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching users
	 * @throws NoSuchUsersException if a matching users could not be found
	 */
	public static Users findByGetUserId_Last(
			long userId, OrderByComparator<Users> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByGetUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching users, or <code>null</code> if a matching users could not be found
	 */
	public static Users fetchByGetUserId_Last(
		long userId, OrderByComparator<Users> orderByComparator) {

		return getPersistence().fetchByGetUserId_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the userses before and after the current users in the ordered set where userId = &#63;.
	 *
	 * @param id the primary key of the current users
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next users
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public static Users[] findByGetUserId_PrevAndNext(
			int id, long userId, OrderByComparator<Users> orderByComparator)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByGetUserId_PrevAndNext(
			id, userId, orderByComparator);
	}

	/**
	 * Removes all the userses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByGetUserId(long userId) {
		getPersistence().removeByGetUserId(userId);
	}

	/**
	 * Returns the number of userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching userses
	 */
	public static int countByGetUserId(long userId) {
		return getPersistence().countByGetUserId(userId);
	}

	/**
	 * Caches the users in the entity cache if it is enabled.
	 *
	 * @param users the users
	 */
	public static void cacheResult(Users users) {
		getPersistence().cacheResult(users);
	}

	/**
	 * Caches the userses in the entity cache if it is enabled.
	 *
	 * @param userses the userses
	 */
	public static void cacheResult(List<Users> userses) {
		getPersistence().cacheResult(userses);
	}

	/**
	 * Creates a new users with the primary key. Does not add the users to the database.
	 *
	 * @param id the primary key for the new users
	 * @return the new users
	 */
	public static Users create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the users
	 * @return the users that was removed
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public static Users remove(int id)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().remove(id);
	}

	public static Users updateImpl(Users users) {
		return getPersistence().updateImpl(users);
	}

	/**
	 * Returns the users with the primary key or throws a <code>NoSuchUsersException</code> if it could not be found.
	 *
	 * @param id the primary key of the users
	 * @return the users
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public static Users findByPrimaryKey(int id)
		throws com.liferay.docs.backend.exception.NoSuchUsersException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the users
	 * @return the users, or <code>null</code> if a users with the primary key could not be found
	 */
	public static Users fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the userses.
	 *
	 * @return the userses
	 */
	public static List<Users> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @return the range of userses
	 */
	public static List<Users> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of userses
	 */
	public static List<Users> findAll(
		int start, int end, OrderByComparator<Users> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of userses
	 */
	public static List<Users> findAll(
		int start, int end, OrderByComparator<Users> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the userses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of userses.
	 *
	 * @return the number of userses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UsersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UsersPersistence _persistence;

}