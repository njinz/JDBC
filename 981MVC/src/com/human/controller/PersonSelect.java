package com.human.controller;

import java.util.ArrayList;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;

public class PersonSelect implements PersonExecute {

	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<PersonDto>response = new ArrayList<PersonDto>(); //integer아닌 PersonDto담는다.
		inputView(request,response);
		logic(request, response);
		outputView(request,response);

	}

	@Override
	public void execute(Object request, Object response) {
		inputView(request,response);
		logic(request, response);
		outputView(request,response);

	}
	//1.입력
	@Override
	public void inputView(Object request, Object response) {
		System.out.println("모든 회원을 출력할 예정입니다.");
	}
	
	//2.처리
	@Override
	public void logic(Object request, Object response) {
		PersonDao dao = new PersonDao();
		for(PersonDto dto:dao.select()) {
			((ArrayList<PersonDto>)response).add(dto);
		}
		
	}

	//3.결과
	@Override
	public void outputView(Object request, Object response) {
//		PersonDao dao = new PersonDao();
//		response = dao.select();
		if(response!=null) {
			ArrayList<PersonDto> dtos = (ArrayList<PersonDto>) response;  //형변환
			System.out.println("회원정보는 다음과 같습니다.");
			for(PersonDto dto : dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("회원정보가 없습니다.");
		}

	}

}
