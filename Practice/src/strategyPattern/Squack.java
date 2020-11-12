package strategyPattern;

public class Squack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("삑 삑");
	}
	

}
