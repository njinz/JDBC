package com.human.controller;

import java.util.ArrayList;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;

public class PersonDelete implements PersonExecute {

	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<Integer>response = new ArrayList<Integer>();
		inputView(request,response);
		logic(request, response);
		outputView(request,response);
	}

	@Override
	public void execute(Object request, Object response) {
		// TODO Auto-generated method stub
		inputView(request, response);
		logic(request, response);
		outputView(request,response);

	}

	@Override
	public void inputView(Object request, Object response) {
		System.out.println("������ ȸ����ȣ�� �Է��ϼ���.");
		System.out.println("no�Է�");
		int no = DBConn.inputInt();
		
		PersonDto dto= (PersonDto)request;
		dto.setNo(no);

	}

	@Override
	public void logic(Object request, Object response) {
		PersonDto dto = (PersonDto) request;
		PersonDao dao = new PersonDao();
		int i = dao.delete(dto.getNo());
		((ArrayList<Integer>)response).add(new Integer(i));

	}

	@Override
	public void outputView(Object request, Object response) {
		PersonDto req = (PersonDto) request;
		ArrayList<Integer> res = ((ArrayList<Integer>)response);
		
		System.out.println("�����ȣ"+req.getNo()+"�� �����͸�"+ res.get(0) +"�� �����߽��ϴ�.");

	}

	
}