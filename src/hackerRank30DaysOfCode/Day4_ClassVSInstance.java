/*
	Objective
	In this challenge, we're going to learn about the difference between a class and an instance; because this is an Object Oriented concept, it's only enabled in certain languages. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Write a Person class with an instance variable, age, and a constructor that takes an integer, initialAge, as a parameter. The constructor must assign initialAge to age after confirming the argument passed as initialAge is not negative; if a negative argument is passed as initialAge, the constructor should set age to 0 and print Age is not valid, setting age to 0.. In addition, you must write the following instance methods:
	
	yearPasses() should increase the age instance variable by 0.
	amIOld() should perform the following conditional actions:
	If age < 13, print You are young..
	If age >= 13 and age < 18, print You are a teenager..
	Otherwise, print You are old..
	To help you learn by example and complete this challenge, much of the code is provided for you, but you'll be writing everything in the future. The code that creates each instance of your Person class is in the main method. Don't worry if you don't understand it all quite yet!
	
	Note: Do not remove or alter the stub code in the editor.
	

	-- 풀이 --
	이번문제 독해는 어렵지도 쉽지도 않았다.
	생성자를 호출했을 때 매개변수의 값이 음수이면
	필드값을 0으로 재설정해주고 양수면 필드값에 저장을 해준다.
	
	13 미만이면 You are young.
	13 이상 18 미만이면 You are a teenager.
	18 이상이라면 You are old. 를 출력하는 문제였다.
	
	필드변수와 생성자를 사용하는 방법에 대한 문제였다.
	
	다만 positive number가 양수이고
	negative number가 음수라는 걸 오늘 처음 알았다.
	3가지 단어 모두 따로따로는 알고있었는데..
	하긴 양은 밝고, 음은 어두운 느낌이니까
	
	단어공부도 틈틈히 해야겠다.

 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day4_ClassVSInstance {
	private int age;

	public Day4_ClassVSInstance(int initialAge) {
		
		if(initialAge < 0) {
			System.out.println("Age is not valid, setting age to 0.");
			initialAge = 0;
		}
		
		this.age = initialAge;
	}

	public void amIOld() {
		if(this.age < 13) {
			System.out.println("You are young.");
			return;
		}
		
		if(this.age < 18) {
			System.out.println("You are a teenager.");
			return;
		}
		
		System.out.println("You are old.");
	}

	public void yearPasses() {
		this.age++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			Day4_ClassVSInstance p = new Day4_ClassVSInstance(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
		}
		sc.close();
	}
}
