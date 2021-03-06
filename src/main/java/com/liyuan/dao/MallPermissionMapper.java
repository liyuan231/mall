package com.liyuan.dao;

import com.liyuan.model.MallPermission;
import com.liyuan.model.MallPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    long countByExample(MallPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int deleteByExample(MallPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int insert(MallPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int insertSelective(MallPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    MallPermission selectOneByExample(MallPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    MallPermission selectOneByExampleSelective(@Param("example") MallPermissionExample example, @Param("selective") MallPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    List<MallPermission> selectByExampleSelective(@Param("example") MallPermissionExample example, @Param("selective") MallPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    List<MallPermission> selectByExample(MallPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    MallPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MallPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    MallPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MallPermission record, @Param("example") MallPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MallPermission record, @Param("example") MallPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MallPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MallPermission record);
}