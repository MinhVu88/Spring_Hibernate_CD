package demos;

import org.springframework.beans.factory.annotation.Value;

public class BasketballCoach implements Coach {

	private Reward reward;
	
	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.team}")
	private String team;
	
	public BasketballCoach(Reward reward) {this.reward = new AnnualRewards();}
	
	public Reward getReward() {return new AnnualRewards();}

	public void setReward(Reward reward) {this.reward = new AnnualRewards();}

	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	public String getTeam() {return team;}

	public void setTeam(String team) {this.team = team;}

	@Override
	public String workout() {return "\nBasketball workout routine: practice slam dunk 500 times";}

	@Override
	public String receiveRewards() {return "\nReward(s) received: " + this.reward.getRewards();}

}
