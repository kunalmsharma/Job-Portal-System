package com.neu.spring.Controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.POJO.JobSeeker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JobSeekerValidator implements Validator {


	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
  String mobilePattern = "[0-9]{10}";
	
    @Override
	public boolean supports(Class aClass)
    {
        return aClass.equals(JobSeeker.class);
    }

    @Override
	public void validate(Object obj, Errors errors)
    {
    	JobSeeker jobseeker = (JobSeeker) obj;
    	Matcher matcher;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.jobseeker", "  First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.jobseeker", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneno", "error.invalid.jobseeker", "Phone No. Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qualification", "error.invalid.jobseeker", "qualification Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workexperience", "error.invalid.workexperience", "workexperience Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "users.emailid", "error.invalid.users.emailid", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "users.password", "error.invalid.users.password", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.street", "error.invalid.address.street", "Street Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.address.city", "city Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.address.state", "State Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.country", "error.invalid.address.country", "country Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipcode", "error.invalid.address.zipcode", "zipcode Required");
         
        if(!(jobseeker.getUsers().getEmailid() != null && jobseeker.getUsers().getEmailid().isEmpty()))
        {  
        Pattern pt = Pattern.compile(emailPattern);  
        matcher = pt.matcher(jobseeker.getUsers().getEmailid());  
         if (!matcher.matches()) {  
          errors.rejectValue("users.emailid", "error.invalid.users.emailid"," Enter a valid emailid in proper format");  
         } 
    }
        
        if (!(jobseeker.getPhoneno() != null && jobseeker.getPhoneno().isEmpty())) {  
            Pattern pa = Pattern.compile(mobilePattern);  
            matcher = pa.matcher(jobseeker.getPhoneno());  
            if (!matcher.matches()) {  
             errors.rejectValue("phoneno", "error.invalid.jobseeker","Enter a valid phone number");  
            }  
           }
    }
}
