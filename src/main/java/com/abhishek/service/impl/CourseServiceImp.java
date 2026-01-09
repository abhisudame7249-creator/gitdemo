package com.abhishek.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.entity.Course;
import com.abhishek.entity.CourseDto;
import com.abhishek.repo.CourseRepository;
import com.abhishek.service.CourseService;

@Service
public class CourseServiceImp implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public String saveCourse(Course course) {
			courseRepository.save(course);
		return "Course saved successfully";
	}
	
	@Override
	public CourseDto getById(int id) {
		Optional<Course> byId = courseRepository.findById(id);
		if(byId.isPresent())
		{
			Course course = byId.get();
			CourseDto cd=new CourseDto();
			cd.setId(course.getId());
			cd.setCoursename(course.getCoursename());
			cd.setFees(course.getFees());
			cd.setDuration(course.getDuration());
			
			return cd;
		}
		throw new CourseNotFoundException("Course not found");
		
	}
	
	@Override
	public List<Course> getall() {
		List<Course> all = courseRepository.findAll();
		return all;
	}
	
	@Override
	public String updateCoursebyid(int id, Course course) {
		Optional<Course> byId = courseRepository.findById(id);
		if(byId.isPresent())
		{
			Course up = byId.get();
			up.setCoursename(course.getCoursename());
			up.setFees(course.getFees());
			up.setDuration(course.getDuration());
			courseRepository.save(up);
		}
		else
		{
			throw new CourseNotFoundException("course not found");
		}
		return "Course Updated Successfully";
	}

	@Override
	public String deleteByid(int id) {
		boolean existsById = courseRepository.existsById(id);
		if(existsById)
		{
			courseRepository.deleteById(id);
		}
		else {
			throw new CourseNotFoundException("course not found");
		}
		
		return "Course Deleted successfully";
	}
}
