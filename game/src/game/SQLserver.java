package game;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class SQLserver {
	
	String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
		private String user="sa";
		private String password="123456";
		private Connection con=null;
		private PreparedStatement presql;
		private ResultSet rs;
	
		
	 public SQLserver(){	
	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public Connection getCon() {
		 return con;
	 }
	public Loginuser Verify(Loginuser loginModel) {
		String id=loginModel.getID();
		String pw=loginModel.getPassWord();
		String sqlStr="select id,password from T_LOGIN where "+"id = ? and password = ?";

		try {
			presql=con.prepareStatement(sqlStr);
			
			
			presql.setString(1, id);
			presql.setString(2, pw);
			
			try{
				rs=presql.executeQuery();
			}catch(Exception exx) {
				exx.printStackTrace();
			}
			
			if(rs.next()==true) {
				loginModel.setLoginSuccess(true);
				
				
				JOptionPane.showMessageDialog(null, "µÇÂ½³É¹¦","¹§Ï²",JOptionPane.WARNING_MESSAGE);
			}else {
				loginModel.setLoginSuccess(false);
				JOptionPane.showMessageDialog(null, "µÇÂ½Ê§°Ü","ÖØÐÂµÇÂ½",JOptionPane.WARNING_MESSAGE);
			}
			con.close();
		} catch (SQLException e) {}
		return loginModel;
	}
}

	
