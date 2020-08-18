package incorrectAnswerSheet;


public class LambdaMaxNum {

	// @FunctionalInterface는 함수가 하나뿐인 인터페이스를 의미함
	@FunctionalInterface
	public interface MyNumber {
		int getInt(int num , int num2);
	}
	
	public static void main(String[] args) {
		MyNumber max = (x, y) -> (x >= y) ? x : y;
		
		System.out.println(max.getInt(10, 20));
		
	}
}


