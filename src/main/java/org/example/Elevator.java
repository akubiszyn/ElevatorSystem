package org.example;

public class Elevator {
    private int elevator_id;
    private int currentFloor;
    private int srcFloor;
    private int dstFloor;
    public boolean isFree;

    public Elevator(int elevatorId) {
        this.elevator_id = elevatorId;
        this.currentFloor = 0;
        this.srcFloor = -1;
        this.dstFloor = -1;
        this.isFree = true;
    }

    public int getElevator_id() {
        return elevator_id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }

    public int getDstFloor() {
        return dstFloor;
    }

    public void setDstFloor(int dstFloor) {
        this.dstFloor = dstFloor;
    }
}
