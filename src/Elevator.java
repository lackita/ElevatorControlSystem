import java.util.HashSet;
import java.util.Set;


public class Elevator {

    private int floor;
    private Direction direction;
    private Set<Integer> goals;

    public Elevator(int f, Direction d) {
	floor = f;
	direction = d;
	goals = new HashSet<Integer>();
    }

    public void request(int floor) {
	goals.add(floor);
	if (this.floor < floor) direction = Direction.UP; 
    }

    public void step() {
	if (direction == Direction.UP) ++floor;
	else if (direction == Direction.DOWN) --floor;
	if (goals.contains(floor)) goals.remove(floor);
	if (goals.isEmpty()) direction = Direction.IDLE;
    }

    public int getFloor() {
	return floor;
    }

}
