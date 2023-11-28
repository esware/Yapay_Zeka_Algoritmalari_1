//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package Simulations;

import java.util.Random;
import Algorithms.*;

public class Robot {
    private int length;
    private int width;
    private int[] position = new int[2];
    private int numOfActions = 4;
    private Random rand = new Random();
    private Algorithm algorithm;
    private Environment environment;

    public Robot(Algorithm algorithm, Environment e)
    {
        this.algorithm =algorithm;
        environment=e;
    }

    public int act(int[] state, int action) {
        int reward = 0;
        int x = state[0];
        int y = state[1];
        if (action == 0) {
            --x;
        } else if (action == 1) {
            ++x;
        } else if (action == 2) {
            ++y;
        } else if (action == 3) {
            --y;
        }

        if (environment.hasObstacle(x, y)) {
            reward = -1;
        } else {
            if (environment.hasCookie(x, y)) {
                reward = 2;
                environment.eatCookie(x, y);
            }

            state[0] = x;
            state[1] = y;
        }

        if (environment.isGoal()) {
            reward = 1;
        }

        return reward;
    }

    public int[] startSearching(Simulator sim)
    {
        GraphSearch ts = new GraphSearch(sim, this,sim.environment);
        return ts.followOptimalPath(algorithm);
    }

    public int chooseRandomAction() {
        return this.rand.nextInt(this.numOfActions);
    }

    public int[] chooseRandomState() {
        int[] state = new int[2];
        boolean found = false;

        while(!found) {
            state[0] = this.rand.nextInt(environment.getHeight());
            state[1] = this.rand.nextInt(environment.getWidth());
            if (!environment.hasObstacle(state[0], state[1])) {
                found = true;
            }
        }

        return state;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getNumOfActions() {
        return this.numOfActions;
    }

    public int[] getPosition() {
        return this.position;
    }

    public void setPosition(int[] pos) {
        this.position = pos;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public String getActionMap(int action) {
        String s = "";
        if (action == 0) {
            s = "north";
        } else if (action == 1) {
            s = "south";
        } else if (action == 2) {
            s = "east";
        } else if (action == 3) {
            s = "west";
        }

        return s;
    }
}
