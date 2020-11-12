package observerPattern;

public class AnnualSubscriber implements Observer {

	private String newsString;
	private Publisher publisher;
	
	public AnnualSubscriber(Publisher publisher) {
		this.publisher = publisher;
		publisher.add(this);
	}
	
	@Override
	public void update(String title, String news) {
		this.newsString = title + "    " + news +  "\n ----------- \n";
		display();
	}
	
	private void display() {
		System.out.println("연간 구독 유저");
		System.out.println(newsString);
	}

}
