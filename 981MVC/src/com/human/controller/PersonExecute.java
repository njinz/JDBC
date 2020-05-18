package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;

public interface PersonExecute {  //인터페이스
		
		public void execute();
		//4.실행
		public void execute(Object request, Object response);
		
		//1. 입력 (사용자입력 받기)
		public void inputView(Object request, Object response);
		//2.처리
		public void logic(Object request, Object response); 
		//3.결과
		public void outputView(Object request, Object response); 
			
		
		
}
