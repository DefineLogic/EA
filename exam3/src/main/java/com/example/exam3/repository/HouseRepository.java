package com.example.exam3.repository;

import com.example.exam3.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HouseRepository extends JpaRepository<House,Integer> {

    public House save(House house);
    public List<House> findAll();
    public Optional<House> findById(Integer id);
    public void deleteById(Integer id);

    @Query("Select h from House h where h.price > ?1")
    public List<House> findHousesWithPriceGreaterThan(double price);

    @Query("Select h from House h where h.year = ?1")
    public List<House> findHousesBuiltAtCertainYear(int year);

    @Query(value = "select * from house order by price desc limit 1", nativeQuery = true)
    public House findAnyMostExpensiveHouse();
}
