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
	private JMenu rankMenu;
	private JMenuItem easyLevel;
	private JMenuItem nomalLevel;
	private JMenuItem hardLevel;
	private JMenuItem Allrank;
	private JMenuItem easyrank;
	private JMenuItem nomalrank;
	private JMenuItem hardrank;
    private	JTextField jTextField;
    private Block[] block;
    private ImageIcon[] icon;
    private MemoryTestPane memoryTestPane;
    private int x=5;//5ͼƬ
    private int y=6;//6���
    private int iconCount=0;
    private JTextField jText;
	public MemoryTest() {
		easyLevel=new JMenuItem("����");
		nomalLevel=new JMenuItem("�м�");
		hardLevel=new JMenuItem("�߼�");
		Allrank=new JMenuItem("����");
		easyrank=new JMenuItem("���Ѷ�����");
		nomalrank=new JMenuItem("��ͨ�Ѷ�����");
		hardrank=new JMenuItem("�����Ѷ�����");
		bar=new JMenuBar();
		fileMenu=new JMenu("�Ѷ�ѡ��");
		fileMenu.add(easyLevel);
		fileMenu.add(nomalLevel);
		fileMenu.add(hardLevel);
		rankMenu=new JMenu("���а�");
		rankMenu.add(Allrank);
		rankMenu.add(easyrank);
		rankMenu.add(nomalrank);
		rankMenu.add(hardrank);
		bar.add(fileMenu);
		bar.add(rankMenu);
		setJMenuBar(bar);
		jText=new JTextField("����",16);
		 block = new Block[x * y];
		      
		      for (int i = 0; i < block.length; i++) {
		        block[i] = new Block();
		 }
		      icon=new ImageIcon[x];
		for (int i = 0; i <x; i++) {
			
			icon[i]=new ImageIcon(MemoryTest.class.getResource("img/a" + i + ".jpg"));
		}
		
		
		memoryTestPane=new MemoryTestPane(block, icon, x, y);
		Allrank.addActionListener(this);
		easyrank.addActionListener(this);
		nomalrank.addActionListener(this);
		hardrank.addActionListener(this);
		easyLevel.addActionListener(this);
		hardLevel.addActionListener(this);
		nomalLevel.addActionListener(this);
		jText.setHorizontalAlignment(JTextField.CENTER);
		//�ı��򲻿ɱ༭
		jText.setEditable(false);
		//������ɫ
		jText.setForeground(Color.RED);
		//�������
		jText.setHorizontalAlignment(JTextField.CENTER);
		
		add(jText,BorderLayout.SOUTH);
		add(memoryTestPane);
		setBounds(200, 200, 500, 500);
		setResizable(false);
		setVisible(true);
		
	}
	public void changeLevel(int x,int y) {
		
		block = new Block[x * y];
        for (int i = 0; i < block.length; i++) {
        block[i] = new Block();
 }
        icon=new ImageIcon[x];
        for (int i = 0; i <x; i++) {
        	icon[i]=new ImageIcon(MemoryTest.class.getResource("img/a" + i + ".jpg"));
        	}
        remove(memoryTestPane);
memoryTestPane=new MemoryTestPane(block, icon, x, y);
		
		
		add(memoryTestPane);
		validate();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==Allrank) {
			ranklist show=new ranklist();
			showrankList showrank=new showrankList(show.getrankArray());
			//System.out.println(show.getrankArray());
		}
		
		else if(e.getSource()==easyrank) {
			ranklist show=new ranklist(0);
			showrankList showrank=new showrankList(show.getrankArray());
			//System.out.println(show.getrankArray());
		}
		else if(e.getSource()==nomalrank) {
			ranklist show=new ranklist(1);
			showrankList showrank=new showrankList(show.getrankArray());
			//System.out.println(show.getrankArray());
		}
		else if(e.getSource()==hardrank) {
			ranklist show=new ranklist(2);
			showrankList showrank=new showrankList(show.getrankArray());
			//System.out.println(show.getrankArray());
		}
		if(e.getSource()==easyLevel)
			
		{	
			changeLevel(5, 6);
			jText.setText("��ǰģʽ����: �ҵ�6��");
			this.setBounds(200, 200, 500, 500);
	
		}
		else if (e.getSource()==nomalLevel)
		{
			changeLevel(6, 7);
			jText.setText("��ǰģʽ�м�: �ҵ�7��");
			setBounds(200, 200, 600, 600);
		}
		else if(e.getSource()==hardLevel)
		{
			changeLevel(7, 8);
			jText.setText("��ǰģʽ�߼�: �ҵ�8��");
			setBounds(200, 200, 700, 700);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MemoryTest();
	}


}
