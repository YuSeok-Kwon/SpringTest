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
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate realEstateId (@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstateId(id);
		return realEstate;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice (@RequestParam("rentPrice") int rentPrice) {
		List<RealEstate> realEstate = new ArrayList<>();
		realEstate = realEstateService.getRealEstateRentPrice(rentPrice);
		return realEstate;
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaPrice (
			@RequestParam("area") int area
			, @RequestParam("price") int price){
		
		List<RealEstate> realEstate = realEstateService.getRealEstateAreaPrice(area,price);
		return realEstate;
	}
	
}
