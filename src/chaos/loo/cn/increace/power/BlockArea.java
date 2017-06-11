package chaos.loo.cn.increace.power;

import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlockArea extends JPanel {
	JLabel[] blocks = new JLabel[16];
	final ImageIcon[] img = new ImageIcon[13];
	final ImageIcon[] imgN = new ImageIcon[13];
	int[] recieve = new int[16];
	int direction = -1;

	BlockArea() {
		super();

		setLayout(null);
		setBounds(0, 160, 335, 318);
		setBackground(new Color(20, 20, 20));

		setImage();

		resetBlocks(blocks);

		for (int i = 0; i < 16; i++) {
			add(blocks[i]);
		}

		GridLayout grid = new GridLayout(4, 4);
		setLayout(grid);

	}

	public void setImage() {

		for (int i = 0; i < 13; i++) {
			URL imageURL = this.getClass().getResource("pict/P" + i + ".png");
			ImageIcon image = new ImageIcon(imageURL);
			img[i] = image;
		}

		for (int i = 0; i < 2; i++) {
			URL imageURL = this.getClass().getResource("pict/N" + i + ".png");
			ImageIcon image = new ImageIcon(imageURL);
			imgN[i] = image;
		}
	}

	public void resetBlocks(JLabel[] blocks) {
		for (int i = 0; i < 16; i++) {
			blocks[i] = new JLabel();
			blocks[i].setIcon(img[0]);
		}

	}

	public void FtoBlock(int[] delivery) {

		recieve = delivery;
		updateBlocks();

	}

	public void updateBlocks() {

		for (int j = 0; j < 16; j++) {

			blocks[j].setIcon(img[recieve[j]]);
		}
	}

	public void setNewBlock(int newone) {
		blocks[newone].setIcon(imgN[0]); 

	}

	public void setNewBlock2(int newone) {
		blocks[newone].setIcon(imgN[1]);

	}

	public int reportDirectionB() {

		return direction;
	}

}
