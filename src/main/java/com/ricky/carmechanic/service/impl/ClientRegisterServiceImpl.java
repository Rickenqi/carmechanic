package com.ricky.carmechanic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ricky.carmechanic.domain.ClientCar;
import com.ricky.carmechanic.domain.example.ClientCarExample;
import com.ricky.carmechanic.mapper.ClientCarMapper;
import com.ricky.carmechanic.service.ClientRegisterService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

public class ClientRegisterServiceImpl implements ClientRegisterService {

    @Autowired
    ClientCarMapper clientCarMapper;

    @Override
    public Result getClientCar(ClientCar clientCar, int pageNum, int pageSize) {
        Result result = new Result();
        List<ClientCar> clientCarList = new ArrayList();
        ClientCarExample example = new ClientCarExample();
        ClientCarExample.Criteria criteria = example.createCriteria();
        criteria.andRegisterIdIsNotNull();
        if(clientCar != null) {
            if(clientCar.getRegisterId() != null)
                criteria.andRegisterIdEqualTo(clientCar.getRegisterId());
            if(clientCar.getCarId() != null)
                criteria.andCarIdEqualTo(clientCar.getCarId());
            if(clientCar.getCarType() != null)
                criteria.andCarTypeEqualTo(clientCar.getCarType());
            if(clientCar.getOwnerName() != null)
                criteria.andOwnerNameEqualTo(clientCar.getOwnerName());
            if(clientCar.getOwnerEmail() != null)
                criteria.andOwnerEmailEqualTo(clientCar.getOwnerEmail());
            if(clientCar.getOwnerPhone() != null)
                criteria.andOwnerEmailEqualTo(clientCar.getOwnerPhone());
        }
        example.or(criteria);
        PageHelper.startPage(pageNum,pageSize);
        try {
            clientCarList = clientCarMapper.selectByExample(example);
            if(clientCarList == null)
                return Result.failure(ResultCode.RESULT_DATA_NONE);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(PageInfo.of(clientCarList));
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result deliverClientRegister(ClientCar clientCar) {
        return null;
    }
}
