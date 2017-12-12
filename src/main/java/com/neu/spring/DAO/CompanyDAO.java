package com.neu.spring.DAO;
import org.hibernate.HibernateException;

import com.neu.spring.POJO.Company;

public class CompanyDAO extends DAO
{

	public void create(Company company) 
	{
        try 
        {
            begin();
            getSession().save(company);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
}