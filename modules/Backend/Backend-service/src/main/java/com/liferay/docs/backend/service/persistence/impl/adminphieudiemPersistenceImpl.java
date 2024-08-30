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

package com.liferay.docs.backend.service.persistence.impl;

import com.liferay.docs.backend.exception.NoSuchadminphieudiemException;
import com.liferay.docs.backend.model.adminphieudiem;
import com.liferay.docs.backend.model.adminphieudiemTable;
import com.liferay.docs.backend.model.impl.adminphieudiemImpl;
import com.liferay.docs.backend.model.impl.adminphieudiemModelImpl;
import com.liferay.docs.backend.service.persistence.adminphieudiemPersistence;
import com.liferay.docs.backend.service.persistence.adminphieudiemUtil;
import com.liferay.docs.backend.service.persistence.impl.constants.TimekeepingPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the adminphieudiem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {adminphieudiemPersistence.class, BasePersistence.class})
public class adminphieudiemPersistenceImpl
	extends BasePersistenceImpl<adminphieudiem>
	implements adminphieudiemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>adminphieudiemUtil</code> to access the adminphieudiem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		adminphieudiemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByid;
	private FinderPath _finderPathWithoutPaginationFindByid;
	private FinderPath _finderPathCountByid;

	/**
	 * Returns all the adminphieudiems where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching adminphieudiems
	 */
	@Override
	public List<adminphieudiem> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<adminphieudiem> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
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
	@Override
	public List<adminphieudiem> findByid(
		int id, int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
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
	@Override
	public List<adminphieudiem> findByid(
		int id, int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByid;
				finderArgs = new Object[] {id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByid;
			finderArgs = new Object[] {id, start, end, orderByComparator};
		}

		List<adminphieudiem> list = null;

		if (useFinderCache) {
			list = (List<adminphieudiem>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (adminphieudiem adminphieudiem : list) {
					if (id != adminphieudiem.getId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ADMINPHIEUDIEM_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(adminphieudiemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<adminphieudiem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adminphieudiem
	 * @throws NoSuchadminphieudiemException if a matching adminphieudiem could not be found
	 */
	@Override
	public adminphieudiem findByid_First(
			int id, OrderByComparator<adminphieudiem> orderByComparator)
		throws NoSuchadminphieudiemException {

		adminphieudiem adminphieudiem = fetchByid_First(id, orderByComparator);

		if (adminphieudiem != null) {
			return adminphieudiem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchadminphieudiemException(sb.toString());
	}

	/**
	 * Returns the first adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adminphieudiem, or <code>null</code> if a matching adminphieudiem could not be found
	 */
	@Override
	public adminphieudiem fetchByid_First(
		int id, OrderByComparator<adminphieudiem> orderByComparator) {

		List<adminphieudiem> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adminphieudiem
	 * @throws NoSuchadminphieudiemException if a matching adminphieudiem could not be found
	 */
	@Override
	public adminphieudiem findByid_Last(
			int id, OrderByComparator<adminphieudiem> orderByComparator)
		throws NoSuchadminphieudiemException {

		adminphieudiem adminphieudiem = fetchByid_Last(id, orderByComparator);

		if (adminphieudiem != null) {
			return adminphieudiem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchadminphieudiemException(sb.toString());
	}

	/**
	 * Returns the last adminphieudiem in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adminphieudiem, or <code>null</code> if a matching adminphieudiem could not be found
	 */
	@Override
	public adminphieudiem fetchByid_Last(
		int id, OrderByComparator<adminphieudiem> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<adminphieudiem> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the adminphieudiems where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (adminphieudiem adminphieudiem :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(adminphieudiem);
		}
	}

	/**
	 * Returns the number of adminphieudiems where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching adminphieudiems
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADMINPHIEUDIEM_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ID_ID_2 =
		"adminphieudiem.id = ?";

	public adminphieudiemPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(adminphieudiem.class);

		setModelImplClass(adminphieudiemImpl.class);
		setModelPKClass(int.class);

		setTable(adminphieudiemTable.INSTANCE);
	}

	/**
	 * Caches the adminphieudiem in the entity cache if it is enabled.
	 *
	 * @param adminphieudiem the adminphieudiem
	 */
	@Override
	public void cacheResult(adminphieudiem adminphieudiem) {
		entityCache.putResult(
			adminphieudiemImpl.class, adminphieudiem.getPrimaryKey(),
			adminphieudiem);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the adminphieudiems in the entity cache if it is enabled.
	 *
	 * @param adminphieudiems the adminphieudiems
	 */
	@Override
	public void cacheResult(List<adminphieudiem> adminphieudiems) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (adminphieudiems.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (adminphieudiem adminphieudiem : adminphieudiems) {
			if (entityCache.getResult(
					adminphieudiemImpl.class, adminphieudiem.getPrimaryKey()) ==
						null) {

				cacheResult(adminphieudiem);
			}
		}
	}

	/**
	 * Clears the cache for all adminphieudiems.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(adminphieudiemImpl.class);

		finderCache.clearCache(adminphieudiemImpl.class);
	}

	/**
	 * Clears the cache for the adminphieudiem.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(adminphieudiem adminphieudiem) {
		entityCache.removeResult(adminphieudiemImpl.class, adminphieudiem);
	}

	@Override
	public void clearCache(List<adminphieudiem> adminphieudiems) {
		for (adminphieudiem adminphieudiem : adminphieudiems) {
			entityCache.removeResult(adminphieudiemImpl.class, adminphieudiem);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(adminphieudiemImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(adminphieudiemImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new adminphieudiem with the primary key. Does not add the adminphieudiem to the database.
	 *
	 * @param id the primary key for the new adminphieudiem
	 * @return the new adminphieudiem
	 */
	@Override
	public adminphieudiem create(int id) {
		adminphieudiem adminphieudiem = new adminphieudiemImpl();

		adminphieudiem.setNew(true);
		adminphieudiem.setPrimaryKey(id);

		return adminphieudiem;
	}

	/**
	 * Removes the adminphieudiem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem that was removed
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public adminphieudiem remove(int id) throws NoSuchadminphieudiemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the adminphieudiem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the adminphieudiem
	 * @return the adminphieudiem that was removed
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public adminphieudiem remove(Serializable primaryKey)
		throws NoSuchadminphieudiemException {

		Session session = null;

		try {
			session = openSession();

			adminphieudiem adminphieudiem = (adminphieudiem)session.get(
				adminphieudiemImpl.class, primaryKey);

			if (adminphieudiem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchadminphieudiemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(adminphieudiem);
		}
		catch (NoSuchadminphieudiemException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected adminphieudiem removeImpl(adminphieudiem adminphieudiem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adminphieudiem)) {
				adminphieudiem = (adminphieudiem)session.get(
					adminphieudiemImpl.class,
					adminphieudiem.getPrimaryKeyObj());
			}

			if (adminphieudiem != null) {
				session.delete(adminphieudiem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (adminphieudiem != null) {
			clearCache(adminphieudiem);
		}

		return adminphieudiem;
	}

	@Override
	public adminphieudiem updateImpl(adminphieudiem adminphieudiem) {
		boolean isNew = adminphieudiem.isNew();

		if (!(adminphieudiem instanceof adminphieudiemModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(adminphieudiem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					adminphieudiem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in adminphieudiem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom adminphieudiem implementation " +
					adminphieudiem.getClass());
		}

		adminphieudiemModelImpl adminphieudiemModelImpl =
			(adminphieudiemModelImpl)adminphieudiem;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(adminphieudiem);
			}
			else {
				adminphieudiem = (adminphieudiem)session.merge(adminphieudiem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			adminphieudiemImpl.class, adminphieudiemModelImpl, false, true);

		if (isNew) {
			adminphieudiem.setNew(false);
		}

		adminphieudiem.resetOriginalValues();

		return adminphieudiem;
	}

	/**
	 * Returns the adminphieudiem with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the adminphieudiem
	 * @return the adminphieudiem
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public adminphieudiem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchadminphieudiemException {

		adminphieudiem adminphieudiem = fetchByPrimaryKey(primaryKey);

		if (adminphieudiem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchadminphieudiemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return adminphieudiem;
	}

	/**
	 * Returns the adminphieudiem with the primary key or throws a <code>NoSuchadminphieudiemException</code> if it could not be found.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem
	 * @throws NoSuchadminphieudiemException if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public adminphieudiem findByPrimaryKey(int id)
		throws NoSuchadminphieudiemException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the adminphieudiem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the adminphieudiem
	 * @return the adminphieudiem, or <code>null</code> if a adminphieudiem with the primary key could not be found
	 */
	@Override
	public adminphieudiem fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the adminphieudiems.
	 *
	 * @return the adminphieudiems
	 */
	@Override
	public List<adminphieudiem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<adminphieudiem> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<adminphieudiem> findAll(
		int start, int end,
		OrderByComparator<adminphieudiem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<adminphieudiem> findAll(
		int start, int end, OrderByComparator<adminphieudiem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<adminphieudiem> list = null;

		if (useFinderCache) {
			list = (List<adminphieudiem>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADMINPHIEUDIEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADMINPHIEUDIEM;

				sql = sql.concat(adminphieudiemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<adminphieudiem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the adminphieudiems from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (adminphieudiem adminphieudiem : findAll()) {
			remove(adminphieudiem);
		}
	}

	/**
	 * Returns the number of adminphieudiems.
	 *
	 * @return the number of adminphieudiems
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADMINPHIEUDIEM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADMINPHIEUDIEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return adminphieudiemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the adminphieudiem persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"id_"}, true);

		_finderPathWithoutPaginationFindByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid",
			new String[] {Integer.class.getName()}, new String[] {"id_"}, true);

		_finderPathCountByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] {Integer.class.getName()}, new String[] {"id_"},
			false);

		_setadminphieudiemUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setadminphieudiemUtilPersistence(null);

		entityCache.removeCache(adminphieudiemImpl.class.getName());
	}

	private void _setadminphieudiemUtilPersistence(
		adminphieudiemPersistence adminphieudiemPersistence) {

		try {
			Field field = adminphieudiemUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, adminphieudiemPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = TimekeepingPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = TimekeepingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TimekeepingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ADMINPHIEUDIEM =
		"SELECT adminphieudiem FROM adminphieudiem adminphieudiem";

	private static final String _SQL_SELECT_ADMINPHIEUDIEM_WHERE =
		"SELECT adminphieudiem FROM adminphieudiem adminphieudiem WHERE ";

	private static final String _SQL_COUNT_ADMINPHIEUDIEM =
		"SELECT COUNT(adminphieudiem) FROM adminphieudiem adminphieudiem";

	private static final String _SQL_COUNT_ADMINPHIEUDIEM_WHERE =
		"SELECT COUNT(adminphieudiem) FROM adminphieudiem adminphieudiem WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "adminphieudiem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No adminphieudiem exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No adminphieudiem exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		adminphieudiemPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private adminphieudiemModelArgumentsResolver
		_adminphieudiemModelArgumentsResolver;

}