package com.benz.here.search.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ChargingStationsTest {

	ChargingResults cr;
	ChargingItem chItem;
	List<ChargingItem> chargingTests;

	@Before
	public void setup() {
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
	}

	@Test
	public void itemsCheck() {
		assertEquals(1, chargingTests.size());
	}

	@Test
	public void itemAverageRatingTest() {
		assertEquals(1, cr.getItems().get(0).getAverageRating());
	}

	@Test
	public void getDistanceTest() {
		assertEquals(300, cr.getItems().get(0).getDistance());
	}

	@Test
	public void getTitle() {
		assertEquals("Test", cr.getItems().get(0).getTitle());
	}

	@Test
	public void getVicinityTest() {
		assertTrue("Near by Bangalore".equals(cr.getItems().get(0).getVicinity()));
	}

	@Test
	public void getLatTest() {
		assertEquals(145.23, cr.getItems().get(0).getPosition().get(0));
	}

	@Test
	public void getLongTest() {
		assertEquals(123.33, cr.getItems().get(0).getPosition().get(1));
	}

}