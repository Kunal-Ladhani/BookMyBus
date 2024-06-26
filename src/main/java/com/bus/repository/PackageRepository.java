package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Packages;

@Repository
public interface PackageRepository extends JpaRepository<Packages, Integer>{

}
