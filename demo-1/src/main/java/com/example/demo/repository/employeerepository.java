package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modals.employee;

public interface employeerepository  extends CrudRepository<employee, Integer>{

	employee findByEmail(String email);

}
