package demos;

public class Main {

	public static void main(String[] args) {
		
		Coach baseball = new BaseballCoach();
		
		System.out.println(baseball.workout());
		
		Coach football = new FootballCoach();
		
		System.out.println(football.workout());
		
	}

}
