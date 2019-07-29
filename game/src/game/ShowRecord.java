package game;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShowRecord extends JDialog {

	int record;
	// public ShowRecord(int record) {
	//// JOptionPane.showMessageDialog(null, "游戏完成:
	// 游戏成绩"+record+"秒","重新登陆",JOptionPane.WARNING_MESSAGE);
	//
	//
	// }

	private JTextField showRecord;

	public ShowRecord(int time) {
		this.showRecord = new JTextField(8);

		this.showRecord.setEditable(false);

		this.showRecord.setHorizontalAlignment(0);

		this.showRecord.setText("所花时间: " + time + "秒");

		add(this.showRecord, "Center");

		setSize(150, 100);

		setLocationRelativeTo(null);

		setVisible(true);
	}

}
