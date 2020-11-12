package adapterPattern;

public class MallradDuck implements Duck {

	@Override
	public void quack() {
		System.out.println("Quack quack");
	}

	@Override
	public void fly() {
		System.out.println("Cherry Filter");
	}
	
}
