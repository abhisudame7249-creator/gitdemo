package com.abhishek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.entity.Course;
import com.abhishek.entity.CourseDto;
import com.abhishek.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRestController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCourse(@RequestBody Course course)
	{
		String saveCourse = courseService.saveCourse(course);
		
		return new ResponseEntity<String> (saveCourse, HttpStatus.CREATED);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<CourseDto> getbyId(@PathVariable int id)
	{
		CourseDto byId = courseService.getById(id);
		return new ResponseEntity<CourseDto>(byId, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Course>> getall()
	{
		
		List<Course> getall = courseService.getall();
		return new ResponseEntity<List<Course>> (getall, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Course course)
	{
		String updateCoursebyid = courseService.updateCoursebyid(id, course);
		return new ResponseEntity<String> (updateCoursebyid, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)
	{
		String deleteByid = courseService.deleteByid(id);
		return new ResponseEntity<String>(deleteByid, HttpStatus.OK);
	}
	
}
