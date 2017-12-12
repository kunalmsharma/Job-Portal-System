package com.neu.spring.DAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.POJO.Users;

public class UsersDAO extends DAO
{

	public void create(Users users) 
	{
        try 
        {
            begin();
            getSession().save(users);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }

	public Users selectUser(Users users)
	{
		try 
		{
            begin();
            System.out.println("users.getEmailid() above" +users.getEmailid());
            Query q = getSession().createQuery("from Users where emailid = :temp");
            System.out.println("users.getEmailid() below" +users.getEmailid());
            q.setParameter("temp", users.getEmailid());
            Users ua = (Users) q.uniqueResult();
            commit();
            return ua;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}

	public Boolean uniqueUser(String emailID)
	{
		begin();
		Query q = getSession().createQuery("from Users where emailID = :temp");
		q.setParameter("temp", emailID);			
		Users users = (Users)q.uniqueResult();	
		commit();
		
		if(users==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}