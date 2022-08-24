package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.entity.Student;
import com.student.demo.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> getClassStudents(String grade) {
		return studentRepository.findByGrade(grade);
	}

	@Override
	public Student saveStudent(Student student) {
		Student newStudent=studentRepository.save(student);
		return newStudent;
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudent=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "id", id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setSubject(student.getSubject());
		existingStudent.setDob(student.getDob());
		existingStudent.setGrade(student.getGrade());
		
		return studentRepository.save(existingStudent);
		
	}

	
}
