package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;

public class GetCourses_EagerLazy {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .addAnnotatedClass(Course.class)
											 .buildSessionFactory();
				
				//Session s = factory.getCurrentSession();
				
				) {
			
			Session s = factory.getCurrentSession();
									
			s.beginTransaction();
			
			/*
			Instructor instructor = new Instructor();
			
			instructor.setId(1);
			
			instructor = s.get(Instructor.class, instructor.getId());
			
			System.out.println(instructor);
						
			// solution 1: use the getter method for retrieving lazy loaded data
			for (Course c : instructor.getCourses()) {
				System.out.println(c);
			}
			*/
			
			// solution 2: use HQL for retrieving lazy loaded data
			Query<Instructor> query = s.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:instructorId", Instructor.class);
			
			int instructorId = 1;
			
			query.setParameter("instructorId", instructorId);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println(instructor);
			
			s.getTransaction().commit();
			
			s.close();
			
			System.out.println("\n\t[ the session is closed ]\n");
			
			for (Course c : instructor.getCourses()) {
				System.out.println(c);
			}
			
			//s.getTransaction().commit();
			
			System.out.println("\n\t~ DONE ~\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
