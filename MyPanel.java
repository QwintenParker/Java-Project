import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MyPanel extends JPanel implements MouseListener {

    public Character character;
    public Enemy enemy1;
    public Enemy enemy2;
    private long previousWorldUpdateTime;
    private double frameWidth;
    private double frameHeight;
    public Walls walls0;

    public MyPanel(double x, double y) throws IOException {
        this.frameWidth = x;
        this.frameHeight = y;
        this.character = new Character(frameWidth/2 - 50, frameHeight/2 - 50);
        this.enemy1 = new Enemy((double) 700, (double) 700, character);
        this.enemy2 = new Enemy(120, 700, character);
        this.walls0 = new Walls(character);
        this.previousWorldUpdateTime = System.currentTimeMillis();
        this.addMouseListener(this);
        walls0.createWallsSquare();
        walls0.createObjects();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        walls0.drawWalls(g);
        character.draw(g);
        walls0.drawObjects(g);
        enemy1.draw(g);
        enemy2.draw(g);
        character.drawGameOver(g);


    }

    public void updateWorldPhysics() {
        long currentTime = System.currentTimeMillis();
        long dt = currentTime - previousWorldUpdateTime;

        character.update(dt, walls0);
        enemy1.update(dt);
        enemy2.update(dt);
        enemy1.updateDamage();
        enemy2.updateDamage();

        previousWorldUpdateTime = currentTime;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        character.open(e, walls0);
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
