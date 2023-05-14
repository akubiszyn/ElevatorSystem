package org.example;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(2);
        elevatorSystem.pickup(3, 1);
        elevatorSystem.pickup(0, 1);
        elevatorSystem.pickup(8, -1);
        elevatorSystem.pickup(8, -1);
        elevatorSystem.pickup(7, -1);
        elevatorSystem.pickup(1, 1);

        for (int i = 0; i < 30; i++){
            elevatorSystem.step();
        }
    }
}