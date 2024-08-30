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

import com.liferay.docs.backend.exception.NoSuchTutiengvietException;
import com.liferay.docs.backend.model.Tutiengviet;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tutiengviet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TutiengvietUtil
 * @generated
 */
@ProviderType
public interface TutiengvietPersistence extends BasePersistence<Tutiengviet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TutiengvietUtil} to access the tutiengviet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tutiengviets where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching tutiengviets
	 */
	public java.util.List<Tutiengviet> findByid(int id);

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
	public java.util.List<Tutiengviet> findByid(int id, int start, int end);

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
	public java.util.List<Tutiengviet> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
			orderByComparator);

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
	public java.util.List<Tutiengviet> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tutiengviet
	 * @throws NoSuchTutiengvietException if a matching tutiengviet could not be found
	 */
	public Tutiengviet findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
				orderByComparator)
		throws NoSuchTutiengvietException;

	/**
	 * Returns the first tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tutiengviet, or <code>null</code> if a matching tutiengviet could not be found
	 */
	public Tutiengviet fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
			orderByComparator);

	/**
	 * Returns the last tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tutiengviet
	 * @throws NoSuchTutiengvietException if a matching tutiengviet could not be found
	 */
	public Tutiengviet findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
				orderByComparator)
		throws NoSuchTutiengvietException;

	/**
	 * Returns the last tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tutiengviet, or <code>null</code> if a matching tutiengviet could not be found
	 */
	public Tutiengviet fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
			orderByComparator);

	/**
	 * Removes all the tutiengviets where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of tutiengviets where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching tutiengviets
	 */
	public int countByid(int id);

	/**
	 * Caches the tutiengviet in the entity cache if it is enabled.
	 *
	 * @param tutiengviet the tutiengviet
	 */
	public void cacheResult(Tutiengviet tutiengviet);

	/**
	 * Caches the tutiengviets in the entity cache if it is enabled.
	 *
	 * @param tutiengviets the tutiengviets
	 */
	public void cacheResult(java.util.List<Tutiengviet> tutiengviets);

	/**
	 * Creates a new tutiengviet with the primary key. Does not add the tutiengviet to the database.
	 *
	 * @param id the primary key for the new tutiengviet
	 * @return the new tutiengviet
	 */
	public Tutiengviet create(int id);

	/**
	 * Removes the tutiengviet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet that was removed
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	public Tutiengviet remove(int id) throws NoSuchTutiengvietException;

	public Tutiengviet updateImpl(Tutiengviet tutiengviet);

	/**
	 * Returns the tutiengviet with the primary key or throws a <code>NoSuchTutiengvietException</code> if it could not be found.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	public Tutiengviet findByPrimaryKey(int id)
		throws NoSuchTutiengvietException;

	/**
	 * Returns the tutiengviet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet, or <code>null</code> if a tutiengviet with the primary key could not be found
	 */
	public Tutiengviet fetchByPrimaryKey(int id);

	/**
	 * Returns all the tutiengviets.
	 *
	 * @return the tutiengviets
	 */
	public java.util.List<Tutiengviet> findAll();

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
	public java.util.List<Tutiengviet> findAll(int start, int end);

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
	public java.util.List<Tutiengviet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
			orderByComparator);

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
	public java.util.List<Tutiengviet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tutiengviet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tutiengviets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tutiengviets.
	 *
	 * @return the number of tutiengviets
	 */
	public int countAll();

}