package com.kepg.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.mybatis.domain.RealEstate;
import com.kepg.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	// 전달 받은 값과 일치하는 id의 행 불러오기
	public RealEstate getRealEstateId(int id) {
		RealEstate realestate = realEstateRepository.selectRealEstateId(id);
		return realestate;
	}
	
	public List<RealEstate> getRealEstateRentPrice (int rentPrice) {
		List<RealEstate> realEstate = realEstateRepository.selectRealEstateRentPrice(rentPrice);
		return realEstate;
	}
	
	public List<RealEstate> getRealEstateAreaPrice (int area, int price){
		List<RealEstate> realEstate = realEstateRepository.selectRealEstateAreaPrice(area, price);
		return realEstate;
	}
	
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			) {
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price);
		return count;
	}
	
	public int addRealEstate(RealEstate realEstate) {
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		return count;
	}
	
	public int updateRealEstate(RealEstate realEstate) {
		int count = realEstateRepository.updateRealEstateByObject(realEstate);
		
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = realEstateRepository.deleteRealEstate(id);
		
		return count;
	}
}
