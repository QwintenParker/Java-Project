import java.awt.*;
import java.util.ArrayList;

public class Walls {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public Character character;
    public int runningX;
    public int runningY;
    public Walls(Character character) {
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
    }

    /*public void startRunningLeft() {
        runningX = 1;
    }

    public void startRunningRight() {
        runningX = -1;
    }

    public void startRunningDown() {
        runningY = -1;
    }

    public void startRunningUp() {
        runningY = 1;
    }

    public void stopRunningLeft() {
        if (runningX == -1) {
            runningX = 0;
        }
    }

    public void stopRunningRight() {
        if (runningX == 1) {
            runningX = 0;
        }
    }

    public void stopRunningDown() {
        if (runningY == 1) {
            runningY = 0;
        }
    }

    public void stopRunningUp() {
        if (runningY == -1) {
            runningY = 0;
        }
    }*/

    public void createWallsSquare() {

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(100, i, character, 10, 50));
            i = i + 50;
        }

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(790, i, character, 10, 50));
            i = i + 50;
        }

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(i, 100, character, 50 ,10));
            i = i + 50;
        }

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(i, 790, character, 50, 10));
            i = i + 50;
        }
    }


    public void drawWalls(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).draw(g);
        }
    }



    public void wallsMoves(long dt) {
        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).update(this, dt);
        }
    }


}
