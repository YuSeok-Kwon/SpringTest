package com.kepg.spring.test.db.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kepg.spring.test.db.domain.Store;

@Mapper
public interface StoreRepository {
	
	// 테이블의 모든 행 조회
	public List<Store> selectStoreList();
}
