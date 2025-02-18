package com.kepg.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kepg.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate selectRealEstateId(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateAreaPrice(
			@Param("area") int area
			, @Param("price") int price);
}
