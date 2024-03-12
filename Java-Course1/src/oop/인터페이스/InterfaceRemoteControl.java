package oop.인터페이스;

public interface InterfaceRemoteControl {
    //interface 안에 abstract가 들어가있다 -> 묵시적으로 생략한다.
    // 인터페이스를 활용하면 다형성을 100% 보장한다.
    // 인터페이스는 객체 생성 불가
    // 부모의 역할을 한다
    // 객체 생성시 업캐스팅 역할을 할 수 있음
    static final int MAX_CHANNEL = 100;
    static final int MIN_CHANNEL = 1;

    void channelUp();
    void channelDown();
    void volumeUp();
    void volumeDown();
}
