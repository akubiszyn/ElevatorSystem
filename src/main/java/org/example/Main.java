package org.example;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(3);
        elevatorSystem.pickup(3, 1);
        elevatorSystem.pickup(0, 1);
        elevatorSystem.pickup(8, -1);

        for (int i = 0; i < 16; i++){
            elevatorSystem.step();
        }
    }
}