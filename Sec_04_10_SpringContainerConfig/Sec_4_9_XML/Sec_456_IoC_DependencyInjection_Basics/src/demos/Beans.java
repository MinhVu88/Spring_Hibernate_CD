package demos;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Beans {

	public static void main(String[] args) {
		
		try (
				// load the Spring config file
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
				
				) {
			
			// retrieve the bean from the Spring container
			Coach bean1 = context.getBean("football", Coach.class);
			
			Coach bean2 = context.getBean("baseball", BaseballCoach.class);
					
			// call methods on the bean (dependency injection type: constructor injection)
			System.out.println(bean1.workout());
			
			System.out.println(bean1.receiveRewards());
			
			System.out.println(bean2.workout());
			
			System.out.println(bean2.receiveRewards());
			
			// dependency injection type: setter injection
			Coach bean3 = context.getBean("cricket", CricketCoach.class);
			
			System.out.println(bean3.workout());
			
			System.out.println(bean3.receiveRewards());
			
			/**
			 * note: the interface Coach can't be used here to call getEmail() & getTeam() from the CricketCoach class
			 * 
			 * because an interface can't call its implementing classes' methods
			 * 
			 * that's why the result returned from getBean() must be assigned to a CricketCoach instance
			 * 
			 * so that the class's getter methods can be called
			 */
			CricketCoach bean4 = context.getBean("cricket", CricketCoach.class);
			
			System.out.println("\ncricket coach -> email: " + bean4.getEmail() + " | team: " + bean4.getTeam());
			
		} catch (BeansException e) {System.out.println("\n" + e.getMessage());}
	}

}
