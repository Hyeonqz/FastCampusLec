package oop.추상화;

public abstract class AnimalEx extends Object{

    public abstract void eat();

    // Body가 있는 구현 메소드
    public void move() {
        System.out.println("무리를 지어서 이동한다");
    }

}
