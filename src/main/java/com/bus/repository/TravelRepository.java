package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel,Integer>{

}
