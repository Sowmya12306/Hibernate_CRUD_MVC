package com.mvc.hibernate.service;

import com.mvc.hibernate.dao.IEmployeeDao;
import com.mvc.hibernate.dto.Employee;
import com.mvc.hibernate.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao empDao;

	@Override
	public String create(Employee emp) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.create(emp);

	}
	@Override
	public Employee findById(Integer eid) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.findById(eid);
	}

	@Override
	public String updateById(Employee emp) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.updateById(emp);	}

	@Override
	public String deleteById(Integer eid) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.deleteById(eid);	}

}
