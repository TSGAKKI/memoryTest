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
		
		//�������
		Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stm.executeUpdate(SQL);
	}
	
	public void startQuery() throws SQLException {
	
		
		ResultSet rs;
		//��ѯ���
		Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=stm.executeQuery(SQL);

		//���α��Ƶ�����������һ��
		rs.last();
		//��ȡ������е�����
		int recordAmount = rs.getRow();
		record=new String[recordAmount];
		int i=0;
		//���α��ƶ���������ĳ�ʼλ��
		rs.beforeFirst();
		while(rs.next()) {
			record[i]=rs.getString("Time")+" "+rs.getString("ID")+" "+rs.getString("Grade")+" "+rs.getString("Rank");
			i++;
		}
		
	}
}
