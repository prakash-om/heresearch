package com.benz.here.search.service;

import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.benz.here.search.domain.Constants;
import com.benz.here.search.utils.ConfigUtility;

@Service
public class GeoCodeServiceImpl implements GeoCodeService {

	@Autowired
	ConfigUtility configUtility;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String getGeoCode(String cityName) {

		String url = getUrl(cityName);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		return parseGeoCode(response.getBody());
	}

	private String parseGeoCode(String response) {
		JSONObject obj = new JSONObject(response);
		JSONArray view = obj.getJSONObject("Response").getJSONArray("View");
		JSONArray result = view.getJSONObject(0).getJSONArray("Result");
		JSONObject displayLocation = result.getJSONObject(0).getJSONObject("Location").getJSONObject("DisplayPosition");
		Object latitude = displayLocation.get("Latitude");
		Object longtidue = displayLocation.get("Longitude");

		return latitude.toString() + "," + longtidue.toString();
	}

	private String getUrl(String cityName) {
		return configUtility.getEvnProperty("geoCodingApi") + "apiKey=" + configUtility.getEvnProperty("apiKey")
				+ "&searchtext=" + cityName;
	}

}
