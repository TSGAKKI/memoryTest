package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class ranklist {
	private int ranking;
	private ArrayList<String> rankArray = new ArrayList<>();

	public ranklist() {
		this.rankArray = readFile();
	}

	public ranklist(int ranking) {
		this.ranking = ranking;
		showList();
	}

	public ArrayList<String> getrankArray() {
		return this.rankArray;
	}

	public void showList() {

		if (ranking == 0) {
			List<String> list = readFile();
			for (String line : list) {
				if (line.matches(".*初级.*")) {
					rankArray.add(line);
				}
			}
		}
		else if (ranking == 1) {
			List<String> list = readFile();
			for (String line : list) {
				if (line.matches(".*中级.*")) {
					rankArray.add(line);
				}
			}
		}
		else if (ranking == 2) {
			List<String> list = readFile();
			for (String line : list) {
				if (line.matches(".*高级.*")) {
					rankArray.add(line);
				}
			}
		}
	}

	public ArrayList<String> readFile() {
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("D:/javadata/score.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
