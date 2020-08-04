package com.ricky.carmechanic.service.impl;

import com.ricky.carmechanic.domain.ClientBill;
import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.domain.example.ClientBillExample;
import com.ricky.carmechanic.domain.example.ClientCarExample;
import com.ricky.carmechanic.mapper.ClientBillMapper;
import com.ricky.carmechanic.service.ClientPaymentService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

public class ClientPaymentServiceImpl implements ClientPaymentService {

    @Autowired
    ClientBillMapper clientBillMapper;

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
    public Result deliverClientBill(List<ClientRepair> repairList) {
        Result result = new Result();
        try {

        } catch (DataAccessException e) {

        }
        return result;
    }
}
