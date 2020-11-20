package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class ReadStudent_3 {

	public static void main(String[] args) {
		
		Session s1 = null;

		Session s2 = null;
		
		try (
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				) {
			
			// session 1
			Student stu = new Student("Layne", "Staley", "Staley@luvcoding.com");
			System.out.println("\n\t[ student id BEFORE being saved to the database: " + stu.getId() + " ]\n");
			
			s1 = factory.getCurrentSession();
			s1.beginTransaction();
			s1.save(stu);
			
			s1.getTransaction().commit();
			
			// session 2
			System.out.println("\n\t[ student id AFTER being saved to the database: " + stu.getId() + " ]");
			
			System.out.println("\n\t[ retrieve the Student object using the new id: " + stu.getId() + " ]\n");
			
			s2 = factory.getCurrentSession();
			s2.beginTransaction();
			Student retrievedStu = s2.get(Student.class, stu.getId());
			
			s2.getTransaction().commit();
			
			System.out.println("\n\t[ The result ]");
			
			System.out.println(retrievedStu);
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		
		} finally {
			if(s1 != null && s2 != null) {
				s1.close();
				
				s2.close();
			}
		}
		
	}

}
