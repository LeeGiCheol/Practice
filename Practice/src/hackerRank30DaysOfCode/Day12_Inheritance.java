/*
	Objective
	Today, we're delving into Inheritance. Check out the attached tutorial for learning materials and an instructional video!
	
	Task
	You are given two classes, Person and Student, where Person is the base class and Student is the derived class. Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.
	
	Complete the Student class by writing the following:
	
	A Student class constructor, which has 4 parameters:
	A string, firstName.
	A string, lastName.
	An integer, id.
	An integer array (or vector) of test scores, scores.
	A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:
	Grading.png
	
	Input Format
	
	The locked stub code in your editor calls your Student class constructor and passes it the necessary arguments. It also calls the calculate method (which takes no arguments).
	
	You are not responsible for reading the following input from stdin:
	The first line contains firstName, lastName, and id, respectively. The second line contains the number of test scores. The third line of space-separated integers describes scores.
	
	
	Output Format
	
	This is handled by the locked stub code in your editor. Your output will be correct if your Student class constructor and calculate() method are properly implemented.
	
	Sample Input
	
	Heraldo Memelli 8135627
	2
	100 80
	Sample Output
	
	 Name: Memelli, Heraldo
	 ID: 8135627
	 Grade: O
	 
	 
	 
	 ---풀이---
	 
	 상속 문제였다.  
	 Person과 Student 두개의 클래스가 주어지고,
	 Person이 부모클래스 Student가 자식클래스이다.
	 Student의 생성자에는 총 4개의 파라미터가 필요하고,
	 char 타입의 calculate 메서드가 필요하다.
	 
	 calculate 메서드는 성적의 평균값을 구해 등급을 리턴한다.
	 
	 별생각없이 배열의 모든값을 더해 배열의 length로 나누어서 풀이했다.
	 
	 풀이 후 stream을 통해 평균값을 구하는 것도 알게되었다.
	 한줄로 해결이 된다. 확실히 stream이나 lambda는 코드 길이 줄이는게 엄청난 것 같다.
	 따로 공부를 해볼 예정
	 
 */

package hackerRank30DaysOfCode;

import java.util.*;
class Person {

	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;

	public Student(String firstName, String lastName, int identification, int[] testScores) {
		super(firstName, lastName, identification);
		this.testScores = testScores;
	}

	char calculate() {
		// 나의 풀이
		double avg = 0;
		for (int i = 0; i < testScores.length; i++) {
			avg += testScores[i];
		}
		avg /= testScores.length;

		// stream을 활용한 풀이
//        double avg = Arrays.stream(this.testScores).average().getAsDouble();

		
		if(avg >= 90) return 'O';
		if(avg >= 80) return 'E';
		if(avg >= 70) return 'A';
		if(avg >= 55) return 'P';
		if(avg >= 40) return 'D';
		
		return 'T';
	}
}

public class Day12_Inheritance {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}
