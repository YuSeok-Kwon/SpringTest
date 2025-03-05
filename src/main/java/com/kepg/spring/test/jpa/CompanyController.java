package com.kepg.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.jpa.domain.Company;
import com.kepg.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@ResponseBody
	@GetMapping("/create")
	public List<Company> createCompany(){
		List<Company> companyList = new ArrayList<>();
		
		Company company = service.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		company = service.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		companyList.add(company);
		
		return companyList;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		Company company = service.updateCompany(9, "중소기업", 34);
		
		return company;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		service.deleteCompany(9);
		
		return "삭제 완료";
	}
}
