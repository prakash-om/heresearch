package com.benz.here.search.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class HttpResponseTest {
	
	HttpResponse httpResponse;
	
	@Before
	public void setUp() {
		httpResponse = new HttpResponse(HttpStatus.OK, "Sucess","Testing");
	}
	
	@Test
	public void statusCheck() {
		assertEquals(HttpStatus.OK, httpResponse.getStatus());
	}
	
	@Test
	public void responseCheck() {
		assertTrue("Sucess".equals(httpResponse.getMessage()));
	}
	
	@Test
	public void responseDataCheck() {
		assertTrue("Testing".equals(httpResponse.getData()));
	}

}
