//dbconn �׽�Ʈ�ϱ�2 ->���׷��̵� ���� 
package com.human.ex;

import com.human.util.DBConn;

public class JDBCEx_StatementUpdate {

	public static void main(String[] args) {
		
	 DBConn.getInstance();
	 String sql="insert into person " + "values"              //���� �ʼ�
				+ "(122,'ȫ3',123.23,sysdate,systimestamp)";
	 DBConn.statementUpdate(sql);
	 sql="delete from person " + "where no=2";
	 DBConn.statementUpdate(sql);
	 sql="update person " + "set name ='��' "+ "where no=1" ;           //���� �ʼ�
	 DBConn.statementUpdate(sql);		
	 DBConn.dbClose();
	 System.out.println("���� ");
	}

	
}
