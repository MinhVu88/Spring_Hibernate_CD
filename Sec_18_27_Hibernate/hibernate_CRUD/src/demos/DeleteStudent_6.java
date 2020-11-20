package demos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class DeleteStudent_6 {

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
			
			// session 1
			int stuId1 = 6;
			
			System.out.println("\n\t[ deleting student id #" + stuId1 + " ]\n");
			
			s1 = factory.getCurrentSession();
			
			s1.beginTransaction();
			
			Student removedStu = s1.get(Student.class, stuId1);
			
			s1.delete(removedStu);
			
			s1.getTransaction().commit();
			
			// session 2
			int stuId2 = 5;
			
			System.out.println("\n\t[ deleting student id #" + stuId2 + " ]\n");
			
			s2 = factory.getCurrentSession();
			
			s2.beginTransaction();
			
			s2.createQuery("delete from Student where id=5").executeUpdate();
			
			s2.getTransaction().commit();
			
			// session 3
			System.out.println("\n\t[ the remaining students ]\n");
			
			s3 = factory.getCurrentSession();
			
			s3.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Student> remainingStudents = s3.createQuery("from Student").list();
			
			for (Student stu : remainingStudents) {
				System.out.println(stu);
			}
			
			s3.getTransaction().commit();
			
			System.out.println("\n\t[ DONE ]\n");
		
		} catch (Exception e) {
			System.out.println("\n\t" + e.getMessage());
		
		} finally {
			if (s1 != null && s2 != null && s3 != null) {
				s1.close();
				
				s2.close();
				
				s3.close();
			}
		}
		
	}

}
