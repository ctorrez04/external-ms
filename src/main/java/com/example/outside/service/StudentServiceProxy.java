package com.example.outside.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.outside.dto.Student;

@FeignClient(name="demo-service")
public interface StudentServiceProxy {

	@GetMapping("/students/{id}")
	public Student retrieveStudentById(@PathVariable("id") Long from);
	
	@GetMapping("/students/")
	public List<Student> retrieveStudentList();
}
