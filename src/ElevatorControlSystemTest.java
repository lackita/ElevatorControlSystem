import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ElevatorControlSystemTest {
    ElevatorControlSystem ecs;
    @Before
    public void createControl() {
	ecs = new ElevatorControlSystem(16);	
    }

    @Test
    public void allElevatorsStartAtGroundFloor() {
	Elevator[] elevators = ecs.status();
	assertEquals(16, elevators.length);
	assertElevatorsAtFloor(16, 0);
    }

    @Test
    public void sameFloorPickupRequest() {
	ecs.pickup(0, Direction.UP);
	ecs.step();
	assertElevatorsAtFloor(16, 0);
    }

    @Test
    public void differentFloorPickupRequest() {
	ecs.pickup(10, Direction.DOWN);
	ecs.step();
	assertElevatorsAtFloor(15, 0);
    }
    
    @Test
    public void multipleElevatorsEngaged() {
	ecs.pickup(10, Direction.DOWN);
	for (int i = 0;i < 10;++i) ecs.step();
	ecs.pickup(1, Direction.DOWN);
	ecs.step();
	assertElevatorsAtFloor(1, 1);
    }
    
    @Test
    public void directionRetained() {
	ecs.pickup(10, Direction.DOWN);
	for (int i = 0;i < 5;++i) ecs.step();
	ecs.pickup(4, Direction.DOWN);
	ecs.step();
	assertElevatorsAtFloor(1, 1);
    }
    
    @Test
    public void onTheWay() {
	ecs.pickup(10, Direction.DOWN);
	ecs.step();
	ecs.pickup(5, Direction.UP);
	ecs.step();
	assertElevatorsAtFloor(15, 0);
    }

    @Test
    public void everythingInconvenient() {
	ecs = new ElevatorControlSystem(2);
	ecs.pickup(10, Direction.DOWN);
	ecs.step();
	ecs.step();
	ecs.step();
	ecs.step();
	ecs.pickup(3, Direction.DOWN);
	ecs.step();
	ecs.step();
	ecs.pickup(1, Direction.UP);
	ecs.step();
	assertElevatorsAtFloor(1, 3);
	ecs.step();
	assertElevatorsAtFloor(1, 2);	
    }

    @Test
    public void wrongDirectionInconvenient() {
	ecs = new ElevatorControlSystem(2);
	ecs.pickup(10, Direction.DOWN);
	ecs.step();
	ecs.pickup(1, Direction.DOWN);
	ecs.step();
	assertElevatorsAtFloor(1, 1);
    }

    private void assertElevatorsAtFloor(int n, int floor) {
	for (Elevator e : ecs.status()) {
	    if (e.getFloor() == floor) --n;
	}
	assertEquals(0, n);
    }
}
