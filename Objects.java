import java.awt.*;
import java.awt.event.MouseEvent;

public class Objects {

    public int x;
    public int y;
    private int closing;
    private int opening;
    public boolean canOpen;

    public Objects(int x, int y) {
        this.x = x;
        this.y = y;
        this.closing = 0;
        this.opening = 0;
        this.canOpen = false;
    }

    public void open(MouseEvent e, int x, int y) {
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
        g.drawRect(x, y, 20, 20);
        g.fillRect(x, y, 20, 20);
    }

    public void update(double x, double y) {
        if (this.x > x - 10 && this.x < x + 30 && this.y > y - 10 && this.y < y + 30) {
            canOpen = true;
        } else {
            canOpen = false;
            closing = 0;
            opening = 0;
        }
    }




}

