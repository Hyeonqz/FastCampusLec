package oop.상속;

public class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("강아지처럼 먹는다");
        super.eat();
    }
}
