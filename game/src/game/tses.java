package game;

import javax.swing.ImageIcon;

public class tses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageIcon i=new ImageIcon(tses.class.getResource("img/a0.jpg"));
		ImageIcon i1=new ImageIcon(tses.class.getResource("img/a0.jpg"));
		if(i==i1) {
			System.out.println("ok");
		}
	}

}
