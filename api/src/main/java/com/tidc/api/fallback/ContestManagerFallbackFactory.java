package com.tidc.api.fallback;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;

/**
 * @ClassNmae ContestManagerFallbackFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class ContestManagerFallbackFactory implements FallbackFactory<ContestManagerApi> {
	public ContestManagerApi create(Throwable throwable) {
		return new ContestManagerApi() {
			public UserOV foundContest(Contest contest, String school_email) {
				return null;
			}
		};
	}
}
