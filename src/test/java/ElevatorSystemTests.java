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
}
