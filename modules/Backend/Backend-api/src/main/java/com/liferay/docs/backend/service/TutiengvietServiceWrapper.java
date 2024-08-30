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
 * Provides a wrapper for {@link TutiengvietService}.
 *
 * @author Brian Wing Shun Chan
 * @see TutiengvietService
 * @generated
 */
public class TutiengvietServiceWrapper
	implements ServiceWrapper<TutiengvietService>, TutiengvietService {

	public TutiengvietServiceWrapper() {
		this(null);
	}

	public TutiengvietServiceWrapper(TutiengvietService tutiengvietService) {
		_tutiengvietService = tutiengvietService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tutiengvietService.getOSGiServiceIdentifier();
	}

	@Override
	public TutiengvietService getWrappedService() {
		return _tutiengvietService;
	}

	@Override
	public void setWrappedService(TutiengvietService tutiengvietService) {
		_tutiengvietService = tutiengvietService;
	}

	private TutiengvietService _tutiengvietService;

}