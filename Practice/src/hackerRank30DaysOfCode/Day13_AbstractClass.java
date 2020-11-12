/*
	Objective
	Today, we're taking what we learned yesterday about Inheritance and extending it to Abstract Classes. Because this is a very specific Object-Oriented concept, submissions are limited to the few languages that use this construct. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given a Book class and a Solution class, write a MyBook class that does the following:
	
	Inherits from Book
	Has a parameterized constructor taking these 3 parameters:
	string title
	string author
	int price
	Implements the Book class' abstract display() method so it prints these 3 lines:
	Title, a space, and then the current instance's title.
	Author, a space, and then the current instance's author.
	Price, a space, and then the current instance's price.
	Note: Because these classes are being written in the same file, you must not use an access modifier (e.g.: public) when declaring MyBook or your code will not execute.
	
	Input Format
	
	You are not responsible for reading any input from stdin. The Solution class creates a Book object and calls the MyBook class constructor (passing it the necessary arguments). It then calls the display method on the Book object.
	
	Output Format
	
	The void display() method should print and label the respective title, author, and price of the MyBook object's instance (with each value on its own line) like so:
	
	Title: $title
	Author: $author
	Price: $price
	Note: The  is prepended to variable names to indicate they are placeholders for variables.
	
	Sample Input
	
	The following input from stdin is handled by the locked stub code in your editor:
	
	The Alchemist
	Paulo Coelho
	248
	Sample Output
	
	The following output is printed by your display() method:
	
	Title: The Alchemist
	Author: Paulo Coelho
	Price: 248
	
	
	---풀이---
	Book 추상 클래스가 주어진다.
	display() 라는 추상 메서드를 포함하고 있다.
	
	Book을 상속받은 MyBook 클래스를 만들어 display() 메서드를 구현하라.
	
	title과 author만 가지고 있는 Book 생성자와는 다르게 price가 추가되어있다.
	필드변수는 super를 통해 기존의 것들을,
	this를 통해 price를 사용할 수 있도록 했다.
	
	그리고 display는 양식에 맞게 print 하도록 구현했다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

abstract class Book {
	String title;
	String author;

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	abstract void display();
}

class MyBook extends Book {
	int price;
	
	MyBook(String title, String author, int price) {
		super(title, author);
		this.price = price;
	}

	@Override
	void display() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
	}
	
}



public class Day13_AbstractClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		String author = scanner.nextLine();
		int price = scanner.nextInt();
		scanner.close();

		Book book = new MyBook(title, author, price);
		book.display();
	}
}
