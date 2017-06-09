package chaos.loo.cn.increace.power;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameArea extends JFrame implements KeyListener, ActionListener {

	int direction = -1;
	int[] initial = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	ControlArea controlArea = new ControlArea();
	ScoreArea scoreArea = new ScoreArea();
	BlockArea blockArea = new BlockArea();
	DisplayArea displayArea = new DisplayArea();

	// Frame Set

	FrameArea() {

		super();

		setLayout(null);
		setSize(342, 516);
		setTitle("4096 " + " LT");

		add(displayArea);
		add(scoreArea, BorderLayout.CENTER);
		add(blockArea, BorderLayout.CENTER);
		add(controlArea);

		this.setSize(342, 516);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.requestFocus();

		controlArea.buttonStart.addActionListener(this);
		controlArea.buttonRestart.addActionListener(this);
		controlArea.buttonClose.addActionListener(this);

		setVisible(true);
	}

	public void PtoFrame(int[] delivery) {

		blockArea.FtoBlock(delivery);

	}

	public int reportDirectionF() {
		direction = blockArea.reportDirectionB();
		return direction;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection() {
		direction = -1;
	}

	public void reFocuse() {

		this.requestFocus();

	}

	// to be written

	public void getScoreArea(FrameArea frm) {

		ScoreArea scoreArea = new ScoreArea();
		frm.add(scoreArea);

	}

	public void setScoreArea(FrameArea frm) {

	}

	public void closeScoreArea(FrameArea frm) {

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.controlArea.buttonStart) {
			this.reFocuse();
		} else if (e.getSource() == this.controlArea.buttonRestart) {

			Process pro = new Process();
			pro.judge = 0;
			pro.beginhere = 0;
			scoreArea.setOpaqueR(false);
			this.reFocuse();

			PtoFrame(initial);

			System.out.println("initial here");

		} else if (e.getSource() == this.controlArea.buttonClose) {
			System.exit(0);
		}

		else
			;

	}

	public void keyPressed(KeyEvent e) {
		Process pro = new Process();
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			direction = 1;
			pro.beginhere = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			direction = 2;
			pro.beginhere = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			direction = 3;
			pro.beginhere = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			direction = 4;
			pro.beginhere = 1;
		} else
			direction = -1;
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

}
