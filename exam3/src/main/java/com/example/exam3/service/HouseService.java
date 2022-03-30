package com.example.exam3.service;

import com.example.exam3.entities.House;
import com.example.exam3.exceptions.HouseNotFoundException;
import com.example.exam3.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    HouseRepository houseRepository;

    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }

    public void deleteHouseById(int id){
        Optional<House> house = houseRepository.findById(id);
        if(house.isPresent()){
            houseRepository.deleteById(id);
        }else {
            handleHouseNotFoundException("House not found with Id:"+id);
        }
    }

    public List<House> findHouseWithPriceGreaterThan(double price){
        List<House> houseList = houseRepository.findHousesWithPriceGreaterThan(price);
        if(houseList.isEmpty()){
            handleHouseNotFoundException("No houses found");
        }
        return houseList;
    }

    private void handleHouseNotFoundException(String message) {
        throw new HouseNotFoundException(message);
    }

}
