package com.medic.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.medic.model.EmployeeEntity;

public class EmployeeValidator implements Validator
{

	@Override
	public boolean supports(Class<?> obj)
	{
	// TODO Auto-generated method stub
	return EmployeeEntity.class.isAssignableFrom(obj);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		EmployeeEntity employee = (EmployeeEntity)obj;
		System.out.println(" Call Employee Validator >>>>>>>>>>>>>>");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.firstname", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.lastname", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
        if (!employee.getEmail().contains("@")) {
			errors.rejectValue("email","", "Email is not valid.");
		}
		
	}

}
