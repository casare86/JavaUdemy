import classes.DeskPhone;
import classes.MobilePhone;
import interfaces.ITelephone;

public class Main {

    public static void main(String[] args) {
        //DekPhone ksaPhone; it also valid
        ITelephone kasPhone;
        kasPhone = new DeskPhone(123456);
        kasPhone.powerOn();
        kasPhone.callPhone(123456);
        kasPhone.answer();
        kasPhone.callPhone(123);

        System.out.println("\n new trial \n");

        ITelephone kasMobile;
        kasMobile = new MobilePhone(1234);
        kasMobile.callPhone(1234);
        kasMobile.powerOn();
        kasMobile.callPhone(1234);
        kasMobile.isRinging();
        kasMobile.answer();

    }
}
