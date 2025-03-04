package com.kepg.spring.test.ajax.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Booking {
	
	private int id;
	private String name;
	private int headCount;
	private int day;
	
	@DateTimeFormat(pattern = "yyyy년 M월 dd일")
	private LocalDate date;
	private String phoneNumber;
	private String state;
	
	// getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
	
}
