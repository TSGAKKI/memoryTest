package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Block extends JButton implements ActionListener {
	
	private ImageIcon openedIcon;
	
	public Block() {
		//grid
		addActionListener(this);
	
	}
	
//	 public void setIcon(ImageIcon icon) { setIcon(icon); }
	
	public  ImageIcon getOpenedIcon() {
		return openedIcon;
	}
	
 public void setOpenedIcon(ImageIcon openedIcon) {
		this.openedIcon = openedIcon;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("second");
		setIcon(getOpenedIcon());
	}

}
