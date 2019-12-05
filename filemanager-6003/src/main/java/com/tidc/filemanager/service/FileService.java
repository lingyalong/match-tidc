package com.tidc.filemanager.service;

import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassNmae FileController
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FileService {
	UserOV<String> uploadPhoto(MultipartFile file,String name);
	UserOV<String> uploadDetails(MultipartFile file,String name);
	void downFile(String path, HttpServletResponse resp) throws Exception;

}
