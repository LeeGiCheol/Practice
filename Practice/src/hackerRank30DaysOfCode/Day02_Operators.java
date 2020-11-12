/*
	Objective
	In this challenge, you'll work with arithmetic operators. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.
	
	Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result!
	
	Input Format
	
	There are  lines of numeric input:
	The first line has a double, mealCost (the cost of the meal before tax and tip).
	The second line has an integer, tipPercent (the percentage of mealCost being added as tip).
	The third line has an integer, taxPercent (the percentage of mealCost being added as tax).
	
	Output Format
	
	Print the total meal cost, where totalCost is the rounded integer result of the entire bill (mealCost with added tax and tip).
	
	Sample Input
	
	12.00
	20
	8
	Sample Output
	
	15
	
	
	- 문제 - 
	double 식사비용 + int 팁 + int 세금을 더해라
	팁은 식사비용의 x(입력값) 퍼센트 
	세금은 식사비용의 y(입력값) 퍼센트
	총 합계를 int로 반올림해서 출력
	
	-풀이-
	팁과 세금을 구한 후 더하기를 해줬는데 한개의 케이스가 실패했다.
	문제를 다시 읽어보니 반올림해서 구하라는데 
	그냥 더하기를 해서 아마 내림이 된 케이스에서 틀린 것 같다.
	그래서 Math.round() 함수를 사용해서 제출하니 정답이 나왔다.
	
	비교적 쉬운 문장이여서 오늘 독해는 나름 할만했다.
	
	Scanner.skip() 함수는 처음봤다.
	API에는 말 그대로 매개변수로 지정한 값을 스킵한다고 되어있다.
	문자열 패턴 이라고 나와있는걸 보니 정규식을 말하는 것으로 보였다.
	
	구글링 해보니 (\r\n|[\n\r\u2028\u2029\u0085])? 이라는 정규식으로
	엔터로인한 공백을 막으려고 사용했다고 한다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day02_Operators {
    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
    	double tip_cost = meal_cost * tip_percent / 100;
    	double tax_cost = meal_cost * tax_percent / 100;
    	
    	System.out.println(tip_cost);
    	System.out.println(tax_cost);
    	
    	long total_cost = Math.round(meal_cost + tip_cost + tax_cost);
    	
    	
    	System.out.println(total_cost);
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("1");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);
        
        
        
        scanner.close();
    }
}
