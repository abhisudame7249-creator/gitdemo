package com.abhishek.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private Integer courseId;
	
}
