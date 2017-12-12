package com.neu.spring.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.spring.DAO.AddressDAO;
import com.neu.spring.DAO.DAO;
import com.neu.spring.DAO.JobSeekerDAO;
import com.neu.spring.DAO.UsersDAO;
import com.neu.spring.POJO.Address;
import com.neu.spring.POJO.JobSeeker;
import com.neu.spring.POJO.Users;
import com.neu.spring.Controller.JobSeekerValidator;


@Controller
public class AddJobSeekerController {

	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired 
	private JobSeekerDAO jobSeekerDAO;
	
	@Autowired
	private UsersDAO usersDAO;
	
	
	
	@RequestMapping(value="JobSeekerRegistration" , method = RequestMethod.POST)
	public String registration(Model model,HttpServletRequest request)
	{
		JobSeeker jobseeker = new JobSeeker();
		Address address = new Address();
		Users users = new Users();
		
		
		jobseeker.setAddress(address);
		jobseeker.setUsers(users);
		
		model.addAttribute("jobseeker",jobseeker);
		
		return "JobSeekerSignup";
	}
	
	@Autowired
	@Qualifier("jobSeekerValidator")
	JobSeekerValidator validator;
		
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
		System.out.println("Inside initBinder"+ validator);
	}
	
	@RequestMapping(value="/RegisterUser", method = RequestMethod.POST)
	public String Job_Seeker_Registration(@ModelAttribute("jobseeker") JobSeeker jobseeker, Model model, BindingResult result,HttpServletRequest request) 
	{	
		validator.validate(jobseeker, result);
		System.out.println("After validator"+ validator);
		if(result.hasErrors())
		{
			
			return "JobSeekerSignup";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("jobseeker", jobseeker);
			Users jobseeker_user = jobseeker.getUsers();						
			jobseeker_user.setRole("jobSeeker");
			
			if(!(usersDAO.uniqueUser(jobseeker_user.getEmailid()))) {			
				System.out.println("Username already exists");
				return "JobSeekerSignup";			
			}	
			
			Address jobeekerAddress = jobseeker.getAddress();
			try { 
				addressDAO.create(jobeekerAddress); 
				DAO.close();
					
				usersDAO.create(jobseeker_user);
				DAO.close();
				
				jobSeekerDAO.create(jobseeker);
				DAO.close();				
			} catch (HibernateException e) {
				System.out.println("Exception: " + e.getMessage());
				return "JobSeekerSignup";
			}
		}	
			
			model.addAttribute("jobseeker", jobseeker);
			return "Success_Registration";
		}
	}

