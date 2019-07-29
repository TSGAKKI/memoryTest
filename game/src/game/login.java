package game;

import javax.swing.*;



import java.awt.*;   //导入必要的包
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
  

  public class login extends JPanel implements ActionListener{
     JTextField jTextField ;//定义文本框组件
     JPasswordField jPasswordField;//定义密码框组件
     JButton jb1; //创建按钮
    Loginuser log;
    boolean loginSuccess;
     
     public login(){
    	 log=new Loginuser(); 
         jTextField = new JTextField(12);
        jPasswordField = new JPasswordField(13);
        jb1 = new JButton("确认");
       
         add(new JLabel("ID: "));
         add(jTextField);
         add(new JLabel("密码: "));
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
		
		SQLserver sqls=new SQLserver();//SQL验证
		log=sqls.Verify(log);
		loginSuccess=log.getLoginSuccess();
	
	}   
 }
  

