package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;

public interface PersonExecute {  //�������̽�
		
		public void execute();
		//4.����
		public void execute(Object request, Object response);
		
		//1. �Է� (������Է� �ޱ�)
		public void inputView(Object request, Object response);
		//2.ó��
		public void logic(Object request, Object response); 
		//3.���
		public void outputView(Object request, Object response); 
			
		
		
}
