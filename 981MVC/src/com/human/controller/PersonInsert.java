package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;

public class PersonInsert implements PersonExecute {
	//model2�� ���׷��̵� �غ���. 
	//1.�Է� (������Է� �ޱ�) - 2.ó��(����Ͻ�����) - 3.��� �� �޼ҵ�� ����.
	
	//4.����޼ҵ�
	@Override
	
	public void execute() {
		PersonDto request = new PersonDto();
		ArrayList<Integer> response = new ArrayList<Integer>();
		inputView(request, response);
		logic(request, response);
		outputView(request,response);
	}
	
	public void execute(Object request, Object response) {
		inputView(request, response);
		logic(request, response);
		outputView(request,response);
	}
	
	
	//1. �Է� (������Է� �ޱ�)
	public void inputView(Object request, Object response) { //�޼ҵ尣 �� �����ϰ��� �Ű�����
		System.out.println("ȸ�������� �Է��ϼ���.");
		System.out.println("no�Է�");
		 int no = DBConn.inputInt();
		 
		 System.out.println("name�Է�");
		 String name  = DBConn.inputString();
		 
		 System.out.println("height�Է�");
		 double height  = DBConn.inputDouble();
		 
		 System.out.println("birth�Է�");
		 Date birth = DBConn.inputDate();
		 
		 System.out.println("regist�Է�");
		 Date regist = DBConn.inputDate();
		 
		 PersonDto dto = (PersonDto) request; //���� object ��ü�̹Ƿ� ĳ���� �ʿ�.
			dto.setNo(no);
			dto.setName(name);
			dto.setHeight(height);
			dto.setBirth(birth);
			dto.setRegist(regist);
	}
	//2.ó��
	public void logic(Object request, Object response) {
		PersonDto dto = (PersonDto) request;
		//insert 
		PersonDao dao = new PersonDao();
		int i = dao.insert(dto);
//		ArrayList<Integer> r = (ArrayList<Integer>)response;
//		r.add(new Integer(i));
		((ArrayList<Integer>)response).add(new Integer(i));
		
		
	}
	//3.���
	public void outputView(Object request, Object response) {
		System.out.println(((ArrayList<Integer>)response).get(0));
	}


	
	
}
