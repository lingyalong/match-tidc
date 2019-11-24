package com.tidc.consumer8001.service;

import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FileManagerService {
	UserOV<String> uploadPhoto(MultipartFile file,String name);
	UserOV<String> uploadDetails( MultipartFile file,String name);
}
