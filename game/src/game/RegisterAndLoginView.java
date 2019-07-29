package game;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RegisterAndLoginView extends JPanel {
	JTabbedPane p;
	RegisterView registerView;
	login logview;
	public RegisterAndLoginView() {
		registerView=new RegisterView();
		logview=new login();
		setLayout(new BorderLayout());
		p=new JTabbedPane();
		p.add("×¢²á",registerView);
		p.add("µÇÂ½", logview);
		
		p.validate();
		add(p,BorderLayout.CENTER);
	}
	public boolean isLoginSuccess() {
		return logview.isLoginSuccess();
	}
}
