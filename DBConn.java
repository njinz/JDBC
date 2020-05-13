package com.human.util;
//�������̼� �۾��Ҽ� �ֵ��� ������. 
//�ݺ��Ǵ� �۾� (db ���� - �۾� - db �ݾ��ֱ�) �ߺ��� ���ְ��� �Լ��� ����.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	//.getInstance() : �̱��� . �ϳ��� ��ü�� ��������
	//new DBconn(); 
	private DBConn() {}; //�ܺο��� ȣ��Ұ��ϵ��� private
	private static Connection dbConn = null;
	public static Connection getInstance() {
		if(dbConn==null) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "human";
				String pw = "human";
				dbConn = DriverManager.getConnection(url,user,pw);
			}
				
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
			catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			
			if(dbConn!=null)dbConn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConn=null;
		}
	}
}
