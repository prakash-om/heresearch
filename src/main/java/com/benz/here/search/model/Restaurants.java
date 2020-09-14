package com.benz.here.search.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Tag implements Serializable{
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
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String title;
    public String group;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Structured implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String start;
    public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public String duration;
    public String recurrence;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class OpeningHours implements Serializable{
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
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public List<Structured> getStructured() {
		return structured;
	}
	public void setStructured(List<Structured> structured) {
		this.structured = structured;
	}
	public String label;
    public boolean isOpen;
    public List<Structured> structured;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Item implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public OpeningHours getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}
	
	public List<Double> position;
    public int distance;
    public String title;
    public int averageRating;
    public String vicinity;
	public String type;
    public List<Tag> tags;
    public OpeningHours openingHours;
	public String id;
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Results implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Item> items;
}

public class Restaurants implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Results getResults() {
		return results;
	}
	public void setResults(Results results) {
		this.results = results;
	}
	
	public Results results;
}