// 클래스 안에 클래스(holder)를 두어 JVM의 클래스 로더 매커니즘과 클래스가 로드되는 시점을 이용한 방법
// 실제로 가장 많이 사용되는 일반적인 싱글톤 클래스 사용 방법이다.

package singletonMultiThread;

public class InitializationOnDemandHolderIdiom {
	private InitializationOnDemandHolderIdiom() {}
	
	private static class LazyHolder {
		public static final InitializationOnDemandHolderIdiom INSTANCE = new InitializationOnDemandHolderIdiom();
	}
	
	public static InitializationOnDemandHolderIdiom getInstance() {
		return LazyHolder.INSTANCE;
	}
}
