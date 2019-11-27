package com.tidc.api.fallback;

import com.tidc.api.controller.FileManagerApi;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassNmae FileManagerFallbackFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class FileManagerFallbackFactory implements FallbackFactory<FileManagerApi> {
	public FileManagerApi create(Throwable throwable) {
		return new FileManagerApi() {
			public UserOV<String> uploadPhoto(MultipartFile file, String name) {
				return null;
			}

			public UserOV<String> uploadDetails(MultipartFile file, String name) {
				return null;
			}

			public UserOV deleteFile(String path) {
				return null;
			}

			public UserOV uploadFile(MultipartFile file, String name) {
				return null;
			}
		};
	}
}
