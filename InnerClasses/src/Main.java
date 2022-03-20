import Inner.Button;
import Inner.Gearbox;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        class ClickListener implements Button.OnCLickListener{

            public ClickListener(){
                System.out.println("I´ve been attached");
            }

            @Override
            public void onCLick(String title) {
                System.out.println(title + " was clicked");
            }
        }
//        Gearbox mcLaren = new Gearbox(6);
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);
//        //worng ways to create new gears (inner class)
//        //Gearbox.Gear second = new Gearbox.Gear(2, 15.4);
//        //Gearbox.Gear third = new mcLaren.Gear(3, 17.8);
//        System.out.println(first.driveSpeed(1000));
        Gearbox mcLaren = new Gearbox(6);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));

        //using a class or anonymous class
        //btnPrint.setOnClickListener(new ClickListener());
        btnPrint.setOnClickListener(new Button.OnCLickListener() {
            @Override
            public void onCLick(String title) {
                System.out.println(title + " was clicked - anonymous class");
            }
        });
        listen();
    }

    private static void listen(){
        boolean quit = false;
        System.out.println("1 for click 0 for quit:");
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
            }
        }
    }
}
