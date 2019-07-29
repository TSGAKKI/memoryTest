package game.Act;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import game.SQLserver;

public class Query {
	String SQL;
	Connection con=new SQLserver().getCon();
	String[] record;
	public Query(String url)  throws SQLException {
		SQL=url;
		
		}
	public String[] getRecord() {
		return record;
	}
	
	public void InsertDat() throws SQLException {
		
		//插入语句
		Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stm.executeUpdate(SQL);
	}
	
	public void startQuery() throws SQLException {
	
		
		ResultSet rs;
		//查询语句
		Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=stm.executeQuery(SQL);

		//将游标移到结果集的最后一行
		rs.last();
		//获取结果集中的条数
		int recordAmount = rs.getRow();
		record=new String[recordAmount];
		int i=0;
		//将游标移动到结果集的初始位置
		rs.beforeFirst();
		while(rs.next()) {
			record[i]=rs.getString("Time")+" "+rs.getString("ID")+" "+rs.getString("Grade")+" "+rs.getString("Rank");
			i++;
		}
		
	}
}
