package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logic.Stop;
import fi.helsinki.cs.reittiopas.logic.State;
import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    private final Stop goal;

    public StateComparator(Stop goalStop) {
        this.goal = goalStop;
    }

    /**
     * Implement this
     *
     * @param stop
     * @return Estimated remaining time
     */
    public double heuristic(Stop stop) {
        Double deltaX = Math.pow(this.goal.getX() - stop.getX(), 2);
        Double deltaY = Math.pow(this.goal.getY() - stop.getY(), 2);
        Double distance = Math.sqrt(deltaX + deltaY);
        return distance / 260;
    }

    /**
     * Implement this
     *
     * @param t1
     * @param t2
     * @return result of the comparison
     */
    @Override
    public int compare(State t1, State t2) {
        Double cost1 = 1.0 * t1.getCurrentTime() + heuristic(t1.getStop());
        Double cost2 = 1.0 * t2.getCurrentTime() + heuristic(t2.getStop());
        // System.out.println(t1);
        // System.out.println(t2);
        if (cost1 < cost2) {
            return -1;
        }
        if (cost1 > cost2) {
            return 1;
        }
        return 0;
    }

}
