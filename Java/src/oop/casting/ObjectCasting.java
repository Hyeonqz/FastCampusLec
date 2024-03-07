package oop.casting;

import oop.상속.Animal;
import oop.상속.Cat;
import oop.상속.Dog;

public class ObjectCasting {
    public static void main(String[] args) {
        // Q. Animal -> Dog, Cat
        Animal animal = new Dog();
        animal.eat();

        // 자식이 부모로 바뀌는거 -> UpCasting
        Animal animal1 = new Cat();
        animal1.eat();

        // 부모가 자식으로 바뀌는거 -> DownCasting
        Cat c = (Cat)animal1;
        c.nightEyeShine();


    }
}
