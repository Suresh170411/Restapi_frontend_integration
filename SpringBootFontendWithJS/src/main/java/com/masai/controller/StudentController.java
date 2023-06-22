package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable Integer roll){
		return new ResponseEntity<Student>(studentService.getStudetByRoll(roll), HttpStatus.OK);
	}
	
	@GetMapping("/student/{name}")
	public ResponseEntity<Student> getStudentByNameHandler(@RequestParam String name){
		return new ResponseEntity<Student>(studentService.getStudetByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{roll}")
	public ResponseEntity<String> deleteStudentHandler(@PathVariable Integer roll){
		return new ResponseEntity<String>(studentService.deleteStudent(roll), HttpStatus.OK);
	}
	
	@PutMapping("/student/{roll}")
	public ResponseEntity<String> updateStudentHandler(@PathVariable Integer roll, @RequestBody Student student){
		return new ResponseEntity<String>(studentService.updateStudent(student, roll), HttpStatus.OK);
	}
}
