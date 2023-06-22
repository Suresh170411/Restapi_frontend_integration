package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	private Integer roll;
	private String name;
	private Integer age;
	private Integer marks;
}
