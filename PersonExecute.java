package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public interface PersonExecute {  //인터페이스
		
		public void execute();
		//4.실행
		public void execute(Request request, Response response);
		
		//1. 입력 (사용자입력 받기)
		public void inputView(Request request, Response response);
		//2.처리
		public void logic(Request request, Response response); 
		//3.결과
		public void outputView(Request request, Response response); 
			
		
		
}
