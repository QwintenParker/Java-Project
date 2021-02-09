import java.awt.*;
import java.util.ArrayList;

public class Walls {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public Character character;
    public Walls(Character character) {
        this.character = character;
    }

    public void createWallsSquare(Graphics g) {

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


        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).draw(g, character);
        }


    }


}
