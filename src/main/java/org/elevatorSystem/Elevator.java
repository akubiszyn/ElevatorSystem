package org.elevatorSystem;
import java.util.ArrayList;
import java.util.Collections;


public class Elevator {
    private int elevatorId;
    private int currentFloor;
    private ArrayList<Integer> dstFloor = new ArrayList<>();
    public boolean isFree;

    private ArrayList<Customer> elCustomers = new ArrayList<>();

    public Elevator(int elevatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
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
        if(this.dstFloor.isEmpty()){
            return -1;
        }
        return this.dstFloor.get(0);
    }

    public void addDstFloor(int dstFloor) {
        this.dstFloor.add(dstFloor);
        int elevatorDirection = this.getDstFloor() - this.getCurrentFloor() >= 0 ? 1 : -1;
        Collections.sort(this.dstFloor);
        if (elevatorDirection == -1){
            Collections.reverse(this.dstFloor);
        }
    }

    public Customer getCustomer() {
        Collections.sort(this.elCustomers, new CustomerComparator());
        return this.elCustomers.get(0);
    }

    public void rmvCustomer(){
        elCustomers.remove(0);
    }
    public boolean checkCustomers(){
        if (elCustomers.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public void addCustomer(Customer customer){
        this.elCustomers.add(customer);
        this.addDstFloor(customer.getSrcFloor());
    }

    public void popDstFloor() {
        this.dstFloor.remove(0);
    }
}
