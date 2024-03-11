package oop.인터페이스;

public class Tv extends RemoteControl{
    @Override
    public void channelUp() {
        System.out.println("TV 채널 업");
    }

    @Override
    public void channelDown() {
        System.out.println("TV 채널 다운");
    }

    @Override
    public void volumeUp() {
        System.out.println("TV 볼류 업");

    }

    @Override
    public void volumeDown() {
        System.out.println("TV 볼륨 다운");

    }
}
