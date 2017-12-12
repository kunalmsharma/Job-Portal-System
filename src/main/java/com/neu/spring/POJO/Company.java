package com.neu.spring.POJO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="companyid")
	private int companyid;
	
	@Column(name="companyName")
	private String companyName;
	
	
	public Company(){
		
	}
	
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}