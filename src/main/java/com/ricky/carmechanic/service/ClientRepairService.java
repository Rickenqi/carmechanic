package com.ricky.carmechanic.service;


import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.util.result.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientRepairService {

    /**
     * handling the query of client repair with optional params and divided pages
     * @param clientRepair
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result getClientRepair(ClientRepair clientRepair, int pageNum, int pageSize);

    /**
     * handle the service of delivering client repair form
     * @param clientRepairList
     * @return
     */
    Result doClientRepair(List<ClientRepair> clientRepairList);
}
