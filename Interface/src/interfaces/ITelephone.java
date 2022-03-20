package interfaces;

public interface ITelephone {

    //methods to be implemented
    void powerOn();
    void dial(int phoneNumber);
    public void answer();
    public boolean callPhone(int phoneNumber);
    public boolean isRinging();

}
