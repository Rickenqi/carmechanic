package com.ricky.carmechanic.mapper;

import com.ricky.carmechanic.domain.MechanicInfo;
import com.ricky.carmechanic.domain.example.MechanicInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MechanicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int countByExample(MechanicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int deleteByExample(MechanicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer mechanicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int insert(MechanicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int insertSelective(MechanicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    List<MechanicInfo> selectByExample(MechanicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    MechanicInfo selectByPrimaryKey(Integer mechanicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MechanicInfo record, @Param("example") MechanicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MechanicInfo record, @Param("example") MechanicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MechanicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mechanic_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MechanicInfo record);
}
