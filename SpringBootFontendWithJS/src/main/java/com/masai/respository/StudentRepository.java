package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByName(String name);
}
