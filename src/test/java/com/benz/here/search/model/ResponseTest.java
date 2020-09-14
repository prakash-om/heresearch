package com.benz.here.search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ResponseTest {

	Response response;
	ParkingSpots ps;
	ParkingResultResults results;
	ParkingSlotItem pkSlots;
	List<ParkingSlotItem> items;
	
	ChargingStations cs;
	ChargingResults cr;
	ChargingItem chItem;
	List<ChargingItem> chargingTests;
	
	@Before
	public void setup( ) {
		cr = new ChargingResults();
		chItem = new ChargingItem();
		chargingTests = new ArrayList<>();
		chargingTests.add(chItem);
		cr.setItems(chargingTests);
		chItem.setAverageRating(1);
		chItem.setDistance(300);
		chItem.setTitle("Test");
		chItem.setVicinity("Near by Bangalore");
		chItem.setPosition(Arrays.asList(145.23, 123.33));
		cs = new ChargingStations();
		cs.setResults(cr);
		
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
		
		response = new Response();
		response.setChargingStation(cs);
		response.setParkingSpot(ps);
		
	}
	
	
	@Test
	public void testPsDistance() {
		assertEquals(521, response.getParkingSpot().getResults().getItems().get(0).getDistance());
	}
	
	@Test
	public void testChDistance() {
		assertEquals(300, response.getChargingStation().getResults().getItems().get(0).getDistance());
	}
	
	
	
}
