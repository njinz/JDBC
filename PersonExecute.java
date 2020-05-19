package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public interface PersonExecute {  //�������̽�
		
		public void execute();
		//4.����
		public void execute(Request request, Response response);
		
		//1. �Է� (������Է� �ޱ�)
		public void inputView(Request request, Response response);
		//2.ó��
		public void logic(Request request, Response response); 
		//3.���
		public void outputView(Request request, Response response); 
			
		
		
}
