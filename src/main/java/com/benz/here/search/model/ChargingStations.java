package com.benz.here.search.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChargingStations implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ChargingResults results;

	public ChargingResults getResults() {
		return results;
	}

	public void setResults(ChargingResults results) {
		this.results = results;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ChargingCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	public String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String title;
    public String system;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ChargingItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<Double> position;
    public List<Double> getPosition() {
		return position;
	}
	public void setPosition(List<Double> position) {
		this.position = position;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
	public ChargingCategory getCategory() {
		return category;
	}
	public void setCategory(ChargingCategory category) {
		this.category = category;
	}
	
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int distance;
    public String title;
    public int averageRating;
    public ChargingCategory category;
    public String vicinity;
    public String type;
    public String id;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ChargingResults implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<ChargingItem> items;

	public List<ChargingItem> getItems() {
		return items;
	}

	public void setItems(List<ChargingItem> items) {
		this.items = items;
	}
}


