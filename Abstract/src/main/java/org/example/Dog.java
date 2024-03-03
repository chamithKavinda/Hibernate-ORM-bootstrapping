package org.example;

public class Dog extends Animal{
    @Override
    public void run(){
        System.out.println("this is run() of dog");
    }
    @Override
    public void run(int speed){
        System.out.println("this is run(speed) of dog");
    }

}
