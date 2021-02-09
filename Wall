import java.awt.*;
import java.util.ArrayList;

public class Wall {

    public double x;
    public double y;
    public double width;
    public double height;
    public Character character;

    public Wall(double x, double y, Character character, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.character = character;
    }

    public void checkObjects() {
        if (character.x >= this.x && character.x <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
            //character.movesA = true;
            character.x = x + width;
        } else  if (character.x + 50 >= this.x && character.x + 50 <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
            //character.movesD = true;
            character.x = x - 50;
        } else if (character.x + 30 >= this.x && character.x + 20 <= x + width && character.y >= y && character.y <= y + height) {
            //character.movesW = true;
            character.y = y + height;
        } else if (character.x + 30 >= this.x && character.x + 20 <= this.x + width && character.y + 50 >= this.y && character.y + 50 <= this.y + height) {
            //character.movesS = true;
            character.y = y - 50;
        }






    }



    public void draw(Graphics g, Character character) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        this.checkObjects();
    }

}
