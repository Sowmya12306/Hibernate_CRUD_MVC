package com.mvc.hibernate.factory;

import com.mvc.hibernate.dao.EmployeeDaoImpl;
import com.mvc.hibernate.dao.IEmployeeDao;

public class EmployeeDaoFactory {
    private static EmployeeDaoImpl EmployeeDao = null;
	private EmployeeDaoFactory() { // private bcoz to private object creation from outside
	}
	public static IEmployeeDao getEmployeeDao() {
		if(EmployeeDao == null) {
			EmployeeDao = new EmployeeDaoImpl();
		}
		return EmployeeDao;
	}
 
}
