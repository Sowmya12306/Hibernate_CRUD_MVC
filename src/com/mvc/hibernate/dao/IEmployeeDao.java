package com.mvc.hibernate.dao;

import com.mvc.hibernate.dto.Employee;

public interface IEmployeeDao {


	String create(Employee emp); //create 
	Employee findById(Integer eid);//for read 
	String updateById(Employee emp);
	String deleteById(Integer eid);

}
