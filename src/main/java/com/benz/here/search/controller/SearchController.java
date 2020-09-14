package com.benz.here.search.controller;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benz.here.search.domain.Constants;
import com.benz.here.search.exception.HereComException;
import com.benz.here.search.model.HttpResponse;
import com.benz.here.search.model.Response;
import com.benz.here.search.service.GeoCodeServiceImpl;
import com.benz.here.search.service.SearchAggregator;

@RestController
public class SearchController {

	@Autowired
	SearchAggregator searchAggregator;

	@Autowired
	GeoCodeServiceImpl geoCodeServiceImpl;

	@GetMapping(Constants.API_PREFIX_V1 + "search")
	public ResponseEntity<HttpResponse> search(@RequestParam(required = false) String geocode,
			@RequestParam(required = false) String cityname)
			throws InterruptedException, ExecutionException, HereComException {
		if (null == geocode && null == cityname) {
			HttpResponse httpResponse = new HttpResponse(HttpStatus.BAD_REQUEST, "Please provide either cityname or geocode parm", null);
			return new ResponseEntity<HttpResponse>(httpResponse,HttpStatus.BAD_REQUEST);
		}
		
		if(Objects.nonNull(cityname) && (cityname.isEmpty() || cityname.isBlank()  )) {
			HttpResponse httpResponse = new HttpResponse(HttpStatus.BAD_REQUEST, "request param cityname is missing", null);
			return new ResponseEntity<HttpResponse>(httpResponse,HttpStatus.BAD_REQUEST);
		}
		
		
		if(Objects.nonNull(geocode) && (geocode.isEmpty() || geocode.isBlank())) {
			HttpResponse httpResponse = new HttpResponse(HttpStatus.BAD_REQUEST, "request param geocode is missing", null);
			return new ResponseEntity<HttpResponse>(httpResponse,HttpStatus.BAD_REQUEST);
		}

		if (Objects.nonNull(cityname)) {
			geocode = geoCodeServiceImpl.getGeoCode(cityname);
		}
		
		Response response;
		try {
			response = searchAggregator.getAggreatedSearchResult(geocode);
		} catch (InterruptedException e) {
			throw e;
		} catch (ExecutionException e) {
			throw e;
		} catch (HereComException e) {
			throw e;
		}
		HttpResponse httpResonse =  new HttpResponse(HttpStatus.OK, "Success", response);	
		return new ResponseEntity<HttpResponse>(httpResonse,HttpStatus.OK) ;
	}
}
