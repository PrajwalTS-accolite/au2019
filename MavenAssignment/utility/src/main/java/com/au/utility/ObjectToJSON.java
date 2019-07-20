package com.au.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJSON<O> {
	
	public static<O> String convertToJSON(O o) {
		String jsonString = null;
		// Creating Object of ObjectMapper define in Jakson Api 
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonString = mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (jsonString);
	}

}
