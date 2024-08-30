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

import com.liferay.docs.backend.exception.NoSuchtudanhgiaException;
import com.liferay.docs.backend.model.tudanhgia;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tudanhgia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tudanhgiaUtil
 * @generated
 */
@ProviderType
public interface tudanhgiaPersistence extends BasePersistence<tudanhgia> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link tudanhgiaUtil} to access the tudanhgia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tudanhgias where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching tudanhgias
	 */
	public java.util.List<tudanhgia> findByid(int id);

	/**
	 * Returns a range of all the tudanhgias where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @return the range of matching tudanhgias
	 */
	public java.util.List<tudanhgia> findByid(int id, int start, int end);

	/**
	 * Returns an ordered range of all the tudanhgias where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tudanhgias
	 */
	public java.util.List<tudanhgia> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tudanhgias where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tudanhgias
	 */
	public java.util.List<tudanhgia> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tudanhgia
	 * @throws NoSuchtudanhgiaException if a matching tudanhgia could not be found
	 */
	public tudanhgia findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
				orderByComparator)
		throws NoSuchtudanhgiaException;

	/**
	 * Returns the first tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tudanhgia, or <code>null</code> if a matching tudanhgia could not be found
	 */
	public tudanhgia fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
			orderByComparator);

	/**
	 * Returns the last tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tudanhgia
	 * @throws NoSuchtudanhgiaException if a matching tudanhgia could not be found
	 */
	public tudanhgia findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
				orderByComparator)
		throws NoSuchtudanhgiaException;

	/**
	 * Returns the last tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tudanhgia, or <code>null</code> if a matching tudanhgia could not be found
	 */
	public tudanhgia fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
			orderByComparator);

	/**
	 * Removes all the tudanhgias where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of tudanhgias where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching tudanhgias
	 */
	public int countByid(int id);

	/**
	 * Caches the tudanhgia in the entity cache if it is enabled.
	 *
	 * @param tudanhgia the tudanhgia
	 */
	public void cacheResult(tudanhgia tudanhgia);

	/**
	 * Caches the tudanhgias in the entity cache if it is enabled.
	 *
	 * @param tudanhgias the tudanhgias
	 */
	public void cacheResult(java.util.List<tudanhgia> tudanhgias);

	/**
	 * Creates a new tudanhgia with the primary key. Does not add the tudanhgia to the database.
	 *
	 * @param id the primary key for the new tudanhgia
	 * @return the new tudanhgia
	 */
	public tudanhgia create(int id);

	/**
	 * Removes the tudanhgia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia that was removed
	 * @throws NoSuchtudanhgiaException if a tudanhgia with the primary key could not be found
	 */
	public tudanhgia remove(int id) throws NoSuchtudanhgiaException;

	public tudanhgia updateImpl(tudanhgia tudanhgia);

	/**
	 * Returns the tudanhgia with the primary key or throws a <code>NoSuchtudanhgiaException</code> if it could not be found.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia
	 * @throws NoSuchtudanhgiaException if a tudanhgia with the primary key could not be found
	 */
	public tudanhgia findByPrimaryKey(int id) throws NoSuchtudanhgiaException;

	/**
	 * Returns the tudanhgia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia, or <code>null</code> if a tudanhgia with the primary key could not be found
	 */
	public tudanhgia fetchByPrimaryKey(int id);

	/**
	 * Returns all the tudanhgias.
	 *
	 * @return the tudanhgias
	 */
	public java.util.List<tudanhgia> findAll();

	/**
	 * Returns a range of all the tudanhgias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @return the range of tudanhgias
	 */
	public java.util.List<tudanhgia> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tudanhgias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tudanhgias
	 */
	public java.util.List<tudanhgia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tudanhgias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>tudanhgiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tudanhgias
	 * @param end the upper bound of the range of tudanhgias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tudanhgias
	 */
	public java.util.List<tudanhgia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tudanhgia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tudanhgias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tudanhgias.
	 *
	 * @return the number of tudanhgias
	 */
	public int countAll();

}