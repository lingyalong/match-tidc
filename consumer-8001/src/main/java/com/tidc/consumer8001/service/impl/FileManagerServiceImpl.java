package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.FileManagerApi;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.FileManagerService;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileManagerServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class FileManagerServiceImpl implements FileManagerService {
	@Autowired
	private FileManagerApi fileManagerApi;
	@Override
	public UserOV uploadFile( MultipartFile file, String name) {
		return fileManagerApi.uploadFile(file,name);
	}
}
