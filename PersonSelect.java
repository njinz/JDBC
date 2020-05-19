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
		ArrayList<PersonDto>response = new ArrayList<PersonDto>(); //integer�ƴ� PersonDto��´�.
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
	//1.�Է�
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("��� ȸ���� ����� �����Դϴ�.");
	}
	
	//2.ó��
	@Override
	public void logic(Request request, Response response) {
		PersonDao dao = new PersonDao();
		response.setArrPersonDto(dao.select());
		}
		

	//3.���
	@Override
	public void outputView(Request request, Response response) {
//		PersonDao dao = new PersonDao();
//		response = dao.select();
		if(response!=null) {
			ArrayList<PersonDto> dtos = response.getArrPersonDto();  //����ȯ
			System.out.println("ȸ�������� ������ �����ϴ�.");
			
			for(PersonDto dto : dtos) {
				System.out.println(dto);	
			}
		}else {
			System.out.println("ȸ�������� �����ϴ�.");
		}

	}

}
