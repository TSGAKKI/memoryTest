package game;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShowRecord extends JDialog {

	int record;
	// public ShowRecord(int record) {
	//// JOptionPane.showMessageDialog(null, "��Ϸ���:
	// ��Ϸ�ɼ�"+record+"��","���µ�½",JOptionPane.WARNING_MESSAGE);
	//
	//
	// }

	private JTextField showRecord;

	public ShowRecord(int time) {
		this.showRecord = new JTextField(8);

		this.showRecord.setEditable(false);

		this.showRecord.setHorizontalAlignment(0);

		this.showRecord.setText("����ʱ��: " + time + "��");

		add(this.showRecord, "Center");

		setSize(150, 100);

		setLocationRelativeTo(null);

		setVisible(true);
	}

}
