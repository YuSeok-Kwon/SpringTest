package com.kepg.spring.test.ajax.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kepg.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {

	public List<Booking> selectBooking();
	
	public int deleteBooking(
			@Param("id") int id
			);
	public int insertBooking(
			@Param("name") String name
			, @Param("headCount") int headCount
			, @Param("day") int day
			, @Param("date") LocalDate date
			, @Param("phoneNumber") String phoneNumber
			);
	
	public Booking selectBookingByNamePhoneNumber(
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber
			);
}
