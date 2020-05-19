package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class PersonInsert implements PersonExecute {
	//model2로 업그레이드 해보자. 
	//1.입력 (사용자입력 받기) - 2.처리(비즈니스로직) - 3.결과 를 메소드로 생성.
	
	//4.실행메소드
	@Override
	public void execute() {
		PersonDto request = new PersonDto();
		ArrayList<Integer> response = new ArrayList<Integer>();
//		inputView(request, response);
//		logic(request, response);
//		outputView(request,response);
	}
	
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request,response);
	}
	
	
	//1. 입력 (사용자입력 받기)
	public void inputView(Request request, Response response) { //메소드간 값 공유하고자 매개변수
		System.out.println("회원정보를 입력하세요.");
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
		 
		 PersonDto dto = new PersonDto(); //본래 object 객체이므로 캐스팅 필요.
			dto.setNo(no);
			dto.setName(name);
			dto.setHeight(height);
			dto.setBirth(birth);
			dto.setRegist(regist);
			request.setPersonDto(dto);
	}
	//2.처리
	public void logic(Request request, Response response) {
		PersonDto dto = request.getPersonDto();
		//insert 
		PersonDao dao = new PersonDao();
		int i = dao.insert(dto);
		response.setResultValue(i);
	}
	
	//3.결과
	public void outputView(Request request, Response response) {
//		System.out.println(((ArrayList<Integer>)response).get(0));
		System.out.println(response.getResultValue());
	}


	
	
}
