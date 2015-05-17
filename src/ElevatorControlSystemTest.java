import static org.junit.Assert.*;

import org.junit.Test;


public class ElevatorControlSystemTest {

    @Test
    public void allElevatorsStartAtGroundFloor() {
	ElevatorControlSystem ecs = new ElevatorControlSystem(16);
	Elevator[] elevators = ecs.status();
	assertEquals(16, elevators.length);
	for (Elevator e : elevators) {
	    assertEquals(0, e.getFloor());
	}
    }

    @Test
    public void sameFloorPickupRequest() {
	ElevatorControlSystem ecs = new ElevatorControlSystem(16);
	ecs.pickup(0, Direction.UP);
	ecs.step();
	for (Elevator e : ecs.status()) {
	    assertEquals(0, e.getFloor());
	}
    }
}
