package demos;

import org.springframework.stereotype.Component;

@Component
public class DailyRewards implements Reward {

	@Override
	public String getRewards() {return "Daily rewards for athletes' exceptional efforts";}

}
