package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;
import entities.Review;

public class GetReviews {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .addAnnotatedClass(Course.class)
											 .addAnnotatedClass(Review.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
									
			s.beginTransaction();
			
			Course c = new Course();
			
			c.setId(15);
			
			c = s.get(Course.class,	c.getId());
			
			System.out.println(c);
			
			for (Review r : c.getReviews()) {
				System.out.println(r);
			}
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
