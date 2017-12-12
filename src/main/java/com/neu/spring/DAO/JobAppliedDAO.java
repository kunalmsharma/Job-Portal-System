package com.neu.spring.DAO;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.POJO.JobApplied;
public class JobAppliedDAO extends DAO
{

		public void create(JobApplied jobApplied) 
		{
			try 
		    {
				begin();
		        getSession().save(jobApplied);
		        commit();
		    }
		    catch (HibernateException e) 
		    {
		    	rollback();
		        e.printStackTrace();
		    }
		}
		public Boolean uniqueJobApplied(int jobpost_jobpostid, int jobseekerid)
		{
			begin();
			
			
			
			Query q = getSession().createQuery("from JobApplied where jobpost_jobpostid = :temp and jobseeker_jobseekerid =:a");
			q.setParameter("temp", jobpost_jobpostid);
			q.setParameter("a", jobseekerid);		
			JobApplied jobapplied = (JobApplied)q.uniqueResult();	
			commit();
			
			if(jobapplied==null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

	public List<JobApplied> jobApplicants()
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobApplied");	            			
			List<JobApplied> applicantList = q.list();
			
	        commit();
	        return applicantList;	            
		}
		catch (HibernateException e) 
		{
		    rollback();
		    e.printStackTrace();
		    return null;
		}		
	}
}