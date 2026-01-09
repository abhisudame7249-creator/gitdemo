package com.abhishek.entity;

import lombok.Data;

@Data
public class StudentDto {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private Integer courseId;
	
	private Course course;
}
