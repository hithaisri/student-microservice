package com.student.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Student;
import com.student.demo.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	
	@PostMapping("/saveStudent")
	public Integer saveStudent(@RequestBody Student student) {
		Student new1=studentService.saveStudent(student);
		return new1.getId();
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getStudentByGrade/{grade}")
	public List<Student> getStudentByGrade(@PathVariable String grade) {
		return studentService.getClassStudents(grade);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable Integer id) {
		return new	ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<Student> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteStudent(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("/deleteAllStudents")
	public void deleteAllStudents() {
		studentService.deleteAllStudents();
	}
	
}