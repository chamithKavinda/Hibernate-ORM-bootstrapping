package org.example;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.getSpeed();

        System.out.println("             ");

        Dog dog = new Dog();
        dog.getSpeed();

        animal.run();
        animal.run(4);

        System.out.println("             ");

        dog.run();
        dog.run(10);
    }
}
