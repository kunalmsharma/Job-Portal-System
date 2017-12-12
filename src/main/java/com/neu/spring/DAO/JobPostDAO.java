package com.neu.spring.DAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.POJO.JobPost;


public class JobPostDAO extends DAO
{

	public void create(JobPost jobPost)  {
		try 
	    {
			begin();
	        getSession().save(jobPost);
	        commit();
	    }
	    catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	    }
	}
	
	public List<JobPost> searchJobPosted()	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobPost");
			List<JobPost> jobList = q.list();
            commit();
            return jobList;
		}
		
		catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public JobPost getJobs (int jobpostid)	{
		
		try 
		{
            begin();
            Query q = getSession().createQuery("from JobPost where jobpostid = :temp");
            q.setParameter("temp", jobpostid);
            JobPost jobPost = (JobPost) q.uniqueResult();
            commit();
            return jobPost;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}
}