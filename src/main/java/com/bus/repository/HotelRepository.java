package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Hotel;



@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
