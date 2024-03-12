package oop.다형성;

import oop.상속.Animal;
import oop.상속.Cat;
import oop.상속.Dog;

public class PolyTest {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat(); //컴파일 할때는 Animal 것이지만, 실행시점에서는 Dog 메소드를 이용한다 -> 동적바인딩.

        Animal animal1 = new Cat();
        animal1.eat();

        //DownCasting
        ((Cat)animal1).nightEyeShine();
    }
}
