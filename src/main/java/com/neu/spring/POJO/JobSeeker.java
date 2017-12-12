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
@Table(name = "JobSeeker")
public class JobSeeker 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="jobseekerid")
	private int jobseekerid;

	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "phoneno")
	private String phoneno;
		
	
	@Column(name = "qualification")
	private String qualification;
		
	@Column(name = "workexperience", nullable=false)
	private String workexperience;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="jobseeker", cascade=CascadeType.ALL)
	private List<JobApplied> jobApplicationList;
	
	public JobSeeker(){
		
	}

	public int getJobseekerid() {
		return jobseekerid;
	}

	public void setJobseekerid(int jobseekerid) {
		this.jobseekerid = jobseekerid;
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
		System.out.print("this.lastname"+lastname);
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getWorkexperience() {
		return workexperience;
	}

	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
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

	public List<JobApplied> getJobApplicationList() {
		return jobApplicationList;
	}

	public void setJobApplicationList(List<JobApplied> jobApplicationList) {
		this.jobApplicationList = jobApplicationList;
	}
	
	
}
