package com.mvc.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mvc.hibernate.dto.Employee;
import com.mvc.hibernate.util.HibernateUtil;


public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public String create(Employee emp) {
		String status = null;
		Session session=null;
		boolean flag=false;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				session.save(emp);  // in L1-cache
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();// stored in DB through ORM
				status = "success";
			}
			else {
				transaction.rollback();
				status = "failure";
			}
			HibernateUtil.closeSession(session);
		}
		return status;

	}

	@Override
	public Employee findById(Integer eid) {
		Session session=null;
		boolean flag=false;
		SessionFactory sessionFactory = null;
		Employee emp =null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				emp = session.get(Employee.class, eid);// in L1-cache
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return emp;
	}


	@Override
	public String updateById(Employee emp) {
		Session session=null;
		boolean flag=false;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		String status = null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				session.clear();
				session.saveOrUpdate(emp);
				//		      session.merge(emp);// in L1-cache
				flag = true;
				System.out.println(emp);

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();// stored in DB through ORM
				status = "success";
			}
			else {
				transaction.rollback();
				status="failure";
			}
			HibernateUtil.closeSession(session);
		}
		return status;	
	}


	@Override
	public String deleteById(Integer eid) {
		Session session = null;
		SessionFactory sessionFactory = null;
		String status = null;
		Transaction transaction = null;
		boolean flag = false;
		Employee emp = null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
				emp = session.get(Employee.class, eid);
				if(emp!=null) {
				session.delete(emp);
				flag=true;
				}
				else {
//					System.out.println("No record exists ");
//					System.err.println("No record exists with given id "+ eid);
//					System.exit(0);
					flag = false;
				}
			}
		}

		catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally { 
			if(flag==true) {
				transaction.commit();
				status = "success";
			}
			else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}
}

