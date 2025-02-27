package com.kepg.spring.test.thymeleaf.weatherhistory.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kepg.spring.test.thymeleaf.weatherhistory.domain.WeatherHistory;

@Mapper
public interface WeatherhistoryRepository {

	public List <WeatherHistory> selectWeatherHistory();
	
	public int insertWeatherHistory (WeatherHistory weatherHistory);
	
}
