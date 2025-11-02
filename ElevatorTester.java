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
        
        // Starts at floor 1 with doors closed
        System.out.println("=== Attempting to board (doors closed) ===");
        elevator.addPassengers(3);  // should fail (doors closed)
        
        // Go to floor 1 (already there, just open doors)
        System.out.println("\n=== Opening doors at floor 1 ===");
        elevator.addDestination(2);
        elevator.stepAction();
        elevator.addDestination(1);
        elevator.stepAction();
        elevator.stepAction();
        
        // Passengers board
        System.out.println("\n=== Boarding passengers ===");
        elevator.addPassengers(3);
        
        // Select destination
        System.out.println("\n=== Elevating to floor 8 ===");
        elevator.addDestination(8);
        elevator.elevate(15);
        
        // Passengers exit
        System.out.println("\n=== Passengers exiting ===");
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
        elevator.addDestination(1);
        elevator.elevate(2);
        elevator.addPassengers(4);
        elevator.addDestination(5);
        
        // Stop at floor 5 - some exit, some board
        System.out.println("\n=== Floor 5 - Passenger exchange ===");
        elevator.elevate(10);
        elevator.exitPassengers(2);
        elevator.addPassengers(3);
        
        // Test capacity
        System.out.println("\n=== Testing capacity limit ===");
        elevator.addPassengers(4);  // Should fail - exceeds capacity
        
        // Continue to higher floors
        System.out.println("\n=== Continuing to floors 10 and 12 ===");
        elevator.addDestination(10);
        elevator.addDestination(12);
        elevator.elevate(20);
        
        // Passengers exit
        elevator.exitPassengers(5);
        
        elevator.printElevator();
    }
}
