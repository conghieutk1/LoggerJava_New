import Interfaces.IKeyListener;

import java.awt.event.KeyEvent;

public class KeyListener implements IKeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        int keyCode = e.getKeyCode();

        System.out.println("Key Typed: " + keyChar + " " + keyCode);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        int keyCode = e.getKeyCode();

        System.out.println("Key Pressed: " + keyChar + " " + keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char keyChar = e.getKeyChar();
        int keyCode = e.getKeyCode();

        System.out.println("Key Released: " + keyChar + " " + keyCode);
        String a = "";
        a += "aa";
    }
}
