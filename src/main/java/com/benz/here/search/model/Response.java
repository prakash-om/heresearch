package com.benz.here.search.model;

import java.io.Serializable;

public class Response implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	ChargingStations chargingStations;
	public ChargingStations getChargingStation() {
		return chargingStations;
	}
	public void setChargingStation(ChargingStations chargingStation) {
		this.chargingStations = chargingStation;
	}
	public ParkingSpots getParkingSpot() {
		return parkingSpots;
	}
	public void setParkingSpot(ParkingSpots parkingSpot) {
		this.parkingSpots = parkingSpot;
	}
	public Restaurants getRestaurant() {
		return restaurants;
	}
	public void setRestaurant(Restaurants restaurant) {
		this.restaurants = restaurant;
	}
	ParkingSpots parkingSpots;
	Restaurants restaurants;

}
