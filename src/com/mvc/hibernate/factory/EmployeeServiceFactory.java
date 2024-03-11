package com.mvc.hibernate.factory;

import com.mvc.hibernate.service.EmployeeServiceImpl;
import com.mvc.hibernate.service.IEmployeeService;

public class EmployeeServiceFactory {
	private static EmployeeServiceImpl EmployeeServiceImpl;

	private EmployeeServiceFactory() {
		
	}
	public static IEmployeeService getEmployeeService() {
		if(EmployeeServiceImpl==null) {
		EmployeeServiceImpl = new EmployeeServiceImpl();
		}
		return EmployeeServiceImpl;
			
	}
}
