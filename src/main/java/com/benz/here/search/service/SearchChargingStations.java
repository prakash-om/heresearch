package com.benz.here.search.service;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;

import com.benz.here.search.exception.HereComException;
import com.benz.here.search.model.ChargingStations;

public interface SearchChargingStations {
	
	ResponseEntity<ChargingStations> searchChargingStations(String at) throws InterruptedException, ExecutionException, HereComException;

}
