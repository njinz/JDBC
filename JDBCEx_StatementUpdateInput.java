//dbconn �׽�Ʈ�ϱ�2 ->���׷��̵� ����  // �������߰��ϱ� insert, update, delete ��
package com.human.ex;

import java.util.Date;

import com.human.util.DBConn;

public class JDBCEx_StatementUpdateInput {

	public static void main(String[] args) {
		
	 DBConn.getInstance();
	 
	 //������Է��� �޾Ƽ� �����͸� �߰��غ���. 
	 System.out.println("no�Է�");
	 int no = DBConn.inputInt();
	 
	 System.out.println("name�Է�");
	 String name  = DBConn.inputString();
	 
	 System.out.println("height�Է�");
	 double height  = DBConn.inputDouble();
	 
	 System.out.println("birth�Է�");
	 Date birth = DBConn.inputDate();
	 
	 System.out.println("regist�Է�");
	 Date regist = DBConn.inputDate();
	 
	 String sql="insert into person " + "values"             
				+ "(%d,'%s',%f,"
				+ "to_date('%s','yyyy-mm-dd hh24:mi:ss'),"
				+ "to_date('%s','yyyy-mm-dd hh24:mi:ss'))";
			
	 
	 sql=String.format(sql, no,name,
			 height, DBConn.dateToString(birth), DBConn.dateToString(regist));
	 System.out.println(sql);
	 
//	 String sql="insert into person " + "values"              
//				+ "(122,'ȫ3',123.23,sysdate,systimestamp)";
//	 
	 DBConn.statementUpdate(sql);
	 sql="delete from person " + "where no=2";
	 DBConn.statementUpdate(sql);
	 
	 sql="update person " + "set name ='��' "+ "where no=1" ;  
	 DBConn.statementUpdate(sql);		
	 
	 DBConn.dbClose();
	 System.out.println("���� ");
	}

	
}
