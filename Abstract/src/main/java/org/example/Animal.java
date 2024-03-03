package org.example;

public class Animal {
    private double speed;
    private String colour;
    private int noOfLegs;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public void run(){
        System.out.println("this is run() of animal");
    }

    public void run(int speed){
        System.out.println("this is run(speed) of animal");
    }
}
