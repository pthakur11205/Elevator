import java.util.*;

/*
 * Class for a single elevator that moves between floors, open/close doors,
 * and manages num of passengers
 */
public class Elevator {
    private int currFloor;
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
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.capacity = capacity;
        this.destinations = new TreeSet<>();
        this.openDoor = false;
        this.currPassengers = 0;
    }
}