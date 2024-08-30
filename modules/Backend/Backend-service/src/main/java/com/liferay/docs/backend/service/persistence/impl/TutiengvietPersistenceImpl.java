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

import com.liferay.docs.backend.exception.NoSuchTutiengvietException;
import com.liferay.docs.backend.model.Tutiengviet;
import com.liferay.docs.backend.model.TutiengvietTable;
import com.liferay.docs.backend.model.impl.TutiengvietImpl;
import com.liferay.docs.backend.model.impl.TutiengvietModelImpl;
import com.liferay.docs.backend.service.persistence.TutiengvietPersistence;
import com.liferay.docs.backend.service.persistence.TutiengvietUtil;
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
 * The persistence implementation for the tutiengviet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TutiengvietPersistence.class, BasePersistence.class})
public class TutiengvietPersistenceImpl
	extends BasePersistenceImpl<Tutiengviet> implements TutiengvietPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TutiengvietUtil</code> to access the tutiengviet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TutiengvietImpl.class.getName();

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
	 * Returns all the tutiengviets where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching tutiengviets
	 */
	@Override
	public List<Tutiengviet> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tutiengviet> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
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
	@Override
	public List<Tutiengviet> findByid(
		int id, int start, int end,
		OrderByComparator<Tutiengviet> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
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
	@Override
	public List<Tutiengviet> findByid(
		int id, int start, int end,
		OrderByComparator<Tutiengviet> orderByComparator,
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

		List<Tutiengviet> list = null;

		if (useFinderCache) {
			list = (List<Tutiengviet>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Tutiengviet tutiengviet : list) {
					if (id != tutiengviet.getId()) {
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

			sb.append(_SQL_SELECT_TUTIENGVIET_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TutiengvietModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Tutiengviet>)QueryUtil.list(
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
	 * Returns the first tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tutiengviet
	 * @throws NoSuchTutiengvietException if a matching tutiengviet could not be found
	 */
	@Override
	public Tutiengviet findByid_First(
			int id, OrderByComparator<Tutiengviet> orderByComparator)
		throws NoSuchTutiengvietException {

		Tutiengviet tutiengviet = fetchByid_First(id, orderByComparator);

		if (tutiengviet != null) {
			return tutiengviet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchTutiengvietException(sb.toString());
	}

	/**
	 * Returns the first tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tutiengviet, or <code>null</code> if a matching tutiengviet could not be found
	 */
	@Override
	public Tutiengviet fetchByid_First(
		int id, OrderByComparator<Tutiengviet> orderByComparator) {

		List<Tutiengviet> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tutiengviet
	 * @throws NoSuchTutiengvietException if a matching tutiengviet could not be found
	 */
	@Override
	public Tutiengviet findByid_Last(
			int id, OrderByComparator<Tutiengviet> orderByComparator)
		throws NoSuchTutiengvietException {

		Tutiengviet tutiengviet = fetchByid_Last(id, orderByComparator);

		if (tutiengviet != null) {
			return tutiengviet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchTutiengvietException(sb.toString());
	}

	/**
	 * Returns the last tutiengviet in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tutiengviet, or <code>null</code> if a matching tutiengviet could not be found
	 */
	@Override
	public Tutiengviet fetchByid_Last(
		int id, OrderByComparator<Tutiengviet> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Tutiengviet> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the tutiengviets where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Tutiengviet tutiengviet :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tutiengviet);
		}
	}

	/**
	 * Returns the number of tutiengviets where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching tutiengviets
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TUTIENGVIET_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "tutiengviet.id = ?";

	public TutiengvietPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Tutiengviet.class);

		setModelImplClass(TutiengvietImpl.class);
		setModelPKClass(int.class);

		setTable(TutiengvietTable.INSTANCE);
	}

	/**
	 * Caches the tutiengviet in the entity cache if it is enabled.
	 *
	 * @param tutiengviet the tutiengviet
	 */
	@Override
	public void cacheResult(Tutiengviet tutiengviet) {
		entityCache.putResult(
			TutiengvietImpl.class, tutiengviet.getPrimaryKey(), tutiengviet);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tutiengviets in the entity cache if it is enabled.
	 *
	 * @param tutiengviets the tutiengviets
	 */
	@Override
	public void cacheResult(List<Tutiengviet> tutiengviets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tutiengviets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Tutiengviet tutiengviet : tutiengviets) {
			if (entityCache.getResult(
					TutiengvietImpl.class, tutiengviet.getPrimaryKey()) ==
						null) {

				cacheResult(tutiengviet);
			}
		}
	}

	/**
	 * Clears the cache for all tutiengviets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TutiengvietImpl.class);

		finderCache.clearCache(TutiengvietImpl.class);
	}

	/**
	 * Clears the cache for the tutiengviet.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tutiengviet tutiengviet) {
		entityCache.removeResult(TutiengvietImpl.class, tutiengviet);
	}

	@Override
	public void clearCache(List<Tutiengviet> tutiengviets) {
		for (Tutiengviet tutiengviet : tutiengviets) {
			entityCache.removeResult(TutiengvietImpl.class, tutiengviet);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TutiengvietImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TutiengvietImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new tutiengviet with the primary key. Does not add the tutiengviet to the database.
	 *
	 * @param id the primary key for the new tutiengviet
	 * @return the new tutiengviet
	 */
	@Override
	public Tutiengviet create(int id) {
		Tutiengviet tutiengviet = new TutiengvietImpl();

		tutiengviet.setNew(true);
		tutiengviet.setPrimaryKey(id);

		return tutiengviet;
	}

	/**
	 * Removes the tutiengviet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet that was removed
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	@Override
	public Tutiengviet remove(int id) throws NoSuchTutiengvietException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tutiengviet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tutiengviet
	 * @return the tutiengviet that was removed
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	@Override
	public Tutiengviet remove(Serializable primaryKey)
		throws NoSuchTutiengvietException {

		Session session = null;

		try {
			session = openSession();

			Tutiengviet tutiengviet = (Tutiengviet)session.get(
				TutiengvietImpl.class, primaryKey);

			if (tutiengviet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTutiengvietException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tutiengviet);
		}
		catch (NoSuchTutiengvietException noSuchEntityException) {
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
	protected Tutiengviet removeImpl(Tutiengviet tutiengviet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tutiengviet)) {
				tutiengviet = (Tutiengviet)session.get(
					TutiengvietImpl.class, tutiengviet.getPrimaryKeyObj());
			}

			if (tutiengviet != null) {
				session.delete(tutiengviet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tutiengviet != null) {
			clearCache(tutiengviet);
		}

		return tutiengviet;
	}

	@Override
	public Tutiengviet updateImpl(Tutiengviet tutiengviet) {
		boolean isNew = tutiengviet.isNew();

		if (!(tutiengviet instanceof TutiengvietModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tutiengviet.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tutiengviet);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tutiengviet proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Tutiengviet implementation " +
					tutiengviet.getClass());
		}

		TutiengvietModelImpl tutiengvietModelImpl =
			(TutiengvietModelImpl)tutiengviet;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tutiengviet);
			}
			else {
				tutiengviet = (Tutiengviet)session.merge(tutiengviet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TutiengvietImpl.class, tutiengvietModelImpl, false, true);

		if (isNew) {
			tutiengviet.setNew(false);
		}

		tutiengviet.resetOriginalValues();

		return tutiengviet;
	}

	/**
	 * Returns the tutiengviet with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tutiengviet
	 * @return the tutiengviet
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	@Override
	public Tutiengviet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTutiengvietException {

		Tutiengviet tutiengviet = fetchByPrimaryKey(primaryKey);

		if (tutiengviet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTutiengvietException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tutiengviet;
	}

	/**
	 * Returns the tutiengviet with the primary key or throws a <code>NoSuchTutiengvietException</code> if it could not be found.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet
	 * @throws NoSuchTutiengvietException if a tutiengviet with the primary key could not be found
	 */
	@Override
	public Tutiengviet findByPrimaryKey(int id)
		throws NoSuchTutiengvietException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tutiengviet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet, or <code>null</code> if a tutiengviet with the primary key could not be found
	 */
	@Override
	public Tutiengviet fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the tutiengviets.
	 *
	 * @return the tutiengviets
	 */
	@Override
	public List<Tutiengviet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tutiengviet> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Tutiengviet> findAll(
		int start, int end, OrderByComparator<Tutiengviet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Tutiengviet> findAll(
		int start, int end, OrderByComparator<Tutiengviet> orderByComparator,
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

		List<Tutiengviet> list = null;

		if (useFinderCache) {
			list = (List<Tutiengviet>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TUTIENGVIET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TUTIENGVIET;

				sql = sql.concat(TutiengvietModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Tutiengviet>)QueryUtil.list(
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
	 * Removes all the tutiengviets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tutiengviet tutiengviet : findAll()) {
			remove(tutiengviet);
		}
	}

	/**
	 * Returns the number of tutiengviets.
	 *
	 * @return the number of tutiengviets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TUTIENGVIET);

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
		return _SQL_SELECT_TUTIENGVIET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TutiengvietModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tutiengviet persistence.
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

		_setTutiengvietUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTutiengvietUtilPersistence(null);

		entityCache.removeCache(TutiengvietImpl.class.getName());
	}

	private void _setTutiengvietUtilPersistence(
		TutiengvietPersistence tutiengvietPersistence) {

		try {
			Field field = TutiengvietUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, tutiengvietPersistence);
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

	private static final String _SQL_SELECT_TUTIENGVIET =
		"SELECT tutiengviet FROM Tutiengviet tutiengviet";

	private static final String _SQL_SELECT_TUTIENGVIET_WHERE =
		"SELECT tutiengviet FROM Tutiengviet tutiengviet WHERE ";

	private static final String _SQL_COUNT_TUTIENGVIET =
		"SELECT COUNT(tutiengviet) FROM Tutiengviet tutiengviet";

	private static final String _SQL_COUNT_TUTIENGVIET_WHERE =
		"SELECT COUNT(tutiengviet) FROM Tutiengviet tutiengviet WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tutiengviet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Tutiengviet exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Tutiengviet exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TutiengvietPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TutiengvietModelArgumentsResolver
		_tutiengvietModelArgumentsResolver;

}