package com.kepg.spring.test.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.mybatis.domain.RealEstate;
import com.kepg.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/realestate")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	// 파라미터 전달 받고 전달 받은 값과 일치하는 행 불러오기
	RealEstate realEstate = null;
	@RequestMapping("/select/1")
	@ResponseBody
	public RealEstate realEstateId (@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstateId(id);
		return realEstate;
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice (@RequestParam("rentPrice") int rentPrice) {
		List<RealEstate> realEstate = new ArrayList<>();
		realEstate = realEstateService.getRealEstateRentPrice(rentPrice);
		return realEstate;
	}
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaPrice (
			@RequestParam("area") int area
			, @RequestParam("price") int price){
		
		List<RealEstate> realEstate = realEstateService.getRealEstateAreaPrice(area,price);
		return realEstate;
	}
	
	@RequestMapping("/insert/1")
	@ResponseBody
	public int createRealEstate() {
		int count = realEstateService.addRealEstate(3, "푸르지용 리버 303동 1104호", 89, "매매", 100000);
		return count;
	}
	
	@RequestMapping("/insert/2")
	@ResponseBody
	public int createRealEstate(
			@RequestParam("realtorId") int realtorId) {
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(realtorId);
		realEstate.setAddress("썅데빌리버 오피스텔 814호");
		realEstate.setArea(45);
		realEstate.setType("월세");
		realEstate.setPrice(100000);
		realEstate.setRentPrice(120);
		
		int count = realEstateService.addRealEstate(realEstate);
		return count;
	}
}
