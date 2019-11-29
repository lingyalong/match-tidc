package com.tidc.api.fallback;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.*;
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

			public UserOV<Contest> updateContest(Contest contest) {
				return null;
			}

			public UserOV addMember(Team team) {
				return null;
			}

			public UserOV deleteMember(Team team) {
				return null;
			}

			public UserOV deleteContest(Contest contest) {
				return null;
			}

			public UserOV deleteWork(Work work) {
				return null;
			}

			public UserOV deleteWorkAndTeam(int contest_id) {
				return null;
			}

			public UserOV deletePower(Power power) {
				return null;
			}
		};
	}
}
