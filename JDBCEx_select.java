package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCEx_select {

	public static void main(String[] args) {
			Connection conn = null;  
			Statement st = null;   //client Server 간 데이터 주고받을때
			ResultSet rs = null;   //쿼리실행결과
		
			try {
				//1.사용할 DB 드라이브 등록 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2.해당DB에 접속
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "human";
				String pw = "human";
				
				//3.연결객체 생성
				conn = DriverManager.getConnection(url,user,pw);
				st = conn.createStatement();
				rs = st.executeQuery("select * from person");
				
				while(rs.next()) {
					//rs.getInt("no");
					int no = rs.getInt(1);
					String name = rs.getString(2);
					double height = rs.getDouble(3);
					// 주의 ! Date import시 java에서 다룰때는(java.util.Date), db에 insert할땐 java.sql.Date
					Date birth1 = rs.getDate(4);        // getDate : 날짜 
					Date birth2 = rs.getTime(4);        // getTime : 시간
					Date birth3= rs.getTimestamp(4);    // getTimestamp : 날짜 + 시간 + 미리세컨즈까지 표시
					Date regist = rs.getTimestamp(5);  
					
					System.out.println(no+" / "+name +" / "+height +" / "+birth1 +" / "+birth2 +" / "+birth3+" / "+regist);
					                  //1 / 홍 / 123.23 / 2020-05-13 / 09:17:37 / 2020-05-13 09:17:37.0 / 2020-05-13 09:17:37.55	
					
					
					//Date format 바꿔줌.
					DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  //import.월(month)는 대문자, 분(min)은 소문자
					System.out.println(df.format(birth1));
					System.out.println(df.format(birth2));
					System.out.println(df.format(birth3));
					
					//2020/05/13 12:00:00  날짜만 있는 date 이므로 시간은 초기값(12:00:00)
					//1970/01/01 09:17:37  시간만 있는 date 이므로 날짜는 초기값(1970/01/01)
					//2020/05/13 09:17:37
					
				}
			}
			
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
			catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
					try {
						if(rs!=null)rs.close();
						if(st!=null)st.close();
						if(conn!=null)conn.close();
					
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}
}
