import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MyPanel extends JPanel implements MouseListener {

    public Character character;
    public Objects object;
    public Objects object1;
    public Objects object2;
    public Enemy enemy1;
    public Enemy enemy2;
    private long previousWorldUpdateTime;
    private double frameWidth;
    private double frameHeight;
    public double eX;
    public double eY;
    public Walls walls0;

    public MyPanel(double x, double y) throws IOException {
        this.frameWidth = x;
        this.frameHeight = y;
        this.character = new Character(frameWidth/2 - 50, frameHeight/2 - 50);
        this.object = new Objects(200, 300);
        this.object1 = new Objects(400, 600);
        this.object2 = new Objects(475, 400);
        this.enemy1 = new Enemy((double) 700, (double) 700, character);
        this.enemy2 = new Enemy(120, 700, character);
        this.walls0 = new Walls(character);
        this.previousWorldUpdateTime = System.currentTimeMillis();
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        walls0.createWallsSquare(g);
        character.draw(g);
        object.draw(g);
        object1.draw(g);
        object2.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        character.drawGameOver(g);


    }

    public void updateWorldPhysics() {
        long currentTime = System.currentTimeMillis();
        long dt = currentTime - previousWorldUpdateTime;

        character.update(dt);
        enemy1.update(dt);
        enemy2.update(dt);
        enemy1.updateDamage(previousWorldUpdateTime);
        enemy2.updateDamage(previousWorldUpdateTime);
        object.update(character.x, character.y);
        object1.update(character.x, character.y);
        object2.update(character.x, character.y);

        previousWorldUpdateTime = currentTime;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        object.open(e, (int) character.x, (int) character.y);
        object1.open(e, (int) character.x, (int) character.y);
        object2.open(e, (int) character.x, (int) character.y);
        eX = e.getX();
        eY = e.getY();
        character.damage(enemy1, e);
        character.damage(enemy2, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
