// 먼저 조건문으로 인스턴스의 존재 여부를 확인한 다음 두번째 조건문에서 
// synchronized를 통해 동기화를 시켜 인스턴스를 생성하는 방법
// 스레드를 안전하게 만들면서, 처음 생성 이후에는 synchronized를 실행하지 않기 때문에 성능저하 완화가 가능함


// volatile 키워드는 자바 코드의 변수를 '메인 메모리에 저장' 할 것을 명시하기 위해 쓰인다. 
// 정확히 말해서, 모든 volatile 변수는 컴퓨터의 메인 메모리로부터 읽히고, 
// volatile 변수에 대한 쓰기 작업은 메인 메모리로 직접 이루어진다. - CPU 캐시가 쓰이지 않는다.



package singletonMultiThread;

public class LazyInitializationDoubleCheckedLocking {
	private volatile static LazyInitializationDoubleCheckedLocking instance;
	
	private LazyInitializationDoubleCheckedLocking() {}
	
	public static LazyInitializationDoubleCheckedLocking getInstance() {
		if(instance == null) {
			synchronized(LazyInitializationDoubleCheckedLocking.class) {
				if(instance == null) {
					instance = new LazyInitializationDoubleCheckedLocking();
				}
			}
		}

		return instance;
	}
}
