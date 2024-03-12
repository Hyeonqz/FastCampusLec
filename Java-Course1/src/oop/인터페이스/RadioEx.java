package oop.인터페이스;

public class RadioEx implements InterfaceRemoteControl {
    private int CURRENT_CHANNEL = 10;
    @Override
    public void channelUp() {
        CURRENT_CHANNEL++;
        if(CURRENT_CHANNEL>InterfaceRemoteControl.MAX_CHANNEL) {
            CURRENT_CHANNEL = 1;
        }
        System.out.println("채널 업");
    }

    @Override
    public void channelDown() {
        System.out.println("채널 다운");
    }

    @Override
    public void volumeUp() {
        System.out.println("사운드 업");
    }

    @Override
    public void volumeDown() {
        System.out.println("사운드 다운");
    }
}
