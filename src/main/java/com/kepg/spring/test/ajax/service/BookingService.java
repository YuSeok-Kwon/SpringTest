package com.kepg.spring.test.ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.ajax.domain.Booking;
import com.kepg.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	public List<Booking> getReservationList(){
		List<Booking> bookingList = repository.selectBooking();
		return bookingList;
	}
	
	public boolean deleteBooking(int id) {
		return repository.deleteBooking(id) > 0;
	}
	
	public boolean createBooking(
			String name
			, int headCount
			, int day
			, LocalDate date
			, String PhoneNumber
			) {
		return repository.insertBooking(name, headCount, day, date, PhoneNumber) > 0;
	}
	
	public Booking getBookingInfoByNamePhoneNumber(String name, String phoneNumber){
		Booking booking = repository.selectBookingByNamePhoneNumber(name, phoneNumber);
		
		return booking;
	}
}
