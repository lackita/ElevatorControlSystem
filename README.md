# API
State of elevators:
``` java
ElevatorControlSystem ecs = new ElevatorControlSystem(5);
Elevator e = ecs.status()[0];
e.getFloor();// 0
e.getDirection();// Direction.IDLE
e.getGoals();// Empty TreeSet
```
