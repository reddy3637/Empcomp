package com.springboot.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.emp.entity.EmpEntity;
import com.springboot.emp.service.EmpService;

@RestController
public class EmpController {
	

	    @Autowired
	    private EmpService service;
	    
	    @PostMapping("/Employee")
	    public String addEmployee(@RequestBody EmpEntity Employee) {
	        return service.addEmployee(Employee);}

	    @PutMapping("/Employee/{id}/{salary}")
	    public EmpEntity updEmployee(@PathVariable int salary, @PathVariable int id, @RequestBody EmpEntity Employee) {
	        return service.updateEmployee(Employee, salary);
	    }

	    @GetMapping("/Employee")
	    public List<EmpEntity> getAllEmployee(){
	        return service.getEmployee();
	    }
	    
	    @ExceptionHandler(value = com.springboot.emp.exception.EmpExist.class)
		public ResponseEntity EmpExist(
				com.springboot.emp.exception.EmpExist ExistExp) {
			return new ResponseEntity("Employee already exists!", HttpStatus.CONFLICT);

	    }
	}



