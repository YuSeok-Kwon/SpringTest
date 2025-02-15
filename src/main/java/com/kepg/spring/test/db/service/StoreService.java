package com.kepg.spring.test.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.db.domain.Store;
import com.kepg.spring.test.db.repository.StoreRepository;


@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	// 데이터 가공
	// `store`모든 행 정보 가져오기
	
	public List<Store> getStoreList() {
		
		List<Store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}
