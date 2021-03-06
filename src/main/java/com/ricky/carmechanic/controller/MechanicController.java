package com.ricky.carmechanic.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ricky.carmechanic.domain.*;
import com.ricky.carmechanic.service.*;
import com.ricky.carmechanic.util.result.Result;
import com.ricky.carmechanic.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class MechanicController {

    Gson gson = new GsonBuilder().create();

    @Autowired
    CarPartService carPartService;
    @Autowired
    ClientPaymentService clientPaymentService;
    @Autowired
    ClientRegisterService clientRegisterService;
    @Autowired
    ClientRepairService clientRepairService;
    @Autowired
    MechanicService mechanicService;

    @PostMapping("/carrepair")
    String acceptCarRepair(@RequestBody ClientRepair form) {
        Result result = clientRepairService.doClientRepair(form);
        return gson.toJson(result);
    }

    @PostMapping("/usage")
    String acceptCarPart(@RequestBody CarpartUsage form) {
        Result result = carPartService.submitCarPartUsage(form);
        return gson.toJson(result);
    }

    @GetMapping("/carpart/list")
    String giveCarPart(CarpartInfo query, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = carPartService.getCarPartInfo(query,pageNum,pageSize);
        return gson.toJson(result);
    }

    @GetMapping("/carregister/list")
    String giveCarRegister(ClientCar query, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = clientRegisterService.getClientCar(query, pageNum, pageSize);
        return gson.toJson(result);
    }

    @GetMapping("/carrepair/list")
    String giveCarRepair(ClientRepair query, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = clientRepairService.getClientRepair(query, pageNum, pageSize);
        return gson.toJson(result);
    }

    @GetMapping("/worker/list")
    String giveWorker(MechanicInfo worker, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Result result = mechanicService.getMechanic(worker, pageNum, pageSize);
        return gson.toJson(result);
    }

    @PostMapping("/altercarpart")
    String alterCarPart(@RequestBody Map<String, String> form) {
        CarpartInfo carpartInfo = new CarpartInfo();
        if(!form.get("carpart_name").equals(""))
            carpartInfo.setCarpartName(form.get("carpart_name"));
        if(!form.get("manufacturer").equals(""))
            carpartInfo.setManufacturer(form.get("manufacturer"));
        if(!form.get("carpartId").equals(""))
            carpartInfo.setCarpartId(Integer.valueOf(form.get("carpartId")));
        if(!form.get("carpart_price").equals(""))
            carpartInfo.setCarpartPrice(Integer.valueOf(form.get("carpart_price")));
        if(!form.get("reserve_amount").equals(""))
            carpartInfo.setReserveAmount(Integer.valueOf(form.get("reserve_amount")));
        Result result = carPartService.updateCarPartInfo(carpartInfo);
        return gson.toJson(result);
    }

    @PostMapping("/delcarpart")
    String delCarPart(@RequestParam Integer id_del) {
        Result result = carPartService.deleteCarPartInfo(id_del);
        return gson.toJson(result);
    }

    @PostMapping("/altermechanic")
    String alterMechanic(@RequestBody Map<String, String> form) {
        System.out.println(gson.toJson(form));
        MechanicInfo mechanicInfo = new MechanicInfo();
        if(form.get("mechanic_id")!="")
            mechanicInfo.setMechanicId(Integer.valueOf(form.get("mechanic_id")));
        if(form.get("mechanic_lv")!="")
            mechanicInfo.setMechanicLv(form.get("mechanic_lv"));
        if(form.get("mechanic_name")!="")
            mechanicInfo.setMechanicName(form.get("mechanic_name"));
        if(form.get("mechanic_phone")!="")
            mechanicInfo.setMechanicPhone(form.get("mechanic_phone"));
        Result result = mechanicService.updateMechanic(mechanicInfo);
        return gson.toJson(result);
    }

    @PostMapping("/delmechanic")
    String delMechanic(@RequestParam Integer id_del) {
        Result result = mechanicService.deleteMechanic(id_del);
        return gson.toJson(result);
    }

    @PostMapping("/mechanic")
    String acceptMechanic(@RequestBody Map<String, String> form) {
        MechanicInfo mechanicInfo = new MechanicInfo();
        mechanicInfo.setMechanicId(Integer.valueOf(form.get("mechanic_id")));
        mechanicInfo.setMechanicName(form.get("mechanic_name"));
        mechanicInfo.setMechanicLv(form.get("mechanic_lv"));
        mechanicInfo.setMechanicPhone(form.get("mechanic_phone"));
        Result result = mechanicService.addMechanic(mechanicInfo);
        return gson.toJson(result);
    }

    @PostMapping("/carregister")
    String acceptCarRegister(@RequestBody Map<String, String> form) {
        ClientCar clientCar = new ClientCar();
        clientCar.setCarId(form.get("car_id"));
        clientCar.setCarType(form.get("car_type"));
        clientCar.setOwnerName(form.get("owner_name"));
        clientCar.setOwnerEmail(form.get("owner_email"));
        clientCar.setOwnerPhone(form.get("owner_phone"));
        Result result = clientRegisterService.doClientRegister(clientCar);
        return gson.toJson(result);
    }

    @GetMapping("/carregister")
    String getCarRegister(@RequestParam Integer id) {
        ClientCar clientCar = new ClientCar();
        clientCar.setRegisterId(id);
        Result result = clientRegisterService.getClientCar(clientCar, 1, 1);
        return gson.toJson(result);
    }

    @GetMapping("/carrepair")
    String getCarRepair(@RequestParam Integer workerId) {
        ClientRepair clientRepair = new ClientRepair();
        clientRepair.setMechanicId(workerId);
        Result result = clientRepairService.getClientRepair(clientRepair, 1, 20);
        System.out.println(gson.toJson(result));
        return gson.toJson(result);
    }

    @GetMapping("/carpart")
    String getCarPart(@RequestParam Integer id) {
        CarpartInfo carpartInfo = new CarpartInfo();
        carpartInfo.setCarpartId(id);
        Result result = carPartService.getCarPartInfo(carpartInfo, 1, 1);
        return gson.toJson(result);
    }

    @GetMapping("/bill")
    String getBill(@RequestParam Integer registerId) {
        if(registerId != null) {
            Result result = clientPaymentService.getClientBill(registerId);
            return gson.toJson(result);
        }
        return gson.toJson(Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR));
    }
}
