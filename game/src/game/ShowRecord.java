package game;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShowRecord extends JDialog{

	int record;
//	public ShowRecord(int record) {
////		JOptionPane.showMessageDialog(null, "��Ϸ���: ��Ϸ�ɼ�"+record+"��","���µ�½",JOptionPane.WARNING_MESSAGE);
//		
//		
//	}
	
	  private JTextField showRecord;
	  /*    */   
	  /*    */   public ShowRecord(int time) {
	  /* 27 */     this.showRecord = new JTextField(8);
	  /*    */     
	  /* 29 */     this.showRecord.setEditable(false);
	  /*    */     
	  /* 31 */     this.showRecord.setHorizontalAlignment(0);
	  /*    */     
	  /* 33 */     this.showRecord.setText("����ʱ��: " + time + "��");
	  /*    */     
	  /* 35 */     add(this.showRecord, "Center");
	  /*    */     
	  /* 37 */     setSize(150, 100);
	  /*    */     
	  /* 39 */     setLocationRelativeTo(null);
	  /*    */     
	  /* 41 */     setVisible(true);
	  /*    */   }
	
}
