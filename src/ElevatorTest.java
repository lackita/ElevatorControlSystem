import static org.junit.Assert.*;

import org.junit.Test;


public class ElevatorTest {

    @Test
    public void goingUp() {
	Elevator e = new Elevator(10, Direction.UP);
	e.request(15);
	e.step();
	assertEquals(11, e.getFloor());
    }

    @Test
    public void goingDown() {
	Elevator e = new Elevator(10, Direction.DOWN);
	e.request(5);
	e.step();
	assertEquals(9, e.getFloor());
    }
    
    @Test
    public void idleAfterFinalGoalReached() {
	Elevator e = new Elevator(10, Direction.UP);
	e.request(11);
	e.step();
	e.step();
	assertEquals(11, e.getFloor());
    }
    
    @Test
    public void changeDirectionToAccommodateNewGoalUpstairs() {
	Elevator e = new Elevator(10, Direction.DOWN);
	e.request(15);
	e.step();
	assertEquals(11, e.getFloor());
    }
    
    @Test
    public void changeDirectionToAccommodateNewGoalDownstairs() {
	Elevator e = new Elevator(10, Direction.UP);
	e.request(5);
	e.step();
	assertEquals(9, e.getFloor());
    }

    @Test
    public void changeDirectionsDownWhenGoalsRemain() {
	Elevator e = new Elevator(10, Direction.UP);
	e.request(5);
	e.request(11);
	e.step();
	e.step();
	e.step();
	assertEquals(9, e.getFloor());
    }

    @Test
    public void changeDirectionsUpWhenGoalsRemain() {
	Elevator e = new Elevator(10, Direction.DOWN);
	e.request(15);
	e.request(9);
	e.step();
	e.step();
	e.step();
	assertEquals(11, e.getFloor());
    }
    // TODO: same floor ignored
}
