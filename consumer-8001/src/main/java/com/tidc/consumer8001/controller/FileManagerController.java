package com.tidc.consumer8001.controller;

import com.tidc.api.controller.FileManagerApi;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileManagerController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class FileManagerController {
	@Autowired
	private FileManagerService fileManagerService;
	@PostMapping(value = "/file" ,headers = "content-type=multipart/form-data")
	public UserOV uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name){
		return fileManagerService.uploadFile(file, name);
	}
}
