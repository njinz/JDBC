//dbconn �׽�Ʈ�ϱ�2 ->���׷��̵� ���� 
package com.human.ex;

import com.human.util.DBConn;

public class JDBCEx_StatementUpdate {

	public static void main(String[] args) {
		
	 DBConn.getInstance();
	 String sql="insert into person " + "values"              //���� �ʼ�
				+ "(122,'ȫ3',123.23,sysdate,systimestamp)";
	 DBConn.StatementUpdate(sql);
	 sql="delete from person " + "where no=2";
	 DBConn.StatementUpdate(sql);
	 sql="update person " + "set name ='��' "+ "where no=1" ;           //���� �ʼ�
	 DBConn.StatementUpdate(sql);		
	 DBConn.dbClose();
	 System.out.println("���� ");
	}

}
