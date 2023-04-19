package Interfaces;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public interface IKeyListener {
    public void keyTyped(KeyEvent e);
    public void keyPressed(KeyEvent e);
    public void keyReleased(KeyEvent e);
}
