//dbconn 테스트하기2 ->업그레이드 버전 
package com.human.ex;

import com.human.util.DBConn;

public class JDBCEx_StatementUpdate {

	public static void main(String[] args) {
		
	 DBConn.getInstance();
	 String sql="insert into person " + "values"              //띄어쓰기 필수
				+ "(122,'홍3',123.23,sysdate,systimestamp)";
	 DBConn.StatementUpdate(sql);
	 sql="delete from person " + "where no=2";
	 DBConn.StatementUpdate(sql);
	 sql="update person " + "set name ='강' "+ "where no=1" ;           //띄어쓰기 필수
	 DBConn.StatementUpdate(sql);		
	 DBConn.dbClose();
	 System.out.println("종료 ");
	}

}
