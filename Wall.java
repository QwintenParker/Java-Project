import java.awt.*;
import java.util.ArrayList;

public class Wall {

    public double x;
    public double y;
    public double width;
    public double height;
    public Character character;
    public long previousWorldUpdateTime;
    public double speedX;
    public double speedY;

    public Wall(double x, double y, Character character, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.character = character;
        this.speedX = 0.2;
        this.speedY = 0.2;
        this.previousWorldUpdateTime = System.currentTimeMillis();
    }

    public void checkObjects() {
        /*if (character.x >= this.x && character.x <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
            character.stopRunningLeft();
        }

        if (character.x + 50 >= this.x && character.x + 50 <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
            character.stopRunningRight();
        }

        if (character.x + 30 >= this.x && character.x + 20 <= x + width && character.y >= y && character.y <= y + height) {
            character.stopRunningUp();
        }

        if (character.x + 30 >= this.x && character.x + 20 <= this.x + width && character.y + 50 >= this.y && character.y + 50 <= this.y + height) {
            character.stopRunningDown();
        }*/

            if (character.x >= this.x && character.x <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
                //character.stopRunningLeft();
                character.x = x + width;
                //character.runningX = 0;
                character.worldRunL = false;
                //System.out.println("Yes");
            }

            if (character.x + 50 >= this.x && character.x + 50 <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
                character.x = x - 50;
                //character.stopRunningRight();
                //character.runningX = 0;
                character.worldRunR = false;
            }

            if (character.x + 30 >= this.x && character.x + 20 <= x + width && character.y >= y && character.y <= y + height) {
                character.y = y + height;
                //character.stopRunningUp();
                //character.runningY = 0;
                character.worldRunU = false;
            }

            if (character.x + 30 >= this.x && character.x + 20 <= this.x + width && character.y + 50 >= this.y && character.y + 50 <= this.y + height) {
                character.y = y - 50;
                //character.stopRunningDown();
               // character.runningY = 0;
                character.worldRunD = false;
            }
    }

    public void update(Walls walls, long dt) {
        x -= character.runningX * dt * speedX;
        y -= character.runningY * dt * speedY;
    }



    public void draw(Graphics g) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        this.checkObjects();
    }

}
