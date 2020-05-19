package com.human.controller;

import java.util.ArrayList;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;

public class PersonSelect implements PersonExecute {

	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<PersonDto>response = new ArrayList<PersonDto>(); //integer�ƴ� PersonDto��´�.
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
	//1.�Է�
	@Override
	public void inputView(Object request, Object response) {
		System.out.println("��� ȸ���� ����� �����Դϴ�.");
	}
	
	//2.ó��
	@Override
	public void logic(Object request, Object response) {
		PersonDao dao = new PersonDao();
		for(PersonDto dto:dao.select()) {
			((ArrayList<PersonDto>)response).add(dto);
		}
		
	}

	//3.���
	@Override
	public void outputView(Object request, Object response) {
//		PersonDao dao = new PersonDao();
//		response = dao.select();
		if(response!=null) {
			ArrayList<PersonDto> dtos = (ArrayList<PersonDto>) response;  //����ȯ
			System.out.println("ȸ�������� ������ �����ϴ�.");
			for(PersonDto dto : dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("ȸ�������� �����ϴ�.");
		}

	}

}
