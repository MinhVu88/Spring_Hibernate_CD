package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;
import entities.Review;

public class CreateReviews {

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
			
			Course c = new Course("web development");
			
			c.addReview(new Review("awesome couses"));
			
			c.addReview(new Review("so-so courses"));
			
			c.addReview(new Review("boring couses"));
			
			s.save(c);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
