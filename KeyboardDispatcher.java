import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardDispatcher implements KeyEventDispatcher {

    private MyPanel panel;

    public boolean W = false;
    public boolean A = false;
    public boolean S = false;
    public boolean D = false;

    public KeyboardDispatcher(MyPanel panel) {
        this.panel = panel;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getID() == KeyEvent.KEY_PRESSED) {

            if (e.getKeyCode() == KeyEvent.VK_A) {
                panel.character.startRunningLeft();
                A = true;
                if (panel.character.movesA && !D) {
                    panel.character.xRunningSpeed = 0;
                } else {
                    panel.character.xRunningSpeed = 0.2;
                }

            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                panel.character.startRunningRight();
                D = true;
                if (panel.character.movesD && !A) {
                    panel.character.xRunningSpeed = 0;
                } else {
                    panel.character.xRunningSpeed = 0.2;
                }

            }

            if (e.getKeyCode() == KeyEvent.VK_W) {
                panel.character.startRunningUp();
                W = true;
                if (panel.character.movesW) {
                    panel.character.yRunningSpeed = 0;
                } else {
                    panel.character.yRunningSpeed = 0.2;
                }

            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                panel.character.startRunningDown();
                S = true;
                if (panel.character.movesS) {
                    panel.character.yRunningSpeed = 0;
                } else {
                    panel.character.yRunningSpeed = 0.2;
                }

            }
        }

        if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                panel.character.stopRunningLeft();
                panel.character.movesA = false;
                A = false;
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                panel.character.stopRunningRight();
                panel.character.movesD = false;
                D = false;
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                panel.character.stopRunningUp();
                panel.character.movesW = false;
                W = false;
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                panel.character.stopRunningDown();
                panel.character.movesS = false;
                S = false;
            }
        }

        /*if (e.getKeyCode() == KeyEvent.VK_G) {
            panel.enemy.startRun();
        }*/

        return false;
    }
}
