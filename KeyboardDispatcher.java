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
                    panel.character.worldRunL = true;
                panel.character.worldRunR = false;
                    panel.character.wallR = false;
            } else

            if (e.getKeyCode() == KeyEvent.VK_D) {
                    panel.character.worldRunR = true;
                panel.character.worldRunL = false;
                    panel.character.wallL = false;
            } else

            if (e.getKeyCode() == KeyEvent.VK_W) {
                    panel.character.worldRunU = true;
                panel.character.worldRunD = false;
                    panel.character.wallD = false;
            } else

            if (e.getKeyCode() == KeyEvent.VK_S) {
                    panel.character.worldRunD = true;
                panel.character.worldRunU = false;
                    panel.character.wallU = false;
            }
        }

        if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                panel.character.worldRunL = false;
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                panel.character.worldRunR = false;
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                panel.character.worldRunU = false;
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                panel.character.worldRunD = false;
            }
        }


        return false;
    }
}
