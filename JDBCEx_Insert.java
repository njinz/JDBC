package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCEx_Insert {

	public static void main(String[] args) {
		//INSERT
		Connection conn = null;  
		Statement st = null;   //client Server 간 데이터 주고받을때
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "human";
			String pw = "human";
			conn = DriverManager.getConnection(url,user,pw);
			st = conn.createStatement();
			
			//프로그램에서는 auto commit이 기본값이다.
			int n = st.executeUpdate("insert into person " + "values"   //띄어쓰기 필수
					+ "(10,'홍1',123.23,sysdate,systimestamp)");   //executeUpdate: int를 리턴한다.
			
			
			if(n==1) { //변경된 갯수 1개 일때
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
				}
			
			n = st.executeUpdate("delete from person " + "where no=2");  //띄어쓰기 필수
					
			if(n>0) { 
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
				}
			
			
			n = st.executeUpdate("update person " + "set name ='강' "+ "where no=1");  //띄어쓰기 필수
			
			if(n>0) { 
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
				}
			
			}
			
		
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			
		}


	}

}
