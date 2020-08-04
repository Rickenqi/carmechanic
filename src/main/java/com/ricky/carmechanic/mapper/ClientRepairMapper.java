package com.ricky.carmechanic.mapper;

import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.domain.example.ClientRepairExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClientRepairMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int countByExample(ClientRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int deleteByExample(ClientRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer repairId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int insert(ClientRepair record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int insertSelective(ClientRepair record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    List<ClientRepair> selectByExample(ClientRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    ClientRepair selectByPrimaryKey(Integer repairId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ClientRepair record, @Param("example") ClientRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ClientRepair record, @Param("example") ClientRepairExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClientRepair record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_repair
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClientRepair record);
}
