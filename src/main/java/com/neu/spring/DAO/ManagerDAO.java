package com.neu.spring.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.POJO.JobPost;
import com.neu.spring.POJO.Manager;
import com.neu.spring.POJO.Users;

public class ManagerDAO extends DAO
{

	public void create(Manager manager)
	{
        try 
        {
            begin();
            getSession().save(manager);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
	
	
	public Manager selectManager(Users users)
		{
			try 
			{
	            begin();
	            Query q = getSession().createQuery("from Manager where users = :temp ");
	            q.setParameter("temp", users);
	            Manager manager = (Manager) q.uniqueResult();
	            commit();
	            return manager;
	        } 
			
			catch (HibernateException e) 
			{
	            rollback();
	            e.printStackTrace();
	            return null;
	        }
		}
	
	  public void delete(JobPost jobpost)
	  {
	            
	        try {
	            begin();
	            int a = jobpost.getJobpostid();
	            System.out.println("AAAAAAAAAAA is"+ a);
	            
	                      
	            
	            Query qb = getSession().createQuery("delete JobApplied where jobpost_jobpostid =:a ");
	            qb.setInteger("a", jobpost.getJobpostid());
	            qb.executeUpdate();
	            
	            Query qa = getSession().createQuery("delete JobPost where jobpostid = :temp ");
	            qa.setInteger("temp", jobpost.getJobpostid());
	            int result = qa.executeUpdate();
	            
	            if (result > 0) {
	                System.out.println("Job Deleted");
	            }
	            commit();
	            //tx.commit();
	        } catch (HibernateException e) {
	        	System.out.println("Delete Rollbak"+e.getMessage());
	            rollback();
	            
	        }
	    }
}
