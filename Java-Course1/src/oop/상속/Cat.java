package oop.상속;

public class Cat extends Animal
{
    public void nightEyeShine() {
        System.out.println("밤에 눈에서 빛이 난다");
    }

    @Override
    public void eat() {
        System.out.println("고양이 처럼 먹는다");
    }
}
