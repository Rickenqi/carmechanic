package com.ricky.carmechanic.service;

import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.CarpartUsage;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CarPartServiceTest extends BasicServiceTest {

    @Autowired
    CarPartService carPartService;

    @Test
    void test1() {
        CarpartInfo carpartInfo = new CarpartInfo();
        CarpartUsage carpartUsage = new CarpartUsage();
        Integer repairId = 0;
        Integer carPartId = 0;
        List<Result> results = new ArrayList<>();
        results.add(carPartService.getCarPartInfo(carpartInfo, 1, 50));
        results.add(carPartService.getCarPartUsage(repairId));
        results.add(carPartService.submitCarPartUsage(carpartUsage));
        results.add(carPartService.updateCarPartInfo(carpartInfo));
        results.add(carPartService.deleteCarPartInfo(carPartId));
        for (Result item: results) {
            Assert.assertEquals(item.getCode(), ResultCode.SUCCESS);
            System.out.println(gson.toJson(item));
        }

    }



}
