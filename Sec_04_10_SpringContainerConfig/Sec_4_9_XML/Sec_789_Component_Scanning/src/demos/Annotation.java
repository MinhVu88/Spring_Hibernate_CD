package demos;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Annotation {

	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml")) {
			
			// use the user-defined bean id
			//Coach bean = context.getBean("tennis", TennisCoach.class);
			
			// use the default bean id, which is the class name with the 1st letter being lower-case
			Coach bean = context.getBean("tennisCoach", TennisCoach.class);
			
			System.out.println(bean.workout());
			
			System.out.println(bean.receiveRewards());
			
		} catch (BeansException e) {System.out.println("\n" + e.getMessage());}
		
	}

}
