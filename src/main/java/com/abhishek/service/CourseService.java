package com.abhishek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhishek.entity.Course;
import com.abhishek.entity.CourseDto;
import com.abhishek.repo.CourseRepository;

public interface CourseService {
	
	public String saveCourse(Course course);
	
	
	CourseDto getById(int id); 
	
	List<Course> getall();

	//update
	public String updateCoursebyid(int id, Course course);
	
	public String deleteByid(int id);
	
}
