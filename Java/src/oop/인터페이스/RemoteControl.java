package oop.인터페이스;

public abstract class RemoteControl {
    public abstract void channelUp();
    public abstract void channelDown();
    public abstract void volumeUp();
    public abstract void volumeDown();

    // 이미 구현 클래스기 때문에 재정의 필요 없음
    public void internet() {
        System.out.println("인터넷이 구동된다");
    }

}
