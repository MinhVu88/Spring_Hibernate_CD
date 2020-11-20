package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Instructor;
import entities.InstructorDetail;

public class GetDetail {

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
			
			System.out.println("\n\t[ Additional info ]");
			
			System.out.println(detail);
			
			System.out.println("\n\t[ General info ]");
			
			System.out.println(detail.getInstructor());
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
