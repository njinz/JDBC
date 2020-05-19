package com.human.test;

import java.util.ArrayList;

import com.human.controller.PersonDelete;
import com.human.controller.PersonExecute;
import com.human.controller.PersonInsert;
import com.human.controller.PersonSelect;
import com.human.controller.PersonUpdate;
import com.human.dto.PersonDto;
import com.human.util.Request;
import com.human.util.Response;

public class PersonResponseTest {

	public static void main(String[] args) {
		
		int select=1;
		PersonExecute pe = null;
		Response response= new Response();
		Request request = new Request();
		
//		Object request = new PersonDto();
//		Object response = new ArrayList<Integer>();
		
		switch(select) {
		case 0:
//			request=new  PersonDto();
//			response=new ArrayList<Integer>();
			pe=new PersonInsert();  //다형성 이용
			break;
		case 1:
//			request=new  PersonDto();
//			response=new ArrayList<Integer>();
			pe=new PersonUpdate();
			break;
		case 2:
			pe=new PersonDelete();
			break;
		case 3:
			pe=new PersonSelect();
			break;
		default:
			break;
		}
		pe.execute(request, response);
//		pe.execute();
		
	}

	}


