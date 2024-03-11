package com.mvc.hibernate.service;

import com.mvc.hibernate.dto.Employee;

public interface IEmployeeService {

	String create(Employee emp); //create 
	Employee findById(Integer eid);//for read 
	String updateById(Employee emp);
	String deleteById(Integer eid);
}
