package com.neymotx.cabserviceh2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neymotx.cabserviceh2.model.Driver;
import com.neymotx.cabserviceh2.model.Location;
import com.neymotx.cabserviceh2.service.ServiceClass;

@RestController
@RequestMapping("/cab")
public class Controller {
	
	@Autowired
	private ServiceClass service;
 
	@GetMapping("/driver/{id}")
	public Optional<Driver> getDriver(@PathVariable("id") int id) {
		
		return service.getDriver(id);
	}
	
	@GetMapping("/drivers")
	public List<Driver> getDrivers() {
		
		return service.getDrivers();
	}
	
	@PostMapping("/driver")
	public Driver addDriver(@RequestBody Driver driver) {
		
		return service.addDriver(driver);
	}
	
	@PutMapping("/driver")
	public Driver updateOrSaveDriver(@RequestBody Driver driver) {
		
		return service.updateOrSaveDriver(driver);
	}
	
	@PostMapping("/book")
	public List<Driver> book(@RequestBody Location location){
		
		return service.nearByDrivers(location);
	}
	
	@DeleteMapping("/driver/{id}")
	public String deleteDriver(@PathVariable("id") int id) {
		
		return service.deleteDriver(id);
	}
	
}
