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
    public double canMoveX;
    public double canMoveY;
    public double xRunningSpeed;
    public double yRunningSpeed;
    public int runningX;
    public int runningY;
    public double characterHealth;
    public boolean canHit;
    public BufferedImage gameOverImage;
    public boolean worldRunL = false;
    public boolean worldRunR;
    public boolean worldRunU;
    public boolean worldRunD;
    public boolean wallL;
    public boolean wallR;
    public boolean wallU;
    public boolean wallD;


    public Character(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        this.canMoveX = x - 50;
        this.canMoveY = y - 50;
        this.xRunningSpeed = 0.2;
        this.yRunningSpeed = 0.2;
        this.runningX = 0;
        this.runningY = 0;
        this.characterHealth = 100;
        this.canHit = false;
        this.gameOverImage = ImageIO.read(img1);
        this.worldRunR = false;
        this.worldRunU = false;
        this.worldRunD = false;
        this.wallL = false;
        this.wallR = false;
        this.wallU = false;
        this.wallD = false;
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



    public void update(long dt, Walls walls) {
        walls.wallsMoves(dt);
    }

    public void open(MouseEvent e, Walls walls) {
        walls.open(e);
    }


    public void damage(Enemy enemy, MouseEvent e) {
        if (e.getX() >= enemy.x && e.getX() <= enemy.x + 40 && e.getY() >= enemy.y && e.getY() <= enemy.y + 40) {
            if ((x - 5 <= enemy.x + 35 && x + 55 >= enemy.x) && (y - 5 <= enemy.y + 35 && y + 55 >= enemy.y)) {
                enemy.enemyHealth -= 10;
                System.out.println("Yes");
            }
        }
    }
}
