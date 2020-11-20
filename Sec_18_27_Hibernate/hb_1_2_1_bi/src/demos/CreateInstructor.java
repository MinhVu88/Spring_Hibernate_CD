package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Instructor;
import entities.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
									
			/*
			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail detail = new InstructorDetail("http://www.luv2code.com/youtube", "coding");
			*/
			
			
			Instructor instructor = new Instructor("Paul", "Davids", "davis@luvguitars.com");
			
			InstructorDetail detail = new InstructorDetail("http://www.luvguitars.com/youtube", "playing guitar");
			
			
			instructor.setDetail(detail);
			
			s.beginTransaction();
			
			// because of "OneToOne(cascade=CascadeType.ALL)", detail is also saved to the db
			s.save(instructor);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
