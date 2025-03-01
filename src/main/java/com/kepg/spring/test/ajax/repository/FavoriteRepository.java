package com.kepg.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kepg.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	
	public int insertFavorite(
			@Param("urlName") String urlName
			, @Param("url") String url
			);
	
	public List<Favorite> selectFavorite();
}
