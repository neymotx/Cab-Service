package com.neymotx.cabserviceh2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neymotx.cabserviceh2.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

	

}
