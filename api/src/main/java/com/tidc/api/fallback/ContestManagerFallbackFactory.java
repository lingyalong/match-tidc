package com.tidc.api.fallback;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import feign.hystrix.FallbackFactory;

import java.util.List;

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

			public UserOV addPower(Power power, String email) {
				return null;
			}

			public UserOV addType(String name) {
				return null;
			}

			public UserOV<List<Contest>> getContestAll() {
				return null;
			}

			public UserOV apply(Work work, String email) {
				return null;
			}

			public UserOV<List<Contest>> getTypeContest(String type) {
				return null;
			}
		};
	}
}
