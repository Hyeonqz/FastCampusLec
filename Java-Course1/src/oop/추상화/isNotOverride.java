package oop.추상화;

public class isNotOverride {
    public static void main(String[] args) {
        AnimalEx animalEx = new Turtle();
        animalEx.eat();


        AnimalEx animalEx1 = new Dolphin();
        animalEx1.eat();
    }
}
