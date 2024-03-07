package oop.상속;

public class AnimalUpcastingTest {
    public static void main(String[] args) {

        Animal ani = new Dog();
        ani.eat();

        Animal ani1 = new Cat();
        ani1.eat();

    }
}
