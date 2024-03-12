package oop.추상화;

import oop.상속.Cat;
import oop.상속.Dog;

public class AbstractTest {
    public static void main(String[] args) {

        // 추상 ㅡㄹ래스는 단독으로 객체를 생성할 수 없다.
        //AnimalEx animalEx = new AnimalEx();

        var animalEx = new Dog();
        animalEx.eat();

        var animalCat = new Cat();
        animalCat.nightEyeShine();
        animalCat.eat();

    }
}
