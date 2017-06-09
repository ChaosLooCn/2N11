package chaos.loo.cn.increace.power;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlArea extends JPanel {

    JButton buttonStart = new JButton("START");
    JButton buttonRestart = new JButton("RESTART");
    JButton buttonClose = new JButton("CLOSE");

    ControlArea() {

        super();

        setBounds(0, 120, 335, 42);
        setBackground(new Color(10, 10, 10));

        buttonStart.setSize(200, 100);
        add(buttonStart, BorderLayout.CENTER);

        buttonRestart.setSize(200, 100);
        add(buttonRestart, BorderLayout.CENTER);

        buttonClose.setSize(200, 100);
        add(buttonClose, BorderLayout.CENTER);

    }

}
