package com.human.util;

import java.util.ArrayList;

import com.human.dto.PersonDto;

public class Response {
	private ArrayList<PersonDto> arrPersonDto=null;
	private int resultValue=0;        //¹Ù²ï °¹¼ö ¹ÝÈ¯
	
	//setter getter
	public ArrayList<PersonDto> getArrPersonDto() {
		return arrPersonDto;
	}
	public void setArrPersonDto(ArrayList<PersonDto> arrPersonDto) {
		this.arrPersonDto = arrPersonDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
	
}
