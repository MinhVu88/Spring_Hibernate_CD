package demos;

public class FootballCoach implements Coach {
	
	private Reward reward;
	
	public FootballCoach() {}
	
	public FootballCoach(Reward reward) {this.reward = new RewardsReceived();}
	
	public Reward getReward() {return new RewardsReceived();}

	public void setReward(Reward reward) {this.reward = new RewardsReceived();}

	@Override
	public String workout() {return "\nFootball workout routine: run a hard 5k";}

	@Override
	public String receiveRewards() {return "\nFootball rewards received: " + this.reward.getRewards();}
	
	public void init() {System.out.println("\nFootball: inside init()");}
	
	public void shutdown() {System.out.println("\nFootball: inside shutdown()");}
	
}
