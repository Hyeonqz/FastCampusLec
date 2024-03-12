package oop.인터페이스;

public class Radio extends RemoteControl{


    @Override
    public void channelUp() {
        System.out.println("라디오 채널 하나 올림");
    }

    @Override
    public void channelDown() {
        System.out.println("라디오 채널 하나 내림");
    }

    @Override
    public void volumeUp() {
        System.out.println("라디오 볼륨 업");
    }

    @Override
    public void volumeDown() {
        System.out.println("라디오 볼륨 다운");
    }
}
