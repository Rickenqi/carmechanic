package com.ricky.carmechanic.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ricky.carmechanic.domain.CarpartInfo;
import com.ricky.carmechanic.domain.CarpartUsage;
import com.ricky.carmechanic.domain.ClientRepair;
import com.ricky.carmechanic.service.CarPartService;
import com.ricky.carmechanic.service.ClientRepairService;
import com.ricky.carmechanic.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MechanicController {

    Gson gson = new GsonBuilder().create();

    @Autowired
    ClientRepairService clientRepairService;

    @Autowired
    CarPartService carPartService;

    @PostMapping("/carrepair")
    String acceptCarRepair(@RequestBody List<ClientRepair> form) {
        Result result = clientRepairService.doClientRepair(form);
        return gson.toJson(result);
    }

    @PostMapping("/carpart")
    String acceptCarPart(@RequestBody CarpartUsage form) {
        Result result = carPartService.submitCarPartUsage(form);
        return gson.toJson(result);
    }

    @GetMapping("/carpart/list")
    String giveCarPart(@RequestBody CarpartInfo query, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = carPartService.getCarPartInfo(query,pageNum,pageSize);
        return gson.toJson(result);
    }
}
