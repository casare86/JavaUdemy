package Inner;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private int gearTotal;
    private boolean cluthIsIn;

    //constructor
    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
        for(int i = 0; i < maxGears; i++){
            addGear(i, 5.3 * i);
        }
    }

    public void operateClutch(boolean in){
        this.cluthIsIn = in;
    }

    public void addGear(int number, double ratio){
        if((number > 0) && (number <= maxGears)){
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear){
        if((newGear >= 0) && (newGear < this.gears.size()) && this.cluthIsIn){
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        }
        else
        {
            System.out.println( "Grind!");
            this.currentGear = 0;
        }
    }
    public double wheelSpeed (int revs){
        if(cluthIsIn){
            System.out.println("Scream!!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    //restric the access to the inner class Gear
    private class Gear {
        //shadow declaration -> inner/Outer class have the same atribute name
        //ex: Gearbox.this.gearNumber
        private int gearTotal = Gearbox.this.gearTotal;
        private int gearNumber;
        private double ratio;


        public Gear (int gearNumber, double ratio){//constructor
            //using this here means its the inner class not the Outer even they have the same name
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public int getGearNumber() {
            return gearNumber;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }
    }
}
