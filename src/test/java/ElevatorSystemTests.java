import org.example.Customer;
import org.example.ElevatorSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class ElevatorSystemTests {
    @Test
    void testCustomers(){
        ElevatorSystem elevatorSystem = new ElevatorSystem(4);
        elevatorSystem.pickup(2, -1);
        elevatorSystem.pickup(5, 1);
        Assertions.assertEquals(2, elevatorSystem.getCustomers().get(0).getSrcFloor());
        Assertions.assertEquals(-1, elevatorSystem.getCustomers().get(0).getDirection());
        Assertions.assertEquals(5, elevatorSystem.getCustomers().get(1).getSrcFloor());
        Assertions.assertEquals(1, elevatorSystem.getCustomers().get(1).getDirection());
    }

    @Test
    void testSystem1() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(3);
        elevatorSystem.pickup(3, 1);
        elevatorSystem.pickup(0, 1);
        elevatorSystem.pickup(8, -1);
        elevatorSystem.getCustomers().get(0).setDstFloor(5);
        elevatorSystem.getCustomers().get(1).setDstFloor(3);
        elevatorSystem.getCustomers().get(2).setDstFloor(1);
        for (int i = 0; i < 4; i++) {
            elevatorSystem.step();
        }
        Assertions.assertEquals(4, elevatorSystem.status().get(0).get(1));
        Assertions.assertEquals(1, elevatorSystem.status().get(1).get(3));

        for (int i = 0; i < 12; i++) {
            elevatorSystem.step();
        }
        Assertions.assertEquals(1, elevatorSystem.status().get(0).get(3));
        Assertions.assertEquals(1, elevatorSystem.status().get(1).get(3));
        Assertions.assertEquals(1, elevatorSystem.status().get(2).get(3));

        Assertions.assertEquals(5, elevatorSystem.status().get(0).get(1));
        Assertions.assertEquals(3, elevatorSystem.status().get(1).get(1));
        Assertions.assertEquals(1, elevatorSystem.status().get(2).get(1));
    }
//    @Test
//    void testSystemOneElevator() {
//        ElevatorSystem elevatorSystem = new ElevatorSystem(1);
//        elevatorSystem.pickup(3, 1);
//        elevatorSystem.pickup(0, 1);
//        elevatorSystem.pickup(8, -1);
//        elevatorSystem.getCustomers().get(0).setDstFloor(9);
//        elevatorSystem.getCustomers().get(1).setDstFloor(6);
//        elevatorSystem.getCustomers().get(2).setDstFloor(5);
//        for (int i = 0; i < 4; i++) {
//            elevatorSystem.step();
//        }
//        Assertions.assertEquals(4, elevatorSystem.status().get(0).get(1));
//        Assertions.assertEquals(6, elevatorSystem.status().get(0).get(2));
//
//        for (int i = 0; i < 12; i++) {
//            elevatorSystem.step();
//        }
//        Assertions.assertEquals(1, elevatorSystem.status().get(0).get(3));
//        Assertions.assertEquals(5, elevatorSystem.status().get(0).get(1));
//    }

}
