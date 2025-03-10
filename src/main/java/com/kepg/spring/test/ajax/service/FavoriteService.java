package com.kepg.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.ajax.domain.Favorite;
import com.kepg.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository repository;
	
	public int createFavorite(
			String urlName
			, String url
			) {
		int count = repository.insertFavorite(urlName, url);
		return count;
		
		
	}
	
	public List<Favorite> selectFavorite() {
		List<Favorite> favorite = repository.selectFavorite();
		return favorite;
	}
		
	public boolean isDuplicate(String url) {
		int count = repository.selectCountByUrl(url);
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean deleteFavorite(Integer id) {

		if(id == null || id <= 0) {
			return false;
		}
		return repository.deleteById(id) != 0;
	}
}
