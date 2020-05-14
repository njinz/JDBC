//dbconn 테스트하기2 ->업그레이드 버전  // 데이터추가하기 insert, update, delete 등
package com.human.ex;

import java.util.Date;

import com.human.util.DBConn;

public class JDBCEx_StatementUpdateInput {

	public static void main(String[] args) {
		
	 DBConn.getInstance();
	 
	 //사용자입력을 받아서 데이터를 추가해보자. 
	 System.out.println("no입력");
	 int no = DBConn.inputInt();
	 
	 System.out.println("name입력");
	 String name  = DBConn.inputString();
	 
	 System.out.println("height입력");
	 double height  = DBConn.inputDouble();
	 
	 System.out.println("birth입력");
	 Date birth = DBConn.inputDate();
	 
	 System.out.println("regist입력");
	 Date regist = DBConn.inputDate();
	 
	 String sql="insert into person " + "values"             
				+ "(%d,'%s',%f,"
				+ "to_date('%s','yyyy-mm-dd hh24:mi:ss'),"
				+ "to_date('%s','yyyy-mm-dd hh24:mi:ss'))";
			
	 
	 sql=String.format(sql, no,name,
			 height, DBConn.dateToString(birth), DBConn.dateToString(regist));
	 System.out.println(sql);
	 
//	 String sql="insert into person " + "values"              
//				+ "(122,'홍3',123.23,sysdate,systimestamp)";
//	 
	 DBConn.statementUpdate(sql);
	 sql="delete from person " + "where no=2";
	 DBConn.statementUpdate(sql);
	 
	 sql="update person " + "set name ='강' "+ "where no=1" ;  
	 DBConn.statementUpdate(sql);		
	 
	 DBConn.dbClose();
	 System.out.println("종료 ");
	}

	
}
