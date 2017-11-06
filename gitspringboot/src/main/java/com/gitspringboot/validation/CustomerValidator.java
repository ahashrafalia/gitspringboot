package com.gitspringboot.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gitspringboot.bean.CustomerBean;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CustomerBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerBean c=(CustomerBean)target;;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","", "Firstname is empty");

	}

}
