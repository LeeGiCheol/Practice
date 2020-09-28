package solidOCPAndDIP;

interface _02_PlayAlgorithm {
	public void play();
}

class Wav implements _02_PlayAlgorithm {

	@Override
	public void play() {
		System.out.println("Play Wav");
	}
	
}

class Mp3 implements _02_PlayAlgorithm {

	@Override
	public void play() {
		System.out.println("Play Mp3");
	}
	
}
