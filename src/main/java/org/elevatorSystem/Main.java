package org.elevatorSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.println("This is elevator system. How many elevators are in the building?");
        Scanner in = new Scanner(System.in);
        String nElevators = in.nextLine();
        ElevatorSystem elevatorSystem = new ElevatorSystem(Integer.parseInt(nElevators));
        while(true) {
            System.out.println("--------------------------");
            System.out.println("Choose a number: \nNew customer: 1 \nMake a step: 2 \nShow status of elevators: 3 \n");
            String request = in.nextLine();
            System.out.println("You chose " + request);
            switch (request) {
                case "1":
                    System.out.println("What is your source floor?");
                    String srcFloor = in.nextLine();
                    System.out.println("In which direction? Up: 1, Down: -1");
                    String direction = in.nextLine();
                    elevatorSystem.pickup(Integer.parseInt(srcFloor), Integer.parseInt(direction));
                    break;
                case "2":
                    System.out.println("How many steps?");
                    String nSteps = in.nextLine();
                    for (int i = 0; i < Integer.parseInt(nSteps); i++) {
                        elevatorSystem.step();
                    }
                    break;
                case "3":
                    System.out.println(elevatorSystem.status());
                    break;

            }
        }
    }
}