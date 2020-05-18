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
		System.out.println("������ ȸ����ȣ�� �̸��� �Է��ϼ���.");
		System.out.println("no�Է�");
		 int no = DBConn.inputInt();
		 
		 System.out.println("name�Է�");
		 String name  = DBConn.inputString();
		
		 PersonDto dto = (PersonDto) request; //���� object ��ü�̹Ƿ� ĳ���� �ʿ�.
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
		System.out.println(((PersonDto)request).getNo()+"�� �������� �̸��� " + 
				((PersonDto)request).getName()+"�� " + ((ArrayList<Integer>)response).get(0)+
				"�� ����Ǿ����ϴ�.");

	}

	

}
