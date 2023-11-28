//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package Simulations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Environment {
    public Environments environmentName;
    private  short[][] region;
    private  int width;
    private  int height;
    private  int[] start;
    private  boolean goal;

    public Environment(Environments environments)
    {
        environmentName = environments;
        start = new int[2];
        Scanner scanner = null;
        var environmentPath = "./src/Environments/"+environmentName.toString()+".txt";

        try {
            scanner = new Scanner(new File(environmentPath), "UTF-8");
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        }

        scanner.next();
        width = scanner.nextInt();
        scanner.next();
        height = scanner.nextInt();
        region = new short[height][width];

        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                region[i][j] = scanner.nextShort();
            }
        }

        this.printEnvironment();
        scanner.next();
        start[0] = scanner.nextInt() - 1;
        start[1] = scanner.nextInt() - 1;
    }

    public void printEnvironment() {
        System.out.println("Given environment is:");

        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                System.out.print(region[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }

    public boolean hasObstacle(int x, int y) {
        return x < 0 || y < 0 || x > height - 1 || y > width - 1 || region[x][y] == 1;
    }

    public boolean hasCookie(int x, int y) {
        return x >= 0 && y >= 0 && x <= height - 1 && y <= width - 1 && region[x][y] == 2;
    }

    public void eatCookie(int x, int y) {
        if (x >= 0 && y >= 0 && x <= height - 1 && y <= width - 1 && region[x][y] == 2) {
            region[x][y] = 0;
        }

    }

    public  boolean isGoal() {
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if (region[i][j] == 2) {
                    return false;
                }
            }
        }

        goal = true;
        return true;
    }

    public  short[][] getEnvironment() {
        return region;
    }

    public  int getWidth() {
        return width;
    }

    public  int getHeight() {
        return height;
    }

    public  int[] getStart() {
        return start;
    }

    public  boolean getGoal() {
        return goal;
    }
    public  boolean isValidLocation(int x, int y) {
        return x >= 0 && y >= 0 && x < height && y < width;
    }
    public  List<int[]> getCookies() {
        List<int[]> cookies = new ArrayList<>();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (region[i][j] == 2) {
                    cookies.add(new int[]{i, j});
                }
            }
        }
        return cookies;
    }
}

