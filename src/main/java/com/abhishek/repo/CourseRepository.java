package com.abhishek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	

}
