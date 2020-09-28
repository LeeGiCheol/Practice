package observerPattern;

public class MainTest {
	public static void main(String[] args) {
		NewsMachine nm = new NewsMachine();
		AnnualSubscriber as1 = new AnnualSubscriber(nm);
		AnnualSubscriber as2 = new AnnualSubscriber(nm);
		EventSubscribe es1 = new EventSubscribe(nm);
		EventSubscribe es2 = new EventSubscribe(nm);

		nm.setNewsInfo("abc", "news");
		nm.setNewsInfo("zzz", "news!!!");
		
	}
}
