package com.ricky.carmechanic.mapper;

import com.ricky.carmechanic.domain.ClientCar;
import com.ricky.carmechanic.domain.example.ClientCarExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClientCarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int countByExample(ClientCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int deleteByExample(ClientCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer registerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int insert(ClientCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int insertSelective(ClientCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    List<ClientCar> selectByExample(ClientCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    ClientCar selectByPrimaryKey(Integer registerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ClientCar record, @Param("example") ClientCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ClientCar record, @Param("example") ClientCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClientCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_car
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClientCar record);
}
