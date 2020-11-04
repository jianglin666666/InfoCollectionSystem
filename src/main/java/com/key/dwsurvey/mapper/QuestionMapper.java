package com.key.dwsurvey.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.key.common.dao.BaseMapper;
import com.key.dwsurvey.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper extends BaseMapper<Question> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    int insertSelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    Question selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Question record);


    /**
     * @param
     * @return
     * @description 根据条件查询数据
     * @author suewong
     * @date 2020/7/14 11:41
     */
    List<Question> findAll(@Param("belongId") String belongId, @Param("tag") Integer tag, @Param("quTag") Integer quTag);


    /**
     * @param
     * @return
     * @description 根据问题父id查询数据
     * @author suewong
     * @date 2020/7/14 15:20
     */
    List<Question> selectByparentQuUuId(@Param("parentQuId") String parentQuId);

    /**
     * 删除题后更改题序号
     *
     * @param belongId
     * @param orderById
     */
    void quOrderByIdDel1(@Param("belongId") String belongId, @Param("orderById") Integer orderById);


    /**
     * 更新题号
     * @param id
     * @param belongId
     * @param orderById
     */
    void quOrderByIdAdd1(String id,String belongId, Integer orderById);





    List<Question> findByBelongIdAndTagNotInQuType(String belongId, Integer tag, List<Integer> quType);
}