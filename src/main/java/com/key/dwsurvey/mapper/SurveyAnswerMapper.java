package com.key.dwsurvey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.key.dwsurvey.entity.SurveyAnswer;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyAnswerMapper  extends BaseMapper<SurveyAnswer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_answer
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_answer
     *
     * @mbggenerated
     */
    int insert(SurveyAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_answer
     *
     * @mbggenerated
     */
    int insertSelective(SurveyAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_answer
     *
     * @mbggenerated
     */
    SurveyAnswer selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_answer
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SurveyAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_answer
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SurveyAnswer record);

    /**
     * 根据x.surveyId and x.ipAddr 查询数量
     * @param surveyId
     * @param ip
     * @return
     */
    Long findUniObjs(String surveyId, String ip);
}