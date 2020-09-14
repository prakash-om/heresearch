package com.benz.here.search.service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.benz.here.search.domain.Constants;
import com.benz.here.search.exception.HereComException;
import com.benz.here.search.model.ChargingStations;
import com.benz.here.search.utils.ConfigUtility;

@Service
public class SearchChargingStationsImpl implements SearchChargingStations {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ConfigUtility configUtility;

	@Override
	public ResponseEntity<ChargingStations> searchChargingStations(String location)
			throws InterruptedException, ExecutionException, HereComException {

		String url = constructUrl(location);
		CompletableFuture<ResponseEntity<ChargingStations>> response = internalSearchChargingStations(url);
		ResponseEntity<ChargingStations> responseEntity = response.get();

		return responseEntity;

	}

	@Async
	private CompletableFuture<ResponseEntity<ChargingStations>> internalSearchChargingStations(String url) throws HereComException {

		ResponseEntity<ChargingStations> response;
		try { 
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_JSON);
		HttpEntity<ChargingStations> entity = new HttpEntity<>(headers);
		response = restTemplate.exchange(url, HttpMethod.GET, entity,
				ChargingStations.class);
		} catch(Exception e) {
			throw new HereComException(e.getMessage());
		}
		return CompletableFuture.completedFuture(response);

	}

	private String constructUrl(String location) {
		return configUtility.getEvnProperty("chargingSearchApi") + "at=" + location + "&" + "q="
				+ configUtility.getEvnProperty("chargingCategory") + "&apiKey=" + configUtility.getEvnProperty("apiKey")
				+ "&size=" + configUtility.getEvnProperty("responseSize");
	}
}
