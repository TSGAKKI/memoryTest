package game;

import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Act.Query;

public class showrankList extends JFrame {
	Box boxv;
	// ArrayList<String> list= new ArrayList<>();
	// public showrankList() { }

	public showrankList(String r) throws SQLException {
		if (r == null) {
			String url = "select *  from T_Rank order by Grade ";
			Query query = new Query(url);
			query.startQuery();
			boxv = Box.createVerticalBox();
			for (int i = 0; i < query.getRecord().length; i++) {
				boxv.add(new JLabel(query.getRecord()[i]));
				boxv.add(Box.createVerticalStrut(10));
			}
		} else {
			String url = "select *  from T_Rank where Rank='" + r + "' order by Grade DESC";
			Query query = new Query(url);
			query.startQuery();
			boxv = Box.createVerticalBox();
			for (int i = 0; i < query.getRecord().length; i++) {
				boxv.add(new JLabel(query.getRecord()[i]));
				boxv.add(Box.createVerticalStrut(10));
			}
		}
		add(new ScrollPane().add(boxv));
		// setResizable(false);
		setBounds(200, 200, 400, 400);
		setVisible(true);

	}
}
