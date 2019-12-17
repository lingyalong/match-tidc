package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.exam.HistoryExamination;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae ContestMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository

public interface ContestMapper {
	@Insert("insert into contest(name,domain,is_mark,is_anonymous,is_exam,is_automation,is_money,brief,start,finish,history_examination_id,url,logo,school_id,number,money,is_open,is_show,start_time) values(#{name},#{domain},#{is_mark},#{is_anonymous},#{is_exam},#{is_automation},#{is_money},#{brief},#{start},#{finish},#{history_examination_id},#{url},#{logo},#{school_id},#{number},#{money},#{is_open},#{is_show},#{start_time})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int insetContest(Contest contest);

	@Select("select id,name,is_exam,start,finish,logo,domain,number,start_time from contest where is_open = 1")
	List<Contest> listContestAll();

	@Select("select id,name,is_exam,start,finish,logo,domain,number,start_time from contest where domain=#{type} and is_open = 1")
	List<Contest> listTypeContest(String type);

	@Select("select * contest where id = #{id} and is_open = 1")
	Contest getContestDetails(int id);

	@Select(" select id,name,start,finish,logo,domain,number,start_time from Contest where is_open = 1 order by id desc limit #{number}")
	List<Contest> listRankContest(int number);

	@Select("select id,start,finish,start_time from contest")
	List<Contest> listContestTime();

	@Update("update contest set is_open = 1 where id=#{id}")
	void upOpen(int id);

	@Update("update contest set is_open = 0 where = id=#{id}")
	void downOpen(int id);

	@Select("select * from contest where id = #{id}")
	Contest getContest(int id);

	@Update("update contest set number = number+1 where id = #{id}")
	int addNumber(int id);

	@Delete("delete from contest where id = #{id}")
	int deleteContest(int id);

	@Select("select school_id from contest where id = #{id}")
	Integer checkLeader(int id);

	@Select("select name,is_exam,brief,logo,url,school_id,number,start_time from contest where is_show = 1")
	List<Contest> checkShowScoreContest();

	@Update("update contest set is_show = #{is_show} where id = #{id}")
	int updateIsShow(Contest contest);

	@Update("update contest set is_open = #{is_open} where id = #{id}")
	int updateIsOpen(Contest contest);

	@Select("select * from contest where id in (select contest_id from power where teacher_id =#{teacher_id})")
	List<Contest> listTeacherContest(int teacher_id);

	@Select("select is_anonymous from contest where id = #{contestId}")
	int checkAnonymous(int contestId);

	@Update("update contest set history_examination_id = #{id} where id = #{contest_id}")
	int updateHistoryExaminationId(HistoryExamination historyExamination);

	@Select("SELECT COUNT(id) FROM contest WHERE id = #{id} AND is_open = 1")
	Integer checkApply(int id);


	int updateContest(Contest contest);

}
