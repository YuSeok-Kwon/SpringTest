package com.kepg.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kepg.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("profileimage") String profileimage
			, @Param("temperature") String temperature
			);
	
	public Seller selectLastSeller();
	
	public Seller selectSeller(@Param("id") int id);
}
