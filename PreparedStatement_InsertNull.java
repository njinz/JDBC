package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class PreparedStatement_InsertNull {

	public static void main(String[] args) throws Exception {
		String sql = "insert into person values(?,?,?,?)";
		Connection conn =null;
		PreparedStatement pst = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		System.out.println("���� �Ϸ�!!!");

		conn = DriverManager.getConnection(url,"scott","1234");
		pst = conn.prepareStatement(sql);
		//preparedStatement setNull(pindex, Types.INTEGER)
		//������ Ÿ���� null�� ����:java.sql.Types.INTEGER
		//�Ǽ��� Ÿ���� null�� ����:java.sql.Types.DOUBLE
		//������ Ÿ���� null�� ����:java.sql.Types.NUMERIC
		//������ Ÿ���� null�� ����:java.sql.Types.VARCHAR / setString(pindex, null)

		pst.setNull(1, Types.INTEGER);
		pst.setString(2, null); //pst.setNull(2,Types.VARCHAR)
		pst.setNull(3, Types.DOUBLE);
		pst.setNull(4, Types.DATE);
		pst.executeUpdate();

		if(conn !=null) conn.close();
		if(pst !=null) pst.close();

		}

		}


