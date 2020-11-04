package com.key.dwsurvey.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.key.dwsurvey.entity.QuChenOption;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuChenOptionMapper extends BaseMapper<QuChenOption> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_qu_chen_option
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_qu_chen_option
     *
     * @mbggenerated
     */
    int insert(QuChenOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_qu_chen_option
     *
     * @mbggenerated
     */
    int insertSelective(QuChenOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_qu_chen_option
     *
     * @mbggenerated
     */
    QuChenOption selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_qu_chen_option
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuChenOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_qu_chen_option
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuChenOption record);

    /**
     * @param
     * @return
     * @description 根据visibility和quId 查询信息
     * @author suewong
     * @date 2020/7/14 14:38
     */

    List<QuChenOption> selectByVisibilityAndQuId(@Param("quId") String quId,@Param("visibility") Integer visibility);

    /**
     * @description 根据orderById查找第一条数据，根据降序排序
     * @param quId
     * @return
     */
    QuChenOption findFirstByOrderByIdDesc(@Param("quId") String quId);
}