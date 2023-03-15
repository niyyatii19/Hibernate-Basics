package com.gl.HibernateCodingChallenge1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCodingChallenge1.config.HibernateConfiguration;
import com.gl.HibernateCodingChallenge1.entity.Employee;
import com.gl.HibernateCodingChallenge1.entity.Project;

public class AppManyToMany {
	public static SessionFactory factory = HibernateConfiguration.getSessionFactory();
	public static void main(String[] args) {
	//Insert	
//		Session session = factory.openSession();
//		Transaction txc = session.beginTransaction();
//		Project proj1 = new Project("Networking project");
//		Project proj2 = new Project("IT project");
//		Project proj3 = new Project("frontend project");
//		
//		Employee emp1 = new Employee("Anthony");
//		Employee emp2 = new Employee("Peter");
//		Employee emp3 = new Employee("Vinay");
//		
//		List<Employee> employees1 = new ArrayList<>();
//		employees1.add(emp1);
//		employees1.add(emp2);
//		List<Project> projects1 = new ArrayList<>();
//		projects1.add(proj1);
//		projects1.add(proj2);
//		
//		emp1.setProjects(projects1);
//		proj1.setEmployees(employees1);
//		
//		List<Employee> employees2 = new ArrayList<>();
//		employees2.add(emp2);
//		employees2.add(emp3);
//		List<Project> projects2 = new ArrayList<>();
//		projects2.add(proj2);
//		projects2.add(proj3);
//		
//		emp2.setProjects(projects2);
//		proj2.setEmployees(employees2);
//		
//		session.persist(emp1);
//		session.persist(emp2);
//		session.persist(emp3);
//		
//	    txc.commit();
//	    session.close();
//		
		
		//Fetching employees using project id 
//	    Session sess1 = factory.openSession();
//	    List<Employee> getAllEmp = sess1.createQuery("from Employee e Join e.projects p where p.id = :pId", Employee.class)
//	    		.setParameter("pId", 2).getResultList();
//	    
//	    sess1.close();
//	    
//	    for(Employee e: getAllEmp) {
//	    	System.out.println(e);
//	    }
	    
	    
		//Fetching projects using emp id
	    Session sess2 = factory.openSession();
	    List<Project> getAllProj = sess2.createQuery("from Project p Join p.employees e where e.id = :eId", Project.class)
	    		.setParameter("eId", 2).getResultList();
	    
	    sess2.close();
	    
	    for(Project p: getAllProj) {
	    	System.out.println(p);
	    }
	    
	}
}
