import java.util.TreeSet;


public class Elevator {

    private int floor;
    private Direction direction;
    private TreeSet<Integer> goals;

    public Elevator(int f, Direction d) {
	floor = f;
	direction = d;
	goals = new TreeSet<Integer>();
    }

    public void request(int floor) {
	goals.add(floor);
    }

    public void step() {
	if (goals.isEmpty()) direction = Direction.IDLE;
	else if (direction == Direction.UP && goals.last() < floor) direction = Direction.DOWN;
	else if (direction == Direction.DOWN && goals.first() > floor) direction = Direction.UP;

	if (direction == Direction.UP) ++floor;
	else if (direction == Direction.DOWN) --floor;

	if (goals.contains(floor)) goals.remove(floor);
    }

    public int getFloor() {
	return floor;
    }

    public Direction getDirection() {
	return direction;
    }

}
