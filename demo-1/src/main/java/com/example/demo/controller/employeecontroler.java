package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modals.employee;
import com.example.demo.services.employeeservice;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class employeecontroler {
@Autowired
employeeservice service;
@PostMapping("/insertion")
public employee insertion( @RequestBody employee l) {
	return service.insertion(l);
}
@PostMapping("/adddata")
public Iterable<employee> empinsert(@RequestBody List<employee> emp) {
	return service.adddata(emp);
}
@GetMapping("/getall")
public List<employee>getall(){
	return service.getall();
}
@GetMapping("/getbyid/{id}")
public Optional<employee> getbyid( @PathVariable  int id) {
	return service.getbyid(id);
}
@GetMapping("/findbyemail/{email}")
public employee findByEmail(@PathVariable String email ) {
	return service.getbyemail(email);
}
@DeleteMapping("/deletebyid/{id}")
public String deletebyid(@PathVariable int id) {
	return service.deletebyid(id);
}
@PutMapping("/update")
public employee updatebyid( @RequestBody employee e) {
	 return service.updatebyid(e);
 }
}