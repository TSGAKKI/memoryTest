package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MemoryTestPane extends JPanel implements ActionListener{
	private JMenuBar bar ;
	private JMenu fileMenu;
	private JMenuItem easyLevel;
	private JMenuItem nomalLevel;
	private JMenuItem hardLevel;
	Block block[];
	ImageIcon icon[];
	LinkedList blockList,iconList;
	int success;
	int time;
	Timer timer;
	JTextField showTime;
	boolean timerIsStar=false;
	int x=0;
	int y=0;
	
	public  MemoryTestPane(Block block[],ImageIcon icon[],int x,int y) {
		easyLevel=new JMenuItem("初级");
		nomalLevel=new JMenuItem("中级");
		hardLevel=new JMenuItem("高级");
		bar=new JMenuBar();
		fileMenu=new JMenu("难度选择");
		fileMenu.add(easyLevel);
		fileMenu.add(nomalLevel);
		fileMenu.add(hardLevel);
		bar.add(fileMenu);
		this.add(bar,BorderLayout.NORTH);
		
		this.block = block;
		    
	   this.icon = icon;
	    
		    this.x = x;
		      
		      this.y = y;
		    
		     this.blockList = new LinkedList();
		     
		     this.iconList = new LinkedList();
		     
		     setLayout(new BorderLayout());
		     
		  JPanel center = new JPanel();
		     
		     center.setLayout(new GridLayout(x, y));
		     
		      for (int i = 0; i < block.length; i++) {
	       center.add(block[i]);
		      
		       block[i].addActionListener(this);
	   } 
		      
		    JPanel south = new JPanel();
		     
		     this.showTime = new JTextField(30);
		    
		     this.showTime.setEditable(false);
		     
		     this.showTime.setForeground(Color.red);
		    
		     this.showTime.setHorizontalAlignment(0);
		      
		    south.add(this.showTime);
		    
	     add(center, "Center");
		    
		      add(south, "South");
		     
		      randomSetIcons(block, icon,y);
		     
		     timer = new Timer(1000,this);
		     
		     timerIsStar = false;
	
	}
	public void randomSetIcons(Block[] block, ImageIcon[] icon,int y) {//顺序执行block给顺序的block随机赋值
		//Collections.shuffle(list);    
		//或者在一个数组内经行一个顺序数组乱序1-30,
		
		List<Integer> list = new ArrayList<Integer>();
	    
		 for (int i = 0; i < icon.length; i++) {
			 for (int j = 0; j < y; j++) {
				list.add(i);
			}
		}
		 Collections.shuffle(list);
		
		 for (int i = 0; i < list.size(); i++) {
			block[i].setOpenedIcon(icon[list.get(i)]);;
		
		}
		  }
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof Block) {
			      
			       Block blockTemp = (Block)e.getSource();
			
			       ImageIcon openedIcon = blockTemp.getOpenedIcon();
			      
			       if (this.iconList.size() == 0) {
			     
		        this.iconList.add(openedIcon);
		         
		        this.blockList.add(blockTemp);
		      
		         this.success = 1;
			    
			      }
			    else {
			         
		         ImageIcon iconTemp = (ImageIcon)this.iconList.getLast();
			        
			        if (iconTemp == openedIcon && !this.blockList.contains(blockTemp)) {
		           
			           this.success++;
			           
			          this.iconList.add(openedIcon);
			          
			          this.blockList.add(blockTemp);
			          
			           if (this.success == this.x)
			          {
			           for (int i = 0; i < this.block.length; i++)
			             {
			              this.block[i].setEnabled(false);
			           }
			            
			            for (int i = 0; i < this.blockList.size(); i++) {
			             Block b = (Block)this.blockList.get(i);
			               
		              b.setDisabledIcon(b.getOpenedIcon());
			          } 
			            
			             this.timer.stop();
			          
			        }
			 
			        
			        }
			         else if (iconTemp != openedIcon) {
			          
		           this.iconList.clear();
			          
			         this.blockList.clear();
			           
		           this.iconList.add(openedIcon);
			         
		          this.blockList.add(blockTemp);
			           
			           this.success = 1;
			           
			          for (int i = 0; i < this.block.length; i++) {
			           if (blockTemp != this.block[i])
			             {
			               this.block[i].setIcon(null);
			             }
			           } 
			         } 
			      } 
	       
			     if (!this.timerIsStar) {
			       
		         this.time = 0;
			         
			         this.timer.start();
			        
			         this.timerIsStar = true;
			     } 
			     } 
			    
			    if (e.getSource() == this.timer) {
			       this.time++;
			    this.showTime.setText("您的用时" + this.time + " 秒");
			    }
	}
	
}
