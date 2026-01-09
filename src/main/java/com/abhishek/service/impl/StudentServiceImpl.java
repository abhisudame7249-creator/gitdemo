package com.abhishek.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhishek.entity.Course;
import com.abhishek.entity.Student;
import com.abhishek.entity.StudentDto;
import com.abhishek.repo.StudentRepository;
import com.abhishek.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RestTemplate restTemplate;
	@Override
	public String saveStudent(Student student) {
		
		studentRepository.save(student);
		
		return "Student saved..";
	}
	
	@Override
	public StudentDto getById(int id) {
		
		Course course = restTemplate.getForObject("http://localhost:9090/course/getbyid/"+id , Course.class);

		Optional<Student> byId = studentRepository.findById(id);
		
		if(byId.isPresent())
		{
			Student student = byId.get();
			StudentDto sd=new StudentDto();
			sd.setId(student.getId());
			sd.setName(student.getName());
			sd.setEmail(student.getEmail());
			sd.setCourseId(student.getCourseId());
			sd.setCourse(course);
			return sd;
		}
		
		throw new StudentNotFoundEXception("Student not found");
	}
	
	@Override
	public List<Student> getall() {
		List<Student> all = studentRepository.findAll();
		// TODO Auto-generated method stub
		return all;
	}

}
