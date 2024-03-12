package oop.인터페이스;

public class InterfaceTest {
    public static void main(String[] args) {
        var radio = new Radio();
        radio.internet();
        radio.channelUp();
        radio.channelDown();
        radio.channelUp();
        radio.volumeDown();

        System.out.println();
        var tv = new Tv();
        tv.internet();
        tv.channelUp();
        tv.channelDown();
        tv.volumeUp();
        tv.volumeDown();
    }
}
