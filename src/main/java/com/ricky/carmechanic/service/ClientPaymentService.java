package com.ricky.carmechanic.service;

import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.util.result.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = DataAccessException.class)
public interface ClientPaymentService {

    /**
     * handle the query of client bill
     * @param registerId
     * @return
     */
    Result getClientBill(Integer registerId);

    /**
     * handle the yield of client bill, with repair form input
     *
     * @param registerId
     * @param clientRepairList
     * @return
     */
    Result makeClientBill(Integer registerId, List<ClientRepair> clientRepairList);
}
