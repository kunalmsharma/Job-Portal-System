package com.neu.spring.Controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.DAO.JobPostDAO;
import com.neu.spring.DAO.UsersDAO;
import com.neu.spring.POJO.JobPost;
import com.neu.spring.POJO.Users;


@Controller
public class LoginController {
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private JobPostDAO jobPostDAO;
	

	@Autowired
	@Qualifier("loginControllerValidator")
	LoginControllerValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);	
	}
//---------------------------------------------------------------------------------------------------	
	
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView JobPortalApplication(Locale locale, Model model,HttpServletRequest request)
	{
		Users users = new Users();

		return new ModelAndView("Home", "users", users);
	}
//---------------------------------------------------------------------------------------------------	
	@RequestMapping(value="home" , method = RequestMethod.POST)
	public ModelAndView home(Locale locale, Model model,HttpServletRequest request)
	{
		Users users = new Users();

		return new ModelAndView("Home", "users", users);
	}

	
	
	@RequestMapping(value = "/LoginSuccess", method = RequestMethod.POST)
	public String logintoSystem(@ModelAttribute("users") Users users,
									BindingResult result, HttpServletRequest request) {
		validator.validate(users, result);
		HttpSession session;		
		if (result.hasErrors()) {
			System.out.println("Result errors");
			return "Home";
		} else {			
			System.out.println("users.getEmailid()" + users.getEmailid());
			Users u = usersDAO.selectUser(users);	
			System.out.print("Login U is"+u.getUserid());
			request.setAttribute("uid", u.getUserid());
			if(u == null)
			{				
				System.out.println("u has null record");
				System.out.println("Username does not exists in database");
				return "Home";
			} else {		
				if(u.getPassword().equals(users.getPassword())) {				
					System.out.println("password matching");
					if(u.getRole().equalsIgnoreCase("jobseeker")){
						System.out.println("JobSeeker Credentials Matched");
						session = request.getSession();  // removed true from here
						session.setAttribute("jobseeker", u);
						session.setAttribute("userID", u.getUserid());
						List<JobPost> jobpostList = jobPostDAO.searchJobPosted();
						request.setAttribute("jobpostList", jobpostList);
						
						return "JobSeekerWorkArea";
					} else  
						if(u.getRole().equalsIgnoreCase("manager")) {
						System.out.println("Manager Credentials Matched");
						session = request.getSession();  // removed true
						session.setAttribute("manager", u);
						return "ManagerWorkArea";	
					}
				}
				System.out.println("Invalid Username or password. Try Again !");
				return "Home";
			}
		}
	}	
	
//----------------------------------------------------------------------------------------------------	
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(Model model,HttpServletRequest request) 
	{	
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("jobseeker")==null && session.getAttribute("manager")==null)
		{
			return "LogoutFailure";
		}
		
		Users users = new Users();
		model.addAttribute(users);
				
		session.invalidate();		
		return "Home";
	}	
}