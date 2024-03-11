package com.mvc.hibernate.controller;

import com.mvc.hibernate.dto.Employee;

public interface IEmployeeController {

	String create(Employee emp); //create 
	Employee findById(Integer eid);//for read 
	String updateById(Employee emp);
	String deleteById(Integer eid);

	
}
