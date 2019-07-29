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
  protected void paintComponent(Graphics g){//��дpaintComponent������ʵ��jPanel�ӱ���
      super.paintComponent(g);                             
      ImageIcon image=new ImageIcon(getClass().getResource("a1.jpg"));        //��ȡͼ��
      image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_FAST)); //����ͼ��ķֱ�������Ӧ����     
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
		p.add("ע��",registerView);
		p.add("��½", logview);
		
		p.validate();
		add(p,BorderLayout.CENTER);
	}
	public boolean isLoginSuccess() {
		return logview.isLoginSuccess();
	}
}
