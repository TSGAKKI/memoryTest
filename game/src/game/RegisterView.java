package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public RegisterView() {
		// TODO Auto-generated constructor stub
		register=new Register();
		inputID=new JTextField(12);
		inputBRBH=new JTextField(12);
		inputPassword=new JPasswordField(12);
		confirm=new JPasswordField(12);
		buttonRegister=new JButton("ע��");
		add(new JLabel("ID"));
		add(inputID);
		add(new JLabel("���˱��(3λ�����)"));
		add(inputBRBH);
		add(new JLabel("����"));
		add(inputPassword);
		add(new JLabel("ȷ������"));
		add(confirm);
		add(buttonRegister);
		buttonRegister.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		char[] pw=inputPassword.getPassword();
		char[] conf=confirm.getPassword();
		if(pw.equals(conf)) {
			JOptionPane.showMessageDialog(null, "�������벻һ��","����",JOptionPane.WARNING_MESSAGE);
		}
		else {
			register.setPassword(new String(pw));
			register.setID(inputID.getText());
			register.setBRBH(inputBRBH.getText());
			new RegisterData().writeRegister(register);
		}
	}

}
