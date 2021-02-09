import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLocation(640, 200);
        frame.setTitle("TEST_MOVES");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);


        MyPanel panel = new MyPanel((double) frame.getWidth(), (double) frame.getHeight());
        frame.add(panel);
        frame.setVisible(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        KeyboardDispatcher keyboardDispatcher = new KeyboardDispatcher(panel);
        manager.addKeyEventDispatcher(keyboardDispatcher);

        while (true) {
            frame.repaint();
            panel.updateWorldPhysics();
            Thread.sleep(20);
        }
    }
}
