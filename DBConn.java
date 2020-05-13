package com.human.util;
//여러명이서 작업할수 있도록 만들어보자. 
//반복되는 작업 (db 연결 - 작업 - db 닫아주기) 중복을 없애고자 함수로 만듦.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	//.getInstance() : 싱글턴 . 하나의 객체만 생성가능
	//new DBconn(); 
	private DBConn() {}; //외부에서 호출불가하도록 private
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
