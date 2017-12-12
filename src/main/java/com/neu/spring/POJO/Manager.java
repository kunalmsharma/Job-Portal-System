package com.neu.spring.POJO;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="managerid")
	private int managerid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Company company;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager", cascade=CascadeType.ALL)
	private List<JobPost> jobpostList;

	public Manager(){
		
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<JobPost> getJobpostList() {
		return jobpostList;
	}

	public void setJobpostList(List<JobPost> jobpostList) {
		this.jobpostList = jobpostList;
	}
	
	
}
