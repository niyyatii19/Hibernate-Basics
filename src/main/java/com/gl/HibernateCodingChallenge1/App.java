package com.gl.HibernateCodingChallenge1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCodingChallenge1.config.HibernateConfiguration;
import com.gl.HibernateCodingChallenge1.entity.Teacher;



public class App {
	private static SessionFactory factory = HibernateConfiguration.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Teacher teacher1 = new Teacher("Nalini", "yadav", "yadav@gmail.com");
		Teacher teacher2 = new Teacher("Shalini", "sharma", "shalini@gmail.com");
		Teacher teacher3 = new Teacher("Nisa", "shahi", "nshai@gmail.com");
		
//		Insert
//		System.out.println("Inserted with id " + insertTeacher(teacher1));
//		System.out.println("Inserted with id " + insertTeacher(teacher2));
//		System.out.println("Inserted with id " + insertTeacher(teacher3));

//      Update
//		teacher1.setId(1);
//		teacher1.setEmail("nYadav.@gmail.com");
//		System.out.println("Updated: "+ updateTeacher(teacher1));
		
//		get teacher details with id 2
//		System.out.println(getTeacherById(2));
		
//		fetch all records
//		for(Teacher t: getAllTeacher()) {
//			System.out.println(t);
//		}
		
//		Remove record
//		teacher1.setId(1);
//		System.out.println("Remove : ");
//		deleteTeacher(teacher1);
		
	}
	
	
	public static int insertTeacher(Teacher teacher) {
    	Session sess = factory.openSession();
    	Transaction tra = sess.beginTransaction();
    	sess.persist(teacher);
    	tra.commit();
    	sess.close();
    	return teacher.getId();
    }
    
   
    
    public static Teacher updateTeacher(Teacher teacher) {
    	Session sess = factory.openSession();
    	Transaction tra = sess.beginTransaction();
    	Teacher updatedTeach = sess.merge(teacher);
    	tra.commit();
    	sess.close();
    	return updatedTeach;
    }
    
    
    public static void deleteTeacher(Teacher teacher) {
    	Session sess = factory.openSession();
    	Transaction tra = sess.beginTransaction();
    	sess.remove(teacher);
    	tra.commit();
    	sess.close();
    }
    
    
    public static Teacher getTeacherById(int teachId) {
    	Session ses = factory.openSession();
    	Teacher teach = ses.get(Teacher.class, teachId);
    	ses.close();
    	return teach;
    }
    
    public static List<Teacher> getAllTeacher(){
    	Session sess = factory.openSession();
    	List<Teacher> teachers = sess.createQuery("from Teacher", Teacher.class).getResultList();
    	
    	
    	sess.close();
    	return teachers;
    }
}
