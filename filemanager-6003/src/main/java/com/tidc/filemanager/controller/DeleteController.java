package com.tidc.filemanager.controller;

import com.tidc.api.exception.DeleteFailedException;
import com.tidc.api.pojo.UserOV;
import com.tidc.filemanager.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae DeleteController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class DeleteController {
	@Autowired
	private DeleteService deleteService;
	@DeleteMapping("/file")
	public UserOV deleteFile(@RequestParam("path") String path) throws DeleteFailedException {
		return deleteService.deleteFile(path);
	}

}
