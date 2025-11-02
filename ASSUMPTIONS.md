# Elevator Simulation – Design Assumptions

The following assumptions and simplifications were made:
---

### Elevator Mechanics

* Only **one elevator** is simulated.
* Doors must be **open** for passengers to board or exit.
* Doors **automatically close** before the elevator moves again.

---

### Movement and Scheduling

* The elevator moves **one floor per step**.
* Destinations are stored in a **sorted `TreeSet`**, so duplicate destinations are ignored.
* Direction is determined by the **nearest pending destination** when still.
* When there are no remaining destinations, the elevator becomes **STILL**.
* Elevator cannot travel below `minFloor` or above `maxFloor`.

---

### Passenger Management

* Passengers can only **board or exit** when doors are open.
* Total passengers cannot exceed **capacity**.
* Passenger counts are simulated numerically (no per-passenger tracking).

---

### Simulation Flow

* Each step (`stepAction`) represents one time tick.
* `elevate(maxActions)` runs for a maximum number of actions or until all destinations are cleared.
* Printed console logs represent the state after each action.

---

### Simplifications

* No real-time scheduling, sensors, or timing delays are modeled.
* No distinction between internal/external elevator requests.
* No error recovery for unexpected conditions beyond bounds/capacity checks.

---

