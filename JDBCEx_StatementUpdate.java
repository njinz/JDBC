//dbconn 테스트하기2 ->업그레이드 버전 
package com.human.ex;

import com.human.util.DBConn;

public class JDBCEx_StatementUpdate {

	public static void main(String[] args) {
		
	 DBConn.getInstance();
	 String sql="insert into person " + "values"              //띄어쓰기 필수
				+ "(122,'홍3',123.23,sysdate,systimestamp)";
	 DBConn.statementUpdate(sql);
	 sql="delete from person " + "where no=2";
	 DBConn.statementUpdate(sql);
	 sql="update person " + "set name ='강' "+ "where no=1" ;           //띄어쓰기 필수
	 DBConn.statementUpdate(sql);		
	 DBConn.dbClose();
	 System.out.println("종료 ");
	}

	
}
