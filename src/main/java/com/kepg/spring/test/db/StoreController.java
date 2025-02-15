package com.kepg.spring.test.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.db.domain.Store;
import com.kepg.spring.test.db.service.StoreService;

@Controller
public class StoreController {

	// request와 response 담당
	// 가공된 정보 가져와서 출력(가게 정보 리스트 가져와서 출력하기)
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList(){
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}
