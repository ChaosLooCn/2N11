package chaos.loo.cn.increace.power;

import java.util.Arrays;
import java.util.Date;

import javax.swing.SwingConstants;

public class Process {

    static int[] report = new int[16];
    static int[] lastreport = new int[16];
    static int judge = 1;
    static int fileSortable = 0;
    static int beginhere = 0;
    static int scoreEnable = 0;
    final static int[] initial = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static void main(String[] args) {

        FrameArea frm = new FrameArea();

        HighScoreFile highScore = new HighScoreFile();
        Mythix mythix = new Mythix();

        try {
            if (highScore.getScoreRecord(0).startsWith("0")
                    & highScore.getScoreRecord(0).endsWith("null")) {
                frm.displayArea.highestScore.setText("     Welcome!!!");
            } else {
                frm.displayArea.highestScore.setText("High Score By   \n"
                        + highScore.getScoreRecord(0).replaceAll("-", "  "));
            }

        } catch (NullPointerException e) {
            // highScore.writeYourScore("0--null none");
        }

        int newone = -2;
        int newtwo = -2;
        long timeOne = 0;
        long timeTwo = 0;

        newone = mythix.generate(1);
        report = mythix.report();
        frm.blockArea.setNewBlock(newone);

        newtwo = mythix.generate(1);
        report = mythix.report();
        frm.blockArea.setNewBlock(newtwo);

        timeOne = new Date().getTime();
        while ((timeTwo - timeOne) < 300) {

            timeTwo = new Date().getTime();
        }

        frm.PtoFrame(report);

        /*
         * newone=mythix.generate(1); report=mythix.report(); if(newone>=1000){
         * frm.blockArea.setNewBlock(newone-1000); } else{ frm.blockArea.setNewBlock(newone); }
         * newone=mythix.generate(1); report=mythix.report(); if(newone>=1000){
         * frm.blockArea.setNewBlock(newone-1000); } else{ frm.blockArea.setNewBlock(newone); }
         * 
         * 
         * timeOne=new Date().getTime(); while((timeTwo-timeOne)<1000){
         * 
         * timeTwo=new Date().getTime(); } frm.PtoFrame(report);
         */

        // Cyclic Processing Body
        while (true) {

            int direction = -1;

            // slide -> merge -> slide
            direction = frm.getDirection();
            frm.setDirection();

            report = mythix.report();

            mythix.slide(direction);
            System.arraycopy(mythix.report(), 0, report, 0, 16);

            mythix.merge(direction);
            System.arraycopy(mythix.report(), 0, report, 0, 16);

            mythix.slide(direction);
            System.arraycopy(mythix.report(), 0, report, 0, 16);
            frm.PtoFrame(report);

            if (judge == 1)
                ;

            else {

                frm.displayArea.highestScore.setText("High Score By   \n"
                        + highScore.getScoreRecord(0).replaceAll("-", "  "));
                mythix.resetPoints();

                mythix.setGrid(initial);

                newone = mythix.generate(1);
                report = mythix.report();
                frm.blockArea.setNewBlock(newone);

                frm.blockArea.validate();
                frm.blockArea.repaint();

                newtwo = mythix.generate(1);
                report = mythix.report();
                frm.blockArea.setNewBlock(newtwo);

                frm.blockArea.validate();
                frm.blockArea.repaint();

                timeOne = new Date().getTime();
                while ((timeTwo - timeOne) < 300) {

                    timeTwo = new Date().getTime();
                }

                frm.PtoFrame(report);
                frm.blockArea.validate();
                frm.blockArea.repaint();

                judge = 1;

            }

            // generate
            if ((!(Arrays.equals(lastreport, report))) & (beginhere == 1)) {

                newone = mythix.generate(0);
                if ((newone != -2)) {
                    if (newone >= 1000) {
                        frm.blockArea.setNewBlock2(newone - 1000);
                    } else {
                        frm.blockArea.setNewBlock(newone);
                    }
                    System.arraycopy(mythix.report(), 0, report, 0, 16);

                    timeOne = new Date().getTime();
                    while ((timeTwo - timeOne) < 300) {

                        timeTwo = new Date().getTime();
                    }

                    frm.PtoFrame(report);
                }
                /* end reminder */
            }

            // Compare
            System.arraycopy(report, 0, lastreport, 0, 16);

            // Set My for testing

            // Set Score Text Format
            if ((Arrays.equals(lastreport, report)) & (mythix.checkZeroNumber() == 0)
                    & (mythix.checkMergable() != 0)) {
                frm.displayArea.yourScore.setFont(new java.awt.Font("Dialog", 1, 22));
                frm.displayArea.yourScore.setText("Game Over...");
                frm.displayArea.highestScore.setText("Your Score is:  \n" + "       "
                        + mythix.points);

                if (fileSortable == 1) {
                    highScore.writeYourScore(mythix.points + "--"
                            + frm.displayArea.playerName.getText());
                } else
                    ;

                if (scoreEnable == 1) {
                    highScore.updateHighScore();
                    frm.scoreArea.setOpaqueR(true);
                }

            } else {
                frm.displayArea.yourScore.setFont(new java.awt.Font("Dialog", 1, 40));
                frm.displayArea.yourScore.setHorizontalAlignment(SwingConstants.CENTER);
                frm.displayArea.yourScore.setText("" + mythix.points);
            }
        }
    }
}