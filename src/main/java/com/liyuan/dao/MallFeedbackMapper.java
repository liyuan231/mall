package com.liyuan.dao;

import com.liyuan.model.MallFeedback;
import com.liyuan.model.MallFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallFeedbackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    long countByExample(MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int deleteByExample(MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int insert(MallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int insertSelective(MallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    MallFeedback selectOneByExample(MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    MallFeedback selectOneByExampleSelective(@Param("example") MallFeedbackExample example, @Param("selective") MallFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    MallFeedback selectOneByExampleWithBLOBs(MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    List<MallFeedback> selectByExampleSelective(@Param("example") MallFeedbackExample example, @Param("selective") MallFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    List<MallFeedback> selectByExampleWithBLOBs(MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    List<MallFeedback> selectByExample(MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    MallFeedback selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MallFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    MallFeedback selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MallFeedback record, @Param("example") MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") MallFeedback record, @Param("example") MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MallFeedback record, @Param("example") MallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(MallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MallFeedback record);
}