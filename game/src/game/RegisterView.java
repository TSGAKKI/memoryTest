package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class RegisterView extends JPanel implements ActionListener {
	
	Register register;
	
	JTextField inputID,inputBRBH;
	JPasswordField inputPassword,confirm;
	JButton buttonRegister;
	Box boxv;
	Box boxh1,boxh2;
	
	public RegisterView() {
		// TODO Auto-generated constructor stub
		boxv=Box.createVerticalBox();
		boxh1=Box.createHorizontalBox();
		boxh2=Box.createHorizontalBox();
		register=new Register();
		inputID=new JTextField(12);
		inputBRBH=new JTextField(12);
		inputPassword=new JPasswordField(12);
		confirm=new JPasswordField(12);
		buttonRegister=new JButton("注册");
		
		boxh1.add(new JLabel("ID"));
		boxh1.add(Box.createHorizontalStrut(10));
		boxh1.add(inputID);
		boxh1.add(Box.createHorizontalStrut(30));

		boxh1.add(new JLabel("病人编号(3位随机数)"));
		boxh1.add(Box.createHorizontalStrut(10));
		boxh1.add(inputBRBH);
		
		boxh2.add(new JLabel("密码"));
		boxh2.add(Box.createHorizontalStrut(10));
		boxh2.add(inputPassword);
		boxh2.add(Box.createHorizontalStrut(10));
		boxh2.add(new JLabel("确认密码"));
		boxh2.add(Box.createHorizontalStrut(10));
		boxh2.add(confirm);
		boxv.add(boxh1);
		boxv.add(Box.createVerticalStrut(10));
		boxv.add(boxh2);
		boxv.add(Box.createVerticalStrut(10));
		boxv.add(buttonRegister);
		add(boxv);
		buttonRegister.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		char[] pw=inputPassword.getPassword();
		char[] conf=confirm.getPassword();
		if(pw.equals(conf)) {
			JOptionPane.showMessageDialog(null, "两次密码不一致","警告",JOptionPane.WARNING_MESSAGE);
		}
		else {
			register.setPassword(new String(pw));
			register.setID(inputID.getText());
			register.setBRBH(inputBRBH.getText());
			new RegisterData().writeRegister(register);
		}
	}

}
