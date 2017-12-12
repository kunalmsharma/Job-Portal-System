package com.neu.spring.DAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.spring.POJO.JobSeeker;
import com.neu.spring.POJO.Users;


public class JobSeekerDAO extends DAO
{
	public void create(JobSeeker jobSeeker) 
	{
        try
        {
            begin();
            getSession().save(jobSeeker);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
	
	public JobSeeker selectJobSeeker(Users users)	{
		try 
		{
            begin();
            Query q = getSession().createQuery("from JobSeeker where users = :temp ");
            q.setParameter("temp", users);
            JobSeeker jobseeker= (JobSeeker) q.uniqueResult();
            commit();
            return jobseeker;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}
	
	
	
	 public void update(int users_userid,JobSeeker jobseeker)
	  {
	            
		 
		 // from jobJobSeeker where user_user_id=:usedID;
		 
		 try {
	            begin();
	            
	            Query x = getSession().createQuery("from JobSeeker where users_userid = :temp ");
	            x.setParameter("temp", users_userid);
	            JobSeeker js= (JobSeeker) x.uniqueResult();
	            
	            js.setFirstname(jobseeker.getFirstname());
	            js.setLastname(jobseeker.getLastname());
	            js.setPhoneno(jobseeker.getPhoneno());
	            js.setQualification(jobseeker.getQualification());
	            js.setWorkexperience(jobseeker.getWorkexperience());
	            getSession().update(js);
	            
	            //HttpSession session = request.getSession();
	            //Users users = (Users) session.getAttribute("jobseeker");
	     /*       int id = jobseeker.getJobseekerid();
	            System.out.println("id is "+ id);
	            Query qa = getSession().createQuery("update JobSeeker set  firstname = :firstname ,lastname = :lastname , phoneno =:phoneno , qualification =:qualification, workexperience=:workexperience where jobseekerid=:id");

	            qa.setString("firstname", jobseeker.getFirstname());
	            qa.setString("lastname", jobseeker.getLastname());
	            qa.setString("phoneno", jobseeker.getPhoneno());
	            qa.setString("qualification", jobseeker.getQualification());
	            qa.setInteger("workexperience", jobseeker.getWorkexperience());
	            qa.setInteger("id", id);
	           // qa.executeUpdate();
	            
	            
	            int result = qa.executeUpdate();       
	            
	            if (result > 0) {
	                System.out.println("My Profile Updated");
	            }*/
	            commit();
	            //tx.commit();
	        } catch (HibernateException e) {
	        	System.out.println("Update Rollbak"+e.getMessage());
	            rollback();
	            
	        }
	    }
	 
	  
	 
}
