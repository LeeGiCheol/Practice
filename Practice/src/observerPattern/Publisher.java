package observerPattern;

// Observer들을 관리하는 메소드를 가지고 있음
// 옵저버 등록(add), 제외(delete), 옵저버들에게 정보를 알려줌(notifyObserver)

public interface Publisher {
	public void add(Observer observer);
	public void delete(Observer observer);
	public void notifyObserver();
}
