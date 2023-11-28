//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package Simulations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class Simulator extends JFrame {
    private int width;
    private int height;
    private static final int heightOffset = 20;
    private int boxSize;
    private Robot robot;
    boolean isFirst;
    int[] prevLocation;
    ImageIcon robotPicture;
    boolean isOnline;
    public Environment environment;

    public Simulator(){

    }

    public Simulator(boolean isOnline, Simulations.Robot robot, Environment environment)
    {

        super("Testing "+environment.environmentName.toString());
        this.environment =environment;
        this.isOnline = isOnline;
        this.robot = robot;
        this.boxSize = 60;
        this.width = environment.getWidth() * this.boxSize;
        this.height = environment.getHeight() * this.boxSize + 20;
        this.setSize(this.width, this.height);
        this.setResizable(false);
        this.isFirst = true;
        this.robotPicture = new ImageIcon(this.getClass().getResource("cookie_monster.png"));
        robot.setWidth(this.robotPicture.getIconWidth());
        robot.setLength(this.robotPicture.getIconHeight());
        robot.setPosition(this.convertBoxToPixels(environment.getStart()));
        this.getContentPane().setBackground(new Color(255, 236, 236));
        this.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                // TODO Auto-generated method stub
                isFirst = true;
                repaint();
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        //robot.startSearching(this);
    }

    public int[] convertBoxToPixels(int[] box) {
        int[] pixels = new int[]{box[1] * this.boxSize + (this.boxSize - this.robot.getWidth()) / 2, 20 + box[0] * this.boxSize + (this.boxSize - this.robot.getLength()) / 2};
        return pixels;
    }

    public void paint(Graphics g) {
        if (this.isFirst) {
            super.paint(g);
            this.drawEnvironment(g);
            this.drawRobot(g, this.robot.getPosition());
            this.isFirst = false;
        } else if (this.prevLocation != null) {
            this.drawRobot(g, this.robot.getPosition());
        }

    }

    public void drawRobot(Graphics g, int[] pos) {
        this.robotPicture.paintIcon(this, g, pos[0], pos[1]);
    }

    public void moveRobot(int[] next) {
        next = this.convertBoxToPixels(next);
        int x_range = Math.abs(next[0] - this.robot.getPosition()[0]);
        int y_range = Math.abs(next[1] - this.robot.getPosition()[1]);
        int x_inc = x_range != 0 ? (next[0] - this.robot.getPosition()[0]) / x_range : 0;
        int y_inc = y_range != 0 ? (next[1] - this.robot.getPosition()[1]) / y_range : 0;

        for(int i = 0; i < y_range || i < x_range; ++i) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException var8) {
                var8.printStackTrace();
            }

            this.prevLocation = this.robot.getPosition();
            this.robot.setPosition(this.robot.getPosition()[0] + x_inc, this.robot.getPosition()[1] + y_inc);
            this.repaint();
        }

    }

    public void repaintSubRegion(Graphics g, int[] pos) {
        short[][] region = environment.getEnvironment();

        for(int i = pos[1] <= 0 ? 0 : pos[1] - 1; i < (pos[1] + this.robot.getLength() >= this.height ? this.height : pos[1] + this.robot.getLength() + 1); ++i) {
            for(int j = pos[0] <= 0 ? 0 : pos[0] - 1; j < (pos[0] + this.robot.getWidth() >= this.width ? this.width : pos[0] + this.robot.getWidth() + 1); ++j) {
                int h_remainder = (i - 20) % this.boxSize;
                int w_remainder = j % this.boxSize;
                int h_division = (i - 20) / this.boxSize;
                int w_division = j / this.boxSize;
                if (h_remainder != 0 && h_remainder != 1 && w_remainder != 0 && w_remainder != 1) {
                    if (region[h_division][w_division] == 1) {
                        g.setColor(new Color(128, 157, 193));
                    } else {
                        g.setColor(new Color(255, 236, 236));
                    }
                } else {
                    g.setColor(new Color(64, 0, 0));
                }

                g.fillRect(j, i, 1, 1);
            }
        }

    }

    public void drawEnvironment(Graphics g) {
        boolean once = true;
        short[][] region = environment.getEnvironment();

        for(int i = 0; (double)i < Math.floor((double)(this.height / this.boxSize)); ++i) {
            g.setColor(new Color(64, 0, 0));
            g.fillRect(0, 20 + i * this.boxSize, this.width, 2);

            for(int j = 0; j < this.width / this.boxSize; ++j) {
                if (once) {
                    g.setColor(new Color(64, 0, 0));
                    g.fillRect(j * this.boxSize, 0, 2, this.height);
                }

                if (region[i][j] == 1) {
                    g.setColor(new Color(128, 157, 193));
                    g.fillRect(j * this.boxSize + 2, 20 + i * this.boxSize + 2, this.boxSize - 2, this.boxSize - 2);
                } else if (region[i][j] == 2) {
                    g.setColor(new Color(160, 80, 0));
                    g.fillOval(j * this.boxSize + 17, 20 + i * this.boxSize + 17, this.boxSize - 34, this.boxSize - 34);
                }
            }

            if (once) {
                once = false;
            }
        }

    }
}
