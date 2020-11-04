package com.key.dwsurvey.mapper;

import com.key.common.dao.BaseMapper;
import com.key.dwsurvey.entity.SurveyStats;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyStatsMapper extends BaseMapper<SurveyStats> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_stats
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_stats
     *
     * @mbggenerated
     */
    int insert(SurveyStats record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_stats
     *
     * @mbggenerated
     */
    int insertSelective(SurveyStats record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_stats
     *
     * @mbggenerated
     */
    SurveyStats selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_stats
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SurveyStats record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_survey_stats
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SurveyStats record);

    SurveyStats selectFirst(@Param("surveyId") String surveyId);
}