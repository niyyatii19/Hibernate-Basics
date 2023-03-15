package com.gl.HibernateCodingChallenge1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCodingChallenge1.config.HibernateConfiguration;
import com.gl.HibernateCodingChallenge1.entity.Address;
import com.gl.HibernateCodingChallenge1.entity.Student;
import com.gl.HibernateCodingChallenge1.entity.Teacher;

public class AppOneToOne {
	public static SessionFactory factory = HibernateConfiguration.getSessionFactory();
	public static void main(String[] args) {
		Student student1 = new Student("Asha", 23);
		Student student2 = new Student("Vinay", 31);
		Student student3 = new Student("Prisha", 21);
		Student student4 = new Student("Bhart", 23);
		
		Address addr1 = new Address("Har bahwan", "Shimla","HP", "1201233");
		Address addr2 = new Address("niwas","Pune", "Maharashtra", "1201213");
		Address addr3 = new Address("AXS", "Mysoru","Karnatka", "1201343");
		Address addr4 = new Address("dharma", "Shimla","HP", "129883");
		
		
		student1.setAddress(addr1);
		addr1.setStudent(student1); 
		
		addr2.setStudent(student2);
		student2.setAddress(addr2);
		addr3.setStudent(student3);
		student3.setAddress(addr3);
		addr4.setStudent(student4);
		student4.setAddress(addr4);
//		Insert Student
//		System.out.println("Inserted: " + insertStudent(student1));
//		System.out.println("Inserted: " + insertStudent(student2));
//		System.out.println("Inserted: " + insertStudent(student3));
//		System.out.println("Inserted: " + insertStudent(student4));
		
//		fetching student from address
//		for(Student s : getStudentFromAddress("Shimla")) {
//			System.out.println(s);
//		}
		
		//deleting address with student but the course will set null;
		
		Student s1 = getStudentByid(2);
		deleteAddr(s1.getAddress());
		
		
		
		
	}
	
	
	private static void deleteAddr(Address addr) {
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.remove(addr);
		tx.commit();
		sess.close();
	}


	private static List<Student> getStudentFromAddress(String address) {
		Session session = factory.openSession();
		List<Student> list = session.createQuery("from Student s where s.address.city = :city", Student.class)
				.setParameter("city", address).getResultList();
		session.close();
		return list;
	}


	public static int insertStudent(Student student) {
    	Session sess = factory.openSession();
    	Transaction tra = sess.beginTransaction();
    	sess.persist(student);
    	tra.commit();
    	sess.close();
    	return student.getId();
    }
	
	public static Student getStudentByid(int id) {
		Session  sess = factory.openSession();
		Student stu = sess.get(Student.class, id);
		sess.close();
		return stu;
	}
    
}
