package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;

public class CreateCourses {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .addAnnotatedClass(Course.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
									
			s.beginTransaction();
			
			Instructor instructor = new Instructor();
			
			instructor.setId(1);
			
			instructor = s.get(Instructor.class, instructor.getId());
			
			Course c1 = new Course("HTML & CSS");
			
			Course c2 = new Course("Javascript");
			
			Course c3 = new Course("NODE js");
			
			Course c4 = new Course("Python");
			
			instructor.addCourse(c1);
			
			instructor.addCourse(c2);
			
			instructor.addCourse(c3);
			
			instructor.addCourse(c4);
			
			s.save(c1);
			
			s.save(c2);
			
			s.save(c3);
			
			s.save(c4);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
