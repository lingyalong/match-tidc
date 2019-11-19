package com.tidc.filemanager.controller;

import com.tidc.api.pojo.UserOV;
import com.tidc.filemanager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class FileController{
	@Autowired
	private FileService fileService;
	@PostMapping("/file")
	public UserOV uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("name") String name){
		return fileService.uploadFile(file, name);
	}
}
