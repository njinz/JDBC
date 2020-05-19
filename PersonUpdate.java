package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class PersonUpdate implements PersonExecute {

	
	
	public void execute() {
		PersonDto request = new PersonDto();
		ArrayList<Integer> response = new ArrayList<Integer>();
//		inputView(request, response);
//		logic(request, response);
//		outputView(request,response);
	}
	
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request, response);
		outputView(request,response);
	}

	
	public void inputView(Request request, Response response) {
		System.out.println("변경할 회원번호와 이름을 입력하세요.");
		System.out.println("no입력");
		 int no = DBConn.inputInt();
		 
		 System.out.println("name입력");
		 String name  = DBConn.inputString();
		
		 PersonDto dto = new PersonDto(); //본래 object 객체이므로 캐스팅 필요.
			dto.setNo(no);
			dto.setName(name);
			request.setPersonDto(dto);
	}


	public void logic(Request request, Response response) {
		PersonDto dto = request.getPersonDto();
		PersonDao dao = new PersonDao();
		int i = dao.update(dto.getName(), dto.getNo());
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(request.getPersonDto().getNo()+"번 데이터의 이름을 " + 
				request.getPersonDto().getName()+"로 " + response.getResultValue()+
				"개 변경되었습니다.");

	}


}
