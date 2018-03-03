package com.auth.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ObjectError;

public class Global {

	public static List<String> GetErrors(List<ObjectError> errors) {
		List<String> result = new ArrayList<String>();
		if (errors != null) {
			for (ObjectError item : errors) {
				result.add(item.getDefaultMessage());
			}
		}
		return result;
	}
}
