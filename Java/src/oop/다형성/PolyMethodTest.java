package oop.다형성;

import oop.상속.Animal;
import oop.상속.Cat;
import oop.상속.Dog;

public class PolyMethodTest {
    public static void main(String[] args) {
        Dog d = new Dog();

        Cat c = new Cat();

        Animal[] animals = new Animal[2];
        animals[0] = d;
        animals[1] = c;
        display(animals);
    }

    private static void display(Animal[] animal) {
        for (int i = 0; i <animal.length ; i++) {
            animal[i].eat();
            if( animal[i] instanceof Cat) {
                ((Cat) animal[i]).nightEyeShine();
            }
        }
    }

}

