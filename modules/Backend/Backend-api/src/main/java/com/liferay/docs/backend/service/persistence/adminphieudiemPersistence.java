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

import com.liferay.docs.backend.exception.NoSuchadminphieudiemException;
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the adminphieudiem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiemUtil
 * @generated
 */
@ProviderType
public interface adminphieudiemPersistence
	extends BasePersistence<adminphieudiem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link adminphieudiemUtil} to access the adminphieudiem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the adminphieudiems where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching adminphieudiems
	 */
	public java.util.List<adminphieudiem> findByid(int id);

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
	public java.util.List<adminphieudiem> findByid(int id, int start, int end);

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
	public java.util.List<adminphieudiem> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
			orderByComparator);

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
	public java.util.List<adminphieudiem> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adminphieudiem
	 * @throws NoSuchadminphieudiemException if a matching adminphieudiem could not be found
	 */
	public adminphieudiem findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
				orderByComparator)
		throws NoSuchadminphieudiemException;

	/**
	 * Returns the first adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adminphieudiem, or <code>null</code> if a matching adminphieudiem could not be found
	 */
	public adminphieudiem fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
			orderByComparator);

	/**
	 * Returns the last adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adminphieudiem
	 * @throws NoSuchadminphieudiemException if a matching adminphieudiem could not be found
	 */
	public adminphieudiem findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
				orderByComparator)
		throws NoSuchadminphieudiemException;

	/**
	 * Returns the last adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adminphieudiem, or <code>null</code> if a matching adminphieudiem could not be found
	 */
	public adminphieudiem fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
			orderByComparator);

	/**
	 * Removes all the adminphieudiems where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of adminphieudiems where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching adminphieudiems
	 */
	public int countByid(int id);

	/**
	 * Caches the adminphieudiem in the entity cache if it is enabled.
	 *
	 * @param adminphieudiem the adminphieudiem
	 */
	public void cacheResult(adminphieudiem adminphieudiem);

	/**
	 * Caches the adminphieudiems in the entity cache if it is enabled.
	 *
	 * @param adminphieudiems the adminphieudiems
	 */
	public void cacheResult(java.util.List<adminphieudiem> adminphieudiems);

	/**
	 * Creates a new adminphieudiem with the primary key. Does not add the adminphieudiem to the database.
	 *
	 * @param id the primary key for the new adminphieudiem
	 * @return the new adminphieudiem
	 */
	public adminphieudiem create(int id);

	/**
	 * Removes the adminphieudiem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem that was removed
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	public adminphieudiem remove(int id) throws NoSuchadminphieudiemException;

	public adminphieudiem updateImpl(adminphieudiem adminphieudiem);

	/**
	 * Returns the adminphieudiem with the primary key or throws a <code>NoSuchadminphieudiemException</code> if it could not be found.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	public adminphieudiem findByPrimaryKey(int id)
		throws NoSuchadminphieudiemException;

	/**
	 * Returns the adminphieudiem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem, or <code>null</code> if a adminphieudiem with the primary key could not be found
	 */
	public adminphieudiem fetchByPrimaryKey(int id);

	/**
	 * Returns all the adminphieudiems.
	 *
	 * @return the adminphieudiems
	 */
	public java.util.List<adminphieudiem> findAll();

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
	public java.util.List<adminphieudiem> findAll(int start, int end);

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
	public java.util.List<adminphieudiem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
			orderByComparator);

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
	public java.util.List<adminphieudiem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<adminphieudiem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the adminphieudiems from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of adminphieudiems.
	 *
	 * @return the number of adminphieudiems
	 */
	public int countAll();

}