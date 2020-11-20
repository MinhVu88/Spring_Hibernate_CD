package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;

public class GetCourses {

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
			
			System.out.println(instructor);
			
			for (Course c : instructor.getCourses()) {
				System.out.println(c);
			}
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
