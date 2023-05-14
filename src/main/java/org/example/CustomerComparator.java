package org.example;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int o1Floor = o1.getDstFloor();
        int o2Floor = o2.getDstFloor();
        if (o1Floor == -1){
            o1Floor = o1.getSrcFloor();
        } else if (o2Floor == -1) {
            o2Floor = o2.getSrcFloor();
        }
        if (o1.getDirection() == 1){
            int value = (o1Floor - o2Floor >= 0 ? 1 : -1);
            return value;
        } else{
            int value = (o1Floor - o2Floor >= 0 ? -1 : 1);
            return value;
        }
    }
}
