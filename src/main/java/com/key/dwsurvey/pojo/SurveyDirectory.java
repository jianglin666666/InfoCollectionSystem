package com.key.dwsurvey.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "t_survey_directory")
public class SurveyDirectory implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.an_item_least_num
     *
     * @mbggenerated
     */
    private Integer anItemLeastNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.answer_num
     *
     * @mbggenerated
     */
    private Integer answerNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.create_date
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.dir_type
     *
     * @mbggenerated
     */
    private Integer dirType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.excerpt_num
     *
     * @mbggenerated
     */
    private Integer excerptNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.html_path
     *
     * @mbggenerated
     */
    private String htmlPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.is_share
     *
     * @mbggenerated
     */
    private Integer isShare;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.parent_id
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.sid
     *
     * @mbggenerated
     */
    private String sid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.survey_detail_id
     *
     * @mbggenerated
     */
    private String surveyDetailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.survey_model
     *
     * @mbggenerated
     */
    private Integer surveyModel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.survey_name
     *
     * @mbggenerated
     */
    private String surveyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.survey_qu_num
     *
     * @mbggenerated
     */
    private Integer surveyQuNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.survey_state
     *
     * @mbggenerated
     */
    private Integer surveyState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.survey_tag
     *
     * @mbggenerated
     */
    private Integer surveyTag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.view_answer
     *
     * @mbggenerated
     */
    private Integer viewAnswer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_survey_directory.visibility
     *
     * @mbggenerated
     */
    private Integer visibility;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_survey_directory
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.id
     *
     * @return the value of t_survey_directory.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.id
     *
     * @param id the value for t_survey_directory.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.an_item_least_num
     *
     * @return the value of t_survey_directory.an_item_least_num
     *
     * @mbggenerated
     */
    public Integer getAnItemLeastNum() {
        return anItemLeastNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.an_item_least_num
     *
     * @param anItemLeastNum the value for t_survey_directory.an_item_least_num
     *
     * @mbggenerated
     */
    public void setAnItemLeastNum(Integer anItemLeastNum) {
        this.anItemLeastNum = anItemLeastNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.answer_num
     *
     * @return the value of t_survey_directory.answer_num
     *
     * @mbggenerated
     */
    public Integer getAnswerNum() {
        return answerNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.answer_num
     *
     * @param answerNum the value for t_survey_directory.answer_num
     *
     * @mbggenerated
     */
    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.create_date
     *
     * @return the value of t_survey_directory.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.create_date
     *
     * @param createDate the value for t_survey_directory.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.dir_type
     *
     * @return the value of t_survey_directory.dir_type
     *
     * @mbggenerated
     */
    public Integer getDirType() {
        return dirType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.dir_type
     *
     * @param dirType the value for t_survey_directory.dir_type
     *
     * @mbggenerated
     */
    public void setDirType(Integer dirType) {
        this.dirType = dirType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.excerpt_num
     *
     * @return the value of t_survey_directory.excerpt_num
     *
     * @mbggenerated
     */
    public Integer getExcerptNum() {
        return excerptNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.excerpt_num
     *
     * @param excerptNum the value for t_survey_directory.excerpt_num
     *
     * @mbggenerated
     */
    public void setExcerptNum(Integer excerptNum) {
        this.excerptNum = excerptNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.html_path
     *
     * @return the value of t_survey_directory.html_path
     *
     * @mbggenerated
     */
    public String getHtmlPath() {
        return htmlPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.html_path
     *
     * @param htmlPath the value for t_survey_directory.html_path
     *
     * @mbggenerated
     */
    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.is_share
     *
     * @return the value of t_survey_directory.is_share
     *
     * @mbggenerated
     */
    public Integer getIsShare() {
        return isShare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.is_share
     *
     * @param isShare the value for t_survey_directory.is_share
     *
     * @mbggenerated
     */
    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.parent_id
     *
     * @return the value of t_survey_directory.parent_id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.parent_id
     *
     * @param parentId the value for t_survey_directory.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.sid
     *
     * @return the value of t_survey_directory.sid
     *
     * @mbggenerated
     */
    public String getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.sid
     *
     * @param sid the value for t_survey_directory.sid
     *
     * @mbggenerated
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.survey_detail_id
     *
     * @return the value of t_survey_directory.survey_detail_id
     *
     * @mbggenerated
     */
    public String getSurveyDetailId() {
        return surveyDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.survey_detail_id
     *
     * @param surveyDetailId the value for t_survey_directory.survey_detail_id
     *
     * @mbggenerated
     */
    public void setSurveyDetailId(String surveyDetailId) {
        this.surveyDetailId = surveyDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.survey_model
     *
     * @return the value of t_survey_directory.survey_model
     *
     * @mbggenerated
     */
    public Integer getSurveyModel() {
        return surveyModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.survey_model
     *
     * @param surveyModel the value for t_survey_directory.survey_model
     *
     * @mbggenerated
     */
    public void setSurveyModel(Integer surveyModel) {
        this.surveyModel = surveyModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.survey_name
     *
     * @return the value of t_survey_directory.survey_name
     *
     * @mbggenerated
     */
    public String getSurveyName() {
        return surveyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.survey_name
     *
     * @param surveyName the value for t_survey_directory.survey_name
     *
     * @mbggenerated
     */
    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.survey_qu_num
     *
     * @return the value of t_survey_directory.survey_qu_num
     *
     * @mbggenerated
     */
    public Integer getSurveyQuNum() {
        return surveyQuNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.survey_qu_num
     *
     * @param surveyQuNum the value for t_survey_directory.survey_qu_num
     *
     * @mbggenerated
     */
    public void setSurveyQuNum(Integer surveyQuNum) {
        this.surveyQuNum = surveyQuNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.survey_state
     *
     * @return the value of t_survey_directory.survey_state
     *
     * @mbggenerated
     */
    public Integer getSurveyState() {
        return surveyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.survey_state
     *
     * @param surveyState the value for t_survey_directory.survey_state
     *
     * @mbggenerated
     */
    public void setSurveyState(Integer surveyState) {
        this.surveyState = surveyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.survey_tag
     *
     * @return the value of t_survey_directory.survey_tag
     *
     * @mbggenerated
     */
    public Integer getSurveyTag() {
        return surveyTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.survey_tag
     *
     * @param surveyTag the value for t_survey_directory.survey_tag
     *
     * @mbggenerated
     */
    public void setSurveyTag(Integer surveyTag) {
        this.surveyTag = surveyTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.user_id
     *
     * @return the value of t_survey_directory.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.user_id
     *
     * @param userId the value for t_survey_directory.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.view_answer
     *
     * @return the value of t_survey_directory.view_answer
     *
     * @mbggenerated
     */
    public Integer getViewAnswer() {
        return viewAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.view_answer
     *
     * @param viewAnswer the value for t_survey_directory.view_answer
     *
     * @mbggenerated
     */
    public void setViewAnswer(Integer viewAnswer) {
        this.viewAnswer = viewAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_survey_directory.visibility
     *
     * @return the value of t_survey_directory.visibility
     *
     * @mbggenerated
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_survey_directory.visibility
     *
     * @param visibility the value for t_survey_directory.visibility
     *
     * @mbggenerated
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
}