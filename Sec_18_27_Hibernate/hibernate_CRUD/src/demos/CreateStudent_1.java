package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class CreateStudent_1 {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Student.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
			
			System.out.println("\n\t[ create a Student instance ]");
			
			Student stu = new Student("Maynard", "Keenan", "Keenan@luv2code.com");
			
			s.beginTransaction();
			
			System.out.println("\n\t[ save the Student object to the database ]\n");
			
			s.save(stu);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
