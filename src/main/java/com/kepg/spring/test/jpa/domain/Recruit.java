package com.kepg.spring.test.jpa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="recruit")
public class Recruit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="corId")
	private int corId;
	
	private String position;
	private String responsibilities;
	private String qulification;
	private String type;
	private String region;
	private int salary;
	private LocalDate deadline;
	
	@CreationTimestamp
	@Column(name="createdAt")
	LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	LocalDateTime updatedAt;
}
