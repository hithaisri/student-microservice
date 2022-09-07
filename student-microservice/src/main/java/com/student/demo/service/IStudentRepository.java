package com.student.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.demo.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer>  {

	List<Student> findByGrade(Integer grade);
	
}
