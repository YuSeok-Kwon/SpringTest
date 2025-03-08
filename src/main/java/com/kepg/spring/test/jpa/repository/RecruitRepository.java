package com.kepg.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kepg.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	
	// id가 8인 공고
	public Recruit findById(int id);
	
	// 파라미터로 전달 받은 colId에 해당하는 공고
	public List<Recruit> findByCorId(int corId);
	
	// 파라미터로 전달받은 포지션과 타입에 해당하는 공고
	public List<Recruit> findByPositionAndType(String position, String typd);
	
	// 파라미터로 전달받은 타입에 해당하거나, 연봉이 ####원 이상인 공고
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	// SELECT * FROM recruit WHERE type = 계약직 ORDER BY salary LIMIT 3;
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	//	성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	// 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
	@Query(value = "SELECT id, corId, position, responsibilities, qulification, type, region, salary, deadline, createdAt, updatedAt "
			+ "FROM recruit "
			+ "WHERE deadline > :deadline "
			+ "AND salary >= :salary "
			+ "AND type = :type "
			+ "ORDER BY salary DESC", nativeQuery=true)
	public List<Recruit> selectRecruit(
			@Param("deadline") LocalDate deadline,
			@Param("salary") int salary,
			@Param("type") String type);
}
