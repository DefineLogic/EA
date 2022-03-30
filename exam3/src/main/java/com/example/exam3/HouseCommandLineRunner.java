package com.example.exam3;

import com.example.exam3.entities.House;
import com.example.exam3.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HouseCommandLineRunner implements CommandLineRunner {

    @Autowired
    HouseRepository houseRepository;

    @Override
    public void run(String... args) throws Exception {
        create();
        read();
        update();
        deleteById(1);
        System.out.println("Houses with price greater than 200000:");
        System.out.println(houseRepository.findHousesWithPriceGreaterThan(200000));
        System.out.println("Houses build at year 1998:");
        System.out.println(houseRepository.findHousesBuiltAtCertainYear(1998));
        System.out.println("Most expensive house:");
        System.out.println(houseRepository.findAnyMostExpensiveHouse());

    }

    private void deleteById(int id) {
        System.out.println("Delete operation ---------------------");
        houseRepository.deleteById(id);
    }

    private void update() {
        System.out.println("Update operation ---------------------");
        House house = houseRepository.findById(1).get();
        house.setPrice(450000);
        houseRepository.save(house);
    }

    private void read() {
        System.out.println("Read operation ---------------------");
        House house = houseRepository.findById(1).get();
        System.out.println(house);
    }

    private void create() {
        System.out.println("Create operation ---------------------");
        houseRepository.save(new House(1996, 550000));
        houseRepository.save(new House(1997, 550000));
        houseRepository.save(new House(1997, 550000));
        houseRepository.save(new House(1998, 200000));
        houseRepository.save(new House(1999, 100000));
        houseRepository.save(new House(2000, 150000));
    }
}
