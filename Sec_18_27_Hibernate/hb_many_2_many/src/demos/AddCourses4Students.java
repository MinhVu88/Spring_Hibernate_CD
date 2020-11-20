package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Course;
import entities.Instructor;
import entities.InstructorDetail;
import entities.Review;
import entities.Student;

public class AddCourses4Students {

	public static void main(String[] args) {
		
		try (
				SessionFactory factory = new Configuration()
											 .configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Instructor.class)
											 .addAnnotatedClass(InstructorDetail.class)
											 .addAnnotatedClass(Course.class)
											 .addAnnotatedClass(Review.class)
											 .addAnnotatedClass(Student.class)
											 .buildSessionFactory();
				
				Session s = factory.getCurrentSession();
				
				) {
									
			s.beginTransaction();
			
			Student st = new Student();
			
			st.setId(2);
			
			st = s.get(Student.class, st.getId());
			
			System.out.println(st);
			
			for (Course c : st.getCourses()) {
				System.out.println(c);
			}
			
			Course c1 = new Course("cyber security");
			
			Course c2 = new Course("game development");
			
			Course c3 = new Course("database administration");
			
			c1.addStudent(st);
			
			c2.addStudent(st);
			
			c3.addStudent(st);
			
			s.save(c1);
			
			s.save(c2);
			
			s.save(c3);
						
			s.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		}
		
	}

}
