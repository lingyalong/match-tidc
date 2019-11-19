package com.tidc.api.controller;

import com.tidc.api.fallback.ContestManagerFallbackFactory;
import com.tidc.api.fallback.FileManagerFallbackFactory;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "FILEMANAGE",fallbackFactory = FileManagerFallbackFactory.class)
public interface FileManagerApi {
	@RequestMapping(value = "/file",method = RequestMethod.POST)
	UserOV uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name);
}
