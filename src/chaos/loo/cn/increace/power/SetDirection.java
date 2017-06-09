package chaos.loo.cn.increace.power;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SetDirection extends JPanel implements KeyListener {

    SetDirection() {
        super();
    }

    static int direction = -1;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            direction = 1;
            System.out.println("up");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            direction = 2;
            System.out.println("down");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction = 3;
            System.out.println("left");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direction = 4;
            System.out.println("right");
        } else
            direction = -1;

    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            direction = 1;
            System.out.println("up");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            direction = 2;
            System.out.println("down");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction = 3;
            System.out.println("left");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direction = 4;
            System.out.println("right");
        } else
            direction = -1;
    }

    public void keyReleased(KeyEvent e) {

    }

    public int directionB() {
        return direction;
    }

}
