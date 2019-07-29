package game;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class showrankList extends JFrame {
	Box boxv;
	ArrayList<String> list= new ArrayList<>();
	//public showrankList() {	}
	
	public showrankList(ArrayList<String> list) {
		this.list=list;
		boxv= Box.createVerticalBox();
		for (int i = 0; i < list.size(); i++) {
			boxv.add(new JLabel(list.get(i)));
			boxv.add(Box.createVerticalStrut(10));
		}
		add(new ScrollPane().add(boxv));
		//setResizable(false);
		setBounds(200, 200, 400, 400);
		setVisible(true);
		
	}
}
