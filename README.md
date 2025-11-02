# Elevator Simulation

This project simulates the operation of a **single elevator** in a multi-floor building. It models realistic elevator behavior, including movement between floors, door operations, passenger management, and destination scheduling.

---

## Overview

The simulation consists of three main files:

* **`Elevator.java`** – Core elevator logic and state management
* **`Direction.java`** – Enum representing elevator movement direction (`UP`, `DOWN`, `STILL`)
* **`ElevatorTester.java`** – Demo scenarios for testing various elevator behaviors

The program prints detailed logs showing each step of the elevator’s operation, such as door openings, floor arrivals, and passenger events.

---

## Features

* Move between **minimum and maximum floors**
* **Add multiple destination floors** dynamically
* Automatically determine **direction (UP/DOWN/STILL)**
* **Open and close doors** at stops
* Manage **passenger boarding and exiting**
* Enforce **maximum capacity**
* Simulate operation over multiple time steps with `elevate(maxActions)`

---

## Class Summary

### `Elevator`

Implements the elevator’s state.

**Key Methods:**

* `addDestination(int floor)` – Schedule a floor visit
* `stepAction()` – Perform one simulation step
* `elevate(int maxActions)` – Run until all destinations are served
* `addPassengers(int count)` / `exitPassengers(int count)` – Manage passengers
* `open()` / `closeDoors()` – Control door state
* `printElevator()` – Print current elevator status

---

### `Direction`

Enum with values:

* `UP`
* `DOWN`
* `STILL`

---

### `ElevatorTester`

Contains demo methods showcasing:

* Basic elevator movement
* Multiple destinations
* Passenger operations
* A full scenario combining all features

Run via:

```bash
# Compile
javac *.java

# Run
java ElevatorTester
```

---

## Example Output

```
=== Starting Elevator ===
Current floor: 1
Destinations: [5]
========================

--- Step 1 ---
Direction is UP
Moving UP -> Floor 2
...
Doors open at floor 5
Doors closed
All destinations reached!
```

---

## File Structure

```
.
├── Elevator.java
├── Direction.java
├── ElevatorTester.java
├── README.md
└── ASSUMPTIONS.md
```

---

## See Also

For design assumptions and simplifications made in this simulation, refer to **[ASSUMPTIONS.md](ASSUMPTIONS.md)**.
