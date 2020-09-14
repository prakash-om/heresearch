package com.benz.here.search.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ParkingSpots implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ParkingResultResults results;

	public ParkingResultResults getResults() {
		return results;
	}

	public void setResults(ParkingResultResults results) {
		this.results = results;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Category implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String id;
    public String title;
    public String type;
    public String system;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Category2 implements Serializable{
    /**
	 * 
	 */
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
	public String title;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Style implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getIconShape() {
		return iconShape;
	}
	public void setIconShape(String iconShape) {
		this.iconShape = iconShape;
	}
	public String color;
    public String textColor;
    public String iconShape;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Bus100 implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category2 getCategory() {
		return category;
	}
	public void setCategory(Category2 category) {
		this.category = category;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public Category2 category;
    public Style style;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Destination implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String destination;
    public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String line;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class TransitLines implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String text;
    public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public List<Destination> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	public String label;
    public List<Destination> destinations;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ParkingSlotItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<Double> position;
    public int distance;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
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
	public TransitLines getTransitLines() {
		return transitLines;
	}
	public void setTransitLines(TransitLines transitLines) {
		this.transitLines = transitLines;
	}
	public String title;
    public Category category;
    public String vicinity;
    public String type;
    public String id;
    public TransitLines transitLines;
}

class ParkingResultResults implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<ParkingSlotItem> getItems() {
		return items;
	}

	public void setItems(List<ParkingSlotItem> items) {
		this.items = items;
	}

	public List<ParkingSlotItem> items;
}