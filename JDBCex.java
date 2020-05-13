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
			//1.����̹� �ε� ( DB���: � dB������) ex) � �� ������ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű����,Ŭ������(OracleDriver)
			System.out.println("����̹� �ε��Ϸ�");
			
			//2.DB���� : url,user,pw �ʿ�
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //��ǰ��(thin):�ش� db�� �ִ� ��ġ-�ڱ���ǻ��(local host):port��ȣ:sid id)
			String user = "human";
			String pw = " human";                                //ex)�������� ��ȭ�Ұ���
			
			con = DriverManager.getConnection(url,user,pw);  //try catch 2��° �޴�
			System.out.println("�����ͺ��̽� ���� ����");
			
			 st = con.createStatement(); //import sql  
			 rs = st.executeQuery(
					"select * from member");  //�������� ��� data�������� �������� �ۼ��Ѵ�.
			
			while(rs.next()) {
				int no = rs.getInt(1); //�ش� Į�� ��ȣ 1���� ���� . �ش� Į������ ���ڷ� �־ ��.
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
						if(con!=null)con.close(); // ����ó�� �� �������� �ݾ��ش�.
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			}
		
		
			
			
			
		
		
		
		
		
		
	}

}
