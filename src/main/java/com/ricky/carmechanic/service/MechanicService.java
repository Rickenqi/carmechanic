package com.ricky.carmechanic.service;

import com.ricky.carmechanic.domain.MechanicInfo;
import com.ricky.carmechanic.util.result.Result;

/**
 * @author la
 * @since 8/24/2020
 */
public interface MechanicService {

    Result addMechanic(MechanicInfo mechanicInfo);

    Result deleteMechanic(Integer mechanicId);

    Result updateMechanic(MechanicInfo mechanicInfo);

    Result getMechanic(MechanicInfo mechanicInfo, int pageNum, int pageSize);
}
