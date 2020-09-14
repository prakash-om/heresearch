package com.benz.here.search.service;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;

import com.benz.here.search.exception.HereComException;
import com.benz.here.search.model.Restaurants;

public interface SearchRestaurants {

	ResponseEntity<Restaurants> searchRestaurant(String at) throws InterruptedException, ExecutionException, HereComException;
	
}
