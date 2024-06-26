package com.mvc.hibernate.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mvc.hibernate.controller.IEmployeeController;
import com.mvc.hibernate.dto.Employee;
import com.mvc.hibernate.factory.EmployeeControllerFactory;

public class TestApp {
	static IEmployeeController employeeController = null;

	public static void main(String[] args) {
		String status = null,name=null,email=null,city=null,country=null;
		Integer id = null;
		Employee employeeRecord=null;
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Choose Your Option :: [1,2,3,4,5]");
				Integer option = Integer.parseInt(br.readLine());
				employeeController = EmployeeControllerFactory.getEmployeeController();

				switch (option) {
				case 1:
					System.out.println("Enter the name :: ");
				    name = br.readLine();
					System.out.println("Enter the emailId ::");
					email = br.readLine();
					System.out.println("Enter the city :: ");
					city = br.readLine();
					System.out.println("Enter the Country :: ");
					country = br.readLine();
					Employee emp = new Employee();
					emp.setName(name);
					emp.setEmail(email);
					emp.setCity(city);
					emp.setCountry(country);

					status = employeeController.create(emp);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record inserted successfully");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record insertion failed ");
					} else {
						System.out.println("Some problem occured please try again...");
					}

					break;
				case 2:
					System.out.println("Enter the id ::");
					id=Integer.parseInt(br.readLine());
					employeeRecord = employeeController.findById(id);
					if(employeeRecord != null)
						System.out.println(employeeRecord);
					else
						System.out.println("Record Not Found........");
					break;
//					
				case 3:
					System.out.println("Enter the id for updation ::");
					id=Integer.parseInt(br.readLine());
					employeeRecord = employeeController.findById(id);
					if(employeeRecord != null) {
						
						employeeRecord.setId(id);
					    System.out.println("EmployeeName :: [existing name is :: "+ employeeRecord.getName() + "]");
					    String new_name = br.readLine();
					    //updating name 
					    if(new_name==null ||new_name.equals("")) {
					    	employeeRecord.setName(employeeRecord.getName());
					    }
					    else {
					    	employeeRecord.setName(new_name);
					    }
					    //updating email
					    System.out.println("EmployeeEmail :: [existing email is :: "+ employeeRecord.getEmail() + "]");
					    String new_email = br.readLine();
					    
					    if(new_email == null ||new_email.equals("")) {
					    	employeeRecord.setEmail(employeeRecord.getEmail());
					    }
					    else {
					    	employeeRecord.setEmail(new_email);
					    }
					    //updating city
					    System.out.println("EmployeeCity :: [existing city is :: "+ employeeRecord.getCity() + "]");
					    String new_city = br.readLine();
					    
					    if(new_city==null ||new_city.equals("")) {
					    	employeeRecord.setCity(employeeRecord.getCity());
					    }
					    else {
					    	employeeRecord.setCity(new_city);
					    }
					    //updating country 
					    System.out.println("EmployeeCountry :: [existing country is :: "+ employeeRecord.getCountry() + "]");
					    String new_country = br.readLine();
					    
					    if(new_country == null ||new_country.equals("")) {
					    	employeeRecord.setCountry(employeeRecord.getCountry());
					    }
					    else {
					    	employeeRecord.setCountry(new_country);
					    }
					    
					    status = employeeController.updateById(employeeRecord);
					    if (status.equalsIgnoreCase("success")) {
					    	System.out.println("Record Updated Succesfully...3");
							System.out.println(employeeRecord);
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed ");
						} 
					}
					else
						System.out.println("Record Not Found........");
					break;
				case 4:
					System.out.println("Enter the id for deletion :: ");
					id = Integer.parseInt(br.readLine());
					status = employeeController.deleteById(id);					
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted succesfully");
					} else if (status.equalsIgnoreCase("failure")) {
						System.err.println("Record deletion failed ");
					} else {
						System.err.println("Record not available for the Given id...");
					}
					
					break;
				case 5:
					System.out.println("Thanks for using the application :) ");
					break;
				default:
					System.out.println("Please enter the option like 1, 2, 3, 4, 5 for operation");
					break;
				}
			}
		}
				catch (NumberFormatException e) {
			System.err.println("please enter valid inputs :: [1,2,3,4,5] " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

