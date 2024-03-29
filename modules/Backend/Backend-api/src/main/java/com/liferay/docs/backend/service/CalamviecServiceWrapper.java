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
 * Provides a wrapper for {@link CalamviecService}.
 *
 * @author Brian Wing Shun Chan
 * @see CalamviecService
 * @generated
 */
public class CalamviecServiceWrapper
	implements CalamviecService, ServiceWrapper<CalamviecService> {

	public CalamviecServiceWrapper() {
		this(null);
	}

	public CalamviecServiceWrapper(CalamviecService calamviecService) {
		_calamviecService = calamviecService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _calamviecService.getOSGiServiceIdentifier();
	}

	@Override
	public CalamviecService getWrappedService() {
		return _calamviecService;
	}

	@Override
	public void setWrappedService(CalamviecService calamviecService) {
		_calamviecService = calamviecService;
	}

	private CalamviecService _calamviecService;

}