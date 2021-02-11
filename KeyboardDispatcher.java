import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardDispatcher implements KeyEventDispatcher {

    private MyPanel panel;

    public KeyboardDispatcher(MyPanel panel) {
        this.panel = panel;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getID() == KeyEvent.KEY_PRESSED) {

            if (e.getKeyCode() == KeyEvent.VK_A) {
                if (panel.character.worldRunL) {
                    panel.character.startRunningLeft();
                    panel.character.worldRunR = true;
                } else {
                    panel.character.stopRunningLeft();
                }

                //panel.walls0.startRunningLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                if (panel.character.worldRunR) {
                    panel.character.startRunningRight();
                    panel.character.worldRunL = true;
                } else {
                    panel.character.stopRunningRight();
                }

                //panel.walls0.startRunningRight();
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                if (panel.character.worldRunU) {
                    panel.character.startRunningUp();
                    panel.character.worldRunD = true;
                } else {
                    panel.character.stopRunningUp();
                }

                //panel.walls0.startRunningUp();
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                if (panel.character.worldRunD) {
                    panel.character.startRunningDown();
                    panel.character.worldRunU = true;
                } else {
                    panel.character.stopRunningDown();
                }

                //panel.walls0.startRunningDown();
            }
        }

        if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                panel.character.stopRunningLeft();
                //panel.walls0.stopRunningLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                panel.character.stopRunningRight();
                //panel.walls0.stopRunningRight();
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                panel.character.stopRunningUp();
                //panel.walls0.stopRunningUp();
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                panel.character.stopRunningDown();
                //panel.walls0.stopRunningDown();
            }
        }

        /*if (e.getKeyCode() == KeyEvent.VK_G) {
            panel.enemy.startRun();
        }*/

        return false;
    }
}
