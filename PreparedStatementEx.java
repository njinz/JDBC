package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementEx {
	public static void main(String[] args) throws Exception {
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  String url="jdbc:oracle:thin:@localhost:1521:orcl";
		  Connection conn = DriverManager.getConnection(url,"scott","1234");
		  
		  System.out.println("접속 완료!!");
		  
		  String sql ="select count(*) from member where addr =?";
		  
		  String addr="천안";
		  
		  PreparedStatement pst = conn.prepareStatement(sql);
		  
		  pst.setString(1, addr);
		  ResultSet rs = pst.executeQuery();
		  
		  rs.next();
		  int n = rs.getInt(1);
		  
		  if(n>0){
		   System.out.println(addr +"지역 회원은"+n+"명입니다.");
		   
		   //addr에 사는 사람의 정보를 출력
		   
		   String sql2 = "select * from member where addr = ?";
		   
		   PreparedStatement pst2 = conn.prepareStatement(sql2);
		   pst2.setString(1, addr);
		   ResultSet rs2 = pst2.executeQuery();
		   
		   while(rs2.next()){
		    int no = rs2.getInt("no");
		    String name = rs2.getString("name");
		    String hp = rs2.getString("hp");
		    String address = rs2.getString("addr");
		          System.out.println(no+"\t"+name+"\t"+hp+"\t"+address);
		   }//while
		   if(rs2 !=null) rs2.close();
		   if(pst2 !=null) pst2.close();
		  }else{
		   System.out.println(addr+"지역 회원은 없습니다....");
		  }
		   
		        if(rs !=null) rs.close();        
		        if(pst !=null) pst.close();        
		        if(conn !=null) conn.close();
		        
		        
		 
		}
}
