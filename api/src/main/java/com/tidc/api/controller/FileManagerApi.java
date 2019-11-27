package com.tidc.api.controller;

import com.tidc.api.fallback.ContestManagerFallbackFactory;
import com.tidc.api.fallback.FileManagerFallbackFactory;
import com.tidc.api.pojo.UserOV;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
/**
 * @ClassNmae FileManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
//@Headers("Content-Type: multipart/form-data")
@FeignClient(value = "FILEMANAGER",fallbackFactory = FileManagerFallbackFactory.class)
public interface FileManagerApi {
	@RequestMapping(value = "/photo/file", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	UserOV<String> uploadPhoto(@RequestPart("file") MultipartFile file, @RequestParam("name") String name);
	@RequestMapping(value = "/details/file",method =RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	UserOV<String> uploadDetails(@RequestPart("file") MultipartFile file,@RequestParam("name") String name);

	@RequestMapping(value = "/file",method = RequestMethod.DELETE)
	UserOV deleteFile(@RequestParam("path") String path);
}
