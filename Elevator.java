import java.util.*;

/*
 * Class for a single elevator that moves between floors, open/close doors,
 * and manages num of passengers
 */
public class Elevator {
    private int currFloor;
    private Direction currDirection;
    private final int minFloor;
    private final int maxFloor;
    private final int capacity;
    private final Set<Integer> destinations;
    private boolean openDoor;
    private int currPassengers;

    /*
     * Creates an elevator
     * @param minFloor - The lowest floor reachable by the elevator
     * @param maxFloor - The highest floor reachable by the elevator
     * @param capacity - max num of passengers elevator can hold
     */
    public Elevator(int minFloor, int maxFloor, int capacity) {
        this.currFloor = minFloor;
        this.currDirection = Direction.STILL;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.capacity = capacity;
        this.destinations = new TreeSet<>();
        this.openDoor = false;
        this.currPassengers = 0;
    }

    /*
     * Add destination floor for elevator to visit
     * @param floor - floor to add
     * @returns true if successful, false if invalid
     */
    public boolean addDestination(int floor) {
        if(floor < minFloor || floor > maxFloor) {
            System.out.println("Invalid floor (out of range): " + floor);
            return false;
        }
        if (floor == currFloor) {
            System.out.println("Already at floor " + floor);
            return false;
        }
        destinations.add(floor);
        System.out.println("Destination added: Floor " + floor);
        return true;
    }

    /*
     * Simulate one step of operations
     * @returns true if action performed
     */
    public boolean stepAction() {
        if(destinations.isEmpty()) {
            if(currDirection != Direction.STILL) {
                currDirection = Direction.STILL;
                System.out.println("Now STILL at floor " + currFloor);
            }
            return false;
        }

        // Close doors if open
        if(openDoor) {
            closeDoors();
            return true;
        }

        // Determines direction when no destinations ahead
        if(currDirection == Direction.STILL || !hasDestinationInCurrentDirection()) {
            currDirection = Direction.STILL;
            getDirection();
        }

        // Check if should stop at curr floor
        if(destinations.contains(currFloor)) {
            stop();
            return true;
        }

        // Move elevator
        move();
        return true;
    }

    private boolean hasDestinationInCurrentDirection() {
        if (currDirection == Direction.STILL) {
            return false;
        }
        
        for (int floor : destinations) {
            if (currDirection == Direction.UP && floor > currFloor) {
                return true;
            }
            if (currDirection == Direction.DOWN && floor < currFloor) {
                return true;
            }
        }
        return false;
    }
    /*
     * Run elevator till all destinations are reached or max actions exceeded
     * @param maxActions - max num of actions to run
     */
    public void elevate(int maxActions) {
        System.out.println("\n=== Starting Elevator ===");
        System.out.println("Current floor: " + currFloor);
        System.out.println("Destinations: " + destinations);
        System.out.println("========================\n");

        for (int i = 1; i <= maxActions; i++) {
            System.out.println("--- Step " + i + " ---");
            boolean actionTaken = stepAction();
            
            if (!actionTaken && destinations.isEmpty()) {
                System.out.println("\nAll destinations reached!");
                break;
            }
        }
        
        printElevator();
    }

    /*
     * Simulates passengers entering elevator
     * @param - count number of passengers boarding
     * @returns true if successful
     */
    public boolean addPassengers(int count) {
        if (!openDoor) {
            System.out.println("Cannot board since doors are closed");
            return false;
        }

        if (currPassengers + count > capacity) {
            System.out.println("Cannot board " + count + " passengers: exceeds capacity of " + capacity);
            return false;
        }

        currPassengers += count;
        System.out.println(count + " passenger(s) boarded -> Total: " + currPassengers + "/" + capacity);
        return true;
    }

    /*
     * Simulates passengers exiting elevator
     * @param - count number of passengers exiting
     * @returns true if successful
     */
    public boolean exitPassengers(int count) {
        if (!openDoor) {
            System.out.println("Cannot exit since doors are closed");
            return false;
        }

        if (currPassengers < count) {
            System.out.println("Cannot exit " + count + " passengers: only " + currPassengers + " inside");
            return false;
        }

        currPassengers -= count;
        System.out.println(count + " passenger(s) exited -> Remaining: " + currPassengers + "/" + capacity);
        return true;
    }

    private void getDirection() {
        int nextFloor = getNextFloor();
        if (nextFloor > currFloor) {
            currDirection = Direction.UP;
            System.out.println("Direction is UP");
        } else if (nextFloor < currFloor) {
            currDirection = Direction.DOWN;
            System.out.println("Direction is DOWN");
        }
    }

    private int getNextFloor() {
        if (destinations.isEmpty()) {
            return currFloor;
        }

        // Find the nearest floor in current direction
        if (currDirection == Direction.UP) {
            for (int floor : destinations) {
                if (floor >= currFloor) {
                    return floor;
                }
            }
        }
        
        if (currDirection == Direction.DOWN) {
            List<Integer> floors = new ArrayList<>(destinations);
            for (int i = floors.size() - 1; i >= 0; i--) {
                if (floors.get(i) <= currFloor) {
                    return floors.get(i);
                }
            }
        }

        // If still, find nearest floor
        if (currDirection == Direction.STILL) {
            int nearest = destinations.iterator().next();
            int minDist = Math.abs(currFloor - nearest);
            for (int floor : destinations) {
                int dist = Math.abs(currFloor - floor);
                if (dist < minDist) {
                    minDist = dist;
                    nearest = floor;
                }
            }
            return nearest;
        }

        // If no floor in direction, take any floor
        return destinations.iterator().next();
    }

    private void move() {
        if (currDirection == Direction.UP && currFloor < maxFloor) {
            currFloor++;
            System.out.println("Moving UP -> Floor " + currFloor);
        } else if (currDirection == Direction.DOWN && currFloor > minFloor) {
            currFloor--;
            System.out.println("Moving DOWN -> Floor " + currFloor);
        }
    }

    private void stop() {
        destinations.remove(currFloor);
        open();
    }

    public void open() {
        if (openDoor) {
            System.out.println("Doors are already open at floor " + currFloor);
            return;
        }
        openDoor = true;
        System.out.println("Doors open at floor " + currFloor);
    }
        
    private void closeDoors() {
       openDoor = false;
       System.out.println("Doors closed");
    }

    // Prints status of elevator
    public void printElevator() {
        System.out.println("\n=============================================");
        System.out.println("Current Floor: " + currFloor);
        System.out.println("Current Direction: " + currDirection);
        System.out.println("Doors are: " + (openDoor ? "OPEN" : "CLOSED"));
        System.out.println("Current Passengers: " + currPassengers + "/" + capacity);
        System.out.println("Destinations: " + (destinations.isEmpty() ? "None" : destinations.toString()));
        System.out.println("\n=============================================");
    }

    // Getters
    public int getCurrentFloor() {
        return currFloor;
    }

    public Direction getCurrentDirection() {
        return currDirection;
    }

    public boolean isStill() {
        return currDirection == Direction.STILL && destinations.isEmpty();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentPassengers() {
        return currPassengers;
    }

    public boolean areDoorsOpen() {
        return openDoor;
    }

    public Set<Integer> getDestinationFloors() {
        return new TreeSet<>(destinations);
    }

}