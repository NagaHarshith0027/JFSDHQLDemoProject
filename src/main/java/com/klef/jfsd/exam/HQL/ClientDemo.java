package com.klef.jfsd.exam.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class ClientDemo {
	
	public static void main(String[] args)
	  {
	    ClientDemo operations = new ClientDemo();
	    //operations.addDepartment();
	    operations.updatepositionalparameters();
	  }
	
	public void addDepartment() {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");

	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();

	    Transaction transaction = session.beginTransaction();

	    Department dep = new Department();
	    dep.setName("BCA");
	    dep.setLocation("Banagalore");
	    dep.setHodName("K Naga Harshith");
	    dep.setNumberOfEmployees(35);

	    session.persist(dep);
	    transaction.commit();

	    System.out.println("Department Details Added Successfully");

	    session.close();
	    sf.close();
	}

	public void updatepositionalparameters()
	{
		    Configuration cfg = new Configuration();
		    cfg.configure("hibernate.cfg.xml");

		    SessionFactory sf = cfg.buildSessionFactory();
		    Session session = sf.openSession();

		    Transaction transaction = session.beginTransaction();

		    String hql = "update Department set name = ?1, location = ?2 where departmentId = ?3";

		    MutationQuery query = session.createMutationQuery(hql);
	        query.setParameter(1, "Biotechnology Department"); 
		    query.setParameter(2, "USA");         
		    query.setParameter(3, 2); 

		    int n = query.executeUpdate();
		    if (n > 0) {
		        System.out.println("Department Details updated successfully.");
		    } else {
		        System.out.println("Department ID not found.");
		    }
		    transaction.commit();
		    session.close();
		    sf.close();
		}

}


