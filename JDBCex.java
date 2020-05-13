package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCex {

	public static void main(String[] args) {
		Connection con=null;
		Statement st =null;
		ResultSet rs= null;
		
		try {
			//1.드라이버 로딩 ( DB등록: 어떤 dB쓸건지) ex) 어떤 폰 쓸건지 결정
			Class.forName("oracle.jdbc.driver.OracleDriver");//패키지명,클래스명(OracleDriver)
			System.out.println("드라이버 로딩완료");
			
			//2.DB연결 : url,user,pw 필요
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //제품명(thin):해당 db가 있는 위치-자기컴퓨터(local host):port번호:sid id)
			String user = "human";
			String pw = " human";                                //ex)누구에게 전화할건지
			
			con = DriverManager.getConnection(url,user,pw);  //try catch 2번째 메뉴
			System.out.println("데이터베이스 접속 성공");
			
			 st = con.createStatement(); //import sql  
			 rs = st.executeQuery(
					"select * from member");  //쿼리문의 결과 data담을곳에 쿼리문을 작성한다.
			
			while(rs.next()) {
				int no = rs.getInt(1); //해당 칼럼 번호 1부터 시작 . 해당 칼럼명을 문자로 넣어도 됨.
				String hp = rs.getString("hp");
				String addr = rs.getString(3);
				String name = rs.getString(4);
				
				
				System.out.println(no + ":" + name + ":" +hp + ":" + addr);
			}
			
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
					try {
						if(rs!=null)rs.close();
						if(st!=null)st.close();
						if(con!=null)con.close(); // 예외처리 후 역순으로 닫아준다.
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			}
		
		
			
			
			
		
		
		
		
		
		
	}

}
