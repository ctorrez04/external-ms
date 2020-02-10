package com.example.outside.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.outside.dto.Student;
import com.example.outside.service.StudentServiceProxy;


@RestController
public class ExternalController {
	
	/*private static final String URL_ZUUL_SERVER="http://zuul-server";
	private static final String URL_DEMO_SERVICE="http://demo-service";
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student res = restTemplate.getForObject(
				URL_ZUUL_SERVER + "/demo/students/"+id, Student.class);
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/ext/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentDemo(@PathVariable Long id) {
		Student res = restTemplate.getForObject(
				URL_DEMO_SERVICE + "/students/"+id, Student.class);
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/ext/", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudentListDemo() {
		ResponseEntity<Object[]> res= restTemplate.getForEntity(
				URL_DEMO_SERVICE + "/students/", Object[].class);
		return new ResponseEntity<>(res.getBody(), HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudentList() {
		ResponseEntity<Object[]> res= restTemplate.getForEntity(
				URL_DEMO_SERVICE + "/students/", Object[].class);
		return new ResponseEntity<>(res.getBody(), HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello() {
		return "Hello Demo. I'm External";
	}*/
	
	@Autowired
	private StudentServiceProxy proxy;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student response = proxy.retrieveStudentById(id);
	    System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Student> getStudents() {
		List<Student> response = proxy.retrieveStudentList();
	    System.out.println(response.size());
		return response;
	}

}
