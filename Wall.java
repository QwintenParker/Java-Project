import java.awt.*;
import java.util.ArrayList;

public class Wall {

    public double x;
    public double y;
    public double width;
    public double height;
    public Character character;
    public int runningX;
    public int runningY;
    public long previousWorldUpdateTime;
    public double speedX;
    public double speedY;

    public Wall(double x, double y, Character character, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
        this.speedX = 0.2;
        this.speedY = 0.2;
        this.previousWorldUpdateTime = System.currentTimeMillis();
    }

    public void checkObjects() {
            if (character.x >= this.x && character.x <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
                character.x = x + width;
            } else  if (character.x + 50 >= this.x && character.x + 50 <= this.x + width && character.y + 30 >= this.y && character.y + 20 <= this.y + height) {
                character.x = x - 50;
            } else if (character.x + 30 >= this.x && character.x + 20 <= x + width && character.y >= y && character.y <= y + height) {
                character.y = y + height;
            } else if (character.x + 30 >= this.x && character.x + 20 <= this.x + width && character.y + 50 >= this.y && character.y + 50 <= this.y + height) {
                character.y = y - 50;
            }
    }

    public void startRunningLeft() {
        runningX = -1;
    }

    public void startRunningRight() {
        runningX = 1;
    }

    public void startRunningDown() {
        runningY = 1;
    }

    public void startRunningUp() {
        runningY = -1;
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
    }

    public void update() {
        long currentTimeMillis = System.currentTimeMillis();
        long dt = currentTimeMillis - previousWorldUpdateTime;
        if (character.worldRunL || character.worldRunR || character.worldRunU || character.worldRunD) {
            x += runningX * dt * speedX;
            y += runningY * dt * speedY;
        }
    }



    public void draw(Graphics g, Character character) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        this.checkObjects();
        this.update();
    }

}
