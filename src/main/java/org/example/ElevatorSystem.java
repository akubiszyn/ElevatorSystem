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


    public void pickup(int srcFloor, int direction) {
        Customer customer = new Customer(this.customers.size() + 1, srcFloor, direction);
        customers.add(customer);
        int idx = 0;
        for (Elevator elevator : this.elevators){
            if (elevator.isFree){
                idx = elevator.getElevatorId();
                elevator.isFree = false;
                elevator.addCustomer(customer);
                break;
            }
        }
        if (idx == 0){
            System.out.println("brak dostępnej windy");
        }
        else{
            this.update(idx, null, srcFloor);
        }

    }

    public void findBestElevator(int srcFloor, int direction){
        Elevator bestElevator;
        for (Elevator elevator : this.elevators){
            int elevatorDirection = elevator.getDstFloor() - elevator.getCurrentFloor() >= 0 ? 1 : -1;
            if ((elevator.getCurrentFloor() - srcFloor) * elevatorDirection == -1 && direction == elevatorDirection){

            }
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
        System.out.println("Step:");
        for (Elevator elevator : this.elevators ) {
            if (!elevator.isFree) {
                this.printMsg("Winda %d jest na piętrze %d", elevator.getElevatorId(), elevator.getCurrentFloor());
                Customer customer = elevator.getCustomer();
                if (elevator.getCurrentFloor() == elevator.getDstFloor()) {
                    if (elevator.getDstFloor() == customer.getSrcFloor()) {
                        this.printMsg("Winda %d dotarła do klienta %d", elevator.getElevatorId(), customer.getCustomerId());
                        this.update(elevator.getElevatorId(), null, this.getFloor(customer));
                    }
                    else {
                        elevator.isFree = true;
                        this.printMsg("Winda %d zawiozła klienta %d do celu", elevator.getElevatorId(), customer.getCustomerId());
                        continue;
                    }
                }
                int nextFloor = elevator.getCurrentFloor() + (elevator.getDstFloor() - elevator.getCurrentFloor() >= 0 ? 1 : -1);
                this.update(elevator.getElevatorId(), nextFloor, null);

            }
        }
    }
    private int getFloor(Customer customer){
        if (customer.getDstFloor() == -1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj piętro");
            int floor = Integer.parseInt(scan.nextLine());
            customer.setDstFloor(floor);
            return Integer.parseInt(scan.nextLine());
        }
        else{
            return customer.getDstFloor();
        }
    }
    private void printMsg(String string, int elevator, int customer){
        String msg = String.format(string, elevator, customer);
        System.out.println(msg);
    }

    public ArrayList<ArrayList<Integer>> status() {
        ArrayList<ArrayList<Integer>> elevatorStatuses = new ArrayList<ArrayList<Integer>>();
        for ( Elevator elevator : this.elevators ) {
               ArrayList<Integer> elevatorStatus = new ArrayList<Integer>();
               elevatorStatus.add(elevator.getElevatorId());
               elevatorStatus.add((elevator.getCurrentFloor()));
               elevatorStatus.add(elevator.getDstFloor());
               elevatorStatus.add(elevator.isFree ? 1 : -1);
               elevatorStatuses.add(elevatorStatus);
        }
        return elevatorStatuses;
    }
}
