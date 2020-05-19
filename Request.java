package com.human.util;

import com.human.dto.PersonDto;

//객체 형변환 매번 해줘야 하는 번거로움 없애보자.
public class Request {
	private PersonDto personDto=null;

	//setter getter
	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}
}
