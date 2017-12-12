package com.neu.spring.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.POJO.Users;

public class LoginControllerValidator implements Validator {

    @Override
	public boolean supports(Class aClass)
    {
        return aClass.equals(Users.class);
    }

    @Override
	public void validate(Object obj, Errors errors)
    {
    	Users users = (Users) obj;
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.jobseeker", "  First Name Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.jobseeker", "Last Name Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneno", "error.invalid.jobseeker", "User Name Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qualification", "error.invalid.jobseeker", "qualification Required");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workexperience", "error.invalid.jobseeker", "workexperience Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailid", "error.invalid.emailid", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "password Required");
                
    }

}
