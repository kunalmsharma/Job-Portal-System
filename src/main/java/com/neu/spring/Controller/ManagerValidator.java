package com.neu.spring.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.POJO.Manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerValidator implements Validator {

	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
  	
    @Override
	public boolean supports(Class aClass)
    {
        return aClass.equals(Manager.class);
    }

    @Override
	public void validate(Object obj, Errors errors)
    {
    	Matcher matcher;
    	Manager manager = (Manager) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.manager", "  First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.manager", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company.companyName", "error.invalid.company.companyName", "Company Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "users.emailid", "error.invalid.users.emailid", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "users.password", "error.invalid.users.password", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.street", "error.invalid.address.street", "Street Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.address.city", "city Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.address.state", "State Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.country", "error.invalid.address.country", "country Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipcode", "error.invalid.address.zipcode", "zipcode Required");
        
        
        if(!(manager.getUsers().getEmailid() != null && manager.getUsers().getEmailid().isEmpty()))
        {  
        Pattern p = Pattern.compile(emailPattern);  
         matcher = p.matcher(manager.getUsers().getEmailid());  
         if (!matcher.matches()) {  
          errors.rejectValue("users.emailid", "error.invalid.users.emailid"," Enter a valid emailid in proper format");  
         }    
         
    }
    }
}
