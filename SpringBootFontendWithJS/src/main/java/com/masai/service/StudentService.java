package com.masai.service;

import java.util.List;

import com.masai.model.Student;

public interface StudentService {

	public Student registerStudent(Student student);
	
	public Student getStudetByRoll(Integer roll);
	
	public Student getStudetByName(String name);
	
	public List<Student> getAllStudents();
	
	public String deleteStudent(Integer roll);
	
	public String updateStudent(Student student, Integer roll);
}
