package adapterPattern;

public class TurkeyAdapter implements Duck {
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	@Override
	public void quack() {
		turkey.gubble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}
	
	
}
