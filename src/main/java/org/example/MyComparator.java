package org.example;

import java.util.Comparator;

public class MyComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getDirection() == 1){
            int value = (o1.getDstFloor() - o1.getDstFloor() >= 0 ? -1 : 1);
            return value;
        } else{
            int value = (o1.getDstFloor() - o1.getDstFloor() >= 0 ? 1 : -1);
            return value;
        }
    }
}
