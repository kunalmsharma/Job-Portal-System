package com.neu.spring.DAO;
import org.hibernate.HibernateException;

import com.neu.spring.POJO.Address;

public class AddressDAO extends DAO
{

	public void create(Address address) 
	{
        try 
        {
            begin();
            getSession().save(address);
            commit();
        }
        catch(HibernateException e)
        {
        	rollback();
        	e.printStackTrace();
        }
        
    }
}
