package classes;

import interfaces.ITelephone;

public class DeskPhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int phoneNumber) {
        this.myNumber = phoneNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phones does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + "on deskphone");
    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Anwsering the desk phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber){
            System.out.println("Riing, Ring");
            return isRinging = true;
        }
        return isRinging = false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
