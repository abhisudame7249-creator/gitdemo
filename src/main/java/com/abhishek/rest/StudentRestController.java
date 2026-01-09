package com.abhishek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abhishek.entity.Course;
import com.abhishek.entity.Student;
import com.abhishek.entity.StudentDto;
import com.abhishek.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student)
	{
		
		String saveStudent = studentService.saveStudent(student);
		
		return new ResponseEntity<String>(saveStudent, HttpStatus.OK);
		
	}
	
	@GetMapping("getbyid/{id}")
	public ResponseEntity<StudentDto> getByid(@PathVariable("id") int id)
	{
	
		StudentDto byId = studentService.getById(id);
		return new ResponseEntity<StudentDto>(byId, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getall()
	{
		List<Student> getall = studentService.getall();
		return new ResponseEntity<List<Student>>(getall, HttpStatus.OK);
	}
	

}
