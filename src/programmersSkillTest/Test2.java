package programmersSkillTest;

public class Test2 {
	public static void main(String[] args) {
		
//		StringBuffer a = new StringBuffer("abc");
//		System.out.println(a.reverse());
		
//		String a = "abc";
//		
//		for (int i = a.length() - 1; i >= 0; i--) {
//			System.out.print(a.charAt(i));
//		}

		
//		String a = "a";
//		int a_ = a.charAt(0);
//		System.out.println(a_);
//		
//		
//		char b = 'b';
//		int b_ = b;
//		
//		
//		System.out.println(b_);
		
//		int sum = 0;
//		for (int i = 1; i <= 20; i++) {
//			if(i % 2 == 0)
//				sum -= i;
//			else if(i % 2 == 1)
//				sum += i;
//		}
//		
//		System.out.println(sum);
		
		
//		double sum = 0;
//		
//		for (double i = 0; i <= 99; i++) {
//			if(i % 2 != 0)
//				sum += i / (i + 1);
//			
//			else
//				sum -= i / (i + 1);
//		}
//		
//		System.out.println(sum);

		int sum = 0;
		int cnt = 1;
		
		for (int i = 0; i < 20; i++) {
			cnt += i;
			sum += cnt;
			System.out.println(cnt);
		}
		
		
	}
}
