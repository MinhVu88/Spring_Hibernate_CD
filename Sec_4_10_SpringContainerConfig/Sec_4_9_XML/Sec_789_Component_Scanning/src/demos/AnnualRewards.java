package demos;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AnnualRewards implements Reward {
	
	private String[] rewards = {"financial gains", "good reputation", "consolidated skills", "better health", "nice body"};
	
	private Random anyReward = new Random();
	
	@Override
	public String getRewards() {return rewards[anyReward.nextInt(rewards.length)];}

}
