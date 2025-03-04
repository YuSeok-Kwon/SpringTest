package com.kepg.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.ajax.domain.Booking;
import com.kepg.spring.test.ajax.service.BookingService;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService service;

	@GetMapping("/mainpage")
	public String openMainPage() {
		return "/ajax/booking/mainpage";
	}
	
	@GetMapping("/listpage")
	public String getReservationList(Model model) {
		
		List<Booking> bookingList = service.getReservationList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "/ajax/booking/reservationListPage";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, Boolean> deleteBooking(
			@RequestParam("id") int id
			){
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isDeleted", service.deleteBooking(id));
		
		return resultMap;
	}
	
	@GetMapping("createpage")
	public String openBookingPage() {
		return "/ajax/booking/doBooking";
	}
	
	@ResponseBody
	@GetMapping("/create")
	public Map<String, Boolean> createBooking(
			@RequestParam("name") String name 
			, @RequestParam("headCount") int headCount
			, @RequestParam("day") int day
			, @RequestParam("date")	LocalDate date
			, @RequestParam("phoneNumber") String phoneNumber
			) {
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isCreated", service.createBooking(name, headCount, day, date, phoneNumber));
		
		return resultMap;
	}
	
	@ResponseBody
	@GetMapping("/checking")
	public Map<String, Object> getBookingInfoByNamePhoneNumber(
			@RequestParam("name") String name 
			, @RequestParam("phoneNumber") String phoneNumber){
		Booking booking = service.getBookingInfoByNamePhoneNumber(name, phoneNumber);
	
		// 조회 성공 {"result" : "success", "data" : {"name" : 권유석, "day" : 2, "date" : 2025년 3월 27일 ...}}
		// 조회 실패 {"result": "fail"}
		Map<String, Object> resultMap = new HashMap<>();
		if(booking != null) {
			// 성공
			resultMap.put("result", "success");
			resultMap.put("data", booking);
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
		 
	}
}
