package game;

import javax.swing.*;



import java.awt.*;   //�����Ҫ�İ�
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
  

  public class login extends JPanel implements ActionListener{
     JTextField jTextField ;//�����ı������
     JPasswordField jPasswordField;//������������
     JButton jb1; //������ť
    Loginuser log;
    boolean loginSuccess;
     
     public login(){
    	 log=new Loginuser(); 
         jTextField = new JTextField(12);
        jPasswordField = new JPasswordField(13);
        jb1 = new JButton("ȷ��");
       
         add(new JLabel("ID: "));
         add(jTextField);
         add(new JLabel("����: "));
         add(jPasswordField);
         add(jb1);
         jb1.addActionListener(this);     
     }
     public boolean isLoginSuccess() {
    	 return loginSuccess;
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		log.setID(jTextField.getText());
		char[] pw=jPasswordField.getPassword();
		log.setPassWord(new String (pw));
		
		SQLserver sqls=new SQLserver();//SQL��֤
		log=sqls.Verify(log);
		loginSuccess=log.getLoginSuccess();
	
	}   
 }
  

