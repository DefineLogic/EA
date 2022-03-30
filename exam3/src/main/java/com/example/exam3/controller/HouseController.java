package com.example.exam3.controller;

import com.example.exam3.entities.House;
import com.example.exam3.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class HouseController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    HouseService houseService;

    @GetMapping("/houses")
    public List<House> getAllHouses(){
        return houseService.getAllHouses();
    }

    @DeleteMapping("/housesById")
    public String  deleteSingleHouseById(@RequestParam int houseId){
        houseService.deleteHouseById(houseId);
        return "House Deleted Successfully";
    }

    @GetMapping("/housesByPrice")
    public List<House> getHousesWithPriceGreaterThan(@RequestParam double price){
        return houseService.findHouseWithPriceGreaterThan(price);
    }

    @GetMapping("/houses/greeting/{name}")
    public String greetings(@PathVariable String name, @RequestHeader(name = "accept-language",required = false)
            Locale locale){
        return messageSource.getMessage("greeting.message",null,locale)+" "+ name;
    }


}
