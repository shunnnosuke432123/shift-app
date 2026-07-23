package com.example.shift;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

	
@Entity
public class Shift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String date;
	private String name;
	private int startTime;
	private int endTime;
	
	public Shift() {
	}
	
	public Shift(String date, String name, int startTime, int endTime) {
		this.date = date;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Long getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	
	public int getStartTime() {
		return startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public boolean isDayOff() {
		return startTime >= endTime;
	}
	
	public String getDisplayText() {
		if(isDayOff()) {
			return "休み";
		}
		return startTime + "-" + endTime;
	}
	
}
