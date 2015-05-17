import java.util.ArrayList;


public class ElevatorControlSystem {
    Elevator[] elevators;
    public ElevatorControlSystem(int n) {
	elevators = new Elevator[n];
	for (int i = 0;i < n;++i) elevators[i] = new Elevator(0, Direction.IDLE);
    }

    public Elevator[] status() {
	return elevators;
    }

    public void pickup(int floor, Direction direction) {
	Elevator closest = nearestElevator(convenientElevators(floor, direction), floor);
	if (closest == null) closest = nearestElevator(elevators, floor);
	closest.request(floor);
    }

    private Elevator nearestElevator(Elevator[] elevators, int floor) {
	int best_distance = Integer.MAX_VALUE;
	Elevator closest = null;
	for (Elevator e : elevators) {
	    int distance = Math.abs(floor - e.getFloor());
	    if (best_distance > distance) {
		best_distance = distance;
		closest = e;
	    }
	}
	return closest;
    }
    
    private Elevator[] convenientElevators(int floor, Direction direction) {
	ArrayList<Elevator> convenient = new ArrayList<Elevator>();
	for (Elevator e : elevators)
	    if (e.isConvenient(floor, direction)) convenient.add(e);
	return convenient.toArray(new Elevator[convenient.size()]);
    }

    public void step() {
	for (Elevator e : elevators)
	    e.step();
    }

    public void update(int elevator, int floor) {
	elevators[elevator].request(floor);
    }
}
