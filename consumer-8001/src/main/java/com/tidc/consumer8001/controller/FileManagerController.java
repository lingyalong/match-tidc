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
	@PostMapping(value = "/photo/file")
	public UserOV<String> uploadPhoto(@RequestParam("file") MultipartFile file, @RequestParam("name") String name){
		return fileManagerService.uploadPhoto(file,name);
	}
	@PostMapping("/details/file")
	public UserOV<String> uploadDetails(@RequestParam("file") MultipartFile file, @RequestParam("name") String name){
		return fileManagerService.uploadDetails(file,name);
	}
}
