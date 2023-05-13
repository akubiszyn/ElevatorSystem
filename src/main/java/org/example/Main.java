package org.example;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(16);
        elevatorSystem.pickup(3, 1);
        while(true){
            elevatorSystem.step();
        }
    }
}