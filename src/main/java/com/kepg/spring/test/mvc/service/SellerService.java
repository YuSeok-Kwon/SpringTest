package com.kepg.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.mvc.domain.Seller;
import com.kepg.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	//전달 받은 값을 추가
	public int addSeller(String nickname
			, String profileimage
			, String temperature) {
		int count = sellerRepository.insertSeller(nickname, profileimage, temperature);
		
		return count;
	}
	
	public Seller infoLastSeller() {
		Seller seller = sellerRepository.selectLastSeller();
		
		return seller;
	}
	
	public Seller infoSeller(int id) {
		Seller seller = sellerRepository.selectSeller(id);
		
		return seller;
	}
}
