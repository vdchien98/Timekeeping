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

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Filekyso. This utility wraps
 * <code>com.liferay.docs.backend.service.impl.FilekysoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FilekysoService
 * @generated
 */
public class FilekysoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.backend.service.impl.FilekysoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static javax.ws.rs.core.Response addFilekyso(
			java.io.File uploadfile, String file_id, String fileUrl)
		throws PortalException {

		return getService().addFilekyso(uploadfile, file_id, fileUrl);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.io.File saveFileToDirectoryAsPDF(
			java.io.File sourceFile, String targetDirectory,
			String targetFileName)
		throws java.io.IOException {

		return getService().saveFileToDirectoryAsPDF(
			sourceFile, targetDirectory, targetFileName);
	}

	public static FilekysoService getService() {
		return _service;
	}

	private static volatile FilekysoService _service;

}