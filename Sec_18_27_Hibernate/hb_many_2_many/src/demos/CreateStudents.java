package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;
import entities.Review;
import entities.Student;

public class CreateStudents {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .addAnnotatedClass(Course.class)
											 .addAnnotatedClass(Review.class)
											 .addAnnotatedClass(Student.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
									
			s.beginTransaction();
			
			Course c = new Course("Hibernate training");
			
			s.save(c);
			
			Student st1 = new Student("John", "Doe", "male@luv2code.com");
			
			Student st2 = new Student("Jane", "Doe", "female@luv2code.com");
			
			c.addStudent(st1);
			
			c.addStudent(st2);
			
			s.save(st1);
			
			s.save(st2);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
