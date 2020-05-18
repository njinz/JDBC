package com.human.util;
//�������̼� �۾��Ҽ� �ֵ��� ������. 
//�ݺ��Ǵ� �۾� (db ���� - �۾� - db �ݾ��ֱ�) �ߺ��� ���ְ��� �Լ��� ����.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DBConn {
	
	private DBConn() {};                    //�ܺο��� ȣ��Ұ��ϵ��� private
	private static Connection dbConn = null;
	private static Statement st=null;
	private static ResultSet rs = null;   // ResultSet: select �� ����� �����ϴ� ��ü(insert�� ������ ����)
	private static Scanner sc = new Scanner(System.in);
	
	
	public static ResultSet statementQuery(String sql) {

		try {
			if(st==null) {
			 st = dbConn.createStatement(); 
			}
			 rs = st.executeQuery(sql);  
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
			}
		return rs;
	}
	
	
	public static int statementUpdate(String sql) {
		int resultValue=0;
		
		try {
			if(st==null) { //!null�̸� �̹� �������ִٴ� ���̹Ƿ� null�϶��� ����
			st = dbConn.createStatement();
			}
			resultValue = st.executeUpdate(sql);   //executeUpdate: int ����.
			}
			catch (SQLException e) {
			e.printStackTrace();
			}finally {
			//DBConn.dbClose();
		}
		
		return resultValue;
	}
	
	
	public static Connection getInstance() {
		if(dbConn==null) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "human";
				String pw = "human";
				dbConn = DriverManager.getConnection(url,user,pw);
			}
				
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
			catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
		return dbConn;
	}
	
	public static void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();        //statement ���� �ݾ��ֱ�
			if(dbConn!=null)dbConn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs=null;
			st=null;
			dbConn=null;
		}
	}
		
	//����� �Է��� �޾ƺ���
	public static int inputInt() {
		System.out.print("�����Է�>>");
		return Integer.parseInt(sc.nextLine()); //������Է°��� ������ ��ȯ.
	}
	public static double inputDouble() {
		System.out.print("�Ǽ��Է�>>");
		return Double.parseDouble(sc.nextLine());  //�Ǽ��� ��ȯ
	}
	public static String inputString() {
		System.out.print("���ڿ� �Է�>>");
		return sc.nextLine();                    //���ڿ��� ��ȯ
	}
	public static Date inputDate() {
		Date returnValue = null;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.print("��¥�Է�(yyyy-MM-dd HH:mm:ss)>>");
		String inputString = sc.nextLine();                        //���ڿ��� ��¥�� ��ȯ
		try {
			returnValue =transFormat.parse(inputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	public static String dateToString(Date d) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(d);
	}
	
	
	
	
}
