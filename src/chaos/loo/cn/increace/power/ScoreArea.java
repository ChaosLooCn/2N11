package chaos.loo.cn.increace.power;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ScoreArea extends JPanel {

    JTextArea highScores = new JTextArea(5, 1);
    JLabel highTitle = new JLabel();

    ScoreArea() {
        super();

        setLayout(null);
        setBounds(40, 185, 255, 268);

        highTitle.setBounds(67, 20, 127, 50);
        highScores.setBounds(12, 85, 231, 148);

        highScores.setBackground(new Color(160, 160, 150));
        highScores.setMargin(new Insets(15, 10, 2, 0));
        highScores.setFont(new java.awt.Font("Dialog", 1, 16));

        highScores.setForeground(Color.white);

        highTitle.setFont(new java.awt.Font("Dialog", 1, 22));

        setOpaqueR(false);

    }

    public void writeScore() {

        highScores.setText(new HighScoreFile().scoreRecord[0] + "\n"
                + new HighScoreFile().scoreRecord[1] + "\n" + new HighScoreFile().scoreRecord[2]
                + "\n" + new HighScoreFile().scoreRecord[3] + "\n"
                + new HighScoreFile().scoreRecord[4]);

    }

    public void setOpaqueR(boolean bl) {
        setOpaque(bl);

        if (bl) {
            setBackground(new Color(220, 220, 220));
            add(highTitle);
            add(highScores);
            highTitle.setText("High Scores");
            writeScore();
            this.validate();
            this.repaint();

            Process pro = new Process();
            pro.scoreEnable = 0;
            System.out.println("bl==true");
        } else {
            highTitle.setText("");
            this.remove(highScores);
            this.validate();
            this.repaint();
            System.out.println("bl==false");
        }

    }

}
