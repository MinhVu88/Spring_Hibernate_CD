package demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//@Component("tennis")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach, InitializingBean, DisposableBean {
	
	@Autowired
	@Qualifier("annualRewards")
	private Reward reward;
	
	public TennisCoach() {System.out.println("\ntennis: inside the no-arg constructor");}
		
	/*
	// constructor dependency injection
	@Autowired
	public TennisCoach(Reward reward) {this.reward = new AnnualRewards();}
	*/
	
	public Reward getReward() {return new AnnualRewards();}

	/*
	// setter dependency injection
	@Autowired
	public void setReward(Reward reward) {
		System.out.println("\ntennis: inside setReward()");
		
		this.reward = new AnnualRewards();
	}
	*/

	@Override
	public String workout() {return "\nWorkout: practice your backhand volley";}

	@Override
	public String receiveRewards() {return "\nReward: " + this.reward.getRewards();}
	
	/*
	// method dependency injection
	@Autowired
	public void doSomething(Reward reward) {
		System.out.println("\ntennis: inside doSomething()");
		
		this.reward = new AnnualRewards();
	}
	*/
	
	public void init() {System.out.println("\n\tinit() is executed AFTER the bean construction & dependency injections");}
	
	public void shutdown() {System.out.println("\n\tshutdown() is executed BEFORE the bean is destroyed/shut down");}
	
	@Override
	public void afterPropertiesSet() throws Exception {init();}
	
	@Override
	public void destroy() throws Exception {shutdown();}
	
}
