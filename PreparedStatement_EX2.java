package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatement_EX2 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		Connection conn = DriverManager.getConnection(url, "scott","1234");
		System.out.println("접속 성공!!!");

		// Statement stmt = conn.createStatement();
		String sql="insert into member values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, Integer.parseInt(args[0])); //no
		ps.setString(2, args[1]);
		ps.setString(3, args[2]);
		ps.setString(4, args[3]);

		// int n = stmt.executeUpdate(sql);

		int n = ps.executeUpdate();

		System.out.println(n+"개의 로우 변경");

		if(ps !=null) ps.close();
		if(conn !=null) conn.close();

		}

		}
