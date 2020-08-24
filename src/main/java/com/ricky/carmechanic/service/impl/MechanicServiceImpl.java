package com.ricky.carmechanic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.MechanicInfo;
import com.ricky.carmechanic.domain.example.MechanicInfoExample;
import com.ricky.carmechanic.mapper.MechanicInfoMapper;
import com.ricky.carmechanic.service.MechanicService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author la
 * @since 8/24/2020
 */
@Service
@Transactional(rollbackFor = DataAccessException.class)
public class MechanicServiceImpl implements MechanicService {
    @Autowired
    MechanicInfoMapper mechanicInfoMapper;

    @Override
    public Result addMechanic(MechanicInfo mechanicInfo) {
        Result result = new Result();
        try {
            mechanicInfoMapper.insertSelective(mechanicInfo);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result deleteMechanic(Integer mechanicId) {
        Result result = new Result();
        MechanicInfo mechanicInfo;
        try {
            mechanicInfo = mechanicInfoMapper.selectByPrimaryKey(mechanicId);
            if(mechanicInfo == null) return Result.failure(ResultCode.RESULT_DATA_NONE);
            mechanicInfoMapper.deleteByPrimaryKey(mechanicId);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(mechanicInfo);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result updateMechanic(MechanicInfo mechanicInfo) {
        Result result = new Result();
        MechanicInfo info;
        try {
            info = mechanicInfoMapper.selectByPrimaryKey(mechanicInfo.getMechanicId());
            if(info == null) mechanicInfoMapper.insertSelective(mechanicInfo);
            else mechanicInfoMapper.updateByPrimaryKeySelective(mechanicInfo);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(mechanicInfo);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result getMechanic(MechanicInfo mechanicInfo, int pageNum, int pageSize) {
        Result result = new Result();
        List<MechanicInfo> mechanicInfoList;
        MechanicInfoExample example = new MechanicInfoExample();
        MechanicInfoExample.Criteria criteria = example.createCriteria();
        // 规则，主键不为空的项（全部）
        criteria.andMechanicIdIsNotNull();
        // 规则，carpartInfo中存在的规则
        if(mechanicInfo != null) {
            if (mechanicInfo.getMechanicId() != null)
                criteria.andMechanicIdEqualTo(mechanicInfo.getMechanicId());
            if (mechanicInfo.getMechanicName() != null)
                criteria.andMechanicNameEqualTo(mechanicInfo.getMechanicName());
            if (mechanicInfo.getMechanicLv() != null)
                criteria.andMechanicLvEqualTo(mechanicInfo.getMechanicLv());
            if (mechanicInfo.getMechanicPhone() != null)
                criteria.andMechanicPhoneEqualTo(mechanicInfo.getMechanicPhone());
        }
        example.or(criteria);
        PageHelper.startPage(pageNum,pageSize);
        try {
            mechanicInfoList = mechanicInfoMapper.selectByExample(example);
            if(mechanicInfoList == null)
                return Result.failure(ResultCode.RESULT_DATA_NONE);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(PageInfo.of(mechanicInfoList));
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
}
