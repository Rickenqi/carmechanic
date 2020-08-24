package com.ricky.carmechanic.service;

import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.CarpartUsage;
import com.ricky.carmechanic.service.impl.CarPartServiceImpl;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CarPartServiceTest extends BasicServiceTest{

    @Autowired
    CarPartService carPartService;

    @Test
    void test1() {
        CarpartInfo carpartInfo = new CarpartInfo();
        Integer carPartId = 1;
        carpartInfo.setCarpartId(1);
        List<Result> results = new ArrayList<>();
        results.add(carPartService.getCarPartInfo(carpartInfo, 1, 50));
        // results.add(carPartService.submitCarPartUsage(carpartUsage));
        // results.add(carPartService.updateCarPartInfo(carpartInfo));
        // results.add(carPartService.deleteCarPartInfo(carPartId));
        for (Result item: results) {
            System.out.println(gson.toJson(item));
        }
    }


}
