package com.kepg.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.mvc.domain.Seller;
import com.kepg.spring.test.mvc.service.SellerService;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/input")
	public String inputSeller() {
		return "/mvc/sellerInput";
	}
	
	@ResponseBody
	@GetMapping("/create")
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileimage") String profileimage
			, @RequestParam("temperature") String temperature
			) {
	int count = sellerService.addSeller(nickname, profileimage, temperature);
	
	return count + "행 입력 성공!";
		
	}
	
	@GetMapping("/info/1")
	public String infoLastSeller(Model model) {
		
		Seller seller = sellerService.infoLastSeller();
		model.addAttribute("seller", seller);
		
		return "/mvc/sellerInfo";
	}
	
	@GetMapping("/info/2")
	public String infoSeller(Model model, @RequestParam(value = "id", defaultValue = "0") int id) {
		
		Seller seller = sellerService.infoSeller(id);
		model.addAttribute("seller", seller);
		
		if(id == 0) {
			return "/mvc/sellerError";
		} else {
		return "/mvc/sellerInfo";
		}
	}
}
