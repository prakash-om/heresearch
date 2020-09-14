package com.benz.here.search.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.benz.here.search.exception.HereComException;
import com.benz.here.search.model.ChargingStations;
import com.benz.here.search.model.ParkingSpots;
import com.benz.here.search.model.Response;
import com.benz.here.search.model.Restaurants;
import com.benz.here.search.utils.ConfigUtility;

@Service
public class SearchAggregator {
	
	
	@Autowired
	SearchRestaurantsImpl searchRestaurantImpl;
	
	@Autowired
	SearchParkingSpotsImpl searchParkingSpotsImpl;
	
	@Autowired
	SearchChargingStationsImpl searchChargingStationsImpl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ConfigUtility configUtility;
	
	@Cacheable(value = "searchData", key = "#lg")
	public Response getAggreatedSearchResult(String lg) throws InterruptedException, ExecutionException, HereComException {
		
		
		ResponseEntity<Restaurants> restaurants = searchRestaurantImpl.searchRestaurant(lg);
		ResponseEntity<ParkingSpots> parkingSpots = searchParkingSpotsImpl.searchParkingSpots(lg);
		ResponseEntity<ChargingStations> chargingStations = searchChargingStationsImpl.searchChargingStations(lg);
		
		Response response = new Response();
		response.setRestaurant(restaurants.getBody());
		response.setParkingSpot(parkingSpots.getBody());
		response.setChargingStation(chargingStations.getBody());
		
		
		return response;
	}
}
