package com.abhishek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

	
}
