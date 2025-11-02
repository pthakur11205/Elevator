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
        return true;
    }

    /*
     * Simulate one step of operations
     * @returns true if action performed
     */
    public boolean stepAction() {
        return true;
    }

    /*
     * Run elevator till all destinations are reached or max actions exceeded
     * @param maxActions - max num of actions to run
     */
    public void elevate(int maxActions) {

    }

    /*
     * Simulates passengers entering elevator
     * @param - count number of passengers boarding
     * @returns true if successful
     */
    public boolean addPassengers(int count) {
        return true;
    }

    /*
     * Simulates passengers exiting elevator
     * @param - count number of passengers exiting
     * @returns true if successful
     */
    public boolean exitPassengers(int count) {
        return true;
    }

    private void getDirection() {

    }

    private int getNextFloor() {
        return -1;
    }

    private void move() {

    }

    private void stop() {

    }

    private void open() {

    }
        
    private void closeDoors() {
       
    }

    // Prints status of elevator
    public void printElevator() {

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