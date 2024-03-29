package com.tidc.api.fallback;

import com.tidc.api.controller.ExamManagerApi;
import com.tidc.api.pojo.exam.*;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * @ClassNmae ExamManagerFallbackFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class ExamManagerFallbackFactory implements FallbackFactory<ExamManagerApi> {
	public ExamManagerApi create(Throwable throwable) {
		return new ExamManagerApi() {
			public UserOV<List<Examination>> listExamination(int schoolId) {
				return null;
			}

			public UserOV<List<Question>> listQuestion(int schoolId) {
				return null;
			}

			public UserOV<Examination> getExaminationInQuestion(int id) {
				return null;
			}

			public UserOV<HistoryExamination> getHistoryExamination(int id) {
				return null;
			}

			public UserOV foundQuestion(Question question) {
				return null;
			}

			public UserOV foundExamination(Examination examination) {
				return null;
			}

			public UserOV ExaminationAddQuestion(ExaminationQuestion examinationQuestion) {
				return null;
			}

			public UserOV<Integer> foundHistoryExamination(int contestId, int examinationId) {
				return null;
			}

			public UserOV historyJoinQuestion(HistoryExamination historyExamination) {
				return null;
			}

			public UserOV<Record> record(Record record) {
				return null;
			}

			public UserOV alterQuestion(Question question) {
				return null;
			}

			public UserOV alterExamination(Examination examination) {
				return null;
			}

			public UserOV deleteQuestion(Question question) {
				return null;
			}

			public UserOV deleteExamination(Examination examination) {
				return null;
			}

			public UserOV examinationDeleteQuestion(ExaminationQuestion examinationQuestion) {
				return null;
			}
		};
	}
}
