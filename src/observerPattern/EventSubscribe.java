package observerPattern;

// Observer를 구현한 클래스들로, notifyObserver()를 호출하면서 알려줄 때마다 Update가 호출됨q

public class EventSubscribe implements Observer {

	private String newsString;
	private Publisher publisher;
	
	public EventSubscribe(Publisher publisher) {
		this.publisher = publisher;
		publisher.add(this);
	}
	
	@Override
	public void update(String title, String news) {
		newsString = title + " " + news;
		display();
	}
	
	public void withdraw() {
		publisher.delete(this);
	}
	
	public void display() {
		System.out.println("이벤트 유저");
		System.out.println(newsString);
	}
	
}
