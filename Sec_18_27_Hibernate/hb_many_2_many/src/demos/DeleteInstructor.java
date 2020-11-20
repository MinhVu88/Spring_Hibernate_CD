package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Instructor;
import entities.InstructorDetail;

public class DeleteInstructor {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {			
			
			s.beginTransaction();
			
			Instructor deletedInstructor = new Instructor();
			
			deletedInstructor.setId(1);
			
			if (deletedInstructor != null) {
				deletedInstructor = s.get(Instructor.class, deletedInstructor.getId());
				
				s.delete(deletedInstructor);
			}
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
