package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Instructor;
import entities.InstructorDetail;

public class DeleteDetail {

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
			
			InstructorDetail detail = new InstructorDetail();
			
			detail.setId(2);
			
			detail = s.get(InstructorDetail.class, detail.getId());
			
			System.out.println("\n\t[ Delete the instructor detail #" + detail.getId() + " ]");
			
			// break the bi-directional link in memory between the Instructor class & the InstructorDetail class
			// by removing the detail object reference from the Instructor class 
			// & re-factoring the cascade types in the InstructorDetail class
			detail.getInstructor().setDetail(null);
			
			s.delete(detail);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
