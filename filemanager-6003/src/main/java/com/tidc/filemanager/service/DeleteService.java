package com.tidc.filemanager.service;

import com.tidc.api.exception.DeleteFailedException;
import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae DeleteService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface DeleteService {
	UserOV deleteFile(String url) throws DeleteFailedException;
}
