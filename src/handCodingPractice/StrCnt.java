// ab가 몇개인지 체크하기

package handCodingPractice;

public class StrCnt {
	public static void main(String[] args) {
		String str = "abasdfasdfabsdfssab";

		int length = str.length();
		int cnt = 0;

		for (int i = 0; i < length; i++) {
			if(i <= length) {
				if(str.charAt(i) == 'a' && str.charAt(i + 1) == 'b') {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}