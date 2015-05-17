# API
Create system with 5 elevators:
``` java
ElevatorControlSystem ecs = new ElevatorControlSystem(5);
```
State of elevators:
``` java
Elevator e = ecs.status()[0];
e.getFloor();// 0
e.getDirection();// Direction.IDLE
e.getGoals();// Empty TreeSet<Integer>
```
Updating elevator:
``` java
ecs.update(1, 5);
ecs.status()[1].getGoals();// {5}
```
Pickup request:
``` java
ecs.pickup(10, Direction.DOWN);
```
Time step:
``` java
ecs.step();
```

# Design
The problem is partitioned into two major categories:
- Which direction a specific elevator should move
- Which elevator should be assigned a request

The decision as to which direction an elevator should move is based on the concept of nearest endpoint. Intuitively, you can visualize all of the destination floors for an elevator on a number line. The most efficient path to visiting every goal is to first go to the nearest endpoint and then change direction and go to the other end.

Deciding which elevator to assign to each of these jobs is less straight-forward. The idea here is to divide requests into convenient and inconvenient for specific elevators. A convenient request is one that's on the way and won't require a change in direction, with everything being convenient to an idle elevator. The algorithm is then to first look for the nearest elevator for which a request is convenient, falling back on the nearest of all elevators.
