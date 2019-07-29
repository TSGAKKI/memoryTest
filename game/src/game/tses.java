package game;

import java.sql.SQLException;

import javax.swing.ImageIcon;

import game.Act.Query;

public class tses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String r="³õ";
		//String url="select *  from T_Rank order by Grade";
		String url="select *  from T_Rank where Rank='"+r+"' order by Grade DESC";
		try {
			Query query=new Query(url);
			System.out.println(query.getRecord()[0]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
