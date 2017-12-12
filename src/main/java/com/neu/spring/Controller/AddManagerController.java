package com.neu.spring.Controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
import com.neu.spring.DAO.CompanyDAO;
import com.neu.spring.DAO.DAO;
import com.neu.spring.DAO.ManagerDAO;
import com.neu.spring.DAO.UsersDAO;
import com.neu.spring.POJO.Address;
import com.neu.spring.POJO.Company;
import com.neu.spring.POJO.Manager;
import com.neu.spring.POJO.Users;

@Controller
public class AddManagerController {
	
	@Autowired
	private ManagerDAO managerDAO;
	

	@Autowired
	private UsersDAO usersDAO;
	

	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private CompanyDAO companyDAO;
	

	@RequestMapping(value="ManagerLogin.htm" , method = RequestMethod.POST)
	public String HrRegistration(Locale locale, Model model,HttpServletRequest request)
	{
		Manager manager = new Manager();
		Address address = new Address();
		Users users = new Users();
		Company company = new Company();
		
		
		manager.setAddress(address);
		manager.setUsers(users);
		manager.setCompany(company);
		
		model.addAttribute("manager",manager);
		return "ManagerSignup";
	}
	

	@Autowired
	@Qualifier("managerValidator")
	ManagerValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{

		binder.setValidator(validator);
		System.out.println("Inside initBinder"+ validator);
	}
	
	
	@RequestMapping(value="addManager.htm", method = RequestMethod.POST)
	public String Hr_Registration(@ModelAttribute("manager") Manager manager, Model model, BindingResult result) 
	{		

		validator.validate(manager, result);
		System.out.println("After validator"+ validator);

		if(result.hasErrors())
		{
			return "ManagerSignup";
		}
		else
		{	
		
			Users manager_user = manager.getUsers();
			manager_user.setRole("manager");

			if(!(usersDAO.uniqueUser(manager_user.getEmailid())))
			{			
				System.out.println("Username already exists");
				return "ManagerSignup";			
			}

			
			Address manager_Address = manager.getAddress();
			Company manager_Company = manager.getCompany();
		
		try
		{
			addressDAO.create(manager_Address); 
			DAO.close();
				
			usersDAO.create(manager_user);
			DAO.close();
			
			companyDAO.create(manager_Company);
			DAO.close();
			
			managerDAO.create(manager);
			DAO.close();			
		}		
		catch (HibernateException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return "ManagerSignup";
		}		
		
			model.addAttribute("manager", manager);
			return "Success_Registration";
		}
	}

}
