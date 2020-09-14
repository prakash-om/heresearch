package com.benz.here.search.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParkingSpotsTest {
	
	ParkingSpots ps;
	ParkingResultResults results;
	ParkingSlotItem pkSlots;
	List<ParkingSlotItem> items;
	@Before
	public void setUp() {
		pkSlots = new ParkingSlotItem();
		items = new ArrayList<>();
		pkSlots.setDistance(521);
		pkSlots.setId("123");
		pkSlots.setTitle("City Parking");
		items.add(pkSlots);
		results = new ParkingResultResults();
		results.setItems(items);
		ps = new ParkingSpots();
		ps.setResults(results);
	}
	
	@Test
	public void testDistanceTest() {
		assertEquals(521, ps.getResults().getItems().get(0).getDistance());
	}
	
	@Test
	public void getIdTest() {
		assertTrue("123".equals(ps.getResults().getItems().get(0).getId()));
	}
	
	@Test
	public void getTitleTest() {
		assertTrue("City Parking".equals(ps.getResults().getItems().get(0).getTitle()));
	}

}
