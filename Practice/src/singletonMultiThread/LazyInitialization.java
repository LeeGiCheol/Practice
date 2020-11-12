// private static으로 인스턴스 변수 만듬
// private으로 생성자를 만들어 외부에서의 생성을 막음
// synchronized 동기화를 활용해 스레드를 안전하게 만듬
// 하지만, synchronized는 큰 성능저하를 발생시키므로 권장하지 않는 방법


package singletonMultiThread;

public class LazyInitialization {
	private static LazyInitialization instance;
	
	private LazyInitialization() {}
	
	public static synchronized LazyInitialization getInstance() {
		if(instance == null) {
			instance = new LazyInitialization();
		}
		
		return instance;
	}
}
