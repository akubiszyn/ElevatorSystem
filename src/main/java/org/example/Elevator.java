package org.example;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Elevator {
    private int elevatorId;
    private int currentFloor;
    private int dstFloor;
    public boolean isFree;

    PriorityQueue<Customer> elCustomers = new PriorityQueue<>(new MyComparator());

    public Elevator(int elevatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.dstFloor = -1;
        this.isFree = true;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDstFloor() {
        return dstFloor;
    }

    public void setDstFloor(int dstFloor) {
        this.dstFloor = dstFloor;
    }

    public Customer getCustomer() {
        return elCustomers.peek();
    }

    public void addCustomer(Customer customer){
        this.elCustomers.add(customer);
    }
}
