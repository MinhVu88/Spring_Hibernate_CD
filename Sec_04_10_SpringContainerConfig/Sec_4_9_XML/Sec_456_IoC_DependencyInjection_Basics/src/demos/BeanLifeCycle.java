package demos;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycle.xml")) {
			
			Coach bean = context.getBean("football", Coach.class);
			
			System.out.println(bean.workout());
			
		} catch (BeansException e) {System.out.println("\n" + e.getMessage());}
		
	}

}
