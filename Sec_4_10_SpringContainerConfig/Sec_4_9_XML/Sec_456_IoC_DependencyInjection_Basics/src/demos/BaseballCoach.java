package demos;

public class BaseballCoach implements Coach {
	
	private Reward reward;
	
	public BaseballCoach() {}

	public BaseballCoach(Reward reward) {this.reward = new RewardsReceived();}
	
	public Reward getReward() {return new RewardsReceived();}

	public void setReward(Reward reward) {this.reward = new RewardsReceived();}

	@Override
	public String workout() {return "\nBaseball workout routine: spend 30 mins on batting practice";}

	@Override
	public String receiveRewards() {return "\nBaseball rewards received: " + this.reward.getRewards();}
	
}
