package com.ricky.carmechanic.service;

import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.CarpartUsage;
import com.ricky.carmechanic.util.result.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface CarPartService {

    /**
     * handling the query of car part with optional params and divided pages
     * @param carpartInfo
     * @param pageNum
     * @param pageSize
     * @return RESULT_DATA_NONE, INTERFACE_INNER_INVOKE_ERROR, SUCCESS(CarPartList)
     */
    Result getCarPartInfo(CarpartInfo carpartInfo, int pageNum, int pageSize);

    /**
     * handling the update of car part, either insert or update
     * @param carpartInfo
     * @return INTERFACE_INNER_INVOKE_ERROR, SUCCESS(carpartInfo)
     */
    Result updateCarPartInfo(CarpartInfo carpartInfo);

    /**
     * handle the delete of car part info
     * @param carPartId
     * @return RESULT_DATA_NONE, INTERFACE_INNER_INVOKE_ERROR, SUCCESS
     */
    Result deleteCarPartInfo(Integer carPartId);

    /**
     * handle the query of car part usage
     * @param repairId
     * @return RESULT_DATA_NONE, INTERFACE_INNER_INVOKE_ERROR, SUCCESS(usageList)
     */
    Result getCarPartUsage(Integer repairId);

    /**
     * handle the submit of carpartUsage
     * @param carpartUsage
     * @return RESULT_DATA_NONE, INTERFACE_INNER_INVOKE_ERROR, SUCCESS(carpartUsage)
     */
    Result submitCarPartUsage(CarpartUsage carpartUsage);
}
