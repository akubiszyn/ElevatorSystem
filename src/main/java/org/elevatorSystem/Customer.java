package org.elevatorSystem;

public class Customer {
    private int customerId;
    private int srcFloor;
    private int direction;
    private int dstFloor = -1;

    public Customer(int customerId, int srcFloor, int direction) {
        this.customerId = customerId;
        this.srcFloor = srcFloor;
        this.direction = direction;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDstFloor() {
        return dstFloor;
    }

    public void setDstFloor(int dstFloor) {
        this.dstFloor = dstFloor;
    }

}
