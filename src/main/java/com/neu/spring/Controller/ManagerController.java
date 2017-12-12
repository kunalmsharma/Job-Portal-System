package com.neu.spring.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.spring.DAO.DAO;
import com.neu.spring.DAO.ManagerDAO;
import com.neu.spring.DAO.JobAppliedDAO;
import com.neu.spring.DAO.JobPostDAO;
import com.neu.spring.POJO.JobApplied;
import com.neu.spring.POJO.JobPost;
import com.neu.spring.POJO.JobSeeker;
import com.neu.spring.POJO.Manager;
import com.neu.spring.POJO.Users;

@Controller
public class ManagerController 
{
	
	@Autowired
	private ManagerDAO managerDAO;
	
	@Autowired
	private JobPostDAO jobPostDAO;
	
	@Autowired
	private JobAppliedDAO jobAppliedDAO;
	

	
	@RequestMapping(value = "/HomePage", method = RequestMethod.POST)
	public String hrHome(Model model) 
	{
		return "ManagerWorkArea";
	}
		

	
	@RequestMapping(value="/CreateOpening", method = RequestMethod.POST)
	public String createNewJobPostion(Locale locale, Model model, HttpServletRequest request)
	{
		JobPost jobPost = new JobPost();
		model.addAttribute("job", jobPost);
		return "PostJob";
	}	

	

	
		@RequestMapping(value="/DeleteJobPosted", method = RequestMethod.POST)
		public String deletePostedJob(@ModelAttribute("job") JobPost jobPost, Model model, HttpServletRequest request,
				BindingResult result) 
		{		
			HttpSession session = request.getSession();

			Users users = (Users) session.getAttribute("manager");
			Manager manager = managerDAO.selectManager(users);
			

			List<JobPost> jobList = jobPostDAO.searchJobPosted();
			request.setAttribute("jobList", jobList);
			return "DeleteJob";
			
		}	

	
	@RequestMapping(value="/JobPosting", method = RequestMethod.POST)
	public String postJobsToPortal(@ModelAttribute("job") JobPost jobPost, Model model, HttpServletRequest request,
			BindingResult result) 
	{		
		
		HttpSession session = request.getSession();
		
		Users userAccount = (Users)session.getAttribute("manager");
		Manager manager = managerDAO.selectManager(userAccount);
			
		List<JobPost> jobpostList = new ArrayList<JobPost>();					
		jobpostList.add(jobPost);	
		manager.setJobpostList(jobpostList);
		jobPost.setManager(manager);
			
		try
		{
			jobPostDAO.create(jobPost);
			DAO.close();
		}
			
		catch (HibernateException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return "PostJob";
		}	
		
		model.addAttribute("job", jobPost);
			
		return "JobPostedSuccessfully";
	}
	

	// View JobPost Applicants
		@RequestMapping(value="/ViewApplicants", method=RequestMethod.POST)
		public String viewApplicants(HttpServletRequest request, Model model)
		{
			HttpSession session = request.getSession();
			
			List<JobSeeker> job_SeekerList = new ArrayList<JobSeeker>();
			
			
			Users users = (Users) session.getAttribute("manager");
			Manager manager = managerDAO.selectManager(users);
			
			List<JobApplied> applicants = jobAppliedDAO.jobApplicants();
			
			for(JobApplied jobapplied : applicants)
			{
				if(jobapplied.getJobpost().getManager().equals(manager))
				{
					System.out.print("jobapplied " + jobapplied.getJobpost());
					job_SeekerList.add(jobapplied.getJobseeker());
				}
			}
				
			model.addAttribute("job_SeekerList", job_SeekerList);
			return "JobApplications";
				
		}
		

		@RequestMapping(value="/delete", method=RequestMethod.POST)
		public String deleteJobs(@ModelAttribute("jobApplications") JobPost jobpost, Model model, 
												BindingResult result, HttpServletRequest request)
		{
			
			HttpSession session = request.getSession();
			
			Users users = (Users) session.getAttribute("jobseeker");
			
						
			int jobID = Integer.parseInt(request.getParameter("delete"));
			System.out.println("JobPost Applied is" +jobID);
			JobPostDAO jobPostDAO = new JobPostDAO();
		    jobpost = jobPostDAO.getJobs(jobID);
			
								
			try
			{
				ManagerDAO managerDAO = new ManagerDAO(); 
				managerDAO.delete(jobpost);
				DAO.close();
			}
				
			catch (HibernateException e)
			{
				System.out.println("Exception: " + e.getMessage());
				return "JobPostFailure";
			}	
			
			//model.addAttribute("jobApplications", jobApplied);
			
			return "JobDeletedSuccessfully";
		}
		
}