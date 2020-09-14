package com.benz.here.search.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.benz.here.search.exception.HereComException;
import com.benz.here.search.model.HttpResponse;
import com.benz.here.search.service.GeoCodeServiceImpl;
import com.benz.here.search.service.SearchAggregator;
import com.benz.here.search.utils.ConfigUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SearchController.class })
public class SearchControllerTest {

	// private SearchController searchController;
	private ResponseEntity<HttpResponse> response;
	private HttpResponse httpResponse;
	// private SearchAggregator searchAggregator;

	@Mock
	SearchAggregator searchAggregator;

	@Mock
	GeoCodeServiceImpl geoCodeServiceImpl;
	
	@Mock
	ConfigUtility configUtility;
	
	@Mock
	RestTemplate restTemplate;


	@InjectMocks
	SearchController searchController;
	
	

	@Before
	public void setUp() throws Exception {
//		initMock();
	}

	private void initMock() {

	}

	  @Test public void testWithNullDataGeoCode() throws InterruptedException,
	  ExecutionException, HereComException { response =
	  searchController.search(null, null); assertEquals(response.getStatusCode(),
	  HttpStatus.BAD_REQUEST); }
	 

	@Test
	public void testWithNullDataCityName() throws InterruptedException, ExecutionException, HereComException {
		response = searchController.search(null, null);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testWithEmptyCityName() throws InterruptedException, ExecutionException, HereComException {
		response = searchController.search(null, "");
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testWithEmptyGeoCode() throws InterruptedException, ExecutionException, HereComException {
		response = searchController.search("", null);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testWithCorrectGeoCode() throws InterruptedException, ExecutionException, HereComException {
		response = searchController.search("40.41956,-3.69196", null);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
}
