package org.example;

import java.util.ArrayList;

public class ElevatorSystem {
    private ArrayList<Elevator> elevators = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> customers = new ArrayList<ArrayList<Integer>>();

    public ElevatorSystem(int nElevators) {
        for (int i = 0; i < nElevators; i++) {
            elevators.add(new Elevator(i + 1));
        }
    }


    void pickup(int src_floor, int direction) {
        ArrayList<Integer> pickups = new ArrayList<Integer>();
        pickups.add(src_floor);
        pickups.add(direction);
        customers.add(pickups);
        int idx = 0;
        for (int i = 0; i < this.elevators.size(); i++){
            if (this.elevators.get(i).isFree = true){
                idx = i;
                break;
            }
        }

    }

    void update(int elevator_id, int current_floor, int dst_floor) {
        Elevator elevator = this.elevators.get(elevator_id - 1);
        elevator.setCurrentFloor(current_floor);
        elevator.setDstFloor(dst_floor);
    }

    void step() {
    }

    ArrayList<ArrayList<Integer>> status() {
        ArrayList<ArrayList<Integer>> elevatorStatuses = new ArrayList<ArrayList<Integer>>();
        for ( Elevator elevator : this.elevators ) {
               ArrayList<Integer> elevatorStatus = new ArrayList<Integer>();
               elevatorStatus.add(elevator.getElevator_id());
               elevatorStatus.add((elevator.getCurrentFloor()));
               elevatorStatus.add(elevator.getDstFloor());
               elevatorStatuses.add(elevatorStatus);
        }
        return elevatorStatuses;
    }
}
