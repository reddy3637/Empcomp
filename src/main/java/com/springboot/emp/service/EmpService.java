package com.springboot.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.emp.entity.EmpEntity;
import com.springboot.emp.exception.EmpExist;

@Service
public interface EmpService {
	
		
		public String addEmployee(EmpEntity Employee) throws EmpExist;
		
		public List<EmpEntity> getEmployee();
		
		public EmpEntity updateEmployee(EmpEntity Employee, int id) ;
	}

