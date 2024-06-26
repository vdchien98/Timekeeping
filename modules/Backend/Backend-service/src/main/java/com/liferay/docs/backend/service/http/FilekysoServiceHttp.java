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

package com.liferay.docs.backend.service.http;

import com.liferay.docs.backend.service.FilekysoServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>FilekysoServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FilekysoServiceHttp {

	public static javax.ws.rs.core.Response addFilekyso(
			HttpPrincipal httpPrincipal, java.io.File uploadfile,
			String file_id, long user_id, String fileUrl)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FilekysoServiceUtil.class, "addFilekyso",
				_addFilekysoParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, uploadfile, file_id, user_id, fileUrl);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.io.File saveFileToDirectoryAsPDF(
			HttpPrincipal httpPrincipal, java.io.File sourceFile,
			String targetDirectory, String targetFileName)
		throws java.io.IOException {

		try {
			MethodKey methodKey = new MethodKey(
				FilekysoServiceUtil.class, "saveFileToDirectoryAsPDF",
				_saveFileToDirectoryAsPDFParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, sourceFile, targetDirectory, targetFileName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof java.io.IOException) {
					throw (java.io.IOException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.io.File)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FilekysoServiceHttp.class);

	private static final Class<?>[] _addFilekysoParameterTypes0 = new Class[] {
		java.io.File.class, String.class, long.class, String.class
	};
	private static final Class<?>[] _saveFileToDirectoryAsPDFParameterTypes2 =
		new Class[] {java.io.File.class, String.class, String.class};

}