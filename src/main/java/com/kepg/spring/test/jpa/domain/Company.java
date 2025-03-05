package com.kepg.spring.test.jpa.domain;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="`company`")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder=true)
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String business;
	private String scale;
	private int headcount;
	
	@Column(name="createdAt")
	@CreationTimestamp
	LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	LocalDateTime updatedAt;
}
