package com.tidc.filemanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.exception.DeleteFailedException;
import com.tidc.api.pojo.UserOV;
import com.tidc.filemanager.service.DeleteService;
import com.tidc.filemanager.utiles.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae DeleteServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class DeleteServiceImpl implements DeleteService {

	@Override
	public UserOV deleteFile(String path) throws DeleteFailedException {
		boolean b = FileUtil.deleteFile(path);
		if(!b){
			throw new DeleteFailedException(path+"删除失败");
		}
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}
}
