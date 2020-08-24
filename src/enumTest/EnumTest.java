/*
	프로그래밍을 하다보면 몇가지의 한정된 데이터들을 가지는 경우가 있다. 
	대표적으로는 "요일"이나 "계절" 같은것 
	요일은 월,화,수,목,금,토,일 이렇게 7가지이고, 
	계절도 봄,여름,가을,겨울 4가지 계절로 한정되어 있다. 
	이렇게 이와 같이 한정된 데이터들을 갖는 데이터들은 열거형으로 묶어주면 편리하다.
	
	아래 예제와 같이 사람별로 좋아하는 계절을 구해야 할 경우
	이름은 계속 변하지만 계절은 4가지로 고정이다.
	이럴 때 계절에 enum을 사용하는 것이 좋다.
	
	- 예제 출처 https://coding-factory.tistory.com/522
 */

package enumTest;


enum Season {
	봄, 여름, 가을, 겨울;
}

public class EnumTest {
	
	public String name;
	public Season favoriteSeason;
	
	public static void main(String[] args) {
		EnumTest people = new EnumTest();
		people.name = "홍길동";
		people.favoriteSeason = Season.가을;
		
		System.out.println("이름 : " + people.name);
		System.out.println("좋아하는 계절 : " + people.favoriteSeason);
		
		System.out.println("---------------------------------");
		
		// 열거 객체 메서드 - values()메소드는 열거 타입의 모든 열거객체들을 배열로 만들어 리턴한다.
		for (Season season : Season.values()) {
			System.out.println(season);
		}
		
		System.out.println("---------------------------------");

		// ordinal() 은 열거객체 중 몇번째 열거객체인지 리턴한다.
		Season season = Season.봄;
		System.out.println(season.ordinal());
	
		System.out.println("---------------------------------");

		// valueOf() 는 인자의 값과 동일한 문자열을 가지는 열거객체를 리턴한다.
		Season seasonValueOf = Season.valueOf("겨울");
		System.out.println(seasonValueOf);
		
		System.out.println("---------------------------------");

		// name() 은 열거객체가 가지고있는 문자열을 리턴한다.
		System.out.println(season.name());
		
		System.out.println("---------------------------------");
		
		Season s1 = Season.가을;
		Season s2 = Season.겨울;
		
		int result1 = s1.compareTo(s2);
		int result2 = s2.compareTo(s1);
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
	}
}
