package Algorithms;

import Simulations.*;

public class GraphSearch {

    private Simulator simulator;
    private Robot robot;
    private Environment environment;
    public GraphSearch(Simulator sim, Robot robot, Environment e) {
        this.simulator = sim;
        this.robot = robot;
        environment=e;
    }

    public int[] followOptimalPath(Algorithm algorithm)
    {
        int[] path = algorithm.findOptimalPath();

        if (path == null)
        {
            System.out.println("No path found.");
            return null;
        }

        int steps = 0;
        int[]state = environment.getStart();
        int action;
        robot.setPosition(simulator.convertBoxToPixels(state));

        for(int i=0; i<path.length; i++)
        {
            action = path[steps];
            steps++;
            robot.act(state, action);
            simulator.moveRobot(state);
        }
        System.out.println("Optimal path is followed.");
        return path;
    }
}

