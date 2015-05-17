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
	direction = preferredDirection();

	if (direction == Direction.UP) ++floor;
	else if (direction == Direction.DOWN) --floor;
    }

    private Direction preferredDirection() {
	if (goals.contains(floor)) goals.remove(floor);
	if (goals.isEmpty()) return Direction.IDLE;
	return directionToward(closestEndpoint());
    }
    
    private Direction directionToward(int destination) {
	if (destination < floor) return Direction.DOWN;
	else return Direction.UP;
	
    }

    private int closestEndpoint() {
	if (Math.abs(floor - goals.last()) > Math.abs(floor - goals.first())) return goals.first();
	return goals.last();
    }

    public int getFloor() {
	return floor;
    }

    public TreeSet<Integer> getGoals() {
	return goals;
    }

    public Direction getDirection() {
	return direction;
    }

    boolean isConvenient(int destination, Direction bearing) {
        return preferredDirection() == Direction.IDLE 
        	|| (
        		preferredDirection() == directionToward(destination) 
        		&& preferredDirection() == bearing
        	);
    }
}
