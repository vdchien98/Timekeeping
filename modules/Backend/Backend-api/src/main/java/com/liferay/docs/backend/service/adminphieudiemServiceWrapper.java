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
 * Provides a wrapper for {@link adminphieudiemService}.
 *
 * @author Brian Wing Shun Chan
 * @see adminphieudiemService
 * @generated
 */
public class adminphieudiemServiceWrapper
	implements adminphieudiemService, ServiceWrapper<adminphieudiemService> {

	public adminphieudiemServiceWrapper() {
		this(null);
	}

	public adminphieudiemServiceWrapper(
		adminphieudiemService adminphieudiemService) {

		_adminphieudiemService = adminphieudiemService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _adminphieudiemService.getOSGiServiceIdentifier();
	}

	@Override
	public adminphieudiemService getWrappedService() {
		return _adminphieudiemService;
	}

	@Override
	public void setWrappedService(adminphieudiemService adminphieudiemService) {
		_adminphieudiemService = adminphieudiemService;
	}

	private adminphieudiemService _adminphieudiemService;

}