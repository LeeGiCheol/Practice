package adapterPattern;

// 오리와 칠면조 인터페이스 생성
// 만약 오리 객체가 부족해서 칠면조 객체를 대신 사용해야 한다면?
// 두 객체는 인터페이스가 다르므로, 바로 칠면조 객체를 사용하는 것은 불가능함
// 따라서 칠면조 어댑터를 생성해서 활용해야 한다

public class MainTest {
	public static void main(String[] args) {
		MallradDuck duck = new MallradDuck();
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
	
		
		System.out.println("The turkey says..");
		turkey.gubble();
		turkey.fly();
		
		System.out.println("The duck says..");
		testDuck(duck);
		
		System.out.println("The TurkeyAdapter says");
		testDuck(turkeyAdapter);
	}
	
	public static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
