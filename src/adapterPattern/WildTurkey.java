package adapterPattern;

public class WildTurkey implements Turkey {

	@Override
	public void gubble() {
		System.out.println("Gubble gubble");
	}

	@Override
	public void fly() {
		System.out.println("I'm flying a short distance");
	}
	
}
