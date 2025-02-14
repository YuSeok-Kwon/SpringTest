package com.kepg.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lifecycle/test01")
@RestController
public class Test01Controller {
	
	@RequestMapping("/1")
	public String htmlResponse() {
		return "<h1>테스트 프로젝트 완성</h1>"
				+ "<h2>해당 프로젝트를 통해서 문제풀이를 진행합니다.</h2>";
	}
	
	
	@RequestMapping("/2")
	public Map<String, Integer> mapResponse() {
		Map<String, Integer> map = new HashMap<>();
		map.put("국어", 80);
		map.put("영어", 90);
		map.put("수학", 85);
		
		return map;
	}
}
