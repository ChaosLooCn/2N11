package chaos.loo.cn.increace.power;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class HighScoreFile {

	String scoreFilePath = this.getClass().getResource("").getPath() + "log/high score";
	static String[] scoreRecord = new String[6];

	HighScoreFile() {
		File highScore = new File(scoreFilePath);

		if (!highScore.exists()) {
			System.out.println(highScore.exists());

			try {
				highScore.createNewFile();
			} catch (Exception e) {
				System.out.println("file .");
			}
		}

		updateHighScore();
	}

	public String getScoreRecord(int line) {

		return scoreRecord[line];
	}

	public void scoreSort() {

		List<MyScoreRecord> sSort = new ArrayList();
		Pattern p = Pattern.compile("\\D+");

		sSort.add(new MyScoreRecord(scoreRecord[0]));
		sSort.add(new MyScoreRecord(scoreRecord[1]));
		sSort.add(new MyScoreRecord(scoreRecord[2]));
		sSort.add(new MyScoreRecord(scoreRecord[3]));
		sSort.add(new MyScoreRecord(scoreRecord[4]));
		sSort.add(new MyScoreRecord(scoreRecord[5]));

		Collections.sort(sSort);

		StringBuilder sb = new StringBuilder();

		for (MyScoreRecord sr : sSort) {
			scoreRecord[sSort.indexOf(sr)] = sr.toString();
		}

	}

	public void writeYourScore(String yourScore) {

		try {

			scoreRecord[5] = yourScore;

			scoreSort();

			File highScore = new File(scoreFilePath);
			highScore.delete();
			try {
				highScore.createNewFile();
			} catch (Exception e) {
				System.out.println("file .");
			}

			FileReader fReader = new FileReader(scoreFilePath);
			BufferedReader bReader = new BufferedReader(fReader);

			FileWriter fWriter2 = new FileWriter(scoreFilePath, true);
			fWriter2.write("");
			fWriter2.close();

			FileWriter fWriter = new FileWriter(scoreFilePath, true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			PrintWriter pWriter = new PrintWriter(bWriter);

			for (int i = 0; i < 5; i++) {
				pWriter.println(scoreRecord[i]);
			}

			bReader.close();
			fReader.close();
			pWriter.close();
			bWriter.close();
			fWriter.close();

			Process pro = new Process();
			pro.fileSortable = 0;

		} catch (IOException e) {
		}
	}

	public void updateHighScore() {
		try {

			FileReader fReader = new FileReader(scoreFilePath);
			BufferedReader bReader = new BufferedReader(fReader);

			for (int i = 0; i < 5; i++) {

				scoreRecord[i] = bReader.readLine();
				if ((scoreRecord[i] == null) | (scoreRecord[i] == "\n"))
					scoreRecord[i] = "0--null";
				else
					;
				System.out.println("scoreRecord[i]  " + scoreRecord[i]);
			}

			bReader.close();
			fReader.close();

		} catch (IOException e) {
		}
	}

	public void deleteLastSR() {

	}

}

// scoreRecord comparable
class MyScoreRecord implements Comparable<MyScoreRecord> {

	String content = new String();

	MyScoreRecord() {
	}

	MyScoreRecord(String content) {
		this.content = content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int compareTo(MyScoreRecord another) {
		Pattern p = Pattern.compile("\\D+");
		if ((Integer.parseInt(p.split(this.content)[0])) > (Integer.parseInt(p.split(another.content)[0]))) {
			return -1;
		} else if ((Integer.parseInt(p.split(this.content)[0])) < (Integer.parseInt(p.split(another.content)[0]))) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {

		return content;
	}

}
