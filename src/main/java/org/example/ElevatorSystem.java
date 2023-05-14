package org.example;

import java.util.*;

public class ElevatorSystem {
    private ArrayList<Elevator> elevators = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private LinkedList<Customer> waitingCustomers = new LinkedList<>();

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
            this.waitingCustomers.add(customer);
        }
    }

    public void assignCustomers(Elevator elevator){
        int elevatorDirection = elevator.getDstFloor() - elevator.getCurrentFloor() > 0 ? 1 : -1;
        elevatorDirection = (elevator.getDstFloor() - elevator.getCurrentFloor() == 0 ? 0 : elevatorDirection);
        ArrayList<Integer> idx = new ArrayList<>();
        for (Customer customer : this.waitingCustomers){
            if (elevator.getCurrentFloor() == customer.getSrcFloor() && (customer.getDirection() == elevatorDirection || elevatorDirection == 0)){
                elevator.addCustomer(customer);
                elevator.popDstFloor();
                this.pickupCustomer(elevator, customer);
                idx.add(this.waitingCustomers.indexOf(customer));
            }
        }
        int j = 0;
        for (int i : idx){
            this.waitingCustomers.remove(i - j);
            j++;
        }
    }


    public void step() {
        System.out.println("Step:");
        for (Elevator elevator : this.elevators ) {
            if (!elevator.isFree) {
                this.printMsg("Winda %d jest na piętrze %d", elevator.getElevatorId(), elevator.getCurrentFloor());
                Customer customer = elevator.getCustomer();
                if (elevator.getCurrentFloor() == elevator.getDstFloor()) {
                    elevator.popDstFloor();
                    if (elevator.getCurrentFloor() == customer.getSrcFloor()) {
                        this.pickupCustomer(elevator, customer);
                    }
                    else if (elevator.getCurrentFloor() == customer.getDstFloor()){
                        elevator.rmvCustomer();
                        if (!elevator.checkCustomers()){
                            if (!this.waitingCustomers.isEmpty()){
                                elevator.addCustomer(this.waitingCustomers.pop());
                            }
                            else{
                                elevator.isFree = true;
                            }
                        }
                        this.printMsg("Winda %d zawiozła klienta %d do celu", elevator.getElevatorId(), customer.getCustomerId());
                    }
                }
                this.assignCustomers(elevator);
                int nextFloor = elevator.getCurrentFloor() + (elevator.getDstFloor() - elevator.getCurrentFloor() > 0 ? 1 : -1);
                nextFloor = (elevator.isFree ? 0 : nextFloor);
                elevator.setCurrentFloor(nextFloor);

            }
        }
    }

    private void pickupCustomer(Elevator elevator, Customer customer) {
        this.printMsg("Winda %d dotarła do klienta %d", elevator.getElevatorId(), customer.getCustomerId());
        elevator.addDstFloor(this.getFloor(customer));
    }

    private int getFloor(Customer customer){
        if (customer.getDstFloor() == -1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj piętro");
            int floor = Integer.parseInt(scan.nextLine());
            customer.setDstFloor(floor);
            return floor;
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
