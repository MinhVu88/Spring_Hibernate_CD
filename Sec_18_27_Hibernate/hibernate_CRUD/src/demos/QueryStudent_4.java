package demos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class QueryStudent_4 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Student.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
			
			s.beginTransaction();
			
			// query 1: retrieve all the Student data
			List<Student> studentList = s.createQuery("from Student").list();
			System.out.println("\n\t[ display all the students ]");
			displayStudents(studentList);
			
			System.out.println("\n");
			
			// query 2: lastName='Chancellor'
			studentList = s.createQuery("from Student s where s.lastName='Chancellor'").list();
			System.out.println("\n\t[ the student whose last name is Chancellor ]");
			displayStudents(studentList);
			
			System.out.println("\n");
			
			// query 3: lastName='Jones' or firstName='Paul'
			studentList = s.createQuery("from Student s where s.lastName='Jones' OR firstName='Paul'").list();
			System.out.println("\n\t[ the student whose last name is Jones or 1st name is Paul ]");
			displayStudents(studentList);
			
			System.out.println("\n");
			
			// query 4: using the predicate LIKE & wildcard %
			studentList = s.createQuery("from Student s where s.email LIKE '%luvcoding.com'").list();
			System.out.println("\n\t[ students whose email addresses end in luvcoding.com ]");
			displayStudents(studentList);
			
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

	private static void displayStudents(List<Student> studentList) {
		for (Student stu : studentList) {
			System.out.println(stu);
		}
	}

}
