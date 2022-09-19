package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logic.Stop;
import fi.helsinki.cs.reittiopas.logic.State;

import java.util.PriorityQueue;

public class TravelPlanner {

    private StateComparator stateComparator;

    /**
     * Implement A*
     *
     */
    public State search(Stop start, Stop goal, int timeAteginning) {
        this.stateComparator = new StateComparator(goal);
        PriorityQueue<State> examinees = new PriorityQueue<>(stateComparator);
        State startState = new State(start, null, timeAteginning);
        // ... ... ...
        examinees.add(startState);
        while (!examinees.isEmpty()) {
            State kasiteltavana = examinees.poll();
            Stop tamaPysakki = kasiteltavana.getStop();
            if (tamaPysakki.equals(goal)) {
                return kasiteltavana;
            }
            tamaPysakki.getNeighbors().stream()
                    .map(pysakki -> new State(pysakki, kasiteltavana,
                            kasiteltavana.getCurrentTime()
                                    + tamaPysakki.fastestTransition(pysakki, kasiteltavana.getCurrentTime())))
                    .forEach(tila -> examinees.add(tila));
        }
        return null;
    }
}
