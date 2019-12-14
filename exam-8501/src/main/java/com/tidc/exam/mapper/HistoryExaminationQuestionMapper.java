package com.tidc.exam.mapper;

import com.tidc.api.pojo.exam.HistoryExamination;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae HistoryExaminationQuestion
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface HistoryExaminationQuestionMapper {
	void join(HistoryExamination historyExamination);


}
