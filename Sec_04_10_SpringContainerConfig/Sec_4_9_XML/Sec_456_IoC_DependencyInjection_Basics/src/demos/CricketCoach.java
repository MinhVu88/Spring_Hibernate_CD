package demos;

import org.springframework.beans.factory.annotation.Value;

public class CricketCoach implements Coach {

	private Reward reward;
	
	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.team}")
	private String team;
	
	public CricketCoach() {System.out.println("\n\tcricket: inside the no-arg constructor");}
	
	public CricketCoach(Reward reward) {this.reward = new RewardsReceived();}
	
	public Reward getReward() {return new RewardsReceived();}

	public void setReward(Reward reward) {
		System.out.println("\n\tcricket: inside the setter method");
		
		this.reward = new RewardsReceived();
	}
	
	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	public String getTeam() {return team;}

	public void setTeam(String team) {this.team = team;}

	@Override
	public String workout() {return "\nCricket workout routine: practice fast bowling for 15 mins";}

	@Override
	public String receiveRewards() {return "\nCricket rewards received: " + this.reward.getRewards();}
	
	
}
