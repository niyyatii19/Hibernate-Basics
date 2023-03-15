package com.gl.HibernateCodingChallenge1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCodingChallenge1.config.HibernateConfiguration;
import com.gl.HibernateCodingChallenge1.entity.Address;
import com.gl.HibernateCodingChallenge1.entity.Course;
import com.gl.HibernateCodingChallenge1.entity.Student;

public class AppOneToMany {
	public static SessionFactory factory = HibernateConfiguration.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course c1 = new Course("Javascript");
		Course c2 = new Course("Java");
		Course c3 = new Course("React");
		//inserting course
//		Session sess = factory.openSession();
//    	Transaction tra = sess.beginTransaction();
//    	sess.persist(c1);
//    	sess.persist(c2);
//    	sess.persist(c3);
//    	tra.commit();
//    	sess.close();
    	
    	c1.setId(1);
		c2.setId(2);
		c3.setId(3);
		
		List<Course> courses = new ArrayList<>();
		Student stud1 = getStudentByid(4);
//		courses.add(c1);
		courses.add(c2);
		stud1.setCourses(courses);
		c1.setStudent(stud1);
		c2.setStudent(stud1);
		
		List<Course> courses1 = new ArrayList<>();
		Student stud2 = getStudentByid(3);
		courses1.add(c1);
		courses1.add(c3);
		stud2.setCourses(courses1);
		c1.setStudent(stud2);
		c3.setStudent(stud2);
		//updating existing student with course
//		Session sess1 = factory.openSession();
//    	Transaction tra1 = sess1.beginTransaction();
//    	sess1.merge(c1);
//    	sess1.merge(c2);
//    	sess1.merge(c3);
//    	tra1.commit();
//    	sess1.close();
		
		//removing course wont affect student
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		c1.setStudent(null);
		sess.remove(c1);
		tx.commit();
		sess.close();
		
	}
	
	public static Student getStudentByid(int id) {
		Session  sess = factory.openSession();
		Student stu = sess.get(Student.class, id);
		sess.close();
		return stu;
	}

}
