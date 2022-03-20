package classes;

import interfaces.ITelephone;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int phoneNumber) {
        this.myNumber = phoneNumber;
        this.isOn = false;
    }

    @Override
    public void powerOn() {
        System.out.println("Mobile phone powered up");
        this.isOn = true;
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + "on mobile");
    }

    @Override
    public void answer() {
        if(isOn && isRinging){
            System.out.println("Hello, this is a mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(isOn && phoneNumber == myNumber){
            System.out.println("Mobile vibrating and ringing");
            return isRinging = isOn;
        }
        System.out.println("Wrong number or phone not available");
        return isRinging = false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

}
