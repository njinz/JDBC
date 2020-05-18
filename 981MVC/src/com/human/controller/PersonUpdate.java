package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;

public class PersonUpdate implements PersonExecute {

	@Override
	public void execute(Object request, Object response) {
		
	}
	public void execute() {
		PersonDto request = new PersonDto();
		ArrayList<Integer> response = new ArrayList<Integer>();
		inputView(request, response);
		logic(request, response);
		outputView(request,response);
	}
//	@Override
//	public void execute(Object request, Object response) {
//		inputView(request, response);
//		logic( request, response); 
//		outputView( request, response); 
//	}

	@Override
	public void inputView(Object request, Object response) {
		System.out.println("변경할 회원번호와 이름을 입력하세요.");
		System.out.println("no입력");
		 int no = DBConn.inputInt();
		 
		 System.out.println("name입력");
		 String name  = DBConn.inputString();
		
		 PersonDto dto = (PersonDto) request; //본래 object 객체이므로 캐스팅 필요.
			dto.setNo(no);
			dto.setName(name);
	}

	@Override
	public void logic(Object request, Object response) {
		PersonDto dto = (PersonDto) request;
		PersonDao dao = new PersonDao();
		int i = dao.update(dto.getName(), dto.getNo());
		((ArrayList<Integer>)response).add(new Integer(i));
	}

	@Override
	public void outputView(Object request, Object response) {
		System.out.println(((PersonDto)request).getNo()+"번 데이터의 이름을 " + 
				((PersonDto)request).getName()+"로 " + ((ArrayList<Integer>)response).get(0)+
				"개 변경되었습니다.");

	}

	

}
