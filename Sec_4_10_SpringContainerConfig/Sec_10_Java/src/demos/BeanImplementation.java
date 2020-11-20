package demos;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanImplementation {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class)) {
			
			Coach bean = context.getBean("getBasketballBean", Coach.class);
			
			System.out.println(bean.workout());
			
			System.out.println(bean.receiveRewards());
			
			BasketballCoach coach = context.getBean("getBasketballBean", BasketballCoach.class);
			
			System.out.println("\nbasketball coach email: " + coach.getEmail());
			
			System.out.println("\nbasketball coach team: " + coach.getTeam());
			
		} catch (BeansException e) {System.out.println("\n" + e.getMessage());}
		
	}

}
