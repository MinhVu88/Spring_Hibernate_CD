package demos;

import org.springframework.stereotype.Component;

@Component
public class WeeklyRewards implements Reward {
	
	@Override
	public String getRewards() {return "Weekly rewards for athletes' exceptional efforts";}

}
