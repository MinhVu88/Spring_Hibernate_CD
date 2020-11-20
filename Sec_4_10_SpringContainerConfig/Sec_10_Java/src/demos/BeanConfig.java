package demos;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:coach.properties")
//@ComponentScan("demos")
public class BeanConfig {
	
	/**
	 * define a bean for yearly rewards
	 * @return a reference to a AnnualRewards instance
	 */
	@Bean
	public Reward getRewardBean() {return new AnnualRewards();}
	
	/**
	 * define a bean for a basketball coach & inject dependency
	 * @return a reference to a BasketballCoach instance
	 */
	@Bean
	public Coach getBasketballBean() {return new BasketballCoach(getRewardBean());}
	
}
