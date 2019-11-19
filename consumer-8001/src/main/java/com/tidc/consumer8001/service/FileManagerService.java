package com.tidc.consumer8001.service;

import com.tidc.api.pojo.UserOV;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FileManagerService {
	UserOV uploadFile(MultipartFile file,String name);
}
