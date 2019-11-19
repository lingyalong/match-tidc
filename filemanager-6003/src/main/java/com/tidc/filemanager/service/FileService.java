package com.tidc.filemanager.service;

import com.tidc.api.pojo.UserOV;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileController
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FileService {
	UserOV uploadFile(MultipartFile file,String name);

}
