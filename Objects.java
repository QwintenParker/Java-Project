import java.awt.*;
import java.awt.event.MouseEvent;

public class Objects {

    public double x;
    public double y;
    public int closing;
    public int opening;
    public double speedX;
    public double speedY;
    public boolean canOpen;
    public double width;
    public double height;
    public Character character;

    public Objects(double x, double y, Character character) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.speedX = 0.21;
        this.speedY = 0.21;
        this.closing = 0;
        this.opening = 0;
        this.canOpen = false;
        this.character = character;
    }

    public void open(MouseEvent e) {
        if (e.getX() >= this.x && e.getX() <= this.x + 20 && e.getY() >= this.y && e.getY() <= this.y + 20) {
            if (canOpen && closing !=1) {
                opening = 1;
                closing = closing + 1;
            } else {
                opening = 0;
                closing = 0;
            }
        }
    }

    public void draw(Graphics g) {
        if (opening == 0) {
            g.setColor(Color.black);
        } else {
            g.setColor(Color.red);
        }
        g.drawRect((int) x, (int) y, (int) width, 20);
        g.fillRect((int) x, (int) y, 20, 20);
    }

    public void update(long dt) {


        if (character.x + 50 > x - 10 && character.x < x + width + 10 && character.y + 50 > y - 10 && character.y < y + height + 10) {
            canOpen = true;
        } else {
            canOpen = false;
            closing = 0;
            opening = 0;
        }
        x -= character.xRunningSpeed * character.runningX * dt;
        y -= character.yRunningSpeed * character.runningY * dt;

    }
}

