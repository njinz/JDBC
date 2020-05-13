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
			Statement st = null;   //client Server �� ������ �ְ������
			ResultSet rs = null;   //����������
		
			try {
				//1.����� DB ����̺� ��� 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2.�ش�DB�� ����
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "human";
				String pw = "human";
				
				//3.���ᰴü ����
				conn = DriverManager.getConnection(url,user,pw);
				st = conn.createStatement();
				rs = st.executeQuery("select * from person");
				
				while(rs.next()) {
					//rs.getInt("no");
					int no = rs.getInt(1);
					String name = rs.getString(2);
					double height = rs.getDouble(3);
					// ���� ! Date import�� java���� �ٷ궧��(java.util.Date), db�� insert�Ҷ� java.sql.Date
					Date birth1 = rs.getDate(4);        // getDate : ��¥ 
					Date birth2 = rs.getTime(4);        // getTime : �ð�
					Date birth3= rs.getTimestamp(4);    // getTimestamp : ��¥ + �ð� + �̸���������� ǥ��
					Date regist = rs.getTimestamp(5);  
					
					System.out.println(no+" / "+name +" / "+height +" / "+birth1 +" / "+birth2 +" / "+birth3+" / "+regist);
					                  //1 / ȫ / 123.23 / 2020-05-13 / 09:17:37 / 2020-05-13 09:17:37.0 / 2020-05-13 09:17:37.55	
					
					
					//Date format �ٲ���.
					DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  //import.��(month)�� �빮��, ��(min)�� �ҹ���
					System.out.println(df.format(birth1));
					System.out.println(df.format(birth2));
					System.out.println(df.format(birth3));
					
					//2020/05/13 12:00:00  ��¥�� �ִ� date �̹Ƿ� �ð��� �ʱⰪ(12:00:00)
					//1970/01/01 09:17:37  �ð��� �ִ� date �̹Ƿ� ��¥�� �ʱⰪ(1970/01/01)
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
