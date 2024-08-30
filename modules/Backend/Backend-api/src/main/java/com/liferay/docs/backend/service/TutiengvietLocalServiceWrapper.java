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

package com.liferay.docs.backend.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TutiengvietLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TutiengvietLocalService
 * @generated
 */
public class TutiengvietLocalServiceWrapper
	implements ServiceWrapper<TutiengvietLocalService>,
			   TutiengvietLocalService {

	public TutiengvietLocalServiceWrapper() {
		this(null);
	}

	public TutiengvietLocalServiceWrapper(
		TutiengvietLocalService tutiengvietLocalService) {

		_tutiengvietLocalService = tutiengvietLocalService;
	}

	/**
	 * Adds the tutiengviet to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TutiengvietLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tutiengviet the tutiengviet
	 * @return the tutiengviet that was added
	 */
	@Override
	public com.liferay.docs.backend.model.Tutiengviet addTutiengviet(
		com.liferay.docs.backend.model.Tutiengviet tutiengviet) {

		return _tutiengvietLocalService.addTutiengviet(tutiengviet);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tutiengvietLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tutiengviet with the primary key. Does not add the tutiengviet to the database.
	 *
	 * @param id the primary key for the new tutiengviet
	 * @return the new tutiengviet
	 */
	@Override
	public com.liferay.docs.backend.model.Tutiengviet createTutiengviet(
		int id) {

		return _tutiengvietLocalService.createTutiengviet(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tutiengvietLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tutiengviet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TutiengvietLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet that was removed
	 * @throws PortalException if a tutiengviet with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.Tutiengviet deleteTutiengviet(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tutiengvietLocalService.deleteTutiengviet(id);
	}

	/**
	 * Deletes the tutiengviet from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TutiengvietLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tutiengviet the tutiengviet
	 * @return the tutiengviet that was removed
	 */
	@Override
	public com.liferay.docs.backend.model.Tutiengviet deleteTutiengviet(
		com.liferay.docs.backend.model.Tutiengviet tutiengviet) {

		return _tutiengvietLocalService.deleteTutiengviet(tutiengviet);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tutiengvietLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tutiengvietLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tutiengvietLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tutiengvietLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tutiengvietLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tutiengvietLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tutiengvietLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tutiengvietLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.backend.model.Tutiengviet fetchTutiengviet(int id) {
		return _tutiengvietLocalService.fetchTutiengviet(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tutiengvietLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tutiengvietLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tutiengvietLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tutiengvietLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tutiengviet with the primary key.
	 *
	 * @param id the primary key of the tutiengviet
	 * @return the tutiengviet
	 * @throws PortalException if a tutiengviet with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.backend.model.Tutiengviet getTutiengviet(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tutiengvietLocalService.getTutiengviet(id);
	}

	/**
	 * Returns a range of all the tutiengviets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.backend.model.impl.TutiengvietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tutiengviets
	 * @param end the upper bound of the range of tutiengviets (not inclusive)
	 * @return the range of tutiengviets
	 */
	@Override
	public java.util.List<com.liferay.docs.backend.model.Tutiengviet>
		getTutiengviets(int start, int end) {

		return _tutiengvietLocalService.getTutiengviets(start, end);
	}

	/**
	 * Returns the number of tutiengviets.
	 *
	 * @return the number of tutiengviets
	 */
	@Override
	public int getTutiengvietsCount() {
		return _tutiengvietLocalService.getTutiengvietsCount();
	}

	/**
	 * Updates the tutiengviet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TutiengvietLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tutiengviet the tutiengviet
	 * @return the tutiengviet that was updated
	 */
	@Override
	public com.liferay.docs.backend.model.Tutiengviet updateTutiengviet(
		com.liferay.docs.backend.model.Tutiengviet tutiengviet) {

		return _tutiengvietLocalService.updateTutiengviet(tutiengviet);
	}

	@Override
	public TutiengvietLocalService getWrappedService() {
		return _tutiengvietLocalService;
	}

	@Override
	public void setWrappedService(
		TutiengvietLocalService tutiengvietLocalService) {

		_tutiengvietLocalService = tutiengvietLocalService;
	}

	private TutiengvietLocalService _tutiengvietLocalService;

}