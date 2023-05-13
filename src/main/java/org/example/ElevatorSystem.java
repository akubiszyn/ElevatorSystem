package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorSystem {
    private ArrayList<Elevator> elevators = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ElevatorSystem(int nElevators) {
        for (int i = 0; i < nElevators; i++) {
            elevators.add(new Elevator(i + 1));
        }
    }


    public void pickup(int src_floor, int direction) {
        Customer customer = new Customer(this.customers.size(), src_floor, direction);
        customers.add(customer);
        int idx = 0;
        for (Elevator elevator : this.elevators){
            if (elevator.isFree = true){
                idx = elevator.getElevatorId();
                elevator.isFree = false;
                elevator.setCustomer(customer.getCustomerId());
                break;
            }
        }
        if (idx == 0){
            System.out.println("brak dostępnej windy");
        }
        else{
            this.update(idx, null, src_floor);
            this.elevators.get(idx).setCustomer(customer.getCustomerId());
        }

    }

    public void update(int elevator_id, Integer current_floor, Integer dst_floor) {
        Elevator elevator = this.elevators.get(elevator_id - 1);
        if (current_floor != null){
            elevator.setCurrentFloor(current_floor);
        }
        if (dst_floor != null){
            elevator.setDstFloor(dst_floor);
        }
    }

    public void step() {
        for (Elevator elevator : this.elevators ) {
            if (elevator.isFree == false) {
                Customer customer = this.customers.get(elevator.getCustomer());
                int nextFloor = elevator.getCurrentFloor() + customer.getDirection();
                elevator.setCurrentFloor(nextFloor);
                String elevatorMsg = String.format("Winda %d jest na piętrze %d", elevator.getElevatorId(), nextFloor);
                System.out.println(elevatorMsg);
                if (elevator.getCurrentFloor() == elevator.getDstFloor()) {
                    if (elevator.getDstFloor() == customer.getSrcFloor()) {
                        String msg = String.format("Winda %d dotarła do klienta %d", elevator.getElevatorId(), customer.getCustomerId());
                        System.out.println(msg);
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Podaj piętro");
                        elevator.setDstFloor(Integer.parseInt(scan.nextLine()));
                    } else {
                        elevator.isFree = true;
                        String msg = String.format("Winda %d zawiozła klienta %d do celu", elevator.getElevatorId(), customer.getCustomerId());
                        System.out.println(msg);
                    }
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> status() {
        ArrayList<ArrayList<Integer>> elevatorStatuses = new ArrayList<ArrayList<Integer>>();
        for ( Elevator elevator : this.elevators ) {
               ArrayList<Integer> elevatorStatus = new ArrayList<Integer>();
               elevatorStatus.add(elevator.getElevatorId());
               elevatorStatus.add((elevator.getCurrentFloor()));
               elevatorStatus.add(elevator.getDstFloor());
               elevatorStatuses.add(elevatorStatus);
        }
        return elevatorStatuses;
    }
}
