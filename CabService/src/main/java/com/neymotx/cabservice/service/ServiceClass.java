package com.neymotx.cabserviceh2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.neymotx.cabserviceh2.dao.DriverRepository;
import com.neymotx.cabserviceh2.model.Driver;
import com.neymotx.cabserviceh2.model.Location;

@Service
public class ServiceClass implements EnvironmentAware {

	@Autowired
	private DriverRepository repo;
	@Autowired
	private Environment env;
	private int distance;
	
	  @Override
	    public void setEnvironment(final Environment environment) {
	        this.env = environment;
	        distance = env.getProperty("cabservice.distance", Integer.class);
	  }
	public List<Driver> getDrivers(){
		
		return repo.findAll();
		
	}

	public  Driver addDriver(Driver driver) {
		
		return repo.save(driver);
	}
	
	public List<Driver> nearByDrivers(Location location){
		 
		List<Driver> nearDrivers = new ArrayList<>();
		List<Driver> drivers = repo.findAll();
		for(Driver driver : drivers) {
			double dist = Math.sin(Math.toRadians(driver.getLatitude())) * Math.sin(Math.toRadians(location.getLatitude())) 
			+ Math.cos(Math.toRadians(driver.getLatitude())) * Math.cos(Math.toRadians(location.getLatitude()))
			* Math.cos(Math.toRadians(driver.getLongitude() - location.getLongitude()));
			dist = 1.609344 * 3963.0 * Math.acos(dist);
			dist = Math.round(dist);
			if(dist <= distance)
				nearDrivers.add(driver);
		}
		
		return nearDrivers;
	}

	public String deleteDriver(int id) {
		
		try{
			repo.deleteById(id);
		}
		catch(Exception e) {
			return "Driver Not Found";
		}
		return "Driver deleted";
	}

	public Optional<Driver> getDriver(int id) {
		
		return repo.findById(id);
		
	}
	public Driver updateOrSaveDriver(Driver driver) {
		
		return repo.save(driver);
	}
	
}
