package oop.클래스;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.name = "진현규";
		p.age = "26";
		p.phone = "010-1234-5678";
		System.out.println(p.name + "\t" + p.age + "\t" + p.phone);
		p.play();
		p.eat();
		p.walk();

		System.out.println();
		Person p1 = new Person();
		p1.name = "윤성환";
		p1.age = "26";
		p1.phone = "010-2354-0321";
		System.out.println(p1.name + "\t" + p1.age + "\t" + p1.phone);
		p1.play();
		p1.eat();
		p1.walk();
	}
}
