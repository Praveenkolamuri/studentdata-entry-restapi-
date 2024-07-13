package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modals.employee;
import com.example.demo.repository.employeerepository;

@Service
public class employeeservice {
@Autowired
employeerepository repo;
public employee insertion(   employee l) {
	return repo.save(l);
}
 public Iterable<employee> adddata(  List<employee> emp) {
	 return repo.saveAll(emp);
 }
  public List<employee> getall(){
	  return (List<employee>) repo.findAll();
  }
  public Optional<employee> getbyid(int id) {
	  return repo.findById(id);
  }
  public employee getbyemail(String email) {
	  return repo.findByEmail(email);
  }
  //delete
 public String deletebyid(int id) {
	  repo.deleteById(id);
	  return "succesfully deleted" + id;
  }
 public employee updatebyid(employee e) {
	 int id=e.getId();
	 employee emp = repo.findById(id).get();
	 emp.setId(e.getId());
	 emp.setBranch(e.getBranch());
	 emp.setName(e.getName());
	 emp.setRollno(e.getRollno());
	 emp.setPassword(e.getPassword());
	 emp.setEmail(e.getEmail());
	 return repo.save(e);
 }
 
 }
