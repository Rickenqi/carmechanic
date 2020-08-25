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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
@Transactional(rollbackFor = DataAccessException.class)
public class ClientRegisterServiceImpl implements ClientRegisterService {

    @Autowired
    ClientCarMapper clientCarMapper;

    @Override
    public Result getClientCar(ClientCar clientCar, int pageNum, int pageSize) {
        Result result = new Result();
        List<ClientCar> clientCarList;
        ClientCarExample example = new ClientCarExample();
        ClientCarExample.Criteria criteria = example.createCriteria();
        criteria.andRegisterIdIsNotNull();
        if(clientCar != null) {
            if(clientCar.getRegisterId() != null)
                criteria.andRegisterIdEqualTo(clientCar.getRegisterId());
            if(! clientCar.getCarId().equals(""))
                criteria.andCarIdEqualTo(clientCar.getCarId());
            if(! clientCar.getCarType().equals(""))
                criteria.andCarTypeEqualTo(clientCar.getCarType());
            if(! clientCar.getOwnerName().equals(""))
                criteria.andOwnerNameEqualTo(clientCar.getOwnerName());
            if(! clientCar.getOwnerEmail().equals(""))
                criteria.andOwnerEmailEqualTo(clientCar.getOwnerEmail());
            if(! clientCar.getOwnerPhone().equals(""))
                criteria.andOwnerPhoneEqualTo(clientCar.getOwnerPhone());
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
    public Result doClientRegister(ClientCar clientCar) {
        Result result = new Result();
        try {
            clientCar.setRegisterDate(Calendar.getInstance().getTime());
            clientCarMapper.insert(clientCar);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
}
