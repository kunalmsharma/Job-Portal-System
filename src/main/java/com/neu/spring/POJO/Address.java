package com.neu.spring.POJO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="addressid")
	private int addressid;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "country")
	private String country;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="address", cascade=CascadeType.ALL)
	private Set<JobSeeker> jobseekerList = new HashSet<JobSeeker>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="address", cascade=CascadeType.ALL)
	private Set<Manager> managerList = new HashSet<Manager>();

	public Address(){
		
	}
	
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public Set<JobSeeker> getJobseekerList() {
		return jobseekerList;
	}

	public void setJobseekerList(Set<JobSeeker> jobseekerList) {
		this.jobseekerList = jobseekerList;
	}

	public Set<Manager> getManagerList() {
		return managerList;
	}
	public void setManagerList(Set<Manager> managerList) {
		this.managerList = managerList;
	}
	
}
