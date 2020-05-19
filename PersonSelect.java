package com.human.controller;

import java.util.ArrayList;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.Request;
import com.human.util.Response;

public class PersonSelect implements PersonExecute {

	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<PersonDto>response = new ArrayList<PersonDto>(); //integer아닌 PersonDto담는다.
//		inputView(request,response);
//		logic(request, response);
//		outputView(request,response);

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request, response);
		outputView(request,response);

	}
	//1.입력
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("모든 회원을 출력할 예정입니다.");
	}
	
	//2.처리
	@Override
	public void logic(Request request, Response response) {
		PersonDao dao = new PersonDao();
		response.setArrPersonDto(dao.select());
		}
		

	//3.결과
	@Override
	public void outputView(Request request, Response response) {
//		PersonDao dao = new PersonDao();
//		response = dao.select();
		if(response!=null) {
			ArrayList<PersonDto> dtos = response.getArrPersonDto();  //형변환
			System.out.println("회원정보는 다음과 같습니다.");
			
			for(PersonDto dto : dtos) {
				System.out.println(dto);	
			}
		}else {
			System.out.println("회원정보가 없습니다.");
		}

	}

}
