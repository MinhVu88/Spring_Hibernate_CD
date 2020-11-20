package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class UpdateStudent_5 {

	public static void main(String[] args) {
		
		Session s1 = null;

		Session s2 = null;

		Session s3 = null;
		
		try (
				SessionFactory factory = new Configuration()
					 					.configure("hibernate.cfg.xml")
					 					.addAnnotatedClass(Student.class)
					 					.buildSessionFactory();
				
				) {
			
			int stuId = 6;
			
			// session 1
			System.out.println("\n\t[ original student id #" + stuId + " ]\n");
			s1 = factory.getCurrentSession();
			s1.beginTransaction();
			System.out.println(s1.get(Student.class, stuId));
			
			s1.getTransaction().commit();
			
			// session 2
			System.out.println("\n\t[ new student id #" + stuId + " ]\n");
			s2 = factory.getCurrentSession();
			s2.beginTransaction();			
			
			Student updatedStu = s2.get(Student.class, stuId);			
			updatedStu.setFirstName("Chris");			
			updatedStu.setLastName("Cornell");
			
			s2.getTransaction().commit();
			
			System.out.println("\n\t[ The result ]");
			System.out.println(updatedStu);
			
			// session 3
			System.out.println("\n\t[ new email addresses for all students ]\n");
			s3 = factory.getCurrentSession();
			s3.beginTransaction();
			s3.createQuery("update Student set email='rockgod@fuckyeah.com'").executeUpdate();
			
			s3.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		
		} finally {
			if(s1 != null && s2 != null && s3 != null) {
				s1.close();
				
				s2.close();
				
				s3.close();
			}
		}
		
	}

}
