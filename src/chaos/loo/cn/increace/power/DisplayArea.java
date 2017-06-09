package chaos.loo.cn.increace.power;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayArea extends JPanel {

    JTextField playerName = new JTextField("Your Name");
    JTextArea highestScore = new JTextArea();
    JLabel yourScore = new JLabel();

    DisplayArea() {

        super();

        setLayout(null);
        setBounds(0, 0, 335, 120);
        setBackground(new Color(200, 200, 200));

        highestScore.setEditable(false);

        playerName.setBounds(25, 23, 80, 35);
        highestScore.setBounds(25, 69, 120, 40);
        yourScore.setBounds(170, 14, 135, 96);

        highestScore.setBackground(new Color(230, 230, 230));
        yourScore.setBackground(new Color(230, 230, 230));

        add(playerName, BorderLayout.WEST);
        add(highestScore, BorderLayout.WEST);
        add(yourScore, BorderLayout.EAST);

    }

}
