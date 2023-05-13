package org.example;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(16);
        System.out.println(elevatorSystem.status());
        elevatorSystem.update(1, 1, 0);
        System.out.println(elevatorSystem.status());
    }
}