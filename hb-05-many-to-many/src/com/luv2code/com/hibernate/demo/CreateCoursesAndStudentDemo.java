package com.luv2code.com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Course;
import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;
import com.luv2code.com.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentDemo {

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
			
			//Create Courses
			Course tempCourse = new Course("History");
			Course tempCourse1 = new Course("Geography");
			session.save(tempCourse);
			session.save(tempCourse1);
			
			//Create Students
			Student tempStudent = new Student("Maisunath", "Maliha", "mumus@gmail.com");
			
			//Add students to the course
			tempStudent.add(tempCourse);
			tempStudent.add(tempCourse1);
			
			//Save the new student
			session.save(tempStudent);			
			
							
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