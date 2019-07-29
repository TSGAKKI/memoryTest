package game;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShowRecord extends JDialog{

	int record;
//	public ShowRecord(int record) {
////		JOptionPane.showMessageDialog(null, "游戏完成: 游戏成绩"+record+"秒","重新登陆",JOptionPane.WARNING_MESSAGE);
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
	  /* 33 */     this.showRecord.setText("所花时间: " + time + "秒");
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
