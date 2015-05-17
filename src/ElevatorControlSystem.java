
public class ElevatorControlSystem {
    Elevator[] elevators;
    public ElevatorControlSystem(int n) {
	elevators = new Elevator[n];
	for (int i = 0;i < n;++i) elevators[i] = new Elevator(0, Direction.UP);
    }

    public Elevator[] status() {
	return elevators;
    }

    public void pickup(int floor, Direction direction) {
	
    }

    public void step() {
	
    }

}
