package com.luv2code.com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Course;
import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;
import com.luv2code.com.hibernate.demo.entity.Student;

public class GetCoursesForMary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//Use session to save and retrieve objects
			
												
			//Start transaction
			session.beginTransaction();
			
			//Fetch Student Mary
			Student tempStudent = session.get(Student.class, 2);
		
			System.out.println("Mary's Courses :" + tempStudent.getCourses());
							
			//Commit transaction
			session.getTransaction().commit();
			
			
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}