package game;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainView extends JFrame implements ActionListener{
	RegisterAndLoginView view; 
	JButton button;
	public MainView(){
		setBounds(100, 100, 400, 200);
		view=new RegisterAndLoginView();
		button=new JButton("主界面");
		button.addActionListener(this);
		add(view,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
		setTitle("主页");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(view.isLoginSuccess()) {
			this.dispose();
			new MemoryTest();
		}
	}

}
