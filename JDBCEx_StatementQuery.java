package com.human.ex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.human.util.DBConn;

public class JDBCEx_StatementQuery {

	public static void main(String[] args) {
		 DBConn.getInstance();                                   //DB����
		 String sql="select * from person";
		 ResultSet rs= DBConn.statementQuery(sql);	           //rs�� �ִ´�.
		 
		 
		 try {
			while(rs.next()) {
					//rs.getInt("no");
					int no = rs.getInt(1);
					String name = rs.getString(2);
					double height = rs.getDouble(3);
					// ���� ! Date import�� java���� �ٷ궧��(java.util.Date), db�� insert�Ҷ� java.sql.Date
					Date birth1 = rs.getDate(4);        // getDate : ��¥ 
					Date birth2 = rs.getTime(4);        // getTime : �ð�
					Date birth3= rs.getTimestamp(4);    // getTimestamp : ��¥ + �ð� + �̸���������� ǥ��
					Date regist = rs.getTimestamp(5);  
					
					System.out.println(no+" / "+name +" / "+height +" / "+birth1 +" / "+birth2 +" / "+birth3+" / "+regist);
					                  //1 / ȫ / 123.23 / 2020-05-13 / 09:17:37 / 2020-05-13 09:17:37.0 / 2020-05-13 09:17:37.55	
					
					
					//Date format �ٲ���.
					DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  //import.��(month)�� �빮��, ��(min)�� �ҹ���
					System.out.println(df.format(birth1));
					System.out.println(df.format(birth2));
					System.out.println(df.format(birth3));
					
					//2020/05/13 12:00:00  ��¥�� �ִ� date �̹Ƿ� �ð��� �ʱⰪ(12:00:00)
					//1970/01/01 09:17:37  �ð��� �ִ� date �̹Ƿ� ��¥�� �ʱⰪ(1970/01/01)
					//2020/05/13 09:17:37
					
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		 DBConn.dbClose();
		 
		 System.out.println("���� ");

	}

}
