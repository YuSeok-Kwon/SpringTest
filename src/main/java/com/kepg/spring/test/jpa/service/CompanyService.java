package com.kepg.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.test.jpa.domain.Company;
import com.kepg.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public Company addCompany(
			String name
			, String business
			, String scale
			, int headcount){
		
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		Company result = repository.save(company);
		
		return result;
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = repository.findById(id);
		
		//isPresent -> Null이면 false 아니면 true return
		if(optionalCompany.isPresent()) {
			Company company = optionalCompany.get();
		
		
	//		Company company = optionalCompany.orElse(null);
			
			company = company.toBuilder()
			.scale(scale)
			.headcount(headcount)
			.build();
			
			Company result = repository.save(company);
			
			return result;
		}
			return null;
	}
	
	public void deleteCompany(int id) {
		Optional<Company> optionalCompany = repository.findById(id);
		
//		if(optionalCompany.isPresent()) {
//			Company company = optionalCompany.get();
//			
//			repository.delete(company);
//		}
		
		// 람다식 표현법
		optionalCompany.ifPresent(company -> repository.delete(company));
	}
}
