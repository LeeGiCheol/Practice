/*
 
	main 메서드에 setFile 메서드를 이용하여 실행하고자 하는 파일을 쉽게 변경할 수 있다.
	새로운 오디오 파일 포맷을 실행시키고자 한다면, 새로운 클래스를 만든 후 play 인터페이스를 상속받아 구현한 후
	setFile 메서드를 이용하여 file 멤버 변수에 주입시키면 된다.
	이와 같은 기술을 '의존성 주입' 이라 한다.

 */

package solidOCPAndDIP;

class _03_SoundPlayer {
	private _02_PlayAlgorithm file;
	
	public void setFile(_02_PlayAlgorithm file) {
		this.file = file;
	}
	
	public void play() {
		file.play();
	}
}


public class _03_Client {
	public static void main(String[] args) {
		_03_SoundPlayer sp = new _03_SoundPlayer();
		sp.setFile(new Wav());
		sp.setFile(new Mp3());
		
		sp.play();
	}
}
