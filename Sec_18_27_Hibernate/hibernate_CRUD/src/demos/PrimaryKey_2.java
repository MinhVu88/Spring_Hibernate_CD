package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class PrimaryKey_2 {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Student.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
			
			System.out.println("\n\t[ create 4 Student instances ]\n");
			
			Student stu1 = new Student("Adam", "Jones", "Jones@luv2code.com");	
			
			Student stu2 = new Student("Danny", "Carey", "Carey@luvcoding.com");
			
			Student stu3 = new Student("Justin", "Chancellor", "Chancellor@luv2code.com");
			
			Student stu4 = new Student("Paul", "D'Amour", "DAmour@luvcoding.com");

			s.beginTransaction();

			System.out.println("\n\t[ save the Student objects to the database ]\n");
			
			s.save(stu1);
			
			s.save(stu2);
			
			s.save(stu3);
			
			s.save(stu4);

			s.getTransaction().commit();

			System.out.println("\n\t[ DONE ]\n");

		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
