package incorrectAnswerSheet;

public class LambdaRunnable {
//	public static void main(String[] args) {
//		Runnable runnable = () -> {
//			for (int i = 0; i < 30; i++) {
//				System.out.println(i);
//			}
//		};
//		
//		Thread thread = new Thread(runnable);
//		thread.start();
//	}
	
	
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				System.out.println(i);
			}
		});
		
		thread.start();
	}
}
