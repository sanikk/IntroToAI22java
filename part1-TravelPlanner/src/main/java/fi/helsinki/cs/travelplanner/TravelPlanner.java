package fi.helsinki.cs.travelplanner;

import java.util.ArrayDeque;
import java.util.HashSet;

public class TravelPlanner {

    /**
     * Implement breadth-first search. Return the answer as a linked list where the
     * first node points to the goal and each node has a stop and is linked to the
     * previous node in the path. The last node in the list is the starting stop and
     * its previous node is null.
     *
     * You can get the neighboring stops by calling the getNeighbors()-method on a
     * stop.
     *
     * @param start Code of the start stop
     * @param goal  Code of the goal stop
     * @return A linked list of States from goal to start
     */
    public State search(Stop start, Stop goal) {
        // Implement breadth-first search
        State state = new State(start, null);
        ArrayDeque<State> jono = new ArrayDeque<>();
        jono.add(state);

        HashSet<Stop> visited = new HashSet<>();

        while (!jono.isEmpty()) {
            final State currentState = jono.removeFirst();
            Stop tamaPysakki = currentState.getStop();
            if (tamaPysakki.equals(goal)) {
                return currentState;
            }
            if (visited.contains(tamaPysakki)) {
                continue;
            }
            tamaPysakki.getNeighbors().stream().map(pysakki -> new State(pysakki, currentState))
                    .forEach(neighbor -> jono.add(neighbor));
            visited.add(tamaPysakki);
        }

        return null;
    }
}
