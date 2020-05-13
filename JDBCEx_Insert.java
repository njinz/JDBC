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
		Statement st = null;   //client Server �� ������ �ְ������
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "human";
			String pw = "human";
			conn = DriverManager.getConnection(url,user,pw);
			st = conn.createStatement();
			
			//���α׷������� auto commit�� �⺻���̴�.
			int n = st.executeUpdate("insert into person " + "values"   //���� �ʼ�
					+ "(10,'ȫ1',123.23,sysdate,systimestamp)");   //executeUpdate: int�� �����Ѵ�.
			
			
			if(n==1) { //����� ���� 1�� �϶�
				System.out.println("������");
			}else {
				System.out.println("��������");
				}
			
			n = st.executeUpdate("delete from person " + "where no=2");  //���� �ʼ�
					
			if(n>0) { 
				System.out.println("������");
			}else {
				System.out.println("��������");
				}
			
			
			n = st.executeUpdate("update person " + "set name ='��' "+ "where no=1");  //���� �ʼ�
			
			if(n>0) { 
				System.out.println("������");
			}else {
				System.out.println("��������");
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
