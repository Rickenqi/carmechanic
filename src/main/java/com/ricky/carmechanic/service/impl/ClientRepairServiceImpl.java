package com.ricky.carmechanic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.ClientCar;
import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.domain.MechanicInfo;
import com.ricky.carmechanic.domain.example.ClientRepairExample;
import com.ricky.carmechanic.mapper.CarpartInfoMapper;
import com.ricky.carmechanic.mapper.ClientCarMapper;
import com.ricky.carmechanic.mapper.ClientRepairMapper;
import com.ricky.carmechanic.mapper.MechanicInfoMapper;
import com.ricky.carmechanic.service.ClientRepairService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
@Transactional(rollbackFor = DataAccessException.class)
public class ClientRepairServiceImpl implements ClientRepairService {

    @Autowired
    ClientRepairMapper clientRepairMapper;

    @Autowired
    ClientCarMapper clientCarMapper;

    @Autowired
    MechanicInfoMapper mechanicInfoMapper;

    @Autowired
    CarpartInfoMapper carpartInfoMapper;

    @Override
    public Result getClientRepair(ClientRepair clientRepair, int pageNum, int pageSize) {
        Result result = new Result();
        List<ClientRepair> clientRepairList = new ArrayList();
        ClientRepairExample example = new ClientRepairExample();
        ClientRepairExample.Criteria criteria = example.createCriteria();
        criteria.andRepairIdIsNotNull();
        if(clientRepair != null) {
            if(clientRepair.getRepairId() != null)
                criteria.andRepairIdEqualTo(clientRepair.getRepairId());
            if(clientRepair.getCarpartId() != null)
                criteria.andCarpartIdEqualTo(clientRepair.getCarpartId());
            if(clientRepair.getMechanicId() != null)
                criteria.andMechanicIdEqualTo(clientRepair.getMechanicId());
            if(clientRepair.getRegisterId() != null)
                criteria.andRegisterIdEqualTo(clientRepair.getRegisterId());
        }
        example.or(criteria);
        PageHelper.startPage(pageNum,pageSize);
        try {
            clientRepairList = clientRepairMapper.selectByExample(example);
            if(clientRepairList == null)
                return Result.failure(ResultCode.RESULT_DATA_NONE);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(PageInfo.of(clientRepairList));
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result doClientRepair(List<ClientRepair> clientRepairList) {
        Result result = new Result();
        try {
            for (ClientRepair item : clientRepairList) {
                // check process
                Integer id1 = item.getRegisterId();
                Integer id2 = item.getMechanicId();
                Integer id3 = item.getCarpartId();
                ClientCar obj1 = clientCarMapper.selectByPrimaryKey(id1);
                MechanicInfo obj2 = mechanicInfoMapper.selectByPrimaryKey(id2);
                CarpartInfo obj3 = carpartInfoMapper.selectByPrimaryKey(id3);
                if(obj1 == null || obj2 == null || obj3 == null)
                    return Result.failure(ResultCode.RESULT_DATA_NONE);
                // repair process
                item.setFinishDate(Calendar.getInstance().getTime());
                // doRepair(item);
                // persist process
                clientRepairMapper.insert(item);
            }
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
}
