//DBConn Ŭ������ Ȱ���غ���.
package com.human.ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.human.util.DBConn;

public class JDBCEx_Singleton {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getInstance();  //getInstance()�޼ҵ� ȣ��
		//Connection
		Statement st;
		try {
			st = conn.createStatement();
			int n = st.executeUpdate("insert into person " + "values"   //���� �ʼ�
				+ "(16,'ȫ3',123.23,sysdate,systimestamp)" );   //executeUpdate: int ����.
		
		if(n==1) { //����� ���� 1�� �϶�
			System.out.println("������");
		}else {
			System.out.println("��������");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.dbClose();
		}
		
		
		
	}

}
