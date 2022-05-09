package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.Student;

public interface Repository extends JpaRepository<Student, Integer>{
	
	List<Student>findById(int id);

}
