package com.kepg.spring.test.thymeleaf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kepg.spring.test.thymeleaf.weatherhistory.domain.WeatherHistory;
import com.kepg.spring.test.thymeleaf.weatherhistory.service.WeatherhistoryService;

@RequestMapping("/weatherhistory")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherhistoryService service;
	
	@GetMapping("/select")
	public String weatherHistory(Model model) {
		
		List <WeatherHistory> weatherhistory = service.getWeatherHistory();

		Map<String,String> weatherImg = new HashMap<>();
		
		weatherImg.put("맑음","http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg");
		weatherImg.put("구름조금","http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg");
		weatherImg.put("흐림","http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg");
		weatherImg.put("비","http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg");

		
		model.addAttribute("history", weatherhistory);
		model.addAttribute("img", weatherImg);
		
		return "/thymeleaf/weatherhistory";
	}
	
//	@GetMapping("/inputWeather")
//	public String inputWeather(
//	        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
//	        @RequestParam String weather,
//	        @RequestParam double temperatures,
//	        @RequestParam double precipitaion,
//	        @RequestParam String microDust,
//	        @RequestParam double windSpeed) { 
//		
//		WeatherHistory weatherHistory = new WeatherHistory();
//		weatherHistory.setDate(date);
//		weatherHistory.setWeather(weather);
//		weatherHistory.setTemperatures(temperatures);
//		weatherHistory.setPrecipitaion(precipitaion);
//		weatherHistory.setMicroDust(microDust);
//		weatherHistory.setWindSpeed(windSpeed);
//		
//		int count = service.inputWeather(date, weather, temperatures, precipitaion, microDust, windSpeed);
//		
//		return "redirect:/weatherhistory/select";
//	}
	
	@PostMapping("/inputWeather")
	public String inputWeather(@ModelAttribute WeatherHistory weatherHistory) {
		service.inputWeather(weatherHistory);
	    return "redirect:/weatherhistory/select"; // 저장 후 목록 페이지로 이동
	}
	
	@GetMapping("/input")
	public String inputWeather() {
		
		return "thymeleaf/weatherInput";
	}
}	
