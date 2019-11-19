package com.tidc.filemanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
import com.tidc.filemanager.properties.FileProperties;
import com.tidc.filemanager.properties.MatchProperties;
import com.tidc.filemanager.service.FileService;
import com.tidc.filemanager.utiles.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassNmae FileServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private MatchProperties matchProperties;
	@Override
	public UserOV uploadFile(MultipartFile file, String name){
		UserOV userOV = new UserOV();
		String fileName = "";
		try {
			fileName = FileUtil.saveFile(matchProperties.getFileProperties().getFilePath(), file, name);
		} catch (IOException e) {
			e.printStackTrace();
			userOV.setStatus(CodeConstant.ERROR).setMessage("文件上传失败").setCode(31);
		}
		userOV.setStatus(CodeConstant.SUCCESS).setMessage(fileName);
		return userOV;
	}
}
