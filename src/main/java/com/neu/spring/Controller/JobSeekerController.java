package com.neu.spring.Controller;

import java.util.ArrayList;
import java.util.List;
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

import com.neu.spring.DAO.JobSeekerDAO;
import com.neu.spring.DAO.DAO;
import com.neu.spring.DAO.JobAppliedDAO;
import com.neu.spring.DAO.JobPostDAO;
import com.neu.spring.POJO.JobApplied;
import com.neu.spring.POJO.JobPost;
import com.neu.spring.POJO.JobSeeker;
import com.neu.spring.POJO.Users;

@Controller
public class JobSeekerController 
{
	@Autowired
	private JobSeekerDAO jobSeekerDAO;
	
	@Autowired
	private JobPostDAO jobPostDAO;
	
	@Autowired
	private JobAppliedDAO jobAppliedDAO;
	
	
		
		@RequestMapping(value = "/SeekerHomePage", method = RequestMethod.POST)
		public String jobSeekerHome(Model model, HttpServletRequest request) 
		{
			List<JobPost> jobList = jobPostDAO.searchJobPosted();
			request.setAttribute("jobList", jobList);
			return "JobSeekerWorkArea";
		}
		
		
		@RequestMapping(value="/apply", method=RequestMethod.POST)
		public String applyJobs(@ModelAttribute("jobApplications") JobApplied jobApplied, Model model, 
												BindingResult result, HttpServletRequest request)
		{
			
			HttpSession session = request.getSession();
			
			Users users = (Users) session.getAttribute("jobseeker");
			
			JobSeeker jobseeker = jobSeekerDAO.selectJobSeeker(users);
			
			int jobID = Integer.parseInt(request.getParameter("apply"));
			System.out.println("JobPost Applied is" +jobID);
			JobPostDAO jobPostDAO = new JobPostDAO();
			JobPost jobpost = jobPostDAO.getJobs(jobID);
			
			jobApplied.setJobpost(jobpost);
			jobApplied.setJobseeker(jobseeker);
			
			
			int a= jobseeker.getJobseekerid();
			System.out.println(" Before try catch A is" +a);
			int b = jobApplied.getJobpost().getJobpostid();
			
			System.out.println("Before try catch B is" +b);
			int c = jobApplied.getJobseeker().getJobseekerid();
			System.out.println(" Before try catch C is" +c);
			System.out.println(" Before try catch jobID is" +jobID);
			
			
//
//			if(!(jobAppliedDAO.uniqueJobApplied(jobID,jobseeker))) {			
//				System.out.println("Username already exists");
//				return "JobSeekerSignup";			
//			}	
			
		try{	
			
			if(!(jobAppliedDAO.uniqueJobApplied(jobID,a))) {			

				System.out.println("You have already Applied for this job!");
				return "MultipleJobApplication";			
			}
			else{
				JobAppliedDAO jobAppliedDAO = new JobAppliedDAO(); 
				jobAppliedDAO.create(jobApplied);
				DAO.close();
			}
			
//			if(a != jobApplied.getJobseeker().getJobseekerid()){
//				JobAppliedDAO jobAppliedDAO = new JobAppliedDAO(); 
//				jobAppliedDAO.uniqueJobApplied(jobID);
//				jobAppliedDAO.create(jobApplied);
//				DAO.close();
//			}
//			else if(b != jobID){
//				JobAppliedDAO jobAppliedDAO = new JobAppliedDAO(); 
//				jobAppliedDAO.create(jobApplied);
//				DAO.close();
//			}
//			else{
//				System.out.println("You have already Applied for this job!");
//				return "MultipleJobApplication";
//			}
		}
/*	try{
		for(JobApplied jh  : jobseeker.getJobApplicationList())
		{
			if(jh.getJobpost().getJobpostid() !=jobID)
			{
				JobAppliedDAO jobAppliedDAO = new JobAppliedDAO(); 
				jobAppliedDAO.create(jobApplied);
				DAO.close();	
			}
			else{
				System.out.println("You have already Applied for this job!");
				return "MultipleJobApplication";
			}
		}
	}  */
			
			//jobApplied.getJobpost().getJobpostid()
//			try
//			{
//				System.out.println(" Inside try first JobPost Applied is" +jobID);
//				System.out.println(" Inside try second JobPost Applied is" +jobApplied.getJobappliedid());
//				if(jobApplied.getJobappliedid() != jobID)
//				{
//				JobAppliedDAO jobAppliedDAO = new JobAppliedDAO(); 
//				jobAppliedDAO.create(jobApplied);
//				DAO.close();
//				}
//				else{
//					System.out.println("You have already Applied for this job!");
//					return "MultipleJobApplication";
//				}
//			}
			
				
			catch (HibernateException e)
			{
				System.out.println("Exception: " + e.getMessage());
				return "JobPostFailure";
			}	
			
			model.addAttribute("jobApplications", jobApplied);
			
			return "JobAppliedSuccessfully";
		}
		
		
			@RequestMapping(value="myJobs", method=RequestMethod.POST)
			public String myJobs(HttpServletRequest request, Model model)
			{
				HttpSession session = request.getSession();
				
				List<JobApplied> myJobAppliedList = new ArrayList<JobApplied>();
				
				Users users = (Users) session.getAttribute("jobseeker");
				JobSeeker jobseeker = jobSeekerDAO.selectJobSeeker(users);
				
				List<JobApplied> applicants = jobAppliedDAO.jobApplicants();
				
				
				for(JobApplied jobapplied : applicants)
				{
					if(jobapplied.getJobseeker() != null) {
						if(jobapplied.getJobseeker().equals(jobseeker))
						{
							
							myJobAppliedList.add(jobapplied);
						}
					}
				}
				
				model.addAttribute("myJobApplicationsList", myJobAppliedList);
				return "JobSeekerAppliedJobs";		
			}
			
