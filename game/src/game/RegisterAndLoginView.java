package game;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


class showbg extends JPanel{
	RegisterAndLoginView v= new RegisterAndLoginView();
	public showbg() {
		  
		 add(v);
		 
		 // TODO Auto-generated constructor stub
		 repaint();
	 }
  protected void paintComponent(Graphics g){//重写paintComponent方法以实现jPanel加背景
      super.paintComponent(g);                             
      ImageIcon image=new ImageIcon(getClass().getResource("a1.jpg"));        //获取图像
      image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_FAST)); //调整图像的分辨率以适应容器     
      image.paintIcon(this, g,0, 0);
  }          
}

public class RegisterAndLoginView extends JPanel {
	JTabbedPane p;
	RegisterView registerView;
	login logview;
	public RegisterAndLoginView() {
		registerView=new RegisterView();
		logview=new login();
		setLayout(new BorderLayout());
		p=new JTabbedPane();
		p.add("注册",registerView);
		p.add("登陆", logview);
		
		p.validate();
		add(p,BorderLayout.CENTER);
	}
	public boolean isLoginSuccess() {
		return logview.isLoginSuccess();
	}
}
