package com.mvc.hibernate.factory;

import com.mvc.hibernate.controller.EmployeeControllerImpl;
import com.mvc.hibernate.controller.IEmployeeController;

public class EmployeeControllerFactory {
	private static EmployeeControllerImpl EmployeeController = null;

	private EmployeeControllerFactory() {
		
	}
    public static IEmployeeController getEmployeeController() {
	if(EmployeeController == null)
	EmployeeController = new EmployeeControllerImpl();
	return EmployeeController;
}	
}
