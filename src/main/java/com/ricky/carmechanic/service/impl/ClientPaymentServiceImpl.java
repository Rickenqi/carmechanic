package com.ricky.carmechanic.service.impl;

import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.ClientBill;
import com.ricky.carmechanic.domain.ClientCar;
import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.domain.example.ClientBillExample;
import com.ricky.carmechanic.domain.example.ClientRepairExample;
import com.ricky.carmechanic.mapper.CarpartInfoMapper;
import com.ricky.carmechanic.mapper.ClientBillMapper;
import com.ricky.carmechanic.mapper.ClientCarMapper;
import com.ricky.carmechanic.mapper.ClientRepairMapper;
import com.ricky.carmechanic.service.ClientPaymentService;
import com.ricky.carmechanic.service.MailService;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional(rollbackFor = DataAccessException.class)
public class ClientPaymentServiceImpl implements ClientPaymentService {

    @Autowired
    ClientBillMapper clientBillMapper;
    @Autowired
    CarpartInfoMapper carpartInfoMapper;
    @Autowired
    ClientRepairMapper clientRepairMapper;
    @Autowired
    ClientCarMapper clientCarMapper;
    @Autowired
    MailService mailService;

    @Override
    public Result getClientBill(Integer registerId) {
        if (isBillExist(registerId)) {
            makeClientBill(registerId);
        }
        Result result = new Result();
        ClientBillExample example = new ClientBillExample();
        ClientBillExample.Criteria criteria = example.createCriteria();
        List<ClientBill> billList;
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
    public Result makeClientBill(Integer registerId) {
        Result result = new Result();
        ClientBill bill = new ClientBill();
        ClientRepairExample example = new ClientRepairExample();
        ClientRepairExample.Criteria criteria = example.createCriteria();
        criteria.andRegisterIdEqualTo(registerId);
        List<ClientRepair> clientRepairList = clientRepairMapper.selectByExample(example);
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
            ClientCar register = clientCarMapper.selectByPrimaryKey(registerId);
            mailService.sendMailBill(register.getOwnerEmail(), register.getOwnerName(), register.getCarType());
        } catch (DataAccessException | MessagingException e) {
            System.out.println(e);
            return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    private Boolean isBillExist(Integer registerId) {
        ClientBillExample example = new ClientBillExample();
        ClientBillExample.Criteria criteria = example.createCriteria();
        criteria.andRegisterIdEqualTo(registerId);
        List<ClientBill> billList = clientBillMapper.selectByExample(example);
        return billList != null;
    }



    private Integer calPayment(ClientRepair clientRepair) {
        Integer carpartId = clientRepair.getCarpartId();
        CarpartInfo carpartInfo = carpartInfoMapper.selectByPrimaryKey(carpartId);
        return 200 + carpartInfo.getCarpartPrice() * carpartInfo.getReserveAmount();
    }
}
