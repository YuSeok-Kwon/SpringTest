package com.kepg.spring.test.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.test.jpa.domain.Recruit;
import com.kepg.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit/find")
@Controller
public class RecruitController {
	
	@Autowired
	private RecruitRepository repository;
	
	@ResponseBody
	@GetMapping("/1")
	public Recruit findById() {
		
		Recruit recruit = null;
		
		recruit = repository.findById(8);
		return recruit;
	}
	
	@ResponseBody
	@GetMapping("/2")
	 public List<Recruit> findByColId(@RequestParam("corId") int corId){
		 
		List<Recruit> recruitList = null;
		recruitList = repository.findByCorId(corId);
		 
	 	return recruitList;
	 }
	
	@ResponseBody
	@GetMapping("/3")
	public List<Recruit> findByPositionANDType(){
		List<Recruit> recruitList = null;
		
		recruitList = repository.findByPositionAndType("웹 back-end 개발자", "정규직");
		return recruitList;
	}
	
	@ResponseBody
	@GetMapping("/4")
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(){
		List<Recruit> recruitList = null;
		
		recruitList = repository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
		return recruitList;
	}
	
	@ResponseBody
	@GetMapping("/5")
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(){
		List<Recruit> recruitList = repository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		return recruitList;
	}
	
	@ResponseBody
	@GetMapping("/6")
	public List<Recruit> findByRegionAndSalaryBetween(){
		List<Recruit> recruitList = repository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		return recruitList;
	}
	
	@ResponseBody
	@GetMapping("/7")
	public List<Recruit> selectRecruit(){
		LocalDate deadline = LocalDate.of(2026, 4, 10);
		
		List<Recruit> recruitList = repository.selectRecruit(deadline, 8100, "정규직");
		
		return recruitList;
	}
}
