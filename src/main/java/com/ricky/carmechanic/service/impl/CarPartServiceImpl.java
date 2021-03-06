package com.ricky.carmechanic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.CarpartUsage;
import com.ricky.carmechanic.domain.example.CarpartInfoExample;
import com.ricky.carmechanic.domain.example.CarpartUsageExample;
import com.ricky.carmechanic.mapper.CarpartInfoMapper;
import com.ricky.carmechanic.mapper.CarpartUsageMapper;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(rollbackFor = DataAccessException.class)
public class CarPartServiceImpl implements com.ricky.carmechanic.service.CarPartService {

    @Autowired
    CarpartUsageMapper carpartUsageMapper;

    @Autowired
    CarpartInfoMapper carpartInfoMapper;


    public Result getCarPartInfo(CarpartInfo carpartInfo, int pageNum, int pageSize) {
        Result result = new Result();
        List<CarpartInfo> CarPartList = new ArrayList();
        CarpartInfoExample example = new CarpartInfoExample();
        CarpartInfoExample.Criteria criteria = example.createCriteria();
        // 规则，主键不为空的项（全部）
        criteria.andCarpartIdIsNotNull();
        // 规则，carpartInfo中存在的规则
        if(carpartInfo != null) {
            if (carpartInfo.getCarpartId() != null)
                criteria.andCarpartIdEqualTo(carpartInfo.getCarpartId());
            if (! carpartInfo.getCarpartName().equals(""))
                criteria.andCarpartNameEqualTo(carpartInfo.getCarpartName());
            if (! carpartInfo.getManufacturer().equals(""))
                criteria.andManufacturerEqualTo(carpartInfo.getManufacturer());
        }
        example.or(criteria);
        PageHelper.startPage(pageNum,pageSize);
        try {
            CarPartList = carpartInfoMapper.selectByExample(example);
            if(CarPartList == null)
                return Result.failure(ResultCode.RESULT_DATA_NONE);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(PageInfo.of(CarPartList));
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public Result updateCarPartInfo(CarpartInfo carpartInfo) {
        Result result = new Result();
        CarpartInfo info;
        try {
            info = carpartInfoMapper.selectByPrimaryKey(carpartInfo.getCarpartId());
            if(info == null) carpartInfoMapper.insertSelective(carpartInfo);
            else carpartInfoMapper.updateByPrimaryKeySelective(carpartInfo);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(carpartInfo);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public Result deleteCarPartInfo(Integer carPartId) {
        Result result = new Result();
        CarpartInfo carpartInfo;
        try {
            carpartInfo = carpartInfoMapper.selectByPrimaryKey(carPartId);
            if(carpartInfo == null) return Result.failure(ResultCode.RESULT_DATA_NONE);
            carpartInfoMapper.deleteByPrimaryKey(carPartId);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(carpartInfo);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public Result getCarPartUsage(Integer repairId) {
        Result result = new Result();
        CarpartUsageExample example = new CarpartUsageExample();
        CarpartUsageExample.Criteria criteria = example.createCriteria();
        criteria.andRepairIdEqualTo(repairId);
        List<CarpartUsage> usageList = new ArrayList();
        try {
            usageList = carpartUsageMapper.selectByExample(example);
            if (usageList == null) return Result.failure(ResultCode.RESULT_DATA_NONE);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(usageList);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public Result submitCarPartUsage(CarpartUsage carpartUsage) {
        Result result = new Result();
        CarpartInfo carpartInfo;
        Integer amount = 0;
        try {
            carpartInfo = carpartInfoMapper.selectByPrimaryKey(carpartUsage.getCarpartId());
            amount = carpartInfo.getReserveAmount() - carpartUsage.getUsageAmount();
            if (amount < 0) return Result.failure(ResultCode.RESULT_DATA_NONE);
            carpartInfo.setReserveAmount(amount);
            carpartInfoMapper.insertSelective(carpartInfo);
            carpartUsageMapper.insertSelective(carpartUsage);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(carpartUsage);
        return result;
    }


}
