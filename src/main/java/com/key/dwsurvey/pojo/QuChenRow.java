package com.key.dwsurvey.pojo;

import java.io.Serializable;

public class QuChenRow implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_qu_chen_row.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_qu_chen_row.option_name
     *
     * @mbggenerated
     */
    private String optionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_qu_chen_row.order_by_id
     *
     * @mbggenerated
     */
    private Integer orderById;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_qu_chen_row.qu_id
     *
     * @mbggenerated
     */
    private String quId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_qu_chen_row.visibility
     *
     * @mbggenerated
     */
    private Integer visibility;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_qu_chen_row
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_qu_chen_row.id
     *
     * @return the value of t_qu_chen_row.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_qu_chen_row.id
     *
     * @param id the value for t_qu_chen_row.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_qu_chen_row.option_name
     *
     * @return the value of t_qu_chen_row.option_name
     *
     * @mbggenerated
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_qu_chen_row.option_name
     *
     * @param optionName the value for t_qu_chen_row.option_name
     *
     * @mbggenerated
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_qu_chen_row.order_by_id
     *
     * @return the value of t_qu_chen_row.order_by_id
     *
     * @mbggenerated
     */
    public Integer getOrderById() {
        return orderById;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_qu_chen_row.order_by_id
     *
     * @param orderById the value for t_qu_chen_row.order_by_id
     *
     * @mbggenerated
     */
    public void setOrderById(Integer orderById) {
        this.orderById = orderById;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_qu_chen_row.qu_id
     *
     * @return the value of t_qu_chen_row.qu_id
     *
     * @mbggenerated
     */
    public String getQuId() {
        return quId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_qu_chen_row.qu_id
     *
     * @param quId the value for t_qu_chen_row.qu_id
     *
     * @mbggenerated
     */
    public void setQuId(String quId) {
        this.quId = quId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_qu_chen_row.visibility
     *
     * @return the value of t_qu_chen_row.visibility
     *
     * @mbggenerated
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_qu_chen_row.visibility
     *
     * @param visibility the value for t_qu_chen_row.visibility
     *
     * @mbggenerated
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
}