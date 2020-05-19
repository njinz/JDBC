package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class PersonInsert implements PersonExecute {
	//model2�� ���׷��̵� �غ���. 
	//1.�Է� (������Է� �ޱ�) - 2.ó��(����Ͻ�����) - 3.��� �� �޼ҵ�� ����.
	
	//4.����޼ҵ�
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
	
	
	//1. �Է� (������Է� �ޱ�)
	public void inputView(Request request, Response response) { //�޼ҵ尣 �� �����ϰ��� �Ű�����
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
		 
		 PersonDto dto = new PersonDto(); //���� object ��ü�̹Ƿ� ĳ���� �ʿ�.
			dto.setNo(no);
			dto.setName(name);
			dto.setHeight(height);
			dto.setBirth(birth);
			dto.setRegist(regist);
			request.setPersonDto(dto);
	}
	//2.ó��
	public void logic(Request request, Response response) {
		PersonDto dto = request.getPersonDto();
		//insert 
		PersonDao dao = new PersonDao();
		int i = dao.insert(dto);
		response.setResultValue(i);
	}
	
	//3.���
	public void outputView(Request request, Response response) {
//		System.out.println(((ArrayList<Integer>)response).get(0));
		System.out.println(response.getResultValue());
	}


	
	
}
