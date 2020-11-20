package demos;

import org.springframework.stereotype.Component;

@Component
public class MonthlyRewards implements Reward {

	@Override
	public String getRewards() {return "Monthly rewards for athletes' exceptional efforts";}

}
