package com.kepg.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lifecycle/test02")
@RestController
public class Test02RestController {

	@RequestMapping("/1")
	public List<Map<String,Object>> getMovieInfo(){
		
		List <Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 0);
		map.put("director", "로베르토 베니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 12);
		map.put("director", "크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");
		list.add(map);
		
		return list;
	}
	
	@RequestMapping("/2")
	public List<Post> listObjectResponse() {
		
		List<Post> postList = new ArrayList<>();
		 
		postList.add(new Post("가입인사", "hanguru", "안녕하세요. 오늘 가입했어요. 잘 부탁드립니다."));
		postList.add(new Post("헐..대박", "bada", "오늘 목요일 이었어.. 금요일 인줄 알았는데..."));
		postList.add(new Post("오늘 데이트 후기 알려드려요", "durumary", "...."));
		
		return postList;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Post> entityResponse() {
		
		Post post = new Post("가입인사", "hanguru", "안녕하세요. 오늘 가입했어요. 잘 부탁드립니다.");
		ResponseEntity<Post> entity = new ResponseEntity<>(post, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	
	
	
	
	
}
