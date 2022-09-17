package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logic.State;
import fi.helsinki.cs.reittiopas.logic.Stop;
import fi.helsinki.cs.reittiopas.logic.StopGraph;

public class Testeri {
    public static void main(String[] args) {

        StopGraph stopGraph = new StopGraph("graph.json", "routes.json");
        // TravelPlanner travelPlanner = new TravelPlanner();
        // int startTime = 4;
        // Stop start = stopGraph.getStop("1150435"); // Meilahdentie
        Stop goal = stopGraph.getStop("1130446"); // Caloniuksenkatu'
        Stop caloniuksenkatu = stopGraph.getStop("1130446"); // Caloniuksenkatu'
        Stop stop1 = stopGraph.getStop("1250429");
        Stop maali = stopGraph.getStop("1121480");

        StateComparator stateComparator = new StateComparator(goal);
        State t1 = new State(stop1, null, 20);
        State t2 = new State(stop1, null, 10);
        System.out.println(stateComparator.compare(t1, t2));

        stateComparator = new StateComparator(maali);
        State state1 = new State(caloniuksenkatu, null, 10);
        State state2 = new State(stop1, null, 10);
        System.out.println(stateComparator.compare(state2, state1) > 0);
    }
}
