package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import module.MainView;

public class MemoryTest extends JFrame implements ActionListener {

	private JMenuBar bar ;
	private JMenu fileMenu;
	private JMenuItem easyLevel;
	private JMenuItem nomalLevel;
	private JMenuItem hardLevel;
    private	JTextField jTextField;
    private Block[] block;
    private ImageIcon[] icon;
    private MemoryTestPane memoryTestPane;
    private int x=6;
    private int y=5;
    private int iconCount=0;
    private JTextField jText;
	public MemoryTest() {
		easyLevel=new JMenuItem("初级");
		nomalLevel=new JMenuItem("中级");
		hardLevel=new JMenuItem("高级");
		bar=new JMenuBar();
		fileMenu=new JMenu("难度选择");
		fileMenu.add(easyLevel);
		fileMenu.add(nomalLevel);
		fileMenu.add(hardLevel);
		bar.add(fileMenu);
		setJMenuBar(bar);
		jText=new JTextField("初级",16);
		 block = new Block[x * y];
		      
		      for (int i = 0; i < block.length; i++) {
		        block[i] = new Block();
		 }
		      icon=new ImageIcon[y];
		for (int i = 0; i <y; i++) {
			
			icon[i]=new ImageIcon(MemoryTest.class.getResource("img/a" + i + ".jpg"));
		}
		
		
		memoryTestPane=new MemoryTestPane(block, icon, x, y);
		easyLevel.addActionListener(this);
		hardLevel.addActionListener(this);
		nomalLevel.addActionListener(this);
		jText.setHorizontalAlignment(JTextField.CENTER);
		//文本框不可编辑
		jText.setEditable(false);
		//字体颜色
		jText.setForeground(Color.RED);
		//字体居中
		jText.setHorizontalAlignment(JTextField.CENTER);
		
		add(jText,BorderLayout.SOUTH);
		add(memoryTestPane);
		setBounds(200, 200, 500, 500);
		setResizable(false);
		setVisible(true);
		
	}
	public void changeLevel() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==easyLevel)
			
		{	remove(memoryTestPane);
			x=6;
			y=5;
			block = new Block[x * y];
	        for (int i = 0; i < block.length; i++) {
	        block[i] = new Block();
	 }
	        icon=new ImageIcon[y];
	        for (int i = 0; i <y; i++) {
	        	icon[i]=new ImageIcon(MemoryTest.class.getResource("img/a" + i + ".jpg"));
	        	}
	memoryTestPane=new MemoryTestPane(block, icon, x, y);
			jText.setText("当前模式初级");
			add(memoryTestPane);
			
			setBounds(200, 200, 500, 500);
			
	
		}
		else if (e.getSource()==nomalLevel)
		{
			remove(memoryTestPane);
			x=6;
			y=6;
			block = new Block[x * y];
	        for (int i = 0; i < block.length; i++) {
	        block[i] = new Block();
	 }
	        icon=new ImageIcon[y];
	        for (int i = 0; i <y; i++) {
	        	icon[i]=new ImageIcon(MemoryTest.class.getResource("img/a" + i + ".jpg"));
	        	}
	memoryTestPane=new MemoryTestPane(block, icon, x, y);
			jText.setText("当前模式中级");
			add(memoryTestPane);
			setBounds(200, 200, 500, 600);
		}
		else if(e.getSource()==hardLevel)
		{
			remove(memoryTestPane);
			x=6;
			y=7;
			block = new Block[x * y];
	        for (int i = 0; i < block.length; i++) {
	        block[i] = new Block();
	 }
	        icon=new ImageIcon[y];
	        for (int i = 0; i <y; i++) {
	        	icon[i]=new ImageIcon(MemoryTest.class.getResource("img/a" + i + ".jpg"));
	        	}
	memoryTestPane=new MemoryTestPane(block, icon, x, y);
			jText.setText("当前模式高级");
			add(memoryTestPane);
			setBounds(200, 200, 500, 700);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MemoryTest();
	}


}
