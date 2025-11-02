public class ElevatorTester {
    public static void main(String[] args) {
        System.out.println("-----------------------------");
        System.out.println("ELEVATOR SIMULATION DEMO");
        System.out.println("-----------------------------");
    
        basicMovement();
        multipleFloors();
        passengerOperations();
        fullScenario();
    
        System.out.println("-----------------------------");
        System.out.println("DEMO COMPLETED");
        System.out.println("-----------------------------");
    }

    // Demo: Basic elevator movement
    private static void basicMovement() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMO: Basic Movement");
        System.out.println("=".repeat(50));
        System.out.println("Elevator travels from floor 1 to floor 5\n");

        Elevator elevator = new Elevator(1, 10, 8);
        elevator.addDestination(5);
        elevator.elevate(10);
    }

    // Demo: Elevator visits multiple floors in a sequence
    private static void multipleFloors() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMO: Multiple Destinations");
        System.out.println("=".repeat(50));
        System.out.println("Visit floors 3, 7, and 2\n");

        Elevator elevator = new Elevator(1, 10, 8);
        elevator.addDestination(3);
        elevator.addDestination(7);
        elevator.addDestination(2);
        elevator.elevate(25);
    }

    // Demo: Demonstrate boarding and exiting
    private static void passengerOperations() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMO: Passenger Operations");
        System.out.println("=".repeat(50));
        System.out.println("Passengers board at floor 1, travel to floor 8, and exit\n");

        Elevator elevator = new Elevator(1, 10, 8);
        
        // Test 1: Try to board with doors closed (should fail)
        System.out.println("=== Test 1: Attempting to board with doors closed ===");
        elevator.addPassengers(3);
        
        // Test 2: Open doors at current floor and board
        System.out.println("\n=== Test 2: Opening doors at floor 1 and boarding ===");
        elevator.open();
        elevator.addPassengers(3);
        
        // Test 3: Elevate to floor 8
        System.out.println("\n=== Test 3: Traveling to floor 8 ===");
        elevator.addDestination(8);
        elevator.elevate(15);
        
        // Test 4: Add another destination (floor 3): should go back down
        System.out.println("\n=== Test 4: Adding destination floor 3 (test direction reversal) ===");
        elevator.addDestination(3);
        elevator.elevate(10);
        
        // Test 5: Passengers exit
        System.out.println("\n=== Test 5: Passengers exiting ===");
        elevator.exitPassengers(3);
        
        elevator.printElevator();
    }

    // Demo: Full scenario with many operations
    private static void fullScenario() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMO: Complete Scenario");
        System.out.println("=".repeat(50));
        System.out.println("Multiple passengers, multiple floors, capacity testing\n");

        Elevator elevator = new Elevator(1, 15, 8);
        
        // Ground floor - group 1 boards
        System.out.println("=== Group 1 boards at ground floor ===");
        elevator.open();  // Open doors at starting floor
        elevator.addPassengers(4);
        elevator.addDestination(5);
        
        // Stop at floor 5 - some exit, some board
        System.out.println("\n=== Floor 5 - Passenger exchange ===");
        elevator.elevate(10);
        elevator.exitPassengers(2);
        elevator.addPassengers(3);
        
        // Test capacity
        System.out.println("\n=== Testing capacity limit ===");
        elevator.addPassengers(4);
        elevator.addPassengers(3);  

        // Continue to higher floors
        System.out.println("\n=== Continuing to floors 10 and 12 ===");
        elevator.addDestination(10);
        elevator.addDestination(12);
        elevator.elevate(20);
        
        // Some passengers exit at floor 12
        System.out.println("\n=== Passengers exiting at floor 12 ===");
        elevator.exitPassengers(5);
        
        // Go back down to floor 3
        System.out.println("\n=== Going back down to floor 3 ===");
        elevator.addDestination(3);
        elevator.elevate(15);
        
        elevator.printElevator();
    }
}
