package com.kepg.spring.test.thymeleaf.weatherhistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.thymeleaf.weatherhistory.domain.WeatherHistory;
import com.kepg.spring.test.thymeleaf.weatherhistory.repository.WeatherhistoryRepository;

@Service
public class WeatherhistoryService {
	
	@Autowired
	private WeatherhistoryRepository repository;
	
	public List <WeatherHistory> getWeatherHistory() {
		List <WeatherHistory> weatherhistory = repository.selectWeatherHistory();
		
		return weatherhistory;
	}
	
	public int inputWeather(WeatherHistory weatherHistory) {
        return repository.insertWeatherHistory(weatherHistory);
    }
}
