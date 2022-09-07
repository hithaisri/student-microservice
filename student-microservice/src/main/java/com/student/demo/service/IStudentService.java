package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import com.student.demo.entity.Student;

public interface IStudentService {

	public List<Student> getAllStudents();
	public Optional<Student> getStudentById(Integer id);
	public List<Student> getClassStudents(Integer grade);
	public Student saveStudent(Student student);
	public void deleteStudent(Integer id);
	public void deleteAllStudents();
	public Student updateStudent(Student student,Integer id);
}
