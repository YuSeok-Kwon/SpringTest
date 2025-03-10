package com.kepg.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.ajax.domain.Favorite;
import com.kepg.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

	@Autowired
	private FavoriteService service;
	
	@GetMapping("/input")
	public String inputPage() {
		return "/ajax/favoriteInput";
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createFavorite(
			@RequestParam("urlName") String urlName
			, @RequestParam("url") String url
			){
		
		int count = service.createFavorite(urlName, url);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/list")
	public String selectFavorit(Model model) {
		List<Favorite> favorite = service.selectFavorite();
		
		model.addAttribute("favorites", favorite);
		
		return "/ajax/favoriteList";
		
	}
	
	@ResponseBody
	@PostMapping("/duplicate-url")
	public Map<String, Boolean> isDuplicate(
			@RequestParam("url") String url
			) {
		boolean duplicate = service.isDuplicate(url);
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isDuplicate", duplicate);
		
		return resultMap;
	}
	
	@ResponseBody
	@PostMapping("/delete")
	public Map<String, Boolean> deleteFavorite(
			@RequestParam("id") Integer id
			) {
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isDeleted", service.deleteFavorite(id));
		
		return resultMap;
	}
}
