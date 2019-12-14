package com.tidc.exam.mapper;

import com.tidc.api.pojo.exam.HistoryQuestion;
import com.tidc.api.pojo.exam.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae HistoryQuestionMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface HistoryQuestionMapper {
	void copyQuestion(List<Question> list);
	List<HistoryQuestion> getAnswerAndScore(int id);
}
