/*
 
	아래 SoundPlayer 클래스는 음악을 재생해주는 클래스이다.
	이 클래스는 wav파일을 재생할 수 있는데,
	만약 mp3 파일을 재생하도록 요구사항이 변경 되었을 경우
	요구사항을 만족 시키기 위해 play() 메서드를 수정해야만 한다.
	이러한 소스코드 변경은 OCP 원칙에 위배된다.
	
	해결하기 위해서 3번 SoundPlayer에서
	생성한 2번 인터페이스를 멤버 변수로 만들고,
	play() 메서드는 인터페이스를 상속받아 구현된 클래스의 play() 함수를 실행시키게 하면 된다.
	마지막으로 메인 메서드에서 setter를 이용하여 우리가 ㅡㄹ레이 하고자 하는 파일의 객체를 지정해주면 된다.
	
	
	이와 같은 설계를 디자인 패턴에서는 Strategy Pattern이라고 한다.
	OCP를 만족한 설계는 변경에 유연하므로 
	유지보수 비용을 줄여주고 코드의 가독성 또한 높아지는 효과를 얻을 수 있다.
	
	- 출처 https://dev-momo.tistory.com/entry/SOLID-%EC%9B%90%EC%B9%99

	
 */

package solidOCPAndDIP;

class SoundPlayer {
	void play() {
		System.out.println("Play wav");
	}
}

public class _01_Client {
	public static void main(String[] args) {
		SoundPlayer sp = new SoundPlayer();
		sp.play();
	}
}
