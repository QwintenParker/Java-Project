import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Walls {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<Objects> objects = new ArrayList<>();
    public Character character;
    public int runningX;
    public int runningY;
    public Walls(Character character) {
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
    }

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

    public void createObjects() {
        objects.add(new Objects(200, 300, character));
        objects.add(new Objects(400, 600, character));
        objects.add(new Objects(475, 400, character));
    }


    public void drawWalls(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).draw(g);
        }
    }

    public void drawObjects(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            (objects.get(i)).draw(g);
        }
    }



    public void wallsMoves(long dt) {
        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).update(dt);
        }

        for (int i = 0; i < objects.size(); i++) {
            (objects.get(i)).update(dt);
        }
    }

    public void open(MouseEvent e) {
        for (int i = 0; i < objects.size(); i++) {
            (objects.get(i)).open(e);
        }
    }


}
