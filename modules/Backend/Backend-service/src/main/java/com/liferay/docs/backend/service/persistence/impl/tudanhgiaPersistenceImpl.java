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

import com.liferay.docs.backend.exception.NoSuchtudanhgiaException;
import com.liferay.docs.backend.model.impl.tudanhgiaImpl;
import com.liferay.docs.backend.model.impl.tudanhgiaModelImpl;
import com.liferay.docs.backend.model.tudanhgia;
import com.liferay.docs.backend.model.tudanhgiaTable;
import com.liferay.docs.backend.service.persistence.impl.constants.TimekeepingPersistenceConstants;
import com.liferay.docs.backend.service.persistence.tudanhgiaPersistence;
import com.liferay.docs.backend.service.persistence.tudanhgiaUtil;
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
 * The persistence implementation for the tudanhgia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {tudanhgiaPersistence.class, BasePersistence.class})
public class tudanhgiaPersistenceImpl
	extends BasePersistenceImpl<tudanhgia> implements tudanhgiaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>tudanhgiaUtil</code> to access the tudanhgia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		tudanhgiaImpl.class.getName();

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
	 * Returns all the tudanhgias where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching tudanhgias
	 */
	@Override
	public List<tudanhgia> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<tudanhgia> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

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
	@Override
	public List<tudanhgia> findByid(
		int id, int start, int end,
		OrderByComparator<tudanhgia> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

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
	@Override
	public List<tudanhgia> findByid(
		int id, int start, int end,
		OrderByComparator<tudanhgia> orderByComparator,
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

		List<tudanhgia> list = null;

		if (useFinderCache) {
			list = (List<tudanhgia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (tudanhgia tudanhgia : list) {
					if (id != tudanhgia.getId()) {
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

			sb.append(_SQL_SELECT_TUDANHGIA_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(tudanhgiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<tudanhgia>)QueryUtil.list(
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
	 * Returns the first tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tudanhgia
	 * @throws NoSuchtudanhgiaException if a matching tudanhgia could not be found
	 */
	@Override
	public tudanhgia findByid_First(
			int id, OrderByComparator<tudanhgia> orderByComparator)
		throws NoSuchtudanhgiaException {

		tudanhgia tudanhgia = fetchByid_First(id, orderByComparator);

		if (tudanhgia != null) {
			return tudanhgia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchtudanhgiaException(sb.toString());
	}

	/**
	 * Returns the first tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tudanhgia, or <code>null</code> if a matching tudanhgia could not be found
	 */
	@Override
	public tudanhgia fetchByid_First(
		int id, OrderByComparator<tudanhgia> orderByComparator) {

		List<tudanhgia> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tudanhgia
	 * @throws NoSuchtudanhgiaException if a matching tudanhgia could not be found
	 */
	@Override
	public tudanhgia findByid_Last(
			int id, OrderByComparator<tudanhgia> orderByComparator)
		throws NoSuchtudanhgiaException {

		tudanhgia tudanhgia = fetchByid_Last(id, orderByComparator);

		if (tudanhgia != null) {
			return tudanhgia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchtudanhgiaException(sb.toString());
	}

	/**
	 * Returns the last tudanhgia in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tudanhgia, or <code>null</code> if a matching tudanhgia could not be found
	 */
	@Override
	public tudanhgia fetchByid_Last(
		int id, OrderByComparator<tudanhgia> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<tudanhgia> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the tudanhgias where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (tudanhgia tudanhgia :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tudanhgia);
		}
	}

	/**
	 * Returns the number of tudanhgias where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching tudanhgias
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TUDANHGIA_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "tudanhgia.id = ?";

	public tudanhgiaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(tudanhgia.class);

		setModelImplClass(tudanhgiaImpl.class);
		setModelPKClass(int.class);

		setTable(tudanhgiaTable.INSTANCE);
	}

	/**
	 * Caches the tudanhgia in the entity cache if it is enabled.
	 *
	 * @param tudanhgia the tudanhgia
	 */
	@Override
	public void cacheResult(tudanhgia tudanhgia) {
		entityCache.putResult(
			tudanhgiaImpl.class, tudanhgia.getPrimaryKey(), tudanhgia);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tudanhgias in the entity cache if it is enabled.
	 *
	 * @param tudanhgias the tudanhgias
	 */
	@Override
	public void cacheResult(List<tudanhgia> tudanhgias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tudanhgias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (tudanhgia tudanhgia : tudanhgias) {
			if (entityCache.getResult(
					tudanhgiaImpl.class, tudanhgia.getPrimaryKey()) == null) {

				cacheResult(tudanhgia);
			}
		}
	}

	/**
	 * Clears the cache for all tudanhgias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(tudanhgiaImpl.class);

		finderCache.clearCache(tudanhgiaImpl.class);
	}

	/**
	 * Clears the cache for the tudanhgia.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(tudanhgia tudanhgia) {
		entityCache.removeResult(tudanhgiaImpl.class, tudanhgia);
	}

	@Override
	public void clearCache(List<tudanhgia> tudanhgias) {
		for (tudanhgia tudanhgia : tudanhgias) {
			entityCache.removeResult(tudanhgiaImpl.class, tudanhgia);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(tudanhgiaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(tudanhgiaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new tudanhgia with the primary key. Does not add the tudanhgia to the database.
	 *
	 * @param id the primary key for the new tudanhgia
	 * @return the new tudanhgia
	 */
	@Override
	public tudanhgia create(int id) {
		tudanhgia tudanhgia = new tudanhgiaImpl();

		tudanhgia.setNew(true);
		tudanhgia.setPrimaryKey(id);

		return tudanhgia;
	}

	/**
	 * Removes the tudanhgia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia that was removed
	 * @throws NoSuchtudanhgiaException if a tudanhgia with the primary key could not be found
	 */
	@Override
	public tudanhgia remove(int id) throws NoSuchtudanhgiaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tudanhgia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tudanhgia
	 * @return the tudanhgia that was removed
	 * @throws NoSuchtudanhgiaException if a tudanhgia with the primary key could not be found
	 */
	@Override
	public tudanhgia remove(Serializable primaryKey)
		throws NoSuchtudanhgiaException {

		Session session = null;

		try {
			session = openSession();

			tudanhgia tudanhgia = (tudanhgia)session.get(
				tudanhgiaImpl.class, primaryKey);

			if (tudanhgia == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtudanhgiaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tudanhgia);
		}
		catch (NoSuchtudanhgiaException noSuchEntityException) {
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
	protected tudanhgia removeImpl(tudanhgia tudanhgia) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tudanhgia)) {
				tudanhgia = (tudanhgia)session.get(
					tudanhgiaImpl.class, tudanhgia.getPrimaryKeyObj());
			}

			if (tudanhgia != null) {
				session.delete(tudanhgia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tudanhgia != null) {
			clearCache(tudanhgia);
		}

		return tudanhgia;
	}

	@Override
	public tudanhgia updateImpl(tudanhgia tudanhgia) {
		boolean isNew = tudanhgia.isNew();

		if (!(tudanhgia instanceof tudanhgiaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tudanhgia.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tudanhgia);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tudanhgia proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom tudanhgia implementation " +
					tudanhgia.getClass());
		}

		tudanhgiaModelImpl tudanhgiaModelImpl = (tudanhgiaModelImpl)tudanhgia;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tudanhgia);
			}
			else {
				tudanhgia = (tudanhgia)session.merge(tudanhgia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			tudanhgiaImpl.class, tudanhgiaModelImpl, false, true);

		if (isNew) {
			tudanhgia.setNew(false);
		}

		tudanhgia.resetOriginalValues();

		return tudanhgia;
	}

	/**
	 * Returns the tudanhgia with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tudanhgia
	 * @return the tudanhgia
	 * @throws NoSuchtudanhgiaException if a tudanhgia with the primary key could not be found
	 */
	@Override
	public tudanhgia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchtudanhgiaException {

		tudanhgia tudanhgia = fetchByPrimaryKey(primaryKey);

		if (tudanhgia == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchtudanhgiaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tudanhgia;
	}

	/**
	 * Returns the tudanhgia with the primary key or throws a <code>NoSuchtudanhgiaException</code> if it could not be found.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia
	 * @throws NoSuchtudanhgiaException if a tudanhgia with the primary key could not be found
	 */
	@Override
	public tudanhgia findByPrimaryKey(int id) throws NoSuchtudanhgiaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tudanhgia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tudanhgia
	 * @return the tudanhgia, or <code>null</code> if a tudanhgia with the primary key could not be found
	 */
	@Override
	public tudanhgia fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the tudanhgias.
	 *
	 * @return the tudanhgias
	 */
	@Override
	public List<tudanhgia> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<tudanhgia> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<tudanhgia> findAll(
		int start, int end, OrderByComparator<tudanhgia> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<tudanhgia> findAll(
		int start, int end, OrderByComparator<tudanhgia> orderByComparator,
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

		List<tudanhgia> list = null;

		if (useFinderCache) {
			list = (List<tudanhgia>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TUDANHGIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TUDANHGIA;

				sql = sql.concat(tudanhgiaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<tudanhgia>)QueryUtil.list(
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
	 * Removes all the tudanhgias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (tudanhgia tudanhgia : findAll()) {
			remove(tudanhgia);
		}
	}

	/**
	 * Returns the number of tudanhgias.
	 *
	 * @return the number of tudanhgias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TUDANHGIA);

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
		return _SQL_SELECT_TUDANHGIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return tudanhgiaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tudanhgia persistence.
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

		_settudanhgiaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_settudanhgiaUtilPersistence(null);

		entityCache.removeCache(tudanhgiaImpl.class.getName());
	}

	private void _settudanhgiaUtilPersistence(
		tudanhgiaPersistence tudanhgiaPersistence) {

		try {
			Field field = tudanhgiaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tudanhgiaPersistence);
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

	private static final String _SQL_SELECT_TUDANHGIA =
		"SELECT tudanhgia FROM tudanhgia tudanhgia";

	private static final String _SQL_SELECT_TUDANHGIA_WHERE =
		"SELECT tudanhgia FROM tudanhgia tudanhgia WHERE ";

	private static final String _SQL_COUNT_TUDANHGIA =
		"SELECT COUNT(tudanhgia) FROM tudanhgia tudanhgia";

	private static final String _SQL_COUNT_TUDANHGIA_WHERE =
		"SELECT COUNT(tudanhgia) FROM tudanhgia tudanhgia WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tudanhgia.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No tudanhgia exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No tudanhgia exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		tudanhgiaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private tudanhgiaModelArgumentsResolver _tudanhgiaModelArgumentsResolver;

}