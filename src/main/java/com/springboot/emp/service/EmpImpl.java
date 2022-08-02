package com.springboot.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.emp.entity.EmpEntity;
import com.springboot.emp.exception.EmpExist;


@Service
public class EmpImpl implements EmpService{
		
		@Autowired
		private com.springboot.emp.repo.EmpRepo EmpRepo;
		
		@Override
		public String addEmployee(EmpEntity Employee) {
			EmpEntity clearEmpData = EmpRepo.findByName(Employee.getName());
			if (clearEmpData == null)
			{
				EmpRepo.save(Employee);
				return "New Employee Added to the Database";}
			else 
				throw new EmpExist ("EmployeeData Already Existed in the Database");
		}

		@Override
		public EmpEntity updateEmployee(EmpEntity Employee, int id)
		{
			Optional<EmpEntity> ed = EmpRepo.findById(id);
			EmpEntity eda = ed.get();
			eda.setName(Employee.getName());
			eda.setSalary(Employee.getSalary());
			eda.setDesignation(Employee.getDesignation());
			EmpRepo.save(eda);
			return eda;}
		
		@Override
		public List<EmpEntity> getEmployee(){
			return EmpRepo.findAllBySalary();}

		
	}

