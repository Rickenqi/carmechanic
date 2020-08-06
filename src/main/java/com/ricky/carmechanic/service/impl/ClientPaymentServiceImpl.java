package com.ricky.carmechanic.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.ClientBill;
import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.domain.example.ClientBillExample;
import com.ricky.carmechanic.mapper.CarpartInfoMapper;
import com.ricky.carmechanic.mapper.ClientBillMapper;
import com.ricky.carmechanic.service.ClientPaymentService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClientPaymentServiceImpl implements ClientPaymentService {

    @Autowired
    ClientBillMapper clientBillMapper;
    @Autowired
    CarpartInfoMapper carpartInfoMapper;

    @Override
    public Result getClientBill(Integer registerId) {
        Result result = new Result();
        ClientBillExample example = new ClientBillExample();
        ClientBillExample.Criteria criteria = example.createCriteria();
        List<ClientBill> billList = new ArrayList();
        criteria.andRegisterIdEqualTo(registerId);
        try{
            billList = clientBillMapper.selectByExample(example);
            if(billList == null)
                return Result.failure(ResultCode.RESULT_DATA_NONE);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setData(billList);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result makeClientBill(Integer registerId, List<ClientRepair> clientRepairList) {
        Result result = new Result();
        ClientBill bill = new ClientBill();
        try {
            bill.setRegisterId(registerId);
            bill.setPayDate(Calendar.getInstance().getTime());
            bill.setPayment(
                    clientRepairList.stream()
                        .map(this::calPayment)
                        .reduce(Integer::sum)
                        .orElse(null)
            );
            clientBillMapper.insert(bill);
        } catch (DataAccessException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    private Integer calPayment(ClientRepair clientRepair) {
        Integer carpartId = clientRepair.getCarpartId();
        CarpartInfo carpartInfo = carpartInfoMapper.selectByPrimaryKey(carpartId);
        return 200 + carpartInfo.getCarpartPrice() * carpartInfo.getReserveAmount();
    }
}
