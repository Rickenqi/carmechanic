package com.ricky.carmechanic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.domain.example.ClientRepairExample;
import com.ricky.carmechanic.mapper.ClientRepairMapper;
import com.ricky.carmechanic.service.ClientRepairService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

public class ClientRepairServiceImpl implements ClientRepairService {

    @Autowired
    ClientRepairMapper clientRepairMapper;

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
    public Result deliverClientRepair(ClientRepair clientRepair) {
        Result result = new Result();

        return result;
    }
}
