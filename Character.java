import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Character {
    public File img1 = new File("failed.png");
    public double x;
    public double y;
    public double xRunningSpeed;
    public double yRunningSpeed;
    public int runningX;
    public int runningY;
    public double characterHealth;
    public boolean canHit;
    public boolean movesW;
    public boolean movesA;
    public boolean movesS;
    public boolean movesD;
    public BufferedImage gameOverImage;


    public Character(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        this.xRunningSpeed = 0.2;
        this.yRunningSpeed = 0.2;
        this.runningX = 0;
        this.runningY = 0;
        this.characterHealth = 100;
        this.canHit = false;
        this.movesW = false;
        this.movesA = false;
        this.movesS = false;
        this.movesD = false;
        this.gameOverImage = ImageIO.read(img1);
    }

    public void draw(Graphics g) {
        int imageX = (int) x;
        int imageY = (int) y;
        g.drawRect(imageX, imageY, 50, 50);
        g.drawString(String.valueOf(characterHealth), 20, 20);
    }

    public void drawGameOver(Graphics g) {
        if (characterHealth <= 0) {
            g.drawImage(this.gameOverImage, 0, 0, null);
            x = 999999999;
            y = 999999999;
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

    /*public void checkObjects(double x, double y, double width, double height) {
        if (this.x >= x && this.x <= x + width && this.y + 50 >= y && this.y <= y + height) {
            movesA = true;
            this.x = x + width;
        }

        if (this.x + 50 >= x && this.x + 50 <= x + width && this.y + 50 >= y && this.y <= y + height) {
            movesD = true;
            this.x = x;
        }

        if (this.x + 48 >= x && this.x <= x + width && this.y >= y && this.y <= y + height) {
            movesW = true;
            this.y = y + height;
        }

        if (this.x + 50 >= x && this.x <= x + width && this.y + 50 >= y && this.y + 50 <= y + height) {
            movesS = true;
            this.y = y;
        }
    }*/

    public void update(long dt) {

        x += dt * xRunningSpeed * runningX;
        y += dt * yRunningSpeed * runningY;
    }

    /*public void updateDamage(Enemy enemy) {
        if ((x - 5 <= enemy.x + 35 && x + 55 >= enemy.x) && (y - 5 <= enemy.y + 35 && y + 55 >= enemy.y)) {
            // enemy.drawHealth = true;
            canHit = true;
        } else {
            canHit = false;
        }

    }*/

    public void damage(Enemy enemy, MouseEvent e) {
        if (e.getX() >= enemy.x && e.getX() <= enemy.x + 40 && e.getY() >= enemy.y && e.getY() <= enemy.y + 40) {
            if ((x - 5 <= enemy.x + 35 && x + 55 >= enemy.x) && (y - 5 <= enemy.y + 35 && y + 55 >= enemy.y)) {
                enemy.enemyHealth -= 10;
                System.out.println("Yes");
            }
        }
    }
}
