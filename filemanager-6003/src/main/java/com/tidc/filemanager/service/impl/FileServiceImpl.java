package com.tidc.filemanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
import com.tidc.filemanager.exception.TypeException;
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
	public UserOV<String> uploadPhoto(MultipartFile file, String name){
		UserOV<String> userOV = new UserOV<>();
		String fileName = "";
		try {
			boolean is_type = FileUtil.isNumType(".jpg,.png", file.getOriginalFilename());
			if(!is_type){
				throw new TypeException("上传的文件不符合图片格式");
			}
			fileName = FileUtil.saveFile(matchProperties.getFileProperties().getFilePath(), file, name);
		} catch (IOException e) {
			e.printStackTrace();
			userOV.setStatus(CodeConstant.ERROR).setData("文件上传失败").setCode(31);
		} catch (TypeException e) {
			e.printStackTrace();
			userOV.setStatus(CodeConstant.ERROR).setData("文件格式不正确").setCode(31);

		}
		userOV.setStatus(CodeConstant.SUCCESS).setData(fileName);
		return userOV;
	}

	@Override
	public UserOV<String> uploadDetails(MultipartFile file, String name) {
		UserOV<String> userOV = new UserOV<>();
		String fileName = "";
		try {
			boolean is_type = FileUtil.isNumType(".zip,.rar", file.getOriginalFilename());
			if(!is_type){
				throw new TypeException("上传的文件不符合压缩包格式");
			}
			fileName = FileUtil.saveFile(matchProperties.getFileProperties().getFilePath(), file, name);
		} catch (IOException e) {
			e.printStackTrace();
			userOV.setStatus(CodeConstant.ERROR).setData("文件上传失败").setCode(31);
		} catch (TypeException e) {
			e.printStackTrace();
			userOV.setStatus(CodeConstant.ERROR).setData("文件格式不正确").setCode(31);

		}
		userOV.setStatus(CodeConstant.SUCCESS).setData(fileName);
		return userOV;
	}
}
