package com.key.dwsurvey.pojo;

import java.io.Serializable;

public class AnOrder implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.belong_answer_id
     *
     * @mbggenerated
     */
    private String belongAnswerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.belong_id
     *
     * @mbggenerated
     */
    private String belongId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.ordery_num
     *
     * @mbggenerated
     */
    private String orderyNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.qu_id
     *
     * @mbggenerated
     */
    private String quId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.qu_row_id
     *
     * @mbggenerated
     */
    private String quRowId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_an_order.visibility
     *
     * @mbggenerated
     */
    private Integer visibility;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_an_order
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.id
     *
     * @return the value of t_an_order.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.id
     *
     * @param id the value for t_an_order.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.belong_answer_id
     *
     * @return the value of t_an_order.belong_answer_id
     *
     * @mbggenerated
     */
    public String getBelongAnswerId() {
        return belongAnswerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.belong_answer_id
     *
     * @param belongAnswerId the value for t_an_order.belong_answer_id
     *
     * @mbggenerated
     */
    public void setBelongAnswerId(String belongAnswerId) {
        this.belongAnswerId = belongAnswerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.belong_id
     *
     * @return the value of t_an_order.belong_id
     *
     * @mbggenerated
     */
    public String getBelongId() {
        return belongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.belong_id
     *
     * @param belongId the value for t_an_order.belong_id
     *
     * @mbggenerated
     */
    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.ordery_num
     *
     * @return the value of t_an_order.ordery_num
     *
     * @mbggenerated
     */
    public String getOrderyNum() {
        return orderyNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.ordery_num
     *
     * @param orderyNum the value for t_an_order.ordery_num
     *
     * @mbggenerated
     */
    public void setOrderyNum(String orderyNum) {
        this.orderyNum = orderyNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.qu_id
     *
     * @return the value of t_an_order.qu_id
     *
     * @mbggenerated
     */
    public String getQuId() {
        return quId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.qu_id
     *
     * @param quId the value for t_an_order.qu_id
     *
     * @mbggenerated
     */
    public void setQuId(String quId) {
        this.quId = quId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.qu_row_id
     *
     * @return the value of t_an_order.qu_row_id
     *
     * @mbggenerated
     */
    public String getQuRowId() {
        return quRowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.qu_row_id
     *
     * @param quRowId the value for t_an_order.qu_row_id
     *
     * @mbggenerated
     */
    public void setQuRowId(String quRowId) {
        this.quRowId = quRowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_order.visibility
     *
     * @return the value of t_an_order.visibility
     *
     * @mbggenerated
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_order.visibility
     *
     * @param visibility the value for t_an_order.visibility
     *
     * @mbggenerated
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
}