//DBConn 클래스를 활용해보자.
package com.human.ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.human.util.DBConn;

public class JDBCEx_Singleton {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getInstance();  //getInstance()메소드 호출
		//Connection
		Statement st;
		try {
			st = conn.createStatement();
			int n = st.executeUpdate("insert into person " + "values"   //띄어쓰기 필수
				+ "(16,'홍3',123.23,sysdate,systimestamp)" );   //executeUpdate: int 리턴.
		
		if(n==1) { //변경된 갯수 1개 일때
			System.out.println("정상동작");
		}else {
			System.out.println("비정상동작");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.dbClose();
		}
		
		
		
	}

}
