package com.human.test;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;

public class PersonDtoTest {

	public static void main(String[] args) {
		//insert
		PersonDao dao = new PersonDao();
		PersonDto dto = new PersonDto();
		dto.setNo(20);
		dto.setName("kim");
		dto.setHeight(124.3);
		dto.setBirth(new Date());
		dto.setRegist(new Date());
		int result = dao.insert(dto);
		System.out.println(result);
		
		//update
//		PersonDao dao = new PersonDao();
		int result2 = dao.update("hong", 20);
		System.out.println(result2);             //1 : 1개 바뀌었다는 뜻
		
		//delete
//		PersonDao dao = new PersonDao();
		int result3 = dao.delete(20);
		System.out.println(result3);
		
		//select
//		PersonDao dao = new PersonDao();
		ArrayList<PersonDto> dtos = dao.select();
		for(PersonDto dto2:dtos) {
			System.out.println(dto2);
		}
		
		
	}
	
}