			@RequestMapping(value="myUpdate", method=RequestMethod.POST)
			public String myUpdates(HttpServletRequest request, Model model)
			{

				HttpSession session = request.getSession();
				
			//	List<JobSeeker> job_SeekerList = new ArrayList<JobSeeker>();
				
				Users users = (Users) session.getAttribute("jobseeker");
				JobSeeker jobseeker = jobSeekerDAO.selectJobSeeker(users);
				
					
				model.addAttribute("jobseeker", jobseeker);
				return "UpdateProfile";		
			}
			
			@RequestMapping(value="SaveUpdate", method=RequestMethod.POST)
			public String saveUpdates(HttpServletRequest request, Model model)
			{

				HttpSession session = request.getSession();
				
							
				Users users = (Users) session.getAttribute("jobseeker");
				JobSeeker jobseeker = jobSeekerDAO.selectJobSeeker(users);
			String a = request.getParameter("firstname");
			System.out.print("a"+a);
			String b = request.getParameter("lastname");
			System.out.print("b"+b);
			String c = request.getParameter("phoneno");
			System.out.print("c"+c);
			String d = request.getParameter("qualification");
			System.out.print("d"+d);
			String f = request.getParameter("workexperience");
			System.out.print("f"+f);
		    String ex =f; 
				
				int userID=(Integer)session.getAttribute("userID");
				System.out.println("userID---"+userID);
				
				try
				{
					JobSeeker j = new JobSeeker();
					j.setFirstname(a);
					j.setLastname(b);
					j.setPhoneno(c);
					j.setQualification(d);
					j.setWorkexperience(ex);
					JobSeekerDAO jobseekerDAO = new JobSeekerDAO(); 
					//jobseekerDAO.getJobSeeker(userID);
					jobseekerDAO.update(userID,j);
					request.getSession().setAttribute("jobseeker", j);
					DAO.close();
				}
					
				catch (HibernateException e)
				{
					System.out.println("Exception: " + e.getMessage());
					return "UpdateProfile";
				}	
				
				//model.addAttribute("jobApplications", jobApplied);
				
				return "SaveUpdate";

			}
			
				
}