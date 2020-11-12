package observerPattern;

import java.util.ArrayList;

// Publisher를 구현한 클래스로, 정보를 제공해주는 퍼블리셔가 됨


public class NewsMachine implements Publisher {

	private ArrayList<Observer> observers;
	private String title;
	private String news;
	
	public NewsMachine() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void delete(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {

		for (Observer observer : observers) {
			observer.update(title, news);
		}
	}
	
	public void setNewsInfo(String title, String news) {
		this.title = title;
		this.news  = news;
		
		notifyObserver();
	}

	public String getTitle() {
		return title;
	}


	public String getNews() {
		return news;
	}

	
}
