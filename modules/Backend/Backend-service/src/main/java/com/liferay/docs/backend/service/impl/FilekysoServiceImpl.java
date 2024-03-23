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

package com.liferay.docs.backend.service.impl;

import com.liferay.docs.backend.service.FilekysoLocalServiceUtil;
import com.liferay.docs.backend.service.base.FilekysoServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ks",
		"json.web.service.context.path=Filekyso"
	},
	service = AopService.class
)
public class FilekysoServiceImpl extends FilekysoServiceBaseImpl {
	@JSONWebService(value = "getchukyso")
	public Response addFilekyso(File uploadfile, String file_id, String fileUrl) throws PortalException {
		System.out.println("tenfile ******------------------- " + uploadfile);
		System.out.println("file_id ******------------------- " + file_id);
		long FileId = Long.parseLong(file_id);
		System.out.println("fileUrl ******------------------- " + fileUrl);
		String targetDirectory = "D:\\AppTimekeeping\\liferay-ce-portal-7.4.3.42-ga42\\filePdfSigned";

		// Thay đổi phần mở rộng của tên file
		String signedFileUrl = changeFileExtension(fileUrl, "signed.pdf");

		// In ra kết quả
		System.out.println("Ten file moi: " + signedFileUrl);

		String targetFileName = fileUrl;
		try {
			File tenfilemoi = saveFileToDirectoryAsPDF(uploadfile, targetDirectory, signedFileUrl);
			System.out.println("tenfilemoi ----------------" + tenfilemoi);
			FilekysoLocalServiceUtil.addfileSigned(targetFileName, signedFileUrl, FileId);
			return Response.ok("File uploaded successfully").build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// Trả về response lỗi nếu có vấn đề trong quá trình xử lý file
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error uploading file").build();
		}

	}

	private static String changeFileExtension(String fileName, String newExtension) {
		int lastDotIndex = fileName.lastIndexOf(".");
		if (lastDotIndex != -1) {
			// Tách phần trước dấu chấm (tên cơ bản) và thêm phần mở rộng mới
			return fileName.substring(0, lastDotIndex) + "." + newExtension;
		} else {
			// Nếu không có dấu chấm, chỉ thêm phần mở rộng mới
			return fileName + "." + newExtension;
		}
	}

	public File saveFileToDirectoryAsPDF(File sourceFile, String targetDirectory, String targetFileName)
			throws IOException {
		File targetDir = new File(targetDirectory);

		// Kiểm tra xem thư mục đích có tồn tại không, nếu không thì tạo mới
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}

		// Tạo một đối tượng File cho tệp đích với tên mong muốn
		File targetFile = new File(targetDirectory, targetFileName);

		// Di chuyển tệp nguồn đến thư mục đích với tên mới
		Path sourcePath = sourceFile.toPath();
		Path targetPath = targetFile.toPath();
		Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

		return targetFile;
	}

}