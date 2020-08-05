package com.ricky.carmechanic.service;


import com.ricky.carmechanic.domain.ClientCar;
import com.ricky.carmechanic.util.result.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = DataAccessException.class)
public interface ClientRegisterService {

    /**
     * handling the query of client car with optional params and divided pages
     * @param clientCar
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result getClientCar(ClientCar clientCar, int pageNum, int pageSize);

    /**
     * handling the service of deliver the client register form
     * @param clientCar
     * @return
     */
    Result deliverClientRegister(ClientCar clientCar);
}
