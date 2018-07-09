package com.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.Person;

@Component
public class ValidationUtil implements Validator {
	private Logger logger = Logger.getLogger(ValidationUtil.class);
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Person.class.isAssignableFrom(arg0);
		
	}

	@Override
	public void validate(Object object, Errors err) {
		// TODO Auto-generated method stub
		Person p=(Person)object;
		logger.info("validation started");
		logger.info("Checking null "+p.getSno());
		if(p.getSno()==null || p.getSno()<10 || p.getSno()>10000)
		 err.rejectValue("sno", "sno.invalid");
	
	   ValidationUtils.rejectIfEmpty(err, "name", "name.invalid");
	
	   ValidationUtils.rejectIfEmpty(err, "city", "city.invalid");
	   
	}

}
