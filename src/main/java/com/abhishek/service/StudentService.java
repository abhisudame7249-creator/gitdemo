package com.abhishek.service;

import java.util.List;

import com.abhishek.entity.Student;
import com.abhishek.entity.StudentDto;

public interface StudentService {
	
	public String saveStudent(Student student);
	
	StudentDto getById(int id);
	
	List<Student>  getall();

}
