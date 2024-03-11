package com.mvc.hibernate.controller;

import com.mvc.hibernate.dto.Employee;
import com.mvc.hibernate.factory.EmployeeControllerFactory;
import com.mvc.hibernate.factory.EmployeeServiceFactory;
import com.mvc.hibernate.service.IEmployeeService;

public class EmployeeControllerImpl implements IEmployeeController{
	IEmployeeService empService;
	
@Override
public String create(Employee emp) {
	empService = EmployeeServiceFactory.getEmployeeService();
	System.out.println("Implementation class name is :: "+ empService.getClass().getName());
	return empService.create(emp);
}

@Override
public Employee findById(Integer eid) {
	empService = EmployeeServiceFactory.getEmployeeService();
	return empService.findById(eid);
}
//
@Override
public String updateById(Employee emp) {
	empService = EmployeeServiceFactory.getEmployeeService();
	return empService.updateById(emp);}

@Override
public String deleteById(Integer eid) {
	empService = EmployeeServiceFactory.getEmployeeService();
	return empService.deleteById(eid);}
}
