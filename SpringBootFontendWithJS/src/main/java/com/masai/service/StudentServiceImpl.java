package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Student;
import com.masai.respository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student registerStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudetByRoll(Integer roll) {
		return studentRepository.findById(roll).get();
	}

	@Override
	public Student getStudetByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public String deleteStudent(Integer roll) {
		studentRepository.deleteById(roll);
		
		return "Student deleted successfully !";
	}

	@Override
	public String updateStudent(Student student, Integer roll) {
		Optional<Student> optional = studentRepository.findById(roll);
		
		optional.get().setName(student.getName());
		optional.get().setMarks(student.getMarks());
		
		studentRepository.save(student);
		
		return "Student updated successfully!";
	}

}
