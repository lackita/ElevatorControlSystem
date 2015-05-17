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
    public void changeDirectionToAccomodateNewGoalUpstairs() {
	Elevator e = new Elevator(10, Direction.DOWN);
	e.request(15);
	e.step();
	assertEquals(11, e.getFloor());
    }
}
