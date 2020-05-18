package com.human.util;
//여러명이서 작업할수 있도록 만들어보자. 
//반복되는 작업 (db 연결 - 작업 - db 닫아주기) 중복을 없애고자 함수로 만듦.
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
	
	private DBConn() {};                    //외부에서 호출불가하도록 private
	private static Connection dbConn = null;
	private static Statement st=null;
	private static ResultSet rs = null;   // ResultSet: select 의 결과를 저장하는 객체(insert시 쓰이지 않음)
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
			if(st==null) { //!null이면 이미 생성되있다는 말이므로 null일때만 실행
			st = dbConn.createStatement();
			}
			resultValue = st.executeUpdate(sql);   //executeUpdate: int 리턴.
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
			if(st!=null)st.close();        //statement 부터 닫아주기
			if(dbConn!=null)dbConn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs=null;
			st=null;
			dbConn=null;
		}
	}
		
	//사용자 입력을 받아보자
	public static int inputInt() {
		System.out.print("정수입력>>");
		return Integer.parseInt(sc.nextLine()); //사용자입력값을 정수로 변환.
	}
	public static double inputDouble() {
		System.out.print("실수입력>>");
		return Double.parseDouble(sc.nextLine());  //실수로 변환
	}
	public static String inputString() {
		System.out.print("문자열 입력>>");
		return sc.nextLine();                    //문자열로 변환
	}
	public static Date inputDate() {
		Date returnValue = null;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.print("날짜입력(yyyy-MM-dd HH:mm:ss)>>");
		String inputString = sc.nextLine();                        //문자열을 날짜로 변환
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
