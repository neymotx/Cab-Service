package com.neymotx.cabserviceh2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;	

@Entity
public class Driver {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	@Column(nullable = false)
	double longitude;
	@Column(nullable = false)
	double latitude;
	@Column(nullable = false)
	String carName;
	@Column(nullable = false)
	String driverName;
	@Column(unique = true)
	String vehicleNumber;
	
	
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", carName=" + carName
				+ ", driverName=" + driverName + ", vehicleNumber=" + vehicleNumber + "]";
	}
	
	
	

	
}
